package com.inditex.rrhh.icmclcwb.api.ventaintegra.dto;

/*
 * Copyright (c) 2022. Inditex
 */
import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VentaIntegraStatisticsResponseDto implements Serializable {

  private int totalStoresOK;

  private int totalStoresKO;

}
