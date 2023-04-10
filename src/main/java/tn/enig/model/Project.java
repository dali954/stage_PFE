package tn.enig.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_project;

    @ManyToOne
    @JoinColumn(name = "id_equipe", referencedColumnName = "id_equipe")
    private Equipe equipe;

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("path")
    private String path;
    @JsonProperty("namespace_id")
    private String namespace_id;
    @JsonProperty("initialize_with_readme")
    public String initialize_with_readme;

    private Date date_debut_project;
    private Date date_fin_project;

}
