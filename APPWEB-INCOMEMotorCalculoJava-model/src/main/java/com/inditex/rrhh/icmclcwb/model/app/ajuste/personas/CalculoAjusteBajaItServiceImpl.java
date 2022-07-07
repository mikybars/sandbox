package com.inditex.rrhh.icmclcwb.model.app.ajuste.personas;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.personas.CalculoAjusteBajaItService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePoliticasRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteBajaItRepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculoAjusteBajaItServiceImpl extends AbstractCalculoAjusteBaseService implements
    CalculoAjusteBajaItService {

  @Autowired
  private PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

  @Autowired
  private TareaCalculoAjusteBajaItRepositoryCustom tareaCalculoAjusteBajaItRepositoryCustom;

  @Override
  protected void precondiciones(final TareaDto tarea,
      final List<IdPersonaLocalDto> personas) {

    this.primaryTemporaryTablePoliticasRepositoryCustom.createTempPersonas();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempPersonas();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasBajaIt();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempFechasBajaIt();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasBajaIt();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempFechasAcumuladasBajaIt();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoConAjuste();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempCalculoConAjuste();
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempPersonasBajaIt(tarea, personas,
        TipoPoliticaEnum.BAJA_IT);
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(tarea);
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasBajaIt();
    this.primaryTemporaryTablePoliticasRepositoryCustom
        .insertTempCalculoConAjusteBajaIt(Collections.singletonList(TipoPoliticaEnum.ANTIGUEDAD));
  }

  @Override
  protected void ajustar(final AlgoritmoAjusteDto algoritmoAjuste, final TareaDto tareaDto) {
    this.tareaCalculoAjusteBajaItRepositoryCustom.ajustar(algoritmoAjuste, tareaDto);
  }

  @Override
  protected void postcondiciones() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempPersonas();
    this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasBajaIt();
    this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasBajaIt();
    this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoConAjuste();
  }

}
