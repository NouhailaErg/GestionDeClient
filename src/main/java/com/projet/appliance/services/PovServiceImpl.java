package com.projet.appliance.services;

import java.io.File;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import com.projet.appliance.dto.PovDto;
import com.projet.appliance.mappers.PovDozerMapper;
import com.projet.appliance.model.Appliance;
import com.projet.appliance.model.Client;
import com.projet.appliance.model.Pov;
import com.projet.appliance.repositories.ApplianceRepository;
import com.projet.appliance.repositories.PovRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import java.io.FileNotFoundException;
import org.springframework.util.StringUtils;


@Service
public class PovServiceImpl implements PovService{


@Autowired
PovDozerMapper povDozerMapper;
@Autowired
PovRepository povRepository;
@Autowired
ApplianceRepository applianceRepository;
	@Override
	public PovDto savePov(PovDto p) {
		PovDto dto=	povDozerMapper.PovToPovDto(povRepository.save(
				povDozerMapper.PovDtoToPov(p)));
		return dto;
	}

	@Override
	public PovDto updatePov(PovDto p) {
		PovDto dto=	povDozerMapper.PovToPovDto(povRepository.save(
				povDozerMapper.PovDtoToPov(p)));
		return dto;
	}

	@Override
	@Transactional
	public void deletePovDtoById(Long id) {
		Pov p = povRepository.getOne(id);
		 Appliance app=applianceRepository.getOne(p.getAppliance().getId_appliance());
			
		 app.setDisponibilite(false);
		 povRepository.deleteById(id);
		 
			
		
	}

	@Override
	public PovDto getPov(Long id) {
		return 	povDozerMapper.PovToPovDto(povRepository.findById(id).get());

	}

	@Override
	public List<PovDto> getAllPov() {
		return 	povDozerMapper.PovToPovDto(povRepository.findAll());

	}

	@Override
	public PovDto findPovById(Long id) {
		return povDozerMapper.PovToPovDto(povRepository.findById(id).get());

	}

	@Override
	public PovDto addPov(PovDto p) {
		Appliance app=applianceRepository.getOne(p.getAppliance().getId_appliance());
		app.setDisponibilite(true);
		PovDto dto=	povDozerMapper.PovToPovDto(povRepository.save(
				povDozerMapper.PovDtoToPov(p)));
		
		return dto;
	}

	@Override
	public List<PovDto> findAllPov() {
		return 	povDozerMapper.PovToPovDto(povRepository.findAll());

	}

	@Override
	public List<PovDto> findByAppliance(Appliance appliance) {
		return povDozerMapper.PovToPovDto(povRepository.findByAppliance(appliance));
	}

	@Override
	public List<PovDto> findByClient(Client client) {
		return povDozerMapper.PovToPovDto(povRepository.findByClient(client));
	}

	@Override
	public List<PovDto> addListPov(List<PovDto> pp) {
		return povDozerMapper.PovToPovDto(povRepository.saveAll
				(povDozerMapper.PovDtoToPov(pp)));
		
	}
	public String generateReport()throws FileNotFoundException,JRException{
	    
	     return"Edition Faite";
	}
}
