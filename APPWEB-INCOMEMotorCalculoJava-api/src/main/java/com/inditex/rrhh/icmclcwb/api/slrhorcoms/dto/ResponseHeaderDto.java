/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseHeaderDto implements Serializable {

    private static final long serialVersionUID = 2532481813163215854L;

    private boolean zkConnected;

    private int status;

    @JsonProperty("QTime")
    private int qTime;

    private ParamsDto params;

}
