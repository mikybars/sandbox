package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionFestivoService;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaLocalizacionFestivoAsyncServiceImplTest {
  @Mock
  private TareaLocalizacionFestivoService tareaLocalizacionFestivoService;

  @InjectMocks
  private TareaLocalizacionFestivoAsyncServiceImpl tareaLocalizacionFestivoAsyncService;

  @Test
  void saveTest() {
    final List<HorarioComercialFestivoDocDto> src = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaLocalizacionFestivoAsyncService.save(src, tarea);

    verify(this.tareaLocalizacionFestivoService).save(anyList(), any(TareaDto.class));
  }

}
