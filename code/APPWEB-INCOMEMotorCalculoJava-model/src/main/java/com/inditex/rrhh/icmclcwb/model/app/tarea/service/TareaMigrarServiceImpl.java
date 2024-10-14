package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEventList;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaMigrarService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMigrarMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaMigrarComisionRepositoryCustom;
import com.inditex.rrhh.icmclcwb.pipe.CommisionCalculationProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaMigrarServiceImpl implements TareaMigrarService {

  @Autowired
  private TareaMigrarMapper tareaMigrarMapper;

  @Autowired
  private TareaMigrarComisionRepositoryCustom tareaMigrarComisionRepositoryCustom;

  @Autowired
  private CommisionCalculationProducer commisionCalculationProducer;

  @Override
  public List<TareaMigrarComisionDto> findCalculoComisionByTareaActual(TareaDto tarea) {
    return this.tareaMigrarComisionRepositoryCustom.findCalculoComisionByTareaActual(tarea);
  }

  @Override
  public void migrarCalculoComision(RunTareaDto runTareaDto) {
    final CommisionCalculationEventList eventList = this.tareaMigrarMapper.tareaMigrarComisionDtoListToCommisionCalculationEventList(
        this.findCalculoComisionByTareaActual(runTareaDto.getTarea()));
    this.commisionCalculationProducer.sendMessage(eventList);
  }
}
