package tn.enig.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enig.model.ProfilCollab;

@Repository
public interface ProfilCollabDao extends JpaRepository<ProfilCollab, Long> {
}
