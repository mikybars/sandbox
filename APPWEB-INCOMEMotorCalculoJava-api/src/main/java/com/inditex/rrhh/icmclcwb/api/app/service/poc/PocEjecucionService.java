package com.inditex.rrhh.icmclcwb.api.app.service.poc;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocEjecucionDto;

public interface PocEjecucionService {

	List<PocEjecucionDto> findAll();
	
	PocEjecucionDto createPocEjecucion(@Valid PocEjecucionDto pocEjecucion);

}