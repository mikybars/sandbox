package com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto;

/*
 * Copyright (c) 2021. Inditex
 */
import java.io.Serializable;

import lombok.Data;

@Data
public class ParamsDto implements Serializable {

  private static final long serialVersionUID = 2532481813163215854L;

  private String qq;

  private String rows;

  private String wt;

}
