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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
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
  private TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RepositoryCustomImpl repository;

  @BeforeEach
  void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.repository, "sqlCalcular", SQL_CALCULAR, true);
    FieldUtils.writeField(this.repository, "sqlCalcularBase", SQL_BASE, true);
  }

  @Test
  void idsTest() {
    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    final IdPersonaLocalDto persona2 = mock(IdPersonaLocalDto.class);
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);
    when(this.tareaCalculoPersonaService.findByAlgoritmo(any(TareaDto.class), any(AlgoritmoDTO.class)))
        .thenReturn(personas);

    final TareaDto tarea = mock(TareaDto.class);
    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);

    final List<IdPersonaLocalDto> ids = this.repository.ids(algoritmo, tarea);

    assertEquals(2, ids.size());
    assertEquals(personas, ids);
    verify(this.tareaCalculoPersonaService, times(1)).findByAlgoritmo(tarea, algoritmo);
  }

  @Test
  void getMapValuesTest() {
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class)))
        .thenReturn(List.of(new IdTipoDatoDto(101)));

    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(1001);
    final TipoCalculoDTO tipoCalculo1 = new TipoCalculoDTO();
    final TipoCalculoDTO tipoCalculo2 = new TipoCalculoDTO();
    tipoCalculo1.setId("011");
    tipoCalculo2.setId("012");
    final TipoComisionDTO tipoComision1 = new TipoComisionDTO();
    final TipoComisionDTO tipoComision2 = new TipoComisionDTO();
    final TipoComisionDTO tipoComision3 = new TipoComisionDTO();
    tipoComision1.setId("001");
    tipoComision2.setId("002");
    tipoComision3.setId("003");
    when(algoritmo.getTipoCalculo()).thenReturn(Arrays.asList(tipoCalculo1, tipoCalculo2));
    when(algoritmo.getTipoComision()).thenReturn(Arrays.asList(tipoComision1, tipoComision2, tipoComision3));
    when(algoritmo.getDesplazamiento()).thenReturn(Boolean.TRUE);
    when(algoritmo.getDesplazamientoBase()).thenReturn(Boolean.FALSE);

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(101L);
    final IdPersonaLocalDto persona = mock(IdPersonaLocalDto.class);
    when(persona.getIdPersonaLocal()).thenReturn("AT1001");
    when(persona.getStdOrHrPeriod()).thenReturn("01");

    final Map<String, Object> result = this.repository.getMapValues(algoritmo, tarea, persona);

    verify(this.tipoDatoService, times(1))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    assertEquals(13, result.size());

    // Verificar parámetros básicos
    assertTrue(result.containsKey(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), result.get(SQL_PARAM_ID_TAREA));

    assertTrue(result.containsKey(SQL_PARAM_CCL_ID_PERSON));
    assertEquals(persona.getIdPersonaLocal(), result.get(SQL_PARAM_CCL_ID_PERSON));

    assertTrue(result.containsKey(SQL_PARAM_STD_OR_HR_PERIOD));
    assertEquals(persona.getStdOrHrPeriod(), result.get(SQL_PARAM_STD_OR_HR_PERIOD));

    assertTrue(result.containsKey(SQL_PARAM_ID_ALGORITMO));
    assertEquals(algoritmo.getId(), result.get(SQL_PARAM_ID_ALGORITMO));

    // Verificar parámetros de tipos de dato
    assertTrue(result.containsKey(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
    assertEquals(List.of(101), result.get(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));

    // Verificar parámetros boolean
    assertTrue(result.containsKey(SQL_PARAM_COMISIONABLE));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_COMISIONABLE));

    assertTrue(result.containsKey(SQL_PARAM_CALCULA));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_CALCULA));

    assertTrue(result.containsKey(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ACTIVO));

    // Verificar indicador de desplazamiento base
    assertTrue(result.containsKey(SQL_PARAM_ID_TIPO_DATO_INDICADOR_DESPLAZAMIENTO_BASE));
    assertEquals(TipoDatoEnum.INDICADOR_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE.getId(),
        result.get(SQL_PARAM_ID_TIPO_DATO_INDICADOR_DESPLAZAMIENTO_BASE));

    // Verificar tipos de comisión y cálculo
    assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_COMISION));
    assertEquals(Arrays.asList("001", "002", "003"), result.get(SQL_PARAM_IDS_TIPOS_COMISION));

    assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(Arrays.asList("011", "012"), result.get(SQL_PARAM_IDS_TIPOS_CALCULO));

    // Verificar desplazamiento
    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));

    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
  }

  @Test
  void getMapValuesWithNullTareaTest() {
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class)))
        .thenReturn(List.of(new IdTipoDatoDto(101)));

    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(1001);
    when(algoritmo.getTipoCalculo()).thenReturn(List.of());
    when(algoritmo.getTipoComision()).thenReturn(List.of());
    when(algoritmo.getDesplazamiento()).thenReturn(Boolean.FALSE);
    when(algoritmo.getDesplazamientoBase()).thenReturn(Boolean.TRUE);

    final IdPersonaLocalDto persona = mock(IdPersonaLocalDto.class);
    when(persona.getIdPersonaLocal()).thenReturn("AT1002");
    when(persona.getStdOrHrPeriod()).thenReturn("02");

    final Map<String, Object> result = this.repository.getMapValues(algoritmo, null, persona);

    assertEquals(12, result.size()); // Sin tarea, un parámetro menos
    assertTrue(result.containsKey(SQL_PARAM_ID_ALGORITMO));
    assertEquals(algoritmo.getId(), result.get(SQL_PARAM_ID_ALGORITMO));
    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
  }

  @Test
  void getMapValuesWithNullPersonaTest() {
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class)))
        .thenReturn(List.of(new IdTipoDatoDto(101)));

    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(1001);
    when(algoritmo.getTipoCalculo()).thenReturn(List.of());
    when(algoritmo.getTipoComision()).thenReturn(List.of());
    when(algoritmo.getDesplazamiento()).thenReturn(Boolean.FALSE);
    when(algoritmo.getDesplazamientoBase()).thenReturn(Boolean.FALSE);

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(101L);

    final Map<String, Object> result = this.repository.getMapValues(algoritmo, tarea, null);

    assertEquals(11, result.size()); // Sin persona, dos parámetros menos
    assertTrue(result.containsKey(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), result.get(SQL_PARAM_ID_TAREA));
    assertTrue(result.containsKey(SQL_PARAM_ID_ALGORITMO));
    assertEquals(algoritmo.getId(), result.get(SQL_PARAM_ID_ALGORITMO));
    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
  }

  @Test
  void getMapValuesWithInstancioTest() {
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class)))
        .thenReturn(List.of(new IdTipoDatoDto(101)));

    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    final TareaDto tarea = Instancio.create(TareaDto.class);
    final IdPersonaLocalDto persona = Instancio.create(IdPersonaLocalDto.class);

    algoritmo.setDesplazamiento(true);
    algoritmo.setDesplazamientoBase(false);

    final Map<String, Object> result = this.repository.getMapValues(algoritmo, tarea, persona);

    assertNotNull(result);
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    assertEquals(algoritmo.getId(), result.get(SQL_PARAM_ID_ALGORITMO));
    assertEquals(tarea.getId(), result.get(SQL_PARAM_ID_TAREA));
    assertEquals(persona.getIdPersonaLocal(), result.get(SQL_PARAM_CCL_ID_PERSON));
    assertEquals(persona.getStdOrHrPeriod(), result.get(SQL_PARAM_STD_OR_HR_PERIOD));
  }

  @Test
  void calcularTest() {
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class)))
        .thenReturn(List.of(new IdTipoDatoDto(101)));

    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(1001);
    final TipoCalculoDTO tipoCalculo1 = new TipoCalculoDTO();
    final TipoCalculoDTO tipoCalculo2 = new TipoCalculoDTO();
    tipoCalculo1.setId("011");
    tipoCalculo2.setId("012");
    final TipoComisionDTO tipoComision1 = new TipoComisionDTO();
    final TipoComisionDTO tipoComision2 = new TipoComisionDTO();
    final TipoComisionDTO tipoComision3 = new TipoComisionDTO();
    tipoComision1.setId("001");
    tipoComision2.setId("002");
    tipoComision3.setId("003");
    when(algoritmo.getTipoCalculo()).thenReturn(Arrays.asList(tipoCalculo1, tipoCalculo2));
    when(algoritmo.getTipoComision()).thenReturn(Arrays.asList(tipoComision1, tipoComision2, tipoComision3));
    when(algoritmo.getDesplazamiento()).thenReturn(Boolean.TRUE);
    when(algoritmo.getDesplazamientoBase()).thenReturn(Boolean.FALSE);

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(101L);
    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    when(persona1.getIdPersonaLocal()).thenReturn("AT1001");
    when(persona1.getStdOrHrPeriod()).thenReturn("01");
    final IdPersonaLocalDto persona2 = mock(IdPersonaLocalDto.class);
    when(persona2.getIdPersonaLocal()).thenReturn("AT1002");
    when(persona2.getStdOrHrPeriod()).thenReturn("02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

    this.repository.calcular(algoritmo, tarea, personas);

    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);

    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      assertEquals(13, value.getValues().size());

      // Verificar parámetros comunes
      assertTrue(value.hasValue(SQL_PARAM_ACTIVO));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_ACTIVO));

      assertTrue(value.hasValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
      assertEquals(List.of(101), value.getValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));

      assertTrue(value.hasValue(SQL_PARAM_ID_ALGORITMO));
      assertEquals(algoritmo.getId(), value.getValue(SQL_PARAM_ID_ALGORITMO));

      assertTrue(value.hasValue(SQL_PARAM_ID_TAREA));
      assertEquals(tarea.getId(), value.getValue(SQL_PARAM_ID_TAREA));

      assertTrue(value.hasValue(SQL_PARAM_COMISIONABLE));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_COMISIONABLE));

      assertTrue(value.hasValue(SQL_PARAM_CALCULA));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_CALCULA));

      assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_DESPLAZAMIENTO_BASE));
      assertEquals(TipoDatoEnum.INDICADOR_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE.getId(),
          value.getValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_DESPLAZAMIENTO_BASE));

      assertTrue(value.hasValue(SQL_PARAM_IDS_TIPOS_COMISION));
      assertEquals(Arrays.asList("001", "002", "003"), value.getValue(SQL_PARAM_IDS_TIPOS_COMISION));

      assertTrue(value.hasValue(SQL_PARAM_IDS_TIPOS_CALCULO));
      assertEquals(Arrays.asList("011", "012"), value.getValue(SQL_PARAM_IDS_TIPOS_CALCULO));

      assertTrue(value.hasValue(SQL_PARAM_ES_DESPLAZAMIENTO));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_ES_DESPLAZAMIENTO));

      assertTrue(value.hasValue(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
      assertEquals(SQL_VALUE_BOOLEAN_FALSE, value.getValue(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));

      // Verificar parámetros específicos de persona
      assertTrue(value.hasValue(SQL_PARAM_CCL_ID_PERSON));
      assertTrue(value.hasValue(SQL_PARAM_STD_OR_HR_PERIOD));
    }

    // Verificar valores específicos de cada persona
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
  void getSqlCalcularTest() {
    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(21);

    final String result = this.repository.getSqlCalcular(algoritmo);

    assertEquals(SQL_BASE, result);
  }

  @Test
  void calcularWithInstancioTest() {
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class)))
        .thenReturn(List.of(new IdTipoDatoDto(101)));

    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    final TareaDto tarea = Instancio.create(TareaDto.class);
    final List<IdPersonaLocalDto> personas = Arrays.asList(
        Instancio.create(IdPersonaLocalDto.class),
        Instancio.create(IdPersonaLocalDto.class));

    this.repository.calcular(algoritmo, tarea, personas);

    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);
    assertNotNull(values[0]);
    assertNotNull(values[1]);
  }

  @Test
  void getMapValuesWithBothDesplazamientoTrueTest() {
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class)))
        .thenReturn(List.of(new IdTipoDatoDto(101)));

    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    final TareaDto tarea = Instancio.create(TareaDto.class);
    final IdPersonaLocalDto persona = Instancio.create(IdPersonaLocalDto.class);

    algoritmo.setDesplazamiento(true);
    algoritmo.setDesplazamientoBase(true);

    final Map<String, Object> result = this.repository.getMapValues(algoritmo, tarea, persona);

    assertNotNull(result);
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
  }

  @Test
  void getMapValuesWithBothDesplazamientoFalseTest() {
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class)))
        .thenReturn(List.of(new IdTipoDatoDto(101)));

    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    final TareaDto tarea = Instancio.create(TareaDto.class);
    final IdPersonaLocalDto persona = Instancio.create(IdPersonaLocalDto.class);

    algoritmo.setDesplazamiento(false);
    algoritmo.setDesplazamientoBase(false);

    final Map<String, Object> result = this.repository.getMapValues(algoritmo, tarea, persona);

    assertNotNull(result);
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
  }

  @Test
  void getMapValuesWithEmptyListsTest() {
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class)))
        .thenReturn(List.of());

    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(1001);
    when(algoritmo.getTipoCalculo()).thenReturn(List.of());
    when(algoritmo.getTipoComision()).thenReturn(List.of());
    when(algoritmo.getDesplazamiento()).thenReturn(Boolean.FALSE);
    when(algoritmo.getDesplazamientoBase()).thenReturn(Boolean.FALSE);

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(101L);
    final IdPersonaLocalDto persona = mock(IdPersonaLocalDto.class);
    when(persona.getIdPersonaLocal()).thenReturn("AT1001");
    when(persona.getStdOrHrPeriod()).thenReturn("01");

    final Map<String, Object> result = this.repository.getMapValues(algoritmo, tarea, persona);

    assertTrue(result.containsKey(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
    assertEquals(List.of(), result.get(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
    assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_COMISION));
    assertEquals(List.of(), result.get(SQL_PARAM_IDS_TIPOS_COMISION));
    assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(List.of(), result.get(SQL_PARAM_IDS_TIPOS_CALCULO));
  }

  @Test
  void addSpecificMapValuesDesplazamientoBaseTest() {
    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    final TareaDto tarea = Instancio.create(TareaDto.class);
    final IdPersonaLocalDto persona = Instancio.create(IdPersonaLocalDto.class);
    final Map<String, Object> map = new HashMap<>();

    this.repository.addSpecificMapValues(map, algoritmo, tarea, persona);

    assertNotNull(map);
    assertEquals(1, map.size()); // Only the specific parameter should be added

    // Verify the specific parameter for DesplazamientoBase (not Desplazamiento)
    assertEquals(TipoDatoEnum.INDICADOR_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE.getId(),
        map.get(SQL_PARAM_ID_TIPO_DATO_INDICADOR_DESPLAZAMIENTO_BASE));
  }
}
