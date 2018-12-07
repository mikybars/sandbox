package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Data
public class ProgramacionTiendaDto implements Serializable {

	private static final long serialVersionUID = -5607507260079003307L;

	@ToString.Exclude
	@ApiModelProperty(value = "Identificador", required = false, readOnly = true, hidden = true)
	private String id;

	@ToString.Exclude
	@ApiModelProperty(value = "Programación", required = false, readOnly = true, hidden = true)
	private Long idProgramacion;
	
	@NotBlank
	@ApiModelProperty(value = "Id de la tienda", required = true, example = "56")
	private String idTienda;

}