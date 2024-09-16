package com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class RecolectarPropertiesDto {

  @Min(0)
  private Integer daysNumber = 0;

}
