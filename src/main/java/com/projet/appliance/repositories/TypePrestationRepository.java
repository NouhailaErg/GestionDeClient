package com.projet.appliance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.appliance.model.TypePrestation;

public interface TypePrestationRepository extends JpaRepository<TypePrestation, Long>{

	List<TypePrestation> findByLibelle(String libelle);

}
