package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PtrVentaOnlineEntregaDomicilioRequestDto implements Serializable {

  private static final long serialVersionUID = 233324946532771844L;

  @NotNull
  private String fechaDesde;

  @NotNull
  private String fechaHasta;

  private Integer pais;

  private List<Integer> cadena;

  private List<Integer> empresa;

  private List<Integer> tiendaOnline = new ArrayList<>();

  private List<Integer> producto = new ArrayList<>();

  private Integer seccion;

  private PtrGroupTypeEnum agrupacion;

  private Integer agruparSeccion;

}
