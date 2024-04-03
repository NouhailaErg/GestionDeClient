package com.projet.appliance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.appliance.model.Pov;
import com.projet.appliance.model.Sceance;

public interface SceanceRepository extends JpaRepository<Sceance, Long>{
	List<Sceance> findByPov(Pov pov);
}
