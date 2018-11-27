package com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PtrPresenciasDetalleComisionableResponseDto {

    private List<PtrPresenciasDetalleComisionableResultItemDto> list;

}
