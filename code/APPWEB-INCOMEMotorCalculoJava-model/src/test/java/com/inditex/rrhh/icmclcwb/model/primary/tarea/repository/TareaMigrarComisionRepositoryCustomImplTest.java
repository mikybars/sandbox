package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPipeConstants;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaMigrarComisionRepositoryCustomImplTest {

  private final static String SQL_FIND_CALCULO_COMISION = "SQL FIND CALCULO COMISION";

  private final static String SQL_FIND_DELETE_CALCULO_COMISION = "SQL FIND DELETE CALCULO COMISION";

  private final static String SQL_COUNT_PERSONAS = "SQL COUNT PERSONAS";

  @InjectMocks
  private TareaMigrarComisionRepositoryCustomImpl tareaMigrarComisionRepositoryCustomImpl;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @BeforeEach
  public void setUp() throws IllegalAccessException {
    MockitoAnnotations.openMocks(this);
    FieldUtils.writeField(this.tareaMigrarComisionRepositoryCustomImpl,
        "sqlFindCalculoComision",
        SQL_FIND_CALCULO_COMISION,
        true);

    FieldUtils.writeField(this.tareaMigrarComisionRepositoryCustomImpl,
        "sqlDeleteCalculoComision",
        SQL_FIND_DELETE_CALCULO_COMISION,
        true);

    FieldUtils.writeField(this.tareaMigrarComisionRepositoryCustomImpl,
        "sqlCountPersonas",
        SQL_COUNT_PERSONAS,
        true);

    FieldUtils.writeField(this.tareaMigrarComisionRepositoryCustomImpl,
        "pageSize",
        100,
        true);
  }

  @Test
  void findCalculoComisionByTareaActualReturnsCorrectResults() throws SQLException {
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
        .icmCkIncIvaEvalPtpo(1234L)
        .codSeccionBanda(1234L)
        .build();

    when(this.namedParameterJdbcTemplate.query(
        ArgumentMatchers.eq(SQL_FIND_CALCULO_COMISION),
        ArgumentMatchers.any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<TareaMigrarComisionDto>>any()))
            .thenAnswer(invocation -> {
              final RowMapper<TareaMigrarComisionDto> rowMapper = invocation.getArgument(2);
              final ResultSet rs = mock(ResultSet.class);
              when(rs.next()).thenReturn(true).thenReturn(false);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_ICM_ID_PERIODO)).thenReturn(1L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_CCL_ID_ORIGEN)).thenReturn(2L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_STD_ID_LEG_ENT)).thenReturn(3L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_CCL_ID_PERSON)).thenReturn(4L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_STD_OR_HR_PERIOD)).thenReturn(5L);
              when(rs.getInt(SqlPipeConstants.SQL_RESULT_ID_ESTADO)).thenReturn(6);
              when(rs.getDate(SqlPipeConstants.SQL_RESULT_FECHA_INICIO_PERIODO)).thenReturn(java.sql.Date.valueOf(LocalDate.now()));
              when(rs.getDate(SqlPipeConstants.SQL_RESULT_FECHA_FIN_PERIODO)).thenReturn(java.sql.Date.valueOf(LocalDate.now()));
              when(rs.getDate(SqlPipeConstants.SQL_RESULT_FECHA)).thenReturn(java.sql.Date.valueOf(LocalDate.now()));
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_TIENDA_CALCULO)).thenReturn(7L);
              when(rs.getDate(SqlPipeConstants.SQL_RESULT_FECHA_INICIO_ESTRUCTURA)).thenReturn(java.sql.Date.valueOf(LocalDate.now()));
              when(rs.getDate(SqlPipeConstants.SQL_RESULT_FECHA_FIN_ESTRUCTURA)).thenReturn(java.sql.Date.valueOf(LocalDate.now()));
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_CCL_ID_SECCION)).thenReturn(8L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_BANDA)).thenReturn(9L);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_VALOR)).thenReturn(10.0f);
              when(rs.getString(SqlPipeConstants.SQL_RESULT_ICM_ID_TP_COMISION)).thenReturn("comision");
              when(rs.getString(SqlPipeConstants.SQL_RESULT_ICM_ID_TP_CALCULO)).thenReturn("calculo");
              when(rs.getString(SqlPipeConstants.SQL_RESULT_ICM_GRUPO_MANUAL)).thenReturn("manual");
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_ID_TIPO_OPCION_CALCULO)).thenReturn(11L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_CCL_ID_COD_ORIGEN_DESTINO)).thenReturn(12L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_COD_TIPO_HORA)).thenReturn(13L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_MINUTOS)).thenReturn(14L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_COD_TIENDA_PRESENCIA_EMPLEADO)).thenReturn(15L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_COD_SECCION_PRESENCIA_EMPLEADO)).thenReturn(16L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_MINUTOS_TIENDA)).thenReturn(17L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_COD_TIENDA_PRESENCIA)).thenReturn(18L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_COD_SECCION_PRESENCIA)).thenReturn(19L);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_TOTAL)).thenReturn(20.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_TOTAL_SIN_AJUSTE)).thenReturn(21.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_AJUSTE_TOTAL)).thenReturn(22.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_FISICA)).thenReturn(23.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_FISICA_SIN_AJUSTE)).thenReturn(24.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_AJUSTE_FISICA)).thenReturn(25.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_ONLINE_IPOD)).thenReturn(26.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_ONLINE_IPOD_SIN_AJUSTE)).thenReturn(27.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_AJUSTE_ONLINE_IPOD)).thenReturn(28.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_ONLINE_SINT)).thenReturn(29.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_ONLINE_SINT_SIN_AJUSTE)).thenReturn(30.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_AJUSTE_ONLINE_SINT)).thenReturn(31.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_ONLINE_ENTREGA_TIENDA)).thenReturn(32.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_ONLINE_ENTREGA_TIENDA_SIN_AJUSTE)).thenReturn(33.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_AJUSTE_ONLINE_ENTREGA_TIENDA)).thenReturn(34.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_ONLINE_ENTREGA_DOMICILIO)).thenReturn(35.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_ONLINE_ENTREGA_DOMICILIO_SIN_AJUSTE)).thenReturn(36.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_AJUSTE_ONLINE_ENTREGA_DOMICILIO)).thenReturn(37.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_VENTA_TOTAL)).thenReturn(38.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_VENTA_FISICA)).thenReturn(39.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_VENTA_ONLINE_IPOD)).thenReturn(40.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_VENTA_ONLINE_SINT)).thenReturn(41.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_VENTA_ONLINE_ENTREGA_TIENDA)).thenReturn(42.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_VENTA_ONLINE_ENTREGA_DOMICILIO)).thenReturn(43.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_OBJETIVO)).thenReturn(44.0f);
              when(rs.getInt(SqlPipeConstants.SQL_RESULT_EXCEPCIONADA)).thenReturn(45);
              when(rs.getInt(SqlPipeConstants.SQL_RESULT_CONGELADA)).thenReturn(46);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_CHALLENGE_VENTA_TOTAL)).thenReturn(47.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_CHALLENGE_VENTA_CAJA)).thenReturn(48.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_CHALLENGE_DEVOLUCIONES)).thenReturn(49.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_CHALLENGE_VENTA_ONLINE_IPOD)).thenReturn(50.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_CHALLENGE_VENTA_ONLINE_PICKING)).thenReturn(51.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_CHALLENGE_VENTA_ONLINE_ENTREGA_TIENDA)).thenReturn(52.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_VENTA_FISICA_INDIVIDUAL)).thenReturn(53.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_DEVOLUCION_FISICA_INDIVIDUAL)).thenReturn(54.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_VENTA_ONLINE_IPOD)).thenReturn(55.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_IMPORTE_DEVOLUCION_INDIVIDUAL_IPOD)).thenReturn(56.0f);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_COEFICIENTE_REDUCCION_JORNADA)).thenReturn(57.0f);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_ICM_CK_INC_IVA_EVAL_PTPO)).thenReturn(1234L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_COD_SECCION_BANDA)).thenReturn(1234L);
              return Collections.singletonList(rowMapper.mapRow(rs, 0));
            });

    final List<TareaMigrarComisionDto> result = this.tareaMigrarComisionRepositoryCustomImpl.findCalculoComisionByTareaActual(tarea);

    assertEquals(1, result.size());
    assertEquals(expectedDto, result.get(0));
  }

  @Test
  void deleteCalculoComisionByTareaActual() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    ambito.setCclIdOrigen("1");
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setIcmIdPeriodo(1L);
    runTareaDto.setTarea(tarea);
    runTareaDto.setTrabajo(trabajo);
    final TareaMigrarComisionDto expectedDto = TareaMigrarComisionDto.builder()
        .icmIdPeriodo(1L)
        .cclIdOrigen(2L)
        .stdIdLegEnt(3L)
        .cclIdPerson(4L)
        .stdOrHrPeriod(5L)
        .fecha(LocalDate.now())
        .tiendaCalculo(7L)
        .cclIdSeccion(8L)
        .banda(9L)
        .valor(10.0f)
        .cclIdCodOrigenDestino(12L)
        .icmIdTpComision("comision")
        .icmIdTpCalculo("calculo")
        .icmGrupoManual("manual")
        .idTipoOpcionCalculo(11L)
        .codTipoHora(13L)
        .codSeccionPresenciaEmpleado(16L)
        .codTiendaPresencia(18L)
        .build();

    when(this.namedParameterJdbcTemplate.queryForObject(
        ArgumentMatchers.eq(SQL_COUNT_PERSONAS),
        ArgumentMatchers.any(MapSqlParameterSource.class),
        ArgumentMatchers.eq(Long.class)))
            .thenReturn(1L);

    when(this.namedParameterJdbcTemplate.query(
        ArgumentMatchers.eq(SQL_FIND_DELETE_CALCULO_COMISION),
        ArgumentMatchers.any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<TareaMigrarComisionDto>>any()))
            .thenAnswer(invocation -> {
              final RowMapper<TareaMigrarComisionDto> rowMapper = invocation.getArgument(2);
              final ResultSet rs = mock(ResultSet.class);
              when(rs.next()).thenReturn(true).thenReturn(false);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_ICM_ID_PERIODO)).thenReturn(1L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_CCL_ID_ORIGEN)).thenReturn(2L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_STD_ID_LEG_ENT)).thenReturn(3L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_CCL_ID_PERSON)).thenReturn(4L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_STD_OR_HR_PERIOD)).thenReturn(5L);
              when(rs.getDate(SqlPipeConstants.SQL_RESULT_FECHA)).thenReturn(java.sql.Date.valueOf(LocalDate.now()));
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_TIENDA_CALCULO)).thenReturn(7L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_CCL_ID_SECCION)).thenReturn(8L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_BANDA)).thenReturn(9L);
              when(rs.getFloat(SqlPipeConstants.SQL_RESULT_VALOR)).thenReturn(10.0f);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_CCL_ID_COD_ORIGEN_DESTINO)).thenReturn(12L);
              when(rs.getString(SqlPipeConstants.SQL_RESULT_ICM_ID_TP_COMISION)).thenReturn("comision");
              when(rs.getString(SqlPipeConstants.SQL_RESULT_ICM_ID_TP_CALCULO)).thenReturn("calculo");
              when(rs.getString(SqlPipeConstants.SQL_RESULT_ICM_GRUPO_MANUAL)).thenReturn("manual");
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_ID_TIPO_OPCION_CALCULO)).thenReturn(11L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_COD_TIPO_HORA)).thenReturn(13L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_COD_SECCION_PRESENCIA_EMPLEADO)).thenReturn(16L);
              when(rs.getLong(SqlPipeConstants.SQL_RESULT_COD_TIENDA_PRESENCIA)).thenReturn(18L);
              return Collections.singletonList(rowMapper.mapRow(rs, 0));
            });

    final List<TareaMigrarComisionDto> result =
        this.tareaMigrarComisionRepositoryCustomImpl.deleteCalculoComisionByTareaActual(runTareaDto, ambito);

    assertEquals(1, result.size());
    assertEquals(expectedDto, result.get(0));
  }
}
