package com.inditex.rrhh.icmclcwb.api.app.dto.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;

@Data
public class RelojDto {

	private LocalDate fecha = LocalDate.now();

	private LocalTime hora = LocalTime.now();

	private LocalDateTime fechaHora = LocalDateTime.now();

}