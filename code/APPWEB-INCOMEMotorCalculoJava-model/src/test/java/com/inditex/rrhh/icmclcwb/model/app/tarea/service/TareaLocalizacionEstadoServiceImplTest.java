package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionEstadoDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionEstadoRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaLocalizacionEstadoServiceImplTest {

  @Mock
  private TareaLocalizacionEstadoRepositoryCustom tareaLocalizacionEstadoRepositoryCustom;

  @Mock
  private TareaLocalizacionEstadoMapper tareaLocalizacionEstadoMapper;

  @InjectMocks
  private TareaLocalizacionEstadoServiceImpl tareaLocalizacionEstadoServiceImpl;

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<TareaLocalizacionEstadoDto> genericTiendaResultItemDto = new ArrayList<>();

    this.tareaLocalizacionEstadoServiceImpl.save(genericTiendaResultItemDto);
    verify(this.tareaLocalizacionEstadoRepositoryCustom, times(1))
        .save(ArgumentMatchers.any());
  }
}
