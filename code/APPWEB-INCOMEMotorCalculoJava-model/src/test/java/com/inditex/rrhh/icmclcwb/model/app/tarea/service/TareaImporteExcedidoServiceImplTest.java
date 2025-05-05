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
class TareaImporteExcedidoServiceImplTest {

  @Mock
  private Logger log;

  @Mock
  private TareaCalculoRepositoryCustom tareaCalculoRepositoryCustom;

  @InjectMocks
  TareaImporteExcedidoServiceImpl tareaImporteExcedidoServiceImpl;

  @Test
  void findPersonaImporteExcedidoByIdTareaTest() {
    final Long idTarea = 1L;
    final List<IdPersonaLocalDto> expectedResults = List.of(new IdPersonaLocalDto());
    when(this.tareaCalculoRepositoryCustom.findPersonaImporteExcedidoByIdTarea(idTarea)).thenReturn(expectedResults);

    final List<IdPersonaLocalDto> results = this.tareaImporteExcedidoServiceImpl.findPersonaImporteExcedidoByIdTarea(idTarea);

    assertEquals(expectedResults, results);
  }

  @Test
  void findPersonaImporteExcedidoByIdTareaNoDataTest() {
    final Long idTarea = 1L;
    when(this.tareaCalculoRepositoryCustom.findPersonaImporteExcedidoByIdTarea(idTarea)).thenReturn(Collections.emptyList());

    final List<IdPersonaLocalDto> results = this.tareaImporteExcedidoServiceImpl.findPersonaImporteExcedidoByIdTarea(idTarea);

    assertEquals(Collections.emptyList(), results);
  }

}
