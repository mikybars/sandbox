package com.inditex.rrhh.icmclcwb.model.mock.calculo.repository;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Repository;

@Repository
public class PopulateMockCalculoRepositoryImpl implements PopulateMockCalculoRepository {
			
	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Logger logger;
	
	@Override
	public void loadScripts(List<Resource> scripts) {
					
		  	ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		  			  			  		  	
		  	scripts.forEach(script ->{		  		
		  		databasePopulator.addScript(script);		  				  		
		  		logger.info("Carga del script: "+ script.getFilename());			    
		  	});
		  	databasePopulator.execute(jdbcTemplate.getDataSource());
		    logger.info("Fin de la carga de todos scripts");
	}

	
	
	
}
