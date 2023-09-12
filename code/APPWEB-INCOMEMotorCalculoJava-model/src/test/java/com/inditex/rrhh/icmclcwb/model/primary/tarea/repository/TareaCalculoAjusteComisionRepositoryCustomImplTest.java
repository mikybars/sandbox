/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

import org.apache.commons.lang3.reflect.FieldUtils;
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
class TareaCalculoAjusteComisionRepositoryCustomImplTest {

  private static final String SQL_NORMALIZAR_AJUSTE_COMISION = "SQL NORMALIZAR AJUSTE COMISION";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> params;

  @InjectMocks
  private TareaCalculoAjusteComisionRepositoryCustomImpl tareaCalculoAjusteComisionRepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaCalculoAjusteComisionRepositoryCustom, "sqlNormalizarAjusteComision",
        SQL_NORMALIZAR_AJUSTE_COMISION, true);
  }

  @Test
  void normalizarAjusteComisionTest() {

    final long idTarea = 89389L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.tareaCalculoAjusteComisionRepositoryCustom.normalizarAjusteComision(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_NORMALIZAR_AJUSTE_COMISION),
        this.params.capture());
    // parametros de la consulta: id tarea
    assertEquals(1, this.params.getValue().getValues().size());
    assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

  }

}
