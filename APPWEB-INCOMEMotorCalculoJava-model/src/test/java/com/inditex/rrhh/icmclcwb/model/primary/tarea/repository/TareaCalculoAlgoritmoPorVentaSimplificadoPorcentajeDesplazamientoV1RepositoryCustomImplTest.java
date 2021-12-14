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
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_LOCALIZACION_PERSONA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_LOCALIZACION_PERSONAS_POR_VENTA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;

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
class TareaCalculoAlgoritmoPorVentaSimplificadoPorcentajeDesplazamientoV1RepositoryCustomImplTest {

  private final static String SQL_CALCULAR_BASE = "SQL CALCULAR BASE";

  private final static String SQL_CALCULAR = "SQL CALCULAR";

  @Mock
  private TareaCalculoPersonaService tareaCalculoPerosnaService;

  @Mock
  private TipoDatoService tipoDatoService;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource[]> paramsCaptor;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @InjectMocks
  private TareaCalculoAlgoritmoPorVentaSimplificadoPorcentajeDesplazamientoV1RepositoryCustomImpl tareaCalculoAlgoritmoPorVentaV1RepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaCalculoAlgoritmoPorVentaV1RepositoryCustom, "sqlCalcular", SQL_CALCULAR, true);
    FieldUtils.writeField(this.tareaCalculoAlgoritmoPorVentaV1RepositoryCustom, "sqlCalcularBase",
        SQL_CALCULAR_BASE,
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

    final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoPorVentaV1RepositoryCustom.ids(algoritmo, tarea);

    assertEquals(2, ids.size());
    assertEquals(personas, ids);
  }

  @Test
  public void getMapValuesTest(@Random AlgoritmoDTO algoritmo2) {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(8001);
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
    when(algoritmo.getTipoCalculo()).thenReturn(
        Arrays.asList(
            tipoCalculo1, tipoCalculo2));
    when(algoritmo.getTipoComision()).thenReturn(
        Arrays.asList(tipoComision1, tipoComision2, tipoComision3));
    when(algoritmo.getDesplazamiento()).thenReturn(Boolean.TRUE);
    when(algoritmo.getDesplazamientoBase()).thenReturn(Boolean.FALSE);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(101L);
    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    when(persona1.getIdPersonaLocal()).thenReturn("AT1001");
    when(persona1.getStdOrHrPeriod()).thenReturn("01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaV1RepositoryCustom.getMapValues(algoritmo,
        tarea,
        persona1);

    // Parámetros de la consulta: activo, idTipoGrupoDato, tipoDatoLocalizacionVentaSeccion,
    // idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod,
    // comisionable, calcula, tipocomision, tipocalculo
    assertEquals(15, result.size());
    // activo
    assertTrue(result.containsKey(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ACTIVO));
    // idTipoDatoVentaLocalizacionPersona
    assertTrue(result.containsKey(SQL_PARAM_ID_TIPO_IMPORTE_VENTA_LOCALIZACION_PERSONA));
    assertEquals(TipoDatoEnum.VENTA_INDIVIDUAL_LOCALIZACION_SECCION.getId(),
        result.get(SQL_PARAM_ID_TIPO_IMPORTE_VENTA_LOCALIZACION_PERSONA));
    // tipoDatoLocalizacionVentaSeccion
    assertTrue(result.containsKey(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
    assertEquals(Arrays.asList(1011), result.get(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
    // idTipoDatoVentaLocalizacionPersonasPorVenta
    assertTrue(result.containsKey(SQL_PARAM_ID_TIPO_IMPORTE_VENTA_LOCALIZACION_PERSONAS_POR_VENTA));
    assertEquals(TipoDatoEnum.VENTA_LOCALIZACION_EMPLEADOS_POR_VENTA_SIMPLIFICADO.getId(),
        result.get(SQL_PARAM_ID_TIPO_IMPORTE_VENTA_LOCALIZACION_PERSONAS_POR_VENTA));
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
    // comisionable
    assertTrue(result.containsKey(SQL_PARAM_COMISIONABLE));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_COMISIONABLE));
    // calcula
    assertTrue(result.containsKey(SQL_PARAM_CALCULA));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_CALCULA));
    // tipocomision
    assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_COMISION));
    assertEquals(Arrays.asList("001", "002", "003"), result.get(SQL_PARAM_IDS_TIPOS_COMISION));
    // tipocalculo
    assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(Arrays.asList("011", "012"), result.get(SQL_PARAM_IDS_TIPOS_CALCULO));
    // esDesplazamiento
    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
    // esDesplazamientoBase
    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    // idTipoDatoIndicadorPresenciaDesplazamiento
    assertTrue(result.containsKey(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO));
    assertEquals(TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO.getId(),
        result.get(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO));

    // Para cobertura
    algoritmo2.setDesplazamientoBase(Boolean.TRUE);
    final Map<String, Object> result2 = this.tareaCalculoAlgoritmoPorVentaV1RepositoryCustom
        .getMapValues(algoritmo2, tarea, persona1);

    assertNotNull(result2);
    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result2.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));

  }

  @Test
  public void calcularTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(8001);
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
    when(algoritmo.getTipoCalculo()).thenReturn(
        Arrays.asList(
            tipoCalculo1, tipoCalculo2));
    when(algoritmo.getTipoComision()).thenReturn(
        Arrays.asList(tipoComision1, tipoComision2, tipoComision3));
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

    this.tareaCalculoAlgoritmoPorVentaV1RepositoryCustom.calcular(algoritmo, tarea, personas);

    // Parámetros de la consulta: activo, idTipoGrupoDato, tipoDatoLocalizacionVentaSeccion,
    // idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod,
    // comisionable, calcula, tipocomision, tipocalculo
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_CALCULAR, this.sqlCaptor.getValue());
    final MapSqlParameterSource[] values = this.paramsCaptor.getValue();
    // 2 elementos, porque se envían dos personas
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      assertEquals(15, value.getValues().size());
      // activo
      assertTrue(value.hasValue(SQL_PARAM_ACTIVO));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_ACTIVO));
      // idTipoGrupoDato
      assertTrue(value.hasValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
      assertEquals(Arrays.asList(1011), value.getValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
      // tipoDatoLocalizacionVentaSeccion
      assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_IMPORTE_VENTA_LOCALIZACION_PERSONAS_POR_VENTA));
      assertEquals(TipoDatoEnum.VENTA_LOCALIZACION_EMPLEADOS_POR_VENTA_SIMPLIFICADO.getId(),
          value.getValue(SQL_PARAM_ID_TIPO_IMPORTE_VENTA_LOCALIZACION_PERSONAS_POR_VENTA));
      // idAlgoritmo
      assertTrue(value.hasValue(SQL_PARAM_ID_ALGORITMO));
      assertEquals(algoritmo.getId(), value.getValue(SQL_PARAM_ID_ALGORITMO));
      // idTarea
      assertTrue(value.hasValue(SQL_PARAM_ID_TAREA));
      assertEquals(tarea.getId(), value.getValue(SQL_PARAM_ID_TAREA));
      // comisionable
      assertTrue(value.hasValue(SQL_PARAM_COMISIONABLE));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_COMISIONABLE));
      // calcula
      assertTrue(value.hasValue(SQL_PARAM_CALCULA));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_CALCULA));
      // tipocomision
      assertTrue(value.hasValue(SQL_PARAM_IDS_TIPOS_COMISION));
      assertEquals(Arrays.asList("001", "002", "003"), value.getValue(SQL_PARAM_IDS_TIPOS_COMISION));
      // tipocalculo
      assertTrue(value.hasValue(SQL_PARAM_IDS_TIPOS_CALCULO));
      assertEquals(Arrays.asList("011", "012"), value.getValue(SQL_PARAM_IDS_TIPOS_CALCULO));
      // esDesplazamiento
      assertTrue(value.hasValue(SQL_PARAM_ES_DESPLAZAMIENTO));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_ES_DESPLAZAMIENTO));
      // esDesplazamientoBase
      assertTrue(value.hasValue(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
      assertEquals(SQL_VALUE_BOOLEAN_FALSE, value.getValue(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
      // idTipoDatoIndicadorPresenciaDesplazamiento
      assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO));
      assertEquals(TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO.getId(),
          value.getValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO));
      // cclIdPerson, stdOrHrPeriod - existencia del parámetro
      assertTrue(value.hasValue(SQL_PARAM_CCL_ID_PERSON));
      assertTrue(value.hasValue(SQL_PARAM_STD_OR_HR_PERIOD));
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
    when(algoritmo.getId()).thenReturn(8001);

    final String result = this.tareaCalculoAlgoritmoPorVentaV1RepositoryCustom
        .getSqlCalcular(algoritmo);
    assertEquals(SQL_CALCULAR_BASE, result);

  }

}
