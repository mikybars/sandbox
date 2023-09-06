package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionComisionHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionComisionHistorico;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionComisionHistoricoRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaLocalizacionComisionHistoricoServiceImplTest {

  @Mock
  private TareaLocalizacionComisionHistoricoRepositoryCustom tareaLocalizacionComisionHistoricoRepositoryCustom;

  @InjectMocks
  private TareaLocalizacionComisionHistoricoServiceImpl tareaLocalizacionComisionHistoricoServiceImpl;

  @Mock
  private TrabajoServiceImpl trabajoServiceImpl;

  @Mock
  private TareaLocalizacionComisionHistoricoMapper tareaLocalizacionComisionHistoricoMapper;

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<TareaLocalizacionComisionHistoricoDto> genericTiendaResultItemDto = new ArrayList<>();

    this.tareaLocalizacionComisionHistoricoServiceImpl.save(genericTiendaResultItemDto);
    verify(this.tareaLocalizacionComisionHistoricoRepositoryCustom, times(1))
        .save(ArgumentMatchers.<List<TareaLocalizacionComisionHistorico>>any());
  }

  @Test
  public void mergeTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<GenericTiendaResultItemDto> genericTiendaResultItemDto = new ArrayList<>();

    this.tareaLocalizacionComisionHistoricoServiceImpl.merge(genericTiendaResultItemDto, tarea);
    verify(this.tareaLocalizacionComisionHistoricoMapper, times(1))
        .genericLocalizacionResultItemDtoToTareaLocalizacionComisionHistoricoDto(
            ArgumentMatchers.<List<GenericTiendaResultItemDto>>any(),
            any(TareaDto.class));
  }

}
