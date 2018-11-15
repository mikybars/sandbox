package com.inditex.rrhh.icmclcwb.model.primary.repository;

import com.inditex.rrhh.icmclcwb.model.primary.domain.CalculoCriteria;

public interface GTCalculoRepository {
		
	public boolean calcular(CalculoCriteria criteria);

}
