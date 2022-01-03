package com.inditex.rrhh.icmclcwb.api.app.validar.properties.dto;

import lombok.Data;

@Data
public class ValidarPropertiesDto {

  boolean enabled;

  boolean logging;

  boolean exception;

  int threadSize;

}
