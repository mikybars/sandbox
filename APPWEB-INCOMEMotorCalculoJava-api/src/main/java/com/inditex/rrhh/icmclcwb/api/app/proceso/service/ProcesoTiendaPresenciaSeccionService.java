package com.inditex.rrhh.icmclcwb.api.app.proceso.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;

public interface ProcesoTiendaPresenciaSeccionService {

    void pivot(@Valid final ProcesoDto proceso);

}
