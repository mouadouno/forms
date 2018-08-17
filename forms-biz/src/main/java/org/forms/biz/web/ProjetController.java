package org.forms.biz.web;

import java.util.List;

import org.forms.biz.entities.Projet;
import org.forms.biz.services.IProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@CrossOrigin
@RestController
@RequestMapping("/Projet")
public class ProjetController {
	@Autowired
	IProjetService iProjetService;

	// ------------------displayAllProjet-------------------------------------------
	@RequestMapping(value = "/getAllProjet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Projet> displayAllProjet() {

		return iProjetService.findAllProjet();
		
	}
	
	// ------------------addProjet-------------------------------------------
	@RequestMapping(value = "/addProjet", method = RequestMethod.POST)
	@ResponseBody
	public void addProjet(@RequestBody Projet projet) {

		if (projet == null) {
			System.out.println("NULL");
		} else {
			System.out.println("Complexité ajoutée");

			iProjetService.saveProjet(projet);
		}

	}
	
	// ------------------getProjetByID-------------------------------------------
	@RequestMapping(value = "/getProjet/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Projet getProjet(@PathVariable int id) {

		Projet c = iProjetService.findProjetById(id);
		
		return c;

	}
	
	// ------------------getProjetByID-------------------------------------------
		@RequestMapping(value = "/getProjetbyPerso/{id}", method = RequestMethod.GET)
		@ResponseBody
		public Projet getProjetbyPersonnel(@PathVariable int id) {

			Projet p = iProjetService.findProjetByPersonnel(id);
			
			return p;

		}
	
	// ------------------updateProjet-------------------------------------------
	@RequestMapping(value = "/updateProjet", method = RequestMethod.PUT)
	@ResponseBody
	public void updateProjet(@RequestBody Projet c) {

		iProjetService.updateProjet(c);
		
	}
	
	// ------------------deleteProjet-------------------------------------------
	@RequestMapping(value = "/deleteProjet/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteProjet(@PathVariable int id) {
		
		iProjetService.deleteProjet(id);
		
	}
}
