package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarCondicionesResaltaSinChallengeService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaAmbitoValidarCondicionesResaltaSinChallengeServiceImpl implements
    RunTareaAmbitoValidarCondicionesResaltaSinChallengeService {

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Autowired
  private ComisAsyncService comisAsyncService;

  @Autowired
  private ValidacionMapper validacionMapper;

  @Autowired
  @Qualifier("resaltaProperties")
  private PrevalidarPropertiesDto resaltaProperties;

  @Autowired
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public ValidacionDto execute(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito,
      @Valid final TareaFaseAccionDto tareaFaseAccion) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final TareaDto tareaDto = runTareaDto.getTarea();
    final List<IdPersonaLocalDto> resaltaValidationResult;
    try {
      final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cfCondicionesResalta = this.comisAsyncService
          .findCondicionesResaltaSinChallenge(runTareaDto, tareaAmbito);
      AsyncUtils.exceptionally(cfCondicionesResalta, cf);

      AsyncUtils.waitAllOfIsOk(cf, cf);

      final List<IdPersonaLocalCondicionesDto> condicionesResalta = AsyncUtils.get(cfCondicionesResalta);

      this.primaryTemporaryTableRepositoryCustom.createTempComisResalta();
      this.primaryTemporaryTableRepositoryCustom.insertTempComisResalta(condicionesResalta);

      this.primaryTemporaryTableRepositoryCustom
          .mergeDateRangesSeccionNotEqualsTempComisResalta(tareaDto);
      this.primaryTemporaryTableRepositoryCustom
          .mergeDateRangesTempComisResalta(tareaDto);

      resaltaValidationResult = this.primaryTemporaryTableRepositoryCustom
          .validateTempComisResalta(tareaDto);

      this.primaryTemporaryTableRepositoryCustom.deleteTempComisResalta();

    } catch (final Exception e) {
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
          EstadoTareaFaseAccionEnum.ERROR.getDto());
      AsyncUtils.cancel(cf);
      throw e;
    }
    return this.validacionMapper.idPersonaLocalDtoTovalidacionDto(tareaAmbito, tareaFaseAccion,
        resaltaValidationResult, this.resaltaProperties, tareaDto);
  }
}
