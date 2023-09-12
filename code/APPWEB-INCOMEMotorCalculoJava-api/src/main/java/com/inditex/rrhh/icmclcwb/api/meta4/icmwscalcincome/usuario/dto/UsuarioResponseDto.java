package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto;

/*
 * Copyright (c) 2022. Inditex
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
public class UsuarioResponseDto implements Serializable {

  private static final long serialVersionUID = -7166368486143869135L;

  private List<UsuarioResultItemDto> items;

}
