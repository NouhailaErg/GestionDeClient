package com.projet.appliance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.appliance.dto.TypeDto;
import com.projet.appliance.mappers.TypeDozerMapper;
import com.projet.appliance.repositories.TypeRepository;

@Service
public class TypeServiceImpl implements TypeService {
	
	@Autowired
	TypeDozerMapper typeDozerMapper;
	@Autowired
	TypeRepository typeRepository;
	public TypeServiceImpl(TypeRepository typeRepository) {
		super();
		this.typeRepository = typeRepository;
	}
	@Override
	public TypeDto saveType(TypeDto t) {
		TypeDto dto=	typeDozerMapper.TypeToTypeDto(typeRepository.save(
				typeDozerMapper.TypeDtoToType(t)));
		return dto;
	}
	@Override
	public TypeDto updateType(TypeDto t) {
		TypeDto dto=	typeDozerMapper.TypeToTypeDto(typeRepository.save(
				typeDozerMapper.TypeDtoToType(t)));
		return dto;
	}
	@Override
	public void deleteTypeById(Long id) {
		 typeRepository.deleteById(id);

	}
	@Override
	public TypeDto getType(Long id) {
		return 	typeDozerMapper.TypeToTypeDto(typeRepository.findById(id).get());

	}
	@Override
	public List<TypeDto> getAllType() {
		return 	typeDozerMapper.TypeToTypeDto(typeRepository.findAll());

	}
	@Override
	public List<TypeDto> findByLibelle(String libelle) {
		return typeDozerMapper.TypeToTypeDto(typeRepository.findByLibelle(libelle));

	}
	@Override
	public List<TypeDto> findAllType() {
		return typeDozerMapper.TypeToTypeDto(typeRepository.findAll());

	}
	@Override
	public TypeDto findTypeById(Long id) {
		return typeDozerMapper.TypeToTypeDto(typeRepository.findById(id).get());

	}
	@Override
	public TypeDto addType(TypeDto t) {
		TypeDto dto=	typeDozerMapper.TypeToTypeDto(typeRepository.save(
				typeDozerMapper.TypeDtoToType(t)));
		return dto;
	}
	@Override
	public List<TypeDto> addListType(List<TypeDto> type) {
		return typeDozerMapper.TypeToTypeDto(typeRepository.saveAll(typeDozerMapper.TypeDtoToType(type)));
	}

	
}
