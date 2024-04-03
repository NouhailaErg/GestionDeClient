package com.projet.appliance.services;

import java.util.List;

import com.projet.appliance.dto.SuiviDto;
import com.projet.appliance.model.Pov;
import com.projet.appliance.model.TypePrestation;

public interface SuiviService {

	SuiviDto saveSuivi(SuiviDto a);
	SuiviDto updateSuivi(SuiviDto a);
	void deleteSuiviDtoById(Long id);
	SuiviDto getSuivi(Long id);
	List<SuiviDto> findByPov(Pov pov);
	List<SuiviDto> findByTypePrestation(TypePrestation typepre);
	List<SuiviDto> getAllSuivi();
	List<SuiviDto> findAllSuivi();
	SuiviDto findSuivi(Long id);
	SuiviDto addSuivi(SuiviDto a);
	List<SuiviDto> addListSuivi(List<SuiviDto> suivi);

}
