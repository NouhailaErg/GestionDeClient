package com.projet.appliance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.appliance.model.Pov;
import com.projet.appliance.model.Suivi;
import com.projet.appliance.model.TypePrestation;

public interface SuiviRepository extends JpaRepository<Suivi, Long> {

	List<Suivi> findByPov(Pov pov);
	List<Suivi> findByTypePrestation(TypePrestation typePrestation);


}
