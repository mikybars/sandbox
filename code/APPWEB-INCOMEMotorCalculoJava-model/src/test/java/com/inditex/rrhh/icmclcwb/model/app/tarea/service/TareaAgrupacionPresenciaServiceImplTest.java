package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionPresenciaRepositoryCustomImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaAgrupacionPresenciaServiceImplTest {

  @Mock
  private TareaAgrupacionPresenciaRepositoryCustomImpl tareaAgrupacionPresenciaRepositoryCustomImpl;

  @InjectMocks
  private TareaAgrupacionPresenciaServiceImpl tareaAgrupacionPresenciaServiceImpl;

  @Test
  public void calcularPresenciasTotalesAgrupacion() {
    TareaDto runTarea = mock(TareaDto.class);
    tareaAgrupacionPresenciaServiceImpl.calcularPresenciasTotalesAgrupacion(runTarea);
    verify(tareaAgrupacionPresenciaRepositoryCustomImpl, times(1))
        .calcularPresenciasTotalesAgrupacion(any(TareaDto.class));
  }

}
