package com.inditex.rrhh.icmclcwb.api.app.dto.poc;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PocPeriodoDto implements Serializable {

	private static final long serialVersionUID = 5142944763830707458L;

	private String id;

	@NotNull
	private LocalDateTime fechaInicioPeriodo;

	@NotNull
	private LocalDateTime fechaFinPeriodo;

}