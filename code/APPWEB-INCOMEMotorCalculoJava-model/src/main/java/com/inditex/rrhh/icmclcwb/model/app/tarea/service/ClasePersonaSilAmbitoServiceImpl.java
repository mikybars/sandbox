package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ClasePersonaSilAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.ClasePersonaSilAmbitoService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.ClasePersonaSilAmbitoRepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClasePersonaSilAmbitoServiceImpl implements ClasePersonaSilAmbitoService {

  @Autowired
  private ClasePersonaSilAmbitoRepositoryCustom clasePersonaSilAmbitoRepositoryCustom;

  @Override
  public List<ClasePersonaSilAmbitoDto> getClaseAndEstadoByCclIdOrigenAndStdIdLegEnt(final String cclIdOrigen, final String stdIdLegEnt) {
    return this.clasePersonaSilAmbitoRepositoryCustom.findClaseEstadoByCclIdOrigenAndStdIdLegEnt(cclIdOrigen, stdIdLegEnt);
  }
}
