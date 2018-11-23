package com.inditex.rrhh.icmclcwb.model.app.calculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.GTCalculoRepository;

@Component
public class GTAlgoritmo implements TipoCalculoAlgoritmo{
						
	@Autowired
	GTCalculoRepository gTCalculoRepository;
	
	@Override
	public void execute(TrabajoDto trabajo) {				
		gTCalculoRepository.calcular(trabajo);						
	}


}
