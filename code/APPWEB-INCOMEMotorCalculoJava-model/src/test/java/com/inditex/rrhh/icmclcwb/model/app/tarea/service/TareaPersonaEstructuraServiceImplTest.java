package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaPersonaEstructuraServiceImplTest {

  @Mock
  private TareaPersonaEstructuraRepositoryCustom tareaPersonaEstructuraRepositoryCustom;

  @InjectMocks
  private TareaPersonaEstructuraServiceImpl tareaPersonaEstructuraServiceImpl;

  @Mock
  private TareaPersonaEstructuraMapper tareaPersonaEstructuraMapper;

  @Mock
  private TrabajoServiceImpl trabajoServiceImpl;

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<TareaPersonaEstructuraDto> estructuras = new ArrayList<>();

    this.tareaPersonaEstructuraServiceImpl.save(estructuras, tarea);
    verify(this.tareaPersonaEstructuraRepositoryCustom, times(1)).save(ArgumentMatchers
        .any());
  }

  @Test
  public void mergeEstructurasComResultItemDtoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<EstructurasComResultItemDto> estructuras = new ArrayList<>();

    this.tareaPersonaEstructuraServiceImpl.mergeEstructurasComResultItemDto(estructuras, tarea);
    verify(this.tareaPersonaEstructuraMapper, times(1))
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(
            ArgumentMatchers.any(), any(TareaDto.class));
  }

  @Test
  public void findPersonasChallengeTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);

    this.tareaPersonaEstructuraServiceImpl.findPersonasChallenge(tarea);
    verify(this.tareaPersonaEstructuraRepositoryCustom, times(1)).findPersonasChallenge(any(TareaDto.class));
  }

  @Test
  public void saveSimulacionShouldInvokeRepositoryWithCorrectParameters() {
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setIdTrabajo(1L);
    final TareaPersonaEstructuraDto tareaPersonaEstructuraDto = new TareaPersonaEstructuraDto();

    this.tareaPersonaEstructuraServiceImpl.saveSimulacion(Collections.singletonList(tareaPersonaEstructuraDto), tareaDto);

    verify(this.tareaPersonaEstructuraRepositoryCustom, times(1)).save(anyList());
  }
}
