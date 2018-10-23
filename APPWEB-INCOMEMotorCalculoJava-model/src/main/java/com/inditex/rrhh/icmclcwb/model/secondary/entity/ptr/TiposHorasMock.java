package com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
public class TiposHorasMock {

	private Integer id;

	private Integer tienda;

	private Integer seccion;

	private Integer persona;

	private Integer horas;

	private Date fecha;

	private Integer Tipo;
	
	private Integer Origen;

	private Boolean excluidoDenom;
	
	private Boolean excluidoCalculo;
	
}
