package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoCalculoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoComisionDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImplTest {

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
    private TareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(
                this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl,
                "sqlCalcular", SQL_CALCULAR, true);
        FieldUtils.writeField(
                this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl,
                "sqlCalcularBase", SQL_BASE, true);
    }

    @Test
    public void idsTest() {
        final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
        final IdPersonaLocalDto persona2 = mock(IdPersonaLocalDto.class);
        final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);
        when(this.tareaCalculoPersonaService.findByAlgoritmo(any(TareaDto.class), any(AlgoritmoDto.class)))
            .thenReturn(personas);

        final TareaDto tarea = mock(TareaDto.class);
        final AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
        final List<IdPersonaLocalDto> ids = this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .ids(algoritmo, tarea);

        assertEquals(2, ids.size());
        assertEquals(personas, ids);
    }


    @Test
    public void getMapValuesNumeroElementosTest() {

        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);
        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");

        final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona1);

        // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
        // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
        verify(this.tipoDatoService)
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        verify(this.tipoDatoService).findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());

        assertEquals(18, result.size());
    }

    @Test
    public void getMapValuesIdTareaTest() {

        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);
        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");

        final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona1);
        // idTarea
        assertTrue(result.containsKey(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), result.get(SQL_PARAM_ID_TAREA));
    }

    @Test
    public void getMapValuesCclIdPersonTest() {

        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);
        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");

        final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona1);
        // cclIdPerson
        assertTrue(result.containsKey(SQL_PARAM_CCL_ID_PERSON));
        assertEquals(persona1.getIdPersonaLocal(), result.get(SQL_PARAM_CCL_ID_PERSON));
    }

    @Test
    public void getMapValuesStdOrHrPeriodTest() {

        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);
        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");

        final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona1);
        // stdOrHrPeriod
        assertTrue(result.containsKey(SQL_PARAM_STD_OR_HR_PERIOD));
        assertEquals(persona1.getStdOrHrPeriod(), result.get(SQL_PARAM_STD_OR_HR_PERIOD));
    }

    @Test
    public void getMapValuesIdAlgoritmoTest() {

        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);
        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");

        final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona1);
        // idAlgoritmo
        assertTrue(result.containsKey(SQL_PARAM_ID_ALGORITMO));
        assertEquals(algoritmo.getId(), result.get(SQL_PARAM_ID_ALGORITMO));
    }

    @Test
    public void getMapValuesTipoDatopersonaPresenciaTest() {

        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);
        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");

        final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona1);
        // tipoDatoPersonaPresencia
        assertTrue(result.containsKey(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA));
        assertEquals(Collections.singleton(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId()),
                result.get(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA));
    }

    @Test
    public void getMapValuesTipoDatoLocalizacionPersonaPresenciaTest() {

        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);
        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");

        final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona1);
        // tipoDatoLocalizacionPersonaPresencia
        assertTrue(result.containsKey(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));
        assertEquals(Arrays.asList(1011), result.get(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));
    }

    @Test
    public void getMapValuesTipoDatoLocalizacionVentaSeccionTest() {

        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);
        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");

        final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona1);
        // tipoDatoLocalizacionVentaSeccion
        assertTrue(result.containsKey(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
        assertEquals(Arrays.asList(1011), result.get(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
    }

    @Test
    public void getMapValuesComisionableTest() {

        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);
        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");

        final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona1);
        // comisionable
        assertTrue(result.containsKey(SQL_PARAM_COMISIONABLE));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_COMISIONABLE));
    }

    @Test
    public void getMapValuesCalculaTest() {

        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);
        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");

        final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona1);
        // calcula
        assertTrue(result.containsKey(SQL_PARAM_CALCULA));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_CALCULA));
    }

    @Test
    public void getMapValuesActivoTest() {

        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);
        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");

        final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona1);
        // activo
        assertTrue(result.containsKey(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ACTIVO));
    }

    @Test
    public void getMapValuesTipoComisionTest() {

        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);
        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");

        final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona1);
        // tipocomision
        assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_COMISION));
        assertEquals(tiposComision, result.get(SQL_PARAM_IDS_TIPOS_COMISION));
    }

    @Test
    public void getMapValuesTipoCalculoTest() {

        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);
        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");

        final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona1);
        // tipocalculo
        assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_CALCULO));
        assertEquals(tiposCalculo, result.get(SQL_PARAM_IDS_TIPOS_CALCULO));
    }

    @Test
    public void getMapValuesEsDesplazamientoTest() {

        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);
        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");

        final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona1);
        // esDesplazamiento
        assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
    }

    @Test
    public void getMapValuesEsDesplazamientoBaseTest() {

        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);
        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");

        final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona1);
        // esDesplazamientoBase
        assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
    }

    @Test
    public void getMapValuesExcluidoCalculoTest() {

        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);
        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");

        final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona1);
        // excluido calculo
        assertTrue(result.containsKey(SQL_PARAM_EXCLUIDO_CALCULO));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_EXCLUIDO_CALCULO));
    }

    @Test
    public void getMapValuesIdTipoDatoIndicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacionTest() {

        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);
        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");

        final Map<String, Object> result = this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona1);
        // idTipoDatoIndicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion
        assertTrue(result.containsKey(
                SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE_DESPLAZAMIENTO_MISMA_LOCALIZACION));
    }

    @Test
    public void calcularNumeroElementosTest() {
        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);

        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");
        final IdPersonaLocalDto persona2 = this.creasteIdPersonaLocalDtoMock("AT1002", "02");
        final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

        this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .calcular(algoritmo, tarea, personas);

        // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
        // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
        verify(this.tipoDatoService, times(2))
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
        final MapSqlParameterSource[] values = this.params.getValue();
        assertEquals(2, values.length);
        for (int i = 0; i < values.length; i++) {
            final MapSqlParameterSource value = values[i];
            assertEquals(18, value.getValues().size());
        }
    }

    @Test
    public void calcularIdTareaTest() {
        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);

        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");
        final IdPersonaLocalDto persona2 = this.creasteIdPersonaLocalDtoMock("AT1002", "02");
        final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

        this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .calcular(algoritmo, tarea, personas);

        verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
        final MapSqlParameterSource[] values = this.params.getValue();
        assertEquals(2, values.length);
        for (int i = 0; i < values.length; i++) {
            final MapSqlParameterSource value = values[i];
            // idTarea
            assertTrue(value.hasValue(SQL_PARAM_ID_TAREA));
            assertEquals(tarea.getId(), value.getValue(SQL_PARAM_ID_TAREA));
        }
    }

    @Test
    public void calcularIdAlgotimoTest() {
        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);

        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");
        final IdPersonaLocalDto persona2 = this.creasteIdPersonaLocalDtoMock("AT1002", "02");
        final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

        this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .calcular(algoritmo, tarea, personas);

        verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
        final MapSqlParameterSource[] values = this.params.getValue();
        assertEquals(2, values.length);
        for (int i = 0; i < values.length; i++) {
            final MapSqlParameterSource value = values[i];
            // algoritmo
            assertTrue(value.hasValue(SQL_PARAM_ID_ALGORITMO));
            assertEquals(algoritmo.getId(), value.getValue(SQL_PARAM_ID_ALGORITMO));
        }
    }

    @Test
    public void calcularComisionableTest() {
        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);

        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");
        final IdPersonaLocalDto persona2 = this.creasteIdPersonaLocalDtoMock("AT1002", "02");
        final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

        this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .calcular(algoritmo, tarea, personas);

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
        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);

        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");
        final IdPersonaLocalDto persona2 = this.creasteIdPersonaLocalDtoMock("AT1002", "02");
        final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

        this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .calcular(algoritmo, tarea, personas);

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
    public void calcularActivoTest() {
        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);

        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");
        final IdPersonaLocalDto persona2 = this.creasteIdPersonaLocalDtoMock("AT1002", "02");
        final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

        this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .calcular(algoritmo, tarea, personas);

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
    public void calcularTipoComisionTest() {
        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);

        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");
        final IdPersonaLocalDto persona2 = this.creasteIdPersonaLocalDtoMock("AT1002", "02");
        final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

        this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .calcular(algoritmo, tarea, personas);

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
        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);

        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");
        final IdPersonaLocalDto persona2 = this.creasteIdPersonaLocalDtoMock("AT1002", "02");
        final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

        this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .calcular(algoritmo, tarea, personas);

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
        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);

        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");
        final IdPersonaLocalDto persona2 = this.creasteIdPersonaLocalDtoMock("AT1002", "02");
        final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

        this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .calcular(algoritmo, tarea, personas);

        verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
        final MapSqlParameterSource[] values = this.params.getValue();
        assertEquals(2, values.length);
        for (int i = 0; i < values.length; i++) {
            final MapSqlParameterSource value = values[i];
            // esDesplazamiento
            assertTrue(value.hasValue(SQL_PARAM_ES_DESPLAZAMIENTO));
            assertEquals(SQL_VALUE_BOOLEAN_FALSE, value.getValue(SQL_PARAM_ES_DESPLAZAMIENTO));
        }
    }

    @Test
    public void calcularEsDesplazamientoBaseTest() {
        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);

        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");
        final IdPersonaLocalDto persona2 = this.creasteIdPersonaLocalDtoMock("AT1002", "02");
        final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

        this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .calcular(algoritmo, tarea, personas);

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
    public void calcularTipoDatoPersonaPresenciaTest() {
        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);

        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");
        final IdPersonaLocalDto persona2 = this.creasteIdPersonaLocalDtoMock("AT1002", "02");
        final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

        this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .calcular(algoritmo, tarea, personas);

        verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
        final MapSqlParameterSource[] values = this.params.getValue();
        assertEquals(2, values.length);
        for (int i = 0; i < values.length; i++) {
            final MapSqlParameterSource value = values[i];
            // tipoDatoPersonaPresencia
            assertTrue(value.hasValue(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA));
            assertEquals(Collections.singleton(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId()),
                    value.getValue(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA));
        }
    }

    @Test
    public void calcularTipoDatoLocalizacionPersonaPresenciaTest() {
        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);

        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");
        final IdPersonaLocalDto persona2 = this.creasteIdPersonaLocalDtoMock("AT1002", "02");
        final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

        this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .calcular(algoritmo, tarea, personas);

        verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
        final MapSqlParameterSource[] values = this.params.getValue();
        assertEquals(2, values.length);
        for (int i = 0; i < values.length; i++) {
            final MapSqlParameterSource value = values[i];
            // tipoDatoLocalizacionPersonaPresencia
            assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));
            assertEquals(Arrays.asList(1011),
                    value.getValue(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));
        }
    }

    @Test
    public void calcularTipoDatoLocalizacionVentaSeccionTest() {
        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);

        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");
        final IdPersonaLocalDto persona2 = this.creasteIdPersonaLocalDtoMock("AT1002", "02");
        final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

        this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .calcular(algoritmo, tarea, personas);

        verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
        final MapSqlParameterSource[] values = this.params.getValue();
        assertEquals(2, values.length);
        for (int i = 0; i < values.length; i++) {
            final MapSqlParameterSource value = values[i];
            // tipoDatoLocalizacionVentaSeccion
            assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
            assertEquals(Arrays.asList(1011),
                    value.getValue(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
        }

    }

    @Test
    public void calcularExcluidoCalculoTest() {
        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);

        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");
        final IdPersonaLocalDto persona2 = this.creasteIdPersonaLocalDtoMock("AT1002", "02");
        final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

        this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .calcular(algoritmo, tarea, personas);

        verify(this.namedParameterJdbcTemplate).batchUpdate(any(String.class), this.params.capture());
        final MapSqlParameterSource[] values = this.params.getValue();
        assertEquals(2, values.length);
        for (int i = 0; i < values.length; i++) {
            final MapSqlParameterSource value = values[i];
            // excluido calculo
            assertTrue(value.hasValue(SQL_PARAM_EXCLUIDO_CALCULO));
            assertEquals(SQL_VALUE_BOOLEAN_FALSE, value.getValue(SQL_PARAM_EXCLUIDO_CALCULO));
        }
    }

    @Test
    public void calcularIdTipoDatoIndicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacionTest() {
        when(this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        final List<String> tiposCalculo = Collections.singletonList("007");
        final List<String> tiposComision = Collections.singletonList("001");
        final AlgoritmoDto algoritmo = this.createAlgoritmoDtoMock(tiposCalculo, tiposComision);
        final long idTarea = 109L;
        final TareaDto tarea = this.createTareaDtoMock(idTarea);

        final IdPersonaLocalDto persona1 = this.creasteIdPersonaLocalDtoMock("AT1001", "01");
        final IdPersonaLocalDto persona2 = this.creasteIdPersonaLocalDtoMock("AT1002", "02");
        final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);

        this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .calcular(algoritmo, tarea, personas);

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

    private TareaDto createTareaDtoMock(final long idTarea) {
        final TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(idTarea);
        return tarea;
    }

    private IdPersonaLocalDto creasteIdPersonaLocalDtoMock(final String idPersona, final String orPersona) {
        final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
        when(persona1.getIdPersonaLocal()).thenReturn(idPersona);
        when(persona1.getStdOrHrPeriod()).thenReturn(orPersona);
        return persona1;
    }

    private AlgoritmoDto createAlgoritmoDtoMock(final List<String> tiposCalculo, final List<String> tiposComision) {
        final AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
        when(algoritmo.getId()).thenReturn(1001);
        when(algoritmo.getTipoCalculo()).thenReturn(tiposCalculo.stream()
            .map(x -> TipoCalculoDto.builder().id(x).build())
            .collect(
                    Collectors.toList()));
        when(algoritmo.getTipoComision()).thenReturn(
                tiposComision.stream()
                    .map(x -> TipoComisionDto.builder().id(x).build())
                    .collect(Collectors.toList()));
        when(algoritmo.getDesplazamiento()).thenReturn(Boolean.FALSE);
        when(algoritmo.getDesplazamientoBase()).thenReturn(Boolean.FALSE);
        return algoritmo;
    }

    @Test
    public void getSqlCalcularTest() {
        final AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
        when(algoritmo.getId()).thenReturn(21);

        final String result = this.tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
            .getSqlCalcular(algoritmo);
        assertEquals(SQL_BASE, result);
    }

}
