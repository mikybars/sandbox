package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;

import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.CarenciasApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.ComisionesManualesApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.CondicionesApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.ExternosApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.IncidenciasApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.MotivosDesplazamientoApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.PersonasApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.PresenciasApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.ValidacionesApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarCarenciasDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarComisionesManualDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarCondicionesDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarExternosDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarIncidenciasDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarMotivosDesplazamientoDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarPersonasDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarPresenciasDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.ValidarTempComisRecuperarFranciaDto;
import com.inditex.rrhh.icmclcwb.api.app.ComisClaseEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalComisionManualDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ComisService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalFechaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.annotation.NuevoMotor;
import com.inditex.rrhh.icmclcwb.model.app.mapper.ComisClientMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * COMIS implementation backed by Facade COMIS REST APIs.
 *
 * <p>Replaces direct database access ({@code ComisRepositoryCustom}) with calls to the COMIS facade REST API, passing the
 * {@code X-Origin-Id} header to route each request to the correct COMIS SQL Server database.
 *
 * <p>Active only when {@code app.motor-calculo.nuevo.enabled=true}.
 */
@Service
@Validated
@NuevoMotor
@RequiredArgsConstructor
public class RestComisService implements ComisService {

  @Qualifier("presenciasComisApiClient")
  private final PresenciasApi presenciasApi;

  @Qualifier("carenciasComisApiClient")
  private final CarenciasApi carenciasApi;

  @Qualifier("comisionesManualesComisApiClient")
  private final ComisionesManualesApi comisionesManualesApi;

  @Qualifier("condicionesComisApiClient")
  private final CondicionesApi condicionesApi;

  @Qualifier("externosComisApiClient")
  private final ExternosApi externosApi;

  @Qualifier("incidenciasComisApiClient")
  private final IncidenciasApi incidenciasApi;

  @Qualifier("motivosDesplazamientoComisApiClient")
  private final MotivosDesplazamientoApi motivosDesplazamientoApi;

  @Qualifier("personasComisApiClient")
  private final PersonasApi personasApi;

  @Qualifier("validacionesComisApiClient")
  private final ValidacionesApi validacionesApi;

  private final TareaAmbitoGlobalFechaService tareaAmbitoGlobalFechaService;

  private final ComisClientMapper comisClientMapper;

  @Override
  public PresenciaOrigenDto findPresenciasOrigenAndFecha(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarPresenciasDto request = new BuscarPresenciasDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .ambito(this.comisClientMapper.toDto(tareaAmbito));
    return this.comisClientMapper.toDto(
        this.presenciasApi.buscarPresencias(request, this.buildXOriginId(runTareaDto, tareaAmbito)));
  }

