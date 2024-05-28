package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarFechasService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaAmbitoValidarFechasServiceImpl implements RunTareaAmbitoValidarFechasService {

  @Autowired
  private ComisAsyncService comisAsyncService;

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Autowired
  private ValidacionMapper validacionMapper;

  @Autowired
  @Qualifier("fechasProperties")
  private PrevalidarPropertiesDto fechasProperties;

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public ValidacionDto execute(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito,
      @Valid final TareaFaseAccionDto tareaFaseAccion) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<IdPersonaLocalFechaIncidenciaDto> incidencias = new ArrayList<>();
    try {
      final CompletableFuture<List<IdPersonaLocalFechaIncidenciaDto>> cfIncidencias = this.comisAsyncService
          .findFechasIncidencias(runTareaDto, tareaAmbito);
      AsyncUtils.exceptionally(cfIncidencias, cf);

      final CompletableFuture<List<IdPersonaLocalFechaIncidenciaDto>> cfDesplazamientos = this.comisAsyncService
          .findFechasDesplazamientos(runTareaDto, tareaAmbito);

      AsyncUtils.exceptionally(cfDesplazamientos, cf);

      AsyncUtils.waitAllOfIsOk(cf, cf);
      incidencias.addAll(AsyncUtils.get(cfIncidencias));
      incidencias.addAll(AsyncUtils.get(cfDesplazamientos));

    } catch (final Exception e) {
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
          EstadoTareaFaseAccionEnum.ERROR.getDto());
      AsyncUtils.cancel(cf);
      throw e;
    }
    return this.validacionMapper.idPersonaLocalFechaIncidenciaDtoToValidacionDto(tareaAmbito, tareaFaseAccion,
        incidencias, this.fechasProperties);
  }

}
