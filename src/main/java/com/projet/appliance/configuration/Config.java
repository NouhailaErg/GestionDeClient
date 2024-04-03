package com.projet.appliance.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

//	  @Bean(name="org.dozer.Mappper")
//	  public DozerBeanMapper dozerBean() {
//		  List<String> mappingFiles = Arrays.asList(
//				  "dozer-global-configuration.xml",
//				  "dozer-bean-mappings.xml",
//				  "more-dozer-bean-mappings.xml"
//				  );
//		  
//		  DozerBeanMapper dozerBean = new DozerBeanMapper();
//		  dozerBean.setMappingFiles(mappingFiles);
//		  return dozerBean;
//	  }
	
	@Bean
	public DozerBeanMapper dozerBeanMapper() {
		return new DozerBeanMapper();
	}
	   // public Mapper getMapper() {

	    //    DozerBeanMapper mapper = new DozerBeanMapper();
	      //  mapper.setMappingFiles(Collections.singletonList("mappings.xml"));

	     //   return mapper;
	   // }
}
