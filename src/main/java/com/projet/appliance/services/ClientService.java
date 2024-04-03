package com.projet.appliance.services;

import java.util.List;

import com.projet.appliance.dto.ClientDto;

public interface ClientService {

	ClientDto saveClient(ClientDto c);
	ClientDto updateClient(ClientDto c);
	void deleteClientDtoById(Long id);
	ClientDto getClient(Long id);
	List<ClientDto> getAllClient();
	List<ClientDto> findByLibelle(String libelle);
	List<ClientDto> findByActivite(String activite);
	List<ClientDto> findAllClient();
	ClientDto findClientById(Long id);
	ClientDto addClient(ClientDto c);
	List<ClientDto> addListClient(List<ClientDto> c);
}
