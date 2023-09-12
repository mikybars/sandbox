package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

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
public class TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaV1RepositoryCustomImplTest {

  private final static String SQL_BASE = "SQL CALCULAR BASE";

  private final static String SQL_CALCULAR = "SQL CALCULAR";

  @Mock
  private TareaCalculoPersonaService tareaCalculoPerosnaService;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource[]> paramsCaptor;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @InjectMocks
  private TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaV1RepositoryCustomImpl tareaCalculoAlgoritmoPorVentaBaseV1RepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaCalculoAlgoritmoPorVentaBaseV1RepositoryCustom, "sqlCalcular", SQL_CALCULAR,
        true);
    FieldUtils.writeField(this.tareaCalculoAlgoritmoPorVentaBaseV1RepositoryCustom, "sqlCalcularBase", SQL_BASE,
        true);
  }

  @Test
  public void idsTest() {

    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    final IdPersonaLocalDto persona2 = mock(IdPersonaLocalDto.class);
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);
    when(this.tareaCalculoPerosnaService.findByAlgoritmo(any(TareaDto.class), any(AlgoritmoDTO.class)))
        .thenReturn(personas);

    final TareaDto tarea = mock(TareaDto.class);
    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);

    final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoPorVentaBaseV1RepositoryCustom.ids(algoritmo,
        tarea);

    assertEquals(2, ids.size());
    assertEquals(personas, ids);
  }

  @Test
  public void getMapValuesTest() {

    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    // when(algoritmo.getId()).thenReturn(1001);
    final TareaDto tarea = mock(TareaDto.class);
    // when(tarea.getId()).thenReturn(101L);
    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    // when(persona1.getCclIdPerson()).thenReturn("AT1001");
    // when(persona1.getStdOrHrPeriod()).thenReturn("01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaBaseV1RepositoryCustom.getMapValues(
        algoritmo, tarea,
        persona1);

    // TODO [COMUN] Definir los parametros de la consulta para el cálculo PorVenta
    assertEquals(0, result.size());

  }

  @Test
  public void calcularTest() {

    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    // when(algoritmo.getId()).thenReturn(1001);
    final TareaDto tarea = mock(TareaDto.class);
    // when(tarea.getId()).thenReturn(101L);
    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    // when(persona1.getCclIdPerson()).thenReturn("AT1001");
    // when(persona1.getStdOrHrPeriod()).thenReturn("01");
    final IdPersonaLocalDto persona2 = mock(IdPersonaLocalDto.class);
    // when(persona2.getCclIdPerson()).thenReturn("AT1002");
    // when(persona2.getStdOrHrPeriod()).thenReturn("02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

    this.tareaCalculoAlgoritmoPorVentaBaseV1RepositoryCustom.calcular(algoritmo, tarea, personas);

    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    // TODO [COMUN] Definir los parametros de la consulta para el cálculo PorVenta
    assertEquals(SQL_CALCULAR, this.sqlCaptor.getValue());
    final MapSqlParameterSource[] values = this.paramsCaptor.getValue();
    // 2 elementos, porque se envían dos personas
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      assertEquals(0, value.getValues().size());
    }

  }

  @Test
  public void getSqlCalcularTest() {

    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    // when(algoritmo.getId()).thenReturn(21);

    final String result = this.tareaCalculoAlgoritmoPorVentaBaseV1RepositoryCustom
        .getSqlCalcular(algoritmo);
    assertEquals(SQL_BASE, result);

  }

}
