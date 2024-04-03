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

import com.projet.appliance.services.TypeService;
import com.projet.appliance.dto.TypeDto;

@RestController
@RequestMapping("/type")
@CrossOrigin("*")
public class TypeController {

	@Autowired
	private  TypeService typeService;


	
	@GetMapping("/all")
	public List<TypeDto> getAllType(){
		List<TypeDto> type= typeService.findAllType();
		return type;
	}
	@GetMapping("/find/{id}")
	public TypeDto getTypeById(@PathVariable("id") Long id){
		TypeDto type = typeService.findTypeById(id);
		return type;
	}
	@GetMapping("/libelle/{libelle}")
	public List<TypeDto> findByLibelle(@PathVariable("libelle") String libelle){
		List<TypeDto> c = typeService.findByLibelle(libelle);
	return c;
	}
	@PostMapping("/add")
	public TypeDto addType(@RequestBody TypeDto t){
		TypeDto newtype = typeService.addType(t);
		return newtype;
	}
	
	@PostMapping("/addList")
	public List<TypeDto> addListType(@RequestBody List<TypeDto> type){
		List<TypeDto> newtype = typeService.addListType(type);
		return newtype;
	}
	
	@PutMapping("/update")
	public TypeDto updateType(@RequestBody TypeDto t){
		TypeDto updtype = typeService.updateType(t);
		return updtype;
	}
	@DeleteMapping("/delete/{id}")
	public TypeDto deleteType(@PathVariable ("id")Long id ){
		typeService.deleteTypeById(id);
		return null;
	}
}
