package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoGlobalLocalizacionPersonaDesplazamientoMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoGlobalLocalizacionPersonaDesplazamientoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaDesplazamiento;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustomImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaAmbitoGlobalLocalizacionPersonaDesplazamientoServiceImplTest {

  @Mock
  private TareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustomImpl tareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustomImpl;

  @InjectMocks
  private TareaAmbitoGlobalLocalizacionPersonaDesplazamientoServiceImpl tareaAmbitoGlobalLocalizacionPersonaDesplazamientoServiceImpl;

  @Mock
  private TareaAmbitoGlobalLocalizacionPersonaDesplazamientoMapper tareaAmbitoGlobalLocalizacionPersonaDesplazamientoMapper;

  @Mock
  private TareaAmbitoGlobalLocalizacionPersonaDesplazamientoDecorator tareaAmbitoGlobalLocalizacionPersonaDesplazamientoDecorator;

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final GenericEmpleadoResultItemDto genericEmpleadoResultItemDto = mock(GenericEmpleadoResultItemDto.class);
    final List<GenericEmpleadoResultItemDto> dtoList = new ArrayList<GenericEmpleadoResultItemDto>();
    final List<TareaAmbitoGlobalLocalizacionPersonaDesplazamiento> list =
        new ArrayList<TareaAmbitoGlobalLocalizacionPersonaDesplazamiento>();
    dtoList.add(genericEmpleadoResultItemDto);
    when(this.tareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustomImpl
        .save(ArgumentMatchers.<List<TareaAmbitoGlobalLocalizacionPersonaDesplazamiento>>any()))
            .thenReturn(list);

    this.tareaAmbitoGlobalLocalizacionPersonaDesplazamientoServiceImpl.save(dtoList, tarea);

    verify(this.tareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustomImpl, times(1))
        .save(ArgumentMatchers.<List<TareaAmbitoGlobalLocalizacionPersonaDesplazamiento>>any());
  }

}
