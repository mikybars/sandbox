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
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.dto.TipoCalculoDTO;
import com.inditex.rrhh.icmclcwb.dto.TipoComisionDTO;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.instancio.Instancio;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class AbstractTareaCalculoChallengeDirectoVentaReduccionJornadaPorcentajeRepositoryCustomTest {

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private TipoDatoService tipoDatoService;

  @Spy
  @InjectMocks
  private AbstractTareaCalculoChallengeDirectoVentaReduccionJornadaPorcentajeRepositoryCustom repository = this.getClassMock();

  private AbstractTareaCalculoChallengeDirectoVentaReduccionJornadaPorcentajeRepositoryCustom getClassMock() {
    return Mockito.mock(AbstractTareaCalculoChallengeDirectoVentaReduccionJornadaPorcentajeRepositoryCustom.class,
        Mockito.CALLS_REAL_METHODS);
  }

  @ParameterizedTest
  @InstancioSource(samples = 3)
  void idsTest(final TareaDto tarea, final AlgoritmoDTO algoritmo) throws IllegalAccessException {
    FieldUtils.writeField(this.repository, "tareaCalculoPersonaService", this.tareaCalculoPersonaService, true);
    final List<IdPersonaLocalDto> expectedPersonas = Instancio.ofList(IdPersonaLocalDto.class)
        .size(5)
        .create();
    doReturn(expectedPersonas).when(this.tareaCalculoPersonaService).findByAlgoritmo(tarea, algoritmo);

    final List<IdPersonaLocalDto> result = this.repository.ids(algoritmo, tarea);

    assertNotNull(result);
    assertEquals(expectedPersonas.size(), result.size());
    assertEquals(expectedPersonas, result);
    verify(this.tareaCalculoPersonaService, times(1)).findByAlgoritmo(tarea, algoritmo);
  }

  @Test
  void getMapValuesWithAllParametersTest() throws IllegalAccessException {
    FieldUtils.writeField(this.repository, "tipoDatoService", this.tipoDatoService, true);
    final List<IdTipoDatoDto> tipoDatoIds = Arrays.asList(
        new IdTipoDatoDto(201),
        new IdTipoDatoDto(202),
        new IdTipoDatoDto(203));
    doReturn(tipoDatoIds).when(this.tipoDatoService)
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());

    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    algoritmo.setId(2001);
    algoritmo.setDesplazamiento(Boolean.TRUE);
    algoritmo.setDesplazamientoBase(Boolean.FALSE);

    final List<TipoCalculoDTO> tiposCalculo = Arrays.asList(
        this.createTipoCalculo("TC201"),
        this.createTipoCalculo("TC202"));
    algoritmo.setTipoCalculo(tiposCalculo);

    final List<TipoComisionDTO> tiposComision = Arrays.asList(
        this.createTipoComision("COM201"),
        this.createTipoComision("COM202"));
    algoritmo.setTipoComision(tiposComision);

    final TareaDto tarea = Instancio.create(TareaDto.class);
    tarea.setId(3001L);

    final IdPersonaLocalDto persona = Instancio.create(IdPersonaLocalDto.class);
    persona.setIdPersonaLocal("PERSON_BASE_001");
    persona.setStdOrHrPeriod("HR");

    final Map<String, Object> result = this.repository.getMapValues(algoritmo, tarea, persona);

    assertNotNull(result);
    assertEquals(12, result.size()); // Parámetros base sin los específicos

    // Verificar parámetros básicos
    assertEquals(tarea.getId(), result.get(SQL_PARAM_ID_TAREA));
    assertEquals(persona.getIdPersonaLocal(), result.get(SQL_PARAM_CCL_ID_PERSON));
    assertEquals(persona.getStdOrHrPeriod(), result.get(SQL_PARAM_STD_OR_HR_PERIOD));
    assertEquals(algoritmo.getId(), result.get(SQL_PARAM_ID_ALGORITMO));

    // Verificar constantes booleanas
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_COMISIONABLE));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_CALCULA));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ACTIVO));

    // Verificar constantes de tipo dato
    assertEquals(Arrays.asList(201, 202, 203), result.get(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));

    // Verificar parámetros específicos del algoritmo
    assertEquals(Arrays.asList("COM201", "COM202"), result.get(SQL_PARAM_IDS_TIPOS_COMISION));
    assertEquals(Arrays.asList("TC201", "TC202"), result.get(SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));

    verify(this.tipoDatoService, times(1))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
  }

  @Test
  void getMapValuesWithNullTareaTest() throws IllegalAccessException {
    FieldUtils.writeField(this.repository, "tipoDatoService", this.tipoDatoService, true);

    final List<IdTipoDatoDto> tipoDatoIds = List.of(new IdTipoDatoDto(301));
    doReturn(tipoDatoIds).when(this.tipoDatoService)
        .findTipoDatoByTipoGrupoDato(any(Integer.class));

    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    algoritmo.setId(4001);
    algoritmo.setDesplazamiento(Boolean.FALSE);
    algoritmo.setDesplazamientoBase(Boolean.TRUE);
    algoritmo.setTipoCalculo(List.of(this.createTipoCalculo("TC301")));
    algoritmo.setTipoComision(List.of(this.createTipoComision("COM301")));

    final IdPersonaLocalDto persona = Instancio.create(IdPersonaLocalDto.class);
    persona.setIdPersonaLocal("PERSON_BASE_002");
    persona.setStdOrHrPeriod("STD");

    final Map<String, Object> result = this.repository.getMapValues(algoritmo, null, persona);

    assertNotNull(result);
    assertEquals(11, result.size()); // Uno menos porque tarea es null

    // Verificar que el parámetro tarea no está incluido
    assertFalse(result.containsKey(SQL_PARAM_ID_TAREA));

    // Verificar que otros parámetros están presentes
    assertEquals(persona.getIdPersonaLocal(), result.get(SQL_PARAM_CCL_ID_PERSON));
    assertEquals(algoritmo.getId(), result.get(SQL_PARAM_ID_ALGORITMO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
  }

  @Test
  void getMapValuesWithNullPersonaTest() throws IllegalAccessException {
    FieldUtils.writeField(this.repository, "tipoDatoService", this.tipoDatoService, true);

    final List<IdTipoDatoDto> tipoDatoIds = List.of(new IdTipoDatoDto(401));
    doReturn(tipoDatoIds).when(this.tipoDatoService)
        .findTipoDatoByTipoGrupoDato(any(Integer.class));

    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    algoritmo.setId(5001);
    algoritmo.setDesplazamiento(null); // Prueba desplazamiento null
    algoritmo.setDesplazamientoBase(null); // Prueba desplazamientoBase null
    algoritmo.setTipoCalculo(List.of(this.createTipoCalculo("TC401")));
    algoritmo.setTipoComision(List.of(this.createTipoComision("COM401")));

    final TareaDto tarea = Instancio.create(TareaDto.class);
    tarea.setId(6001L);

    final Map<String, Object> result = this.repository.getMapValues(algoritmo, tarea, null);

    assertNotNull(result);
    assertEquals(10, result.size()); // Dos menos porque persona es null

    // Verificar que parámetros de persona no están incluidos
    assertFalse(result.containsKey(SQL_PARAM_CCL_ID_PERSON));
    assertFalse(result.containsKey(SQL_PARAM_STD_OR_HR_PERIOD));

    // Verificar que otros parámetros están presentes
    assertEquals(tarea.getId(), result.get(SQL_PARAM_ID_TAREA));
    assertEquals(algoritmo.getId(), result.get(SQL_PARAM_ID_ALGORITMO));

    // Verificar que valores booleanos null se manejan correctamente
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
  }

  @Test
  void getMapValuesWithEmptyListsTest() throws IllegalAccessException {
    FieldUtils.writeField(this.repository, "tipoDatoService", this.tipoDatoService, true);

    final List<IdTipoDatoDto> tipoDatoIds = List.of();
    doReturn(tipoDatoIds).when(this.tipoDatoService)
        .findTipoDatoByTipoGrupoDato(any(Integer.class));

    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    algoritmo.setId(7001);
    algoritmo.setDesplazamiento(Boolean.FALSE);
    algoritmo.setDesplazamientoBase(Boolean.FALSE);
    algoritmo.setTipoCalculo(List.of()); // Lista vacía
    algoritmo.setTipoComision(List.of()); // Lista vacía

    final TareaDto tarea = Instancio.create(TareaDto.class);
    tarea.setId(8001L);

    final IdPersonaLocalDto persona = Instancio.create(IdPersonaLocalDto.class);
    persona.setIdPersonaLocal("PERSON_BASE_003");
    persona.setStdOrHrPeriod("STD");

    final Map<String, Object> result = this.repository.getMapValues(algoritmo, tarea, persona);

    assertNotNull(result);
    assertEquals(12, result.size());

    // Verificar que listas vacías se manejan correctamente
    assertEquals(List.of(), result.get(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
    assertEquals(List.of(), result.get(SQL_PARAM_IDS_TIPOS_COMISION));
    assertEquals(List.of(), result.get(SQL_PARAM_IDS_TIPOS_CALCULO));
  }

  @Test
  void addSpecificMapValuesDefaultImplementationTest() throws IllegalAccessException {
    FieldUtils.writeField(this.repository, "tipoDatoService", this.tipoDatoService, true);

    final List<IdTipoDatoDto> tipoDatoIds = List.of(new IdTipoDatoDto(501));
    doReturn(tipoDatoIds).when(this.tipoDatoService)
        .findTipoDatoByTipoGrupoDato(any(Integer.class));

    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    algoritmo.setId(9001);
    algoritmo.setDesplazamiento(Boolean.TRUE);
    algoritmo.setDesplazamientoBase(Boolean.TRUE);
    algoritmo.setTipoCalculo(List.of(this.createTipoCalculo("TC501")));
    algoritmo.setTipoComision(List.of(this.createTipoComision("COM501")));

    final TareaDto tarea = Instancio.create(TareaDto.class);
    tarea.setId(10001L);

    final IdPersonaLocalDto persona = Instancio.create(IdPersonaLocalDto.class);
    persona.setIdPersonaLocal("PERSON_BASE_004");
    persona.setStdOrHrPeriod("HR");

    final Map<String, Object> result = this.repository.getMapValues(algoritmo, tarea, persona);

    assertNotNull(result);
    assertEquals(12, result.size()); // Solo parámetros comunes, ninguno específico añadido por defecto

    // Verificar que todos los parámetros comunes están presentes
    assertEquals(tarea.getId(), result.get(SQL_PARAM_ID_TAREA));
    assertEquals(persona.getIdPersonaLocal(), result.get(SQL_PARAM_CCL_ID_PERSON));
    assertEquals(persona.getStdOrHrPeriod(), result.get(SQL_PARAM_STD_OR_HR_PERIOD));
    assertEquals(algoritmo.getId(), result.get(SQL_PARAM_ID_ALGORITMO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_COMISIONABLE));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_CALCULA));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));

    verify(this.tipoDatoService, times(1))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
  }

  // Métodos auxiliares
  private TipoCalculoDTO createTipoCalculo(final String id) {
    final TipoCalculoDTO tipoCalculo = new TipoCalculoDTO();
    tipoCalculo.setId(id);
    return tipoCalculo;
  }

  private TipoComisionDTO createTipoComision(final String id) {
    final TipoComisionDTO tipoComision = new TipoComisionDTO();
    tipoComision.setId(id);
    return tipoComision;
  }
}
