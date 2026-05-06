package com.inditex.rrhh.icmclcwb.model.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
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
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarCarenciasResponseDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarComisionesManualResponseDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarCondicionesDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarCondicionesResponseDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarExternosDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarExternosResponseDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarIncidenciasDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarIncidenciasResponseDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarMotivosDesplazamientoResponseDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarPersonasDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarPersonasResponseDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.ValidarTempComisRecuperarFranciaResponseDto;
import com.inditex.rrhh.icmclcwb.api.app.ComisClaseEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalComisionManualDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalFechaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.ComisClientMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Unit tests for {@link RestComisService}.
 */
@ExtendWith(SpringExtension.class)
class RestComisServiceTest {

  private static final String CCL_ID_ORIGEN_SPAIN = AppConstants.ID_ORIGEN_SPAIN;

  private static final String CCL_ID_ORIGEN_OTHER = "99";

  private static final String STD_ID_LEG_ENT = "001";

  private static final Long TAREA_ID = 1L;

  @Mock
  private PresenciasApi presenciasApi;

  @Mock
  private CarenciasApi carenciasApi;

  @Mock
  private ComisionesManualesApi comisionesManualesApi;

  @Mock
  private CondicionesApi condicionesApi;

  @Mock
  private ExternosApi externosApi;

  @Mock
  private IncidenciasApi incidenciasApi;

  @Mock
  private MotivosDesplazamientoApi motivosDesplazamientoApi;

  @Mock
  private PersonasApi personasApi;

  @Mock
  private ValidacionesApi validacionesApi;

  @Mock
  private TareaAmbitoGlobalFechaService tareaAmbitoGlobalFechaService;

  @Mock
  private ComisClientMapper comisClientMapper;

  @InjectMocks
  private RestComisService service;

  private RunTareaDto runTareaDto;

  private TareaAmbitoDto tareaAmbitoSpain;

  private TareaAmbitoDto tareaAmbitoOther;

  private com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.PeriodoDto clientPeriodoDto;

  @BeforeEach
  void setUp() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(TAREA_ID);
    tarea.setStdIdLegEnt(STD_ID_LEG_ENT);
    tarea.setFechaInicioPeriodo(LocalDate.of(2025, 1, 1));
    tarea.setFechaFinPeriodo(LocalDate.of(2025, 1, 31));
    tarea.setIdTrabajo(10L);
    tarea.setIdOrganization("ORG");

    runTareaDto = RunTareaDto.builder().tarea(tarea).build();

    tareaAmbitoSpain = TareaAmbitoDto.builder().cclIdOrigen(CCL_ID_ORIGEN_SPAIN).build();
    tareaAmbitoOther = TareaAmbitoDto.builder().cclIdOrigen(CCL_ID_ORIGEN_OTHER).build();

    com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.TareaDto clientTareaDto =
        new com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.TareaDto();
    clientPeriodoDto = new com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.PeriodoDto();

