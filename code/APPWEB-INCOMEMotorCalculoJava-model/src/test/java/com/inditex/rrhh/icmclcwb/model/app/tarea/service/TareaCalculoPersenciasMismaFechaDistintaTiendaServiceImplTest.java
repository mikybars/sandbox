package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaCalculoPersenciasMismaFechaDistintaTiendaServiceImplTest {

  @Mock
  private TareaCalculoRepositoryCustom tareaCalculoRepositoryCustom;

  @InjectMocks
  TareaCalculoPresenciasMismaFechaDistintaTiendaServiceImpl tareaCalculoPresenciasMismaFechaDistintaTiendaService;

  @Test
  void findPersonaPresenciasMismaFechaDistintaTienda() {

    final Long idTarea = 1L;
    final List<IdPersonaLocalDto> expectedResults = List.of(new IdPersonaLocalDto());
    when(this.tareaCalculoRepositoryCustom.findPersonaPresenciasMismaFechaDistintaTienda(idTarea))
        .thenReturn(expectedResults);

    final List<IdPersonaLocalDto> results =
        this.tareaCalculoPresenciasMismaFechaDistintaTiendaService.findPersonaPresenciasMismaFechaDistintaTienda(idTarea);

    assertEquals(expectedResults, results);
  }

}
