package com.inditex.rrhh.icmclcwb.model.app.trabajo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.CalculoPropertiesDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.GTCalculoRepository;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Component
public class GTAlgoritmo implements TipoCalculoAlgoritmo {

	@Autowired
	GTCalculoRepository gTCalculoRepository;
		
	@Autowired
	@Qualifier("calculoGTPropertiesDto")
	private CalculoPropertiesDto calculoGTPropertiesDto;

	@Autowired
	private Logger log;
	

	@Override
	public Flux<Void> execute(RunTrabajoDto trabajoRunDto)  {
										
		if (trabajoRunDto.getRunTrabajoCalcular().getIdsEmpleados().size() >= calculoGTPropertiesDto.getNumBlock()) {					
			
			 Map<Long, List<Long>> grupos = trabajoRunDto.getRunTrabajoCalcular().getIdsEmpleados().stream()
					.collect(Collectors.groupingBy(s -> (s - 1) / calculoGTPropertiesDto.getNumBlock()));			 
			 List<List<Long>> subGrupos = new ArrayList<>(grupos.values());			 			 			 			
			 
			  CountDownLatch latch = new CountDownLatch(1);            
	            Flux.fromIterable(subGrupos)
	    				.parallel()
	    				.runOn(Schedulers.parallel())
	    				.doOnNext(idsEmpleados -> 	    						    						    						    					    						    				 	    					    				    						    				
	    					gTCalculoRepository.calcularByEmpleadoBatch(trabajoRunDto.getTrabajoDto().getId(), idsEmpleados)
	    				)	    			
	      			  .doOnError(error -> log.error(error.getMessage()))
	    			  .doAfterTerminate(latch::countDown)
	    		     .subscribe();    
	            
	    		try {
					latch.await();
				} catch (Exception e) {
					 return Flux.error(new ApplicationException( //TODO cambiar el estado
				                "Error al persistir bloque de empleados del trabajo: " + trabajoRunDto.getTrabajoDto().getId()));						
				}        			 			 			 

		} else {
			gTCalculoRepository.calcular(trabajoRunDto.getTrabajoDto().getId());						
		}

		return Flux.empty();
	}

}
