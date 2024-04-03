package com.projet.appliance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projet.appliance.dto.SuiviDto;
import com.projet.appliance.model.Pov;
import com.projet.appliance.model.TypePrestation;
import com.projet.appliance.services.SuiviService;

@RestController
@RequestMapping("/suivi")
@CrossOrigin("http://localhost:4200/")
public class SuiviController {
	
	@Autowired
	private  SuiviService suiviService;

	
		@GetMapping("/all")
		public List<SuiviDto> getAllSuivi(){
			List<SuiviDto> sv= suiviService.findAllSuivi();
			return sv;
		}
		@GetMapping("/find/{id}")
		public SuiviDto getSuiviById(@PathVariable("id") Long id){
			SuiviDto c = suiviService.findSuivi(id);
			return c;
		}
		@PostMapping("/pov")
		public List<SuiviDto> findByPov(@RequestBody Pov pov) {
			List<SuiviDto> c = suiviService.findByPov(pov);
			return c;
		}
		@GetMapping("/typepre/{typePrestation}")
		public List<SuiviDto> findByTypePrestation(@PathVariable("typePrestation") TypePrestation typePrestation) {
			List<SuiviDto> c = suiviService.findByTypePrestation(typePrestation);
			return c;
		}
		@PostMapping("/add")
		public SuiviDto addSuivi(@RequestBody SuiviDto c){
			SuiviDto newsuivi = suiviService.addSuivi(c);
			return newsuivi;
		}
		@PostMapping("/addList")
		public List<SuiviDto> addListSuivi(@RequestBody List<SuiviDto> s){
			List<SuiviDto> newsuiv = suiviService.addListSuivi(s);
			return newsuiv;
		}
		
		@PutMapping("/update")
		public SuiviDto updateSuivi(@RequestBody SuiviDto cc){
			SuiviDto updasuivi = suiviService.updateSuivi(cc);
			return updasuivi;
		}
		@DeleteMapping("/delete/{id}")
		public SuiviDto deleteSuivi(@PathVariable ("id")Long id ){
			suiviService.deleteSuiviDtoById(id);
			return null;
		}

}
