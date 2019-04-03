package com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class PtrPresenciaTiendasEmpleadoRequestDto {

    @ApiModelProperty(value = "Fecha inicio rango", required = false, example = "2018-01-01")
    private String fechaDesde;

    @ApiModelProperty(value = "Fecha fin rango", required = false, example = "2018-10-31")
    private String fechaHasta;

    @NotNull
    @ApiModelProperty(value = "Id origen", required = true, example = "11")
    private Integer origen;  
    
    @ApiModelProperty(value = "Id cadena", required = false, allowableValues = "8")
    private List<Integer> cadena;
    
    @ApiModelProperty(value = "Id empresa", required = false, allowableValues = "1000")
    private List<Integer> empresa;
    
    @ApiModelProperty(value = "Id persona", required = false, allowableValues = "1000")
    private List<Integer> persona;
    
    @ApiModelProperty(value = "Tipo", required = false, allowableValues = "1")
    private List<Integer> tipo;
    
    @ApiModelProperty(value = "Agrupacion", required = false, allowableValues = "TIENDA, TIENDA_PERSONA")
    private String agrupacion;
}
