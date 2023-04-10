package tn.enig.dao;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import tn.enig.model.Collaborateur;
import tn.enig.model.Project;

import java.util.HashMap;
import java.util.Map;

@Repository
public class GitlabDao {

    @Autowired
    CollaborateurDao collaborateurDao;

    @Autowired
    ProjetDao projectDao;

    // @Value("${gitlab.base-url}")
    private String gitLabApiUrl = "https://gitlab.com/api/v4";

    // @Value("${gitlab.token}")
    private String gitLabApiToken = "glpat-fuam5v7VhRvfLrkT6sos";

    private final RestTemplate restTemplate;

    public GitlabDao(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Vérifier si l'utilisateur existe
    public boolean checkUserExists(String username) {
        String url = gitLabApiUrl + "/users?username=" + username;
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(gitLabApiToken);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            String body = response.getBody();
            JSONArray jsonArray = new JSONArray(body);
            return jsonArray.length() > 0;
        }
        return false;
    }

    // Vérifier si le projet existe
    public boolean checkProjectExists(String projectId) {
        String url = gitLabApiUrl + "/projects/" + projectId;
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(gitLabApiToken);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getStatusCode() == HttpStatus.OK;
    }

    // Vérifier si l'utilisateur existe dans le projet
    public boolean checkUserInProject(String projectId, String username) {
        String url = gitLabApiUrl + "/projects/" + projectId + "/members?username=" + username;
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(gitLabApiToken);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            String body = response.getBody();
            JSONArray jsonArray = new JSONArray(body);
            return jsonArray.length() > 0;
        }
        return false;
    }

    public String createUser(Long id) {

        Collaborateur user = collaborateurDao.findById(id).get();
        String url = gitLabApiUrl + "/users";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(gitLabApiToken);

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", user.getUsername());
        requestBody.put("email", user.getEmail());
        requestBody.put("password", user.getPassword());

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return "Utilisateur " + user.getUsername() + " créé avec succès";
        } else {
            return "Erreur lors de la création de l'utilisateur " + user.getUsername() + ": " + response.getBody();
        }
    }

    public String createProject(Long id) {
        Project project = projectDao.findById(id).get();
        String url = gitLabApiUrl + "/projects";

        HttpHeaders headers = new HttpHeaders();
        System.out.println(url);
        headers.setBearerAuth(gitLabApiToken);

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", project.getName());
        requestBody.put("description", project.getDescription());
        requestBody.put("path", project.getPath());
        requestBody.put("namespace_id", project.getNamespace_id());
        requestBody.put("initialize_with_readme", project.getInitialize_with_readme());
        // System.out.println(requestBody.get("name"));
        // System.out.println(requestBody.get("description"));
        // System.out.println(requestBody.get("path"));
        // System.out.println(requestBody.get("namespace_id"));
        // System.out.println(requestBody.get("initialize_with_readme"));

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return "Projet " + project.getName() + " créé avec succès";
        } else {
            return "Erreur lors de la création du projet " + project.getName() + ": " + response.getBody();
        }
    }

    public String assignUserToProject(String username, String projectName, String accessLevel) {
        String url = gitLabApiUrl + "/projects/" + username + "%2F" + projectName + "/members";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(gitLabApiToken);

        // Vérifier si l'utilisateur existe
        // if (!checkUserExists(username)) {
        // System.out.println("L'utilisateur " + username + " n'existe pas");
        // return;
        // }

        // Vérifier si le projet existe
        // if (!checkProjectExists(projectName)) {
        // System.out.println("Le projet " + projectName + " n'existe pas");
        // return;
        // }

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("user_id", username);
        requestBody.put("access_level", accessLevel);

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return "true";
        } else {
            return "false";
        }
    }
}
