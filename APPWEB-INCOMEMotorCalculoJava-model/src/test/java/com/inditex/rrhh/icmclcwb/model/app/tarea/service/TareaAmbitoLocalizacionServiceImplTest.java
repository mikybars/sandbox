package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoLocalizacionMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoLocalizacion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoLocalizacionRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaAmbitoLocalizacionServiceImplTest {

  @Mock
  private TareaAmbitoLocalizacionRepository tareaAmbitoLocalizacionRepository;

  @InjectMocks
  private TareaAmbitoLocalizacionServiceImpl tareaAmbitoLocalizacionServiceImpl;

  @Mock
  private TareaAmbitoLocalizacionMapper tareaAmbitoLocalizacionMapper;

  @Mock
  private TareaAmbitoLocalizacionMapperDecorator tareaAmbitoLocalizacionMapperDecorator;

  @Test
  public void createTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final List<TareaAmbitoLocalizacion> list = new ArrayList<TareaAmbitoLocalizacion>();
    final List<TareaAmbitoLocalizacionDto> dtoList = new ArrayList<TareaAmbitoLocalizacionDto>();

    when(this.tareaAmbitoLocalizacionRepository.saveAll(ArgumentMatchers.<List<TareaAmbitoLocalizacion>>any()))
        .thenReturn(list);

    this.tareaAmbitoLocalizacionServiceImpl.create(dtoList, tarea);

    verify(this.tareaAmbitoLocalizacionRepository, times(1))
        .saveAll(ArgumentMatchers.<List<TareaAmbitoLocalizacion>>any());
  }

  @Test
  public void findByTarea() {
    final TareaDto tarea = mock(TareaDto.class);
    final List<TareaAmbitoLocalizacion> list = new ArrayList<TareaAmbitoLocalizacion>();
    when(this.tareaAmbitoLocalizacionRepository.findByTareaId(any(Long.class))).thenReturn(list);

    this.tareaAmbitoLocalizacionServiceImpl.findByTarea(tarea);

    verify(this.tareaAmbitoLocalizacionRepository, times(1)).findByTareaId(any(Long.class));
  }

}
