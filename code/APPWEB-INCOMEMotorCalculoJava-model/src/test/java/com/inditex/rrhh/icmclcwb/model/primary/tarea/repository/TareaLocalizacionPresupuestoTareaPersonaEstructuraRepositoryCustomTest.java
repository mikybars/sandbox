package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
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
public class TareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustomTest {

  private final static String SQL_RELACIONAR_ESTRUCTURA_SIN_DESPLAZAMIENTO = "SQL RELACIONAR ESTRUCTURA SIN DESPLAZAMIENTO";

  private final static String SQL_RELACIONAR_ESTRUCTURA_DESPLAZAMIENTO = "SQL RELACIONAR ESTRUCTURA DESPLAZAMIENTO";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private TareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustomImpl tareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom,
        "sqlRelacionarEstructuraSinDesplazamiento", SQL_RELACIONAR_ESTRUCTURA_SIN_DESPLAZAMIENTO, true);
  }

  @Test
  public void relacionarSinDesplazamientoTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(89348L);

    this.tareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom.relacionarEstructuraSinDesplazamiento(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_RELACIONAR_ESTRUCTURA_SIN_DESPLAZAMIENTO, this.sqlCaptor.getValue());

    // Parámetros de la consulta: idTarea, incluidoChallenge, tiposCalculo,
    // tiposCalculoChallengeLocalizacion,
    // tiposCalculoChallengePrecioHora, activo
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(5, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // incluidoChallenge
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INCLUIDO_CHALLENGE));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
        params.getValue(SqlPrimaryConstants.SQL_PARAM_INCLUIDO_CHALLENGE));
    // tiposCalculo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(Arrays.asList(TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(),
        TipoCalculoEnum.CHALLENGE_PRECIO_HORA_SECCION.getId(),
        TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_IMPORTE_SECCION.getId(),
        TipoCalculoEnum.CHALLENGE_PORCENTAJE.getId()),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
    // tiposCalculoChallengeLocalizacion
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO_CHALLENGE_LOCALIZACION));
    assertEquals(
        Arrays.asList(TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(),
            TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_PORCENTAJE.getId()),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO_CHALLENGE_LOCALIZACION));
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
  }

}
