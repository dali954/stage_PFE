package tn.enig.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.enig.Service.ProjectService;
import tn.enig.Service.UserService;

@RestController
@RequestMapping("/api")
public class Controller {

    // @Autowired
    // private UserService userService;
    @Autowired
    private ProjectService projectService;

    public Controller(ProjectService projectService) {
        // this.userService = userService;
        this.projectService = projectService;
    }

    // @PostMapping("/users")
    // public ResponseEntity<Void> createUser(@RequestParam String username,
    // @RequestParam String email,
    // @RequestParam String password) {
    // userService.createUser(username, email, password);
    // return new ResponseEntity<>(HttpStatus.CREATED);
    // }

    // @PostMapping("/users")
    // public Collaborateur createUser(@RequestBody Collaborateur collaborateur) {
    // return userService.createUser(collaborateur);
    // }

    @PostMapping
    public ResponseEntity<String> createProject(@RequestBody Long id) {
        String resultat = projectService.createProject(id);
        return new ResponseEntity<>(resultat, HttpStatus.CREATED);
    }

    // @PostMapping
    // public ResponseEntity<String> addMemberToProject(@PathVariable String
    // username, @PathVariable String projectName,
    // String accessLevel) {
    // String resultat = projectService.assignUserToProject(username, projectName,
    // accessLevel);
    // return new ResponseEntity<>(resultat, HttpStatus.CREATED);
    // }

}
