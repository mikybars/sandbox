package com.inditex.rrhh.icmclcwb.api.app.dto;

/*
 * Copyright (c) 2022. Inditex
 */
import java.io.Serializable;

import lombok.Data;

@Data
public class VentaIntegraStatisticsResponseDto implements Serializable {

  private int totalStoresOK;

  private int totalStoresKO;

}
