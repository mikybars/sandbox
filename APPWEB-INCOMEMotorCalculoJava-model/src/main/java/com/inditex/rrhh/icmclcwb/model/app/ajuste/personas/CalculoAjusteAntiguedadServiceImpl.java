package com.inditex.rrhh.icmclcwb.model.app.ajuste.personas;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.personas.CalculoAjusteAntiguedadService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePoliticasRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteAntiguedadRepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculoAjusteAntiguedadServiceImpl extends AbstractCalculoAjusteBaseService implements
    CalculoAjusteAntiguedadService {

  @Autowired
  private PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

  @Autowired
  private TareaCalculoAjusteAntiguedadRepositoryCustom tareaCalculoAjusteAntiguedadRepositoryCustom;

  @Override
  protected void precondiciones(final TareaDto tarea, final List<IdPersonaLocalDto> personas) {

    this.primaryTemporaryTablePoliticasRepositoryCustom.createTempPersonas();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempPersonas();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAntiguedad();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempFechasAntiguedad();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasAntiguedad();
    this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempFechasAcumuladasAntiguedad();

    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempPersonas(tarea, personas,
        TipoPoliticaEnum.ANTIGUEDAD);
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad();
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad();

  }

  @Override
  protected void ajustar(final AlgoritmoAjusteDto algoritmoAjuste, final TareaDto tareaDto) {
    this.tareaCalculoAjusteAntiguedadRepositoryCustom.ajustar(algoritmoAjuste, tareaDto);
  }

  @Override
  protected void postcondiciones() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempPersonas();
    this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAntiguedad();
    this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasAntiguedad();
  }

}
