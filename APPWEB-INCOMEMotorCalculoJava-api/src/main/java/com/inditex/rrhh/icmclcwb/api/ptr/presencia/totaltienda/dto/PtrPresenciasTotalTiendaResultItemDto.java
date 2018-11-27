package com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto;

import java.util.Date;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PtrPresenciasTotalTiendaResultItemDto {

	@NotNull
	private Integer tienda;

	private Date fecha;

	@NotNull
	private Integer minutos;

}