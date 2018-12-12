package com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTiendaSeccionDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description="Para GHRS: cadena=6, tienda=7446, seccion 1"
		+ "  Para Espana:tienda=52, seccion=2")
public class PtrPresenciaTotalTiendaSeccionRequestDto {

	@ApiModelProperty(value = "Id tiendaSeccion (en esta lista puedes completar con tienda = 52 y seccion = 2; o con la tienda 150)", required = false)
	private List<PtrPresenciaTiendaSeccionDto> tiendaSeccion;

	@ApiModelProperty(value = "Fecha inicio rango", required = false, example = "2018-01-01")
	private Date fechaDesde;

	@ApiModelProperty(value = "Fecha fin rango", required = false, example = "2018-10-31")
	private Date fechaHasta;

	@ApiModelProperty(value = "Id tipo hora", required = false, example = "1")
	private Integer tipo;

	//TODO: XSD En el XSD viene como simple pero en el Postman funciona con múltiple
	@ApiModelProperty(value = "Id cadena", required = true, allowableValues = " 1 ")
	@NotNull
	@NotEmpty
	private List<Integer> cadena;

	@NotNull
	@ApiModelProperty(value = "Id origen", required = false, example = "11")
	private Integer origen;

}