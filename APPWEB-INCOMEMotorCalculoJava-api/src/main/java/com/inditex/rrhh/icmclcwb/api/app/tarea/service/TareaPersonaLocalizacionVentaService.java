package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaLocalizacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;

public interface TareaPersonaLocalizacionVentaService {

    List<TareaPersonaLocalizacionVentaDto> savePtrVentaOnlineIpodIndividualDetalleResponse(
            PtrVentaOnlineIpodIndividualDetalleResponseDto dto, @Valid TareaDto tarea);

    List<TareaPersonaLocalizacionVentaDto> savePtrVentaIndividualDetalleResponseDto(
            PtrVentaIndividualDetalleResponseDto dto, @Valid TareaDto tarea);

}
