package com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SeccionPresenciasDetalleComisionableType {

    private Integer seccion;

    private Long minutos;

}
