package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEvent;
import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEventList;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;

import org.mapstruct.Mapper;

@Mapper
public abstract class TareaMigrarMapper {

  public CommisionCalculationEventList tareaMigrarComisionDtoListToCommisionCalculationEventList(
      List<TareaMigrarComisionDto> src) {
    final List<CommisionCalculationEvent> events = src.stream()
        .map(this::tareaMigrarComisionDtoToCommisionCalculationEvent)
        .toList();
    return CommisionCalculationEventList.newBuilder().setEvents(events).build();
  }

  protected abstract CommisionCalculationEvent tareaMigrarComisionDtoToCommisionCalculationEvent(
      TareaMigrarComisionDto src);
}
