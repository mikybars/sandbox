package com.inditex.rrhh.icmclcwb.api.app.dto.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inditex.rrhh.icmclcwb.api.app.util.Constants;

import lombok.Data;

@Data
public class RelojDto {

	private LocalDate fecha = LocalDate.now();

	private LocalTime hora = LocalTime.now();

	private LocalDateTime fechaHora = LocalDateTime.now();

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.LOCAL_TIME_JSON)
	private LocalTime horaFormat = LocalTime.now();

}