package com.Duane.driversLicense.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Duane.driversLicense.models.License;
import com.Duane.driversLicense.models.Person;
import com.Duane.driversLicense.services.PersonService;

@Controller
public class HomeController {

	private PersonService personServ;
	
	public HomeController (PersonService personServ) {
		this.personServ = personServ;
	}
	
	@GetMapping("/persons/new")
	public String NewPerson(Model model) {
		model.addAttribute("aPerson", new Person());
		model.addAttribute("allLicenses", personServ.getAllLicenses());
		return "NewPerson.jsp";
	}
	@GetMapping("/licenses/new")
	public String NewLicense(Model model) {
		model.addAttribute("aLicense", new License());
		model.addAttribute("allPeople", personServ.getAllPeople());
		return "NewLicense.jsp";
	}
	
	@PostMapping("/person/create")
	public String createPerson(@Valid @ModelAttribute("aPerson") Person aPerson, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			// still display notes if validation error
			System.out.println(result.getAllErrors());
		}else {
			personServ.create(aPerson);
		// otherwise create a note and redirect back
		}
		return "redirect:/licenses/new";
	}
	
	@PostMapping("/license/create")
	public String createLicense(@Valid @ModelAttribute("aLicense") License aLicense, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			// still display notes if validation error
			System.out.println(result.getAllErrors());
		}else {
			personServ.create(aLicense);
		// otherwise create a note and redirect back
		}
		return "redirect:/persons/new";
	}
	
	@GetMapping(value = "/person/{id}/view")
	public String findOne(@PathVariable("id") Long id, Model model) {
    	Person personToShow = this.personServ.findPerson(id);
    	model.addAttribute("personToShow", personToShow);
    	return "View.jsp";
	}
	

	
	
	
}
