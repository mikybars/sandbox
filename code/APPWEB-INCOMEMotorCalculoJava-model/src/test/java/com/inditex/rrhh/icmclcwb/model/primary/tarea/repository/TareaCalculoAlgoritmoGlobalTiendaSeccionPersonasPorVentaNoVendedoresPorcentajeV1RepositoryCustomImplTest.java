package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_CALCULA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_COMISIONABLE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.dto.TipoCalculoDTO;
import com.inditex.rrhh.icmclcwb.dto.TipoComisionDTO;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.instancio.Instancio;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TareaCalculoAlgoritmoGlobalTiendaSeccionPersonasPorVentaNoVendedoresPorcentajeV1RepositoryCustomImplTest {

  private final static String SQL_BASE = "SQL CALCULAR BASE";

  private final static String SQL_CALCULAR = "SQL CALCULAR";

  @Mock
  private TipoDatoService tipoDatoService;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private TareaCalculoAlgoritmoGlobalTiendaSeccionPersonasPorVentaNoVendedoresPorcentajeV1RepositoryCustomImpl tareaCalculoAlgoritmoGlobalTiendaSeccionPersonasPorVentaNoVendedoresPorcentajeV1RepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaCalculoAlgoritmoGlobalTiendaSeccionPersonasPorVentaNoVendedoresPorcentajeV1RepositoryCustom,
        "sqlCalcular",
        SQL_CALCULAR, true);
    FieldUtils.writeField(this.tareaCalculoAlgoritmoGlobalTiendaSeccionPersonasPorVentaNoVendedoresPorcentajeV1RepositoryCustom,
        "sqlCalcularBase",
        SQL_BASE, true);
  }

  @ParameterizedTest
  @InstancioSource
  void getMapValuesTest(final List<IdTipoDatoDto> tiposDatoVenta,
      final AlgoritmoDTO algoritmo, final TareaDto tarea,
      final IdPersonaLocalDto persona) {

    final List<IdTipoDatoDto> tiposDato = Instancio.ofList(IdTipoDatoDto.class).size(3).create();
    algoritmo.setDesplazamiento(true);
    algoritmo.setDesplazamientoBase(false);

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(tiposDatoVenta);
    when(this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
            .thenReturn(tiposDato);

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaSeccionPersonasPorVentaNoVendedoresPorcentajeV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona);

    verify(this.tipoDatoService, times(1))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    verify(this.tipoDatoService, times(1)).findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());

    // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    // tipoDatoLocalizacionPersonaPresencia, idTipoDatoIndicadorPresencia
    final Map<String, Object> expected = new HashMap<>();
    expected.put(SQL_PARAM_ACTIVO, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION,
        tiposDatoVenta.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    expected.put(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA,
        Collections.singletonList(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId()));
    expected.put(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPO_HORA_DESPLAZAMIENTO.getId());
    expected.put(SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
    expected.put(SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SQL_PARAM_COMISIONABLE, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_CALCULA, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_EXCLUIDO_CALCULO, SQL_VALUE_BOOLEAN_FALSE);
    expected.put(SQL_PARAM_IDS_TIPOS_COMISION,
        algoritmo.getTipoComision().stream().map(TipoComisionDTO::getId).collect(Collectors.toList()));
    expected.put(SQL_PARAM_IDS_TIPOS_CALCULO,
        algoritmo.getTipoCalculo().stream().map(TipoCalculoDTO::getId).collect(Collectors.toList()));
    expected.put(SQL_PARAM_ES_DESPLAZAMIENTO, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_ES_DESPLAZAMIENTO_BASE, SQL_VALUE_BOOLEAN_FALSE);
    expected.put(SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
    expected.put(SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
    expected.put(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA, TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId());
    expected.put(SQL_PARAM_ID_TIPO_CALCULO, TipoCalculoEnum.GLOBAL_SECCION.getId());
    expected.put(SQL_PARAM_FECHA_INICIO_PERIODO, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));

    assertEquals(expected, result);
  }

  @ParameterizedTest
  @InstancioSource
  void calcularTest(final List<IdTipoDatoDto> tiposDatoVenta,
      final AlgoritmoDTO algoritmo,
      final TareaDto tarea) {

    final List<IdTipoDatoDto> tiposDato = Instancio.ofList(IdTipoDatoDto.class).size(3).create();
    final List<IdPersonaLocalDto> personas = Instancio.ofList(IdPersonaLocalDto.class).size(25).create();

    algoritmo.setDesplazamiento(true);
    algoritmo.setDesplazamientoBase(false);

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(tiposDatoVenta);
    when(this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
            .thenReturn(tiposDato);

    this.tareaCalculoAlgoritmoGlobalTiendaSeccionPersonasPorVentaNoVendedoresPorcentajeV1RepositoryCustom.calcular(algoritmo, tarea,
        personas);

    verify(this.tipoDatoService, times(25))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    verify(this.tipoDatoService, times(25)).findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    final ArgumentCaptor<MapSqlParameterSource[]> paramsCaptor = ArgumentCaptor.forClass(MapSqlParameterSource[].class);
    verify(this.namedParameterJdbcTemplate).batchUpdate(eq(SQL_CALCULAR), paramsCaptor.capture());

    final List<Map<String, Object>> params =
        Arrays.stream(paramsCaptor.getValue()).map(MapSqlParameterSource::getValues).collect(Collectors.toList());

    final List<Map<String, Object>> expected = new ArrayList<>();

    personas.forEach(persona -> {

      // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
      // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
      // tipoDatoLocalizacionPersonaPresencia
      final Map<String, Object> map = new HashMap<>();
      map.put(SQL_PARAM_ACTIVO, SQL_VALUE_BOOLEAN_TRUE);
      map.put(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION,
          tiposDatoVenta.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
      map.put(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA,
          Collections.singletonList(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId()));
      map.put(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA,
          TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPO_HORA_DESPLAZAMIENTO.getId());
      map.put(SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
      map.put(SQL_PARAM_ID_TAREA, tarea.getId());
      map.put(SQL_PARAM_COMISIONABLE, SQL_VALUE_BOOLEAN_TRUE);
      map.put(SQL_PARAM_CALCULA, SQL_VALUE_BOOLEAN_TRUE);
      map.put(SQL_PARAM_EXCLUIDO_CALCULO, SQL_VALUE_BOOLEAN_FALSE);
      map.put(SQL_PARAM_IDS_TIPOS_COMISION,
          algoritmo.getTipoComision().stream().map(TipoComisionDTO::getId).collect(Collectors.toList()));
      map.put(SQL_PARAM_IDS_TIPOS_CALCULO,
          algoritmo.getTipoCalculo().stream().map(TipoCalculoDTO::getId).collect(Collectors.toList()));
      map.put(SQL_PARAM_ES_DESPLAZAMIENTO, SQL_VALUE_BOOLEAN_TRUE);
      map.put(SQL_PARAM_ES_DESPLAZAMIENTO_BASE, SQL_VALUE_BOOLEAN_FALSE);
      map.put(SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
      map.put(SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
      map.put(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA, TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId());
      map.put(SQL_PARAM_ID_TIPO_CALCULO, TipoCalculoEnum.GLOBAL_SECCION.getId());
      map.put(SQL_PARAM_FECHA_INICIO_PERIODO, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
      expected.add(map);
    });
    assertEquals(expected, params);

  }

  @Test
  void getSqlCalcularTest() {

    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(21);

    final String result = this.tareaCalculoAlgoritmoGlobalTiendaSeccionPersonasPorVentaNoVendedoresPorcentajeV1RepositoryCustom
        .getSqlCalcular(algoritmo);
    assertEquals(SQL_BASE, result);

  }

}
