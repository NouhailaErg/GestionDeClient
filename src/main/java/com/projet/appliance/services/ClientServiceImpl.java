package com.projet.appliance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.appliance.dto.ClientDto;
import com.projet.appliance.mappers.ClientDozerMapper;
import com.projet.appliance.repositories.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientDozerMapper clientDozerMapper;
	@Autowired
	ClientRepository clientRepository;
	
	public ClientServiceImpl(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	@Override
	public ClientDto saveClient(ClientDto c) {
		ClientDto dto=	clientDozerMapper.ClientToClientDto(clientRepository.save(
				clientDozerMapper.ClientDtoToClient(c)));
		return dto;
	}

	@Override
	public ClientDto updateClient(ClientDto c) {
		ClientDto dto=	clientDozerMapper.ClientToClientDto(clientRepository.save(
				clientDozerMapper.ClientDtoToClient(c)));
		return dto;
	}


	@Override
	public void deleteClientDtoById(Long id) {	
		 clientRepository.deleteById(id);
		
	}

	@Override
	public ClientDto getClient(Long id) {
		return 	clientDozerMapper.ClientToClientDto(clientRepository.findById(id).get());

	}

	@Override
	public List<ClientDto> getAllClient() {
		return 	clientDozerMapper.ClientToClientDto(clientRepository.findAll());

	}

	@Override
	public List<ClientDto> findByLibelle(String libelle) {
		return clientDozerMapper.ClientToClientDto(clientRepository.findByLibelle(libelle));

	}

	@Override
	public List<ClientDto> findAllClient() {
		return clientDozerMapper.ClientToClientDto(clientRepository.findAll());

	}

	@Override
	public ClientDto findClientById(Long id) {
		return clientDozerMapper.ClientToClientDto(clientRepository.findById(id).get());

	}

	@Override
	public ClientDto addClient(ClientDto c) {
		ClientDto dto=	clientDozerMapper.ClientToClientDto(clientRepository.save(
				clientDozerMapper.ClientDtoToClient(c)));
		return dto;
	}

	@Override
	public List<ClientDto> findByActivite(String activite) {
		return clientDozerMapper.ClientToClientDto(clientRepository.findByActivite(activite));

	}

	@Override
	public List<ClientDto> addListClient(List<ClientDto> c) {
		return clientDozerMapper.ClientToClientDto(clientRepository.saveAll(clientDozerMapper.ClientDtoToClient(c)));
	}

	

}
