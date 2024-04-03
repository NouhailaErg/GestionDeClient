package com.projet.appliance.mappers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.projet.appliance.dto.ClientDto;
import com.projet.appliance.model.Client;

@Component

public class ClientDozerMapper {

	@Autowired
	private DozerBeanMapper mapper;
	
	public ClientDto ClientToClientDto(Client client) {

		if (client == null) {
			return null;
		}

		ClientDto clientDto = mapper.map(client, ClientDto.class);

		

		return clientDto;
	}
	public List<ClientDto> ClientToClientDto(List<Client> clients) {

		if (CollectionUtils.isEmpty(clients)) {
			return Collections.emptyList();
		}

		List<ClientDto> clientDtos = new ArrayList<ClientDto>();

		for (Client client : clients) {
			clientDtos.add(ClientToClientDto(client));
		}
		return clientDtos;
	}
	

public Client ClientDtoToClient(ClientDto clientDto) {

	if (clientDto == null) {
		return null;
	}

	Client client = mapper.map(clientDto, Client.class);

	

	return client;
}


public List<Client> ClientDtoToClient(List<ClientDto> dtos) {

	if (CollectionUtils.isEmpty(dtos)) {
		return Collections.emptyList();
	}

	List<Client> clients = new ArrayList<Client>();

	for (ClientDto clientDto : dtos) {
		clients.add(ClientDtoToClient(clientDto));
	}

	return clients;
}


}
