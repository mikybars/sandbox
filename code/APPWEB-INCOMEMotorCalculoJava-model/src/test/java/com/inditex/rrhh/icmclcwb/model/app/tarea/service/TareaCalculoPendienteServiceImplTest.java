package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaCalculoPendienteServiceImplTest {
  @Mock
  private Logger log;

  @Mock
  private TareaCalculoRepositoryCustom tareaCalculoRepositoryCustom;

  @InjectMocks
  TareaCalculoPendienteServiceImpl tareaCalculoPendienteService;

  @Test
  void findPersonaImporteExcedidoByIdTareaTest() {
    final Long idTarea = 1L;
    final String cclIdOrigen = "11";
    final String stdIdLegEnt = "8";
    final List<IdPersonaLocalDto> expectedResults = List.of(new IdPersonaLocalDto());
    when(this.tareaCalculoRepositoryCustom.findPersonaCalculoPendiente(idTarea, cclIdOrigen, stdIdLegEnt))
        .thenReturn(expectedResults);

    final List<IdPersonaLocalDto> results =
        this.tareaCalculoPendienteService.findPersonaCalculoPendiente(idTarea, cclIdOrigen, stdIdLegEnt);

    assertEquals(expectedResults, results);
  }

  @Test
  void findPersonaImporteExcedidoByIdTareaNoDataTest() {
    final Long idTarea = 1L;
    final String cclIdOrigen = "11";
    final String stdIdLegEnt = "8";
    when(this.tareaCalculoRepositoryCustom.findPersonaCalculoPendiente(idTarea, cclIdOrigen, stdIdLegEnt))
        .thenReturn(Collections.emptyList());

    final List<IdPersonaLocalDto> results =
        this.tareaCalculoPendienteService.findPersonaCalculoPendiente(idTarea, cclIdOrigen, stdIdLegEnt);

    assertEquals(Collections.emptyList(), results);
  }

}
