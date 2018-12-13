package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosBloqueDto;

public interface TrabajoDatosMeta4IcmWsCalcIncomeService {

    void tiendasHistorico(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque)
            throws Exception;

    void tiendasEmpleadoHistorico(@Valid final TrabajoDto trabajo,
            @Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception;

    void condicionesEmpleados(@Valid final TrabajoDto trabajo,
            @Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception;

    void empleadosTienda(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque)
            throws Exception;

    void tiendasPresencia(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque)
            throws Exception;

    void tiendasComisionable(@Valid final TrabajoDto trabajo,
            @Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception;

}