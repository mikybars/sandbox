package com.inditex.rrhh.icmclcwb.api.ptr.presencia.service;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResponseDto;

import jakarta.validation.Valid;

public interface PtrPresenciaService {

  PtrPresenciaDetalleResponseDto presenciasDetalle(@Valid final PtrPresenciaDetalleRequestDto request);

  PtrPresenciaTiposHorasResponseDto tiposHoras(@Valid final PtrPresenciaTiposHorasRequestDto request);

  PtrPresenciaTiendasEmpleadoResponseDto presenciasTiendasEmpleado(
      @Valid final PtrPresenciaTiendasEmpleadoRequestDto request);

  PtrPresenciaTotalizadoResponseDto presenciasTotalizado(@Valid final PtrPresenciaTotalizadoRequestDto request);

  PtrPresenciaEmpleadosTiendaResponseDto presenciasEmpleadosTienda(
      @Valid final PtrPresenciaEmpleadosTiendaRequestDto request);

}
