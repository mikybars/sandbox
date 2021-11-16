package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.async.service.PtrAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarPresenciasEsService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaAmbitoValidarPresenciasEsServiceImpl implements RunTareaAmbitoValidarPresenciasEsService {

  @Autowired
  private ComisAsyncService comisAsyncService;

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Autowired
  private PtrAsyncService ptrAsyncService;

  @Autowired
  private ValidacionMapper validacionMapper;

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public ValidacionDto execute(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito,
      @Valid final TareaFaseAccionDto tareaFaseAccion) {
    boolean validacion = Boolean.FALSE;
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final CompletableFuture<PresenciaOrigenDto> cfPresenciaComis = this.comisAsyncService
          .findPresenciasOrigenAndFecha(runTareaDto, tareaAmbito);
      AsyncUtils.exceptionally(cfPresenciaComis, cf);

      final CompletableFuture<PresenciaOrigenDto> cfPresenciaPtr = this.ptrAsyncService
          .findPresenciasOrigenAndFechaEs(runTareaDto, tareaAmbito);
      AsyncUtils.exceptionally(cfPresenciaPtr, cf);

      AsyncUtils.waitAllOfIsOk(cf, cf);

      final PresenciaOrigenDto presenciaComis = AsyncUtils.get(cfPresenciaComis);
      final PresenciaOrigenDto presenciaPtr = AsyncUtils.get(cfPresenciaPtr);

      validacion = presenciaComis.getHorasSeccion4().equals(presenciaPtr.getHorasSeccion4());

    } catch (final Exception e) {
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
          EstadoTareaFaseAccionEnum.ERROR.getDto());
      AsyncUtils.cancel(cf);
      throw e;
    }
    return this.validacionMapper.booleanToValidacionDto(tareaAmbito, tareaFaseAccion, validacion);
  }

}
