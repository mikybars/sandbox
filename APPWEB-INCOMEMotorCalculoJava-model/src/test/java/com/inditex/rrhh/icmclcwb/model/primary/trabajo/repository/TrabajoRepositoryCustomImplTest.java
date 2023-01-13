package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.EstadoPeriodoCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.dto.EstadoTrabajoDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructura;

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
public class TrabajoRepositoryCustomImplTest {

  private final static String SQL_UPDATE_ESTADO = "SQL UPDATE ESTADO";

  private final static String SQL_FIND_EMPRESA_EMPLEADOS_EXPORTADOS = "SQL FIND EMPRESA EMPLEADOS EXPORTADOS";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private TrabajoRepositoryCustomImpl trabajoRepositoryCustom;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> parametersCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.trabajoRepositoryCustom, "sqlUpdateFechaInicioAndEstado", SQL_UPDATE_ESTADO, true);
    FieldUtils.writeField(this.trabajoRepositoryCustom, "sqlFindEmpresaEmpleadosExportados", SQL_FIND_EMPRESA_EMPLEADOS_EXPORTADOS, true);

  }

  @Test
  public void updateEstadoTest() {

    final TrabajoDTO trabajo = mock(TrabajoDTO.class);
    when(trabajo.getId()).thenReturn(100L);
    final EstadoTrabajoDTO estado = mock(EstadoTrabajoDTO.class);
    when(estado.getId()).thenReturn(78);

    this.trabajoRepositoryCustom.updateEstado(trabajo, estado);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(),
        this.parametersCaptor.capture());
    assertEquals(SQL_UPDATE_ESTADO, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.parametersCaptor.getValue();

    // Parámetros de la consulta: idTrabajo, nuevoIdEstado
    assertEquals(3, params.getValues().size());
    // idTrabajo
    assertTrue(params.hasValue("idTrabajo"));
    assertEquals(trabajo.getId(), params.getValue("idTrabajo"));
    // nuevoIdEstado
    assertTrue(params.hasValue("nuevoIdEstado"));
    assertEquals(estado.getId(), params.getValue("nuevoIdEstado"));

  }

  @Test
  public void findEmpresasCalcularProgramadosTest() {

    final TrabajoDTO trabajo = mock(TrabajoDTO.class);
    when(trabajo.getId()).thenReturn(100L);
    final List<String> origen = mock(List.class);
    final List<String> empresa = mock(List.class);

    this.trabajoRepositoryCustom.findEmpresasCalcularProgramados(trabajo, empresa, origen);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.parametersCaptor.capture(),
        ArgumentMatchers.<RowMapper<TareaPersonaEstructura>>any());
    assertEquals(SQL_FIND_EMPRESA_EMPLEADOS_EXPORTADOS, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.parametersCaptor.getValue();

    // Parámetros de la consulta: idTrabajo, nuevoIdEstado
    assertEquals(4, params.getValues().size());
    // origen
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN));
    assertEquals(origen, params.getValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN));
    // empresa
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT));
    assertEquals(empresa, params.getValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT));
    // periodo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ICM_ID_PERIODO));
    assertEquals(trabajo.getIcmIdPeriodo(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ICM_ID_PERIODO));
    // idEstado
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO));
    assertEquals(EstadoPeriodoCalculoPersonaEnum.EXPORTADO.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO));
  }

}
