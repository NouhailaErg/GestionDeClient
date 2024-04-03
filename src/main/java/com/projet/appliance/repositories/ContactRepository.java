package com.projet.appliance.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.appliance.model.Client;
import com.projet.appliance.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	List<Contact> findByNom(String nom);
	List<Contact> findByClient(Client client);

	

}
