package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;

public interface TrabajoDatosPtrVentaService {

    void ventaDetalleEmpleado(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos)
            throws Exception;

    void ventaTotalizadaTienda(@Valid final TrabajoDto trabajo,
            @NotNull @NotEmpty final List<TipoTrabajoTiendaDto> tipoTrabajoTienda,
            @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception;

}