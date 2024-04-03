package com.projet.appliance.dto;

import lombok.Data;

@Data
public class ContactDto {

	private Long id;
	private String nom;
	private String prenom;
	private String telephone;
	private String fonction;
	private ClientDto client;
	private String email;
}
