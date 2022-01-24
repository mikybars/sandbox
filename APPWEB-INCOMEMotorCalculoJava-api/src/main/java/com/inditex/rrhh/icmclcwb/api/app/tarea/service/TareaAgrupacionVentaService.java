package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface TareaAgrupacionVentaService {

  void savePtrVentaTotalizadoResponse(
      @Valid @NotNull final PtrVentaTotalizadoResponseDto dto, @Valid @NotNull final TareaDto tarea,
      @Valid @NotNull final List<TareaAgrupacionCadenasDto> agrupaciones);

  void savePtrVentaOnlineEntregaDomicilioResponse(
      @Valid @NotNull final PtrVentaOnlineEntregaDomicilioResponseDto dto, @Valid @NotNull final TareaDto tarea,
      @Valid @NotNull final List<TareaAgrupacionCadenasDto> agrupaciones);

  void updateActivoVentaOnlineEntregaDomicilio(@Valid @NotNull final TareaDto tarea);

}
