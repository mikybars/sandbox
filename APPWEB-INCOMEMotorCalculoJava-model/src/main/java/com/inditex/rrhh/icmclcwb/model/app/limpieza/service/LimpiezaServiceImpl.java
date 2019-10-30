package com.inditex.rrhh.icmclcwb.model.app.limpieza.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository.LimpiezaRepositoryCustom;

@Service
@Validated
public class LimpiezaServiceImpl implements LimpiezaService {

    @Autowired
    private LimpiezaRepositoryCustom limpiezaRepositoryCustom;
    
    @Autowired
    private TrabajoService trabajoService;

    @Override
    public void runTarea(@NotNull @Valid final TareaDto tarea) {
        tarea.getAmbito().stream().forEach(item -> limpiezaRepositoryCustom.limpieza(tarea, item));
        limpiezaRepositoryCustom.consolidar(tarea, trabajoService.find(tarea.getIdTrabajo()));
    }

}
