package com.projet.appliance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projet.appliance.dto.ContactDto;
import com.projet.appliance.mappers.ContactDozerMapper;
import com.projet.appliance.model.Client;
import com.projet.appliance.repositories.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	ContactDozerMapper contactDozerMapper;
	@Autowired
	ContactRepository contactRepository;
	@Override
	public ContactDto saveContact(ContactDto p) {
		ContactDto dto=	contactDozerMapper.ContactToContactDto(contactRepository.save(
				contactDozerMapper.ContactDtoToContact(p)));
		return dto;
	}

	@Override
	public ContactDto updateContact(ContactDto p) {
		ContactDto dto=	contactDozerMapper.ContactToContactDto(contactRepository.save(
				contactDozerMapper.ContactDtoToContact(p)));
		return dto;
	}

	@Override
	public void deleteContactDtoById(Long id) {
		contactRepository.deleteById(id);		
	}

	@Override
	public ContactDto getContact(Long id) {
		return 	contactDozerMapper.ContactToContactDto(contactRepository.findById(id).get());

	}

	@Override
	public List<ContactDto> getAllContact() {
		return 	contactDozerMapper.ContactToContactDto(contactRepository.findAll());

	}

	@Override
	public List<ContactDto> findAllContact() {
		return 	contactDozerMapper.ContactToContactDto(contactRepository.findAll());

	}

	@Override
	public ContactDto findContactById(Long id) {
		return contactDozerMapper.ContactToContactDto(contactRepository.findById(id).get());

	}

	@Override
	public ContactDto addContact(ContactDto p) {
		ContactDto dto=	contactDozerMapper.ContactToContactDto(contactRepository.save(
				contactDozerMapper.ContactDtoToContact(p)));
		return dto;
	}


	@Override
	public List<ContactDto> findByNom(String nom) {
		return contactDozerMapper.ContactToContactDto(contactRepository.findByNom(nom));
	}

	@Override
	public List<ContactDto> findByClient(Client client) {
		
				return contactDozerMapper.ContactToContactDto(contactRepository.findByClient(client));
	}

	@Override
	public List<ContactDto> addListContact(List<ContactDto> c) {
		return contactDozerMapper.ContactToContactDto(contactRepository.saveAll(contactDozerMapper.ContactDtoToContact(c)));
	}

}
