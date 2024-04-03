package com.projet.appliance.dto;

import java.sql.Date;


import lombok.Data;

@Data
public class SceanceDto {

	private Long id;
	private Date date_sceance;
	private String resumer;
    private String participant;
    private PovDto pov;

}
