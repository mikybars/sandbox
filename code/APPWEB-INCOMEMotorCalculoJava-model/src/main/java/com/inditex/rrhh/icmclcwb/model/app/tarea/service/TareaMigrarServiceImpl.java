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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaMigrarServiceImpl implements TareaMigrarService {

  private static final Logger LOG = LoggerFactory.getLogger(TareaMigrarService.class);

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
    try {
      final CommisionCalculationEventList eventList = this.tareaMigrarMapper.tareaMigrarComisionDtoListToCommisionCalculationEventList(
          this.findCalculoComisionByTareaActual(runTareaDto.getTarea()));
      LOG.info("[{}] [{}] :: Invoking producer to migrate commission calculation with size {}  ", runTareaDto.getTrabajo().getId(),
          runTareaDto.getTarea().getId(), eventList.getEvents().size());
      if (this.commisionCalculationProducer == null) {
        LOG.info("Producer is null");
      } else {
        LOG.info("Producer [{}] loaded with {} events", this.commisionCalculationProducer, eventList.getEvents().size());
      }
      this.commisionCalculationProducer.sendMessage(eventList);
    } catch (final Exception e) {
      LOG.error("[{}] [{}] :: Error invoking producer to migrate commission calculation", runTareaDto.getTrabajo().getId(),
          runTareaDto.getTarea().getId(), e);
      throw e;
    }
  }
}
