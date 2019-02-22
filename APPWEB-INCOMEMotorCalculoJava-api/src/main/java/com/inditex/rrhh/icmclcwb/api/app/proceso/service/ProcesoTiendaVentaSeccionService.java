package com.inditex.rrhh.icmclcwb.api.app.proceso.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;

public interface ProcesoTiendaVentaSeccionService {

    void pivot(@Valid final ProcesoDto proceso);

}
