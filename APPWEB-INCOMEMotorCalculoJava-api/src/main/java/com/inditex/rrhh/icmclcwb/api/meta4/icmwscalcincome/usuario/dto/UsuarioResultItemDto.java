package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto;

/*
 * Copyright (c) 2022. Inditex
 */
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioResultItemDto implements Serializable {

  private static final long serialVersionUID = -3179919492448337966L;

  private String mail;

  private String idUsuario;

}