  @Override
  public List<IdMotivoDesplazamientoDto> findMotivoDesplazamiento(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarMotivosDesplazamientoDto request = new BuscarMotivosDesplazamientoDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()));
    return this.comisClientMapper.toApiMotivoDesplazamientoList(
        this.motivosDesplazamientoApi.buscarMotivosDesplazamiento(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalFechaIncidenciaDto> findFechasIncidencias(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarIncidenciasDto request = new BuscarIncidenciasDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarIncidenciasDto.TipoEnum.INCIDENCIAS);
    return this.comisClientMapper.toApiFechaIncidenciaList(
        this.incidenciasApi.buscarIncidencias(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalFechaIncidenciaDto> findFechasDesplazamientos(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarIncidenciasDto request = new BuscarIncidenciasDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarIncidenciasDto.TipoEnum.DESPLAZAMIENTOS);
    return this.comisClientMapper.toApiFechaIncidenciaList(
        this.incidenciasApi.buscarIncidencias(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesHistorico(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarCondicionesDto request = new BuscarCondicionesDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarCondicionesDto.TipoEnum.HISTORICO)
        .variante(BuscarCondicionesDto.VarianteEnum.ESTANDAR)
        .periodoAmpliado(this.comisClientMapper.toDto(
            this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                runTareaDto.getTarea().getId(), TipoDatoEnum.PERIODO_AMPLIADO.getId())));
    return this.comisClientMapper.toApiCondicionesList(
        this.condicionesApi.buscarCondiciones(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesHistoricoEs(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarCondicionesDto request = new BuscarCondicionesDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarCondicionesDto.TipoEnum.HISTORICO)
        .variante(BuscarCondicionesDto.VarianteEnum.ES);
    return this.comisClientMapper.toApiCondicionesList(
        this.condicionesApi.buscarCondiciones(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamiento(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarCondicionesDto request = new BuscarCondicionesDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarCondicionesDto.TipoEnum.DESPLAZAMIENTO)
        .variante(BuscarCondicionesDto.VarianteEnum.ESTANDAR)
        .periodoAmpliado(this.comisClientMapper.toDto(
            this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                runTareaDto.getTarea().getId(), TipoDatoEnum.PERIODO_AMPLIADO.getId())));
    return this.comisClientMapper.toApiCondicionesList(
        this.condicionesApi.buscarCondiciones(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamientoEs(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarCondicionesDto request = new BuscarCondicionesDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarCondicionesDto.TipoEnum.DESPLAZAMIENTO)
        .variante(BuscarCondicionesDto.VarianteEnum.ES)
        .periodoAmpliado(this.comisClientMapper.toDto(
            this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                runTareaDto.getTarea().getId(), TipoDatoEnum.PERIODO_AMPLIADO.getId())));
    return this.comisClientMapper.toApiCondicionesList(
        this.condicionesApi.buscarCondiciones(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesResalta(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarCondicionesDto request = new BuscarCondicionesDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarCondicionesDto.TipoEnum.RESALTA)
        .variante(BuscarCondicionesDto.VarianteEnum.ESTANDAR);
    return this.comisClientMapper.toApiCondicionesList(
        this.condicionesApi.buscarCondiciones(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesResaltaSinPrimas(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarCondicionesDto request = new BuscarCondicionesDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarCondicionesDto.TipoEnum.RESALTA_SIN_PRIMAS);
    return this.comisClientMapper.toApiCondicionesList(
        this.condicionesApi.buscarCondiciones(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesResaltaEs(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarCondicionesDto request = new BuscarCondicionesDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarCondicionesDto.TipoEnum.RESALTA)
        .variante(BuscarCondicionesDto.VarianteEnum.ES);
    return this.comisClientMapper.toApiCondicionesList(
        this.condicionesApi.buscarCondiciones(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesPrimas(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarCondicionesDto request = new BuscarCondicionesDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarCondicionesDto.TipoEnum.PRIMAS);
    return this.comisClientMapper.toApiCondicionesList(
        this.condicionesApi.buscarCondiciones(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findBajasIt(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarCondicionesDto request = new BuscarCondicionesDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarCondicionesDto.TipoEnum.BAJAS_IT)
        .variante(BuscarCondicionesDto.VarianteEnum.ESTANDAR)
        .periodoAmpliado(this.comisClientMapper.toDto(
            this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                runTareaDto.getTarea().getId(), TipoDatoEnum.PERIODO_AMPLIADO.getId())));
    return this.comisClientMapper.toApiCondicionesList(
        this.condicionesApi.buscarCondiciones(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalCarenciaDto> findCarencia(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarCarenciasDto request = new BuscarCarenciasDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()));
    return this.comisClientMapper.toApiCarenciaList(
        this.carenciasApi.buscarCarencias(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalExternaDto> findExternosByClase(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito, final ComisClaseEmpleadoEnum clase) {
    final BuscarExternosDto request = new BuscarExternosDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarExternosDto.TipoEnum.CLASE)
        .clase(BuscarExternosDto.ClaseEnum.fromValue(clase.getId()));
    return this.comisClientMapper.toApiExternosList(
        this.externosApi.buscarExternos(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalExternaDto> findExternosByMinIdPersona(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito, @NotNull @Positive final Long minIdPersona) {
    final BuscarExternosDto request = new BuscarExternosDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarExternosDto.TipoEnum.MIN_ID_PERSONA)
        .minIdPersona(minIdPersona);
    return this.comisClientMapper.toApiExternosList(
        this.externosApi.buscarExternos(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findBajasItEs(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarCondicionesDto request = new BuscarCondicionesDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarCondicionesDto.TipoEnum.BAJAS_IT)
        .variante(BuscarCondicionesDto.VarianteEnum.ES);
    return this.comisClientMapper.toApiCondicionesList(
        this.condicionesApi.buscarCondiciones(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesHistoricoSinChallenge(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarCondicionesDto request = new BuscarCondicionesDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarCondicionesDto.TipoEnum.HISTORICO)
        .variante(BuscarCondicionesDto.VarianteEnum.SIN_CHALLENGE)
        .periodoAmpliado(this.comisClientMapper.toDto(
            this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                runTareaDto.getTarea().getId(), TipoDatoEnum.PERIODO_AMPLIADO.getId())));
    return this.comisClientMapper.toApiCondicionesList(
        this.condicionesApi.buscarCondiciones(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamientoSinChallenge(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarCondicionesDto request = new BuscarCondicionesDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarCondicionesDto.TipoEnum.DESPLAZAMIENTO)
        .variante(BuscarCondicionesDto.VarianteEnum.SIN_CHALLENGE)
        .periodoAmpliado(this.comisClientMapper.toDto(
            this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                runTareaDto.getTarea().getId(), TipoDatoEnum.PERIODO_AMPLIADO.getId())));
    return this.comisClientMapper.toApiCondicionesList(
        this.condicionesApi.buscarCondiciones(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesResaltaSinChallenge(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarCondicionesDto request = new BuscarCondicionesDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarCondicionesDto.TipoEnum.RESALTA)
        .variante(BuscarCondicionesDto.VarianteEnum.SIN_CHALLENGE);
    return this.comisClientMapper.toApiCondicionesList(
        this.condicionesApi.buscarCondiciones(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalComisionManualDto> findComisionManual(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarComisionesManualDto request = new BuscarComisionesManualDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()));
    return this.comisClientMapper.toApiComisionManualList(
        this.comisionesManualesApi.buscarComisionesManual(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalLocalizacionDto> findPersonas(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito, @NotNull final Long maxIdPersona) {
    final BuscarPersonasDto request = new BuscarPersonasDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarPersonasDto.TipoEnum.ESTANDAR)
        .maxIdPersona(maxIdPersona);
    return this.comisClientMapper.toApiLocalizacionList(
        this.personasApi.buscarPersonas(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalLocalizacionDto> findPersonasSil(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito, @NotNull final Long maxIdPersona,
      @Valid final ClaseResultItemDto clase) {
    final BuscarPersonasDto.TipoEnum tipo = CollectionUtils.isNotEmpty(clase.getIdsEstadoSil())
        ? BuscarPersonasDto.TipoEnum.SIL_CON_ESTADO
        : BuscarPersonasDto.TipoEnum.SIL_SIN_ESTADO;
    final BuscarPersonasDto request = new BuscarPersonasDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(tipo)
        .maxIdPersona(maxIdPersona)
        .clase(this.comisClientMapper.toDto(clase));
    return this.comisClientMapper.toApiLocalizacionList(
        this.personasApi.buscarPersonas(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesHistoricoChallengeIncluidoPorcentaje(
      @Valid final RunTareaDto runTareaDto, @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarCondicionesDto request = new BuscarCondicionesDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarCondicionesDto.TipoEnum.HISTORICO)
        .variante(BuscarCondicionesDto.VarianteEnum.CHALLENGE_INCLUIDO_PORCENTAJE)
        .periodoAmpliado(this.comisClientMapper.toDto(
            this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                runTareaDto.getTarea().getId(), TipoDatoEnum.PERIODO_AMPLIADO.getId())));
    return this.comisClientMapper.toApiCondicionesList(
        this.condicionesApi.buscarCondiciones(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamientoChallengeIncluidoPorcentaje(
      @Valid final RunTareaDto runTareaDto, @Valid final TareaAmbitoDto tareaAmbito) {
    final BuscarCondicionesDto request = new BuscarCondicionesDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()))
        .tipo(BuscarCondicionesDto.TipoEnum.DESPLAZAMIENTO)
        .variante(BuscarCondicionesDto.VarianteEnum.CHALLENGE_INCLUIDO_PORCENTAJE)
        .periodoAmpliado(this.comisClientMapper.toDto(
            this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                runTareaDto.getTarea().getId(), TipoDatoEnum.PERIODO_AMPLIADO.getId())));
    return this.comisClientMapper.toApiCondicionesList(
        this.condicionesApi.buscarCondiciones(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  @Override
  public List<IdPersonaLocalDto> validateTempComisRecuperarFrancia(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    final ValidarTempComisRecuperarFranciaDto request = new ValidarTempComisRecuperarFranciaDto()
        .tarea(this.comisClientMapper.toDto(runTareaDto.getTarea()));
    return this.comisClientMapper.toApiPersonaLocalList(
        this.validacionesApi.validarTempComisRecuperarFrancia(request, this.buildXOriginId(runTareaDto, tareaAmbito)).getData());
  }

  /**
   * Builds the {@code X-Origin-Id} header value used to route requests to the correct COMIS SQL Server database instance.
   *
   * <p>For Spain ({@code cclIdOrigen = "11"}) the routing key includes the legal entity ({@code cclIdOrigen_stdIdLegEnt}). For all other
   * origins only {@code cclIdOrigen} is used.
   *
   * @param runTareaDto task execution payload.
   * @param tareaAmbito task scope payload.
   * @return the X-Origin-Id header value.
   */
  private String buildXOriginId(final RunTareaDto runTareaDto, final TareaAmbitoDto tareaAmbito) {
    if (AppConstants.ID_ORIGEN_SPAIN.equals(tareaAmbito.getCclIdOrigen())) {
      return tareaAmbito.getCclIdOrigen() + AppConstants.UNDERSCORE + runTareaDto.getTarea().getStdIdLegEnt();
    }
    return tareaAmbito.getCclIdOrigen();
  }

}
