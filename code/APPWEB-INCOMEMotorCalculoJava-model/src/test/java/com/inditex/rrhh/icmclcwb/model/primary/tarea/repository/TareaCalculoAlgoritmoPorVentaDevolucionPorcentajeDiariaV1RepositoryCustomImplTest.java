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
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_REPARTO_VENDEDOR_0;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_DEVOLUCION_LOCALIZACION_PERSONA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
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
class TareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaV1RepositoryCustomImplTest {

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
  private TareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaV1RepositoryCustomImpl tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaV1RepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaV1RepositoryCustom,
        "sqlCalcular",
        SQL_CALCULAR, true);
    FieldUtils.writeField(this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaV1RepositoryCustom,
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

    final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaV1RepositoryCustom
        .ids(algoritmo, tarea);

    assertEquals(2, ids.size());
    assertEquals(personas, ids);
  }

  @Test
  void getMapValuesTest() {

    when(this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
            .thenReturn(
                Arrays.asList(
                    IdTipoDatoDto
                        .builder()
                        .id(TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId())
                        .build(),
                    IdTipoDatoDto
                        .builder()
                        .id(TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId())
                        .build(),
                    IdTipoDatoDto
                        .builder()
                        .id(TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA
                            .getId())
                        .build()));

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
            tipoCalculo1,
            tipoCalculo2));
    when(algoritmo.getTipoComision()).thenReturn(
        Arrays.asList(tipoComision1, tipoComision2, tipoComision3));
    when(algoritmo.getDesplazamiento()).thenReturn(Boolean.TRUE);
    when(algoritmo.getDesplazamientoBase()).thenReturn(Boolean.FALSE);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(101L);
    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    when(persona1.getIdPersonaLocal()).thenReturn("AT1001");
    when(persona1.getStdOrHrPeriod()).thenReturn("01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // Parámetros de la consulta: idAlgoritmo, activo, idTipoDatoIndicadorPresencia,
    // idTipoDatoDevolucionLocalizacionPersona,
    // idTipoDatoDevolucionLocalizacion, fechaInicioPeriodo, idTipoDatoImporteComisionDevolucion,
    // cclIdPersonVendedor0,
    // idTipoPresencia, idTarea, cclIdPerson, stdOrHrPeriod, tiposCalculo, tiposComision,
    // esDesplazamiento,
    // esDesplazamientoBase, comisionable, calcula
    assertEquals(18, result.size());
    // activo
    assertTrue(result.containsKey(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ACTIVO));
    // idTipoDatoIndicadorPresencia
    assertTrue(result.containsKey(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
    assertEquals(TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId(),
        result.get(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
    // tipoDatoLocalizacionPersonaPresencia
    assertTrue(result.containsKey(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));
    assertEquals(
        Arrays.asList(TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
            TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
            TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()),
        result.get(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));
    // idTipoDatoDevolucionLocalizacionPersona
    assertTrue(result.containsKey(SQL_PARAM_ID_TIPO_IMPORTE_DEVOLUCION_LOCALIZACION_PERSONA));
    assertEquals(TipoDatoEnum.DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId(),
        result.get(SQL_PARAM_ID_TIPO_IMPORTE_DEVOLUCION_LOCALIZACION_PERSONA));
    // idTipoDatoDevolucionLocalizacion
    assertTrue(result.containsKey(SQL_PARAM_ID_TIPO_DATO_DEVOLUCION_LOCALIZACION_SECCION));
    assertEquals(TipoDatoEnum.DEVOLUCION_LOCALIZACION.getId(),
        result.get(SQL_PARAM_ID_TIPO_DATO_DEVOLUCION_LOCALIZACION_SECCION));
    // idTipoDatoImporteComisionDevolucion
    assertTrue(result.containsKey(SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_DEVOLUCION));
    assertEquals(TipoDatoEnum.IMPORTE_COMISION_DEVOLUCIONES_LOCALIZACION_POR_VENTA.getId(),
        result.get(SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_DEVOLUCION));
    // cclIdPersonVendedor0
    assertTrue(result.containsKey(SQL_PARAM_ID_TIPO_DATO_REPARTO_VENDEDOR_0));
    assertEquals(TipoDatoEnum.REPARTO_DEVOLUCION_VENDEDOR_0_LOCALIZACION_SECCION.getId(),
        result.get(SQL_PARAM_ID_TIPO_DATO_REPARTO_VENDEDOR_0));
    // idTipoPresencia
    assertTrue(result.containsKey(SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION));
    assertEquals(Collections.singletonList(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId()),
        result.get(SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION));
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
    // tiposComision
    assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_COMISION));
    assertEquals(Arrays.asList("001", "002", "003"), result.get(SQL_PARAM_IDS_TIPOS_COMISION));
    // tiposCalculo
    assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(Arrays.asList("011", "012"), result.get(SQL_PARAM_IDS_TIPOS_CALCULO));
    // esDesplazamiento
    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
    // esDesplazamientoBase
    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
  }

  @Test
  void calcularTest() {

    when(this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
            .thenReturn(
                Arrays.asList(
                    IdTipoDatoDto
                        .builder()
                        .id(TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId())
                        .build(),
                    IdTipoDatoDto
                        .builder()
                        .id(TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId())
                        .build(),
                    IdTipoDatoDto
                        .builder()
                        .id(TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA
                            .getId())
                        .build()));

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
            tipoCalculo1,
            tipoCalculo2));
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

    this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaV1RepositoryCustom.calcular(algoritmo, tarea,
        personas);

    // Parámetros de la consulta: idAlgoritmo, activo, idTipoDatoIndicadorPresencia,
    // idTipoDatoDevolucionLocalizacionPersona,
    // idTipoDatoDevolucionLocalizacion, fechaInicioPeriodo, idTipoDatoImporteComisionDevolucion,
    // cclIdPersonVendedor0,
    // idSeccion, tiposDatoPersonaPresencia, idTarea, cclIdPerson, stdOrHrPeriod, tiposCalculo,
    // tiposComision, esDesplazamiento,
    // esDesplazamientoBase, comisionable, calcula
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_CALCULAR, this.sqlCaptor.getValue());
    final MapSqlParameterSource[] values = this.paramsCaptor.getValue();
    // 2 elementos, porque se envían dos personas
    assertEquals(2, values.length);
    for (final MapSqlParameterSource value : values) {
      assertEquals(18, value.getValues().size());
      // activo
      assertTrue(value.hasValue(SQL_PARAM_ACTIVO));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_ACTIVO));
      // idTipoDatoIndicadorPresencia
      assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
      assertEquals(TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId(),
          value.getValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
      // tipoDatoLocalizacionPersonaPresencia
      assertTrue(value.hasValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));
      assertEquals(
          Arrays.asList(TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
              TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
              TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()),
          value.getValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));
      // idTipoDatoDevolucionLocalizacionPersona
      assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_IMPORTE_DEVOLUCION_LOCALIZACION_PERSONA));
      assertEquals(TipoDatoEnum.DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId(),
          value.getValue(SQL_PARAM_ID_TIPO_IMPORTE_DEVOLUCION_LOCALIZACION_PERSONA));
      // idTipoDatoDevolucionLocalizacion
      assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_DATO_DEVOLUCION_LOCALIZACION_SECCION));
      assertEquals(TipoDatoEnum.DEVOLUCION_LOCALIZACION.getId(),
          value.getValue(SQL_PARAM_ID_TIPO_DATO_DEVOLUCION_LOCALIZACION_SECCION));
      // idTipoDatoImporteComisionDevolucion
      assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_DEVOLUCION));
      assertEquals(TipoDatoEnum.IMPORTE_COMISION_DEVOLUCIONES_LOCALIZACION_POR_VENTA.getId(),
          value.getValue(SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_DEVOLUCION));
      // cclIdPersonVendedor0
      assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_DATO_REPARTO_VENDEDOR_0));
      assertEquals(TipoDatoEnum.REPARTO_DEVOLUCION_VENDEDOR_0_LOCALIZACION_SECCION.getId(),
          value.getValue(SQL_PARAM_ID_TIPO_DATO_REPARTO_VENDEDOR_0));
      // idTipoPresencia
      assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION));
      assertEquals(Collections.singletonList(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId()),
          value.getValue(SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION));
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
      // tiposComision
      assertTrue(value.hasValue(SQL_PARAM_IDS_TIPOS_COMISION));
      assertEquals(Arrays.asList("001", "002", "003"), value.getValue(SQL_PARAM_IDS_TIPOS_COMISION));
      // tiposCalculo
      assertTrue(value.hasValue(SQL_PARAM_IDS_TIPOS_CALCULO));
      assertEquals(Arrays.asList("011", "012"), value.getValue(SQL_PARAM_IDS_TIPOS_CALCULO));
      // esDesplazamiento
      assertTrue(value.hasValue(SQL_PARAM_ES_DESPLAZAMIENTO));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_ES_DESPLAZAMIENTO));
      // esDesplazamientoBase
      assertTrue(value.hasValue(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
      assertEquals(SQL_VALUE_BOOLEAN_FALSE, value.getValue(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
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
  void getSqlCalcularTest() {
    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(21);

    final String result = this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaV1RepositoryCustom
        .getSqlCalcular(algoritmo);
    assertEquals(SQL_BASE, result);
  }

}
