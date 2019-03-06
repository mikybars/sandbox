package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaTiendaPresenciaSeccionService {

    void pivot(@Valid final TareaDto tarea);

}
