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
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE_DESPLAZAMIENTO_MISMA_LOCALIZACION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImplTest {

  private final static String SQL_BASE = "SQL CALCULAR BASE";

  private final static String SQL_CALCULAR = "SQL CALCULAR";

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private TipoDatoService tipoDatoService;

  @Mock
  private Logger log;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource[]> params;

  @InjectMocks
  private TareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(
        this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom,
        "sqlCalcular", SQL_CALCULAR, true);
    FieldUtils.writeField(
        this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom,
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

    final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .ids(algoritmo, tarea);

    assertEquals(2, ids.size());
    assertEquals(personas, ids);
  }

  @Test
  public void getMapValuesTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    verify(this.tipoDatoService).findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    assertEquals(18, result.size());
  }

  @Test
  public void getMapValuesActivoTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // activo
    assertTrue(result.containsKey(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ACTIVO));
  }

  @Test
  public void getMapValuesTipoDatoLocalizacionVentaSeccionTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // tipoDatoLocalizacionVentaSeccion
    assertTrue(result.containsKey(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
    assertEquals(Arrays.asList(1011), result.get(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
  }

  @Test
  public void getMapValuesTipoDatoPersonaPresenciaTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // tipoDatoPersonaPresencia
    assertTrue(result.containsKey(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA));
    assertEquals(Arrays.asList(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId()),
        result.get(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA));
  }

  @Test
  public void getMapValuesIdAlgoritmoTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // idAlgoritmo
    assertTrue(result.containsKey(SQL_PARAM_ID_ALGORITMO));
    assertEquals(algoritmo.getId(), result.get(SQL_PARAM_ID_ALGORITMO));
  }

  @Test
  public void getMapValuesIdTareaTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // idTarea
    assertTrue(result.containsKey(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), result.get(SQL_PARAM_ID_TAREA));
  }

  @Test
  public void getMapValuesCclIdPersonTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // cclIdPerson
    assertTrue(result.containsKey(SQL_PARAM_CCL_ID_PERSON));
    assertEquals(persona1.getIdPersonaLocal(), result.get(SQL_PARAM_CCL_ID_PERSON));
  }

  @Test
  public void getMapValuesStdOrHrPeriodTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // stdOrHrPeriod
    assertTrue(result.containsKey(SQL_PARAM_STD_OR_HR_PERIOD));
    assertEquals(persona1.getStdOrHrPeriod(), result.get(SQL_PARAM_STD_OR_HR_PERIOD));
  }

  @Test
  public void getMapValuesComisionableTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // comisionable
    assertTrue(result.containsKey(SQL_PARAM_COMISIONABLE));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_COMISIONABLE));
  }

  @Test
  public void getMapValuesCalculaTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // calcula
    assertTrue(result.containsKey(SQL_PARAM_CALCULA));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_CALCULA));
  }

  @Test
  public void getMapValuesExcluidoCalculoTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // excluido calculo
    assertTrue(result.containsKey(SQL_PARAM_EXCLUIDO_CALCULO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_EXCLUIDO_CALCULO));
  }

  @Test
  public void getMapValuesTipoComisionTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // tipocomision
    assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_COMISION));
    assertEquals(tiposComision, result.get(SQL_PARAM_IDS_TIPOS_COMISION));
  }

  @Test
  public void getMapValuesTipoCalculoTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // tipocalculo
    assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(tiposCalculo, result.get(SQL_PARAM_IDS_TIPOS_CALCULO));
  }

  @Test
  public void getMapValuesEsDesplazamientoTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // esDesplazamiento
    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
  }

  @Test
  public void getMapValuesEsDesplazamientoBaseTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // esDesplazamientoBase
    assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
  }

  @Test
  public void getMapValuesIdTipoDatoIndicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacionTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");

    final Map<String, Object> result = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getMapValues(algoritmo, tarea, persona1);

    // idTipoDatoIndicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion
    assertTrue(result.containsKey(
        SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE_DESPLAZAMIENTO_MISMA_LOCALIZACION));

  }

  @Test
  public void calcularNuemeroElementosTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));

    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final Long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");
    final IdPersonaLocalDto persona2 = this.createIdPersonaLocalDtoMock("AT1002", "02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

    this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.calcular(algoritmo,
        tarea,
        personas);

    // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      assertEquals(18, value.getValues().size());
    }
  }

  @Test
  public void calcularNuemeroActivoTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));

    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final Long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");
    final IdPersonaLocalDto persona2 = this.createIdPersonaLocalDtoMock("AT1002", "02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

    this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.calcular(algoritmo,
        tarea,
        personas);

    // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      // activo
      assertTrue(value.hasValue(SQL_PARAM_ACTIVO));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_ACTIVO));
    }
  }

  @Test
  public void calcularNuemeroTipoDatoLocalizacionVentaSeccionTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));

    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final Long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");
    final IdPersonaLocalDto persona2 = this.createIdPersonaLocalDtoMock("AT1002", "02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

    this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.calcular(algoritmo,
        tarea,
        personas);

    // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      // tipoDatoLocalizacionVentaSeccion
      assertTrue(value.hasValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
      assertEquals(Arrays.asList(1011), value.getValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
    }
  }

  @Test
  public void calcularTipoDatoPersonaPresenciaTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));

    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final Long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");
    final IdPersonaLocalDto persona2 = this.createIdPersonaLocalDtoMock("AT1002", "02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

    this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.calcular(algoritmo,
        tarea,
        personas);

    // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      // tipoDatoPersonaPresencia
      assertTrue(value.hasValue(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA));
      assertEquals(Arrays.asList(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId()),
          value.getValue(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA));
    }
  }

  @Test
  public void calcularExcluidoCalculoTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));

    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final Long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");
    final IdPersonaLocalDto persona2 = this.createIdPersonaLocalDtoMock("AT1002", "02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

    this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.calcular(algoritmo,
        tarea,
        personas);

    // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      // excluidoCalculo
      assertTrue(value.hasValue(SQL_PARAM_ID_ALGORITMO));
      assertEquals(algoritmo.getId(), value.getValue(SQL_PARAM_ID_ALGORITMO));
    }
  }

  @Test
  public void calcularIdtareaTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));

    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final Long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");
    final IdPersonaLocalDto persona2 = this.createIdPersonaLocalDtoMock("AT1002", "02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

    this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.calcular(algoritmo,
        tarea,
        personas);

    // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      // idTarea
      assertTrue(value.hasValue(SQL_PARAM_ID_TAREA));
      assertEquals(idTarea, value.getValue(SQL_PARAM_ID_TAREA));
    }
  }

  @Test
  public void calcularComisionableTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));

    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final Long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");
    final IdPersonaLocalDto persona2 = this.createIdPersonaLocalDtoMock("AT1002", "02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

    this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.calcular(algoritmo,
        tarea,
        personas);

    // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      // comisionable
      assertTrue(value.hasValue(SQL_PARAM_COMISIONABLE));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_COMISIONABLE));
    }
  }

  @Test
  public void calcularCalculaTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));

    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final Long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");
    final IdPersonaLocalDto persona2 = this.createIdPersonaLocalDtoMock("AT1002", "02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

    this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.calcular(algoritmo,
        tarea,
        personas);

    // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      // calcula
      assertTrue(value.hasValue(SQL_PARAM_CALCULA));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_CALCULA));
    }
  }

  @Test
  public void calcularTipoComisionTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));

    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final Long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");
    final IdPersonaLocalDto persona2 = this.createIdPersonaLocalDtoMock("AT1002", "02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

    this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.calcular(algoritmo,
        tarea,
        personas);

    // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      // tipocomision
      assertTrue(value.hasValue(SQL_PARAM_IDS_TIPOS_COMISION));
      assertEquals(tiposComision, value.getValue(SQL_PARAM_IDS_TIPOS_COMISION));
    }
  }

  @Test
  public void calcularTipoCalculoTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));

    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final Long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");
    final IdPersonaLocalDto persona2 = this.createIdPersonaLocalDtoMock("AT1002", "02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

    this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.calcular(algoritmo,
        tarea,
        personas);

    // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      // tipocalculo
      assertTrue(value.hasValue(SQL_PARAM_IDS_TIPOS_CALCULO));
      assertEquals(tiposCalculo, value.getValue(SQL_PARAM_IDS_TIPOS_CALCULO));
    }
  }

  @Test
  public void calcularEsDesplazamientoTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));

    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final Long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");
    final IdPersonaLocalDto persona2 = this.createIdPersonaLocalDtoMock("AT1002", "02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

    this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.calcular(algoritmo,
        tarea,
        personas);

    // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      // esDesplazamiento
      assertTrue(value.hasValue(SQL_PARAM_ES_DESPLAZAMIENTO));
      assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_ES_DESPLAZAMIENTO));
    }
  }

  @Test
  public void calcularEsDesplazamientoBaseTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));

    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final Long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");
    final IdPersonaLocalDto persona2 = this.createIdPersonaLocalDtoMock("AT1002", "02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

    this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.calcular(algoritmo,
        tarea,
        personas);

    // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      // esDesplazamientoBase
      assertTrue(value.hasValue(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
      assertEquals(SQL_VALUE_BOOLEAN_FALSE, value.getValue(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    }
  }

  @Test
  public void calcularIdTipoDatoIndicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacionTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));

    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final Long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");
    final IdPersonaLocalDto persona2 = this.createIdPersonaLocalDtoMock("AT1002", "02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

    this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.calcular(algoritmo,
        tarea,
        personas);

    // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      // idTipoDatoIndicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion
      assertTrue(value.hasValue(
          SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE_DESPLAZAMIENTO_MISMA_LOCALIZACION));
      assertEquals(
          TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE_DESPLAZAMIENTO_MISMA_LOCALIZACION
              .getId(),
          value.getValue(
              SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE_DESPLAZAMIENTO_MISMA_LOCALIZACION));
    }
  }

  @Test
  public void calcularPersonasTest() {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
        .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));

    final List<String> tiposComision = Arrays.asList("001", "002", "003");
    final List<String> tiposCalculo = Arrays.asList("011", "012");
    final AlgoritmoDTO algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
    final Long idTarea = 101L;
    final TareaDto tarea = this.createTareaDtoMock(idTarea);
    final IdPersonaLocalDto persona1 = this.createIdPersonaLocalDtoMock("AT1001", "01");
    final IdPersonaLocalDto persona2 = this.createIdPersonaLocalDtoMock("AT1002", "02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

    this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .calcular(algoritmo,
            tarea,
            personas);

    // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
    // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
    verify(this.tipoDatoService, times(2))
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
    verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
    final MapSqlParameterSource[] values = this.params.getValue();
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
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
  public void getSqlCalcularTest() {

    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(21);

    final String result = this.tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom
        .getSqlCalcular(algoritmo);
    assertEquals(SQL_BASE, result);

  }

  private IdPersonaLocalDto createIdPersonaLocalDtoMock(final String idPersona, final String orEmpleado) {
    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    when(persona1.getIdPersonaLocal()).thenReturn(idPersona);
    when(persona1.getStdOrHrPeriod()).thenReturn(orEmpleado);
    return persona1;
  }

  private TareaDto createTareaDtoMock(final Long idTarea) {
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(idTarea);
    when(tarea.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2019, 11, 1));

    return tarea;
  }

  private AlgoritmoDTO createAlgoritmoDtoMock(final List<String> tiposCalculo, final List<String> tiposComision) {
    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(1001);
    when(algoritmo.getTipoCalculo()).thenReturn(tiposCalculo.stream()
        .map(x -> {
          final TipoCalculoDTO tc = new TipoCalculoDTO();
          tc.id(x);
          return tc;
        })
        .collect(Collectors.toList()));
    when(algoritmo.getTipoComision()).thenReturn(tiposComision.stream()
        .map(x -> {
          final TipoComisionDTO tc = new TipoComisionDTO();
          tc.id(x);
          return tc;
        })
        .collect(Collectors.toList()));
    when(algoritmo.getDesplazamiento()).thenReturn(Boolean.TRUE);
    when(algoritmo.getDesplazamientoBase()).thenReturn(Boolean.FALSE);
    return algoritmo;
  }

}
