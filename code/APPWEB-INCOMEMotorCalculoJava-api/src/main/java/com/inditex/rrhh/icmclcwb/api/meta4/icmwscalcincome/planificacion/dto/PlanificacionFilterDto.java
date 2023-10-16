package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanificacionFilterDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private List<PlanificacionFilterParametersDto> items;

}
