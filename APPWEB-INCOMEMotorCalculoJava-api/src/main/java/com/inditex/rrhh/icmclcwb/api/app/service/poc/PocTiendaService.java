package com.inditex.rrhh.icmclcwb.api.app.service.poc;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocTiendaDto;

public interface PocTiendaService {

	List<PocTiendaDto> findAll();

}