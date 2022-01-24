package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaAusenciaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaAusenciaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaAusenciaHistorico;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaAusenciaHistoricoRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaPersonaAusenciaHistoricoServiceImplTest {

  @Mock
  private TareaPersonaAusenciaHistoricoRepositoryCustom tareaPersonaAusenciaHistoricoRepositoryCustom;

  @InjectMocks
  private TareaPersonaAusenciaHistoricoServiceImpl tareaPersonaAusenciaHistoricoServiceImpl;

  @Mock
  private TareaPersonaAusenciaHistoricoMapper tareaPersonaAusenciaHistoricoMapper;

  @Mock
  private TrabajoServiceImpl trabajoServiceImpl;

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<TareaPersonaAusenciaHistoricoDto> tareaPersonaAusencia = new ArrayList<>();

    this.tareaPersonaAusenciaHistoricoServiceImpl.save(tareaPersonaAusencia);
    verify(this.tareaPersonaAusenciaHistoricoRepositoryCustom, times(1)).save(ArgumentMatchers
        .<List<TareaPersonaAusenciaHistorico>>any());
  }

  @Test
  public void saveAusenciaResultItemDtoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<AusenciasResultItemDto> ausenciasResultItemDto = new ArrayList<>();

    this.tareaPersonaAusenciaHistoricoServiceImpl.saveAusenciaResultItemDto(ausenciasResultItemDto, tarea);
    verify(this.tareaPersonaAusenciaHistoricoRepositoryCustom, times(1)).save(ArgumentMatchers
        .<List<TareaPersonaAusenciaHistorico>>any());
  }

}
