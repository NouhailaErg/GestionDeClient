package com.projet.appliance.dto;

import java.math.BigDecimal;



import lombok.Data;

@Data
public class SuiviDto {

	private Long id;
	private Boolean offre_com;
	private BigDecimal montant;
	private TypePrestationDto typePrestation;
	private String compte_rendu;
	private PovDto pov;

}
