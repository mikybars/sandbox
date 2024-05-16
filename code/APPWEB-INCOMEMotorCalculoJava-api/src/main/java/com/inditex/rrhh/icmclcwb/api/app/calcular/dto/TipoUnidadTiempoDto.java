package com.inditex.rrhh.icmclcwb.api.app.calcular.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TipoUnidadTiempoDto implements Serializable {

  private static final long serialVersionUID = 3599996592130837920L;

  private Integer id;

  private String icmIdUnidadTiempo;

  private String nombre;

}
