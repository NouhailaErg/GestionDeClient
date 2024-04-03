package com.projet.appliance.dto;


import java.util.Date;



import lombok.Data;

@Data
public class PovDto {

	private Long id;
	private ApplianceDto appliance;
	private ClientDto client; 	
	private Date date_debut;
	private Date date_fin;
	private String description;
	private String compteManager;
	private String ingenieurCybersecurite;
	private String analyseCybersecurity;
	private String libelle_pov;
}
