package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_CALCULA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_COMISIONABLE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE_DESPLAZAMIENTO_MISMA_LOCALIZACION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
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
class TareaCalculoAlgoritmoGlobalTiendaPorcentajeDesplazamientoBaseV1RepositoryCustomImplTest {

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
  private TareaCalculoAlgoritmoGlobalTiendaPorcentajeDesplazamientoBaseV1RepositoryCustomImpl tareaCalculoAlgoritmoGlobalTiendaPorcentajeDesplazamientoBaseV1RepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDesplazamientoBaseV1RepositoryCustom,
        "sqlCalcular", SQL_CALCULAR, true);
    FieldUtils.writeField(this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDesplazamientoBaseV1RepositoryCustom,
        "sqlCalcularBase", SQL_BASE, true);
  }

  @Test
  void idsTest(@Random(type = IdPersonaLocalDto.class, size = 2) final List<IdPersonaLocalDto> personas) {

    when(this.tareaCalculoPersonaService.findByAlgoritmo(any(TareaDto.class), any(AlgoritmoDTO.class)))
        .thenReturn(personas);

    final TareaDto tarea = mock(TareaDto.class);
    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);

    final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDesplazamientoBaseV1RepositoryCustom
        .ids(algoritmo, tarea);

    assertEquals(2, ids.size());
    assertEquals(personas, ids);
  }

  @Test
  void getMapValuesTest(@Random final AlgoritmoDTO algoritmo, @Random final TareaDto tarea,
      @Random(type = IdTipoDatoDto.class, size = 2) final List<IdTipoDatoDto> tiposDatoPersonaPresencia,
      @Random(type = IdTipoDatoDto.class, size = 3) final List<IdTipoDatoDto> tiposDatoVenta,
      @Random final IdPersonaLocalDto persona) {

    // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    final Map<String, Object> expected = new HashMap<>();
    expected.put(SQL_PARAM_ACTIVO, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION,
        tiposDatoVenta.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    expected.put(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA,
        Collections.singletonList(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId()));
    expected.put(SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
    expected.put(SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
    expected.put(SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
    expected.put(SQL_PARAM_COMISIONABLE, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_CALCULA, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_EXCLUIDO_CALCULO, SQL_VALUE_BOOLEAN_FALSE);
    expected.put(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE_DESPLAZAMIENTO_MISMA_LOCALIZACION,
        TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE_DESPLAZAMIENTO_MISMA_LOCALIZACION
            .getId());
    expected.put(SQL_PARAM_IDS_TIPOS_COMISION,
        algoritmo.getTipoComision().stream().map(TipoComisionDTO::getId).collect(Collectors.toList()));
    expected.put(SQL_PARAM_IDS_TIPOS_CALCULO, algoritmo.getTipoCalculo().stream().map(TipoCalculoDTO::getId).collect(Collectors.toList()));
    expected.put(SQL_PARAM_ES_DESPLAZAMIENTO, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_ES_DESPLAZAMIENTO_BASE, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    expected.put(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA,
        tiposDatoPersonaPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));

    algoritmo.setDesplazamiento(true);
    algoritmo.setDesplazamientoBase(true);

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(tiposDatoVenta);
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
        .thenReturn(tiposDatoPersonaPresencia);

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDesplazamientoBaseV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona);

    verify(this.tipoDatoService, times(1)).findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.tipoDatoService, times(1))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());

    assertEquals(expected, result);

  }

  @Test
  void calcularTest(@Random final AlgoritmoDTO algoritmo, @Random final TareaDto tarea,
      @Random(type = IdTipoDatoDto.class, size = 2) final List<IdTipoDatoDto> tiposDatoPersonaPresencia,
      @Random(type = IdTipoDatoDto.class, size = 3) final List<IdTipoDatoDto> tiposDatoVenta,
      @Random(type = IdPersonaLocalDto.class, size = 2) final List<IdPersonaLocalDto> personas) {

    algoritmo.setDesplazamiento(true);
    algoritmo.setDesplazamientoBase(true);
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(tiposDatoVenta);
    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
        .thenReturn(tiposDatoPersonaPresencia);

    // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    final List<Map<String, Object>> expected = new ArrayList<>();
    for (final IdPersonaLocalDto persona : personas) {
      final Map<String, Object> map = new HashMap<>();
      map.put(SQL_PARAM_ACTIVO, SQL_VALUE_BOOLEAN_TRUE);
      map.put(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION,
          tiposDatoVenta.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
      map.put(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA,
          Collections.singletonList(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId()));
      map.put(SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
      map.put(SQL_PARAM_ID_TAREA, tarea.getId());
      map.put(SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
      map.put(SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
      map.put(SQL_PARAM_COMISIONABLE, SQL_VALUE_BOOLEAN_TRUE);
      map.put(SQL_PARAM_CALCULA, SQL_VALUE_BOOLEAN_TRUE);
      map.put(SQL_PARAM_EXCLUIDO_CALCULO, SQL_VALUE_BOOLEAN_FALSE);
      map.put(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE_DESPLAZAMIENTO_MISMA_LOCALIZACION,
          TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE_DESPLAZAMIENTO_MISMA_LOCALIZACION
              .getId());
      map.put(SQL_PARAM_IDS_TIPOS_COMISION, algoritmo.getTipoComision().stream().map(TipoComisionDTO::getId).collect(Collectors.toList()));
      map.put(SQL_PARAM_IDS_TIPOS_CALCULO, algoritmo.getTipoCalculo().stream().map(TipoCalculoDTO::getId).collect(Collectors.toList()));
      map.put(SQL_PARAM_ES_DESPLAZAMIENTO, SQL_VALUE_BOOLEAN_TRUE);
      map.put(SQL_PARAM_ES_DESPLAZAMIENTO_BASE, SQL_VALUE_BOOLEAN_TRUE);
      map.put(SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
      map.put(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA,
          tiposDatoPersonaPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
      expected.add(map);
    }

    this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDesplazamientoBaseV1RepositoryCustom.calcular(algoritmo, tarea,
        personas);

    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final List<Map<String, Object>> values =
        Arrays.stream(this.params.getValue()).map(MapSqlParameterSource::getValues).collect(Collectors.toList());
    assertEquals(expected, values);

  }

  @Test
  void getSqlCalcularTest() {

    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(21);

    final String result = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDesplazamientoBaseV1RepositoryCustom
        .getSqlCalcular(algoritmo);
    assertEquals(SQL_BASE, result);

  }

}