    // Common mapper stubs
    when(comisClientMapper.toDto(any(com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto.class)))
        .thenReturn(clientTareaDto);
    when(comisClientMapper.toDto(any(TareaAmbitoDto.class)))
        .thenReturn(new com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.TareaAmbitoDto());
    when(comisClientMapper.toDto(any(PeriodoDto.class)))
        .thenReturn(clientPeriodoDto);
    when(tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
        TAREA_ID, TipoDatoEnum.PERIODO_AMPLIADO.getId()))
            .thenReturn(PeriodoDto.builder()
                .fechaInicioPeriodo(LocalDate.of(2024, 12, 1))
                .fechaFinPeriodo(LocalDate.of(2025, 1, 31))
                .build());
  }

  // -------------------------------------------------------------------------
  // X-Origin-Id routing logic
  // -------------------------------------------------------------------------

  @Test
  void findPresenciasOrigenAndFecha_whenOriginIsSpain_thenXOriginIdIncludesLegalEntity() {
    final var clientResponse = new com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.PresenciaOrigenDto()
        .horasSeccion1(10);
    final String expectedXOriginId = CCL_ID_ORIGEN_SPAIN + "_" + STD_ID_LEG_ENT;
    when(presenciasApi.buscarPresencias(any(), eq(expectedXOriginId))).thenReturn(clientResponse);
    when(comisClientMapper.toDto(clientResponse))
        .thenReturn(PresenciaOrigenDto.builder().horasSeccion1(10).build());

    final PresenciaOrigenDto result = service.findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoSpain);

    assertNotNull(result);
    assertEquals(10, result.getHorasSeccion1());
    verify(presenciasApi).buscarPresencias(any(), eq(expectedXOriginId));
  }

  @Test
  void findPresenciasOrigenAndFecha_whenOriginIsNotSpain_thenXOriginIdIsCclIdOrigen() {
    final var clientResponse = new com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.PresenciaOrigenDto()
        .horasSeccion1(5);
    when(presenciasApi.buscarPresencias(any(), eq(CCL_ID_ORIGEN_OTHER))).thenReturn(clientResponse);
    when(comisClientMapper.toDto(clientResponse))
        .thenReturn(PresenciaOrigenDto.builder().horasSeccion1(5).build());

    final PresenciaOrigenDto result = service.findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoOther);

    assertNotNull(result);
    verify(presenciasApi).buscarPresencias(any(), eq(CCL_ID_ORIGEN_OTHER));
  }

  @Test
  void findPresenciasOrigenAndFecha_whenApiReturnsNull_thenReturnsNull() {
    when(presenciasApi.buscarPresencias(any(), any())).thenReturn(null);
    when(comisClientMapper.toDto((com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.PresenciaOrigenDto) null))
        .thenReturn(null);

    final PresenciaOrigenDto result = service.findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoOther);

    assertNull(result);
  }

  // -------------------------------------------------------------------------
  // Motivos desplazamiento
  // -------------------------------------------------------------------------

  @Test
  void findMotivoDesplazamiento_whenCalled_thenReturnsData() {
    final List<IdMotivoDesplazamientoDto> expected = List.of(new IdMotivoDesplazamientoDto());
    final var response = new BuscarMotivosDesplazamientoResponseDto();
    when(motivosDesplazamientoApi.buscarMotivosDesplazamiento(any(), any())).thenReturn(response);
    when(comisClientMapper.toApiMotivoDesplazamientoList(response.getData())).thenReturn(expected);

    final List<IdMotivoDesplazamientoDto> result = service.findMotivoDesplazamiento(runTareaDto, tareaAmbitoOther);

    assertEquals(expected, result);
    verify(motivosDesplazamientoApi).buscarMotivosDesplazamiento(any(), eq(CCL_ID_ORIGEN_OTHER));
  }

  // -------------------------------------------------------------------------
  // Incidencias
  // -------------------------------------------------------------------------

  @Test
  void findFechasIncidencias_whenCalled_thenCallsApiWithTipoIncidencias() {
    final var captor = ArgumentCaptor.forClass(BuscarIncidenciasDto.class);
    final var response = new BuscarIncidenciasResponseDto();
    final List<IdPersonaLocalFechaIncidenciaDto> expected = List.of(new IdPersonaLocalFechaIncidenciaDto());
    when(incidenciasApi.buscarIncidencias(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiFechaIncidenciaList(response.getData())).thenReturn(expected);

    final List<IdPersonaLocalFechaIncidenciaDto> result = service.findFechasIncidencias(runTareaDto, tareaAmbitoOther);

    assertEquals(expected, result);
    assertEquals(BuscarIncidenciasDto.TipoEnum.INCIDENCIAS, captor.getValue().getTipo());
  }

  @Test
  void findFechasDesplazamientos_whenCalled_thenCallsApiWithTipoDesplazamientos() {
    final var captor = ArgumentCaptor.forClass(BuscarIncidenciasDto.class);
    final var response = new BuscarIncidenciasResponseDto();
    when(incidenciasApi.buscarIncidencias(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiFechaIncidenciaList(response.getData())).thenReturn(List.of());

    service.findFechasDesplazamientos(runTareaDto, tareaAmbitoOther);

    assertEquals(BuscarIncidenciasDto.TipoEnum.DESPLAZAMIENTOS, captor.getValue().getTipo());
  }

  // -------------------------------------------------------------------------
  // Condiciones — tipo + variante verification
  // -------------------------------------------------------------------------

  @Test
  void findCondicionesHistorico_whenCalled_thenCallsApiWithHistoricoEstandarAndPeriodoAmpliado() {
    final var captor = ArgumentCaptor.forClass(BuscarCondicionesDto.class);
    final var response = new BuscarCondicionesResponseDto();
    final List<IdPersonaLocalCondicionesDto> expected = List.of();
    when(condicionesApi.buscarCondiciones(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiCondicionesList(response.getData())).thenReturn(expected);

    final List<IdPersonaLocalCondicionesDto> result = service.findCondicionesHistorico(runTareaDto, tareaAmbitoOther);

    assertEquals(expected, result);
    final BuscarCondicionesDto request = captor.getValue();
    assertEquals(BuscarCondicionesDto.TipoEnum.HISTORICO, request.getTipo());
    assertEquals(BuscarCondicionesDto.VarianteEnum.ESTANDAR, request.getVariante());
    assertEquals(clientPeriodoDto, request.getPeriodoAmpliado());
  }

  @Test
  void findCondicionesHistoricoEs_whenCalled_thenCallsApiWithHistoricoEs() {
    final var captor = ArgumentCaptor.forClass(BuscarCondicionesDto.class);
    final var response = new BuscarCondicionesResponseDto();
    when(condicionesApi.buscarCondiciones(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiCondicionesList(response.getData())).thenReturn(List.of());

    service.findCondicionesHistoricoEs(runTareaDto, tareaAmbitoOther);

    assertEquals(BuscarCondicionesDto.TipoEnum.HISTORICO, captor.getValue().getTipo());
    assertEquals(BuscarCondicionesDto.VarianteEnum.ES, captor.getValue().getVariante());
  }

  @Test
  void findCondicionesDesplazamiento_whenCalled_thenCallsApiWithDesplazamientoEstandarAndPeriodoAmpliado() {
    final var captor = ArgumentCaptor.forClass(BuscarCondicionesDto.class);
    final var response = new BuscarCondicionesResponseDto();
    when(condicionesApi.buscarCondiciones(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiCondicionesList(response.getData())).thenReturn(List.of());

    service.findCondicionesDesplazamiento(runTareaDto, tareaAmbitoOther);

    assertEquals(BuscarCondicionesDto.TipoEnum.DESPLAZAMIENTO, captor.getValue().getTipo());
    assertEquals(BuscarCondicionesDto.VarianteEnum.ESTANDAR, captor.getValue().getVariante());
    assertEquals(clientPeriodoDto, captor.getValue().getPeriodoAmpliado());
  }

  @Test
  void findCondicionesDesplazamientoEs_whenCalled_thenCallsApiWithDesplazamientoEsAndPeriodoAmpliado() {
    final var captor = ArgumentCaptor.forClass(BuscarCondicionesDto.class);
    final var response = new BuscarCondicionesResponseDto();
    when(condicionesApi.buscarCondiciones(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiCondicionesList(response.getData())).thenReturn(List.of());

    service.findCondicionesDesplazamientoEs(runTareaDto, tareaAmbitoOther);

    assertEquals(BuscarCondicionesDto.TipoEnum.DESPLAZAMIENTO, captor.getValue().getTipo());
    assertEquals(BuscarCondicionesDto.VarianteEnum.ES, captor.getValue().getVariante());
  }

  @Test
  void findCondicionesResalta_whenCalled_thenCallsApiWithResaltaEstandar() {
    final var captor = ArgumentCaptor.forClass(BuscarCondicionesDto.class);
    final var response = new BuscarCondicionesResponseDto();
    when(condicionesApi.buscarCondiciones(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiCondicionesList(response.getData())).thenReturn(List.of());

    service.findCondicionesResalta(runTareaDto, tareaAmbitoOther);

    assertEquals(BuscarCondicionesDto.TipoEnum.RESALTA, captor.getValue().getTipo());
    assertEquals(BuscarCondicionesDto.VarianteEnum.ESTANDAR, captor.getValue().getVariante());
  }

  @Test
  void findCondicionesResaltaSinPrimas_whenCalled_thenCallsApiWithResaltaSinPrimas() {
    final var captor = ArgumentCaptor.forClass(BuscarCondicionesDto.class);
    final var response = new BuscarCondicionesResponseDto();
    when(condicionesApi.buscarCondiciones(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiCondicionesList(response.getData())).thenReturn(List.of());

    service.findCondicionesResaltaSinPrimas(runTareaDto, tareaAmbitoOther);

    assertEquals(BuscarCondicionesDto.TipoEnum.RESALTA_SIN_PRIMAS, captor.getValue().getTipo());
  }

  @Test
  void findCondicionesResaltaEs_whenCalled_thenCallsApiWithResaltaEs() {
    final var captor = ArgumentCaptor.forClass(BuscarCondicionesDto.class);
    final var response = new BuscarCondicionesResponseDto();
    when(condicionesApi.buscarCondiciones(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiCondicionesList(response.getData())).thenReturn(List.of());

    service.findCondicionesResaltaEs(runTareaDto, tareaAmbitoOther);

    assertEquals(BuscarCondicionesDto.TipoEnum.RESALTA, captor.getValue().getTipo());
    assertEquals(BuscarCondicionesDto.VarianteEnum.ES, captor.getValue().getVariante());
  }

  @Test
  void findCondicionesPrimas_whenCalled_thenCallsApiWithPrimas() {
    final var captor = ArgumentCaptor.forClass(BuscarCondicionesDto.class);
    final var response = new BuscarCondicionesResponseDto();
    when(condicionesApi.buscarCondiciones(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiCondicionesList(response.getData())).thenReturn(List.of());

    service.findCondicionesPrimas(runTareaDto, tareaAmbitoOther);

    assertEquals(BuscarCondicionesDto.TipoEnum.PRIMAS, captor.getValue().getTipo());
  }

  @Test
  void findBajasIt_whenCalled_thenCallsApiWithBajasItEstandarAndPeriodoAmpliado() {
    final var captor = ArgumentCaptor.forClass(BuscarCondicionesDto.class);
    final var response = new BuscarCondicionesResponseDto();
    when(condicionesApi.buscarCondiciones(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiCondicionesList(response.getData())).thenReturn(List.of());

    service.findBajasIt(runTareaDto, tareaAmbitoOther);

    assertEquals(BuscarCondicionesDto.TipoEnum.BAJAS_IT, captor.getValue().getTipo());
    assertEquals(BuscarCondicionesDto.VarianteEnum.ESTANDAR, captor.getValue().getVariante());
    assertEquals(clientPeriodoDto, captor.getValue().getPeriodoAmpliado());
  }

  @Test
  void findBajasItEs_whenCalled_thenCallsApiWithBajasItEs() {
    final var captor = ArgumentCaptor.forClass(BuscarCondicionesDto.class);
    final var response = new BuscarCondicionesResponseDto();
    when(condicionesApi.buscarCondiciones(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiCondicionesList(response.getData())).thenReturn(List.of());

    service.findBajasItEs(runTareaDto, tareaAmbitoOther);

    assertEquals(BuscarCondicionesDto.TipoEnum.BAJAS_IT, captor.getValue().getTipo());
    assertEquals(BuscarCondicionesDto.VarianteEnum.ES, captor.getValue().getVariante());
  }

  @Test
  void findCondicionesHistoricoSinChallenge_whenCalled_thenCallsApiWithHistoricoSinChallenge() {
    final var captor = ArgumentCaptor.forClass(BuscarCondicionesDto.class);
    final var response = new BuscarCondicionesResponseDto();
    when(condicionesApi.buscarCondiciones(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiCondicionesList(response.getData())).thenReturn(List.of());

    service.findCondicionesHistoricoSinChallenge(runTareaDto, tareaAmbitoOther);

    assertEquals(BuscarCondicionesDto.TipoEnum.HISTORICO, captor.getValue().getTipo());
    assertEquals(BuscarCondicionesDto.VarianteEnum.SIN_CHALLENGE, captor.getValue().getVariante());
    assertEquals(clientPeriodoDto, captor.getValue().getPeriodoAmpliado());
  }

  @Test
  void findCondicionesDesplazamientoSinChallenge_whenCalled_thenCallsApiWithDesplazamientoSinChallenge() {
    final var captor = ArgumentCaptor.forClass(BuscarCondicionesDto.class);
    final var response = new BuscarCondicionesResponseDto();
    when(condicionesApi.buscarCondiciones(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiCondicionesList(response.getData())).thenReturn(List.of());

    service.findCondicionesDesplazamientoSinChallenge(runTareaDto, tareaAmbitoOther);

    assertEquals(BuscarCondicionesDto.TipoEnum.DESPLAZAMIENTO, captor.getValue().getTipo());
    assertEquals(BuscarCondicionesDto.VarianteEnum.SIN_CHALLENGE, captor.getValue().getVariante());
  }

  @Test
  void findCondicionesResaltaSinChallenge_whenCalled_thenCallsApiWithResaltaSinChallenge() {
    final var captor = ArgumentCaptor.forClass(BuscarCondicionesDto.class);
    final var response = new BuscarCondicionesResponseDto();
    when(condicionesApi.buscarCondiciones(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiCondicionesList(response.getData())).thenReturn(List.of());

    service.findCondicionesResaltaSinChallenge(runTareaDto, tareaAmbitoOther);

    assertEquals(BuscarCondicionesDto.TipoEnum.RESALTA, captor.getValue().getTipo());
    assertEquals(BuscarCondicionesDto.VarianteEnum.SIN_CHALLENGE, captor.getValue().getVariante());
  }

  @Test
  void findCondicionesHistoricoChallengeIncluidoPorcentaje_whenCalled_thenCallsApiWithChallengeIncluidoPorcentaje() {
    final var captor = ArgumentCaptor.forClass(BuscarCondicionesDto.class);
    final var response = new BuscarCondicionesResponseDto();
    when(condicionesApi.buscarCondiciones(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiCondicionesList(response.getData())).thenReturn(List.of());

    service.findCondicionesHistoricoChallengeIncluidoPorcentaje(runTareaDto, tareaAmbitoOther);

    assertEquals(BuscarCondicionesDto.TipoEnum.HISTORICO, captor.getValue().getTipo());
    assertEquals(BuscarCondicionesDto.VarianteEnum.CHALLENGE_INCLUIDO_PORCENTAJE, captor.getValue().getVariante());
    assertEquals(clientPeriodoDto, captor.getValue().getPeriodoAmpliado());
  }

  @Test
  void findCondicionesDesplazamientoChallengeIncluidoPorcentaje_whenCalled_thenCallsApiWithChallengeIncluidoPorcentaje() {
    final var captor = ArgumentCaptor.forClass(BuscarCondicionesDto.class);
    final var response = new BuscarCondicionesResponseDto();
    when(condicionesApi.buscarCondiciones(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiCondicionesList(response.getData())).thenReturn(List.of());

    service.findCondicionesDesplazamientoChallengeIncluidoPorcentaje(runTareaDto, tareaAmbitoOther);

    assertEquals(BuscarCondicionesDto.TipoEnum.DESPLAZAMIENTO, captor.getValue().getTipo());
    assertEquals(BuscarCondicionesDto.VarianteEnum.CHALLENGE_INCLUIDO_PORCENTAJE, captor.getValue().getVariante());
  }

  // -------------------------------------------------------------------------
  // Carencias
  // -------------------------------------------------------------------------

  @Test
  void findCarencia_whenCalled_thenReturnsData() {
    final List<IdPersonaLocalCarenciaDto> expected = List.of(new IdPersonaLocalCarenciaDto());
    final var response = new BuscarCarenciasResponseDto();
    when(carenciasApi.buscarCarencias(any(), eq(CCL_ID_ORIGEN_OTHER))).thenReturn(response);
    when(comisClientMapper.toApiCarenciaList(response.getData())).thenReturn(expected);

    final List<IdPersonaLocalCarenciaDto> result = service.findCarencia(runTareaDto, tareaAmbitoOther);

    assertEquals(expected, result);
    verify(carenciasApi).buscarCarencias(any(), eq(CCL_ID_ORIGEN_OTHER));
  }

  // -------------------------------------------------------------------------
  // Externos
  // -------------------------------------------------------------------------

  @Test
  void findExternosByClase_whenCalled_thenCallsApiWithTipoClaseAndMappedClase() {
    final var captor = ArgumentCaptor.forClass(BuscarExternosDto.class);
    final var response = new BuscarExternosResponseDto();
    final List<IdPersonaLocalExternaDto> expected = List.of();
    when(externosApi.buscarExternos(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiExternosList(response.getData())).thenReturn(expected);

    service.findExternosByClase(runTareaDto, tareaAmbitoOther, ComisClaseEmpleadoEnum.EMPLEADO_EXTERNO_BRASIL);

    assertEquals(BuscarExternosDto.TipoEnum.CLASE, captor.getValue().getTipo());
    assertEquals(BuscarExternosDto.ClaseEnum.EMPLEADO_EXTERNO_BRASIL, captor.getValue().getClase());
  }

  @Test
  void findExternosByClase_whenBosniaClase_thenMapsBosniaClaseEnum() {
    final var captor = ArgumentCaptor.forClass(BuscarExternosDto.class);
    final var response = new BuscarExternosResponseDto();
    when(externosApi.buscarExternos(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiExternosList(response.getData())).thenReturn(List.of());

    service.findExternosByClase(runTareaDto, tareaAmbitoOther, ComisClaseEmpleadoEnum.EMPLEADO_EXTERNO_BOSNIA);

    assertEquals(BuscarExternosDto.ClaseEnum.EMPLEADO_EXTERNO_BOSNIA, captor.getValue().getClase());
  }

  @Test
  void findExternosByMinIdPersona_whenCalled_thenCallsApiWithTipoMinIdPersona() {
    final var captor = ArgumentCaptor.forClass(BuscarExternosDto.class);
    final var response = new BuscarExternosResponseDto();
    when(externosApi.buscarExternos(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiExternosList(response.getData())).thenReturn(List.of());

    service.findExternosByMinIdPersona(runTareaDto, tareaAmbitoOther, 500000L);

    assertEquals(BuscarExternosDto.TipoEnum.MIN_ID_PERSONA, captor.getValue().getTipo());
    assertEquals(500000L, captor.getValue().getMinIdPersona());
  }

  // -------------------------------------------------------------------------
  // Comisiones manuales
  // -------------------------------------------------------------------------

  @Test
  void findComisionManual_whenCalled_thenReturnsData() {
    final List<IdPersonaLocalComisionManualDto> expected = List.of();
    final var response = new BuscarComisionesManualResponseDto();
    when(comisionesManualesApi.buscarComisionesManual(any(), eq(CCL_ID_ORIGEN_OTHER))).thenReturn(response);
    when(comisClientMapper.toApiComisionManualList(response.getData())).thenReturn(expected);

    final List<IdPersonaLocalComisionManualDto> result = service.findComisionManual(runTareaDto, tareaAmbitoOther);

    assertEquals(expected, result);
  }

  // -------------------------------------------------------------------------
  // Personas
  // -------------------------------------------------------------------------

  @Test
  void findPersonas_whenCalled_thenCallsApiWithEstandarAndMaxIdPersona() {
    final var captor = ArgumentCaptor.forClass(BuscarPersonasDto.class);
    final var response = new BuscarPersonasResponseDto();
    final List<IdPersonaLocalLocalizacionDto> expected = List.of();
    when(personasApi.buscarPersonas(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiLocalizacionList(response.getData())).thenReturn(expected);

    service.findPersonas(runTareaDto, tareaAmbitoOther, 90000000L);

    assertEquals(BuscarPersonasDto.TipoEnum.ESTANDAR, captor.getValue().getTipo());
    assertEquals(90000000L, captor.getValue().getMaxIdPersona());
  }

  @Test
  void findPersonasSil_whenIdsEstadoSilIsNotEmpty_thenCallsApiWithSilConEstado() {
    final var captor = ArgumentCaptor.forClass(BuscarPersonasDto.class);
    final var response = new BuscarPersonasResponseDto();
    when(personasApi.buscarPersonas(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiLocalizacionList(response.getData())).thenReturn(List.of());

    final ClaseResultItemDto clase = new ClaseResultItemDto();
    clase.setIdsEstadoSil(List.of("ACTIVO", "BAJA"));
    when(comisClientMapper.toDto(clase))
        .thenReturn(new com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.ClaseResultItemDto());

    service.findPersonasSil(runTareaDto, tareaAmbitoOther, 100L, clase);

    assertEquals(BuscarPersonasDto.TipoEnum.SIL_CON_ESTADO, captor.getValue().getTipo());
    assertEquals(100L, captor.getValue().getMaxIdPersona());
  }

  @Test
  void findPersonasSil_whenIdsEstadoSilIsEmpty_thenCallsApiWithSilSinEstado() {
    final var captor = ArgumentCaptor.forClass(BuscarPersonasDto.class);
    final var response = new BuscarPersonasResponseDto();
    when(personasApi.buscarPersonas(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiLocalizacionList(response.getData())).thenReturn(List.of());

    final ClaseResultItemDto clase = new ClaseResultItemDto();
    clase.setIdsEstadoSil(List.of());
    when(comisClientMapper.toDto(clase))
        .thenReturn(new com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.ClaseResultItemDto());

    service.findPersonasSil(runTareaDto, tareaAmbitoOther, 100L, clase);

    assertEquals(BuscarPersonasDto.TipoEnum.SIL_SIN_ESTADO, captor.getValue().getTipo());
  }

  @Test
  void findPersonasSil_whenIdsEstadoSilIsNull_thenCallsApiWithSilSinEstado() {
    final var captor = ArgumentCaptor.forClass(BuscarPersonasDto.class);
    final var response = new BuscarPersonasResponseDto();
    when(personasApi.buscarPersonas(captor.capture(), any())).thenReturn(response);
    when(comisClientMapper.toApiLocalizacionList(response.getData())).thenReturn(List.of());

    final ClaseResultItemDto clase = new ClaseResultItemDto();
    clase.setIdsEstadoSil(null);
    when(comisClientMapper.toDto(clase))
        .thenReturn(new com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.ClaseResultItemDto());

    service.findPersonasSil(runTareaDto, tareaAmbitoOther, 100L, clase);

    assertEquals(BuscarPersonasDto.TipoEnum.SIL_SIN_ESTADO, captor.getValue().getTipo());
  }

  // -------------------------------------------------------------------------
  // Validaciones
  // -------------------------------------------------------------------------

  @Test
  void validateTempComisRecuperarFrancia_whenCalled_thenReturnsData() {
    final List<IdPersonaLocalDto> expected = List.of(new IdPersonaLocalDto());
    final var response = new ValidarTempComisRecuperarFranciaResponseDto();
    when(validacionesApi.validarTempComisRecuperarFrancia(any(), eq(CCL_ID_ORIGEN_OTHER))).thenReturn(response);
    when(comisClientMapper.toApiPersonaLocalList(response.getData())).thenReturn(expected);

    final List<IdPersonaLocalDto> result = service.validateTempComisRecuperarFrancia(runTareaDto, tareaAmbitoOther);

    assertEquals(expected, result);
    verify(validacionesApi).validarTempComisRecuperarFrancia(any(), eq(CCL_ID_ORIGEN_OTHER));
  }

  // -------------------------------------------------------------------------
  // X-Origin-Id Spain routing via condiciones
  // -------------------------------------------------------------------------

  @Test
  void findCondicionesHistorico_whenOriginIsSpain_thenXOriginIdIncludesLegalEntity() {
    final String expectedXOriginId = CCL_ID_ORIGEN_SPAIN + "_" + STD_ID_LEG_ENT;
    final var response = new BuscarCondicionesResponseDto();
    when(condicionesApi.buscarCondiciones(any(), eq(expectedXOriginId))).thenReturn(response);
    when(comisClientMapper.toApiCondicionesList(response.getData())).thenReturn(List.of());

    service.findCondicionesHistorico(runTareaDto, tareaAmbitoSpain);

    verify(condicionesApi).buscarCondiciones(any(), eq(expectedXOriginId));
  }

}
