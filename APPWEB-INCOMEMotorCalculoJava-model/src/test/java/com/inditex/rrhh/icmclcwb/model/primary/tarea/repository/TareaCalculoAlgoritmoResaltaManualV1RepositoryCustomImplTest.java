package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_COMISION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoComisionEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.dto.TipoCalculoDTO;
import com.inditex.rrhh.icmclcwb.dto.TipoComisionDTO;

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

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
public class TareaCalculoAlgoritmoResaltaManualV1RepositoryCustomImplTest {

  private final static String SQL_BASE = "SQL CALCULAR BASE";

  private final static String SQL_CALCULAR = "SQL CALCULAR";

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource[]> params;

  @InjectMocks
  private TareaCalculoAlgoritmoResaltaManualV1RepositoryCustomImpl tareaCalculoAlgoritmoResaltaManualV1RepositoryCustom;

  @Random
  private AlgoritmoDTO algoritmo;

  @Random
  private TareaDto tarea;

  @Random
  private IdPersonaLocalDto persona;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaCalculoAlgoritmoResaltaManualV1RepositoryCustom,
        "sqlCalcular",
        SQL_CALCULAR, true);
    FieldUtils.writeField(this.tareaCalculoAlgoritmoResaltaManualV1RepositoryCustom,
        "sqlCalcularBase", SQL_BASE, true);
  }

  @Test
  public void idsTest() {

    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    final IdPersonaLocalDto persona2 = mock(IdPersonaLocalDto.class);
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);
    when(this.tareaCalculoPersonaService.findByAlgoritmo(any(TareaDto.class), any(AlgoritmoDTO.class)))
        .thenReturn(personas);

    final TareaDto tarea = mock(TareaDto.class);
    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoResaltaManualV1RepositoryCustom.ids(algoritmo,
        tarea);

    assertEquals(2, ids.size());
    assertEquals(personas, ids);

  }

  @Test
  public void getMapValuesTest() {

    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(1001);
    final TipoCalculoDTO tipoCalculo = new TipoCalculoDTO();
    tipoCalculo.setId(TipoCalculoEnum.NINGUNO.getId());
    final TipoComisionDTO tipoComision = new TipoComisionDTO();
    tipoComision.setId(TipoComisionEnum.RESALTA_MANUAL.getId());
    when(algoritmo.getTipoComision())
        .thenReturn(Arrays.asList(tipoComision));
    when(algoritmo.getTipoCalculo())
        .thenReturn(Arrays.asList(tipoCalculo));

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(101L);
    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    when(persona1.getIdPersonaLocal()).thenReturn("AT1001");
    when(persona1.getStdOrHrPeriod()).thenReturn("01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoResaltaManualV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // parametros de la consulta: idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, tiposCalculo,
    // tiposComision, esDesplazamiento, esDesplazamientoBase
    assertEquals(9, result.size());
    // idAlgoritmo
    assertTrue(result.containsKey(SQL_PARAM_ID_ALGORITMO));
    assertEquals(algoritmo.getId(), result.get(SQL_PARAM_ID_ALGORITMO));
    // idTarea
    assertTrue(result.containsKey(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), result.get(SQL_PARAM_ID_TAREA));
    // cclIdPerson
    assertTrue(result.containsKey(SQL_PARAM_CCL_ID_PERSON));
    assertEquals(persona1.getIdPersonaLocal(), result.get(SQL_PARAM_CCL_ID_PERSON));
    // stdOrHrPeriod
    assertTrue(result.containsKey(SQL_PARAM_STD_OR_HR_PERIOD));
    assertEquals(persona1.getStdOrHrPeriod(), result.get(SQL_PARAM_STD_OR_HR_PERIOD));
    // tipocomision
    assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_COMISION));
    assertEquals(Arrays.asList(TipoComisionEnum.RESALTA_MANUAL.getId()), result.get(SQL_PARAM_IDS_TIPOS_COMISION));
    // tipocalculo
    assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(Arrays.asList(TipoCalculoEnum.NINGUNO.getId()), result.get(SQL_PARAM_IDS_TIPOS_CALCULO));
    // idTipoComision
    assertTrue(result.containsKey(SQL_PARAM_ID_TIPO_COMISION));
    assertEquals(TipoComisionEnum.RESALTA_MANUAL.getId(), result.get(SQL_PARAM_ID_TIPO_COMISION));
    // esDesplazamiento
    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
    // esDesplazamientoBase
    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));

  }

  @Test
  public void calcularTest() {

    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(1001);
    final TipoCalculoDTO tipoCalculo = new TipoCalculoDTO();
    tipoCalculo.setId(TipoCalculoEnum.NINGUNO.getId());
    final TipoComisionDTO tipoComision = new TipoComisionDTO();
    tipoComision.setId(TipoComisionEnum.RESALTA_MANUAL.getId());
    when(algoritmo.getTipoComision())
        .thenReturn(Arrays.asList(tipoComision));
    when(algoritmo.getTipoCalculo())
        .thenReturn(Arrays.asList(tipoCalculo));
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(101L);
    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    when(persona1.getIdPersonaLocal()).thenReturn("AT1001");
    when(persona1.getStdOrHrPeriod()).thenReturn("01");
    final IdPersonaLocalDto persona2 = mock(IdPersonaLocalDto.class);
    when(persona2.getIdPersonaLocal()).thenReturn("AT1002");
    when(persona2.getStdOrHrPeriod()).thenReturn("02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

    this.tareaCalculoAlgoritmoResaltaManualV1RepositoryCustom.calcular(algoritmo, tarea, personas);;

    // parametros de la consulta: idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, tiposCalculo,
    // tiposComision, esDesplazamiento, esDesplazamientoBase, comisionable, calcula
    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      assertEquals(9, value.getValues().size());
      // algoritmo
      assertTrue(value.hasValue(SQL_PARAM_ID_ALGORITMO));
      assertEquals(algoritmo.getId(), value.getValue(SQL_PARAM_ID_ALGORITMO));
      // cclIdPerson, stdOrHrPeriod - existencia del parámetro
      assertTrue(value.hasValue(SQL_PARAM_CCL_ID_PERSON));
      assertTrue(value.hasValue(SQL_PARAM_STD_OR_HR_PERIOD));
      // tipocalculo
      assertTrue(value.hasValue(SQL_PARAM_IDS_TIPOS_CALCULO));
      assertEquals(Arrays.asList(TipoCalculoEnum.NINGUNO.getId()), value.getValue(SQL_PARAM_IDS_TIPOS_CALCULO));
      // tipocomision
      assertTrue(value.hasValue(SQL_PARAM_IDS_TIPOS_COMISION));
      assertEquals(Arrays.asList(TipoComisionEnum.RESALTA_MANUAL.getId()),
          value.getValue(SQL_PARAM_IDS_TIPOS_COMISION));
      // idTipoComision
      assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_COMISION));
      assertEquals(TipoComisionEnum.RESALTA_MANUAL.getId(), value.getValue(SQL_PARAM_ID_TIPO_COMISION));
      // esDesplazamiento
      assertTrue(value.hasValue(SQL_PARAM_ES_DESPLAZAMIENTO));
      assertEquals(SQL_VALUE_BOOLEAN_FALSE, value.getValue(SQL_PARAM_ES_DESPLAZAMIENTO));
      // esDesplazamientoBase
      assertTrue(value.hasValue(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
      assertEquals(SQL_VALUE_BOOLEAN_FALSE, value.getValue(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    }

    // cclIdPerson, stdOrHrPeriod - valores del parámetro
    assertEquals(1,
        Arrays.stream(values)
            .filter(value -> persona1.getIdPersonaLocal().equals(value.getValue(SQL_PARAM_CCL_ID_PERSON))
                && persona1.getStdOrHrPeriod().equals(value.getValue(SQL_PARAM_STD_OR_HR_PERIOD)))
            .toArray().length);
    assertEquals(1,
        Arrays.stream(values)
            .filter(value -> persona2.getIdPersonaLocal().equals(value.getValue(SQL_PARAM_CCL_ID_PERSON))
                && persona2.getStdOrHrPeriod().equals(value.getValue(SQL_PARAM_STD_OR_HR_PERIOD)))

            .toArray().length);

  }

  @Test
  public void getSqlCalcularTest() {
    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(21);

    final String result = this.tareaCalculoAlgoritmoResaltaManualV1RepositoryCustom
        .getSqlCalcular(algoritmo);
    assertEquals(SQL_BASE, result);
  }

  @Test
  void getMapValuesTest2() {
    this.algoritmo.setDesplazamientoBase(true);
    this.algoritmo.setDesplazamiento(true);

    final Map<String, Object> result = this.tareaCalculoAlgoritmoResaltaManualV1RepositoryCustom
        .getMapValues(this.algoritmo, this.tarea, this.persona);

    assertNotNull(result);
    assertEquals(result.get(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO), SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    assertEquals(result.get(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE), SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
  }

}
