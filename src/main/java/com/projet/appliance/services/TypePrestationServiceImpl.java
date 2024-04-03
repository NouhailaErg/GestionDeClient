package com.projet.appliance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projet.appliance.dto.TypePrestationDto;
import com.projet.appliance.mappers.TypePrestationDozerMapper;
import com.projet.appliance.repositories.TypePrestationRepository;

@Service
public class TypePrestationServiceImpl implements TypePrestationService{

	@Autowired
	TypePrestationDozerMapper typePrestationDozerMapper;
	@Autowired
	TypePrestationRepository typePrestationRepository;
	@Override
	public TypePrestationDto saveTypePrestation(TypePrestationDto a) {
		TypePrestationDto dto=	typePrestationDozerMapper.TypePrestationToTypePrestationDto(typePrestationRepository.save(
				typePrestationDozerMapper.TypePrestationDtoToTypePrestation(a)));
		return dto;
	}
	@Override
	public TypePrestationDto updateTypePrestation(TypePrestationDto a) {
		TypePrestationDto dto=	typePrestationDozerMapper.TypePrestationToTypePrestationDto(typePrestationRepository.save(
				typePrestationDozerMapper.TypePrestationDtoToTypePrestation(a)));
		return dto;
	}
	@Override
	public void deleteTypePrestationDtoById(Long id) {
		typePrestationRepository.deleteById(id);
		
	}
	@Override
	public TypePrestationDto getTypePrestation(Long id) {
		return 	typePrestationDozerMapper.TypePrestationToTypePrestationDto(typePrestationRepository.findById(id).get());

	}
	@Override
	public List<TypePrestationDto> getAllTypePrestation() {
		return 	typePrestationDozerMapper.TypePrestationToTypePrestationDto(typePrestationRepository.findAll());

	}
	
	@Override
	public List<TypePrestationDto> findAllTypePrestation() {
		return typePrestationDozerMapper.TypePrestationToTypePrestationDto(typePrestationRepository.findAll());

	}
	@Override
	public TypePrestationDto findTypePrestation(Long id) {
		return typePrestationDozerMapper.TypePrestationToTypePrestationDto(typePrestationRepository.findById(id).get());

	}
	@Override
	public TypePrestationDto addTypePrestation(TypePrestationDto a) {
		TypePrestationDto dto=	typePrestationDozerMapper.TypePrestationToTypePrestationDto(typePrestationRepository.save(
				typePrestationDozerMapper.TypePrestationDtoToTypePrestation(a)));
		return dto;
	}
	@Override
	public List<TypePrestationDto> findByLibelle(String libelle) {
		
		return typePrestationDozerMapper.TypePrestationToTypePrestationDto(typePrestationRepository.findByLibelle(libelle));
	}
	@Override
	public List<TypePrestationDto> addListTypePrestationDto(List<TypePrestationDto> TypePrestationDto) {
		return typePrestationDozerMapper.TypePrestationToTypePrestationDto(typePrestationRepository.saveAll(typePrestationDozerMapper.TypePrestationDtoToTypePrestatione(TypePrestationDto)));
	}
}
