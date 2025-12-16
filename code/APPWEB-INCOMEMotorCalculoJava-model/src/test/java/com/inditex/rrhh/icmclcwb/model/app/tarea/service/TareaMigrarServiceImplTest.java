package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationDelete;
import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationDeleteEvent;
import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationUpdate;
import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationUpdateEvent;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.CommisionCalculationDeleteEventMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.CommisionCalculationUpdateEventMapper;
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
  private CommisionCalculationUpdateEventMapper commisionCalculationUpdateEventMapper;

  @Mock
  private TareaMigrarComisionRepositoryCustom tareaMigrarComisionRepositoryCustom;

  @Mock
  private CommisionCalculationProducer commisionCalculationProducer;

  @Mock
  private CommisionCalculationDeleteEventMapper commisionCalculationDeleteEventMapper;

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

    final List<CommisionCalculationUpdate> updateLists = Collections.singletonList(new CommisionCalculationUpdate());
    final List<CommisionCalculationUpdateEvent> eventList = Collections.singletonList(new CommisionCalculationUpdateEvent());

    final List<CommisionCalculationDelete> deleteLists = Collections.singletonList(new CommisionCalculationDelete());
    final List<CommisionCalculationDeleteEvent> deleteList = Collections.singletonList(new CommisionCalculationDeleteEvent());

    when(this.tareaMigrarComisionRepositoryCustom.findCalculoComisionByTareaActual(tareaDto))
        .thenReturn(Collections.singletonList(new TareaMigrarComisionDto()));
    when(this.commisionCalculationUpdateEventMapper.tareaMigrarComisionDtoListToCCommisionCalculationUpdateEventList(
        Collections.singletonList(new TareaMigrarComisionDto()))).thenReturn(eventList);
    when(this.splitListUtils.splitCommisionCalculationUpdateEventList(null, eventList)).thenReturn(updateLists);
    when(this.commisionCalculationDeleteEventMapper.tareaMigrarComisionDtoListToCCommisionCalculationDeleteEventList(any()))
        .thenReturn(deleteList);
    when(this.splitListUtils.splitCommisionCalculationDeleteEventList(null, deleteList)).thenReturn(deleteLists);
    this.tareaMigrarServiceImpl.migrarCalculoComision(runTareaDto, anyList());

    verify(this.splitListUtils, times(1)).splitCommisionCalculationUpdateEventList(null, eventList);
    verify(this.commisionCalculationProducer, times(1)).sendMessageV3Update(updateLists.get(0));
    verify(this.commisionCalculationProducer, times(1)).sendMessageV3Delete(deleteLists.get(0));
  }

  @Test
  void migrarCalculoComisionHandlesEmptyList() {
    final TrabajoDTO trabajoDTO = new TrabajoDTO();
    trabajoDTO.setId(1L);
    final RunTareaDto runTareaDto = new RunTareaDto();
    runTareaDto.setTrabajo(trabajoDTO);
    final TareaDto tareaDto = new TareaDto();
    runTareaDto.setTarea(tareaDto);

    final List<CommisionCalculationUpdate> updateLists = new ArrayList<>();
    final List<CommisionCalculationUpdateEvent> eventList = new ArrayList<>();

    final List<CommisionCalculationDelete> deleteLists = new ArrayList<>();
    final List<CommisionCalculationDeleteEvent> deleteList = new ArrayList<>();

    when(this.tareaMigrarComisionRepositoryCustom.findCalculoComisionByTareaActual(tareaDto))
        .thenReturn(Collections.singletonList(new TareaMigrarComisionDto()));
    when(this.commisionCalculationUpdateEventMapper.tareaMigrarComisionDtoListToCCommisionCalculationUpdateEventList(
        Collections.singletonList(new TareaMigrarComisionDto()))).thenReturn(eventList);
    when(this.splitListUtils.splitCommisionCalculationUpdateEventList(null, eventList)).thenReturn(updateLists);
    when(this.commisionCalculationDeleteEventMapper.tareaMigrarComisionDtoListToCCommisionCalculationDeleteEventList(any()))
        .thenReturn(new ArrayList<>());
    when(this.splitListUtils.splitCommisionCalculationDeleteEventList(null, deleteList)).thenReturn(deleteLists);

    this.tareaMigrarServiceImpl.migrarCalculoComision(runTareaDto, anyList());

    verify(this.splitListUtils, times(1)).splitCommisionCalculationUpdateEventList(null, eventList);
    verify(this.commisionCalculationProducer, times(0)).sendMessageV3Update(any());
  }

  @Test
  void migrarCalculoComisionHandlesException() {
    final TrabajoDTO trabajoDTO = new TrabajoDTO();
    trabajoDTO.setId(1L);
    final RunTareaDto runTareaDto = new RunTareaDto();
    runTareaDto.setTrabajo(trabajoDTO);
    final TareaDto tareaDto = new TareaDto();
    runTareaDto.setTarea(tareaDto);

    final List<CommisionCalculationUpdate> updateLists = Collections.singletonList(new CommisionCalculationUpdate());
    final List<CommisionCalculationUpdateEvent> eventList = Collections.singletonList(new CommisionCalculationUpdateEvent());

    when(this.tareaMigrarComisionRepositoryCustom.findCalculoComisionByTareaActual(tareaDto))
        .thenReturn(Collections.singletonList(new TareaMigrarComisionDto()));
    when(this.commisionCalculationUpdateEventMapper.tareaMigrarComisionDtoListToCCommisionCalculationUpdateEventList(
        Collections.singletonList(new TareaMigrarComisionDto()))).thenReturn(eventList);
    when(this.splitListUtils.splitCommisionCalculationUpdateEventList(null, eventList)).thenReturn(updateLists);

    doThrow(new RuntimeException("Test Exception")).when(this.commisionCalculationProducer).sendMessageV3Update(any());

    final RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
      this.tareaMigrarServiceImpl.migrarCalculoComision(runTareaDto, anyList());
    });

    assertEquals("Test Exception", exception.getMessage());
    verify(this.splitListUtils, times(1)).splitCommisionCalculationUpdateEventList(null, eventList);
    verify(this.commisionCalculationProducer, times(1)).sendMessageV3Update(any());
  }

  @Test
  void testDeleteCalculoComisionByTareaActual() {
    when(this.tareaMigrarComisionRepositoryCustom.deleteCalculoComisionByTareaActual(any(), any())).thenReturn(new ArrayList<>());

    this.tareaMigrarServiceImpl.deleteCalculoComisionByTareaActual(new RunTareaDto(), new TareaAmbitoDto());

    verify(this.tareaMigrarComisionRepositoryCustom, times(1)).deleteCalculoComisionByTareaActual(any(), any());
  }
}
