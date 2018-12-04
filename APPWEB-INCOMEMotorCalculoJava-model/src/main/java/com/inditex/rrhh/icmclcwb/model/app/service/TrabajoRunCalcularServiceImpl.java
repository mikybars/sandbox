package com.inditex.rrhh.icmclcwb.model.app.service;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajo;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
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

    @AuditoriaTrabajo
    @Override
    public TrabajoDto run(@Valid final TrabajoDto trabajo) throws Exception {
        if (EstadoTrabajoEnum.PENDIENTE_CALCULO.getId().equals(trabajo.getEstado().getId())) {
            trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.EN_CURSO_CALCULO.getDto(), trabajo);                        
            //TODO Tengo una agrupacion de los tipos de calculo                        
            TestUtils.threadSleep();                                    
            trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.PENDIENTE_CONSOLIDACION.getDto(), trabajo);
        }
        return trabajo;
    }

}