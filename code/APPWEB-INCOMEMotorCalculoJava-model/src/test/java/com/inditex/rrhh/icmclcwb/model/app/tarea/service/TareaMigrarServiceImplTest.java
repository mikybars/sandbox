package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEvent;
import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEventList;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMigrarMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.SplitListUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaMigrarComisionRepositoryCustom;
import com.inditex.rrhh.icmclcwb.pipe.CommisionCalculationProducer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaMigrarServiceImplTest {

  @Mock
  private SplitListUtils splitListUtils;

  @Mock
  private TareaMigrarMapper tareaMigrarMapper;

  @Mock
  private TareaMigrarComisionRepositoryCustom tareaMigrarComisionRepositoryCustom;

  @Mock
  private CommisionCalculationProducer commisionCalculationProducer;

  @InjectMocks
  private TareaMigrarServiceImpl tareaMigrarServiceImpl;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void migrarCalculoComisionExpandsAndSplitsList() {
    final TrabajoDTO trabajoDTO = new TrabajoDTO();
    trabajoDTO.setId(1L);
    final RunTareaDto runTareaDto = new RunTareaDto();
    runTareaDto.setTrabajo(trabajoDTO);
    final TareaDto tareaDto = new TareaDto();
    runTareaDto.setTarea(tareaDto);

    final List<CommisionCalculationEvent> events = Collections.singletonList(new CommisionCalculationEvent());
    final CommisionCalculationEventList eventList = new CommisionCalculationEventList();
    eventList.setEvents(events);

    when(this.tareaMigrarComisionRepositoryCustom.findCalculoComisionByTareaActual(tareaDto))
        .thenReturn(Collections.singletonList(new TareaMigrarComisionDto()));
    when(this.tareaMigrarMapper.tareaMigrarComisionDtoListToCommisionCalculationEventList(
        Collections.singletonList(new TareaMigrarComisionDto()))).thenReturn(eventList);
    when(this.splitListUtils.splitList(eventList)).thenReturn(Collections.singletonList(eventList));

    this.tareaMigrarServiceImpl.migrarCalculoComision(runTareaDto);

    verify(this.splitListUtils, times(1)).splitList(eventList);
    verify(this.commisionCalculationProducer, times(1)).sendMessage(eventList);
  }

  @Test
  void migrarCalculoComisionHandlesEmptyList() {
    final TrabajoDTO trabajoDTO = new TrabajoDTO();
    trabajoDTO.setId(1L);
    final RunTareaDto runTareaDto = new RunTareaDto();
    runTareaDto.setTrabajo(trabajoDTO);
    final TareaDto tareaDto = new TareaDto();
    runTareaDto.setTarea(tareaDto);

    final CommisionCalculationEventList eventList = new CommisionCalculationEventList();
    eventList.setEvents(Collections.emptyList());

    when(this.tareaMigrarComisionRepositoryCustom.findCalculoComisionByTareaActual(tareaDto))
        .thenReturn(Collections.emptyList());
    when(this.tareaMigrarMapper.tareaMigrarComisionDtoListToCommisionCalculationEventList(Collections.emptyList()))
        .thenReturn(eventList);
    when(this.splitListUtils.splitList(eventList)).thenReturn(Collections.emptyList());

    this.tareaMigrarServiceImpl.migrarCalculoComision(runTareaDto);

    verify(this.splitListUtils, times(1)).splitList(eventList);
    verify(this.commisionCalculationProducer, times(0)).sendMessage(eventList);
  }

  @Test
  void migrarCalculoComisionHandlesException() {
    final TrabajoDTO trabajoDTO = new TrabajoDTO();
    trabajoDTO.setId(1L);
    final RunTareaDto runTareaDto = new RunTareaDto();
    runTareaDto.setTrabajo(trabajoDTO);
    final TareaDto tareaDto = new TareaDto();
    runTareaDto.setTarea(tareaDto);

    final List<CommisionCalculationEvent> events = Collections.singletonList(new CommisionCalculationEvent());
    final CommisionCalculationEventList eventList = new CommisionCalculationEventList();
    eventList.setEvents(events);

    when(this.tareaMigrarComisionRepositoryCustom.findCalculoComisionByTareaActual(tareaDto))
        .thenReturn(Collections.singletonList(new TareaMigrarComisionDto()));
    when(this.tareaMigrarMapper.tareaMigrarComisionDtoListToCommisionCalculationEventList(
        Collections.singletonList(new TareaMigrarComisionDto()))).thenReturn(eventList);
    when(this.splitListUtils.splitList(eventList)).thenReturn(Collections.singletonList(eventList));

    doThrow(new RuntimeException("Test Exception")).when(this.commisionCalculationProducer).sendMessage(eventList);

    final RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
      this.tareaMigrarServiceImpl.migrarCalculoComision(runTareaDto);
    });

    assertEquals("Test Exception", exception.getMessage());
    verify(this.splitListUtils, times(1)).splitList(eventList);
    verify(this.commisionCalculationProducer, times(1)).sendMessage(eventList);
  }
}
