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

import com.projet.appliance.dto.TypePrestationDto;
import com.projet.appliance.services.TypePrestationService;

@RestController
@RequestMapping("/typePrestation")
@CrossOrigin("http://localhost:4200/")
public class TypePrestationController {

	@Autowired
	private  TypePrestationService typePrestationService;


		@GetMapping("/all")
		public List<TypePrestationDto> getAllTypePrestation(){
			List<TypePrestationDto> tp= typePrestationService.findAllTypePrestation();
			return tp;
		}
		@GetMapping("/find/{id}")
		public TypePrestationDto getTypePrestationById(@PathVariable("id") Long id){
			TypePrestationDto c = typePrestationService.findTypePrestation(id);
			return c;
		}
		@GetMapping("/libelle/{libelle}")
		public List<TypePrestationDto> findByLibelle(@PathVariable("libelle") String libelle){
			List<TypePrestationDto> c = typePrestationService.findByLibelle(libelle);
		return c;
		}
		@PostMapping("/add")
		public TypePrestationDto addTypePrestation(@RequestBody TypePrestationDto c){
			TypePrestationDto newtp = typePrestationService.addTypePrestation(c);
			return newtp;
		}
		@PostMapping("/addList")
		public List<TypePrestationDto> addListTypePrestationDto(@RequestBody List<TypePrestationDto> typePrestation){
			List<TypePrestationDto> newtp = typePrestationService.addListTypePrestationDto(typePrestation);
			return newtp;
		}
		@PutMapping("/update")
		public TypePrestationDto updateTypePrestation(@RequestBody TypePrestationDto cc){
			TypePrestationDto updtp = typePrestationService.updateTypePrestation(cc);
			return updtp;
		}
		@DeleteMapping("/delete/{id}")
		public TypePrestationDto deleteTypePrestation(@PathVariable ("id")Long id ){
			typePrestationService.deleteTypePrestationDtoById(id);
			return null;
		}
}
