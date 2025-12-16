package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationDelete;
import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationUpdate;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaMigrarService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.CommisionCalculationDeleteEventMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.CommisionCalculationUpdateEventMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMigrarMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.SplitListUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaMigrarComisionRepositoryCustom;
import com.inditex.rrhh.icmclcwb.pipe.CommisionCalculationProducer;

import jakarta.validation.constraints.NotNull;
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
  private SplitListUtils splitListUtils;

  @Autowired
  private TareaMigrarMapper tareaMigrarMapper;

  @Autowired
  private TareaMigrarComisionRepositoryCustom tareaMigrarComisionRepositoryCustom;

  @Autowired
  private CommisionCalculationUpdateEventMapper commisionCalculationUpdateEventMapper;

  @Autowired
  private CommisionCalculationDeleteEventMapper commisionCalculationDeleteEventMapper;

  @Autowired
  private CommisionCalculationProducer commisionCalculationProducer;

  @Override
  public List<TareaMigrarComisionDto> findCalculoComisionByTareaActual(TareaDto tarea) {
    return this.tareaMigrarComisionRepositoryCustom.findCalculoComisionByTareaActual(tarea);
  }

  @Override
  public List<TareaMigrarComisionDto> deleteCalculoComisionByTareaActual(@NotNull final RunTareaDto runTareaDto,
      @NotNull final TareaAmbitoDto tareaAmbitoDto) {
    return this.tareaMigrarComisionRepositoryCustom.deleteCalculoComisionByTareaActual(runTareaDto, tareaAmbitoDto);
  }

  @Override
  public void migrarCalculoComision(RunTareaDto runTareaDto, List<TareaMigrarComisionDto> deleteMigracion) {
    try {

      // New Topic
      final List<CommisionCalculationUpdate> updateLists =
          this.splitListUtils.splitCommisionCalculationUpdateEventList(runTareaDto.getTarea().getId(),
              this.commisionCalculationUpdateEventMapper.tareaMigrarComisionDtoListToCCommisionCalculationUpdateEventList(
                  this.findCalculoComisionByTareaActual(runTareaDto.getTarea())));

      LOG.info("[{}] [{}] :: Commission calculation total size {}  ", runTareaDto.getTrabajo().getId(),
          runTareaDto.getTarea().getId(), updateLists.size());
      // Send the topic
      if (!updateLists.isEmpty()) {
        updateLists.forEach(updateList -> {
          this.commisionCalculationProducer.sendMessageV3Update(updateList);
        });
      }
      // Send the delete topic
      final List<CommisionCalculationDelete> deleteLists =
          this.splitListUtils.splitCommisionCalculationDeleteEventList(runTareaDto.getTarea().getId(),
              this.commisionCalculationDeleteEventMapper.tareaMigrarComisionDtoListToCCommisionCalculationDeleteEventList(
                  deleteMigracion));
      if (!deleteLists.isEmpty()) {
        deleteLists.forEach(deleteList -> {
          this.commisionCalculationProducer.sendMessageV3Delete(deleteList);
        });
      }

    } catch (final Exception e) {
      LOG.error("[{}] [{}] :: Error invoking producer to migrate commission calculation", runTareaDto.getTrabajo().getId(),
          runTareaDto.getTarea().getId(), e);
      throw e;
    }
  }
}
