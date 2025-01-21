package com.inditex.rrhh.icmclcwb.model.app.run.tarea.normalizar.service;

/*
 * Copyright (c) 2021. Inditex
 */

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.normalizar.service.RunTareaNormalizarAjusteComisionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteComisionRepositoryCustom;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaNormalizarAjusteComisionServiceImpl implements RunTareaNormalizarAjusteComisionService {

  private static final Logger LOG = LoggerFactory.getLogger(RunTareaNormalizarAjusteComisionServiceImpl.class);

  private final PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  private final TareaCalculoAjusteComisionRepositoryCustom tareaCalculoAjusteComisionRepositoryCustom;

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void normalizarAjusteComision(@Valid final TareaDto tarea) {
    try {
      RunTareaNormalizarAjusteComisionServiceImpl.LOG.info(
          "Tarea[{}] :: Inicio :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: creacion tablas temporales",
          tarea.getId());
      this.primaryTemporaryTableRepositoryCustom.createTempCalculoPorComision();
      this.primaryTemporaryTableRepositoryCustom.createTempCalculoAjusteTotalizado();
      RunTareaNormalizarAjusteComisionServiceImpl.LOG.info(
          "Tarea[{}] :: Fin :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: creacion tablas temporales",
          tarea.getId());
      RunTareaNormalizarAjusteComisionServiceImpl.LOG.info(
          "Tarea[{}] :: Inicio :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: insercion tablas temporales",
          tarea.getId());
      this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoSinComision(tarea);
      this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoPorComision(tarea);
      this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoAjusteTotalizado(tarea);
      RunTareaNormalizarAjusteComisionServiceImpl.LOG.info(
          "Tarea[{}] :: Fin :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: insercion tablas temporales",
          tarea.getId());
      RunTareaNormalizarAjusteComisionServiceImpl.LOG.info(
          "Tarea[{}] :: Inicio :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: normalizar ajuste comision",
          tarea.getId());
      this.tareaCalculoAjusteComisionRepositoryCustom.normalizarAjusteComision(tarea);
      RunTareaNormalizarAjusteComisionServiceImpl.LOG.info(
          "Tarea[{}] :: Fin :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: normalizar ajuste comision",
          tarea.getId());
    } finally {
      RunTareaNormalizarAjusteComisionServiceImpl.LOG.info(
          "Tarea[{}] :: Inicio :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: borrado tablas temporales",
          tarea.getId());
      this.primaryTemporaryTableRepositoryCustom.deleteTempCalculoPorComision();
      this.primaryTemporaryTableRepositoryCustom.deleteTempCalculoAjusteTotalizado();
      RunTareaNormalizarAjusteComisionServiceImpl.LOG.info(
          "Tarea[{}] :: Fin :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: borrado tablas temporales",
          tarea.getId());
    }
  }

}
