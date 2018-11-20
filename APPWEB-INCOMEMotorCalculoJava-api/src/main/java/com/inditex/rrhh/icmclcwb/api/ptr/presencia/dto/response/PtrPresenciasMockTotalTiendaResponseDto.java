package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response;

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
public class PtrPresenciasMockTotalTiendaResponseDto {

	@NotNull
	private Integer tienda;

	private Date fecha;

	@NotNull
	private Integer minutos;

}