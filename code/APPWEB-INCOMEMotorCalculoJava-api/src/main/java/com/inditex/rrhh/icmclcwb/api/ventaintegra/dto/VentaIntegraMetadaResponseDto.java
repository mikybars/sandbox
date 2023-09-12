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
public class VentaIntegraMetadaResponseDto implements Serializable {

  private String self;

  private String apiVersion;

  private String reqTs;

  private String respTs;

  private int queryTimeMs;

  private int countryTic;

  private int groupCompanyTic;

  private String from;

  private String to;

  private List<Integer> storeTicsList;

  private String before;

}
