package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TrabajoTiendaPresenciaSeccionService {

    void pivot(@Valid final TrabajoDto trabajoDto) throws Exception;

}
