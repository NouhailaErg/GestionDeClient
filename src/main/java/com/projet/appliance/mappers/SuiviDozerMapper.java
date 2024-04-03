package com.projet.appliance.mappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.projet.appliance.dto.PovDto;
import com.projet.appliance.dto.SuiviDto;
import com.projet.appliance.dto.TypePrestationDto;
import com.projet.appliance.model.Pov;
import com.projet.appliance.model.Suivi;
import com.projet.appliance.model.TypePrestation;

@Component
public class SuiviDozerMapper {

	@Autowired
	private DozerBeanMapper mapper;
	
	public SuiviDto SuiviToSuiviDto(Suivi suivi) {

		if (suivi == null) {
			return null;
		}

		SuiviDto suiviDto = mapper.map(suivi, SuiviDto.class);

		//ID_typePres
		TypePrestation tp = suivi.getTypePrestation();
        if (tp != null) {
        	suiviDto.setTypePrestation(mapper.map(tp, TypePrestationDto.class));
        
        }
		//pov
		Pov pov = suivi.getPov();
        if (pov != null) {
        	suiviDto.setPov(mapper.map(pov, PovDto.class));
        
        }

		return suiviDto;
	}
	public List<SuiviDto> SuiviToSuiviDto(List<Suivi> suivis) {

		if (CollectionUtils.isEmpty(suivis)) {
			return Collections.emptyList();
		}

		List<SuiviDto> suiviDtos = new ArrayList<SuiviDto>();

		for (Suivi suivi : suivis) {
			suiviDtos.add(SuiviToSuiviDto(suivi));
		}
		return suiviDtos;
	}
	public List<SuiviDto> SuiviiToSuiviDto(List<Suivi> suivis) {

		if (CollectionUtils.isEmpty(suivis)) {
			return Collections.emptyList();
		}

		List<SuiviDto> suiviDtos = new ArrayList<SuiviDto>();

		for (Suivi suivi : suivis) {
			suiviDtos.add(SuiviToSuiviDto(suivi));
		}
		return suiviDtos;
	}
	public Suivi SuiviDtoToSuivi(SuiviDto suiviDto) {

		if (suiviDto == null) {
			return null;
		}

		Suivi suivi = mapper.map(suiviDto, Suivi.class);

		

		return suivi;
	}

	public List<Suivi> SuiviDtoToSuivi(List<SuiviDto> dtos) {

		if (CollectionUtils.isEmpty(dtos)) {
			return Collections.emptyList();
		}

		List<Suivi> suivis = new ArrayList<Suivi>();

		for (SuiviDto suiviDto : dtos) {
			suivis.add(SuiviDtoToSuivi(suiviDto));
		}

		return suivis;
	}
}
