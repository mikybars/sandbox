package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPersonaVentaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;

public interface TareaLocalizacionPersonaVentaService {

    List<TareaLocalizacionPersonaVentaDto> savePtrVentaOnlineIpodIndividualDetalleResponse(
            @Valid final PtrVentaOnlineIpodIndividualDetalleResponseDto dto, @Valid final TareaDto tarea);

    List<TareaLocalizacionPersonaVentaDto> savePtrVentaIndividualDetalleResponseDto(
            @Valid final PtrVentaIndividualDetalleResponseDto dto, @Valid final TareaDto tarea);

}
