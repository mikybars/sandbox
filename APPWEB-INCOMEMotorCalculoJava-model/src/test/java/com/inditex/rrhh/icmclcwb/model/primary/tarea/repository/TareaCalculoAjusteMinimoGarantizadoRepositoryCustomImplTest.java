package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
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
public class TareaCalculoAjusteMinimoGarantizadoRepositoryCustomImplTest {

  private final static String SQL_AJUSTAR_BASE = "SQL CALCULAR BASE";

  private final static String SQL_AJUSTAR = "SQL CALCULAR";

  @Mock
  private TareaCalculoPersonaService tareaCalculoPerosnaService;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource[]> params;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @InjectMocks
  private TareaCalculoAjusteMinimoGarantizadoRepositoryCustomImpl tareaCalculoAjusteMinimoGarantizadoRepositoryCustomImpl;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaCalculoAjusteMinimoGarantizadoRepositoryCustomImpl, "sqlAjustar", SQL_AJUSTAR,
        true);
    FieldUtils.writeField(this.tareaCalculoAjusteMinimoGarantizadoRepositoryCustomImpl, "sqlAjustarBase",
        SQL_AJUSTAR_BASE, true);
  }

  @Test
  public void idsTest() {
    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    final IdPersonaLocalDto persona2 = mock(IdPersonaLocalDto.class);
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);
    when(this.tareaCalculoPerosnaService.findByTareaAndIdEstadoAndIdTipoPolitica(any(TareaDto.class),
        any(String.class)))
            .thenReturn(personas);

    final TareaDto tarea = mock(TareaDto.class);
    final List<IdPersonaLocalDto> ids = this.tareaCalculoAjusteMinimoGarantizadoRepositoryCustomImpl
        .ids(tarea);

    assertEquals(personas, ids);
  }

  @Test
  public void getMapValuesTest() {
    final AlgoritmoAjusteDto algoritmoAjuste = mock(AlgoritmoAjusteDto.class);
    when(algoritmoAjuste.getId()).thenReturn(11003);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(101L);
    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    when(persona1.getIdPersonaLocal()).thenReturn("AT1001");
    when(persona1.getStdOrHrPeriod()).thenReturn("01");

    final Map<String, Object> result = this.tareaCalculoAjusteMinimoGarantizadoRepositoryCustomImpl
        .getMapValues(algoritmoAjuste, tarea, persona1);
    assertEquals(7, result.size());

    // idTarea
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), result.get(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // cclIdPerson
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
    assertEquals(persona1.getIdPersonaLocal(), result.get(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
    // stdOrHrPeriod
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
    assertEquals(persona1.getStdOrHrPeriod(), result.get(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
    // idAlgoritmo
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO_AJUSTE));
    assertEquals(algoritmoAjuste.getId(), result.get(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO_AJUSTE));
    // idTipoPolitica
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
    assertEquals(TipoPoliticaEnum.MINIMO_GARANTIZADO.getId(),
        result.get(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
    // idTipoPoliticaAjuste
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE));
    assertEquals(
        Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD.getIdMeta4(), TipoPoliticaEnum.VACACIONES.getIdMeta4(),
            TipoPoliticaEnum.BAJA_IT.getIdMeta4()),
        result.get(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE));
    // inactivo
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE, result.get(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
  }

}
