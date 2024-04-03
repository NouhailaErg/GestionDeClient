package com.projet.appliance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projet.appliance.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>  {

	List<Client> findByLibelle(String libelle);
	List<Client> findByActivite(String activite);
}
