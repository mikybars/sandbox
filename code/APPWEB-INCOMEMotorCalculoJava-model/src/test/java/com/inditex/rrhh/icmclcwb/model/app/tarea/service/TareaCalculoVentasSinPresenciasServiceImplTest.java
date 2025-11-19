package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaCalculoVentasSinPresenciasServiceImplTest {

  @Mock
  private Logger log;

  @Mock
  private TareaCalculoRepositoryCustom tareaCalculoRepositoryCustom;

  @InjectMocks
  TareaCalculoVentasSinPresenciasServiceImpl tareaCalculoVentasSinPresenciasServiceImpl;

  @Test
  void findTiendaVentasSinPresenciasTest() {
    final Long idTarea = 1L;
    final List<IdLocalizacionLocalDto> expectedResults = List.of(new IdLocalizacionLocalDto());
    when(this.tareaCalculoRepositoryCustom.findTiendaVentasSinPresencias(idTarea))
        .thenReturn(expectedResults);

    final List<IdLocalizacionLocalDto> results =
        this.tareaCalculoVentasSinPresenciasServiceImpl.findTiendaVentasSinPresencias(idTarea);

    assertEquals(expectedResults, results);
  }

  @Test
  void findTiendaVentasSinPresenciasNoDataTest() {
    final Long idTarea = 1L;
    when(this.tareaCalculoRepositoryCustom.findTiendaVentasSinPresencias(idTarea))
        .thenReturn(Collections.emptyList());

    final List<IdLocalizacionLocalDto> results =
        this.tareaCalculoVentasSinPresenciasServiceImpl.findTiendaVentasSinPresencias(idTarea);

    assertEquals(Collections.emptyList(), results);
  }

}
