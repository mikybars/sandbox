package com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrevalidarPropertiesDto {

  SincronizacionDto sincronizacion;

  private int meses;

}
