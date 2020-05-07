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

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoCalculoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoComisionDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

@RunWith(MockitoJUnitRunner.class)
public class TareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustomImplTest {

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
    private TareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(
                tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl,
                "sqlCalcular", SQL_CALCULAR, true);
        FieldUtils.writeField(
                tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl,
                "sqlCalcularBase", SQL_BASE, true);
    }

    @Test
    public void idsTest() {
        TareaCalculoPersonaDto persona1 = mock(TareaCalculoPersonaDto.class);
        TareaCalculoPersonaDto persona2 = mock(TareaCalculoPersonaDto.class);
        List<TareaCalculoPersonaDto> personas = Arrays.asList(persona1, persona2);
        when(tareaCalculoPersonaService.findByAlgoritmo(any(TareaDto.class), any(AlgoritmoDto.class)))
            .thenReturn(personas);

        TareaDto tarea = mock(TareaDto.class);
        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
        List<TareaCalculoPersonaDto> ids = tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl
            .ids(algoritmo, tarea);

        assertEquals(2, ids.size());
        assertEquals(personas, ids);
    }


    @Test
    public void getMapValuesTest() {

        when(tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
        when(algoritmo.getId()).thenReturn(1001);
        when(algoritmo.getTipoCalculo()).thenReturn(
                Arrays.asList(
                        TipoCalculoDto
                            .builder()
                            .id("007")
                            .build()));
        when(algoritmo.getTipoComision()).thenReturn(
                Arrays.asList(
                        TipoComisionDto
                            .builder()
                            .id("001")
                            .build()));
        when(algoritmo.getDesplazamiento()).thenReturn(Boolean.FALSE);
        when(algoritmo.getDesplazamientoBase()).thenReturn(Boolean.FALSE);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(101L);
        TareaCalculoPersonaDto persona1 = mock(TareaCalculoPersonaDto.class);
        when(persona1.getCclIdPerson()).thenReturn("AT1001");
        when(persona1.getStdOrHrPeriod()).thenReturn("01");

        Map<String, Object> result = tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl
            .getMapValues(algoritmo, tarea, persona1);

        // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
        // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
        verify(tipoDatoService)
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        verify(tipoDatoService).findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());

        assertEquals(18, result.size());
        // idTarea
        assertTrue(result.containsKey(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), result.get(SQL_PARAM_ID_TAREA));
        // cclIdPerson
        assertTrue(result.containsKey(SQL_PARAM_CCL_ID_PERSON));
        assertEquals(persona1.getCclIdPerson(), result.get(SQL_PARAM_CCL_ID_PERSON));
        // stdOrHrPeriod
        assertTrue(result.containsKey(SQL_PARAM_STD_OR_HR_PERIOD));
        assertEquals(persona1.getStdOrHrPeriod(), result.get(SQL_PARAM_STD_OR_HR_PERIOD));
        // idAlgoritmo
        assertTrue(result.containsKey(SQL_PARAM_ID_ALGORITMO));
        assertEquals(algoritmo.getId(), result.get(SQL_PARAM_ID_ALGORITMO));
        // tipoDatoPersonaPresencia
        assertTrue(result.containsKey(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA));
        assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId(),
                result.get(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA));
        // tipoDatoLocalizacionPersonaPresencia
        assertTrue(result.containsKey(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));
        assertEquals(Arrays.asList(1011), result.get(SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));
        // tipoDatoLocalizacionVentaSeccion
        assertTrue(result.containsKey(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
        assertEquals(Arrays.asList(1011), result.get(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
        // comisionable
        assertTrue(result.containsKey(SQL_PARAM_COMISIONABLE));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_COMISIONABLE));
        // calcula
        assertTrue(result.containsKey(SQL_PARAM_CALCULA));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_CALCULA));
        // activo
        assertTrue(result.containsKey(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ACTIVO));
        // tipocomision
        assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_COMISION));
        assertEquals(Arrays.asList("001"), result.get(SQL_PARAM_IDS_TIPOS_COMISION));
        // tipocalculo
        assertTrue(result.containsKey(SQL_PARAM_IDS_TIPOS_CALCULO));
        assertEquals(Arrays.asList("007"), result.get(SQL_PARAM_IDS_TIPOS_CALCULO));
        // esDesplazamiento
        assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO));
        // esDesplazamientoBase
        assertTrue(result.containsKey(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
        // excluido calculo
        assertTrue(result.containsKey(SQL_PARAM_EXCLUIDO_CALCULO));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_EXCLUIDO_CALCULO));
    }


    @Test
    public void calcularTest() {
        when(tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
                .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        when(tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
        when(algoritmo.getId()).thenReturn(1001);
        when(algoritmo.getTipoCalculo()).thenReturn(
                Arrays.asList(
                        TipoCalculoDto
                            .builder()
                            .id("007")
                            .build()));
        when(algoritmo.getTipoComision()).thenReturn(
                Arrays.asList(
                        TipoComisionDto
                            .builder()
                            .id("001")
                            .build()));
        when(algoritmo.getDesplazamiento()).thenReturn(Boolean.FALSE);
        when(algoritmo.getDesplazamientoBase()).thenReturn(Boolean.FALSE);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(101L);

        TareaCalculoPersonaDto persona1 = mock(TareaCalculoPersonaDto.class);
        when(persona1.getCclIdPerson()).thenReturn("AT1001");
        when(persona1.getStdOrHrPeriod()).thenReturn("01");
        TareaCalculoPersonaDto persona2 = mock(TareaCalculoPersonaDto.class);
        when(persona2.getCclIdPerson()).thenReturn("AT1002");
        when(persona2.getStdOrHrPeriod()).thenReturn("02");
        List<TareaCalculoPersonaDto> personas = Arrays.asList(persona1, persona2);

        tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl
            .calcular(algoritmo, tarea, personas);

        // parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
        // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
        verify(tipoDatoService, times(2))
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
        verify(namedParameterJdbcTemplate).batchUpdate(any(String.class), params.capture());
        MapSqlParameterSource[] values = params.getValue();
        assertEquals(2, values.length);
        for (int i = 0; i < values.length; i++) {
            MapSqlParameterSource value = values[i];
            assertEquals(18, value.getValues().size());
            // idTarea
            assertTrue(value.hasValue(SQL_PARAM_ID_TAREA));
            assertEquals(tarea.getId(), value.getValue(SQL_PARAM_ID_TAREA));
            // cclIdPerson, stdOrHrPeriod - existencia del parámetro
            assertTrue(value.hasValue(SQL_PARAM_CCL_ID_PERSON));
            assertTrue(value.hasValue(SQL_PARAM_STD_OR_HR_PERIOD));
            // algoritmo
            assertTrue(value.hasValue(SQL_PARAM_ID_ALGORITMO));
            assertEquals(algoritmo.getId(), value.getValue(SQL_PARAM_ID_ALGORITMO));
            // comisionable
            assertTrue(value.hasValue(SQL_PARAM_COMISIONABLE));
            assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_COMISIONABLE));
            // calcula
            assertTrue(value.hasValue(SQL_PARAM_CALCULA));
            assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_CALCULA));
            // activo
            assertTrue(value.hasValue(SQL_PARAM_ACTIVO));
            assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_ACTIVO));
            // tipocomision
            assertTrue(value.hasValue(SQL_PARAM_IDS_TIPOS_COMISION));
            assertEquals(Arrays.asList("001"), value.getValue(SQL_PARAM_IDS_TIPOS_COMISION));
            // tipocalculo
            assertTrue(value.hasValue(SQL_PARAM_IDS_TIPOS_CALCULO));
            assertEquals(Arrays.asList("007"), value.getValue(SQL_PARAM_IDS_TIPOS_CALCULO));
            // esDesplazamiento
            assertTrue(value.hasValue(SQL_PARAM_ES_DESPLAZAMIENTO));
            assertEquals(SQL_VALUE_BOOLEAN_FALSE, value.getValue(SQL_PARAM_ES_DESPLAZAMIENTO));
            // esDesplazamientoBase
            assertTrue(value.hasValue(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
            assertEquals(SQL_VALUE_BOOLEAN_FALSE, value.getValue(SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
            // tipoDatoPersonaPresencia
            assertTrue(value.hasValue(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA));
            assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId(),
                    value.getValue(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA));
            // tipoDatoPersonaPresencia
            assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));
            assertEquals(Arrays.asList(1011),
                    value.getValue(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_PERSONA_PRESENCIA));
            // tipoDatoLocalizacionVentaSeccion
            assertTrue(value.hasValue(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
            assertEquals(Arrays.asList(1011),
                    value.getValue(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
            // excluido calculo
            assertTrue(value.hasValue(SQL_PARAM_EXCLUIDO_CALCULO));
            assertEquals(SQL_VALUE_BOOLEAN_FALSE, value.getValue(SQL_PARAM_EXCLUIDO_CALCULO));
        }

        // cclIdPerson, stdOrHrPeriod - valores del parámetro
        assertEquals(1,
                Arrays.stream(values)
                    .filter(value -> persona1.getCclIdPerson().equals(value.getValue(SQL_PARAM_CCL_ID_PERSON))
                            && persona1.getStdOrHrPeriod().equals(value.getValue(SQL_PARAM_STD_OR_HR_PERIOD)))
                    .toArray().length);
        assertEquals(1,
                Arrays.stream(values)
                    .filter(value -> persona2.getCclIdPerson().equals(value.getValue(SQL_PARAM_CCL_ID_PERSON))
                            && persona2.getStdOrHrPeriod().equals(value.getValue(SQL_PARAM_STD_OR_HR_PERIOD)))

                    .toArray().length);
    }

    @Test
    public void getSqlCalcularTest() {
        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
        when(algoritmo.getId()).thenReturn(21);

        String result = tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl
            .getSqlCalcular(algoritmo);
        assertEquals(SQL_BASE, result);
    }

}
