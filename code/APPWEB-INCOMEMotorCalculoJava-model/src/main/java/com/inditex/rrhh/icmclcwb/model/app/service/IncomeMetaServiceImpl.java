package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.IncomeMetaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4RequestDto;

import org.springframework.stereotype.Component;

@Component
public class IncomeMetaServiceImpl implements IncomeMetaService {

  @Override
  public List<IdPersonaLocalExternaDto> getEmpleadosExternosExcluidosDenominador(final ReglaEmpleadoExternoMeta4RequestDto request) {
    return null;
  }
}
