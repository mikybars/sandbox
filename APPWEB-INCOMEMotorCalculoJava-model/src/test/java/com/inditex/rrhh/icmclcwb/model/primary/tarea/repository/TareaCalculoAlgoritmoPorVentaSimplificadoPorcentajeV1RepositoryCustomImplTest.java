package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Assert;
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
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaCalculoAlgoritmoPorVentaSimplificadoPorcentajeV1RepositoryCustomImplTest {

    private final static String SQL_CALCULAR_BASE = "SQL CALCULAR BASE";

    private final static String SQL_CALCULAR = "SQL CALCULAR";

    @Mock
    private TareaCalculoPersonaService tareaCalculoPerosnaService;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource[]> paramsCaptor;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @InjectMocks
    private TareaCalculoAlgoritmoPorVentaSimplificadoPorcentajeV1RepositoryCustomImpl
        tareaCalculoAlgoritmoPorVentaV1RepositoryCustom;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaCalculoAlgoritmoPorVentaV1RepositoryCustom, "sqlCalcular", SQL_CALCULAR, true);
        FieldUtils.writeField(tareaCalculoAlgoritmoPorVentaV1RepositoryCustom, "sqlCalcularBase", SQL_CALCULAR_BASE, true);
    }

    @Test
    public void idsTest() {

        TareaCalculoPersonaDto persona1 = mock(TareaCalculoPersonaDto.class);
        TareaCalculoPersonaDto persona2 = mock(TareaCalculoPersonaDto.class);
        List<TareaCalculoPersonaDto> personas = Arrays.asList(persona1, persona2);
        when(tareaCalculoPerosnaService.findByAlgoritmo(any(TareaDto.class), any(AlgoritmoDto.class)))
            .thenReturn(personas);

        TareaDto tarea = mock(TareaDto.class);
        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);

        List<TareaCalculoPersonaDto> ids =
            tareaCalculoAlgoritmoPorVentaV1RepositoryCustom.ids(algoritmo, tarea);

        assertEquals(2, ids.size());
        assertEquals(personas, ids);
    }

    @Test
    public void getMapValuesTest() {

        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
        when(algoritmo.getId()).thenReturn(8001);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(101L);
        TareaCalculoPersonaDto persona1 = mock(TareaCalculoPersonaDto.class);
        when(persona1.getCclIdPerson()).thenReturn("AT1001");
        when(persona1.getStdOrHrPeriod()).thenReturn("01");

        Map<String, Object> result = tareaCalculoAlgoritmoPorVentaV1RepositoryCustom.getMapValues(algoritmo, tarea, persona1);

        //Parámetros de la consulta: activo, idTipoGrupoDato, tipoDatoLocalizacionVentaSeccion, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod,
        //comisionable, calcula
        assertEquals(9, result.size());
        //activo
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, result.get(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        //idTipoGrupoDato
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
        assertEquals(TipoGrupoDatoEnum.VENTA_LOCALIZACION_POR_VENTA.getId(), result.get(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
        //tipoDatoLocalizacionVentaSeccion
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
        assertEquals(TipoDatoEnum.VENTA_LOCALIZACION_EMPLEADOS_POR_VENTA_SIMPLIFICADO.getId(), result.get(SqlPrimaryConstants.SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
        //idAlgoritmo
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO));
        assertEquals(algoritmo.getId(), result.get(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO));
        //idTarea
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), result.get(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        //cclIdPerson
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
        assertEquals(persona1.getCclIdPerson(), result.get(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
        //stdOrHrPeriod
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
        assertEquals(persona1.getStdOrHrPeriod(), result.get(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
        //comisionable
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, result.get(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE));
        //calcula
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_CALCULA));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, result.get(SqlPrimaryConstants.SQL_PARAM_CALCULA));

    }

    @Test
    public void calcularTest() {

        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
        when(algoritmo.getId()).thenReturn(8001);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(101L);
        TareaCalculoPersonaDto persona1 = mock(TareaCalculoPersonaDto.class);
        when(persona1.getCclIdPerson()).thenReturn("AT1001");
        when(persona1.getStdOrHrPeriod()).thenReturn("01");
        TareaCalculoPersonaDto persona2 = mock(TareaCalculoPersonaDto.class);
        when(persona2.getCclIdPerson()).thenReturn("AT1002");
        when(persona2.getStdOrHrPeriod()).thenReturn("02");
        List<TareaCalculoPersonaDto> personas = Arrays.asList(persona1, persona2);

        tareaCalculoAlgoritmoPorVentaV1RepositoryCustom.calcular(algoritmo, tarea, personas);

        //Parámetros de la consulta: activo, idTipoGrupoDato, tipoDatoLocalizacionVentaSeccion, idAlgoritmo, idTarea, cclIdPerson, stdOrHrPeriod,
        //comisionable, calcula
        verify(namedParameterJdbcTemplate).batchUpdate(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_CALCULAR, sqlCaptor.getValue());
        MapSqlParameterSource[] values = paramsCaptor.getValue();
        //2 elementos, porque se envían dos personas
        assertEquals(2, values.length);
        for (int i = 0; i<values.length; i++) {
            MapSqlParameterSource value = values[i];
            assertEquals(9, value.getValues().size());
            // activo
            Assert.assertTrue(value.hasValue(SQL_PARAM_ACTIVO));
            assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_ACTIVO));
            // idTipoGrupoDato
            Assert.assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
            assertEquals(TipoGrupoDatoEnum.VENTA_LOCALIZACION_POR_VENTA.getId(), value.getValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
            // tipoDatoLocalizacionVentaSeccion
            Assert.assertTrue(value.hasValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
            assertEquals(TipoDatoEnum.VENTA_LOCALIZACION_EMPLEADOS_POR_VENTA_SIMPLIFICADO.getId(), value.getValue(SQL_PARAM_TIPO_DATO_LOCALIZACION_VENTA_SECCION));
            // idAlgoritmo
            Assert.assertTrue(value.hasValue(SQL_PARAM_ID_ALGORITMO));
            assertEquals(algoritmo.getId(), value.getValue(SQL_PARAM_ID_ALGORITMO));
            // idTarea
            Assert.assertTrue(value.hasValue(SQL_PARAM_ID_TAREA));
            assertEquals(tarea.getId(), value.getValue(SQL_PARAM_ID_TAREA));
            // comisionable
            Assert.assertTrue(value.hasValue(SQL_PARAM_COMISIONABLE));
            assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_COMISIONABLE));
            // calcula
            Assert.assertTrue(value.hasValue(SQL_PARAM_CALCULA));
            assertEquals(SQL_VALUE_BOOLEAN_TRUE, value.getValue(SQL_PARAM_CALCULA));
            // cclIdPerson, stdOrHrPeriod - existencia del parámetro
            Assert.assertTrue(value.hasValue(SQL_PARAM_CCL_ID_PERSON));
            Assert.assertTrue(value.hasValue(SQL_PARAM_STD_OR_HR_PERIOD));
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
        when(algoritmo.getId()).thenReturn(8001);

        String result = tareaCalculoAlgoritmoPorVentaV1RepositoryCustom
            .getSqlCalcular(algoritmo);
        assertEquals(SQL_CALCULAR_BASE, result);

    }
}
