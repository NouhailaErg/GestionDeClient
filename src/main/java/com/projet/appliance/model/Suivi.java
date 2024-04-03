package com.projet.appliance.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="SUIVI")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Suivi {
	 @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "ID_SUIVI")
	private Long id;
	 @Column(name="OFFRE_COMMERCIAL")
	private Boolean offre_com;
	 @Column(name="MONTANT")
	private BigDecimal montant;

	 @ManyToOne(fetch = FetchType.EAGER)
	   @JoinColumn(name="ID_typePres")
	private TypePrestation typePrestation;
	 @Column(name="COMPTE_RENDU")
	 private String compte_rendu;
	 @ManyToOne(fetch = FetchType.EAGER)
	   @JoinColumn(name="ID_POV")
	private Pov pov;

}
