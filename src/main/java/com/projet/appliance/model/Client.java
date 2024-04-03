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
@Table(name="CLIENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
//	@JsonBackReference
	@Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="ID_CLIENT")
	private Long id_client;
	   @Column(name = "LIBELLE")
	private String libelle;
	   @Column(name = "SECTEUR")
	private String secteur;
	   @Column(name = "ACTIVITE")
	private String activite;

}
