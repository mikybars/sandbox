package com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PtrPresenciaTiendasEmpleadoResponseDto {

    private List<PtrPresenciaTiendasEmpleadoResultItemDto> presenciasTiendasEmpleado;

}
