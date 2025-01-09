package com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PtrPresenciaTiendasEmpleadoRequestDto {

  private String fechaDesde;

  private String fechaHasta;

  @NonNull
  private Integer origen;

  private List<Integer> cadena;

  private List<Integer> empresa;

  private List<Integer> persona;

  private List<Integer> tipo;

  private Boolean incluidoVenta;

  private Boolean incluidoChallenge;

  private Boolean incluidoEcommerce;

  private Boolean excluidoCalculo;

  private Boolean excluidoDenom;

  private String agrupacion;

}
