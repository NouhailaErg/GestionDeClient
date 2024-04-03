package com.projet.appliance.services;

import java.util.List;

import com.projet.appliance.dto.ApplianceDto;
import com.projet.appliance.model.Type;

public interface ApplianceService {
	
	ApplianceDto saveAppliance(ApplianceDto a);
	ApplianceDto updateAppliance(ApplianceDto a);
	void deleteApplianceDtoById(Long id);
	ApplianceDto getAppliance(Long id);
	List<ApplianceDto> getAllAppliance();
	List<ApplianceDto> findByDisponibilite(Boolean disponibilite);
	List<ApplianceDto> findByType(Type type);
	List<ApplianceDto> findByLibelle(String libelle);
	List<ApplianceDto> findAllAppliance();
	ApplianceDto findApplianceById(Long id);
	ApplianceDto addAppliance(ApplianceDto a);
	List<ApplianceDto> addListAppliance(List<ApplianceDto> a);

}
