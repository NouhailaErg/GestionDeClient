package com.projet.appliance.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.projet.appliance.dto.PovDto;
import com.projet.appliance.model.Appliance;
import com.projet.appliance.model.Client;

import net.sf.jasperreports.engine.JRException;


public interface PovService {

	PovDto savePov(PovDto p);
	PovDto updatePov(PovDto p);
	void deletePovDtoById(Long id);
	PovDto getPov(Long id);
	List<PovDto> getAllPov();
	List<PovDto> findByAppliance(Appliance appliance);
	List<PovDto> findByClient(Client client);
	List<PovDto> findAllPov();
	PovDto findPovById(Long id);
	PovDto addPov(PovDto p);
	List<PovDto> addListPov(List<PovDto> pp);
	String generateReport()throws FileNotFoundException,JRException;
	

}
