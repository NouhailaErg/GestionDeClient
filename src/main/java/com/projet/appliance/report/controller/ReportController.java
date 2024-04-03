package com.projet.appliance.report.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.appliance.report.service.ReportService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
@RequestMapping("/report")
@CrossOrigin("*")
public class ReportController {

	@Autowired
	private ReportService reportService;
	
	@GetMapping("/povpdf/{id}")
	public void exportPovPdf(@PathVariable Long id ,HttpServletResponse response) throws Exception{
		JasperPrint jasperPrint = reportService.povPdf(id);
		if(jasperPrint == null) {
			return;
		}
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename = pov.pdf");
		
		OutputStream outputStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	}
	@GetMapping("/povpdf/all")
	public void exporttPovPdf(HttpServletResponse response) throws Exception{
		JasperPrint jasperPrint = reportService.generateReport();
		if(jasperPrint == null) {
			return;
		}
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename = pov.pdf");
		
		OutputStream outputStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	}
	//appliance
	
	
}
