package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaPresenciaManual;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustomImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaAmbitoGlobalLocalizacionPersonaPresenciaManualServiceImplTest {

  @Mock
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustomImpl tareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustomImpl;

  @InjectMocks
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaManualServiceImpl tareaAmbitoGlobalLocalizacionPersonaPresenciaManualServiceImpl;

  @Mock
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaManualMapper tareaAmbitoGlobalLocalizacionPersonaPresenciaManualMapper;

  @Mock
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaManualDecorator tareaAmbitoGlobalLocalizacionPersonaPresenciaManualDecorator;

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final GenericEmpleadoResultItemDto genericEmpleadoResultItemDto = mock(GenericEmpleadoResultItemDto.class);
    final List<GenericEmpleadoResultItemDto> dtoList = new ArrayList<GenericEmpleadoResultItemDto>();
    final List<TareaAmbitoGlobalLocalizacionPersonaPresenciaManual> list =
        new ArrayList<TareaAmbitoGlobalLocalizacionPersonaPresenciaManual>();

    dtoList.add(genericEmpleadoResultItemDto);
    when(this.tareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustomImpl
        .save(ArgumentMatchers.<List<TareaAmbitoGlobalLocalizacionPersonaPresenciaManual>>any()))
            .thenReturn(list);

    this.tareaAmbitoGlobalLocalizacionPersonaPresenciaManualServiceImpl.save(dtoList, tarea);

    verify(this.tareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustomImpl, times(1))
        .save(ArgumentMatchers.<List<TareaAmbitoGlobalLocalizacionPersonaPresenciaManual>>any());
  }

}
