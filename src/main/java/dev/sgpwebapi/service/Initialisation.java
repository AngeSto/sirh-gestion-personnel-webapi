package dev.sgpwebapi.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sgpwebapi.entity.Banque;
import dev.sgpwebapi.entity.Collaborateur;
import dev.sgpwebapi.entity.Departement;
import dev.sgpwebapi.repository.BanqueRepository;
import dev.sgpwebapi.repository.CollaborateurRepository;
import dev.sgpwebapi.repository.DepartementRepository;

@Service
public class Initialisation {
	
	@Autowired DepartementRepository departService;
	@Autowired CollaborateurRepository collaboService;
	@Autowired BanqueRepository banqueService;
	
	public void initDepartement(){
		Stream.of(new Departement("Ile de France"),
				new Departement("Loire Atlantique"),
				new Departement("Bretagne")).
		forEach(departService::save);	
	}
	
	public void initCollaborateur(){
		Stream.of(new Collaborateur(departService.findOne(1), "M01", "Ange", "Sto", banqueService.findOne(1)),
				new Collaborateur(departService.findOne(2),"M02","Pierre", "Aurelle", banqueService.findOne(2)))
		.forEach(collaboService::save);
	}

	public void initBanque(){
		Stream.of(new Banque("Société Générale", "111111","222222"),
				new Banque("Banque Populaire", "333333", "44444"))
		.forEach(banqueService::save);
	}
}
