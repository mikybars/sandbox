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
		
		//TODO comprobamos el numero de empleados a calcular, si es superior a mil lo dividmos en bloques de mil
		//usaremos reactor para paralelizar las llamadas
				 
		//Map<Integer, List<Integer>> groups = intList.stream().collect(Collectors.groupingBy(s -> (s - 1) / 1000));
		//List<List<Integer>> subSets = new ArrayList<List<Integer>>(groups.values());
		 		    
		 //System.out.println("subSets: "+subSets);
		    
		
		 gTCalculoRepository.calcular(trabajo.getId());
		
				
	}


}
