package com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PtrPresenciaTotalTiendaSeccionResponseDto {

	private List<PtrPresenciaTotalTiendaSeccionResultItemDto> presenciasTotalTiendaSeccion;

}