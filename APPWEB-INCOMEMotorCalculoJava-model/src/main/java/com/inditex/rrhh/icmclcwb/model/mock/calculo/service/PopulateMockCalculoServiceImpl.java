package com.inditex.rrhh.icmclcwb.model.mock.calculo.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.model.mock.calculo.repository.PopulateMockCalculoRepository;

@Service
public class PopulateMockCalculoServiceImpl implements PopulateMockCalculoService {

				
	@Autowired
	private PopulateMockCalculoRepository populateMockCalculoRepository;
	
	@Autowired
	private Logger logger;
			
	@Async
	@Override
	public void loadMock(){
				
		logger.info("Servicio async de carga de scritp de datos mock");
		ArrayList<Resource> scripts = new ArrayList<>();		
		scripts.add( new ClassPathResource("mocks/INCOME_TRABAJO_TIENDA_VENTA_SECCION.sql"));			
		scripts.add( new ClassPathResource("mocks/INCOME_TRABAJO_EMPLEADO_ESTRUCTURA_1.sql"));	
		populateMockCalculoRepository.loadScripts(scripts);	   	   
	}
	
	
	@Override
	public void deleteMock(){		
		logger.info("Servicio de carga de scritp de borrado");
		ArrayList<Resource> scripts = new ArrayList<>();		
		scripts.add( new ClassPathResource("mocks/BORRADO_MODELO_INTERMEDIO.sql"));
		populateMockCalculoRepository.loadScripts(scripts);
	}
	
}
