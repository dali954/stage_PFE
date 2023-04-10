package tn.enig.Service;

import org.springframework.stereotype.Service;

import tn.enig.dao.GitlabDao;
import tn.enig.model.Member;
import tn.enig.model.Project;

@Service
public class ProjectService {

    private final GitlabDao gitLabDao;

    public ProjectService(GitlabDao gitLabDao) {
        this.gitLabDao = gitLabDao;
    }

    public String createProject(Long id) {
        return gitLabDao.createProject(id);
    }

    public String assignUserToProject(String username, String projectName, String accessLevel) {
        return gitLabDao.assignUserToProject(username, projectName, accessLevel);
    }

}
