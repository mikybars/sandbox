package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.SincronizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarPresenciasMismaFechaDistintaTiendaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPresenciasMismaFechaDistintaTiendaService;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionDatoServiceImpl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaAmbitoValidarPresenciasMismaFechaDistintaTiendaServiceImpl
    implements RunTareaAmbitoValidarPresenciasMismaFechaDistintaTiendaService {

  private static final Logger LOG = LoggerFactory.getLogger(RunTareaAmbitoValidarPresenciasMismaFechaDistintaTiendaServiceImpl.class);

  private final TareaFaseAccionDatoServiceImpl tareaFaseAccionFallidasService;

  private final TareaCalculoPresenciasMismaFechaDistintaTiendaService tareaCalculoPresenciasMismaFechaDistintaTienda;

  private final ValidacionMapper validacionMapper;

  @Override
  public ValidacionDto execute(RunTareaDto runTareaDto, TareaAmbitoDto tareaAmbito, TareaFaseAccionDto tareaFaseAccion) {

    final List<IdPersonaLocalDto> empleadosPresenciasMismaFechaDistintaTiendaValidationResult;
    final List<TareaFaseAccionDatoDto> tareaFaseAccionDatoList = new ArrayList<>();

    try {
      empleadosPresenciasMismaFechaDistintaTiendaValidationResult =
          this.tareaCalculoPresenciasMismaFechaDistintaTienda.findPersonaPresenciasMismaFechaDistintaTienda(
              tareaAmbito.getIdTarea());

      LOG.info("Trabajo[{}]Tarea[{}] :: Validación empleados presencias misma fecha distinta tienda - Empleados encontrados: {}",
          runTareaDto.getTrabajo().getId(), runTareaDto.getTarea().getId(),
          empleadosPresenciasMismaFechaDistintaTiendaValidationResult != null
              ? empleadosPresenciasMismaFechaDistintaTiendaValidationResult.size()
              : 0);

      if (empleadosPresenciasMismaFechaDistintaTiendaValidationResult != null
          && !empleadosPresenciasMismaFechaDistintaTiendaValidationResult.isEmpty()) {
        empleadosPresenciasMismaFechaDistintaTiendaValidationResult
            .forEach(
                empleado -> tareaFaseAccionDatoList.add(TareaFaseAccionDatoDto.builder().idTareaFaseAccion(tareaFaseAccion.getId())
                    .idTipoDato(TipoDatoEnum.PERSONA.getId()).dato(empleado.getIdPersonaLocal()).build()));
        this.tareaFaseAccionFallidasService.save(tareaFaseAccionDatoList);
      }

      return this.validacionMapper.idPersonaLocalDtoTovalidacionDto(tareaAmbito, tareaFaseAccion,
          empleadosPresenciasMismaFechaDistintaTiendaValidationResult,
          PrevalidarPropertiesDto.builder().sincronizacion(SincronizacionDto.builder().activo(false).build()).build(),
          runTareaDto.getTarea());

    } catch (final Exception e) {
      RunTareaAmbitoValidarPresenciasMismaFechaDistintaTiendaServiceImpl.LOG.error(
          "Trabajo[{}]Tarea[{}] :: Error :: RunTareaAmbitoValidarPresenciasMismaFechaDistintaTiendaServiceImpl :: "
              + "empleadosPresenciasMismaFechaDistintaTienda",
          runTareaDto.getTrabajo().getId(), runTareaDto.getTarea().getId(), e);
      return this.validacionMapper.booleanToValidacionDto(tareaAmbito, tareaFaseAccion, true);
    }
  }
}
