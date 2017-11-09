package dev.sgpwebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgpwebapi.entity.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {

}
