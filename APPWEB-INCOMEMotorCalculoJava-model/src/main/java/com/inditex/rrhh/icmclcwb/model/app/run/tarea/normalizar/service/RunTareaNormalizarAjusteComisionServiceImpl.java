package com.inditex.rrhh.icmclcwb.model.app.run.tarea.normalizar.service;

/*
 * Copyright (c) 2021. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.normalizar.service.RunTareaNormalizarAjusteComisionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteComisionRepositoryCustom;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaNormalizarAjusteComisionServiceImpl implements RunTareaNormalizarAjusteComisionService {

  @Autowired
  private Logger log;

  @Autowired
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @Autowired
  private TareaCalculoAjusteComisionRepositoryCustom tareaCalculoAjusteComisionRepositoryCustom;

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void normalizarAjusteComision(@Valid final TareaDto tarea) {
    try {
      this.log.info(
          "Tarea[{}] :: Inicio :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: creacion tablas temporales",
          tarea.getId());
      this.primaryTemporaryTableRepositoryCustom.createTempCalculoPorComision();
      this.primaryTemporaryTableRepositoryCustom.createTempCalculoAjusteTotalizado();
      this.log.info(
          "Tarea[{}] :: Fin :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: creacion tablas temporales",
          tarea.getId());
      this.log.info(
          "Tarea[{}] :: Inicio :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: insercion tablas temporales",
          tarea.getId());
      this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoSinComision(tarea);
      this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoPorComision(tarea);
      this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoAjusteTotalizado(tarea);
      this.log.info(
          "Tarea[{}] :: Fin :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: insercion tablas temporales",
          tarea.getId());
      this.log.info(
          "Tarea[{}] :: Inicio :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: normalizar ajuste comision",
          tarea.getId());
      this.tareaCalculoAjusteComisionRepositoryCustom.normalizarAjusteComision(tarea);
      this.log.info(
          "Tarea[{}] :: Fin :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: normalizar ajuste comision",
          tarea.getId());
    } finally {
      this.log.info(
          "Tarea[{}] :: Inicio :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: borrado tablas temporales",
          tarea.getId());
      this.primaryTemporaryTableRepositoryCustom.deleteTempCalculoPorComision();
      this.primaryTemporaryTableRepositoryCustom.deleteTempCalculoAjusteTotalizado();
      this.log.info(
          "Tarea[{}] :: Fin :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: borrado tablas temporales",
          tarea.getId());
    }
  }

}
