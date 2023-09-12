package com.inditex.rrhh.icmclcwb.api.ptr.venta.service;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

import javax.validation.Valid;

public interface PtrVentaGeneralService {

  PtrVentaTotalizadoResponseDto ventaTotalizado(@Valid PtrVentaTotalizadoRequestDto request);

}
