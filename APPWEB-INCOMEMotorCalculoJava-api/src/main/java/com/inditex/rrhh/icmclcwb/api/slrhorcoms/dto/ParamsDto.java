/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ParamsDto implements Serializable {

    private static final long serialVersionUID = 2532481813163215854L;

    private String q;

    private String rows;

    private String wt;

}
