package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationUpdateEvent;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;

import org.mapstruct.Mapper;

@Mapper
public interface CommisionCalculationUpdateEventMapper {

  List<CommisionCalculationUpdateEvent> tareaMigrarComisionDtoListToCCommisionCalculationUpdateEventList(
      List<TareaMigrarComisionDto> src);

  CommisionCalculationUpdateEvent tareaMigrarComisionDtoToCommisionCalculationUpdateEvent(
      TareaMigrarComisionDto src);
}
