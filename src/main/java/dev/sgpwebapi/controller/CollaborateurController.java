package dev.sgpwebapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.sgpwebapi.entity.Banque;
import dev.sgpwebapi.entity.Collaborateur;
import dev.sgpwebapi.repository.BanqueRepository;
import dev.sgpwebapi.repository.CollaborateurRepository;
import dev.sgpwebapi.repository.DepartementRepository;

@RestController
@RequestMapping("/collaborateurs")
public class CollaborateurController {
	
	@Autowired private CollaborateurRepository collaboService;
	@Autowired private DepartementRepository departService;
	@Autowired private BanqueRepository banqueService;
	
	@GetMapping
	public List<Collaborateur> listeCollaborateur(@RequestParam("departement") Optional<Integer> id_departement){
		
		if(id_departement.isPresent()){
			
			return collaboService.findByDepartement(departService.findOne(id_departement.get()));
		}
		return collaboService.findAll();
	}
	
	@GetMapping("/{matricule}")
	public Collaborateur collaborateurParMatricule(@PathVariable String matricule){
		
		return collaboService.findByMatricule(matricule);
	}
	
	@PutMapping("/{matricule}")
	public String putCollaborateur(@PathVariable String matricule){
		
		Collaborateur collabo = collaboService.findByMatricule(matricule);
		collabo.setMatricule(matricule);
		collabo.setNom("Feuille");
		collabo.setPrenom("Paloma");
		collabo.setDepartement(departService.findOne(3));
		collabo.setBanque(banqueService.findOne(2));
		collaboService.save(collabo);
		
		return "Put collaborateur successfully!";
	}
	
	@GetMapping("{matricule}/banque")
	public Banque getCollaborateurBanque(@PathVariable String matricule){
		
		return collaboService.findByMatricule(matricule).getBanque();
	}
	
	@PutMapping("{matricule}/banque")
	public String putBanque(@PathVariable String matricule){
		Collaborateur collabo = collaboService.findByMatricule(matricule);
		Banque banque = banqueService.findOne(collabo.getBanque().getId());
		banque.setNom("Crédit Lyonnais");
		banque.setIban("888888");
		banque.setBic("999999");
		banqueService.save(banque);
		return "Put banque successfully";
	}
}
