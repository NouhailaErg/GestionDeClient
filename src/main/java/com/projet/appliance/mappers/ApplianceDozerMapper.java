package com.projet.appliance.mappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.projet.appliance.dto.ApplianceDto;
import com.projet.appliance.dto.TypeDto;
import com.projet.appliance.model.Appliance;
import com.projet.appliance.model.Type;


@Component
public class ApplianceDozerMapper {

	
	
	@Autowired
	private DozerBeanMapper mapper;
	
	public ApplianceDto ApplianceToApplianceDto(Appliance appliance) {

		if (appliance == null) {
			return null;
		}

		ApplianceDto applianceDto = mapper.map(appliance, ApplianceDto.class);

		Type typeA = appliance.getType();
        if (typeA != null) {
        	applianceDto.setType(mapper.map(typeA, TypeDto.class));
        }
        return applianceDto;
	}
	public List<ApplianceDto> ApplianceToApplianceDto(List<Appliance> appliances) {

		if (CollectionUtils.isEmpty(appliances)) {
			return Collections.emptyList();
		}

		List<ApplianceDto> applianceDtos = new ArrayList<ApplianceDto>();

		for (Appliance appliance : appliances) {
			applianceDtos.add(ApplianceToApplianceDto(appliance));
		}
		return applianceDtos;
	}
	
	public Appliance ApplianceDtoToAppliance(ApplianceDto applianceDto) {

		if (applianceDto == null) {
			return null;
		}

		Appliance appliance = mapper.map(applianceDto, Appliance.class);

		

		return appliance;
	}

	public List<Appliance> ApplianceDtoToAppliance(List<ApplianceDto> dtos) {

		if (CollectionUtils.isEmpty(dtos)) {
			return Collections.emptyList();
		}

		List<Appliance> appliances = new ArrayList<Appliance>();

		for (ApplianceDto applianceDto : dtos) {
			appliances.add(ApplianceDtoToAppliance(applianceDto));
		}

		return appliances;
	}


}
