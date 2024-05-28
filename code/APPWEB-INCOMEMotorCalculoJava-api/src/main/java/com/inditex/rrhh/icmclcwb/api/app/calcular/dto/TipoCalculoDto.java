package com.inditex.rrhh.icmclcwb.api.app.calcular.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TipoCalculoDto implements Serializable {

  private static final long serialVersionUID = -5773205858357489594L;

  private String id;

}
