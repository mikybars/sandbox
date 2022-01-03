package com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto;

/*
 * Copyright (c) 2021. Inditex
 */
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseHeaderDto implements Serializable {

  private static final long serialVersionUID = 2532481813163215854L;

  private boolean zkConnected;

  private int status;

  @JsonProperty("QTime")
  private int qtime;

  private ParamsDto params;

}
