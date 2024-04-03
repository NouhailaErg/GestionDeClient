package com.projet.appliance.mappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.projet.appliance.dto.TypeDto;
import com.projet.appliance.model.Type;

@Component
public class TypeDozerMapper {

	@Autowired
	private DozerBeanMapper mapper;
	
	public TypeDto TypeToTypeDto(Type type) {

		if (type == null) {
			return null;
		}

		TypeDto typeDto = mapper.map(type, TypeDto.class);

		return typeDto;
	}
	public List<TypeDto> TypeToTypeDto(List<Type> types) {

		if (CollectionUtils.isEmpty(types)) {
			return Collections.emptyList();
		}

		List<TypeDto> typeDtos = new ArrayList<TypeDto>();

		for (Type type : types) {
			typeDtos.add(TypeToTypeDto(type));
		}
		return typeDtos;
	}
	public Type TypeDtoToType(TypeDto typeDto) {

		if (typeDto == null) {
			return null;
		}

		Type type = mapper.map(typeDto, Type.class);

		

		return type;
	}

	public List<Type> TypeDtoToType(List<TypeDto> dtos) {

		if (CollectionUtils.isEmpty(dtos)) {
			return Collections.emptyList();
		}

		List<Type> types = new ArrayList<Type>();

		for (TypeDto typeDto : dtos) {
			types.add(TypeDtoToType(typeDto));
		}

		return types;
	}
}
