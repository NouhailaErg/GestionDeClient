package com.projet.appliance.services;

import java.util.List;
import com.projet.appliance.dto.TypePrestationDto;


public interface TypePrestationService {

	TypePrestationDto saveTypePrestation(TypePrestationDto a);
	TypePrestationDto updateTypePrestation(TypePrestationDto a);
	void deleteTypePrestationDtoById(Long id);
	TypePrestationDto getTypePrestation(Long id);
	List<TypePrestationDto> findByLibelle(String libelle);
	List<TypePrestationDto> getAllTypePrestation();
	List<TypePrestationDto> findAllTypePrestation();
	TypePrestationDto findTypePrestation(Long id);
	TypePrestationDto addTypePrestation(TypePrestationDto a);
	List<TypePrestationDto> addListTypePrestationDto(List<TypePrestationDto> TypePrestationDto);

}
