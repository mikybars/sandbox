package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;

public interface TrabajoDatosMeta4IcmWsCalcIncomeService {

    void tiendasHistorico(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception;

    void tiendasEmpleadoHistorico(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception;

    void condicionesEmpleados(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception;

    void empleadosTienda(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception;

    void tiendasPresencia(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception;

    void tiendasComisionable(@Valid final TrabajoDto trabajo, @NotNull final List<TipoTrabajoTiendaDto> tipoTrabajoTienda,
            @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception;

}