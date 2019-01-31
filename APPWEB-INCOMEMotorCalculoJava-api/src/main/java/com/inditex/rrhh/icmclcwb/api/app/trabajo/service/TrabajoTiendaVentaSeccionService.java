package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TrabajoTiendaVentaSeccionService {

    void pivot(@Valid TrabajoDto trabajoDto) throws Exception;

}
