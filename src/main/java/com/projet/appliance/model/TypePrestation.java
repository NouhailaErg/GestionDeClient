package com.projet.appliance.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TYPE_PRESTATION")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypePrestation {
	  @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "ID_typePres")
	private Long id;
	  @Column(name="LIBELLE")
	private String libelle;

}
