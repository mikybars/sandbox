package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccionFallidas;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccionFallidasPk;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TipoFallidas;

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

@ExtendWith({SpringExtension.class})
class TareaFaseAccionFallidasRepositoryCustomImplTest {

  private final static String SQL_INSERT_FALLIDAS = "SQL INSERT FALLIDAS";

  @InjectMocks
  TareaFaseAccionFallidasRepositoryCustomImpl tareaFaseAccionFallidasRepositoryCustom;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaFaseAccionFallidasRepositoryCustom,
        "sqlSave", SQL_INSERT_FALLIDAS, true);
  }

  @Test
  void saveTest() {
    final TareaFaseAccion TFA = new TareaFaseAccion();
    TFA.setId(1L);
    final TareaFaseAccionFallidasPk TFAFPk = new TareaFaseAccionFallidasPk();
    TFAFPk.setTareaFaseAccion(TFA);
    final TipoFallidas TF = new TipoFallidas();
    TF.setId(1);

    final TareaFaseAccionFallidas TFAF = new TareaFaseAccionFallidas();
    TFAF.setFallidas("55, 66");
    TFAF.setPk(TFAFPk);
    TFAF.setTipoFallidas(TF);

    this.tareaFaseAccionFallidasRepositoryCustom.save(TFAF);
    verify(this.namedParameterJdbcTemplate).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());

    assertEquals(SQL_INSERT_FALLIDAS, this.sqlCaptor.getValue());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1L, params.getValue("idTareaFaseAccion"));
    assertEquals(1, params.getValue("idTipoFallidas"));
    assertEquals("55, 66", params.getValue("fallidas"));
  }

}
