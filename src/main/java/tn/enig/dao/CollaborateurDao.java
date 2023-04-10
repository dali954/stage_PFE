package tn.enig.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enig.model.Collaborateur;

@Repository
public interface CollaborateurDao extends JpaRepository<Collaborateur, Long> {
}
