package com.projet.appliance.mappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.projet.appliance.dto.ApplianceDto;
import com.projet.appliance.dto.PovDto;
import com.projet.appliance.dto.ClientDto;
import com.projet.appliance.model.Appliance;
import com.projet.appliance.model.Client;
import com.projet.appliance.model.Pov;

@Component
public class PovDozerMapper {

	@Autowired
	private DozerBeanMapper mapper;
	
	public PovDto PovToPovDto(Pov pov) {

		if (pov == null) {
			return null;
		}

		PovDto povDto = mapper.map(pov, PovDto.class);
//
	
		Appliance appli = pov.getAppliance();
        if (appli != null) {
        	povDto.setAppliance(mapper.map(appli, ApplianceDto.class));
        	
        }
        //
        Client c = pov.getClient();
		if(c != null) {
			povDto.setClient((mapper.map(c, ClientDto.class)));
		}
	return povDto;
	}
	public List<PovDto> PovToPovDto(List<Pov> povs) {

		if (CollectionUtils.isEmpty(povs)) {
			return Collections.emptyList();
		}

		List<PovDto> povDtos = new ArrayList<PovDto>();

		for (Pov pov : povs) {
			povDtos.add(PovToPovDto(pov));
		}
		return povDtos;
	}
	public List<PovDto> PovvToPovDto(List<Pov> povss) {

		if (CollectionUtils.isEmpty(povss)) {
			return Collections.emptyList();
		}

		List<PovDto> povDtos = new ArrayList<PovDto>();

		for (Pov pov : povss) {
			povDtos.add(PovToPovDto(pov));
		}
		return povDtos;
	}
	public Pov PovDtoToPov(PovDto povDto) {

		if (povDto == null) {
			return null;
		}

		Pov pov = mapper.map(povDto, Pov.class);
        
		Appliance appli = pov.getAppliance();
        if (appli != null) {
        	povDto.setAppliance(mapper.map(appli, ApplianceDto.class));
        	
        }
        //
        Client cli = pov.getClient();
        if (cli != null) {
        	povDto.setClient(mapper.map(cli, ClientDto.class));
        
        }

		return pov;
	}

	public List<Pov> PovDtoToPov(List<PovDto> dtos) {

		if (CollectionUtils.isEmpty(dtos)) {
			return Collections.emptyList();
		}

		List<Pov> povs = new ArrayList<Pov>();

		for (PovDto povDto : dtos) {
			povs.add(PovDtoToPov(povDto));
		}

		return povs;
	}
}
