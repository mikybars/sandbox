package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto;

/*
 * Copyright (c) 2021. Inditex
 */
import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TiposHoraResponseDto implements Serializable {

  private static final long serialVersionUID = -6831979255668938533L;

  private List<TiposHoraResultItemDto> items;

}
