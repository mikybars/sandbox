package com.inditex.rrhh.icmclcwb.api.app.calcular.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "Modelo TipoOpcionCalculoDto")
@Data
public class TipoOpcionCalculoDto implements Serializable {

  private static final long serialVersionUID = -3238295465162517018L;

  private String idMeta4;

  private Integer id;

  private String nombre;

}
