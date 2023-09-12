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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDto implements Serializable {

  private static final long serialVersionUID = -5065653723179964512L;

  private String idUsuario;
}
