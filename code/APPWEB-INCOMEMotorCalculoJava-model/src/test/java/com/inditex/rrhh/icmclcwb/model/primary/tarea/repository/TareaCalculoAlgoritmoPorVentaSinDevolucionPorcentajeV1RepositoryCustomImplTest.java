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
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_VENTA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_LOCALIZACION_PERSONA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_LOCALIZACION_PERSONAS_POR_VENTA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeV1RepositoryCustomImplTest {

  private final static String SQL_BASE = "SQL CALCULAR BASE";

  private final static String SQL_CALCULAR = "SQL CALCULAR";

  @Mock
  private TareaCalculoPersonaService tareaCalculoPerosnaService;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Mock
  private TipoDatoService tipoDatoService;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource[]> paramsCaptor;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @InjectMocks
  private TareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeV1RepositoryCustomImpl tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeV1RepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeV1RepositoryCustom,
        "sqlCalcular",
        SQL_CALCULAR, true);
    FieldUtils.writeField(this.tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeV1RepositoryCustom,
        "sqlCalcularBase",
        SQL_BASE, true);
  }

  @Test
  void idsTest() {

    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    final IdPersonaLocalDto persona2 = mock(IdPersonaLocalDto.class);
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);
    when(this.tareaCalculoPerosnaService.findByAlgoritmo(any(TareaDto.class), any(AlgoritmoDTO.class)))
        .thenReturn(personas);

    final TareaDto tarea = mock(TareaDto.class);
    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);

    final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeV1RepositoryCustom
        .ids(algoritmo, tarea);

    assertEquals(2, ids.size());
    assertEquals(personas, ids);
  }

  @ParameterizedTest
  @InstancioSource
  void getMapValuesTest(final AlgoritmoDTO algoritmo, final AlgoritmoDTO algoritmo2, final TareaDto tarea,
      final IdPersonaLocalDto persona) {

    final List<IdTipoDatoDto> tiposDato = Instancio.ofList(IdTipoDatoDto.class).size(3).create();

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class))).thenReturn(tiposDato);

    algoritmo.setDesplazamiento(Boolean.TRUE);
    algoritmo.setDesplazamientoBase(Boolean.FALSE);

    final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona);

    verify(this.tipoDatoService, times(1))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());

    // Parámetros de la consulta: idAlgoritmo, activo, idTipoDatoIndicadorPresencia,
    // tipoDatoLocalizacionPersonaPresencia, idTipoDatoVentaLocalizacionPersona,
    // idTipoDatoVentaSinDevolucionLocalizacionSeccion, idTipoDatoVentaLocalizacionPersonasPorVenta,
    // idTipoDatoImporteComisionVenta,
    // idTipoPresenciaLocalizacion, idTarea, cclIdPerson, stdOrHrPeriod, tiposCalculo, tiposComision,
    // esDesplazamiento,
    // esDesplazamientoBase, comisionable, calcula
    final Map<String, Object> expected = new HashMap<>();
    expected.put(SQL_PARAM_ACTIVO, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA, TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId());
    expected.put(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA,
        tiposDato.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    expected.put(SQL_PARAM_ID_TIPO_IMPORTE_VENTA_LOCALIZACION_PERSONA,
        TipoDatoEnum.VENTA_SIN_DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId());
    expected.put(SQL_PARAM_ID_TIPO_DATO_VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION,
        TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION.getId());
    expected.put(SQL_PARAM_ID_TIPO_IMPORTE_VENTA_LOCALIZACION_PERSONAS_POR_VENTA,
        TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_EMPLEADOS_POR_VENTA.getId());
    expected.put(SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_VENTA, TipoDatoEnum.IMPORTE_COMISION_VENTA_LOCALIZACION_POR_VENTA.getId());
    expected.put(SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION,
        Collections.singletonList(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId()));
    expected.put(SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
    expected.put(SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
    expected.put(SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
    expected.put(SQL_PARAM_COMISIONABLE, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_CALCULA, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_IDS_TIPOS_COMISION,
        algoritmo.getTipoComision().stream().map(TipoComisionDTO::getId).collect(Collectors.toList()));
    expected.put(SQL_PARAM_IDS_TIPOS_CALCULO, algoritmo.getTipoCalculo().stream().map(TipoCalculoDTO::getId).collect(Collectors.toList()));
    expected.put(SQL_PARAM_ES_DESPLAZAMIENTO, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_ES_DESPLAZAMIENTO_BASE, SQL_VALUE_BOOLEAN_FALSE);

    assertEquals(expected, result);

    // Para cobertura
    algoritmo2.setDesplazamientoBase(Boolean.TRUE);
    final Map<String, Object> result2 = this.tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeV1RepositoryCustom
        .getMapValues(algoritmo2, tarea, persona);

    assertNotNull(result2);
    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result2.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));

  }

  @ParameterizedTest
  @InstancioSource
  void calcularTest(final AlgoritmoDTO algoritmo, final TareaDto tarea) {

    final List<IdTipoDatoDto> tiposDato = Instancio.ofList(IdTipoDatoDto.class).size(3).create();
    final List<IdPersonaLocalDto> personas = Instancio.ofList(IdPersonaLocalDto.class).size(2).create();

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class))).thenReturn(tiposDato);

    algoritmo.setDesplazamiento(Boolean.TRUE);
    algoritmo.setDesplazamientoBase(Boolean.FALSE);

    this.tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeV1RepositoryCustom.calcular(algoritmo, tarea,
        personas);

    // Parámetros de la consulta: idAlgoritmo, activo, idTipoDatoIndicadorPresencia,
    // idTipoDatoVentaLocalizacionPersona, tipoDatoLocalizacionPersonaPresencia
    // idTipoDatoVentaSinDevolucionLocalizacionSeccion, idTipoDatoVentaLocalizacionPersonasPorVenta,
    // idTipoDatoImporteComisionVenta,
    // idSeccion, tiposDatoPersonaPresencia, idTarea, cclIdPerson, stdOrHrPeriod, tiposCalculo,
    // tiposComision, esDesplazamiento,
    // esDesplazamientoBase, comisionable, calcula
    verify(this.namedParameterJdbcTemplate).batchUpdate(eq(SQL_CALCULAR), this.paramsCaptor.capture());
    // una vez por cada persona
    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());

    final List<Map<String, Object>> params =
        Arrays.stream(this.paramsCaptor.getValue()).map(MapSqlParameterSource::getValues).collect(Collectors.toList());

    final List<Map<String, Object>> expected = new ArrayList<>();
    for (final IdPersonaLocalDto persona : personas) {
      final Map<String, Object> map = new HashMap<>();
      map.put(SQL_PARAM_ACTIVO, SQL_VALUE_BOOLEAN_TRUE);
      map.put(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA, TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId());
      map.put(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA,
          tiposDato.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
      map.put(SQL_PARAM_ID_TIPO_IMPORTE_VENTA_LOCALIZACION_PERSONA,
          TipoDatoEnum.VENTA_SIN_DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId());
      map.put(SQL_PARAM_ID_TIPO_DATO_VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION,
          TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION.getId());
      map.put(SQL_PARAM_ID_TIPO_IMPORTE_VENTA_LOCALIZACION_PERSONAS_POR_VENTA,
          TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_EMPLEADOS_POR_VENTA.getId());
      map.put(SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_VENTA, TipoDatoEnum.IMPORTE_COMISION_VENTA_LOCALIZACION_POR_VENTA.getId());
      map.put(SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION,
          Collections.singletonList(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId()));
      map.put(SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
      map.put(SQL_PARAM_ID_TAREA, tarea.getId());
      map.put(SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
      map.put(SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
      map.put(SQL_PARAM_COMISIONABLE, SQL_VALUE_BOOLEAN_TRUE);
      map.put(SQL_PARAM_CALCULA, SQL_VALUE_BOOLEAN_TRUE);
      map.put(SQL_PARAM_IDS_TIPOS_COMISION, algoritmo.getTipoComision().stream().map(TipoComisionDTO::getId).collect(Collectors.toList()));
      map.put(SQL_PARAM_IDS_TIPOS_CALCULO, algoritmo.getTipoCalculo().stream().map(TipoCalculoDTO::getId).collect(Collectors.toList()));
      map.put(SQL_PARAM_ES_DESPLAZAMIENTO, SQL_VALUE_BOOLEAN_TRUE);
      map.put(SQL_PARAM_ES_DESPLAZAMIENTO_BASE, SQL_VALUE_BOOLEAN_FALSE);
      expected.add(map);
    }

    assertEquals(expected, params);

  }

  @Test
  void getSqlCalcularTest() {

    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(21);

    final String result = this.tareaCalculoAlgoritmoPorVentaSinDevolucionPorcentajeV1RepositoryCustom
        .getSqlCalcular(algoritmo);
    assertEquals(SQL_BASE, result);

  }

}
