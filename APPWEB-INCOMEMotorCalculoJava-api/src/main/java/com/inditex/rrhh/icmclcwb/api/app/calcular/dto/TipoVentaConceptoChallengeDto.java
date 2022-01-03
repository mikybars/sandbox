package com.inditex.rrhh.icmclcwb.api.app.calcular.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "Modelo TipoVentaConceptoChallengeDto")
@Data
public class TipoVentaConceptoChallengeDto implements Serializable {

  private static final long serialVersionUID = -1442619013808761570L;

  private Long id;

  private String nombre;

  private String descripcion;

  private String icmIdConceptoVenta;

}
