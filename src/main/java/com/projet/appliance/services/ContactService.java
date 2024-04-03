package com.projet.appliance.services;

import java.util.List;

import com.projet.appliance.dto.ContactDto;
import com.projet.appliance.model.Client;

public interface ContactService {

	ContactDto saveContact(ContactDto p);
	ContactDto updateContact(ContactDto p);
	void deleteContactDtoById(Long id);
	ContactDto getContact(Long id);
	List<ContactDto> getAllContact();
	List<ContactDto> findByNom(String nom);
	List<ContactDto> findByClient(Client client);
	List<ContactDto> findAllContact();
	ContactDto findContactById(Long id);
	ContactDto addContact(ContactDto p);
	List<ContactDto> addListContact(List<ContactDto> c);

}
