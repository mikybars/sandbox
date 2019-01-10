package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoTiendaVentaSeccionService {

    void pivot(@Valid TrabajoDto trabajoDto) throws Exception;

}
