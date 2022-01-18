package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamiento;

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

@ExtendWith(SpringExtension.class)
class TareaPersonaEstructuraDesplazamientoRepositoryCustomImplTest {

  private static final String SQL_SAVE = "SQL SAVE";

  private static final String SQL_CREAR_CHALLENGE_OPCION_ORIGEN_IGUALAR_BANDAS = "SQL CREAR CHALLENGE OPCION ORIGEN IGUALR BANDAS";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @InjectMocks
  private TareaPersonaEstructuraDesplazamientoRepositoryCustomImpl tareaPersonaEstructuraDesplazamientoRepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaPersonaEstructuraDesplazamientoRepositoryCustom,
        "sqlSave", SQL_SAVE, true);
    FieldUtils.writeField(this.tareaPersonaEstructuraDesplazamientoRepositoryCustom,
        "batchSize", 100, true);
    FieldUtils.writeField(this.tareaPersonaEstructuraDesplazamientoRepositoryCustom,
        "sqlCrearChallengeOpcionOrigenIgualarBandas", SQL_CREAR_CHALLENGE_OPCION_ORIGEN_IGUALAR_BANDAS, true);
  }

  @Test
  void saveTest() {
    final List<TareaPersonaEstructuraDesplazamiento> items = Arrays
        .asList(mock(TareaPersonaEstructuraDesplazamiento.class));
    this.tareaPersonaEstructuraDesplazamientoRepositoryCustom.save(items);
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
    assertEquals(SQL_SAVE, this.sqlCaptor.getValue());
  }

  @Test
  void crearEstructurasDestinoIgualarBandasTest() {

    final ArgumentCaptor<MapSqlParameterSource> paramsCaptor = ArgumentCaptor.forClass(MapSqlParameterSource.class);
    this.tareaPersonaEstructuraDesplazamientoRepositoryCustom.crearEstructurasDestinoIgualarBandas();
    verify(this.namedParameterJdbcTemplate).update(eq(SQL_CREAR_CHALLENGE_OPCION_ORIGEN_IGUALAR_BANDAS), paramsCaptor.capture());
    final MapSqlParameterSource params = paramsCaptor.getValue();
    final Map<String, Object> expected = new HashMap<String, Object>() {
      private static final long serialVersionUID = -8705967666979364371L;

      {
        this.put(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        this.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
      }
    };

    assertEquals(expected, params.getValues());

  }

}
