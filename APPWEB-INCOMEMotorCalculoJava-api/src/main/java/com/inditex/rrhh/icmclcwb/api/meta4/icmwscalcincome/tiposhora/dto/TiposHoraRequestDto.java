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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TiposHoraRequestDto implements Serializable {

  private static final long serialVersionUID = -947192660099861683L;

  private String idOrigen;

  private List<String> idsEmpresa;

}
