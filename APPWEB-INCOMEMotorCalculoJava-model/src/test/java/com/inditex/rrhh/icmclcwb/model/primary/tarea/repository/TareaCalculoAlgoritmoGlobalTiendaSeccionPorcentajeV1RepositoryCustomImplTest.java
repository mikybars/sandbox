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
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
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
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

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
class TareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeV1RepositoryCustomImplTest {

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
  private TareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeV1RepositoryCustomImpl tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeV1RepositoryCustom;

  @BeforeEach
  void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeV1RepositoryCustom, "sqlCalcular",
        SQL_CALCULAR, true);
    FieldUtils.writeField(this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeV1RepositoryCustom,
        "sqlCalcularBase",
        SQL_BASE, true);
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

    final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeV1RepositoryCustom
        .ids(algoritmo, tarea);

    assertEquals(2, ids.size());
    assertEquals(personas, ids);
  }

  @Test
  void getMapValuesTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    when(this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId()))
            .thenReturn(Arrays
                .asList(new IdTipoDatoDto(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId())));
    when(this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
            .thenReturn(Arrays.asList(
                new IdTipoDatoDto(
                    TipoDatoEnum.PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_INCLUIDODENOMINADOR.getId()),
                new IdTipoDatoDto(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDOECOMMERCE.getId())));

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
    when(algoritmo.getTipoCalculo()).thenReturn(
        Arrays.asList(
            tipoCalculo1,
            tipoCalculo2));
    when(algoritmo.getTipoComision()).thenReturn(
        Arrays.asList(tipoComision1, tipoComision2, tipoComision3));
    when(algoritmo.getDesplazamiento()).thenReturn(Boolean.TRUE);
    when(algoritmo.getDesplazamientoBase()).thenReturn(Boolean.FALSE);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(101L);
    when(tarea.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2019, 1, 1));

    final IdPersonaLocalDto persona = mock(IdPersonaLocalDto.class);
    when(persona.getIdPersonaLocal()).thenReturn("AT1001");
    when(persona.getStdOrHrPeriod()).thenReturn("01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona);
    verify(this.tipoDatoService).findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());

    // parametros de la consulta: activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    // tipoDatoLocalizacionPersonaPresencia
    final Map<String, Object> expected = new HashMap<>();
    expected.put(SQL_PARAM_ACTIVO, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION, Collections.singletonList(1011));
    expected.put(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA,
        Collections.singletonList(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId()));
    expected.put(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA,
        Arrays.asList(TipoDatoEnum.PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_INCLUIDODENOMINADOR.getId(),
            TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDOECOMMERCE.getId()));
    expected.put(SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
    expected.put(SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
    expected.put(SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
    expected.put(SQL_PARAM_COMISIONABLE, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_CALCULA, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_EXCLUIDO_CALCULO, SQL_VALUE_BOOLEAN_FALSE);
    expected.put(SQL_PARAM_IDS_TIPOS_COMISION, Arrays.asList("001", "002", "003"));
    expected.put(SQL_PARAM_IDS_TIPOS_CALCULO, Arrays.asList("011", "012"));
    expected.put(SQL_PARAM_ES_DESPLAZAMIENTO, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_ES_DESPLAZAMIENTO_BASE, SQL_VALUE_BOOLEAN_FALSE);
    expected.put(SQL_PARAM_FECHA_INICIO_PERIODO, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));

    assertEquals(expected, result);

  }

  @Test
  void calcularTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    when(this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId()))
            .thenReturn(Arrays
                .asList(new IdTipoDatoDto(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId())));
    when(this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
            .thenReturn(Arrays.asList(
                new IdTipoDatoDto(
                    TipoDatoEnum.PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_INCLUIDODENOMINADOR.getId()),
                new IdTipoDatoDto(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDOECOMMERCE.getId())));

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
    when(algoritmo.getTipoCalculo()).thenReturn(
        Arrays.asList(
            tipoCalculo1,
            tipoCalculo2));
    when(algoritmo.getTipoComision()).thenReturn(
        Arrays.asList(tipoComision1, tipoComision2, tipoComision3));
    when(algoritmo.getDesplazamiento()).thenReturn(Boolean.TRUE);
    when(algoritmo.getDesplazamientoBase()).thenReturn(Boolean.FALSE);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(101L);
    when(tarea.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2019, 1, 1));
    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    when(persona1.getIdPersonaLocal()).thenReturn("AT1001");
    when(persona1.getStdOrHrPeriod()).thenReturn("01");
    final IdPersonaLocalDto persona2 = mock(IdPersonaLocalDto.class);
    when(persona2.getIdPersonaLocal()).thenReturn("AT1002");
    when(persona2.getStdOrHrPeriod()).thenReturn("02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

    this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeV1RepositoryCustom.calcular(algoritmo, tarea, personas);

    // parametros de la consulta: activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    // tipoDatoLocalizacionPersonaPresencia
    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final List<Map<String, Object>> values =
        Arrays.stream(this.params.getValue()).map(MapSqlParameterSource::getValues).collect(Collectors.toList());
    assertEquals(2, values.size());
    final Map<String, Object> expectedPersona1 = new HashMap<>();
    expectedPersona1.put(SQL_PARAM_ACTIVO, SQL_VALUE_BOOLEAN_TRUE);
    expectedPersona1.put(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION, Collections.singletonList(1011));
    expectedPersona1.put(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA,
        Collections.singletonList(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId()));
    expectedPersona1.put(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA,
        Arrays.asList(TipoDatoEnum.PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_INCLUIDODENOMINADOR.getId(),
            TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDOECOMMERCE.getId()));
    expectedPersona1.put(SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
    expectedPersona1.put(SQL_PARAM_ID_TAREA, tarea.getId());
    expectedPersona1.put(SQL_PARAM_CCL_ID_PERSON, persona1.getIdPersonaLocal());
    expectedPersona1.put(SQL_PARAM_STD_OR_HR_PERIOD, persona1.getStdOrHrPeriod());
    expectedPersona1.put(SQL_PARAM_COMISIONABLE, SQL_VALUE_BOOLEAN_TRUE);
    expectedPersona1.put(SQL_PARAM_CALCULA, SQL_VALUE_BOOLEAN_TRUE);
    expectedPersona1.put(SQL_PARAM_EXCLUIDO_CALCULO, SQL_VALUE_BOOLEAN_FALSE);
    expectedPersona1.put(SQL_PARAM_IDS_TIPOS_COMISION, Arrays.asList("001", "002", "003"));
    expectedPersona1.put(SQL_PARAM_IDS_TIPOS_CALCULO, Arrays.asList("011", "012"));
    expectedPersona1.put(SQL_PARAM_ES_DESPLAZAMIENTO, SQL_VALUE_BOOLEAN_TRUE);
    expectedPersona1.put(SQL_PARAM_ES_DESPLAZAMIENTO_BASE, SQL_VALUE_BOOLEAN_FALSE);
    expectedPersona1.put(SQL_PARAM_FECHA_INICIO_PERIODO, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));

    final Map<String, Object> expectedPersona2 = new HashMap<>(expectedPersona1);
    expectedPersona2.put(SQL_PARAM_CCL_ID_PERSON, persona2.getIdPersonaLocal());
    expectedPersona2.put(SQL_PARAM_STD_OR_HR_PERIOD, persona2.getStdOrHrPeriod());

    assertTrue(values.contains(expectedPersona1));
    assertTrue(values.contains(expectedPersona2));
  }

  @Test
  void getSqlCalcularTest() {

    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(21);

    final String result = this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeV1RepositoryCustom
        .getSqlCalcular(algoritmo);
    assertEquals(SQL_BASE, result);

  }

}
