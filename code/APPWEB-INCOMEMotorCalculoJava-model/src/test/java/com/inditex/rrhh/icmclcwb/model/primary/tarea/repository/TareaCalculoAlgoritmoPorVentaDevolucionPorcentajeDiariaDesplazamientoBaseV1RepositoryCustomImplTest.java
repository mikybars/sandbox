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
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_DEVOLUCION_LOCALIZACION_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_DEVOLUCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_REPARTO_VENDEDOR_0;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_DEVOLUCION_LOCALIZACION_PERSONA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
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
class TareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImplTest {

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

  @InjectMocks
  private TareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(
        this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom,
        "sqlCalcular", SQL_CALCULAR, true);
    FieldUtils.writeField(
        this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom,
        "sqlCalcularBase", SQL_BASE, true);
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

    final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .ids(algoritmo, tarea);

    assertEquals(2, ids.size());
    assertEquals(personas, ids);
  }

  @Test
  void getMapValuesTest(@Random final AlgoritmoDTO algoritmo, @Random final AlgoritmoDTO algoritmo2, @Random final TareaDto tarea,
      @Random(type = IdTipoDatoDto.class, size = 3) final List<IdTipoDatoDto> tiposDato, @Random final IdPersonaLocalDto persona) {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class))).thenReturn(tiposDato);

    algoritmo.setDesplazamiento(Boolean.TRUE);
    algoritmo.setDesplazamientoBase(Boolean.FALSE);

    final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona);

    verify(this.tipoDatoService, times(1))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());

    // Parámetros de la consulta: idAlgoritmo, activo, idTipoDatoIndicadorPresencia,
    // idTipoDatoDevolucionLocalizacionPersona,
    // idTipoDatoDevolucionLocalizacion, fechaInicioPeriodo, idTipoDatoImporteComisionDevolucion,
    // cclIdPersonVendedor0,
    // idTipoPresencia, idTarea, cclIdPerson, stdOrHrPeriod, tiposCalculo, tiposComision,
    // esDesplazamiento,
    // esDesplazamientoBase, comisionable, calcula, idTipoDatoIndicadorPresenciaDesplazamientoBase
    final Map<String, Object> expected = new HashMap<>();
    expected.put(SQL_PARAM_ACTIVO, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA, TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId());
    expected.put(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA,
        tiposDato.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    expected.put(SQL_PARAM_ID_TIPO_IMPORTE_DEVOLUCION_LOCALIZACION_PERSONA,
        TipoDatoEnum.DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId());
    expected.put(SQL_PARAM_ID_TIPO_DATO_DEVOLUCION_LOCALIZACION_SECCION, TipoDatoEnum.DEVOLUCION_LOCALIZACION.getId());
    expected.put(SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_DEVOLUCION,
        TipoDatoEnum.IMPORTE_COMISION_DEVOLUCIONES_LOCALIZACION_POR_VENTA.getId());
    expected.put(SQL_PARAM_ID_TIPO_DATO_REPARTO_VENDEDOR_0, TipoDatoEnum.REPARTO_DEVOLUCION_VENDEDOR_0_LOCALIZACION_SECCION.getId());
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
    expected.put(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE,
        TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE.getId());

    assertEquals(expected, result);
  }

  @Test
  void calcularTest(@Random final AlgoritmoDTO algoritmo, @Random final TareaDto tarea,
      @Random(type = IdTipoDatoDto.class, size = 3) final List<IdTipoDatoDto> tiposDato,
      @Random(type = IdPersonaLocalDto.class, size = 2) final List<IdPersonaLocalDto> personas) {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class))).thenReturn(tiposDato);

    algoritmo.setDesplazamiento(Boolean.TRUE);
    algoritmo.setDesplazamientoBase(Boolean.FALSE);

    this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.calcular(
        algoritmo,
        tarea, personas);

    // Parámetros de la consulta: idAlgoritmo, activo, idTipoDatoIndicadorPresencia,
    // idTipoDatoDevolucionLocalizacionPersona,
    // idTipoDatoDevolucionLocalizacion, fechaInicioPeriodo, idTipoDatoImporteComisionDevolucion,
    // cclIdPersonVendedor0,
    // idTipoPresencia, idTarea, cclIdPerson, stdOrHrPeriod, tiposCalculo, tiposComision,
    // esDesplazamiento,
    // esDesplazamientoBase, comisionable, calcula, idTipoDatoIndicadorPresenciaDesplazamientoBase
    verify(this.namedParameterJdbcTemplate).batchUpdate(eq(SQL_CALCULAR), this.paramsCaptor.capture());

    final List<Map<String, Object>> params =
        Arrays.stream(this.paramsCaptor.getValue()).map(MapSqlParameterSource::getValues).collect(Collectors.toList());

    final List<Map<String, Object>> expected = new ArrayList<>();
    for (final IdPersonaLocalDto persona : personas) {
      final Map<String, Object> map = new HashMap<>();
      map.put(SQL_PARAM_ACTIVO, SQL_VALUE_BOOLEAN_TRUE);
      map.put(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA, TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId());
      map.put(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA,
          tiposDato.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
      map.put(SQL_PARAM_ID_TIPO_IMPORTE_DEVOLUCION_LOCALIZACION_PERSONA, TipoDatoEnum.DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId());
      map.put(SQL_PARAM_ID_TIPO_DATO_DEVOLUCION_LOCALIZACION_SECCION, TipoDatoEnum.DEVOLUCION_LOCALIZACION.getId());
      map.put(SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_DEVOLUCION,
          TipoDatoEnum.IMPORTE_COMISION_DEVOLUCIONES_LOCALIZACION_POR_VENTA.getId());
      map.put(SQL_PARAM_ID_TIPO_DATO_REPARTO_VENDEDOR_0, TipoDatoEnum.REPARTO_DEVOLUCION_VENDEDOR_0_LOCALIZACION_SECCION.getId());
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
      map.put(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE,
          TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE.getId());
      expected.add(map);
    }

    assertEquals(expected, params);
  }

  @Test
  void getSqlCalcularTest() {

    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(21);

    final String result = this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getSqlCalcular(algoritmo);
    assertEquals(SQL_BASE, result);

  }

}
