package com.projet.appliance.report.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.projet.appliance.dto.PovDto;
import com.projet.appliance.mappers.PovDozerMapper;
import com.projet.appliance.model.Pov;
import com.projet.appliance.report.dto.IApplianceDto;
import com.projet.appliance.report.dto.IClientDto;
import com.projet.appliance.report.dto.IPovDto;
import com.projet.appliance.report.repository.ReportRepository;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {
	public static final String Resource = "static/report/pov1.jrxml";
	public static final String Resources = "static/report/List.jrxml";
	public static final String Resourcess = "static/report/appliance.jrxml";
	public static final String Resourcesc = "static/report/client.jrxml";

	@Autowired
	ReportRepository povrepo;

	@Autowired
	PovDozerMapper mapper;

	public JasperPrint povPdf(Long id) throws IOException, JRException {
		InputStream resource = new ClassPathResource(Resource).getInputStream();
		JasperReport jasperReport = JasperCompileManager.compileReport(resource);
		IPovDto pov = povrepo.getPov(id);

		if (pov == null) {
			return null;
		}

		List<IPovDto> data = new ArrayList<IPovDto>();
		data.add(pov);
		Map<String, Object> parameters = new HashMap();

		parameters.put(JRParameter.REPORT_LOCALE, Locale.FRENCH);

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		return jasperPrint;
	}

	///////
	public JasperPrint generateReport() throws IOException, JRException {
		InputStream resource = new ClassPathResource(Resources).getInputStream();
		JasperReport jasperReport = JasperCompileManager.compileReport(resource);
		List<IPovDto> pov = povrepo.getAllPov();
		if (pov == null) {
			return null;
		}

		List<IPovDto> data = new ArrayList<IPovDto>();
		for (IPovDto povs : pov) {
			data.add(povs);
		}
		
		Map<String, Object> parameters = new HashMap();

		parameters.put(JRParameter.REPORT_LOCALE, Locale.FRENCH);

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		return jasperPrint;
	}
	///appliance
	public JasperPrint generateReportApp() throws IOException, JRException {
		InputStream resource = new ClassPathResource(Resourcess).getInputStream();
		JasperReport jasperReport = JasperCompileManager.compileReport(resource);
		List<IApplianceDto> appliance = povrepo.getAllAppliance();
		if (appliance == null) {
			return null;
		}

		List<IApplianceDto> data = new ArrayList<IApplianceDto>();
		for (IApplianceDto appliances : appliance) {
			data.add(appliances);
		}
		
		Map<String, Object> parameters = new HashMap();

		parameters.put(JRParameter.REPORT_LOCALE, Locale.FRENCH);

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		return jasperPrint;
	}
	////client
	public JasperPrint generateReportClient() throws IOException, JRException {
		InputStream resource = new ClassPathResource(Resourcesc).getInputStream();
		JasperReport jasperReport = JasperCompileManager.compileReport(resource);
		List<IClientDto> client = povrepo.getAllClient();
		if (client == null) {
			return null;
		}

		List<IClientDto> data = new ArrayList<IClientDto>();
		for (IClientDto clients : client) {
			data.add(clients);
		}
		
		Map<String, Object> parameters = new HashMap();

		parameters.put(JRParameter.REPORT_LOCALE, Locale.FRENCH);

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		return jasperPrint;
	}
}
