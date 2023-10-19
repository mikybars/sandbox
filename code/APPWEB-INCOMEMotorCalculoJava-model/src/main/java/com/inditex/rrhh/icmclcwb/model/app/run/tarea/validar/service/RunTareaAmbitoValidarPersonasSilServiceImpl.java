package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarPersonasSilService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ClasePersonaSilAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.ClasePersonaSilAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
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
public class RunTareaAmbitoValidarPersonasSilServiceImpl implements RunTareaAmbitoValidarPersonasSilService {

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Autowired
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Autowired
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @Autowired
  private ComisAsyncService comisAsyncService;

  @Autowired
  private ValidacionMapper validacionMapper;

  @Autowired
  private Logger log;

  @Autowired
  private ClasePersonaSilAmbitoService clasePersonaSilAmbitoService;

  @Autowired
  @Qualifier("personasProperties")
  private PrevalidarPropertiesDto personasProperties;

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public ValidacionDto execute(
      @Valid final RunTareaDto runTarea,
      @Valid final TareaAmbitoDto tareaAmbito,
      @Valid final TareaFaseAccionDto tareaFaseAccion) {

    final TareaDto tarea = runTarea.getTarea();
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    List<IdPersonaLocalDto> validationResult = new ArrayList<>();
    try {

      final List<IdPersonaLocalLocalizacionDto> personasComis = new ArrayList<>();

      // llamar a Meta4 para obtener las clases y/o estado SIL
      // final ClaseRequestDto request = ClaseRequestDto.builder().cclIdOrigen(tareaAmbito.getCclIdOrigen()).build();
      // final ClaseResponseDto clases = this.meta4IcmWsCalcIncomeService.getClases(request);

      // Establecemos de manera estática las clases/estados porque son los que Sil usa en este momento
      final ClaseResponseDto clases = ClaseResponseDto.builder().build();

      final List<ClaseResultItemDto> clasesItems = new ArrayList<>();
      final List<ClasePersonaSilAmbitoDto> clasesEstados = this.clasePersonaSilAmbitoService
          .getClaseAndEstadoByCclIdOrigenAndStdIdLegEnt(tareaAmbito.getCclIdOrigen(), tarea.getStdIdLegEnt());

      clasesEstados.stream().collect(groupingBy(ClasePersonaSilAmbitoDto::getClase))
          .forEach((clase, list) -> {
            clasesItems.add(ClaseResultItemDto.builder()
                .idOrigen(list.get(0).getCclIdOrigen())
                .idClase(clase.toString())
                .idsEstadoSil(list.stream().map(ClasePersonaSilAmbitoDto::getEstado).map(estado -> estado.toString())
                    .collect(Collectors.toList()))
                .build());
          });

      clases.setItems(clasesItems);

      // obtención de las personas desde Comis usando las clases y estaod SIL
      final List<CompletableFuture<List<IdPersonaLocalLocalizacionDto>>> cfsPersonas = new ArrayList<>();
      clases.getItems().forEach(clase -> {
        final CompletableFuture<List<IdPersonaLocalLocalizacionDto>> cfPersonas =
            this.comisAsyncService.findPersonasSil(runTarea, tareaAmbito, AppConstants.MIN_ID_PERSONA_EXTERNO_NO_ES, clase);
        AsyncUtils.exceptionally(cfPersonas, cf);
        cfsPersonas.add(cfPersonas);
      });

      AsyncUtils.waitAllOfIsOk(cf, cf);
      cfsPersonas.forEach(cfPersonas -> personasComis.addAll(AsyncUtils.get(cfPersonas)));

      // guardado de la info de comis en una tabla temporal
      this.primaryTemporaryTableRepositoryCustom.createTempComisPersonasLocalizaciones();
      this.primaryTemporaryTableRepositoryCustom.indexTempComisPersonasLocalizaciones();
      this.primaryTemporaryTableRepositoryCustom.insertTempComisPersonasLocalizaciones(personasComis);

      // comparar la info de la tabla temporal con los datos de Income
      validationResult = this.primaryTemporaryTableRepositoryCustom.validateTempComisPersonas(tarea);
      this.log.info("Trabajo[{}]Tarea[{}] :: Ok :: RunTareaAmbitoValidarPersonasSilServiceImpl :: PersonasSil: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getIdTrabajo(), validationResult);

    } catch (final Exception e) {
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion, EstadoTareaFaseAccionEnum.ERROR.getDto());
      AsyncUtils.cancel(cf);
      this.log.error("Trabajo[{}]Tarea[{}] :: Fin :: RunTareaAmbitoValidarPersonasSilServiceImpl :: PersonasSil: {}",
          runTarea.getTrabajo().getId(), runTarea.getTarea().getIdTrabajo(), e);
      throw e;
    } finally {
      this.primaryTemporaryTableRepositoryCustom.deleteTempComisPersonasLocalizaciones();
    }
    return this.validacionMapper
        .idPersonaLocalDtoTovalidacionDto(tareaAmbito, tareaFaseAccion, validationResult, this.personasProperties, tarea);

  }
}
