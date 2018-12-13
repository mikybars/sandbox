package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosBloqueDto;

public interface TrabajoDatosPtrPresenciaService {

    void tiposHoras(@Valid final TrabajoDto trabajo) throws Exception;

    void presenciaDetalleEmpleado(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception;

    void presenciaTotalizadaTienda(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception;

}