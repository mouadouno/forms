package org.forms.biz.web;

import java.util.List;

import org.forms.biz.entities.Personnel;
import org.forms.biz.services.IPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/Personnel")
public class PersonnelController {
	@Autowired
	IPersonnelService iPersonnelService;

	// ------------------displayAllPersonnel-------------------------------------------
	@RequestMapping(value = "/getAllPersonnel", method = RequestMethod.GET)
	public List<Personnel> displayAllPersonnel() {

		return iPersonnelService.findAllPersonnel();
		
	}
	
	// ------------------addPersonnel-------------------------------------------
	@RequestMapping(value = "/addPersonnel", method = RequestMethod.POST)
	@ResponseBody
	public void addPersonnel(@RequestBody Personnel personnel) {

		if (personnel == null) {
			System.out.println("NULL");
		} else {
			System.out.println("Complexité ajoutée");

			iPersonnelService.savePersonnel(personnel);
		}

	}
	
	// ------------------getPersonnelByID-------------------------------------------
	@RequestMapping(value = "/getPersonnel/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Personnel getPersonnel(@PathVariable int id) {

		Personnel c = iPersonnelService.findPersonnelById(id);
		
		return c;

	}

	
	// ------------------updatePersonnel-------------------------------------------
	@RequestMapping(value = "/updatePersonnel", method = RequestMethod.PUT)
	@ResponseBody
	public void updatePersonnel(@RequestBody Personnel c) {

		iPersonnelService.updatePersonnel(c);
		
	}
	
	// ------------------deletePersonnel-------------------------------------------
	@RequestMapping(value = "/deletePersonnel/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePersonnel(@PathVariable int id) {
		
		iPersonnelService.deletePersonnel(id);
		
	}
}
