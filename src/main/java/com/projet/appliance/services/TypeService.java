package com.projet.appliance.services;

import java.util.List;

import com.projet.appliance.dto.TypeDto;

public interface TypeService {

	TypeDto saveType(TypeDto t);
	TypeDto updateType(TypeDto t);
	void deleteTypeById(Long id);
	TypeDto getType(Long id);
	List<TypeDto> getAllType();
	List<TypeDto> findByLibelle(String libelle);
	List<TypeDto> findAllType();
	TypeDto findTypeById(Long id);
	TypeDto addType(TypeDto t);
	List<TypeDto> addListType(List<TypeDto> type);
}
