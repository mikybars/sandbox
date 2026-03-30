package com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.dto;

/*
 * Copyright (c) 2021. Inditex
 */
import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ResponseDto<T extends DocDto> implements Serializable {

  private static final long serialVersionUID = 2693622743316270172L;

  private List<T> data;

}
