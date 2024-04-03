package com.projet.appliance.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.projet.appliance.dto.PovDto;
import com.projet.appliance.model.Appliance;
import com.projet.appliance.model.Client;
import com.projet.appliance.model.Pov;
import com.projet.appliance.report.service.ReportService;
import com.projet.appliance.repositories.PovRepository;
import com.projet.appliance.services.PovService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;


@RestController
@RequestMapping("/pov")
@CrossOrigin("*")
public class PovController {
	@Autowired
	PovRepository povRepository;
	private static final Long id = null;
	@Autowired
	private  PovService povService;



		@GetMapping("/all")
		public List<PovDto> getAllPov(){
			List<PovDto> pov= povService.findAllPov();
			return pov;
		}
		@GetMapping("/find/{id}")
		public PovDto getPovById(@PathVariable("id") Long id){
			PovDto pov = povService.findPovById(id);
			return pov;
		}
		@PostMapping("/appliance")
		public List<PovDto> findByAppliance(@RequestBody Appliance appliance) {
			List<PovDto> pov = povService.findByAppliance(appliance);
			return pov;
		}
		@PostMapping("/client")
		public List<PovDto> findByClient(@RequestBody Client client) {
			List<PovDto> pov = povService.findByClient(client);
			return pov;
		}
		@PostMapping("/add")
		public PovDto addPov(@RequestBody PovDto povv){
			PovDto newpov = povService.addPov(povv);
			return newpov;
		}
		@PostMapping("/addList")
		public List<PovDto> addListPov(@RequestBody List<PovDto> p){
			List<PovDto> newpov = povService.addListPov(p);
			return newpov;
		}
		@PutMapping("/update")
		public PovDto updatePov(@RequestBody PovDto pov){
			PovDto updapov = povService.updatePov(pov);
			return updapov;
		}
		@DeleteMapping("/delete/{id}")
		public void deletePov(@PathVariable ("id")Long id ){
			povService.deletePovDtoById(id);
		
		}
		
		private final static String RESSOURCE="C:\\Users\\HP\\eclipse-workspace\\Appliance\\src\\main\\resources\\pov.jrxml";
		
}
