package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.rrhh.icmclcwb.dto.EstadoTrabajoDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

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
public class TrabajoRepositoryCustomImplTest {

  private final static String SQL_UPDATE_ESTADO = "SQL UPDATE ESTADO";

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

}
