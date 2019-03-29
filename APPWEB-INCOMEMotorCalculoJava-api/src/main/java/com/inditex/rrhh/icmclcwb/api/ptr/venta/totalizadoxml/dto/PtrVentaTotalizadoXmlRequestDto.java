package com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizadoxml.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PtrVentaTotalizadoXmlRequestDto implements Serializable {

    private static final long serialVersionUID = -529195772706345954L;

    @ApiModelProperty(value = "Fecha inicio rango de busqueda", required = true, example = "2017-01-01")
    @NotNull
    private String fechaDesde;

    @ApiModelProperty(value = "Fecha fin rango de busqueda", required = true, example = "2017-12-31")
    @NotNull
    private String fechaHasta;

    @ApiModelProperty(value = "Id de pais", required = false, example = "11")
    @NotNull
    private Integer pais;

    @ApiModelProperty(value = "Id cadena", required = false, example = "1")
    @NotNull
    private Integer cadena;

    @ApiModelProperty(value = "Listado de ids de tiendas", required = false, example = "['57', '691']")
    private List<String> tienda = new ArrayList<>();
    
    @ApiModelProperty(value = "Id seccion", required = false, example = "1")
    private Integer seccion;
    
    @ApiModelProperty(value = "Id temporada", required = false, example = "1")
    private Integer temporada;
    
    @ApiModelProperty(value = "Id producto", required = false, example = "1")
    private Integer producto;

    @ApiModelProperty(value = "Agrupación de datos", required = false, example = "FECHA_TIENDA")
    private PtrGroupTypeEnum agrupacion;
    
    

}
