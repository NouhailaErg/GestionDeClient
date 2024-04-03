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

import com.projet.appliance.dto.ContactDto;
import com.projet.appliance.model.Client;
import com.projet.appliance.services.ContactService;

@RestController
@RequestMapping("/contact")
@CrossOrigin("*")
public class ContactController {

	@Autowired
	private  ContactService contactService;

	
		@GetMapping("/all")
		public List<ContactDto> getAllContact(){
			List<ContactDto> contact= contactService.findAllContact();
			return contact;
		}
		@GetMapping("/find/{id}")
		public ContactDto getContactById(@PathVariable("id") Long id){
			ContactDto contactt = contactService.findContactById(id);
			return contactt;
		}
		@GetMapping("/nom/{nom}")
		public List<ContactDto> findByNom(@PathVariable("nom") String nom) {
			List<ContactDto> nomm = contactService.findByNom(nom);
			return nomm;
		}
       @PostMapping("/client")
       public List<ContactDto> findByClient(@RequestBody Client client){
	   List<ContactDto> c = contactService.findByClient(client);
	   return c;
}
		
		
		@PostMapping("/add")
		public ContactDto addContact(@RequestBody ContactDto c){
			ContactDto newcontact = contactService.addContact(c);
			return newcontact;
		}
		@PostMapping("/addList")
		public List<ContactDto> addListContact(@RequestBody List<ContactDto> c){
			List<ContactDto> newcon = contactService.addListContact(c);
			return newcon;
			}
		
		@PutMapping("/update")
		public ContactDto updateContact(@RequestBody ContactDto c){
			ContactDto updacontact = contactService.updateContact(c);
			return updacontact;
		}
		@DeleteMapping("/delete/{id}")
		public ContactDto deleteContact(@PathVariable ("id")Long id ){
			contactService.deleteContactDtoById(id);
			return null;
		}
}
