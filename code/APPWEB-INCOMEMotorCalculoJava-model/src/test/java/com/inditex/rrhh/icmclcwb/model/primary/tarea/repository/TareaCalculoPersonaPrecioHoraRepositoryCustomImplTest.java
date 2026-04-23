package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCalculoPersona;

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
class TareaCalculoPersonaPrecioHoraRepositoryCustomImplTest {

  private final String sqlInsert = "INSERT PRECIO HORA";

  private final String sqlIds = "SELECT IDS";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private TareaCalculoPersonaPrecioHoraRepositoryCustomImpl tareaCalculoPersonaPrecioHoraRepositoryCustomImpl;

  @Captor
  private ArgumentCaptor<String> sql;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> params;

  @BeforeEach
  void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaCalculoPersonaPrecioHoraRepositoryCustomImpl, "sqlInsertPrecioHora", this.sqlInsert,
        true);
    FieldUtils.writeField(this.tareaCalculoPersonaPrecioHoraRepositoryCustomImpl, "sqlIds", this.sqlIds, true);
  }

  @Test
  void idsTest() {
    final Long idTarea = 123L;
    final String cclIdOrigen = "origen";
    this.tareaCalculoPersonaPrecioHoraRepositoryCustomImpl.ids(idTarea, cclIdOrigen);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sql.capture(), this.params.capture(),
        ArgumentMatchers.<RowMapper<TareaCalculoPersona>>any());

    assertEquals(this.sqlIds, this.sql.getValue());
    assertEquals(2, this.params.getValue().getValues().size());
    assertEquals(idTarea, this.params.getValue().getValue("idTarea"));
    assertEquals(cclIdOrigen, this.params.getValue().getValue("cclIdOrigen"));
  }

  @Test
  void insertPrecioHoraTest() {
    final Long idTarea = 123L;
    final Long icmIdPeriodo = 456L;
    final String cclIdOrigen = "origen";
    final String stdIdLegEnt = "legEnt";
    final String cclIdPerson = "789";

    this.tareaCalculoPersonaPrecioHoraRepositoryCustomImpl.insertPrecioHora(idTarea, icmIdPeriodo, cclIdOrigen, stdIdLegEnt,
        List.of(cclIdPerson));
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sql.capture(), this.params.capture(),
        ArgumentMatchers.<RowMapper<TareaCalculoPersona>>any());

    assertEquals(this.sqlInsert, this.sql.getValue());
    assertEquals(5, this.params.getValue().getValues().size());
    assertEquals(idTarea, this.params.getValue().getValue("idTarea"));
    assertEquals(icmIdPeriodo, this.params.getValue().getValue("icmIdPeriodo"));
    assertEquals(cclIdOrigen, this.params.getValue().getValue("cclIdOrigen"));
    assertEquals(stdIdLegEnt, this.params.getValue().getValue("stdIdLegEnt"));
    assertEquals(List.of(cclIdPerson), this.params.getValue().getValue("cclIdPerson"));
  }

}
