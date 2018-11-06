package com.inditex.rrhh.icmclcwb.model.app.service.poc;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocPeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.poc.PocPeriodoService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.poc.PocPeriodoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.poc.PocPeriodoRepository;

@Service
@Validated
public class PocPeriodoServiceImpl implements PocPeriodoService {

	@Autowired
	private PocPeriodoRepository pocPeriodoRepository;

	@Autowired
	private PocPeriodoMapper pocPeriodoMapper;

	@Override
	public List<PocPeriodoDto> findAll() {
		return pocPeriodoMapper.pocPeriodoToPocPeriodoDto(pocPeriodoRepository.findAll());
	}

}