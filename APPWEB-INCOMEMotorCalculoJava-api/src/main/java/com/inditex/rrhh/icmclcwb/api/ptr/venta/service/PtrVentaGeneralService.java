package com.inditex.rrhh.icmclcwb.api.ptr.venta.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

public interface PtrVentaGeneralService {

    PtrVentaTotalizadoResponseDto ventaTotalizado(@Valid PtrVentaTotalizadoRequestDto request);

}
