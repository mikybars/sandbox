package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

import javax.validation.Valid;
import java.util.List;

public interface TareaAgrupacionVentaService {

    void savePtrVentaTotalizadoResponse(
        @Valid final PtrVentaTotalizadoResponseDto dto, @Valid final TareaDto tarea,
        @Valid final List<TareaAgrupacionCadenasDto> agrupaciones);

    void savePtrVentaOnlineEntregaDomicilioResponse(
        @Valid final PtrVentaOnlineEntregaDomicilioResponseDto dto, @Valid final TareaDto tarea,
        @Valid final List<TareaAgrupacionCadenasDto> agrupaciones);

    void updateActivoVentaOnlineEntregaDomicilio(@Valid final TareaDto tarea);
}
