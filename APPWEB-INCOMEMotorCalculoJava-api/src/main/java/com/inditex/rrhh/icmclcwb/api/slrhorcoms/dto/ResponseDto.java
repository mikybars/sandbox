/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ResponseDto<T extends DocDto> implements Serializable {

    private static final long serialVersionUID = 2693622743316270172L;

    private int numFound;

    private int start;

    private List<T> docs;

}
