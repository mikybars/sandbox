package com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PtrPresenciaDetalleResponseDto {

    private List<PtrPresenciaDetalleResultItemDto> presenciasDetalle;

}
