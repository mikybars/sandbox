package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.FaseAccionService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.FaseAccionRepositoryCustom;

import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class FaseAccionServiceImpl implements FaseAccionService {

  @Autowired
  private FaseAccionRepositoryCustom faseAccionRepositoryCustom;

  @Override
  public List<FaseAccionDto> findByIdFase(@NonNull @Positive final Integer idFase) {
    return this.faseAccionRepositoryCustom.findByIdFase(idFase);
  }

}
