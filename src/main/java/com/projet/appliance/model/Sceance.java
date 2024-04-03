package com.projet.appliance.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="SCEANCE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sceance {
	 @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "ID_SCEANCE")
	private Long id;
	  @Temporal(TemporalType.DATE)
			@CreatedDate
			@Column(name="DATE_SCEANCE")
	 private Date date_sceance;
	  @Column(name="RESUMER")
	 private String resumer;
	  @Column(name="PARTICIPANT")
  private String participant;
	  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="ID_POV")
private Pov pov;
	

}
