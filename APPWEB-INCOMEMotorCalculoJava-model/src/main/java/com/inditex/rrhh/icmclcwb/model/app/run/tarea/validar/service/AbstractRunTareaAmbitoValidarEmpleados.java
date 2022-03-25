package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractRunTareaAmbitoValidarEmpleados {

  @Autowired
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @Autowired
  private ValidacionMapper validacionMapper;

  @Autowired
  @Qualifier("personasProperties")
  private PrevalidarPropertiesDto personasProperties;

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  /**
   * Obtiene las personas de Comis y sus tiendas.
   *
   * @param runTarea runTarea
   * @param tareaAmbito tareaAmbito
   * @return Lista de personas y tiendas.
   */
  protected abstract List<IdPersonaLocalLocalizacionDto> obtenerEmpleadosComis(@Valid final RunTareaDto runTarea,
      @Valid final TareaAmbitoDto tareaAmbito);

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public ValidacionDto execute(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito,
      final TareaFaseAccionDto tareaFaseAccion) {

    final TareaDto tarea = runTarea.getTarea();
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    List<IdPersonaLocalDto> validationResult = new ArrayList<>();
    try {

      final List<IdPersonaLocalLocalizacionDto> personasComis = this.obtenerEmpleadosComis(runTarea, tareaAmbito);

      // guardado de la info de comis en una tabla temporal
      this.primaryTemporaryTableRepositoryCustom.createTempComisPersonasLocalizaciones();
      this.primaryTemporaryTableRepositoryCustom.indexTempComisPersonasLocalizaciones();
      this.primaryTemporaryTableRepositoryCustom.insertTempComisPersonasLocalizaciones(personasComis);

      // comparar la info de la tabla temporal con los datos de Income
      validationResult = this.primaryTemporaryTableRepositoryCustom.validateTempComisPersonas(tarea);

    } catch (final Exception e) {
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion, EstadoTareaFaseAccionEnum.ERROR.getDto());
      AsyncUtils.cancel(cf);
      throw e;
    } finally {
      this.primaryTemporaryTableRepositoryCustom.deleteTempComisPersonasLocalizaciones();
    }
    return this.validacionMapper
        .idPersonaLocalDtoTovalidacionDto(tareaAmbito, tareaFaseAccion, validationResult, this.personasProperties, tarea);
  }

}
