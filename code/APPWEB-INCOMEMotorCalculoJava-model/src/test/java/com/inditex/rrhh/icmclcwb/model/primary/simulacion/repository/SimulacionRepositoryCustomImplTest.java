package com.inditex.rrhh.icmclcwb.model.primary.simulacion.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.Collections;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class SimulacionRepositoryCustomImplTest {

  private final static String SQL_MERGE_LOCALIZACION_SIMULACION =
      "SQL MERGE LOCALIZACION SIMULACION";

  private final static String SQL_MERGE_EMPLEADO_SIMULACION =
      "SQL MERGE EMPLEADO SIMULACION";

  private final static String SQL_MERGE_ESTRUCTURAS_EMPLEADO_SIMULACION =
      "SQL MERGE ESTRUCTURAS EMPLEADO SIMULACION";

  private final static String SQL_MERGE_PRESENCIAS_EMPLEADO_SIMULACION =
      "SQL MERGE PRESENCIAS EMPLEADO SIMULACION";

  private final static String SQL_MERGE_PRESENCIA_EMPLEADO_ULTIMO_CALCULO = "SQL MERGE PRESENCIA EMPLEADO ULTIMO CALCULO";

  private final static String SQL_MERGE_PRESENCIA_TIENDA_ULTIMO_CALCULO = "SQL MERGE PRESENCIA TIENDA ULTIMO _CALCULO";

  private final static String SQL_MERGE_VENTA_ULTIMO_CALCULO = "SQL MERGE VENTA ULTIMO CALCULO";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private SimulacionRepositoryCustomImpl simulacionRepositoryCustom;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.simulacionRepositoryCustom,
        "sqlMergeEmpleadoSimulacion",
        SQL_MERGE_EMPLEADO_SIMULACION, true);
    FieldUtils.writeField(this.simulacionRepositoryCustom,
        "sqlMergeEstructurasEmpleadoSimulacion",
        SQL_MERGE_ESTRUCTURAS_EMPLEADO_SIMULACION, true);
    FieldUtils.writeField(this.simulacionRepositoryCustom,
        "sqlMergePresenciasEmpleadoSimulacion",
        SQL_MERGE_PRESENCIAS_EMPLEADO_SIMULACION, true);
    FieldUtils.writeField(this.simulacionRepositoryCustom,
        "sqlMergePresenciaEmpleadoUltimoCalculo",
        SQL_MERGE_PRESENCIA_EMPLEADO_ULTIMO_CALCULO, true);
    FieldUtils.writeField(this.simulacionRepositoryCustom,
        "sqlMergePresenciaTiendaUltimoCalculo",
        SQL_MERGE_PRESENCIA_TIENDA_ULTIMO_CALCULO, true);
    FieldUtils.writeField(this.simulacionRepositoryCustom,
        "sqlMergeVentaUltimoCalculo",
        SQL_MERGE_VENTA_ULTIMO_CALCULO, true);

  }

  @Test
  public void mergeEmpleadoSimulacionTest() {

    final Long idTarea = 555L;
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(idTarea);

    this.simulacionRepositoryCustom.mergeEmpleadoSimulacion(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    // Parametros del SQL: idTarea
    assertEquals(1, this.paramsCaptor.getValue().getValues().size());
    // idTarea
    assertTrue(this.paramsCaptor.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, this.paramsCaptor.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

  }

  @Test
  public void mergeEstructurasEmpleadoSimulacionTest() {

    final Long idTarea = 555L;
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(idTarea);

    this.simulacionRepositoryCustom.mergeEstructurasEmpleadoSimulacion(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    // Parametros del SQL: idTarea
    assertEquals(1, this.paramsCaptor.getValue().getValues().size());
    // idTarea
    assertTrue(this.paramsCaptor.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, this.paramsCaptor.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

  }

  @Test
  public void mergePresenciasEmpleadoSimulacionTest() {

    final Long idTarea = 555L;
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(idTarea);

    this.simulacionRepositoryCustom.mergePresenciasEmpleadoSimulacion(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    // Parametros del SQL: idTarea
    assertEquals(1, this.paramsCaptor.getValue().getValues().size());
    // idTarea
    assertTrue(this.paramsCaptor.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, this.paramsCaptor.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

  }

  @Test
  public void mergePresenciaEmpleadoUltimoCalculoTest() {

    final Long idTarea = 555L;
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(idTarea);

    this.simulacionRepositoryCustom.mergePresenciaEmpleadoUltimoCalculo(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    // Parametros del SQL: idTarea
    assertEquals(1, this.paramsCaptor.getValue().getValues().size());
    // idTarea
    assertTrue(this.paramsCaptor.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, this.paramsCaptor.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

  }

  @Test
  public void mergePresenciaTiendaUltimoCalculoTest() {

    final Long idTarea = 555L;
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(idTarea);

    this.simulacionRepositoryCustom.mergePresenciaTiendaUltimoCalculo(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    // Parametros del SQL: idTarea
    assertEquals(1, this.paramsCaptor.getValue().getValues().size());
    // idTarea
    assertTrue(this.paramsCaptor.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, this.paramsCaptor.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

  }

  @Test
  public void mergeVentaUltimoCalculoTest() {

    final Long idTarea = 555L;
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(idTarea);

    this.simulacionRepositoryCustom.mergeVentaUltimoCalculo(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    // Parametros del SQL: idTarea
    assertEquals(1, this.paramsCaptor.getValue().getValues().size());
    // idTarea
    assertTrue(this.paramsCaptor.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, this.paramsCaptor.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

  }

  @Test
  public void findEstructurasEmpleadoSimulacionShouldReturnList() {
    final TareaDto tareaDto = mock(TareaDto.class);
    final TareaPersonaEstructuraDto tareaPersonaEstructuraDto = new TareaPersonaEstructuraDto();
    when(this.namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCondicionesDto>>any())).thenAnswer((invocation) -> {

          final RowMapper<TareaPersonaEstructuraDto> rowMapper = invocation.getArgument(2);
          final ResultSet rs = mock(ResultSet.class);
          when(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA)).thenReturn(tareaPersonaEstructuraDto.getIdTarea());
          when(rs.getDate(SqlPrimaryConstants.SQL_RESULT_ID_ORIGEN)).thenReturn(Date.valueOf(tareaPersonaEstructuraDto.getCclIdOrigen()));
          when(rs.getDate(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_META4))
              .thenReturn(Date.valueOf(tareaPersonaEstructuraDto.getStdIdHr()));
          when(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_LOCAL)).thenReturn(tareaPersonaEstructuraDto.getCclIdPerson());
          when(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_ID_TP_CALCULO)).thenReturn(tareaPersonaEstructuraDto.getIcmIdTpCalculo());
          when(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_ID_TP_COMISION)).thenReturn(tareaPersonaEstructuraDto.getIcmIdTpComision());
          when(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA)).thenReturn(tareaPersonaEstructuraDto.getStdOrHrPeriod());
          when(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_VALOR)).thenReturn(tareaPersonaEstructuraDto.getValor());
          when(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ICM_ORD_TOPE)).thenReturn(tareaPersonaEstructuraDto.getTope());
          when(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_ID_ESTR_COMISION_BASE))
              .thenReturn(tareaPersonaEstructuraDto.getIcmIdEstrComisionBase());
          when(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_ID_ESTR_COMISION_PADRE))
              .thenReturn(tareaPersonaEstructuraDto.getIcmIdEstrComisionPadre());
          when(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_ID_ESTR_COMISION))
              .thenReturn(tareaPersonaEstructuraDto.getIcmIdEstrComision());
          when(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_INICIO_PERIODO))
              .thenReturn(Date.valueOf(tareaPersonaEstructuraDto.getFechaInicioPeriodo()));
          when(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_ID_TP_ESTRUCTURA))
              .thenReturn(tareaPersonaEstructuraDto.getIcmIdTpEstructura());
          when(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DESPLAZAMIENTO))
              .thenReturn(tareaPersonaEstructuraDto.getDesplazamiento());
          when(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DESPLAZAMIENTO_BASE))
              .thenReturn(tareaPersonaEstructuraDto.getDesplazamientoBase());
          when(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_ACTIVO)).thenReturn(tareaPersonaEstructuraDto.getActivo());
          when(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DIA_LUNES))
              .thenReturn(tareaPersonaEstructuraDto.getDiaL());
          when(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DIA_MARTES))
              .thenReturn(tareaPersonaEstructuraDto.getDiaM());
          when(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DIA_MIERCOLES))
              .thenReturn(tareaPersonaEstructuraDto.getDiaX());
          when(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DIA_JUEVES))
              .thenReturn(tareaPersonaEstructuraDto.getDiaJ());
          when(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DIA_VIERNES))
              .thenReturn(tareaPersonaEstructuraDto.getDiaV());
          when(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DIA_SABADO))
              .thenReturn(tareaPersonaEstructuraDto.getDiaS());
          when(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DIA_DOMINGO))
              .thenReturn(tareaPersonaEstructuraDto.getDiaD());
          when(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_FESTIVO)).thenReturn(tareaPersonaEstructuraDto.getFestivo());

          return Collections.singletonList(rowMapper.mapRow(rs, 0));

        });

    this.simulacionRepositoryCustom.findEstructurasEmpleadoSimulacion(tareaDto);
    verify(tareaDto, times(1)).getId();
  }

  @Test
  public void updateBandaExcepcionadaShouldUpdate() {
    final TareaDto tareaDto = mock(TareaDto.class);
    this.simulacionRepositoryCustom.updateBandaExcepcionada(tareaDto, 1, "test", "1");
    verify(tareaDto, times(1)).getId();
  }

}
