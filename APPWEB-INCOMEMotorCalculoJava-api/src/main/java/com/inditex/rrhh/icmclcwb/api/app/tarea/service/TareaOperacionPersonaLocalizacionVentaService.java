package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaOperacionPersonaLocalizacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;

public interface TareaOperacionPersonaLocalizacionVentaService {

    List<TareaOperacionPersonaLocalizacionVentaDto> savePtrVentaIndividualDetalleResponse(
            @Valid final PtrVentaIndividualDetalleResponseDto dto, @Valid final TareaDto tarea);

}
