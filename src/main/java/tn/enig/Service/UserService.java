package tn.enig.Service;

import org.springframework.stereotype.Service;

import tn.enig.dao.GitlabDao;
import tn.enig.model.Collaborateur;

@Service
public class UserService {

    private final GitlabDao GitLabDao;

    public UserService(GitlabDao gitLabDao) {
        this.GitLabDao = gitLabDao;
    }

    // public void createUser(String username, String email, String password) {
    // gitLabDao.createUser(username, email, password);
    // }

    public String createUser(Long id) {
        return GitLabDao.createUser(id);
    }

}
