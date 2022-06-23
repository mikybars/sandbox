package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.Arrays;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccionDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccionDatoPk;

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
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TareaFaseAccionDatoRepositoryCustomImplTest {

  private final static String SQL_INSERT_DATO = "SQL INSERT DATO";

  @InjectMocks
  TareaFaseAccionDatoRepositoryCustomImpl tareaFaseAccionFallidasRepositoryCustom;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaFaseAccionFallidasRepositoryCustom,
        "sqlSave", SQL_INSERT_DATO, true);
    FieldUtils.writeField(this.tareaFaseAccionFallidasRepositoryCustom,
        "batchSize", 100, true);
  }

  @Test
  void saveTest() {
    final TareaFaseAccion TFA = new TareaFaseAccion();
    TFA.setId(1L);
    final TareaFaseAccionDatoPk TFAFPk = new TareaFaseAccionDatoPk();
    TFAFPk.setTareaFaseAccion(TFA);
    TFAFPk.setDato("55");
    final TipoDato TD = new TipoDato();
    TD.setId(1);

    final TareaFaseAccionDato TFAF = new TareaFaseAccionDato();
    TFAF.setPk(TFAFPk);
    TFAF.setTipoDato(TD);

    this.tareaFaseAccionFallidasRepositoryCustom.save(Arrays.asList(TFAF));

    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
    assertEquals(SQL_INSERT_DATO, this.sqlCaptor.getValue());
  }

}
