package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoDatosPtrVentaService {

    void ventaDetalleEmpleado(@Valid final TrabajoDto trabajo) throws Exception;

    void ventaTotalizadaTienda(@Valid final TrabajoDto trabajo,
            @NotNull final List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception;

    void ventaTotalizadaTiendaTest(@Valid TrabajoDto trabajo, List<TipoTrabajoTiendaDto> tipoTrabajoTienda)
            throws Exception;

}