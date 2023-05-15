package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionVentaIntegraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionVentaIntegraService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaFaseAccionVentaIntegraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaFaseAccionVentaIntegraRepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaFaseAccionVentaIntegraServiceImpl implements TareaFaseAccionVentaIntegraService {

  @Autowired
  private TareaFaseAccionVentaIntegraMapper tareaFaseAccionVentaIntegraMapper;

  @Autowired
  private TareaFaseAccionVentaIntegraRepositoryCustom tareaFaseAccionVentaIntegraRepository;

  /**
   * Guarda en TAREA_FASE_ACCION_VENTA_INTEGRA.
   *
   * @param src TareaFaseAccionVentaIntegraDto
   */
  @Override
  public void save(final List<TareaFaseAccionVentaIntegraDto> src) {
    this.tareaFaseAccionVentaIntegraRepository.save(
        this.tareaFaseAccionVentaIntegraMapper.tareaFaseAccionVentaIntegraDtoToTareaFaseAccionVentaIntegra(src));
  }

}
