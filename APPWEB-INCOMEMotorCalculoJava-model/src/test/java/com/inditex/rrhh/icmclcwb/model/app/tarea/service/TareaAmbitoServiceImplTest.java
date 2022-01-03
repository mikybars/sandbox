package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbito;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaAmbitoServiceImplTest {

  @Mock
  private TareaAmbitoRepository tareaAmbitoRepository;

  @InjectMocks
  private TareaAmbitoServiceImpl tareaAmbitoServiceImpl;

  @Mock
  private TareaAmbitoMapper tareaAmbitoMapper;

  @Mock
  private TareaAmbitoMapperDecorator tareaAmbitoMapperDecorator;

  @Test
  public void createTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final List<TareaAmbito> list = new ArrayList<TareaAmbito>();
    final List<TareaAmbitoDto> dtoList = new ArrayList<TareaAmbitoDto>();
    when(this.tareaAmbitoRepository.saveAll(ArgumentMatchers.<List<TareaAmbito>>any())).thenReturn(list);

    this.tareaAmbitoServiceImpl.create(dtoList, tarea);

    verify(this.tareaAmbitoRepository, times(1)).saveAll(ArgumentMatchers.<List<TareaAmbito>>any());
  }

  @Test
  public void findByTarea() {
    final TareaDto tarea = mock(TareaDto.class);
    final List<TareaAmbito> list = new ArrayList<TareaAmbito>();
    when(this.tareaAmbitoRepository.findByTareaId(any(Long.class))).thenReturn(list);

    this.tareaAmbitoServiceImpl.findByTarea(tarea);

    verify(this.tareaAmbitoRepository, times(1)).findByTareaId(any(Long.class));
  }

}
