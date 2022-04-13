package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

/*
 * Copyright (c) 2022. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionFallidasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionFallidasService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaFaseAccionFallidasMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaFaseAccionFallidasRepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaFaseAccionFallidasServiceImpl implements TareaFaseAccionFallidasService {

  @Autowired
  private TareaFaseAccionFallidasMapper tareaFaseAccionFallidasMapper;

  @Autowired
  private TareaFaseAccionFallidasRepositoryCustom tareaFaseAccionFallidasRepository;

  /**
   * Guarda en TAREA_FASE_ACCION_FALLIDAS.
   *
   * @param src TareaFaseAccionFallidasDto
   */
  @Override
  public void save(TareaFaseAccionFallidasDto src) {
    this.tareaFaseAccionFallidasRepository.save(
        this.tareaFaseAccionFallidasMapper.tareaFaseAccionFallidasDtoToTareaFaseAccionFallidas(src));
  }
}
