package com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto;

import java.io.Serializable;
import java.util.Date;
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
public class PtrPresenciasTotalTiendaRequestDto implements Serializable {

    private static final long serialVersionUID = -6393288223215939223L;

    @ApiModelProperty(value = "Id tienda", required = false, allowableValues = "8102")
    private List<Integer> tiendas;

    @ApiModelProperty(value = "Fecha inico Rango", required = false, example = "2018-05-01")
    private Date fechaDesde;

    @ApiModelProperty(value = "Fecha fin rango", required = false, example = "2018-10-31")
    private Date fechaHasta;
    
    @ApiModelProperty(value = "Id tipo", required = false, example = "1")
    private Integer tipo;

	//TODO: XSD En el XSD viene como simple pero en el Postman funciona con múltiple
	@ApiModelProperty(value = "Id cadena", required = true, allowableValues = " 4 ")
	@NotNull
	private List<Integer> cadena;
	
	@NotNull
	@ApiModelProperty(value = "Id origen", required = false, example = "11")
	private Integer origen;


}