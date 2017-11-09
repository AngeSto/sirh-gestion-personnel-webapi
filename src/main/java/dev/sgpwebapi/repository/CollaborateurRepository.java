package dev.sgpwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgpwebapi.entity.Collaborateur;
import dev.sgpwebapi.entity.Departement;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer>{

	public List<Collaborateur> findByDepartement(Departement idDepartement);
	
	public Collaborateur findByMatricule(String matricule);
}
