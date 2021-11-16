package com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto;

/*
 * Copyright (c) 2021. Inditex
 */
import java.io.Serializable;

import lombok.Data;

@Data
public abstract class SlrhorcomsPageRequestDto implements Serializable {

  private static final long serialVersionUID = -3226737743371414553L;

  private Integer rows;

  private Integer start;

}
