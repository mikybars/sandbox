package com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PtrPresenciaTotalizadoRequestDto implements Serializable {

  private static final long serialVersionUID = 3550793312992226985L;

  private List<Integer> tienda;

  private String fechaDesde;

  private String fechaHasta;

  private Integer tipo;

  private List<Integer> cadena;

  @NotNull
  private Integer origen;

  private List<Integer> empresa;

  private Boolean incluidoVenta;

  private Boolean incluidoChallenge;

  private Boolean incluidoEcommerce;

  private Boolean excluidoCalculo;

  private Boolean excluidoDenom;

  private String agrupacion;

  private Integer agruparSeccion;

}
