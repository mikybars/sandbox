package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionEstadoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocResultItemDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaLocalizacionEstadoAsyncServiceImplTest {
  @Mock
  private TareaLocalizacionEstadoService tareaLocalizacionEstadoService;

  @InjectMocks
  private TareaLocalizacionEstadoAsyncServiceImpl tareaLocalizacionEstadoAsyncService;

  @Test
  void saveTest() {
    final List<TareaLocalizacionEstadoDto> lista = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaLocalizacionEstadoAsyncService.save(lista, tarea);

    verify(this.tareaLocalizacionEstadoService).save(anyList());
  }

  @Test
  void saveEstadoWlocResultItemDtoTest() {
    final List<EstadoWlocResultItemDto> lista = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaLocalizacionEstadoAsyncService.saveEstadoWlocResultItemDto(lista, tarea);

    verify(this.tareaLocalizacionEstadoService).save(anyList());
    verify(this.tareaLocalizacionEstadoService).merge(anyList(), any(TareaDto.class));
  }
}
