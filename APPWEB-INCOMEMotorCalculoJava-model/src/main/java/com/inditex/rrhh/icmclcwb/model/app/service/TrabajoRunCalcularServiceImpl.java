package com.inditex.rrhh.icmclcwb.model.app.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajoRun;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants.EstadoTrabajoEnum;
import com.inditex.rrhh.icmclcwb.model.app.calculo.CalculoAlgoritmoFactory;
import com.inditex.rrhh.icmclcwb.model.app.util.TestUtils;

@Service
@Validated
public class TrabajoRunCalcularServiceImpl implements TrabajoRunCalcularService {

    @Autowired
    private TrabajoService trabajoService;
        
	@Autowired
	private CalculoAlgoritmoFactory calculoAlgoritmoFactory;

    @CounterMetric
    @TimerMetric
    @AuditoriaTrabajoRun
    @Override
    public TrabajoRunDto run(@Valid final TrabajoRunDto trabajoRun) throws Exception {
//        TrabajoDto trabajo = trabajoRun.getTrabajoDto();
//        if (EstadoTrabajoEnum.PENDIENTE_CALCULO.getId().equals(trabajo.getEstado().getId())) {
//            trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.EN_CURSO_CALCULO.getDto(), trabajo);                        
//                  
//            //obtenemos los datos de bbdd sino estan cargados en memoria
//                                  
//            CountDownLatch latch = new CountDownLatch(1);            
//            Flux.fromIterable(trabajoRun.getTrabajoRunDatos().getTiposCalculo())
//            		.log()
//    				.parallel()
//    				.runOn(Schedulers.parallel())
//    				.doOnNext(tipo -> {
//    					calculoAlgoritmoFactory.crearAlgoritmo(TipoCalculoEnum.of(tipo)).execute(trabajo);    					
//    				})
//      			  .doOnError(error -> error.printStackTrace())
//    			  .doAfterTerminate(latch::countDown)
//    		     .subscribe();    				
//    		latch.await();
//            
//            
////            trabajoRun.getTrabajoRunDatos().getTiposCalculo().forEach(tipo ->{            	            	            	           
////            	   calculoAlgoritmoFactory.crearAlgoritmo(TipoCalculoEnum.of(tipo)).execute(trabajo);            	                 	               	                        	                        	            	
////            });
//            
//                                     
//            trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.PENDIENTE_CONSOLIDACION.getDto(), trabajo);
//        }
        
        TrabajoDto trabajo = trabajoRun.getTrabajoDto();
        if (EstadoTrabajoEnum.PENDIENTE_CALCULO.getId().equals(trabajo.getEstado().getId())) {
            trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.EN_CURSO_CALCULO.getDto(), trabajo);                        
            //TODO Tengo una agrupacion de los tipos de calculo                        
            TestUtils.threadSleep();                                    
            trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.PENDIENTE_CONSOLIDACION.getDto(), trabajo);
        }
        return trabajoRun;
    }

}