package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto;

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
public class PtrVentaOnlineIpodRequestDto implements Serializable {

  private static final long serialVersionUID = -621566192491672941L;

  @NonNull
  private String fechaDesde;

  @NonNull
  private String fechaHasta;

  private Integer pais;

  private List<Integer> cadena;

  private List<Integer> empresa;

  private List<Integer> tiendaOnline = new ArrayList<>();

  private List<Integer> producto = new ArrayList<>();

  private List<Integer> tienda = new ArrayList<>();

  private List<Integer> seccion;

  private PtrGroupTypeEnum agrupacion;

  private Integer agruparSeccion;

  // @ApiModelProperty(value = "Flag ventaPAT (includo/excluido)", required = false, example = "1")
  // @XmlElement(name = "ventaPAT")
  // private Integer ventaPAT;

}
