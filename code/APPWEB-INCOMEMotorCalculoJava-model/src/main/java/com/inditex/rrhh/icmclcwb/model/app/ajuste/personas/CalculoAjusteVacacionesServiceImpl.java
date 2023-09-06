package com.inditex.rrhh.icmclcwb.model.app.ajuste.personas;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.personas.CalculoAjusteVacacionesService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePoliticasRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteVacacionesRepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculoAjusteVacacionesServiceImpl extends AbstractCalculoAjusteBaseService implements
    CalculoAjusteVacacionesService {

  @Autowired
  private PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

  @Autowired
  private TareaCalculoAjusteVacacionesRepositoryCustom tareaCalculoAjusteVacacionesRepositoryCustom;

  @Override
  protected void precondiciones(final TareaDto tarea,
      final List<IdPersonaLocalDto> personas) {
    this.primaryTemporaryTablePoliticasRepositoryCustom.createTempPersonas();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasVacaciones();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasVacaciones();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoConAjuste();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempPersonas();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempFechasVacaciones();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempFechasAcumuladasVacaciones();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempCalculoConAjuste();
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempPersonas(tarea, personas,
        TipoPoliticaEnum.VACACIONES);
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasVacaciones();
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasVacaciones();
    this.primaryTemporaryTablePoliticasRepositoryCustom
        .insertTempCalculoConAjuste(Collections.singletonList(TipoPoliticaEnum.VACACIONES));
  }

  @Override
  protected void ajustar(final AlgoritmoAjusteDto algoritmoAjuste, final TareaDto tareaDto) {
    this.tareaCalculoAjusteVacacionesRepositoryCustom.ajustar(algoritmoAjuste, tareaDto);
  }

  @Override
  protected void postcondiciones() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempPersonas();
    this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasVacaciones();
    this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasVacaciones();
    this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoConAjuste();
  }

}
