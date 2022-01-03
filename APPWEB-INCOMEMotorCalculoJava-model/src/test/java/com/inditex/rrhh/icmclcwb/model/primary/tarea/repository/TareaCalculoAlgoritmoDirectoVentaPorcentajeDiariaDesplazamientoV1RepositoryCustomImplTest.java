package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
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
public class TareaCalculoAlgoritmoDirectoVentaPorcentajeDiariaDesplazamientoV1RepositoryCustomImplTest {

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
  private TareaCalculoAlgoritmoDirectoVentaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl tareaCalculoAlgoritmoDirectoVentaPorcentajeDiariaDesplazamientoV1RepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaCalculoAlgoritmoDirectoVentaPorcentajeDiariaDesplazamientoV1RepositoryCustom,
        "sqlCalcular", SQL_CALCULAR, true);
    FieldUtils.writeField(this.tareaCalculoAlgoritmoDirectoVentaPorcentajeDiariaDesplazamientoV1RepositoryCustom,
        "sqlCalcularBase", SQL_BASE, true);
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
    final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoDirectoVentaPorcentajeDiariaDesplazamientoV1RepositoryCustom
        .ids(algoritmo, tarea);

    assertEquals(2, ids.size());
    assertEquals(personas, ids);
  }

  @Test
  public void getMapValuesTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class)))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(101)));
    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(1001);
    final TipoCalculoDTO tipoCalculo1 = new TipoCalculoDTO();
    tipoCalculo1.setId("003");
    final TipoComisionDTO tipoComision1 = new TipoComisionDTO();
    tipoComision1.setId("008");

    when(algoritmo.getTipoCalculo()).thenReturn(
        Arrays.asList(
            tipoCalculo1));
    when(algoritmo.getTipoComision()).thenReturn(
        Arrays.asList(tipoComision1));
    when(algoritmo.getDesplazamiento()).thenReturn(Boolean.TRUE);
    when(algoritmo.getDesplazamientoBase()).thenReturn(Boolean.FALSE);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(101L);
    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    when(persona1.getIdPersonaLocal()).thenReturn("AT1001");
    when(persona1.getStdOrHrPeriod()).thenReturn("01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoDirectoVentaPorcentajeDiariaDesplazamientoV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // Parámetros de la consulta: activo, tipoDatoLocalizacionVentaSeccion,
    // idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    verify(this.tipoDatoService, times(1))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    assertEquals(13, result.size());
    // activo
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, result.get(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    // tipoDatoLocalizacionVentaSeccion
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
    assertEquals(Arrays.asList(101),
        result.get(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
    // idAlgoritmo
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO));
    assertEquals(algoritmo.getId(), result.get(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO));
    // idTarea
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), result.get(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // cclIdPerson
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
    assertEquals(persona1.getIdPersonaLocal(), result.get(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
    // stdOrHrPeriod
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
    assertEquals(persona1.getStdOrHrPeriod(), result.get(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
    // comisionable
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
        result.get(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE));
    // calcula
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_CALCULA));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, result.get(SqlPrimaryConstants.SQL_PARAM_CALCULA));
    // tipocomision
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
    assertEquals(Arrays.asList("008"), result.get(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
    // tipocalculo
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(Arrays.asList("003"), result.get(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
    // esDesplazamiento
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
        result.get(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO));
    // esDesplazamientoBase
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
        result.get(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE));

  }

  @Test
  public void calcularTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class)))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(101)));

    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(1001);
    final TipoCalculoDTO tipoCalculo1 = new TipoCalculoDTO();
    tipoCalculo1.setId("003");
    final TipoComisionDTO tipoComision1 = new TipoComisionDTO();
    tipoComision1.setId("008");

    when(algoritmo.getTipoCalculo()).thenReturn(
        Arrays.asList(
            tipoCalculo1));
    when(algoritmo.getTipoComision()).thenReturn(
        Arrays.asList(tipoComision1));
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

    this.tareaCalculoAlgoritmoDirectoVentaPorcentajeDiariaDesplazamientoV1RepositoryCustom.calcular(algoritmo,
        tarea,
        personas);

    // parametros de la consulta: activo, tipoDatoLocalizacionVentaSeccion,
    // idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      assertEquals(13, value.getValues().size());
      // activo
      assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
      assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
          value.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
      // tipoDatoLocalizacionVentaSeccion
      assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
      assertEquals(Arrays.asList(101),
          value.getValue(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
      // excluidoCalculo
      assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO));
      assertEquals(algoritmo.getId(), value.getValue(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO));
      // idTarea
      assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
      assertEquals(tarea.getId(), value.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
      // comisionable
      assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE));
      assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
          value.getValue(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE));
      // calcula
      assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_CALCULA));
      assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
          value.getValue(SqlPrimaryConstants.SQL_PARAM_CALCULA));
      // tipocomision
      assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
      assertEquals(Arrays.asList("008"), value.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
      // tipocalculo
      assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
      assertEquals(Arrays.asList("003"), value.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
      // esDesplazamiento
      assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO));
      assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
          value.getValue(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO));
      // esDesplazamientoBase
      assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
      assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
          value.getValue(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
      // cclIdPerson, stdOrHrPeriod - existencia del parámetro
      assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
      assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
    }

    // cclIdPerson, stdOrHrPeriod - valores del parámetro
    assertEquals(1,
        Arrays.stream(values)
            .filter(value -> persona1.getIdPersonaLocal()
                .equals(value.getValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON))
                && persona1.getStdOrHrPeriod()
                    .equals(value.getValue(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD)))
            .toArray().length);
    assertEquals(1,
        Arrays.stream(values)
            .filter(value -> persona2.getIdPersonaLocal()
                .equals(value.getValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON))
                && persona2.getStdOrHrPeriod()
                    .equals(value.getValue(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD)))

            .toArray().length);
  }

  @Test
  public void getSqlCalcularTest() {

    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(21);

    final String result = this.tareaCalculoAlgoritmoDirectoVentaPorcentajeDiariaDesplazamientoV1RepositoryCustom
        .getSqlCalcular(algoritmo);
    assertEquals(SQL_BASE, result);

  }

}
