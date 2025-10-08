package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoRepositoryCustom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaPorcentajeServiceImplTest {

  @Mock
  private TareaCalculoRepositoryCustom tareaCalculoRepositoryCustom;

  @InjectMocks
  private TareaCalculoPorcentajeServiceImpl tareaPorcentajeService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void findPersonaPorcetaje0_delegatesToRepository() {
    final Long idTarea = 1L;
    final String cclIdOrigen = "ORIGEN";
    final String stdIdLegEnt = "LEG";
    final List<IdPersonaLocalDto> expected = Collections.singletonList(new IdPersonaLocalDto());

    when(this.tareaCalculoRepositoryCustom.findPersonaPorcentaje0(idTarea)).thenReturn(expected);

    final List<IdPersonaLocalDto> result = this.tareaPorcentajeService.findPersonaPorcetaje0(idTarea);

    assertEquals(expected, result);
    verify(this.tareaCalculoRepositoryCustom, times(1)).findPersonaPorcentaje0(idTarea);
  }
}
