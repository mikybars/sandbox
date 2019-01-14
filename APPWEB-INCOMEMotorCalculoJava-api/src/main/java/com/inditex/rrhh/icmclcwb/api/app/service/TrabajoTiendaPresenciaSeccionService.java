package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoTiendaPresenciaSeccionService {

    void pivot(@Valid final TrabajoDto trabajoDto) throws Exception;

}
