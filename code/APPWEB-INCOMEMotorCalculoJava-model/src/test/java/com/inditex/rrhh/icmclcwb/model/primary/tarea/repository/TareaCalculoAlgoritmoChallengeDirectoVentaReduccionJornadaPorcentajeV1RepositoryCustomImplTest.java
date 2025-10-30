package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_CALCULA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_COMISIONABLE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.dto.TipoCalculoDTO;
import com.inditex.rrhh.icmclcwb.dto.TipoComisionDTO;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.instancio.Instancio;
import org.instancio.Select;
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
class TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeV1RepositoryCustomImplTest {

  private final static String SQL_BASE = "SQL CALCULAR BASE";

  private final static String SQL_CALCULAR = "SQL CALCULAR";

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private TipoDatoService tipoDatoService;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource[]> params;

  @InjectMocks
  private TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeV1RepositoryCustomImpl repository;

  @BeforeEach
  void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.repository, "sqlCalcular", SQL_CALCULAR, true);
    FieldUtils.writeField(this.repository, "sqlCalcularBase", SQL_BASE, true);
  }

  @Test
  void idsTest() {
    final TareaDto tarea = Instancio.of(TareaDto.class)
        .set(Select.field(TareaDto::getId), 101L)
        .create();

    final AlgoritmoDTO algoritmo = Instancio.of(AlgoritmoDTO.class)
        .set(Select.field(AlgoritmoDTO::getId), 1001)
        .create();

    final List<IdPersonaLocalDto> expectedPersonas = Instancio.ofList(IdPersonaLocalDto.class)
        .size(2)
        .create();

    when(this.tareaCalculoPersonaService.findByAlgoritmo(any(TareaDto.class), any(AlgoritmoDTO.class)))
        .thenReturn(expectedPersonas);

    final List<IdPersonaLocalDto> result = this.repository.ids(algoritmo, tarea);

    assertNotNull(result);
    assertEquals(2, result.size());
    assertEquals(expectedPersonas, result);
    verify(this.tareaCalculoPersonaService).findByAlgoritmo(tarea, algoritmo);
  }

  @Test
  void idsTestWithNullValues() {
    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    final TareaDto tarea = null;

    final List<IdPersonaLocalDto> expectedPersonas = Instancio.ofList(IdPersonaLocalDto.class)
        .size(1)
        .create();

    when(this.tareaCalculoPersonaService.findByAlgoritmo(any(), any(AlgoritmoDTO.class)))
        .thenReturn(expectedPersonas);

    final List<IdPersonaLocalDto> result = this.repository.ids(algoritmo, tarea);

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(expectedPersonas, result);
    verify(this.tareaCalculoPersonaService).findByAlgoritmo(tarea, algoritmo);
  }

  @Test
  void getMapValuesTest() {

    final AlgoritmoDTO algoritmo = this.createTestAlgoritmo();
    final TareaDto tarea = Instancio.of(TareaDto.class)
        .set(Select.field(TareaDto::getId), 101L)
        .create();
    final IdPersonaLocalDto persona = Instancio.of(IdPersonaLocalDto.class)
        .set(Select.field(IdPersonaLocalDto::getIdPersonaLocal), "AT1001")
        .set(Select.field(IdPersonaLocalDto::getStdOrHrPeriod), "01")
        .create();

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(List.of(new IdTipoDatoDto(1011)));

    final Map<String, Object> result = this.repository.getMapValues(algoritmo, tarea, persona);

    assertNotNull(result);
    assertEquals(12, result.size());

    // Verify all expected parameters
    assertTrue(result.containsKey(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ACTIVO));

    assertTrue(result.containsKey(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
    assertEquals(List.of(1011), result.get(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));

    assertTrue(result.containsKey(SQL_PARAM_ID_ALGORITMO));
    assertEquals(algoritmo.getId(), result.get(SQL_PARAM_ID_ALGORITMO));

    assertTrue(result.containsKey(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), result.get(SQL_PARAM_ID_TAREA));

    assertTrue(result.containsKey(SQL_PARAM_CCL_ID_PERSON));
    assertEquals(persona.getIdPersonaLocal(), result.get(SQL_PARAM_CCL_ID_PERSON));

    assertTrue(result.containsKey(SQL_PARAM_STD_OR_HR_PERIOD));
    assertEquals(persona.getStdOrHrPeriod(), result.get(SQL_PARAM_STD_OR_HR_PERIOD));

    assertTrue(result.containsKey(SQL_PARAM_COMISIONABLE));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_COMISIONABLE));

    assertTrue(result.containsKey(SQL_PARAM_CALCULA));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_CALCULA));

    assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_COMISION));
    assertEquals(Arrays.asList("001", "002", "003"), result.get(SQL_PARAM_IDS_TIPOS_COMISION));

    assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(Arrays.asList("011", "012"), result.get(SQL_PARAM_IDS_TIPOS_CALCULO));

    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));

    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));

    verify(this.tipoDatoService).findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
  }

  @Test
  void getMapValuesTestWithNullTarea() {

    final AlgoritmoDTO algoritmo = this.createTestAlgoritmo();
    final TareaDto tarea = null;
    final IdPersonaLocalDto persona = Instancio.of(IdPersonaLocalDto.class)
        .set(Select.field(IdPersonaLocalDto::getIdPersonaLocal), "AT1001")
        .set(Select.field(IdPersonaLocalDto::getStdOrHrPeriod), "01")
        .create();

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(List.of(new IdTipoDatoDto(1011)));

    final Map<String, Object> result = this.repository.getMapValues(algoritmo, tarea, persona);

    assertNotNull(result);
    assertEquals(11, result.size()); // One less parameter since tarea is null
    assertTrue(result.containsKey(SQL_PARAM_ID_ALGORITMO));
    assertTrue(result.containsKey(SQL_PARAM_CCL_ID_PERSON));
    assertTrue(result.containsKey(SQL_PARAM_STD_OR_HR_PERIOD));
    // Tarea parameters should not be present
    assertFalse(result.containsKey(SQL_PARAM_ID_TAREA));
  }

  @Test
  void getMapValuesTestWithNullPersona() {

    final AlgoritmoDTO algoritmo = this.createTestAlgoritmo();
    final TareaDto tarea = Instancio.of(TareaDto.class)
        .set(Select.field(TareaDto::getId), 101L)
        .create();
    final IdPersonaLocalDto persona = null;

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(List.of(new IdTipoDatoDto(1011)));

    final Map<String, Object> result = this.repository.getMapValues(algoritmo, tarea, persona);

    assertNotNull(result);
    assertEquals(10, result.size()); // Two less parameters since persona is null
    assertTrue(result.containsKey(SQL_PARAM_ID_ALGORITMO));
    assertTrue(result.containsKey(SQL_PARAM_ID_TAREA));
    // Persona parameters should not be present
    assertFalse(result.containsKey(SQL_PARAM_CCL_ID_PERSON));
    assertFalse(result.containsKey(SQL_PARAM_STD_OR_HR_PERIOD));
  }

  @Test
  void getMapValuesTestWithDesplazamientoFalse() {

    final AlgoritmoDTO algoritmo = this.createTestAlgoritmoWithDesplazamientoFalse();
    final TareaDto tarea = Instancio.of(TareaDto.class)
        .set(Select.field(TareaDto::getId), 101L)
        .create();
    final IdPersonaLocalDto persona = Instancio.of(IdPersonaLocalDto.class)
        .set(Select.field(IdPersonaLocalDto::getIdPersonaLocal), "AT1001")
        .set(Select.field(IdPersonaLocalDto::getStdOrHrPeriod), "01")
        .create();

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(List.of(new IdTipoDatoDto(1011)));

    final Map<String, Object> result = this.repository.getMapValues(algoritmo, tarea, persona);

    assertNotNull(result);
    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));

    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
  }

  @Test
  void calcularTest() {

    final AlgoritmoDTO algoritmo = this.createTestAlgoritmo();
    final TareaDto tarea = Instancio.of(TareaDto.class)
        .set(Select.field(TareaDto::getId), 101L)
        .create();

    final List<IdPersonaLocalDto> personas = Instancio.ofList(IdPersonaLocalDto.class)
        .size(2)
        .generate(Select.field(IdPersonaLocalDto::getIdPersonaLocal), gen -> gen.string().length(6))
        .generate(Select.field(IdPersonaLocalDto::getStdOrHrPeriod), gen -> gen.oneOf("01", "02"))
        .create();

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(List.of(new IdTipoDatoDto(1011)));

    this.repository.calcular(algoritmo, tarea, personas);

    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.namedParameterJdbcTemplate).batchUpdate(anyString(), this.params.capture());

    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);

    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      assertEquals(12, value.getValues().size());

      // Verify common parameters
      assertTrue(value.hasValue(SQL_PARAM_ACTIVO));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_ACTIVO));

      assertTrue(value.hasValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
      assertEquals(List.of(1011), value.getValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));

      assertTrue(value.hasValue(SQL_PARAM_ID_ALGORITMO));
      assertEquals(algoritmo.getId(), value.getValue(SQL_PARAM_ID_ALGORITMO));

      assertTrue(value.hasValue(SQL_PARAM_ID_TAREA));
      assertEquals(tarea.getId(), value.getValue(SQL_PARAM_ID_TAREA));

      assertTrue(value.hasValue(SQL_PARAM_COMISIONABLE));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_COMISIONABLE));

      assertTrue(value.hasValue(SQL_PARAM_CALCULA));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_CALCULA));

      assertTrue(value.hasValue(SQL_PARAM_IDS_TIPOS_COMISION));
      assertEquals(Arrays.asList("001", "002", "003"), value.getValue(SQL_PARAM_IDS_TIPOS_COMISION));

      assertTrue(value.hasValue(SQL_PARAM_IDS_TIPOS_CALCULO));
      assertEquals(Arrays.asList("011", "012"), value.getValue(SQL_PARAM_IDS_TIPOS_CALCULO));

      assertTrue(value.hasValue(SQL_PARAM_ES_DESPLAZAMIENTO));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_ES_DESPLAZAMIENTO));

      assertTrue(value.hasValue(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
      assertEquals(SQL_VALUE_BOOLEAN_FALSE, value.getValue(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));

      // Verify persona-specific parameters
      assertTrue(value.hasValue(SQL_PARAM_CCL_ID_PERSON));
      assertTrue(value.hasValue(SQL_PARAM_STD_OR_HR_PERIOD));
    }

    // Verify that each persona appears exactly once
    final List<String> personIds = Arrays.stream(values)
        .map(value -> (String) value.getValue(SQL_PARAM_CCL_ID_PERSON))
        .toList();

    for (final IdPersonaLocalDto persona : personas) {
      assertTrue(personIds.contains(persona.getIdPersonaLocal()));
    }
  }

  @Test
  void calcularTestWithEmptyPersonas() {

    final AlgoritmoDTO algoritmo = this.createTestAlgoritmo();
    final TareaDto tarea = Instancio.of(TareaDto.class)
        .set(Select.field(TareaDto::getId), 101L)
        .create();
    final List<IdPersonaLocalDto> personas = List.of();

    this.repository.calcular(algoritmo, tarea, personas);

    verify(this.tipoDatoService, times(0))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.namedParameterJdbcTemplate).batchUpdate(anyString(), this.params.capture());

    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(0, values.length);
  }

  @Test
  void getSqlCalcularTest() {

    final AlgoritmoDTO algoritmo = Instancio.of(AlgoritmoDTO.class)
        .set(Select.field(AlgoritmoDTO::getId), 21)
        .create();

    final String result = this.repository.getSqlCalcular(algoritmo);

    assertEquals(SQL_BASE, result);
  }

  @Test
  void getSqlCalcularTestWithDifferentId() {

    final AlgoritmoDTO algoritmo = Instancio.of(AlgoritmoDTO.class)
        .set(Select.field(AlgoritmoDTO::getId), 100)
        .create();

    final String result = this.repository.getSqlCalcular(algoritmo);

    assertEquals(SQL_BASE, result);
  }

  /**
   * Creates a test AlgoritmoDTO with predefined values for testing.
   */
  private AlgoritmoDTO createTestAlgoritmo() {
    final AlgoritmoDTO algoritmo = Instancio.of(AlgoritmoDTO.class)
        .set(Select.field(AlgoritmoDTO::getId), 1001)
        .set(Select.field(AlgoritmoDTO::getDesplazamiento), Boolean.TRUE)
        .set(Select.field(AlgoritmoDTO::getDesplazamientoBase), Boolean.FALSE)
        .create();

    // Create TipoCalculoDTO objects
    final TipoCalculoDTO tipoCalculo1 = new TipoCalculoDTO();
    tipoCalculo1.setId("011");
    final TipoCalculoDTO tipoCalculo2 = new TipoCalculoDTO();
    tipoCalculo2.setId("012");
    algoritmo.setTipoCalculo(Arrays.asList(tipoCalculo1, tipoCalculo2));

    // Create TipoComisionDTO objects
    final TipoComisionDTO tipoComision1 = new TipoComisionDTO();
    tipoComision1.setId("001");
    final TipoComisionDTO tipoComision2 = new TipoComisionDTO();
    tipoComision2.setId("002");
    final TipoComisionDTO tipoComision3 = new TipoComisionDTO();
    tipoComision3.setId("003");
    algoritmo.setTipoComision(Arrays.asList(tipoComision1, tipoComision2, tipoComision3));

    return algoritmo;
  }

  /**
   * Creates a test AlgoritmoDTO with desplazamiento set to false.
   */
  private AlgoritmoDTO createTestAlgoritmoWithDesplazamientoFalse() {
    final AlgoritmoDTO algoritmo = this.createTestAlgoritmo();
    algoritmo.setDesplazamiento(Boolean.FALSE);
    algoritmo.setDesplazamientoBase(Boolean.TRUE);
    return algoritmo;
  }

}
