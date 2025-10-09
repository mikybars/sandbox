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
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_DESPLAZAMIENTO_BASE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.dto.TipoCalculoDTO;
import com.inditex.rrhh.icmclcwb.dto.TipoComisionDTO;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.instancio.Instancio;
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
class TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RepositoryCustomImplTest {

  private static final String SQL_CALCULAR = "INSERT INTO TEST_TABLE (columna1, columna2) VALUES (:param1, :param2)";

  private static final String SQL_CALCULAR_BASE = "SELECT * FROM TEST_TABLE WHERE activo = activo";

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private TipoDatoService tipoDatoService;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource[]> paramsCaptor;

  @InjectMocks
  private TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RepositoryCustomImpl repository;

  @BeforeEach
  void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.repository, "sqlCalcular", SQL_CALCULAR, true);
    FieldUtils.writeField(this.repository, "sqlCalcularBase", SQL_CALCULAR_BASE, true);
  }

  @Test
  void idsTest() {
    // Given
    final TareaDto tarea = Instancio.create(TareaDto.class);
    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    final List<IdPersonaLocalDto> expectedPersonas = Instancio.ofList(IdPersonaLocalDto.class)
        .size(3)
        .create();

    when(this.tareaCalculoPersonaService.findByAlgoritmo(tarea, algoritmo))
        .thenReturn(expectedPersonas);

    // When
    final List<IdPersonaLocalDto> result = this.repository.ids(algoritmo, tarea);

    // Then
    assertNotNull(result);
    assertEquals(expectedPersonas.size(), result.size());
    assertEquals(expectedPersonas, result);
    verify(this.tareaCalculoPersonaService, times(1)).findByAlgoritmo(tarea, algoritmo);
  }

  @Test
  void getMapValuesWithAllParametersTest() {
    // Given
    final List<IdTipoDatoDto> tipoDatoIds = Arrays.asList(
        new IdTipoDatoDto(101),
        new IdTipoDatoDto(102));
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(tipoDatoIds);

    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    algoritmo.setId(1001);
    algoritmo.setDesplazamiento(Boolean.TRUE);
    algoritmo.setDesplazamientoBase(Boolean.FALSE);

    final List<TipoCalculoDTO> tiposCalculo = Arrays.asList(
        this.createTipoCalculo("TC001"),
        this.createTipoCalculo("TC002"));
    algoritmo.setTipoCalculo(tiposCalculo);

    final List<TipoComisionDTO> tiposComision = Arrays.asList(
        this.createTipoComision("COM001"),
        this.createTipoComision("COM002"),
        this.createTipoComision("COM003"));
    algoritmo.setTipoComision(tiposComision);

    final TareaDto tarea = Instancio.create(TareaDto.class);
    tarea.setId(2001L);

    final IdPersonaLocalDto persona = Instancio.create(IdPersonaLocalDto.class);
    persona.setIdPersonaLocal("PERSON001");
    persona.setStdOrHrPeriod("HR");

    // When
    final Map<String, Object> result = this.repository.getMapValues(algoritmo, tarea, persona);

    // Then
    assertNotNull(result);
    assertEquals(13, result.size());

    // Verify basic parameters
    assertEquals(tarea.getId(), result.get(SQL_PARAM_ID_TAREA));
    assertEquals(persona.getIdPersonaLocal(), result.get(SQL_PARAM_CCL_ID_PERSON));
    assertEquals(persona.getStdOrHrPeriod(), result.get(SQL_PARAM_STD_OR_HR_PERIOD));
    assertEquals(algoritmo.getId(), result.get(SQL_PARAM_ID_ALGORITMO));

    // Verify boolean constants
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_COMISIONABLE));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_CALCULA));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ACTIVO));

    // Verify tipo dato constants
    assertEquals(TipoDatoEnum.INDICADOR_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE.getId(),
        result.get(SQL_PARAM_ID_TIPO_DATO_INDICADOR_DESPLAZAMIENTO_BASE));
    assertEquals(Arrays.asList(101, 102), result.get(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));

    // Verify algorithm specific parameters
    assertEquals(Arrays.asList("COM001", "COM002", "COM003"), result.get(SQL_PARAM_IDS_TIPOS_COMISION));
    assertEquals(Arrays.asList("TC001", "TC002"), result.get(SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));

    verify(this.tipoDatoService, times(1))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
  }

  @Test
  void getMapValuesWithNullTareaTest() {
    // Given
    final List<IdTipoDatoDto> tipoDatoIds = List.of(new IdTipoDatoDto(201));
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class)))
        .thenReturn(tipoDatoIds);

    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    algoritmo.setId(3001);
    algoritmo.setDesplazamiento(Boolean.FALSE);
    algoritmo.setDesplazamientoBase(Boolean.TRUE);
    algoritmo.setTipoCalculo(List.of(this.createTipoCalculo("TC003")));
    algoritmo.setTipoComision(List.of(this.createTipoComision("COM004")));

    final IdPersonaLocalDto persona = Instancio.create(IdPersonaLocalDto.class);
    persona.setIdPersonaLocal("PERSON002");
    persona.setStdOrHrPeriod("STD");

    // When
    final Map<String, Object> result = this.repository.getMapValues(algoritmo, null, persona);

    // Then
    assertNotNull(result);
    assertEquals(12, result.size()); // One less because tarea is null

    // Verify tarea parameter is not included
    assertFalse(result.containsKey(SQL_PARAM_ID_TAREA));

    // Verify other parameters are still present
    assertEquals(persona.getIdPersonaLocal(), result.get(SQL_PARAM_CCL_ID_PERSON));
    assertEquals(algoritmo.getId(), result.get(SQL_PARAM_ID_ALGORITMO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
  }

  @Test
  void getMapValuesWithNullPersonaTest() {
    // Given
    final List<IdTipoDatoDto> tipoDatoIds = List.of(new IdTipoDatoDto(301));
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class)))
        .thenReturn(tipoDatoIds);

    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    algoritmo.setId(4001);
    algoritmo.setDesplazamiento(null); // Testing null desplazamiento
    algoritmo.setDesplazamientoBase(null); // Testing null desplazamientoBase
    algoritmo.setTipoCalculo(List.of(this.createTipoCalculo("TC004")));
    algoritmo.setTipoComision(List.of(this.createTipoComision("COM005")));

    final TareaDto tarea = Instancio.create(TareaDto.class);
    tarea.setId(5001L);

    // When
    final Map<String, Object> result = this.repository.getMapValues(algoritmo, tarea, null);

    // Then
    assertNotNull(result);
    assertEquals(11, result.size()); // Two less because persona is null

    // Verify persona parameters are not included
    assertFalse(result.containsKey(SQL_PARAM_CCL_ID_PERSON));
    assertFalse(result.containsKey(SQL_PARAM_STD_OR_HR_PERIOD));

    // Verify other parameters are still present
    assertEquals(tarea.getId(), result.get(SQL_PARAM_ID_TAREA));
    assertEquals(algoritmo.getId(), result.get(SQL_PARAM_ID_ALGORITMO));

    // Verify null boolean values are handled correctly
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
  }

  @Test
  void calcularTest() {
    // Given
    final List<IdTipoDatoDto> tipoDatoIds = List.of(new IdTipoDatoDto(401));
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class)))
        .thenReturn(tipoDatoIds);

    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    algoritmo.setId(6001);
    algoritmo.setDesplazamiento(Boolean.TRUE);
    algoritmo.setDesplazamientoBase(Boolean.TRUE);
    algoritmo.setTipoCalculo(List.of(this.createTipoCalculo("TC005")));
    algoritmo.setTipoComision(List.of(this.createTipoComision("COM006")));

    final TareaDto tarea = Instancio.create(TareaDto.class);
    tarea.setId(7001L);

    final List<IdPersonaLocalDto> personas = Arrays.asList(
        this.createPersona("PERSON003", "HR1"),
        this.createPersona("PERSON004", "HR2"));

    // When
    this.repository.calcular(algoritmo, tarea, personas);

    // Then
    verify(this.namedParameterJdbcTemplate, times(1))
        .batchUpdate(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource[] capturedParams = this.paramsCaptor.getValue();
    assertNotNull(capturedParams);
    assertEquals(2, capturedParams.length);

    // Verify parameters for each persona
    for (int i = 0; i < capturedParams.length; i++) {
      final MapSqlParameterSource params = capturedParams[i];
      assertNotNull(params);
      assertEquals(13, params.getValues().size());

      // Verify common parameters
      assertEquals(algoritmo.getId(), params.getValue(SQL_PARAM_ID_ALGORITMO));
      assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_COMISIONABLE));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_CALCULA));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ES_DESPLAZAMIENTO));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    }

    // Verify specific persona parameters
    assertTrue(Arrays.stream(capturedParams)
        .anyMatch(params -> "PERSON003".equals(params.getValue(SQL_PARAM_CCL_ID_PERSON))
            && "HR1".equals(params.getValue(SQL_PARAM_STD_OR_HR_PERIOD))));
    assertTrue(Arrays.stream(capturedParams)
        .anyMatch(params -> "PERSON004".equals(params.getValue(SQL_PARAM_CCL_ID_PERSON))
            && "HR2".equals(params.getValue(SQL_PARAM_STD_OR_HR_PERIOD))));

    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
  }

  @Test
  void getSqlCalcularTest() {
    // Given
    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    algoritmo.setId(8001);

    // When
    final String result = this.repository.getSqlCalcular(algoritmo);

    // Then
    assertNotNull(result);
    assertEquals(SQL_CALCULAR_BASE, result);
  }

  @Test
  void getSqlCalcularBaseTest() {
    // When
    final String result = this.repository.getSqlCalcularBase();

    // Then
    assertNotNull(result);
    assertEquals(SQL_CALCULAR_BASE, result);
  }

  @Test
  void getMapValuesWithEmptyListsTest() {
    // Given
    final List<IdTipoDatoDto> tipoDatoIds = List.of();
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class)))
        .thenReturn(tipoDatoIds);

    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    algoritmo.setId(9001);
    algoritmo.setDesplazamiento(Boolean.FALSE);
    algoritmo.setDesplazamientoBase(Boolean.FALSE);
    algoritmo.setTipoCalculo(List.of()); // Empty list
    algoritmo.setTipoComision(List.of()); // Empty list

    final TareaDto tarea = Instancio.create(TareaDto.class);
    tarea.setId(10001L);

    final IdPersonaLocalDto persona = Instancio.create(IdPersonaLocalDto.class);
    persona.setIdPersonaLocal("PERSON005");
    persona.setStdOrHrPeriod("STD");

    // When
    final Map<String, Object> result = this.repository.getMapValues(algoritmo, tarea, persona);

    // Then
    assertNotNull(result);
    assertEquals(13, result.size());

    // Verify empty lists are handled correctly
    assertEquals(List.of(), result.get(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
    assertEquals(List.of(), result.get(SQL_PARAM_IDS_TIPOS_COMISION));
    assertEquals(List.of(), result.get(SQL_PARAM_IDS_TIPOS_CALCULO));
  }

  @Test
  void getMapValuesWithComplexScenarioTest() {
    // Given
    final List<IdTipoDatoDto> tipoDatoIds = Arrays.asList(
        new IdTipoDatoDto(501),
        new IdTipoDatoDto(502),
        new IdTipoDatoDto(503));
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(tipoDatoIds);

    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    algoritmo.setId(11001);
    algoritmo.setDesplazamiento(Boolean.TRUE);
    algoritmo.setDesplazamientoBase(Boolean.TRUE);

    final List<TipoCalculoDTO> tiposCalculo = Arrays.asList(
        this.createTipoCalculo("TC010"),
        this.createTipoCalculo("TC011"),
        this.createTipoCalculo("TC012"),
        this.createTipoCalculo("TC013"));
    algoritmo.setTipoCalculo(tiposCalculo);

    final List<TipoComisionDTO> tiposComision = Arrays.asList(
        this.createTipoComision("COM010"),
        this.createTipoComision("COM011"),
        this.createTipoComision("COM012"),
        this.createTipoComision("COM013"),
        this.createTipoComision("COM014"));
    algoritmo.setTipoComision(tiposComision);

    final TareaDto tarea = Instancio.create(TareaDto.class);
    tarea.setId(12001L);

    final IdPersonaLocalDto persona = Instancio.create(IdPersonaLocalDto.class);
    persona.setIdPersonaLocal("PERSON_COMPLEX");
    persona.setStdOrHrPeriod("COMPLEX");

    // When
    final Map<String, Object> result = this.repository.getMapValues(algoritmo, tarea, persona);

    // Then
    assertNotNull(result);
    assertEquals(13, result.size());

    // Verify multiple items in lists
    assertEquals(Arrays.asList(501, 502, 503), result.get(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
    assertEquals(Arrays.asList("COM010", "COM011", "COM012", "COM013", "COM014"),
        result.get(SQL_PARAM_IDS_TIPOS_COMISION));
    assertEquals(Arrays.asList("TC010", "TC011", "TC012", "TC013"),
        result.get(SQL_PARAM_IDS_TIPOS_CALCULO));

    // Verify both boolean flags are true
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));

    verify(this.tipoDatoService, times(1))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
  }

  // Helper methods
  private TipoCalculoDTO createTipoCalculo(final String id) {
    final TipoCalculoDTO tipoCalculo = new TipoCalculoDTO();
    tipoCalculo.setId(id);
    return tipoCalculo;
  }

  private TipoComisionDTO createTipoComision(final String id) {
    final TipoComisionDTO tipoComision = new TipoComisionDTO();
    tipoComision.setId(id);
    return tipoComision;
  }

  private IdPersonaLocalDto createPersona(final String idPersonaLocal, final String stdOrHrPeriod) {
    final IdPersonaLocalDto persona = Instancio.create(IdPersonaLocalDto.class);
    persona.setIdPersonaLocal(idPersonaLocal);
    persona.setStdOrHrPeriod(stdOrHrPeriod);
    return persona;
  }
}
