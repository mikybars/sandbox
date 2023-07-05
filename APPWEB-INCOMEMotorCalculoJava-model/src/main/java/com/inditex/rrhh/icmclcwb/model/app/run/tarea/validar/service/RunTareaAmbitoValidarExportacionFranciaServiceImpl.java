package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarExportacionFranciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaAmbitoValidarExportacionFranciaServiceImpl implements RunTareaAmbitoValidarExportacionFranciaService {

  public static final String COMIS = "COMIS";

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Autowired
  private TareaAmbitoLocalizacionService tareaAmbitoLocalizacionService;

  @Autowired
  private TareaAmbitoPersonaService tareaAmbitoPersonaService;

  @Autowired
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @Autowired
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Autowired
  private Logger log;

  @Autowired
  @Qualifier("carenciaProperties")
  private PrevalidarPropertiesDto carenciaProperties;

  @Autowired
  private ValidacionMapper validacionMapper;

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public ValidacionDto execute(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito,
      @Valid final TareaFaseAccionDto tareaFaseAccion) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<IdPersonaLocalDto> personas;
    final TrabajoDTO trabajo = runTareaDto.getTrabajo();
    final TareaDto tarea = runTareaDto.getTarea();
    PlanificacionResponseDto planificacion = new PlanificacionResponseDto();

    try {
      final PlanificacionRequestDto request = new PlanificacionRequestDto();
      final PlanificacionFilterParametersDto parameters = new PlanificacionFilterParametersDto();
      final PlanificacionFilterDto filter = new PlanificacionFilterDto();

      parameters.setIdPeriodo(trabajo.getIcmIdPeriodo());
      parameters.setProceso(COMIS);
      parameters.setFecFin(tarea.getFechaFinPeriodo());
      parameters.setFecPro(trabajo.getFechaHoraCreacion().toLocalDateTime().withNano(0));
      parameters.setListaEmpresas(tarea.getStdIdLegEnt());
      parameters.setIdOrigen(tareaAmbito.getCclIdOrigen());

      if (TipoAmbitoEnum.SOCIEDAD.getId().equals(trabajo.getTipoAmbito().getId())
          || TipoAmbitoEnum.ORIGEN.getId().equals(trabajo.getTipoAmbito().getId())
          || TipoAmbitoEnum.EMPRESA.getId().equals(trabajo.getTipoAmbito().getId())) {
        parameters.setIdAmbito(TipoAmbitoEnum.EMPRESA.getId());

      } else if (TipoAmbitoEnum.LOCALIZACION.getId().equals(trabajo.getTipoAmbito().getId())) {
        parameters.setIdAmbito(trabajo.getTipoAmbito().getId());

        final List<TareaAmbitoLocalizacionDto> localizacion = this.tareaAmbitoLocalizacionService.findByTarea(tarea);

        parameters.setListaTiendas(localizacion.stream().map(e -> e.getStdIdWorkLocat()).collect(Collectors.joining(",")));

      } else if (TipoAmbitoEnum.PERSONA.getId().equals(trabajo.getTipoAmbito().getId())) {
        parameters.setIdAmbito(trabajo.getTipoAmbito().getId());

        final List<TareaAmbitoPersonaDto> persona = this.tareaAmbitoPersonaService.findByTarea(tarea);

        parameters.setListaEmpleados(persona.stream().map(e -> e.getCclIdPerson()).collect(Collectors.joining(",")));

      } else {
        throw new IcmclcwbException("El tipo ambito no esta soportado");
      }

      filter.setItems(Arrays.asList(parameters));
      request.setData(filter);
      planificacion = this.meta4IcmWsCalcIncomeService.planificacion(request);

      planificacion.getData().stream().filter(e -> e.getResultado().equals("KO"))
          .forEach(e -> e.getAvisos().getAvisos().stream().forEach(f -> {
            this.log.warn("Aviso: Registro afectado:" + f.getRegistroAfectado());
          }));

      planificacion.getData().stream().filter(e -> e.getResultado().equals("KO"))
          .forEach(e -> e.getErrores().getErrores().stream().forEach(f -> {
            this.log.warn("Error: Registro afectado:" + f.getRegistroAfectado());
          }));
    } catch (final Exception e) {
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
          EstadoTareaFaseAccionEnum.ERROR.getDto());
      AsyncUtils.cancel(cf);
      throw e;
    }
    return this.validacionMapper.booleanToValidacionDto(tareaAmbito, tareaFaseAccion, true);

  }
}
