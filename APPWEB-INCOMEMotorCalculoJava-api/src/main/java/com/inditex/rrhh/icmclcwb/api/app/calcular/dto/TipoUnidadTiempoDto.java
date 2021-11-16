package com.inditex.rrhh.icmclcwb.api.app.calcular.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "Modelo TipoUnidadTiempoDto")
@Data
public class TipoUnidadTiempoDto implements Serializable {

  private static final long serialVersionUID = 3599996592130837920L;

  private Integer id;

  private String icmIdUnidadTiempo;

  private String nombre;

}
