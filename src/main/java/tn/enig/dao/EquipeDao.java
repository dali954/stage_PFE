package tn.enig.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enig.model.Equipe;

@Repository
public interface EquipeDao extends JpaRepository<Equipe, Long> {
}
