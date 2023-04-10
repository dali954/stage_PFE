package tn.enig.model;

import java.io.Serializable;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Collaborateur")
public class Collaborateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_collab;

    @ManyToOne
    @JoinColumn(name = "id_profil_collab", referencedColumnName = "id_profil_collab")
    private ProfilCollab profilCollab;

    @ManyToOne
    @JoinColumn(name = "id_equipe", referencedColumnName = "id_equipe")
    private Equipe equipe;

    private String email;
    private String username;
    private String password;

}
