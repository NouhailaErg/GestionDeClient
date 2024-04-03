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
@Table(name="CONTACT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

	@Id    @GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	   @Column(name = "NOM")
	private String nom;
	   @Column(name = "PRENOM")
	private String prenom;
	   @Column(name = "FONCTION")
	private String fonction;
	   @Column(name = "TELEPHONE")
	private String telephone;
	
	    @ManyToOne(fetch = FetchType.EAGER)
	   @JoinColumn(name="ID_CLIENT")
	private Client client; 
		   @Column(name = "EMAIL")
	private String email;
}
