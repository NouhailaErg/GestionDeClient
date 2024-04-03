package com.projet.appliance.mappers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.projet.appliance.dto.TypePrestationDto;
import com.projet.appliance.model.TypePrestation;

@Component
public class TypePrestationDozerMapper {

	@Autowired
	private DozerBeanMapper mapper;
	
	public TypePrestationDto TypePrestationToTypePrestationDto(TypePrestation typePrestation) {

		if (typePrestation == null) {
			return null;
		}

		TypePrestationDto typePrestationDto = mapper.map(typePrestation, TypePrestationDto.class);

		

		return typePrestationDto;
	}
	public List<TypePrestationDto> TypePrestationToTypePrestationDto(List<TypePrestation> typeps) {

		if (CollectionUtils.isEmpty(typeps)) {
			return Collections.emptyList();
		}

		List<TypePrestationDto> typeDtos = new ArrayList<TypePrestationDto>();

		for (TypePrestation type : typeps) {
			typeDtos.add(TypePrestationToTypePrestationDto(type));
		}
		return typeDtos;
	}
	public TypePrestation TypePrestationDtoToTypePrestation(TypePrestationDto typePrestationDto) {

		if (typePrestationDto == null) {
			return null;
		}

		TypePrestation typePrestation = mapper.map(typePrestationDto, TypePrestation.class);

		

		return typePrestation;
	}

	public List<TypePrestation> TypePrestationDtoToTypePrestatione(List<TypePrestationDto> dtos) {

		if (CollectionUtils.isEmpty(dtos)) {
			return Collections.emptyList();
		}

		List<TypePrestation> typePrestations = new ArrayList<TypePrestation>();

		for (TypePrestationDto typePrestationDto : dtos) {
			typePrestations.add(TypePrestationDtoToTypePrestation(typePrestationDto));
		}

		return typePrestations;
	}
	
}
