package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@XmlRootElement(name = "ventaOnlineTiendaRequest")
@XmlAccessorType(XmlAccessType.NONE)
@Data
public class PtrVentaOnlinePickingRequestDto implements Serializable {

  private static final long serialVersionUID = 7536621533080093360L;

  @ApiModelProperty(value = "Fecha inicio rango de busqueda", required = true, example = "2017-01-01")
  @XmlElement(name = "fechaDesde")
  @NotNull
  private String fechaDesde;

  @ApiModelProperty(value = "Fecha fin rango de busqueda", required = true, example = "2017-12-31")
  @XmlElement(name = "fechaHasta")
  @NotNull
  private String fechaHasta;

  @ApiModelProperty(value = "Id de pais", required = false, example = "11")
  @XmlElement(name = "pais")
  private Integer pais;

  @ApiModelProperty(value = "Id cadena", required = false, example = "1")
  @XmlElement(name = "cadena")
  private List<Integer> cadena;

  @ApiModelProperty(value = "Id empresa", required = false, example = "1")
  @XmlElement(name = "empresa")
  private List<Integer> empresa;

  @ApiModelProperty(value = "Listado de ids de tiendas online", required = false, example = "['4091', '9724']")
  @XmlElement(name = "tiendaOnline")
  private List<String> tiendaOnline;

  @ApiModelProperty(value = "Listado de ids de producto", required = false, example = "[1,2,3]")
  @XmlElement(name = "producto")
  private List<Integer> producto;

  @ApiModelProperty(value = "Listado de ids de tiendas", required = false, example = "['57', '691']")
  @XmlElement(name = "tienda")
  private List<Integer> tienda = new ArrayList<>();

  @ApiModelProperty(value = "Id seccion", required = false, example = "1")
  @XmlElement(name = "seccion")
  private List<Integer> seccion;

  @ApiModelProperty(value = "Agrupación de datos", required = false, example = "FECHA_TIENDA")
  @XmlElement(name = "agrupacion")
  private PtrGroupTypeEnum agrupacion;

  @ApiModelProperty(value = "Agrupar seccion flag (pivotado)", required = false, example = "1")
  @XmlElement(name = "agruparSeccion")
  private Integer agruparSeccion;

  @ApiModelProperty(value = "Flag ventaPAT (includo/excluido)", required = false, example = "1")
  @XmlElement(name = "ventaPAT")
  private Integer ventaPAT;

  @ApiModelProperty(value = "Flag excluido ipod (excluido/incluido)", required = false, example = "0")
  @XmlElement(name = "excluirIpod")
  private Integer excluirIpod;

}
