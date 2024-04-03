package com.projet.appliance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.appliance.dto.SuiviDto;
import com.projet.appliance.mappers.SuiviDozerMapper;
import com.projet.appliance.model.Pov;
import com.projet.appliance.model.TypePrestation;
import com.projet.appliance.repositories.SuiviRepository;

@Service
public class SuiviServiceImpl implements SuiviService{

	@Autowired
	SuiviDozerMapper suiviDozerMapper;
	@Autowired
	SuiviRepository suiviRepository;
	@Override
	public SuiviDto saveSuivi(SuiviDto a) {
		SuiviDto dto=	suiviDozerMapper.SuiviToSuiviDto(suiviRepository.save(
				suiviDozerMapper.SuiviDtoToSuivi(a)));
		return dto;
	}
	@Override
	public SuiviDto updateSuivi(SuiviDto a) {
		SuiviDto dto=	suiviDozerMapper.SuiviToSuiviDto(suiviRepository.save(
				suiviDozerMapper.SuiviDtoToSuivi(a)));
		return dto;
	}
	@Override
	public void deleteSuiviDtoById(Long id) {
		suiviRepository.deleteById(id);
		
	}
	@Override
	public SuiviDto getSuivi(Long id) {
		return 	suiviDozerMapper.SuiviToSuiviDto(suiviRepository.findById(id).get());

	}
	@Override
	public List<SuiviDto> getAllSuivi() {
		return 	suiviDozerMapper.SuiviToSuiviDto(suiviRepository.findAll());

	}
	@Override
	public List<SuiviDto> findAllSuivi() {
		return suiviDozerMapper.SuiviToSuiviDto(suiviRepository.findAll());

	}
	@Override
	public SuiviDto findSuivi(Long id) {
		return suiviDozerMapper.SuiviToSuiviDto(suiviRepository.findById(id).get());

	}
	@Override
	public SuiviDto addSuivi(SuiviDto a) {
		SuiviDto dto=	suiviDozerMapper.SuiviToSuiviDto(suiviRepository.save(
				suiviDozerMapper.SuiviDtoToSuivi(a)));
		return dto;
	}
	@Override
	public List<SuiviDto> findByPov(Pov pov) {
		return suiviDozerMapper.SuiviiToSuiviDto(suiviRepository.findByPov(pov));
	}
	@Override
	public List<SuiviDto> findByTypePrestation(TypePrestation typePrestation) {
		return suiviDozerMapper.SuiviiToSuiviDto(suiviRepository.findByTypePrestation(typePrestation));
	}
	@Override
	public List<SuiviDto> addListSuivi(List<SuiviDto> suivi) {
		return suiviDozerMapper.SuiviiToSuiviDto(suiviRepository.saveAll(suiviDozerMapper.SuiviDtoToSuivi(suivi)));
	}
	
	
}
