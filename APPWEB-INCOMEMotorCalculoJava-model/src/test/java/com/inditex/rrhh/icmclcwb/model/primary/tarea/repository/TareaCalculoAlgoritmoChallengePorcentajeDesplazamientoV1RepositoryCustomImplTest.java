package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

/*
 * Copyright (c) 2022. Inditex
 */
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
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_INCLUIDO_CHALLENGE_PORCENTAJE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
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

public class TareaCalculoAlgoritmoChallengePorcentajeDesplazamientoV1RepositoryCustomImplTest {

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
  private TareaCalculoAlgoritmoChallengePorcentajeDesplazamientoV1RepositoryCustomImpl tareaCalculoAlgoritmoChallengePorcentajeDesplazamientoV1RepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaCalculoAlgoritmoChallengePorcentajeDesplazamientoV1RepositoryCustom, "sqlCalcular",
        SQL_CALCULAR, true);
    FieldUtils.writeField(this.tareaCalculoAlgoritmoChallengePorcentajeDesplazamientoV1RepositoryCustom, "sqlCalcularBase",
        SQL_BASE, true);
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

    final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoChallengePorcentajeDesplazamientoV1RepositoryCustom.ids(
        algoritmo,
        tarea);

    assertEquals(2, ids.size());
    assertEquals(personas, ids);
  }

  @Test
  public void getMapValuesTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    when(this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(4002), new IdTipoDatoDto(4003)));
    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(1001);
    final TipoCalculoDTO tipoCalculo1 = new TipoCalculoDTO();
    tipoCalculo1.setId("011");
    final TipoComisionDTO tipoComision1 = new TipoComisionDTO();
    tipoComision1.setId("015");
    when(algoritmo.getTipoCalculo()).thenReturn(
        Arrays.asList(
            tipoCalculo1));
    when(algoritmo.getTipoComision()).thenReturn(
        Arrays.asList(tipoComision1));
    when(algoritmo.getDesplazamiento()).thenReturn(Boolean.TRUE);
    when(algoritmo.getDesplazamientoBase()).thenReturn(Boolean.FALSE);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(101L);
    when(tarea.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2019, 11, 1));

    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    when(persona1.getIdPersonaLocal()).thenReturn("AT1001");
    when(persona1.getStdOrHrPeriod()).thenReturn("01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoChallengePorcentajeDesplazamientoV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // Parámetros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    verify(this.tipoDatoService).findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    assertEquals(18, result.size());
    // activo
    assertTrue(result.containsKey(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ACTIVO));
    // tipoDatoLocalizacionVentaSeccion
    assertTrue(result.containsKey(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
    assertEquals(Arrays.asList(1011), result.get(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
    // tipoDatoPersonaPresencia
    assertTrue(result.containsKey(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA));
    assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDOCHALLENGEPORCENTAJE.getId(),
        result.get(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA));
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
    // incluido challenge porcentaje
    assertTrue(result.containsKey(SQL_PARAM_INCLUIDO_CHALLENGE_PORCENTAJE));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_INCLUIDO_CHALLENGE_PORCENTAJE));
    // tipocomision
    assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_COMISION));
    assertEquals(Arrays.asList("015"), result.get(SQL_PARAM_IDS_TIPOS_COMISION));
    // tipocalculo
    assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(Arrays.asList("011"), result.get(SQL_PARAM_IDS_TIPOS_CALCULO));
    // esDesplazamiento
    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
    // esDesplazamientoBase
    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
  }

  @Test
  public void calcularTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    when(this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(4002), new IdTipoDatoDto(4003)));

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
    when(tarea.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2019, 11, 1));
    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    when(persona1.getIdPersonaLocal()).thenReturn("AT1001");
    when(persona1.getStdOrHrPeriod()).thenReturn("01");
    final IdPersonaLocalDto persona2 = mock(IdPersonaLocalDto.class);
    when(persona2.getIdPersonaLocal()).thenReturn("AT1002");
    when(persona2.getStdOrHrPeriod()).thenReturn("02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

    this.tareaCalculoAlgoritmoChallengePorcentajeDesplazamientoV1RepositoryCustom.calcular(algoritmo, tarea, personas);

    // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    // tipoDatoLocalizacionPersonaPresencia
    /*
     * verify(this.tipoDatoService, times(2)) .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
     * verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture()); final MapSqlParameterSource[] values =
     * this.params.getValue(); assertEquals(2, values.length); for (int i = 0; i < values.length; i++) { final MapSqlParameterSource value =
     * values[i]; assertEquals(16, value.getValues().size()); // activo assertTrue(value.hasValue(SQL_PARAM_ACTIVO));
     * assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_ACTIVO)); // tipoDatoLocalizacionVentaSeccion
     * assertTrue(value.hasValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION)); assertEquals(Arrays.asList(1011),
     * value.getValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION)); // tipoDatoPersonaPresencia
     * assertTrue(value.hasValue(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA));
     * assertEquals(Arrays.asList(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId()),
     * value.getValue(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA)); // tipoDatoLocalizacionPersonaPresencia
     * assertTrue(value.hasValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA)); assertEquals(
     * Arrays.asList(TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
     * TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()),
     * value.getValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA)); // excluidoCalculo
     * assertTrue(value.hasValue(SQL_PARAM_ID_ALGORITMO)); assertEquals(algoritmo.getId(), value.getValue(SQL_PARAM_ID_ALGORITMO)); //
     * idTarea assertTrue(value.hasValue(SQL_PARAM_ID_TAREA)); assertEquals(tarea.getId(), value.getValue(SQL_PARAM_ID_TAREA)); //
     * comisionable assertTrue(value.hasValue(SQL_PARAM_COMISIONABLE)); assertEquals(SQL_VALUE_BOOLEAN_TRUE,
     * value.getValue(SQL_PARAM_COMISIONABLE)); // calcula assertTrue(value.hasValue(SQL_PARAM_CALCULA));
     * assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_CALCULA)); // excluido calculo
     * assertTrue(value.hasValue(SQL_PARAM_EXCLUIDO_CALCULO)); assertEquals(SQL_VALUE_BOOLEAN_FALSE,
     * value.getValue(SQL_PARAM_EXCLUIDO_CALCULO)); // tipocomision assertTrue(value.hasValue(SQL_PARAM_IDS_TIPOS_COMISION));
     * assertEquals(Arrays.asList("001", "002", "003"), value.getValue(SQL_PARAM_IDS_TIPOS_COMISION)); // tipocalculo
     * assertTrue(value.hasValue(SQL_PARAM_IDS_TIPOS_CALCULO)); assertEquals(Arrays.asList("011", "012"),
     * value.getValue(SQL_PARAM_IDS_TIPOS_CALCULO)); // esDesplazamiento assertTrue(value.hasValue(SQL_PARAM_ES_DESPLAZAMIENTO));
     * assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_ES_DESPLAZAMIENTO)); // esDesplazamientoBase
     * assertTrue(value.hasValue(SQL_PARAM_ES_DESPLAZAMIENTO_BASE)); assertEquals(SQL_VALUE_BOOLEAN_FALSE,
     * value.getValue(SQL_PARAM_ES_DESPLAZAMIENTO_BASE)); // cclIdPerson, stdOrHrPeriod - existencia del parámetro
     * assertTrue(value.hasValue(SQL_PARAM_CCL_ID_PERSON)); assertTrue(value.hasValue(SQL_PARAM_STD_OR_HR_PERIOD)); }
     *
     * // cclIdPerson, stdOrHrPeriod - valores del parámetro assertEquals(1, Arrays.stream(values) .filter(value ->
     * persona1.getIdPersonaLocal().equals(value.getValue(SQL_PARAM_CCL_ID_PERSON)) &&
     * persona1.getStdOrHrPeriod().equals(value.getValue(SQL_PARAM_STD_OR_HR_PERIOD))) .toArray().length); assertEquals(1,
     * Arrays.stream(values) .filter(value -> persona2.getIdPersonaLocal().equals(value.getValue(SQL_PARAM_CCL_ID_PERSON)) &&
     * persona2.getStdOrHrPeriod().equals(value.getValue(SQL_PARAM_STD_OR_HR_PERIOD)))
     *
     * .toArray().length);
     */

  }

  @Test
  public void getSqlCalcularTest() {

    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(21);

    final String result = this.tareaCalculoAlgoritmoChallengePorcentajeDesplazamientoV1RepositoryCustom
        .getSqlCalcular(algoritmo);
    assertEquals(SQL_BASE, result);

  }

}
