package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarEstructuraService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class RunTareaProcesarEstructuraServiceImpl implements RunTareaProcesarEstructuraService {

    @Autowired
    private TareaPersonaEstructuraRepositoryCustom tareaPersonaEstructuraRepositoryCustom;

    @Override
    public void updateActivoTopes(@Valid TareaDto tarea) {
        tareaPersonaEstructuraRepositoryCustom.updateActivoTopes(tarea);
    }
}
