package com.inditex.rrhh.icmclcwb.model.app.service.poc;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.poc.PocTiendaService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.poc.PocTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.poc.PocTiendaRepository;

@Service
@Validated
public class PocTiendaServiceImpl implements PocTiendaService {

	@Autowired
	private PocTiendaRepository pocTiendaRepository;

	@Autowired
	private PocTiendaMapper pocTiendaMapper;

	@Override
	public List<PocTiendaDto> findAll() {
		return pocTiendaMapper.pocTiendaToPocTiendaDto(pocTiendaRepository.findAll());
	}

}