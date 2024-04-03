package com.projet.appliance.dto;


import lombok.Data;

@Data
public class ApplianceDto {
	private Long id_appliance;
	private String libelle;
	private TypeDto type;
	private String dbid;
	private Boolean disponibilite;
	private String reference;

}
