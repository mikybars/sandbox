package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel 
public class PresenciasTotalTiendaSeccionRequestDto {

	@ApiModelProperty(value = "Id tiendaSeccion (en esta lista puedes completar con tienda = 52 y seccion = 2; o con la tienda 150)", required = false)
	private List<TiendaSeccionDto> tiendaSeccion;

	@ApiModelProperty(value = "Fecha inicio rango", required = false, example = "2016-01-01")
	private Date fechaDesde;

	@ApiModelProperty(value = "Fecha fin rango", required = false, example = "2016-02-31")
	private Date fechaHasta;

	@ApiModelProperty(value = "Id tipo hora", required = false, example = "1")
	private Integer tipo;

	@ApiModelProperty(value = "Id cadena", required = true, example = " 1 ")
	@NotNull
	private List<Integer> cadena;

	@ApiModelProperty(value = "Id origen", required = false, example = "11")
	private Integer origen;

}