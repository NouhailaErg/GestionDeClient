package com.projet.appliance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.appliance.dto.PovDto;
import com.projet.appliance.model.Appliance;
import com.projet.appliance.model.Client;
import com.projet.appliance.model.Pov;

public interface PovRepository extends JpaRepository<Pov, Long> {

	List<Pov> findByAppliance(Appliance appliance);
	List<Pov> findByClient(Client client);

}
