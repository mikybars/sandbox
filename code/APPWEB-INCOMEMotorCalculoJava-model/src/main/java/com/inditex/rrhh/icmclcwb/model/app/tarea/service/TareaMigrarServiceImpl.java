package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaMigrarService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaMigrarComisionRepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaMigrarServiceImpl implements TareaMigrarService {

  @Autowired
  private TareaMigrarComisionRepositoryCustom tareaMigrarComisionRepositoryCustom;

  @Override
  public List<TareaMigrarComisionDto> findCalculoComisionByTareaActual(TareaDto tarea) {
    return this.tareaMigrarComisionRepositoryCustom.findCalculoComisionByTareaActual(tarea);
  }
}
