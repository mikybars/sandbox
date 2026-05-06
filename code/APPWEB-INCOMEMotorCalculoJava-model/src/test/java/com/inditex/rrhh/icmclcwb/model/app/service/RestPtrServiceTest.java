package com.inditex.rrhh.icmclcwb.model.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.PresenciasApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarPresenciasDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Unit tests for {@link RestPtrService}.
 */
@ExtendWith(SpringExtension.class)
class RestPtrServiceTest {

  private static final String CCL_ID_ORIGEN_SPAIN = AppConstants.ID_ORIGEN_SPAIN;

  private static final String CCL_ID_ORIGEN_OTHER = "99";

  private static final String STD_ID_LEG_ENT = "001";

  private static final Integer HORAS_SECCION_1 = 10;

  private static final Integer HORAS_SECCION_2 = 20;

  private static final Integer HORAS_SECCION_3 = 30;

  private static final Integer HORAS_SECCION_4 = 40;

  private static final String ID_CATALOGO = "5";

  @Mock
  private PresenciasApi presenciasApi;

  @Mock
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @InjectMocks
  private RestPtrService restPtrService;

  private RunTareaDto runTareaDto;

  private TareaAmbitoDto tareaAmbitoSpain;

  private TareaAmbitoDto tareaAmbitoOther;

  private com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.PresenciaOrigenDto presenciaOrigenClientDto;

  @BeforeEach
  void setUp() {
    final TareaDto tarea = new TareaDto();
    tarea.setStdIdLegEnt(STD_ID_LEG_ENT);
    tarea.setFechaInicioPeriodo(LocalDate.of(2025, 1, 1));
    tarea.setFechaFinPeriodo(LocalDate.of(2025, 1, 31));
    tarea.setIdTrabajo(1L);
    tarea.setIdOrganization("ORG");

    runTareaDto = RunTareaDto.builder()
        .tarea(tarea)
        .build();

    tareaAmbitoSpain = TareaAmbitoDto.builder()
        .cclIdOrigen(CCL_ID_ORIGEN_SPAIN)
        .build();

    tareaAmbitoOther = TareaAmbitoDto.builder()
        .cclIdOrigen(CCL_ID_ORIGEN_OTHER)
        .build();

    presenciaOrigenClientDto = new com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.PresenciaOrigenDto()
        .horasSeccion1(HORAS_SECCION_1)
        .horasSeccion2(HORAS_SECCION_2)
        .horasSeccion3(HORAS_SECCION_3)
        .horasSeccion4(HORAS_SECCION_4);
  }

  // -------------------------------------------------------------------------
  // findPresenciasOrigenAndFecha
  // -------------------------------------------------------------------------

  @Test
  void findPresenciasOrigenAndFecha_whenApiReturnsData_thenReturnsMappedDto() {
    when(presenciasApi.buscarPresencias(any(BuscarPresenciasDto.class), isNull()))
        .thenReturn(presenciaOrigenClientDto);

    final PresenciaOrigenDto result = restPtrService
        .findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoOther);

