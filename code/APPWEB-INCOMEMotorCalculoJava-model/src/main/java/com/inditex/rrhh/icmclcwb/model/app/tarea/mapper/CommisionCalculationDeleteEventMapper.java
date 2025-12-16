package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationDeleteEvent;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;

import org.mapstruct.Mapper;

@Mapper
public interface CommisionCalculationDeleteEventMapper {

  List<CommisionCalculationDeleteEvent> tareaMigrarComisionDtoListToCCommisionCalculationDeleteEventList(
      List<TareaMigrarComisionDto> src);

  CommisionCalculationDeleteEvent tareaMigrarComisionDtoToCommisionCalculationDeleteEvent(
      TareaMigrarComisionDto src);
}
