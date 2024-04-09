package com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto;

import java.util.List;

import lombok.Data;

@Data
public class PtrPresenciaEmpleadosTiendaRequestDto {

  private String fechaDesde;

  private String fechaHasta;

  private Integer origen;

  private List<Integer> empresa;

  private List<Integer> cadena;

  private List<Integer> tienda;

  private List<Integer> tipo;

  private Boolean incluidoVenta;

  private Boolean incluidoChallenge;

  private Boolean incluidoEcommerce;

  private Boolean excluidoCalculo;

  private Boolean excluidoDenom;

  private String agrupacion;

}
