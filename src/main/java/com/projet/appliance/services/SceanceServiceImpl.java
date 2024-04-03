package com.projet.appliance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.appliance.dto.SceanceDto;
import com.projet.appliance.mappers.SceanceDozerMapper;
import com.projet.appliance.model.Pov;
import com.projet.appliance.repositories.SceanceRepository;

@Service
public class SceanceServiceImpl implements SceanceService{


	@Autowired
	SceanceDozerMapper sceanceDozerMapper;
	@Autowired
	SceanceRepository sceanceRepository;
	
	@Override
	public SceanceDto saveSceance(SceanceDto a) {
		SceanceDto dto=	sceanceDozerMapper.SceanceToSceanceDto(sceanceRepository.save(
				sceanceDozerMapper.SceanceDtoToSceance(a)));
		return dto;
	}
	@Override
	public SceanceDto updateSceance(SceanceDto a) {
			SceanceDto dto=	sceanceDozerMapper.SceanceToSceanceDto(sceanceRepository.save(
					sceanceDozerMapper.SceanceDtoToSceance(a)));
			return dto;
	}
	@Override
	public void deleteSceanceDtoById(Long id) {
		 sceanceRepository.deleteById(id);

	}
	@Override
	public SceanceDto getSceance(Long id) {
		return 	sceanceDozerMapper.SceanceToSceanceDto(sceanceRepository.findById(id).get());

	}
	@Override
	public List<SceanceDto> getAllSceance() {
		return 	sceanceDozerMapper.SceanceToSceanceDto(sceanceRepository.findAll());

	}
	@Override
	public List<SceanceDto> findAllSceance() {
		return sceanceDozerMapper.SceanceToSceanceDto(sceanceRepository.findAll());

	}
	@Override
	public SceanceDto findSceance(Long id) {
		return sceanceDozerMapper.SceanceToSceanceDto(sceanceRepository.findById(id).get());

	}
	@Override
	public SceanceDto addSceance(SceanceDto a) {
			SceanceDto dto=	sceanceDozerMapper.SceanceToSceanceDto(sceanceRepository.save(
					sceanceDozerMapper.SceanceDtoToSceance(a)));
			return dto;
	}
	@Override
	public List<SceanceDto> findByPov(Pov pov) {
		return sceanceDozerMapper.SceanceToSceanceDto(sceanceRepository.findByPov(pov));
	}
	@Override
	public List<SceanceDto> addListSceance(List<SceanceDto> s) {
		return sceanceDozerMapper.SceanceToSceanceDto(sceanceRepository.saveAll
				(sceanceDozerMapper.SceanceDtoToSceance(s)));
		
	}
}
