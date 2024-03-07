package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReglaEmpleadoExternoMeta4RequestDto {

  private String idOrganization;

  private List<Integer> puestos;

}
