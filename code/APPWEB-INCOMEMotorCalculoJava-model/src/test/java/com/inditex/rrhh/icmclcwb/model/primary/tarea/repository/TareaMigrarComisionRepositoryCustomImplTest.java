package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPipeConstants;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TareaMigrarComisionRepositoryCustomImplTest {

  private final static String SQL_FIND_CALCULO_COMISION = "SQL FIND CALCULO COMISION";

  @InjectMocks
  private TareaMigrarComisionRepositoryCustomImpl tareaMigrarComisionRepositoryCustomImpl;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @BeforeEach
  public void setUp() throws IllegalAccessException {
    MockitoAnnotations.openMocks(this);
    FieldUtils.writeField(this.tareaMigrarComisionRepositoryCustomImpl,
        "sqlFindCalculoComision",
        SQL_FIND_CALCULO_COMISION,
        true);
  }

  @Test
  void findCalculoComisionByTareaActualReturnsEmptyListWhenNoResults() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);

    when(this.namedParameterJdbcTemplate.query(
        ArgumentMatchers.eq(SQL_FIND_CALCULO_COMISION),
        ArgumentMatchers.any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<TareaMigrarComisionDto>>any()))
            .thenReturn(Collections.emptyList());

    final List<TareaMigrarComisionDto> result = this.tareaMigrarComisionRepositoryCustomImpl.findCalculoComisionByTareaActual(tarea);

    assertTrue(result.isEmpty());
  }

  @Test
  void findCalculoComisionByTareaActualTest() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);

    final TareaMigrarComisionDto expectedDto = TareaMigrarComisionDto.builder()
        .icmIdPeriodo(1L)
        .cclIdOrigen(2L)
        .stdIdLegEnt(3L)
        .cclIdPerson(4L)
        .stdOrHrPeriod(5L)
        .idEstado(6)
        .fechaInicioPeriodo(LocalDate.now())
        .fechaFinPeriodo(LocalDate.now())
        .fecha(LocalDate.now())
        .tiendaCalculo(7L)
        .fechaInicioEstructura(LocalDate.now())
        .fechaFinEstructura(LocalDate.now())
        .cclIdSeccion(8L)
        .banda(9L)
        .valor(10.0f)
        .icmIdTpComision("comision")
        .icmIdTpCalculo("calculo")
        .icmGrupoManual("manual")
        .idTipoOpcionCalculo(11L)
        .cclIdCodOrigenDestino(12L)
        .codTipoHora(13L)
        .minutos(14L)
        .codTiendaPresenciaEmpleado(15L)
        .codSeccionPresenciaEmpleado(16L)
        .minutosTienda(17L)
        .codTiendaPresencia(18L)
        .codSeccionPresencia(19L)
        .importeTotal(20.0f)
        .importeTotalSinAjuste(21.0f)
        .importeAjusteTotal(22.0f)
        .importeFisica(23.0f)
        .importeFisicaSinAjuste(24.0f)
        .importeAjusteFisica(25.0f)
        .importeOnlineIpod(26.0f)
        .importeOnlineIpodSinAjuste(27.0f)
        .importeAjusteOnlineIpod(28.0f)
        .importeOnlineSint(29.0f)
        .importeOnlineSintSinAjuste(30.0f)
        .importeAjusteOnlineSint(31.0f)
        .importeOnlineEntregaTienda(32.0f)
        .importeOnlineEntregaTiendaSinAjuste(33.0f)
        .importeAjusteOnlineEntregaTienda(34.0f)
        .importeOnlineEntregaDomicilio(35.0f)
        .importeOnlineEntregaDomicilioSinAjuste(36.0f)
        .importeAjusteOnlineEntregaDomicilio(37.0f)
        .ventaTotal(38.0f)
        .ventaFisica(39.0f)
        .ventaOnlineIpod(40.0f)
        .ventaOnlineSint(41.0f)
        .ventaOnlineEntregaTienda(42.0f)
        .ventaOnlineEntregaDomicilio(43.0f)
        .objetivo(44.0f)
        .excepcionada(45)
        .congelada(46)
        .challengeVentaTotal(47.0f)
        .challengeVentaCaja(48.0f)
        .challengeDevoluciones(49.0f)
        .challengeVentaOnlineIpod(50.0f)
        .challengeVentaOnlinePicking(51.0f)
        .challengeVentaOnlineEntregaTienda(52.0f)
        .importeVentaFisicaIndividual(53.0f)
        .importeDevolucionFisicaIndividual(54.0f)
        .importeVentaOnlineIpod(55.0f)
        .importeDevolucionIndividualIpod(56.0f)
        .coeficienteReduccionJornada(57.0f)
        .build();

    when(this.namedParameterJdbcTemplate.query(
        ArgumentMatchers.eq(SQL_FIND_CALCULO_COMISION),
        ArgumentMatchers.any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<TareaMigrarComisionDto>>any()))
            .thenReturn(Collections.singletonList(expectedDto));

    final List<TareaMigrarComisionDto> result = this.tareaMigrarComisionRepositoryCustomImpl.findCalculoComisionByTareaActual(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<TareaMigrarComisionDto>>any());

    assertEquals(SQL_FIND_CALCULO_COMISION, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(SqlPipeConstants.SQL_PARAM_ICM_ID_TAREA_ACTUAL));

    assertEquals(1, result.size());
    assertEquals(expectedDto, result.get(0));
  }

  @Test
  void findCalculoComisionByTareaActualThrowsExceptionWhenQueryFails() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);

    when(this.namedParameterJdbcTemplate.query(
        ArgumentMatchers.eq(SQL_FIND_CALCULO_COMISION),
        ArgumentMatchers.any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<TareaMigrarComisionDto>>any()))
            .thenThrow(new RuntimeException("Database error"));

    Exception exception = assertThrows(RuntimeException.class, () -> {
      this.tareaMigrarComisionRepositoryCustomImpl.findCalculoComisionByTareaActual(tarea);
    });

    assertEquals("Database error", exception.getMessage());
  }

  @Test
  void findCalculoComisionByTareaActualReturnsCorrectResults() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);

    final TareaMigrarComisionDto expectedDto = TareaMigrarComisionDto.builder()
        .icmIdPeriodo(1L)
        .cclIdOrigen(2L)
        .stdIdLegEnt(3L)
        .cclIdPerson(4L)
        .stdOrHrPeriod(5L)
        .idEstado(6)
        .fechaInicioPeriodo(LocalDate.now())
        .fechaFinPeriodo(LocalDate.now())
        .fecha(LocalDate.now())
        .tiendaCalculo(7L)
        .fechaInicioEstructura(LocalDate.now())
        .fechaFinEstructura(LocalDate.now())
        .cclIdSeccion(8L)
        .banda(9L)
        .valor(10.0f)
        .icmIdTpComision("comision")
        .icmIdTpCalculo("calculo")
        .icmGrupoManual("manual")
        .idTipoOpcionCalculo(11L)
        .cclIdCodOrigenDestino(12L)
        .codTipoHora(13L)
        .minutos(14L)
        .codTiendaPresenciaEmpleado(15L)
        .codSeccionPresenciaEmpleado(16L)
        .minutosTienda(17L)
        .codTiendaPresencia(18L)
        .codSeccionPresencia(19L)
        .importeTotal(20.0f)
        .importeTotalSinAjuste(21.0f)
        .importeAjusteTotal(22.0f)
        .importeFisica(23.0f)
        .importeFisicaSinAjuste(24.0f)
        .importeAjusteFisica(25.0f)
        .importeOnlineIpod(26.0f)
        .importeOnlineIpodSinAjuste(27.0f)
        .importeAjusteOnlineIpod(28.0f)
        .importeOnlineSint(29.0f)
        .importeOnlineSintSinAjuste(30.0f)
        .importeAjusteOnlineSint(31.0f)
        .importeOnlineEntregaTienda(32.0f)
        .importeOnlineEntregaTiendaSinAjuste(33.0f)
        .importeAjusteOnlineEntregaTienda(34.0f)
        .importeOnlineEntregaDomicilio(35.0f)
        .importeOnlineEntregaDomicilioSinAjuste(36.0f)
        .importeAjusteOnlineEntregaDomicilio(37.0f)
        .ventaTotal(38.0f)
        .ventaFisica(39.0f)
        .ventaOnlineIpod(40.0f)
        .ventaOnlineSint(41.0f)
        .ventaOnlineEntregaTienda(42.0f)
        .ventaOnlineEntregaDomicilio(43.0f)
        .objetivo(44.0f)
        .excepcionada(45)
        .congelada(46)
        .challengeVentaTotal(47.0f)
        .challengeVentaCaja(48.0f)
        .challengeDevoluciones(49.0f)
        .challengeVentaOnlineIpod(50.0f)
        .challengeVentaOnlinePicking(51.0f)
        .challengeVentaOnlineEntregaTienda(52.0f)
        .importeVentaFisicaIndividual(53.0f)
        .importeDevolucionFisicaIndividual(54.0f)
        .importeVentaOnlineIpod(55.0f)
        .importeDevolucionIndividualIpod(56.0f)
        .coeficienteReduccionJornada(57.0f)
        .build();

    when(this.namedParameterJdbcTemplate.query(
        ArgumentMatchers.eq(SQL_FIND_CALCULO_COMISION),
        ArgumentMatchers.any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<TareaMigrarComisionDto>>any()))
            .thenReturn(Collections.singletonList(expectedDto));

    final List<TareaMigrarComisionDto> result = this.tareaMigrarComisionRepositoryCustomImpl.findCalculoComisionByTareaActual(tarea);

    assertEquals(1, result.size());
    assertEquals(expectedDto, result.get(0));
  }
}
