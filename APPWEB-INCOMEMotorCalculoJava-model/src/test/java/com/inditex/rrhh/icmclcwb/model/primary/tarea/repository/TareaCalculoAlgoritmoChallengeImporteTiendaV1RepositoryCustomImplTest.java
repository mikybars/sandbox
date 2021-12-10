package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

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

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
public class TareaCalculoAlgoritmoChallengeImporteTiendaV1RepositoryCustomImplTest {

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
  private TareaCalculoAlgoritmoChallengeImporteTiendaV1RepositoryCustomImpl tareaCalculoAlgoritmoChallengeImporteTiendaV1RepositoryCustomImpl;

  @Random
  private AlgoritmoDTO algoritmo;

  @Random
  private TareaDto tarea;

  @Random
  private IdPersonaLocalDto persona;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaCalculoAlgoritmoChallengeImporteTiendaV1RepositoryCustomImpl, "sqlCalcular",
        SQL_CALCULAR, true);
    FieldUtils.writeField(this.tareaCalculoAlgoritmoChallengeImporteTiendaV1RepositoryCustomImpl, "sqlCalcularBase",
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

    final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoChallengeImporteTiendaV1RepositoryCustomImpl
        .ids(algoritmo, tarea);

    assertEquals(2, ids.size());
    assertEquals(personas, ids);
  }

  @Test
  public void getMapValuesTest() {
    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(1001);
    final TipoCalculoDTO tipoCalculo1 = new TipoCalculoDTO();
    tipoCalculo1.setId("012");
    final TipoComisionDTO tipoComision1 = new TipoComisionDTO();
    final TipoComisionDTO tipoComision2 = new TipoComisionDTO();
    tipoComision1.setId("011");
    tipoComision2.setId("012");
    when(algoritmo.getTipoCalculo()).thenReturn(
        Arrays.asList(
            tipoCalculo1));
    when(algoritmo.getTipoComision()).thenReturn(
        Arrays.asList(tipoComision1, tipoComision2));
    when(algoritmo.getDesplazamiento()).thenReturn(Boolean.FALSE);
    when(algoritmo.getDesplazamientoBase()).thenReturn(Boolean.FALSE);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(101L);
    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    when(persona1.getIdPersonaLocal()).thenReturn("AT1001");
    when(persona1.getStdOrHrPeriod()).thenReturn("01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoChallengeImporteTiendaV1RepositoryCustomImpl
        .getMapValues(algoritmo, tarea, persona1);

    // Parámetros de la consulta: activo, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod,
    // comisionable, calcula
    assertEquals(12, result.size());
    // idTarea
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), result.get(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // cclIdPerson
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
    assertEquals(persona1.getIdPersonaLocal(), result.get(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
    // stdOrHrPeriod
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
    assertEquals(persona1.getStdOrHrPeriod(), result.get(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
    // idAlgoritmo
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO));
    assertEquals(algoritmo.getId(), result.get(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO));
    // comisionable
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
        result.get(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE));
    // calcula
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_CALCULA));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, result.get(SqlPrimaryConstants.SQL_PARAM_CALCULA));
    // activo
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, result.get(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    // activo
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE, result.get(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
    // tipocomision
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
    assertEquals(Arrays.asList("011", "012"), result.get(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
    // tipocalculo
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(Arrays.asList("012"), result.get(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
    // esDesplazamiento
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
        result.get(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO));
    // esDesplazamientoBase
    assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
        result.get(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
  }

  @Test
  public void calcularTest() {
    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(1001);
    final TipoCalculoDTO tipoCalculo1 = new TipoCalculoDTO();
    tipoCalculo1.setId("012");
    final TipoComisionDTO tipoComision1 = new TipoComisionDTO();
    final TipoComisionDTO tipoComision2 = new TipoComisionDTO();
    tipoComision1.setId("011");
    tipoComision2.setId("012");
    when(algoritmo.getTipoCalculo()).thenReturn(
        Arrays.asList(
            tipoCalculo1));
    when(algoritmo.getTipoComision()).thenReturn(
        Arrays.asList(tipoComision1, tipoComision2));
    when(algoritmo.getDesplazamiento()).thenReturn(Boolean.FALSE);
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

    this.tareaCalculoAlgoritmoChallengeImporteTiendaV1RepositoryCustomImpl.calcular(algoritmo, tarea, personas);

    // parametros de la consulta: activo, tipoDatoLocalizacionVentaSeccion,
    // idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      assertEquals(12, value.getValues().size());
      // activo
      assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
      assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
          value.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
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
      // inactivo
      assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
      assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
          value.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
      // tipocomision
      assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
      assertEquals(Arrays.asList("011", "012"), value.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
      // tipocalculo
      assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
      assertEquals(Arrays.asList("012"), value.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
      // esDesplazamiento
      assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO));
      assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
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

    final String result = this.tareaCalculoAlgoritmoChallengeImporteTiendaV1RepositoryCustomImpl
        .getSqlCalcular(algoritmo);
    assertEquals(SQL_BASE, result);

  }

  @Test
  void getMapValuesTest2() {
    this.algoritmo.setDesplazamiento(true);
    this.algoritmo.setDesplazamientoBase(true);

    final Map<String, Object> result = this.tareaCalculoAlgoritmoChallengeImporteTiendaV1RepositoryCustomImpl
        .getMapValues(this.algoritmo, this.tarea, this.persona);

    assertNotNull(result);
    assertEquals(result.get(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO), SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    assertEquals(result.get(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE), SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
  }

}
