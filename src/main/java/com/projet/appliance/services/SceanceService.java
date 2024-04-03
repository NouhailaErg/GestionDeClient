package com.projet.appliance.services;

import java.util.List;

import com.projet.appliance.dto.SceanceDto;
import com.projet.appliance.model.Pov;

public interface SceanceService {

	SceanceDto saveSceance(SceanceDto a);
	SceanceDto updateSceance(SceanceDto a);
	void deleteSceanceDtoById(Long id);
	SceanceDto getSceance(Long id);
	List<SceanceDto> getAllSceance();
	List<SceanceDto> findByPov(Pov pov);
	List<SceanceDto> findAllSceance();
	SceanceDto findSceance(Long id);
	SceanceDto addSceance(SceanceDto a);
	List<SceanceDto> addListSceance(List<SceanceDto> s);

}
