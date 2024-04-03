package com.projet.appliance.dto;

import lombok.Data;

@Data
public class ClientDto {

	private Long id_client;
	private String libelle;
	private String secteur;
	private String activite;
}
