package com.projet.appliance.report.dto;

import java.util.Date;

public interface IPovDto {
	Long getId();
	String getApplianceLibelle();
	String getClientLibelle();
	Date getDateDebut();
	Date getDateFin();
	String getDescription();
	String getCompteManager();
	String getIngenieurCybersecurite();
	String getAnalyseCybersecurity();
	String getLibelle_pov();
}
