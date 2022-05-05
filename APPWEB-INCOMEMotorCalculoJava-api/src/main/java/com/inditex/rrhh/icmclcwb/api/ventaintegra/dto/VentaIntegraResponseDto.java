package com.inditex.rrhh.icmclcwb.api.ventaintegra.dto;

/*
 * Copyright (c) 2022. Inditex
 */
import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class VentaIntegraResponseDto implements Serializable {

  private VentaIntegraMetadaResponseDto metadata;

  private VentaIntegraStatisticsResponseDto statistics;

  private List<VentaIntegraDataResponseDto> data;

}
