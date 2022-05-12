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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteAntiguedadRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * javierev
 */
@ExtendWith(SpringExtension.class)
class CalculoAjusteAntiguedadServiceImplTest {

  @Mock
  private PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

  @Mock
  private TareaCalculoAjusteAntiguedadRepositoryCustom tareaCalculoAjusteAntiguedadRepositoryCustom;

  @InjectMocks
  private CalculoAjusteAntiguedadServiceImpl calculoAjusteAntiguedadService;

  @Test
  void precondicionesTest() {
    final List<IdPersonaLocalDto> personas = this.createPersonas();
    final TareaDto tarea = this.createTarea();
    this.calculoAjusteAntiguedadService.precondiciones(tarea, personas);
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createTempPersonas();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createIndexTempPersonas();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createTempFechasAntiguedad();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createIndexTempFechasAntiguedad();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createTempFechasAcumuladasAntiguedad();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1))
        .createIndexTempFechasAcumuladasAntiguedad();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).insertTempPersonas(tarea, personas,
        TipoPoliticaEnum.ANTIGUEDAD);
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).insertTempFechasAntiguedad();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).insertTempFechasAcumuladasAntiguedad();
  }

  @Test
  void ajustarTest() {
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    this.calculoAjusteAntiguedadService.ajustar(algoritmoAjuste, new TareaDto());
    verify(this.tareaCalculoAjusteAntiguedadRepositoryCustom, times(1)).ajustar(algoritmoAjuste, new TareaDto());
  }

  @Test
  void postcondicionesTest() {
    this.calculoAjusteAntiguedadService.postcondiciones();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempPersonas();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempFechasAntiguedad();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempFechasAcumuladasAntiguedad();
  }

  @Test
  void ajustarExceptionTest() throws Exception {
    doThrow(new RuntimeException("Error")).when(this.tareaCalculoAjusteAntiguedadRepositoryCustom)
        .ajustar(any(AlgoritmoAjusteDto.class), any(TareaDto.class));
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    final TareaDto tarea = this.createTarea();
    final List<IdPersonaLocalDto> personas = this.createPersonas();
    assertThrows(RuntimeException.class,
        () -> {
          this.calculoAjusteAntiguedadService.ajustar(algoritmoAjuste, tarea,
              personas);
        });
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempPersonas();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempFechasAntiguedad();
    verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempFechasAcumuladasAntiguedad();
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
