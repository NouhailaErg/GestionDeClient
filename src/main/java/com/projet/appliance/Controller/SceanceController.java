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

import com.projet.appliance.dto.SceanceDto;
import com.projet.appliance.model.Pov;
import com.projet.appliance.services.SceanceService;

@RestController
@RequestMapping("/sceance")
@CrossOrigin("http://localhost:4200/")
public class SceanceController {

	@Autowired
	private  SceanceService sceanceService;

	
		@GetMapping("/all")
		public List<SceanceDto> getAllSceance(){
			List<SceanceDto> sceancee= sceanceService.findAllSceance();
			return sceancee;
		}
		@GetMapping("/find/{id}")
		public SceanceDto getSceanceById(@PathVariable("id") Long id){
			SceanceDto c = sceanceService.findSceance(id);
			return c;
		}
		@PostMapping("/pov")
		public List<SceanceDto> findByPov(@RequestBody Pov pov) {
			List<SceanceDto> c = sceanceService.findByPov(pov);
			return c;
		}
		
		@PostMapping("/add")
		public SceanceDto addSceance(@RequestBody SceanceDto c){
			SceanceDto newsceance = sceanceService.addSceance(c);
			return newsceance;
		}
		@PostMapping("/addList")
		public List<SceanceDto> addListSceance(@RequestBody List<SceanceDto> c) {
			List<SceanceDto> newscea = sceanceService.addListSceance(c);
			return newscea;
		}
		
		@PutMapping("/update")
		public SceanceDto updateSceance(@RequestBody SceanceDto cc){
			SceanceDto updasceance = sceanceService.updateSceance(cc);
			return updasceance;
		}
		@DeleteMapping("/delete/{id}")
		public SceanceDto deleteSceance(@PathVariable ("id")Long id ){
			sceanceService.deleteSceanceDtoById(id);
			return null;
		}
}
