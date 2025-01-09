package com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PtrVentaTotalizadoRequestDto implements Serializable {

  private static final long serialVersionUID = -529195772706345954L;

  @NonNull
  private String fechaDesde;

  @NonNull
  private String fechaHasta;

  @NonNull
  private Integer pais;

  private List<Integer> cadena;

  private List<Integer> tienda = new ArrayList<>();

  private List<Integer> seccion;

  private Integer temporada;

  private List<Integer> producto;

  private List<Integer> empresa;

  private Integer agruparSeccion;

  private PtrGroupTypeEnum agrupacion;

  private String operacion;

}
