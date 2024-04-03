package com.projet.appliance.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.projet.appliance.model.Pov;
import com.projet.appliance.report.dto.IApplianceDto;
import com.projet.appliance.report.dto.IClientDto;
import com.projet.appliance.report.dto.IPovDto;
@Component
public interface ReportRepository extends JpaRepository<Pov, Long>{

	@Query(value = GET_POV , nativeQuery = true)
	IPovDto getPov(@Param ("id") Long id);
	public static final String GET_POV="select "
			+ "id_pov as id, "
			+ "a.libelle as applianceLibelle, "
			+ "c.libelle as clientLibelle, "
			+ "DATE_DEBUT as dateDebut, "
			+ "DATE_FIN as dateFin, "
			+ "DESCRIPTION as description, "
			+ "COMPTEMANAGER as compteManager, "
			+ "p.iingenieur_cyber_security as ingenieurCybersecurite, "
			+ "p.analyse_cyber_security as analyseCybersecurity, "
			+ "p.LIBELLE_POV as libelle_pov "
			+ "from pov p, appliance a , client c "
			+ "where p.id_appliance=a.id_appliance "
			+ "and p.id_client= c.id_client "
			+ "and id_pov=:id ";
	
	
	
	@Query(value = Get_AllPov, nativeQuery = true)
	List<IPovDto> getAllPov();
	public static final String Get_AllPov="select "
			+ "id_pov as id, "
			+ "a.libelle as applianceLibelle, "
			+ "c.libelle as clientLibelle, "
			+ "DATE_DEBUT as dateDebut, "
			+ "DATE_FIN as dateFin, "
			+ "DESCRIPTION as description, "
			+ "COMPTEMANAGER as compteManager, "
			+ "p.iingenieur_cyber_security as ingenieurCybersecurite, "
			+ "p.analyse_cyber_security as analyseCybersecurity, "
			+ "p.LIBELLE_POV as libelle_pov "
			+ "from pov p, appliance a , client c "
			+ "where p.id_appliance=a.id_appliance "
			+ "and p.id_client= c.id_client ";
	
	//Appliance
	@Query(value = Get_AllApp, nativeQuery = true)
	List<IApplianceDto> getAllAppliance();
	public static final String Get_AllApp="select "
			+ "id_appliance as id, "
			+ "a.libelle as libelle, "
			+ "t.libelle as typeLibelle, "
			+ "a.dbid as dbid, "
			+ "a.disponibilite as disponibilite, "
			+ "reference as reference "
			+ "from appliance a , type t "
			+ "where a.id_type=t.id_type ";
	//Appliance
		@Query(value = Get_AllCli, nativeQuery = true)
		List<IClientDto> getAllClient();
		public static final String Get_AllCli="select * from client";
}


