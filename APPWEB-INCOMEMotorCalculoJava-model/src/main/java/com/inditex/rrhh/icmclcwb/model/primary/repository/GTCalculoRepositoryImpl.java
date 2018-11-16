package com.inditex.rrhh.icmclcwb.model.primary.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.domain.CalculoCriteria;

@Repository
public class GTCalculoRepositoryImpl  implements GTCalculoRepository{
	
	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean calcular(CalculoCriteria criteria) 		
	{			
		return false;
	}
	
		
	
}

