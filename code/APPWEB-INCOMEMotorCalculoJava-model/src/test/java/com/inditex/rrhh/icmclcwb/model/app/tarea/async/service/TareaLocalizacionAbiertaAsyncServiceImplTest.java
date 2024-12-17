package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionAbiertaService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaLocalizacionAbiertaAsyncServiceImplTest {
  @Mock
  private TareaLocalizacionAbiertaService tareaLocalizacionAbiertaService;

  @InjectMocks
  private TareaLocalizacionAbiertaAsyncServiceImpl tareaLocalizacionAbiertaAsyncService;

  @Test
  void saveAbiertoTest() {
    final TareaDto tareaDto = new TareaDto();
    final TrabajoDTO trabajoDto = new TrabajoDTO();

    this.tareaLocalizacionAbiertaAsyncService.saveAbierto(tareaDto, trabajoDto);

    verify(this.tareaLocalizacionAbiertaService).saveAbierto(any(TareaDto.class), any(TrabajoDTO.class));
  }

  @Test
  void saveCerradoTest() {
    final TareaDto tareaDto = new TareaDto();
    final TrabajoDTO trabajoDto = new TrabajoDTO();

    this.tareaLocalizacionAbiertaAsyncService.saveCerrado(tareaDto, trabajoDto);

    verify(this.tareaLocalizacionAbiertaService).saveCerrado(any(TareaDto.class), any(TrabajoDTO.class));
  }
}
