package com.inditex.rrhh.icmclcwb.api.app.calcular.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TipoVentaConceptoDto implements Serializable {

  private static final long serialVersionUID = 2189398182822927590L;

  private Long id;

  private String icmIdConceptoVenta;

  private String nombre;

  private String descripcion;

}
