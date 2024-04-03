package com.projet.appliance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.appliance.model.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {

	List<Type> findByLibelle(String libelle);

}
