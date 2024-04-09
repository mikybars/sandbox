package com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PtrPresenciaDetalleRequestDto implements Serializable {

  private static final long serialVersionUID = 2089515262512038387L;

  private List<Integer> tienda;

  private Integer seccion;

  private List<Integer> persona;

  private String fechaDesde;

  private String fechaHasta;

  private List<Integer> tipo;

  private List<Integer> cadena;

  private List<Integer> empresa;

  private Integer origen;

  private Boolean incluidoVenta;

  private Boolean incluidoChallenge;

  private Boolean incluidoEcommerce;

  private Boolean excluidoDenom;

  private Boolean excluidoCalculo;

  private String agrupacion;

  private Integer agruparSeccion;

}
