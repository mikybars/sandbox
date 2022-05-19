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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteVacacionesRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class CalculoAjusteVacacionesServiceImplTest {

  @Mock
  private PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

  @Mock
  private TareaCalculoAjusteVacacionesRepositoryCustom tareaCalculoAjusteVacacionesRepositoryCustom;

  @InjectMocks
  private CalculoAjusteVacacionesServiceImpl calculoAjusteVacacionesService;

  @Test
  void precondicionesTest() {
    final List<IdPersonaLocalDto> personas = this.createPersonas();
    final TareaDto tarea = this.createTarea();
    this.calculoAjusteVacacionesService.precondiciones(tarea, personas);
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createTempPersonas();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createIndexTempPersonas();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createTempFechasVacaciones();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createIndexTempFechasVacaciones();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createTempFechasAcumuladasVacaciones();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1))
        .createIndexTempFechasAcumuladasVacaciones();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createTempCalculoConAjuste();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1))
        .createIndexTempCalculoConAjuste();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).insertTempPersonas(tarea, personas,
        TipoPoliticaEnum.VACACIONES);
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).insertTempFechasVacaciones();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1))
        .insertTempFechasAcumuladasVacaciones();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1))
        .insertTempCalculoConAjuste(Collections.singletonList(TipoPoliticaEnum.VACACIONES));
  }

  @Test
  void ajustarTest() {
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    this.calculoAjusteVacacionesService.ajustar(algoritmoAjuste, new TareaDto());
    verify(this.tareaCalculoAjusteVacacionesRepositoryCustom, times(1)).ajustar(algoritmoAjuste, new TareaDto());
  }

  @Test
  void postcondicionesTest() {
    this.calculoAjusteVacacionesService.postcondiciones();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempPersonas();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempFechasVacaciones();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempFechasAcumuladasVacaciones();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempCalculoConAjuste();
  }

  @Test
  void ajustarExceptionTest() throws Exception {
    doThrow(new RuntimeException("Error")).when(this.tareaCalculoAjusteVacacionesRepositoryCustom)
        .ajustar(any(AlgoritmoAjusteDto.class), any(TareaDto.class));
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    final TareaDto tarea = this.createTarea();
    final List<IdPersonaLocalDto> personas = this.createPersonas();
    assertThrows(RuntimeException.class,
        () -> {
          this.calculoAjusteVacacionesService.ajustar(algoritmoAjuste, tarea,
              personas);
        });
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempPersonas();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempFechasVacaciones();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempFechasAcumuladasVacaciones();
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
