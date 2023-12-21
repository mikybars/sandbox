package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4Dto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4RequestDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.ReglaEmpleadoExternoMeta4Service;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.ReglaEmpleadoExternoMeta4Mapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.ReglaEmpleadoExternoMeta4RepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReglaEmpleadoExternoMeta4ServiceImpl implements ReglaEmpleadoExternoMeta4Service {

  @Autowired
  private ReglaEmpleadoExternoMeta4RepositoryCustom reglaEmpleadoExternoMeta4RepositoryCustom;

  @Autowired
  private ReglaEmpleadoExternoMeta4Mapper reglaEmpleadoExternoMeta4Mapper;

  @Override
  public ReglaEmpleadoExternoMeta4RequestDto getReglasEmpleadoExternoMeta4ActivasByCclIdOrigen(final String cclIdOrigen,
      final String stdIdLegEnt) {
    final List<ReglaEmpleadoExternoMeta4Dto> reglas = this.reglaEmpleadoExternoMeta4RepositoryCustom
        .findReglasEmpleadoExternoMeta4ActivasByCclIdOrigen(cclIdOrigen, stdIdLegEnt);

    return this.reglaEmpleadoExternoMeta4Mapper.reglaEmpleadoExternoMeta4DtoListToReglaEmpleadoExternoMeta4RequestDto(reglas);
  }
}
