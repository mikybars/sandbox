package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
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

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaCalculoAlgoritmoGlobalTiendaPorcentajeDesplazamientoBaseV1RepositoryCustomImplTest {

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
    private TareaCalculoAlgoritmoGlobalTiendaPorcentajeDesplazamientoBaseV1RepositoryCustomImpl
        tareaCalculoAlgoritmoGlobalTiendaPorcentajeDesplazamientoBaseV1RepositoryCustom;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaCalculoAlgoritmoGlobalTiendaPorcentajeDesplazamientoBaseV1RepositoryCustom, "sqlCalcular", SQL_CALCULAR, true);
        FieldUtils.writeField(tareaCalculoAlgoritmoGlobalTiendaPorcentajeDesplazamientoBaseV1RepositoryCustom, "sqlCalcularBase", SQL_BASE, true);
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

        List<TareaCalculoPersonaDto> ids =
            tareaCalculoAlgoritmoGlobalTiendaPorcentajeDesplazamientoBaseV1RepositoryCustom.ids(algoritmo, tarea);

        assertEquals(2, ids.size());
        assertEquals(personas, ids);
    }

    @Test
    public void getMapValuesTest() {

        when(tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));
        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
        when(algoritmo.getId()).thenReturn(1001);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(101L);
        TareaCalculoPersonaDto persona1 = mock(TareaCalculoPersonaDto.class);
        when(persona1.getCclIdPerson()).thenReturn("AT1001");
        when(persona1.getStdOrHrPeriod()).thenReturn("01");

        Map<String, Object> result = tareaCalculoAlgoritmoGlobalTiendaPorcentajeDesplazamientoBaseV1RepositoryCustom.getMapValues(algoritmo, tarea, persona1);

        //parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
        // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
        verify(tipoDatoService).findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
        assertEquals(12, result.size());
        // idSeccion
        assertTrue(result.containsKey(SQL_PARAM_ID_SECCION));
        assertEquals(AppConstants.SECCION_4, result.get(SQL_PARAM_ID_SECCION));
        // activo
        assertTrue(result.containsKey(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_ACTIVO));
        // tipoDatoLocalizacionVentaSeccion
        assertTrue(result.containsKey(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
        assertEquals(Arrays.asList(1011), result.get(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
        // tipoDatoPersonaPresencia
        assertTrue(result.containsKey(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA));
        assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId(), result.get(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA));
        // idAlgoritmo
        assertTrue(result.containsKey(SQL_PARAM_ID_ALGORITMO));
        assertEquals(algoritmo.getId(), result.get(SQL_PARAM_ID_ALGORITMO));
        // idTarea
        assertTrue(result.containsKey(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), result.get(SQL_PARAM_ID_TAREA));
        // cclIdPerson
        assertTrue(result.containsKey(SQL_PARAM_CCL_ID_PERSON));
        assertEquals(persona1.getCclIdPerson(), result.get(SQL_PARAM_CCL_ID_PERSON));
        // stdOrHrPeriod
        assertTrue(result.containsKey(SQL_PARAM_STD_OR_HR_PERIOD));
        assertEquals(persona1.getStdOrHrPeriod(), result.get(SQL_PARAM_STD_OR_HR_PERIOD));
        // comisionable
        assertTrue(result.containsKey(SQL_PARAM_COMISIONABLE));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_COMISIONABLE));
        // calcula
        assertTrue(result.containsKey(SQL_PARAM_CALCULA));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, result.get(SQL_PARAM_CALCULA));
        // excluido calculo
        assertTrue(result.containsKey(SQL_PARAM_EXCLUIDO_CALCULO));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, result.get(SQL_PARAM_EXCLUIDO_CALCULO));
    }

    @Test
    public void calcularTest() {

        when(tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(1011)));

        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
        when(algoritmo.getId()).thenReturn(1001);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(101L);
        TareaCalculoPersonaDto persona1 = mock(TareaCalculoPersonaDto.class);
        when(persona1.getCclIdPerson()).thenReturn("AT1001");
        when(persona1.getStdOrHrPeriod()).thenReturn("01");
        TareaCalculoPersonaDto persona2 = mock(TareaCalculoPersonaDto.class);
        when(persona2.getCclIdPerson()).thenReturn("AT1002");
        when(persona2.getStdOrHrPeriod()).thenReturn("02");
        List<TareaCalculoPersonaDto> personas = Arrays.asList(persona1, persona2);

        tareaCalculoAlgoritmoGlobalTiendaPorcentajeDesplazamientoBaseV1RepositoryCustom.calcular(algoritmo, tarea, personas);

        //parametros de la consulta: idSeccion, activo, tipoDatoLocalizacionVentaSeccion, excluido calculo,
        // tipoDatoPersonaPresencia, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod, comisionable, calcula
        verify(tipoDatoService, times(2)).findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_LOCALIZACION_SECCION.getId());
        verify(namedParameterJdbcTemplate).batchUpdate(any(String.class), params.capture());
        MapSqlParameterSource[] values = params.getValue();
        assertEquals(2, values.length);
        for (int i = 0; i<values.length; i++) {
            MapSqlParameterSource value = values[i];
            assertEquals(12, value.getValues().size());
            // idSeccion
            assertTrue(value.hasValue(SQL_PARAM_ID_SECCION));
            assertEquals(AppConstants.SECCION_4, value.getValue(SQL_PARAM_ID_SECCION));
            // activo
            assertTrue(value.hasValue(SQL_PARAM_ACTIVO));
            assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_ACTIVO));
            // tipoDatoLocalizacionVentaSeccion
            assertTrue(value.hasValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
            assertEquals(Arrays.asList(1011), value.getValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
            // tipoDatoPersonaPresencia
            assertTrue(value.hasValue(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA));
            assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId(), value.getValue(SQL_PARAM_TIPO_DATO_PERSONA_PRESENCIA));
            // excluidoCalculo
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
            // excluido calculo
            assertTrue(value.hasValue(SQL_PARAM_EXCLUIDO_CALCULO));
            assertEquals(SQL_VALUE_BOOLEAN_FALSE, value.getValue(SQL_PARAM_EXCLUIDO_CALCULO));
            // cclIdPerson, stdOrHrPeriod - existencia del parámetro
            assertTrue(value.hasValue(SQL_PARAM_CCL_ID_PERSON));
            assertTrue(value.hasValue(SQL_PARAM_STD_OR_HR_PERIOD));
        }

        // cclIdPerson, stdOrHrPeriod - valores del parámetro
        assertEquals(1,
            Arrays.stream(values)
                .filter(value ->
                    persona1.getCclIdPerson().equals(value.getValue(SQL_PARAM_CCL_ID_PERSON))
                        && persona1.getStdOrHrPeriod().equals(value.getValue(SQL_PARAM_STD_OR_HR_PERIOD)))
                .toArray()
                .length);
        assertEquals(1,
            Arrays.stream(values)
                .filter(value ->
                    persona2.getCclIdPerson().equals(value.getValue(SQL_PARAM_CCL_ID_PERSON))
                        && persona2.getStdOrHrPeriod().equals(value.getValue(SQL_PARAM_STD_OR_HR_PERIOD)))

                .toArray()
                .length);
    }

    @Test
    public void getSqlCalcularTest() {

        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
        when(algoritmo.getId()).thenReturn(21);

        String result = tareaCalculoAlgoritmoGlobalTiendaPorcentajeDesplazamientoBaseV1RepositoryCustom
            .getSqlCalcular(algoritmo);
        assertEquals(SQL_BASE, result);

    }

}
