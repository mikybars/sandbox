package com.inditex.rrhh.icmclcwb.api.app.calcular.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class AlgoritmoDto implements Serializable {

  private static final long serialVersionUID = -8045541542256497791L;

  private Integer id;

  private Boolean activo;

  private Boolean desplazamiento;

  private Boolean desplazamientoBase;

  private String nombre;

  private List<TipoComisionDto> tipoComision;

  private List<TipoCalculoDto> tipoCalculo;

  private List<TipoDatoDto> tipoDato;

}
