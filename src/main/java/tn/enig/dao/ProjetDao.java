package tn.enig.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enig.model.Project;

@Repository
public interface ProjetDao extends JpaRepository<Project, Long> {
}
