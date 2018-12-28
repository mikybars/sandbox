package com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PtrPresenciaTotalTiendaRequestDto implements Serializable {

    private static final long serialVersionUID = -6393288223215939223L;

    @ApiModelProperty(value = "Id tienda", required = false, allowableValues = "8102")
    private List<Integer> tienda;

    @ApiModelProperty(value = "Fecha inico Rango", required = false, example = "2018-05-01")
    private String fechaDesde;

    @ApiModelProperty(value = "Fecha fin rango", required = false, example = "2018-10-31")
    private String fechaHasta;
    
    @ApiModelProperty(value = "Id tipo", required = false, example = "1")
    private Integer tipo;

	@ApiModelProperty(value = "Id cadena", required = true, example = " 4 ")
	private Integer cadena;
	
	@NotNull
	@ApiModelProperty(value = "Id origen", required = false, example = "11")
	private Integer origen;


}