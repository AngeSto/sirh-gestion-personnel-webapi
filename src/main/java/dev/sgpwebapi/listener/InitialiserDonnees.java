package dev.sgpwebapi.listener;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.sgpwebapi.service.Initialisation;

@Component
public class InitialiserDonnees{

	@Autowired Initialisation initialisation;
	
	@EventListener ({ContextRefreshedEvent.class})
	void contextRefreshedEvent() {
	initialisation.initDepartement();
	initialisation.initBanque();
	initialisation.initCollaborateur();
	}

}
