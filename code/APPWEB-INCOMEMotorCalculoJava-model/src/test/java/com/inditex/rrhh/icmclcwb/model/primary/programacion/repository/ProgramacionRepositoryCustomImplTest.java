package com.inditex.rrhh.icmclcwb.model.primary.programacion.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ProgramacionRepositoryCustomImplTest {

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private ProgramacionRepositoryCustomImpl programacionRepositoryCustom;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> params;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(programacionRepositoryCustom, "sqlCustomReset", "", true);
    FieldUtils.writeField(programacionRepositoryCustom, "sqlCheckActiva", "", true);
  }

  @Test
  public void resetTest() throws ParseException {

    programacionRepositoryCustom.reset();

    verify(namedParameterJdbcTemplate, times(1)).update(any(String.class), params.capture());

    // parametros consulta SQL: fechaSiguienteEjecucion, activo
    assertEquals(2, params.getValue().getValues().size());
    // fechaSiguienteEjecucion
    assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_FECHA_SIGUIENTE_EJECUCION));
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    assertTrue(DateUtils.isSameDay(sdf.parse("01/01/1800"),
        (Date) params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_FECHA_SIGUIENTE_EJECUCION)));
    // activo
    assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
        params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
  }

  @Test
  public void activaTest() {

    programacionRepositoryCustom.activa();

    verify(namedParameterJdbcTemplate, times(1)).update(any(String.class), params.capture());

    // parametros consulta SQL: activo
    assertEquals(1, params.getValue().getValues().size());
    // activo
    assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
        params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));

  }

}
