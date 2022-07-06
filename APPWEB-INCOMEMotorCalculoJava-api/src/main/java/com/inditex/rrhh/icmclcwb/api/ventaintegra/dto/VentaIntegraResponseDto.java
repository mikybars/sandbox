package com.inditex.rrhh.icmclcwb.api.ventaintegra.dto;

/*
 * Copyright (c) 2022. Inditex
 */
import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VentaIntegraResponseDto implements Serializable {

  private VentaIntegraMetadaResponseDto metadata;

  private VentaIntegraStatisticsResponseDto statistics;

  private List<VentaIntegraDataResponseDto> data;

}
