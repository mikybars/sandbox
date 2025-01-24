package com.inditex.rrhh.icmclcwb.model.app.ajuste.personas;

import java.util.List;

/*
 * Copyright (c) 2021. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.ajuste.personas.CalculoAjusteCarenciaService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePoliticasRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteCarenciaRepositoryCustom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculoAjusteCarenciaServiceImpl extends AbstractCalculoAjusteBaseService implements
    CalculoAjusteCarenciaService {

  private final PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

  private final TareaCalculoAjusteCarenciaRepositoryCustom tareaCalculoAjusteCarenciaRepositoryCustom;

  @Override
  protected void precondiciones(final TareaDto tarea,
      final List<IdPersonaLocalDto> personas) {
    this.primaryTemporaryTablePoliticasRepositoryCustom.createTempPersonas();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempPersonas();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasCarencia();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempFechasCarencia();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasCarencia();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempFechasAcumuladasCarencia();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoConAjuste();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempCalculoConAjuste();
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempPersonas(tarea, personas,
        TipoPoliticaEnum.CARENCIA);
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasCarencia();
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasCarencia();
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoConAjusteCarencia();
  }

  @Override
  protected void ajustar(final AlgoritmoAjusteDto algoritmoAjuste, final TareaDto tareaDto) {
    this.tareaCalculoAjusteCarenciaRepositoryCustom.ajustar(algoritmoAjuste, tareaDto);
  }

  @Override
  protected void postcondiciones() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempPersonas();
    this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasCarencia();
    this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasCarencia();
    this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoConAjuste();
  }

}
