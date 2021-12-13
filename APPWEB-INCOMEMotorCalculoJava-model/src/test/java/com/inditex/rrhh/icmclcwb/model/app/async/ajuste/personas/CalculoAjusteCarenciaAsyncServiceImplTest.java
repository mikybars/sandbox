/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.async.ajuste.personas;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.personas.CalculoAjusteCarenciaService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class CalculoAjusteCarenciaAsyncServiceImplTest {

  @Mock
  private CalculoAjusteCarenciaService calculoAjusteCarenciaService;

  @InjectMocks
  private CalculoAjusteCarenciaAsyncServiceImpl calculoAjusteCarenciaAsyncService;

  @Test
  void ajustarTest() {
    final AlgoritmoAjusteDto algoritmo = new AlgoritmoAjusteDto();
    algoritmo.setId(89);
    final TareaDto tarea = new TareaDto();
    tarea.setId(23L);
    final List<IdPersonaLocalDto> personas = Collections.singletonList(
        IdPersonaLocalDto
            .builder()
            .idPersonaLocal("ID PERSONA")
            .stdOrHrPeriod("OR PERSONA")
            .build());
    final CompletableFuture<Void> cf = this.calculoAjusteCarenciaAsyncService.ajustar(algoritmo, tarea, personas);
    verify(this.calculoAjusteCarenciaService, times(1)).ajustar(algoritmo, tarea, personas);
    assertNotNull(cf);
  }

}
