package com.inditex.rrhh.icmclcwb.config.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class TareaCalculoQueryTest {

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Test
  @Disabled("Se necesita un tarea y un algoritmo para probar este calculo")
  public void sqlCalcularGlobalTiendaWhereIdTarea() {
    final MapSqlParameterSource arg = new MapSqlParameterSource();
    arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, 7L);
    arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO, 1L);
    this.namedParameterJdbcTemplate.update("", arg);
  }

}
