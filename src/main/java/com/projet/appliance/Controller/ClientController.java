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

import com.projet.appliance.dto.ClientDto;
import com.projet.appliance.report.service.ReportService;
import com.projet.appliance.services.ClientService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
@RequestMapping("/client")
@CrossOrigin("*")
public class ClientController {

	@Autowired
	private  ClientService clientService;

	@Autowired
	private ReportService reportService;
	
	@GetMapping("/all")
	public List<ClientDto> getAllClient(){
		List<ClientDto> cliente= clientService.findAllClient();
		return cliente;
	}
	@GetMapping("/find/{id}")
	public ClientDto getClientById(@PathVariable("id") Long id){
		ClientDto client = clientService.findClientById(id);
		return client;
	}
	@PostMapping("/add")
	public ClientDto addClient(@RequestBody ClientDto client){
		ClientDto newclient = clientService.addClient(client);
		return newclient;
	}
	@PostMapping("/addList")
	public List<ClientDto> addListClient(@RequestBody List<ClientDto> client){
		List<ClientDto> newclie = clientService.addListClient(client);
		return newclie;
	}
	@GetMapping("/libelle/{libelle}")
	public List<ClientDto> findByLibelle(@PathVariable("libelle") String libelle){
		List<ClientDto> client = clientService.findByLibelle(libelle);
	return client;
	}
	@GetMapping("/activite/{activite}")
	public List<ClientDto> findByActivite(@PathVariable("activite") String activite){
		List<ClientDto> client = clientService.findByActivite(activite);
		return client;
	}
	@PutMapping("/update")
	public ClientDto updateClient(@RequestBody ClientDto client){
		ClientDto updclient = clientService.updateClient(client);
		return updclient;
	}
	@DeleteMapping("/delete/{id}")
	public ClientDto deleteClient(@PathVariable ("id")Long id ){
		clientService.deleteClientDtoById(id);
		return null;
		
	}
	@GetMapping("/clientpdf/client")
	public void exporttoPovPdf(HttpServletResponse response) throws Exception{
		JasperPrint jasperPrint = reportService.generateReportClient();
		if(jasperPrint == null) {
			return;
		}
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename = client.pdf");
		
		OutputStream outputStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	}
}
