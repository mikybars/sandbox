package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TrabajoEmpleadoHistoricoDto implements Serializable {

	private static final long serialVersionUID = 1168987218682802281L;

	@ApiModelProperty(value = "Identificador del empleado", required = false)
	private String id;

	@NotNull
	@ApiModelProperty(value = "Identificador del trabajo", required = true)
	private Long idTrabajo;

	// TODO CONSTRAINTS El metodo
	// com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeSessionAsyncService.searchEmpleados(SearchEmpleadosRequestDto)
	// devuelve datos nulos
	@NotBlank
	@ApiModelProperty(value = "Id del empleado", required = true)
	private String idEmpleado;

	// TODO CONSTRAINTS El metodo
	// com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeSessionAsyncService.searchEmpleados(SearchEmpleadosRequestDto)
	// devuelve datos nulos
	@NotBlank
	private String orEmpleado;

	// TODO CONSTRAINTS El metodo
	// com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeSessionAsyncService.searchEmpleados(SearchEmpleadosRequestDto)
	// devuelve datos nulos
	@NotBlank
	private String idEmpleadoLocal;

	@NotBlank
	private String idTienda;

	@NotBlank
	private String idTiendaMeta4;

	@NotNull
	private Date fechaInicio;

	@NotNull
	private Date fechaFin;
}
