package com.inditex.rrhh.icmclcwb.api.app.calcular.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "Modelo TipoAusenciaDto")
@Data
public class TipoAusenciaDto implements Serializable {

  private static final long serialVersionUID = -5012878405810914326L;

  private Integer id;

  private String icmTpAbsence;

  private String nombre;

}
