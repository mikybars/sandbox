package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoGlobalLocalizacionPersonaPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoGlobalLocalizacionPersonaPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaPresencia;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustomImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaAmbitoGlobalLocalizacionPersonaPresenciaServiceImplTest {

  @Mock
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustomImpl tareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustomImpl;

  @InjectMocks
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaServiceImpl tareaAmbitoGlobalLocalizacionPersonaPresenciaServiceImpl;

  @Mock
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaMapper tareaAmbitoGlobalLocalizacionPersonaPresenciaMapper;

  @Mock
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaDecorator tareaAmbitoGlobalLocalizacionPersonaPresenciaDecorator;

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final PtrPresenciaEmpleadosTiendaResponseDto ptrPresenciaEmpleadosTiendaResponseDto = mock(
        PtrPresenciaEmpleadosTiendaResponseDto.class);
    final PtrPresenciaEmpleadosTiendaResultItemDto ptrPresenciaEmpleadosTiendaResultItemDto = mock(
        PtrPresenciaEmpleadosTiendaResultItemDto.class);
    ptrPresenciaEmpleadosTiendaResponseDto.setPresenciasTiendasEmpleado(new ArrayList<>());
    ptrPresenciaEmpleadosTiendaResponseDto.getPresenciasTiendasEmpleado()
        .add(ptrPresenciaEmpleadosTiendaResultItemDto);

    this.tareaAmbitoGlobalLocalizacionPersonaPresenciaServiceImpl.save(ptrPresenciaEmpleadosTiendaResponseDto,
        tarea);

    verify(this.tareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustomImpl, times(1))
        .save(ArgumentMatchers.<List<TareaAmbitoGlobalLocalizacionPersonaPresencia>>any());
  }

}
