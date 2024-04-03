package com.projet.appliance.Controller;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.appliance.dto.ApplianceDto;
import com.projet.appliance.model.Type;
import com.projet.appliance.report.service.ReportService;
import com.projet.appliance.services.ApplianceService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
@RequestMapping("/appliance")
@CrossOrigin("*")
public class ApplianceController {

	@Autowired
	private ApplianceService applianceService;
	@Autowired
	private ReportService reportService;

		@GetMapping(value="/all")
		public List<ApplianceDto> getAllAppliance(){
			List<ApplianceDto> appliancee= applianceService.findAllAppliance();
			return appliancee;
		}
		@GetMapping("/libelle/{libelle}")
		public List<ApplianceDto> findByLibelle(@PathVariable("libelle") String libelle){
			List<ApplianceDto> appliance = applianceService.findByLibelle(libelle);
		return appliance;
		}
		@GetMapping("/type/{type}")
		public List<ApplianceDto> findByLibelle(@PathVariable("type") Type type){
			List<ApplianceDto> typee = applianceService.findByType(type);
		return typee;
		}
		@GetMapping("/dis/{disponibilite}")
		public List<ApplianceDto> findBydisponibilite(@PathVariable("disponibilite") Boolean disponibilite){
			List<ApplianceDto> appliance = applianceService.findByDisponibilite(disponibilite);
			return appliance;
		}
		
		
@GetMapping("/find/{id}")
public ApplianceDto getApplianceById(@PathVariable("id") Long id){
	if(id==null) {
		return null;
	}
	ApplianceDto appliance = applianceService.findApplianceById(id);
	return appliance;
}
		@PostMapping("/add")
		public ApplianceDto addAppliance(@RequestBody ApplianceDto appliance){
			ApplianceDto newappliance = applianceService.addAppliance(appliance);
			return newappliance;
		}
		@PostMapping("/addList")
		public List<ApplianceDto> addListAppliance(@RequestBody List<ApplianceDto> appliance){
			List<ApplianceDto> newapp = applianceService.addListAppliance(appliance);
			return newapp;
		}
		@PutMapping("/update")
		public ApplianceDto updateAppliance(@RequestBody ApplianceDto appliance){
			ApplianceDto updappliance = applianceService.updateAppliance(appliance);
			return updappliance;
		}
		@DeleteMapping("/delete/{id}")
		public ApplianceDto deleteAppliance(@PathVariable ("id")Long id ){
			applianceService.deleteApplianceDtoById(id);
			return null;
		}
		@GetMapping("/applipdf/appliance")
		public void exporttoPovPdf(HttpServletResponse response) throws Exception{
			JasperPrint jasperPrint = reportService.generateReportApp();
			if(jasperPrint == null) {
				return;
			}
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "attachment; filename = appliance.pdf");
			
			OutputStream outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		}
}
