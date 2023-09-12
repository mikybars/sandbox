package com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PtrPresenciaEmpleadosTiendaResponseDto {

  private List<PtrPresenciaEmpleadosTiendaResultItemDto> presenciasTiendasEmpleado;

}
