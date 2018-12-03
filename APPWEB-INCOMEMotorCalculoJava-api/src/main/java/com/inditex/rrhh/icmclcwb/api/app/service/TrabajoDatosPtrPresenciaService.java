package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;

public interface TrabajoDatosPtrPresenciaService {

    void tiposHoras(@Valid final TrabajoDto trabajo) throws Exception;

    void presenciaDetalleEmpleado(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception;

    void presenciaTotalizadaTienda(@Valid final TrabajoDto trabajo,
            @NotNull final List<TipoTrabajoTiendaDto> tipoTrabajoTienda, @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception;

}