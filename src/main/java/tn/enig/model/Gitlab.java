package tn.enig.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "gitlab")
public class Gitlab implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_gitlab_project;

    @ManyToOne
    @JoinColumn(name = "id_project", referencedColumnName = "id_project")
    private Project project;

    private String nom_gitlab_project;
    private String url_gitlab_project;

}
