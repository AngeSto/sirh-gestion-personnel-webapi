package dev.sgpwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sgpwebapi.entity.Departement;
import dev.sgpwebapi.repository.DepartementRepository;

@RestController
@RequestMapping("/departements")
@CrossOrigin(origins = "http://localhost:9000")
public class DepartementControlleur {
	
	  @Autowired private DepartementRepository departService;
	
	  @GetMapping
	  public List<Departement> listeDepartement(){
		  
		  return departService.findAll();
	  }

	  
}
