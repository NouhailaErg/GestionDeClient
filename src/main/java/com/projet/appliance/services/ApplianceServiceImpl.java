package com.projet.appliance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.appliance.dto.ApplianceDto;
import com.projet.appliance.mappers.ApplianceDozerMapper;
import com.projet.appliance.model.Type;
import com.projet.appliance.repositories.ApplianceRepository;


@Service
public class ApplianceServiceImpl implements ApplianceService {

	@Autowired
	ApplianceDozerMapper applianceDozerMapper;
	@Autowired
	ApplianceRepository applianceRepository;
	
	
	
	
	@Override
	public ApplianceDto saveAppliance(ApplianceDto a) {
		ApplianceDto dto=	applianceDozerMapper.ApplianceToApplianceDto(applianceRepository.save(
				applianceDozerMapper.ApplianceDtoToAppliance(a)));
		return dto;
	}
	
	@Override
	public ApplianceDto addAppliance(ApplianceDto a) {
	a.setDisponibilite(false);
		ApplianceDto dto=	applianceDozerMapper.ApplianceToApplianceDto(applianceRepository.save(
				applianceDozerMapper.ApplianceDtoToAppliance(a)));
		return dto;
	}

	@Override
	public ApplianceDto updateAppliance(ApplianceDto a) {
		ApplianceDto dto=	applianceDozerMapper.ApplianceToApplianceDto(applianceRepository.save(
				applianceDozerMapper.ApplianceDtoToAppliance(a)));
		return dto;	}


	@Override
	public void deleteApplianceDtoById(Long id) {
		 applianceRepository.deleteById(id);
		
	}

	@Override
	public ApplianceDto getAppliance(Long id) {
		return 	applianceDozerMapper.ApplianceToApplianceDto(applianceRepository.findById(id).get());

	}

	@Override
	public List<ApplianceDto> getAllAppliance() {

	return 	applianceDozerMapper.ApplianceToApplianceDto(applianceRepository.findAll());
	}	
	
	@Override
	public List<ApplianceDto> findByLibelle(String libelle) {
		return applianceDozerMapper.ApplianceToApplianceDto(applianceRepository.findByLibelle(libelle));
	}
	public List<ApplianceDto> findAllAppliance(){
		return applianceDozerMapper.ApplianceToApplianceDto(applianceRepository.findAll());

	}

	@Override
	public ApplianceDto findApplianceById(Long id) {
		return applianceDozerMapper.ApplianceToApplianceDto(applianceRepository.findById(id).get());

	}

	@Override
	public List<ApplianceDto> findByDisponibilite(Boolean disponibilite) {
		return  applianceDozerMapper.ApplianceToApplianceDto(applianceRepository.findBydisponibilite(disponibilite));
	}



	@Override
	public List<ApplianceDto> findByType(Type type) {
		return applianceDozerMapper.ApplianceToApplianceDto(applianceRepository.findByType(type));
	}

	@Override
	public List<ApplianceDto> addListAppliance(List<ApplianceDto> a) {
		return applianceDozerMapper.ApplianceToApplianceDto(applianceRepository.saveAll(
				applianceDozerMapper.ApplianceDtoToAppliance(a)));
	}


	
}