    assertNotNull(result);
    assertEquals(HORAS_SECCION_1, result.getHorasSeccion1());
    assertEquals(HORAS_SECCION_2, result.getHorasSeccion2());
    assertEquals(HORAS_SECCION_3, result.getHorasSeccion3());
    assertEquals(HORAS_SECCION_4, result.getHorasSeccion4());
    verify(meta4IcmWsCalcIncomeService, never()).getCatalogo(any());
  }

  @Test
  void findPresenciasOrigenAndFecha_whenApiReturnsNull_thenReturnsEmptyDto() {
    when(presenciasApi.buscarPresencias(any(BuscarPresenciasDto.class), isNull()))
        .thenReturn(null);

    final PresenciaOrigenDto result = restPtrService
        .findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoOther);

    assertNotNull(result);
    assertNull(result.getHorasSeccion1());
    assertNull(result.getHorasSeccion2());
    assertNull(result.getHorasSeccion3());
    assertNull(result.getHorasSeccion4());
  }

  // -------------------------------------------------------------------------
  // findPresenciasOrigenAndFechaEs – non-Spain origin
  // -------------------------------------------------------------------------

  @Test
  void findPresenciasOrigenAndFechaEs_whenOriginIsNotSpain_thenSkipsCatalogAndCallsApi() {
    when(presenciasApi.buscarPresencias(any(BuscarPresenciasDto.class), isNull()))
        .thenReturn(presenciaOrigenClientDto);

    final PresenciaOrigenDto result = restPtrService
        .findPresenciasOrigenAndFechaEs(runTareaDto, tareaAmbitoOther);

    assertNotNull(result);
    assertEquals(HORAS_SECCION_1, result.getHorasSeccion1());
    assertEquals(HORAS_SECCION_2, result.getHorasSeccion2());
    assertEquals(HORAS_SECCION_3, result.getHorasSeccion3());
    assertEquals(HORAS_SECCION_4, result.getHorasSeccion4());
    verify(meta4IcmWsCalcIncomeService, never()).getCatalogo(any());
  }

  @Test
  void findPresenciasOrigenAndFechaEs_whenOriginIsNotSpainAndApiReturnsNull_thenReturnsEmptyDto() {
    when(presenciasApi.buscarPresencias(any(BuscarPresenciasDto.class), isNull()))
        .thenReturn(null);

    final PresenciaOrigenDto result = restPtrService
        .findPresenciasOrigenAndFechaEs(runTareaDto, tareaAmbitoOther);

    assertNotNull(result);
    assertNull(result.getHorasSeccion1());
  }

  // -------------------------------------------------------------------------
  // findPresenciasOrigenAndFechaEs – Spain origin, happy path
  // -------------------------------------------------------------------------

  @Test
  void findPresenciasOrigenAndFechaEs_whenOriginIsSpainAndCatalogIsValid_thenCallsApiWithCatalogId() {
    final CatalogoResultItemDto item = new CatalogoResultItemDto();
    item.setIdCatalogo(ID_CATALOGO);
    final CatalogoResponseDto catalogoResponse = new CatalogoResponseDto(List.of(item));

    when(meta4IcmWsCalcIncomeService.getCatalogo(any(CatalogoRequestDto.class)))
        .thenReturn(catalogoResponse);
    when(presenciasApi.buscarPresencias(any(BuscarPresenciasDto.class), isNull()))
        .thenReturn(presenciaOrigenClientDto);

    final PresenciaOrigenDto result = restPtrService
        .findPresenciasOrigenAndFechaEs(runTareaDto, tareaAmbitoSpain);

    assertNotNull(result);
    assertEquals(HORAS_SECCION_1, result.getHorasSeccion1());
    assertEquals(HORAS_SECCION_2, result.getHorasSeccion2());
    assertEquals(HORAS_SECCION_3, result.getHorasSeccion3());
    assertEquals(HORAS_SECCION_4, result.getHorasSeccion4());
    verify(meta4IcmWsCalcIncomeService).getCatalogo(any(CatalogoRequestDto.class));
    verify(presenciasApi).buscarPresencias(any(BuscarPresenciasDto.class), isNull());
  }

  // -------------------------------------------------------------------------
  // findPresenciasOrigenAndFechaEs – Spain origin, error scenarios
  // -------------------------------------------------------------------------

  @Test
  void findPresenciasOrigenAndFechaEs_whenOriginIsSpainAndCatalogResponseIsNull_thenThrowsException() {
    when(meta4IcmWsCalcIncomeService.getCatalogo(any(CatalogoRequestDto.class)))
        .thenReturn(null);

    assertThrows(IcmclcwbException.class,
        () -> restPtrService.findPresenciasOrigenAndFechaEs(runTareaDto, tareaAmbitoSpain));

    verify(presenciasApi, never()).buscarPresencias(any(), any());
  }

  @Test
  void findPresenciasOrigenAndFechaEs_whenOriginIsSpainAndCatalogItemsIsEmpty_thenThrowsException() {
    final CatalogoResponseDto catalogoResponse = new CatalogoResponseDto(Collections.emptyList());

    when(meta4IcmWsCalcIncomeService.getCatalogo(any(CatalogoRequestDto.class)))
        .thenReturn(catalogoResponse);

    assertThrows(IcmclcwbException.class,
        () -> restPtrService.findPresenciasOrigenAndFechaEs(runTareaDto, tareaAmbitoSpain));

    verify(presenciasApi, never()).buscarPresencias(any(), any());
  }

  @Test
  void findPresenciasOrigenAndFechaEs_whenOriginIsSpainAndIdCatalogoIsBlank_thenThrowsException() {
    final CatalogoResultItemDto item = new CatalogoResultItemDto();
    item.setIdCatalogo("   ");
    final CatalogoResponseDto catalogoResponse = new CatalogoResponseDto(List.of(item));

    when(meta4IcmWsCalcIncomeService.getCatalogo(any(CatalogoRequestDto.class)))
        .thenReturn(catalogoResponse);

    assertThrows(IcmclcwbException.class,
        () -> restPtrService.findPresenciasOrigenAndFechaEs(runTareaDto, tareaAmbitoSpain));

    verify(presenciasApi, never()).buscarPresencias(any(), any());
  }

  @Test
  void findPresenciasOrigenAndFechaEs_whenOriginIsSpainAndIdCatalogoIsNull_thenThrowsException() {
    final CatalogoResultItemDto item = new CatalogoResultItemDto();
    item.setIdCatalogo(null);
    final CatalogoResponseDto catalogoResponse = new CatalogoResponseDto(List.of(item));

    when(meta4IcmWsCalcIncomeService.getCatalogo(any(CatalogoRequestDto.class)))
        .thenReturn(catalogoResponse);

    assertThrows(IcmclcwbException.class,
        () -> restPtrService.findPresenciasOrigenAndFechaEs(runTareaDto, tareaAmbitoSpain));

    verify(presenciasApi, never()).buscarPresencias(any(), any());
  }

  @Test
  void findPresenciasOrigenAndFechaEs_whenOriginIsSpainAndCatalogItemsIsNull_thenThrowsException() {
    final CatalogoResponseDto catalogoResponse = new CatalogoResponseDto(null);

    when(meta4IcmWsCalcIncomeService.getCatalogo(any(CatalogoRequestDto.class)))
        .thenReturn(catalogoResponse);

    assertThrows(IcmclcwbException.class,
        () -> restPtrService.findPresenciasOrigenAndFechaEs(runTareaDto, tareaAmbitoSpain));

    verify(presenciasApi, never()).buscarPresencias(any(), any());
  }

}
