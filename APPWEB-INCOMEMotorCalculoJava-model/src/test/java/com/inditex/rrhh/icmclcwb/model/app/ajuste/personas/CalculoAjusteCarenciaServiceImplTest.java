/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.ajuste.personas;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePoliticasRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteCarenciaRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * javierev
 */
@ExtendWith(SpringExtension.class)
class CalculoAjusteCarenciaServiceImplTest {

  @Mock
  private PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

  @Mock
  private TareaCalculoAjusteCarenciaRepositoryCustom tareaCalculoAjusteCarenciaRepositoryCustom;

  @InjectMocks
  private CalculoAjusteCarenciaServiceImpl calculoAjusteCarenciaService;

  @Test
  void precondicionesTest() {
    final List<IdPersonaLocalDto> personas = this.createPersonas();
    final TareaDto tarea = this.createTarea();
    this.calculoAjusteCarenciaService.precondiciones(tarea, personas);
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createTempPersonas();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createIndexTempPersonas();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createTempFechasCarencia();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createTempFechasAcumuladasCarencia();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createTempCalculoConAjuste();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createIndexTempFechasCarencia();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createIndexTempFechasAcumuladasCarencia();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1))
        .createIndexTempCalculoConAjuste();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).insertTempPersonas(tarea, personas,
        TipoPoliticaEnum.CARENCIA);
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).insertTempFechasCarencia();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).insertTempFechasAcumuladasCarencia();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1))
        .insertTempCalculoConAjusteCarencia();
  }

  @Test
  void ajustarTest() {
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    this.calculoAjusteCarenciaService.ajustar(algoritmoAjuste, new TareaDto());
    verify(this.tareaCalculoAjusteCarenciaRepositoryCustom, times(1)).ajustar(algoritmoAjuste, new TareaDto());
  }

  @Test
  void postcondicionesTest() {
    this.calculoAjusteCarenciaService.postcondiciones();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempPersonas();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempFechasCarencia();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempFechasAcumuladasCarencia();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempCalculoConAjuste();
  }

  @Test
  void ajustarExceptionTest() throws Exception {
    doThrow(new RuntimeException("Error")).when(this.tareaCalculoAjusteCarenciaRepositoryCustom)
        .ajustar(any(AlgoritmoAjusteDto.class), any(TareaDto.class));
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    final TareaDto tarea = this.createTarea();
    final List<IdPersonaLocalDto> personas = this.createPersonas();
    assertThrows(RuntimeException.class,
        () -> {
          this.calculoAjusteCarenciaService.ajustar(algoritmoAjuste, tarea,
              personas);
        });
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempPersonas();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempFechasCarencia();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempFechasAcumuladasCarencia();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempCalculoConAjuste();
  }

  private AlgoritmoAjusteDto createAlgoritmoAjuste() {
    final AlgoritmoAjusteDto algoritmoAjuste = new AlgoritmoAjusteDto();
    algoritmoAjuste.setId(1929);
    return algoritmoAjuste;
  }

  private List<IdPersonaLocalDto> createPersonas() {
    return Collections.singletonList(IdPersonaLocalDto
        .builder()
        .idPersonaLocal("ID PERSONA")
        .stdOrHrPeriod("OR PERSONA")
        .build());
  }

  private TareaDto createTarea() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(123L);
    return tarea;
  }

}
