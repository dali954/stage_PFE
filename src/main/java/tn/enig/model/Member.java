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
@Table(name = "Member")
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_collab")
    private Collaborateur collaborateur;

    @Enumerated(EnumType.STRING)
    private AccessLevel accessLevel;

    public Member(Collaborateur collaborateur2, AccessLevel accessLevel2) {
    }
}
