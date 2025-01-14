package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface TareaAgrupacionVentaService {

  void savePtrVentaTotalizadoResponse(
      @Valid @NonNull final PtrVentaTotalizadoResponseDto dto, @Valid @NonNull final TareaDto tarea,
      @Valid @NonNull final List<TareaAgrupacionCadenasDto> agrupaciones);

  void savePtrVentaOnlineEntregaDomicilioResponse(
      @Valid @NonNull final PtrVentaOnlineEntregaDomicilioResponseDto dto, @Valid @NonNull final TareaDto tarea,
      @Valid @NonNull final List<TareaAgrupacionCadenasDto> agrupaciones);

  void updateActivoVentaOnlineEntregaDomicilio(@Valid @NonNull final TareaDto tarea);

}
