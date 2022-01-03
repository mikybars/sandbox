package com.inditex.rrhh.icmclcwb.api.app.calcular.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "Modelo TipoPresupuestoDto")
@Data
public class TipoPresupuestoDto implements Serializable {

  private static final long serialVersionUID = 1964919709143020545L;

  private Integer id;

  private String icmIdTpPresupuesto;

  private String nombre;

  private String descripcion;

}
