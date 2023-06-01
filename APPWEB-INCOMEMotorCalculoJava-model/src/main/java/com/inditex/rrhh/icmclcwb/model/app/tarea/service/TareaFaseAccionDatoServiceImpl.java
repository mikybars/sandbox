package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionDatoService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaFaseAccionDatoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaFaseAccionDatoRepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaFaseAccionDatoServiceImpl implements TareaFaseAccionDatoService {

  @Autowired
  private TareaFaseAccionDatoMapper tareaFaseAccionDatoMapper;

  @Autowired
  private TareaFaseAccionDatoRepositoryCustom tareaFaseAccionDatoRepository;

  /**
   * Guarda en TAREA_FASE_ACCION_DATO.
   *
   * @param src TareaFaseAccionDatoDto
   */
  @Override
  public void save(final List<TareaFaseAccionDatoDto> src) {
    this.tareaFaseAccionDatoRepository.save(
        this.tareaFaseAccionDatoMapper.tareaFaseAccionDatoDtoToTareaFaseAccionDato(src));
  }
}
