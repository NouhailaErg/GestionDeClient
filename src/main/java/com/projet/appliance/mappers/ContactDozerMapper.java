package com.projet.appliance.mappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.projet.appliance.dto.ClientDto;
import com.projet.appliance.dto.ContactDto;
import com.projet.appliance.model.Contact;
import com.projet.appliance.model.Client;

@Component
public class ContactDozerMapper {

	@Autowired
	private DozerBeanMapper mapper;
	
	public ContactDto ContactToContactDto(Contact contact) {

		if (contact == null) {
			return null;
		}

		ContactDto contactDto = mapper.map(contact, ContactDto.class);

		
		
		Client c = contact.getClient();
		if(c != null) {
			contactDto.setClient((mapper.map(c, ClientDto.class)));
		}
        

		return contactDto;
	}
	public List<ContactDto> ContactToContactDto(List<Contact> contacts) {

		if (CollectionUtils.isEmpty(contacts)) {
			return Collections.emptyList();
		}

		List<ContactDto> contactDto = new ArrayList<ContactDto>();

		for (Contact contact : contacts) {
			contactDto.add(ContactToContactDto(contact));
		}
		return contactDto;
	}
	public Contact ContactDtoToContact(ContactDto contactDto) {

		if (contactDto == null) {
			return null;
		}

		Contact contact = mapper.map(contactDto, Contact.class);
//pour le foreign key

		Client c = contact.getClient();
		if(c != null) {
			contactDto.setClient((mapper.map(c, ClientDto.class)));
		}
		
		return contact;
	}

	public List<Contact> ContactDtoToContact(List<ContactDto> dtos) {

		if (CollectionUtils.isEmpty(dtos)) {
			return Collections.emptyList();
		}

		List<Contact> contacts = new ArrayList<Contact>();

		for (ContactDto contactDto : dtos) {
			contacts.add(ContactDtoToContact(contactDto));
		}

		return contacts;
	}
}
