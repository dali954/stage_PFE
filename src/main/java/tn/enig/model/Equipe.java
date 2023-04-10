package tn.enig.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import jakarta.persistence.*;;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "equipe")
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_equipe;

    @ManyToOne
    @JoinColumn(name = "id_collab", referencedColumnName = "id_collab")
    private Collaborateur collaborateur;

    private String nom_equipe;
    private Boolean disponibilite;

}
