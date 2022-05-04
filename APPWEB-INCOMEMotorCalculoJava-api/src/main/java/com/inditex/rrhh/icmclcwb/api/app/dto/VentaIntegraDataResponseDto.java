package com.inditex.rrhh.icmclcwb.api.app.dto;

/*
 * Copyright (c) 2022. Inditex
 */
import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class VentaIntegraDataResponseDto implements Serializable {

  private int storeTic;

  private List<String> errorDates;

}
