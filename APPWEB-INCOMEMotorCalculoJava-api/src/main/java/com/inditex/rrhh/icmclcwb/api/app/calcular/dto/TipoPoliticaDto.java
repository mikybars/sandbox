package com.inditex.rrhh.icmclcwb.api.app.calcular.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "Modelo TipoPoliticaDto")
@Data
public class TipoPoliticaDto implements Serializable {

  private static final long serialVersionUID = 8374699593681829924L;

  private Integer id;

  private String icmIdTpPolitica;

  private String nombre;

}
