package com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto;

/*
 * Copyright (c) 2021. Inditex
 */
import java.io.Serializable;

import lombok.Data;

@Data
public class RootDto<T extends DocDto> implements Serializable {

  private static final long serialVersionUID = -3392099918205482681L;

  private ResponseHeaderDto responseHeader;

  private ResponseDto<T> response;

}
