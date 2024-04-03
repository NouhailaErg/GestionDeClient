package com.projet.appliance.mappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.projet.appliance.dto.PovDto;
import com.projet.appliance.dto.SceanceDto;
import com.projet.appliance.model.Pov;
import com.projet.appliance.model.Sceance;

@Component
public class SceanceDozerMapper {

	@Autowired
	private DozerBeanMapper mapper;
	
	public SceanceDto SceanceToSceanceDto(Sceance sceance) {

		if (sceance == null) {
			return null;
		}

		SceanceDto sceanceDto = mapper.map(sceance, SceanceDto.class);

		Pov pova = sceance.getPov();
        if (pova != null) {
        	sceanceDto.setPov(mapper.map(pova, PovDto.class));
        }

		return sceanceDto;
	}
	public List<SceanceDto> SceanceToSceanceDto(List<Sceance> sceances) {

		if (CollectionUtils.isEmpty(sceances)) {
			return Collections.emptyList();
		}

		List<SceanceDto> sceanceDtos = new ArrayList<SceanceDto>();

		for (Sceance sceance : sceances) {
			sceanceDtos.add(SceanceToSceanceDto(sceance));
		}
		return sceanceDtos;
	}
	public Sceance SceanceDtoToSceance(SceanceDto sceanceDto) {

		if (sceanceDto == null) {
			return null;
		}

		Sceance sceance = mapper.map(sceanceDto, Sceance.class);

		Pov pova = sceance.getPov();
        if (pova != null) {
        	sceanceDto.setPov(mapper.map(pova, PovDto.class));
        }

		return sceance;
	}

	public List<Sceance> SceanceDtoToSceance(List<SceanceDto> dtos) {

		if (CollectionUtils.isEmpty(dtos)) {
			return Collections.emptyList();
		}

		List<Sceance> sceances = new ArrayList<Sceance>();

		for (SceanceDto sceanceDto : dtos) {
			sceances.add(SceanceDtoToSceance(sceanceDto));
		}

		return sceances;
	}
}
