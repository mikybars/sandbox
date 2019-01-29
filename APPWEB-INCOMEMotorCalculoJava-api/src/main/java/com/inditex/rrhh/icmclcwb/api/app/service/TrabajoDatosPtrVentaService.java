package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosBloqueDto;

public interface TrabajoDatosPtrVentaService {

    void ventaDetalleEmpleado(@Valid final TrabajoDto trabajo,
            @Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception;

    void ventaTotalizadaTienda(@Valid final TrabajoDto trabajo,
            @Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception;

}