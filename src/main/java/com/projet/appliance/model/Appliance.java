package com.projet.appliance.model;

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
@Table(name="APPLIANCE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appliance {

	@Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="ID_APPLIANCE")
	private Long id_appliance;
	   @Column(name = "LIBELLE")
	private String libelle;
	   @ManyToOne(fetch = FetchType.EAGER)
	   @JoinColumn(name="ID_TYPE")
	private Type type;
	   @Column(name="DBID")
private String dbid;
	   @Column(name="DISPONIBILITE")
	private Boolean disponibilite;
	   @Column(name="REFERENCE")
	private String reference;
}
