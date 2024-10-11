package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEvent;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;

import org.mapstruct.Mapper;

@Mapper
public abstract class TareaMigrarMapper {

  public abstract List<CommisionCalculationEvent> tareaMigrarComisionDtoToCommisionCalculationEvent(
      List<TareaMigrarComisionDto> src);
}
