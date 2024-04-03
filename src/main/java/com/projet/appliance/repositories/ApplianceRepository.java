package com.projet.appliance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.appliance.model.Appliance;
import com.projet.appliance.model.Type;

public interface ApplianceRepository extends JpaRepository<Appliance, Long> {
	List<Appliance> findByLibelle(String libelle);
	List<Appliance> findBydisponibilite(Boolean disponibilite);
	List<Appliance> findByType(Type type);
}
