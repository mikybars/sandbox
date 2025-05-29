package com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SincronizacionDto {

  private int maxEmpleados;

  private boolean activo;

}
