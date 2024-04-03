package com.projet.appliance.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="POV")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE", length=4)
public class Pov {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "ID_POV")
	private Long id;

	   @ManyToOne(fetch = FetchType.EAGER)
	   @JoinColumn(name="ID_APPLIANCE")
	private Appliance appliance;

	   @ManyToOne(fetch = FetchType.EAGER)
	   @JoinColumn(name="ID_CLIENT")
	private Client client; 

	  @Temporal(TemporalType.DATE)
		@CreatedDate
		@Column(name="DATE_DEBUT")
	private Date date_debut;
	   @Temporal(TemporalType.DATE)
		@CreatedDate
		@Column(name="DATE_FIN")
	private Date date_fin;
		@Column(name="DESCRIPTION")
	private String description;
		@Column(name="COMPTEMANAGER")
	private String compteManager;
		@Column(name="IingenieurCyberSecurity")
	private String ingenieurCybersecurite;
		@Column(name="AnalyseCyberSecurity")
	private String analyseCybersecurity;
		@Column(name="LIBELLE_POV")
	private String libelle_pov;

}
