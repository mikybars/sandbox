package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.FaseService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.FaseMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.FaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class FaseServiceImpl implements FaseService {

  @Autowired
  private FaseRepository faseRepository;

  @Autowired
  private FaseMapper faseMapper;

  @Override
  public List<FaseDto> findAll() {
    return this.faseMapper.faseToFaseDto(this.faseRepository.findAll());
  }

}
