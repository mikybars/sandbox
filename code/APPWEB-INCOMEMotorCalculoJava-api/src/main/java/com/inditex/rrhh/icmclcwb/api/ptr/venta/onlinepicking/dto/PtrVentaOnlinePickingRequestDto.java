package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto;

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
public class PtrVentaOnlinePickingRequestDto implements Serializable {

  private static final long serialVersionUID = 7536621533080093360L;

  @NonNull
  private String fechaDesde;

  @NonNull
  private String fechaHasta;

  private Integer pais;

  private List<Integer> cadena;

  private List<Integer> empresa;

  private List<String> tiendaOnline;

  private List<Integer> producto;

  private List<Integer> tienda = new ArrayList<>();

  private List<Integer> seccion;

  private PtrGroupTypeEnum agrupacion;

  private Integer agruparSeccion;

  private Integer ventaPAT;

  private Integer excluirIpod;

}
