package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionFestivoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionFestivo;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionFestivoRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaLocalizacionFestivoServiceImplTest {

  @Mock
  private TareaLocalizacionFestivoRepositoryCustom tareaLocalizacionFestivoRepositoryCustom;

  @InjectMocks
  private TareaLocalizacionFestivoServiceImpl tareaLocalizacionFestivoServiceImpl;

  @Mock
  private TrabajoServiceImpl trabajoServiceImpl;

  @Mock
  private TareaLocalizacionFestivoMapper tareaLocalizacionFestivoMapper;

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<HorarioComercialFestivoDocDto> items = new ArrayList<>();

    this.tareaLocalizacionFestivoServiceImpl.save(items, tarea);
    verify(this.tareaLocalizacionFestivoRepositoryCustom, times(1))
        .save(ArgumentMatchers.any());
  }

}
