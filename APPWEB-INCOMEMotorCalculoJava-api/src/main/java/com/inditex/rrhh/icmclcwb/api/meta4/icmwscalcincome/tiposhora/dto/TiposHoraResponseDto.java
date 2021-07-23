/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TiposHoraResponseDto implements Serializable {

    private static final long serialVersionUID = -6831979255668938533L;

    private List<TiposHoraResultItemDto> items;

}
