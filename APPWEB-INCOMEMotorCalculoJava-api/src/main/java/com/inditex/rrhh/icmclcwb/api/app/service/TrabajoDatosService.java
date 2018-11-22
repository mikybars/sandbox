package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoDatosService {

    void condicionesEmpleados(@Valid final TrabajoDto trabajo) throws Exception;

    void empleadosTienda(@Valid final TrabajoDto trabajo) throws Exception;

    void tiendasParametro(@Valid final TrabajoDto trabajo) throws Exception;

    void tiendasHistorico(@Valid final TrabajoDto trabajo) throws Exception;

    void tiposHoras(@Valid final TrabajoDto trabajo) throws Exception;

    void ventaDetalleEmpleado(@Valid final TrabajoDto trabajo) throws Exception;

    void presenciaDetalleEmpleado(@Valid final TrabajoDto trabajo) throws Exception;

    void ventaTotalizadaTienda(@Valid final TrabajoDto trabajo, @NotNull final List<TipoTrabajoTiendaDto> tipoTrabajoTienda)
            throws Exception;

    void presenciaTotalizadaTienda(@Valid final TrabajoDto trabajo,
            @NotNull final List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception;

	void ventaTotalizadaTiendaTest(@Valid TrabajoDto trabajo, List<TipoTrabajoTiendaDto> tipoTrabajoTienda)
			throws Exception;

}