package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLimpiezaRepositoryCustom;

@Service
@Validated
public class TareaLimpiezaServiceImpl implements TareaLimpiezaService {

    @Autowired
    private TareaLimpiezaRepositoryCustom tareaLimpiezaRepositoryCustom;

    @Autowired
    private TrabajoService trabajoService;

    @Override
    public void save(@Valid @NotNull final TareaDto tarea) {
        tareaLimpiezaRepositoryCustom.mergeLimpieza(tarea, trabajoService.find(tarea.getIdTrabajo()));
    }

}
