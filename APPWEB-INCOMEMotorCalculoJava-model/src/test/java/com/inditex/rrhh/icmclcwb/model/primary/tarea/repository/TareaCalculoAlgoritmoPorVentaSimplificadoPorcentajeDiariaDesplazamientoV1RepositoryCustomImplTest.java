package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
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

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaCalculoAlgoritmoPorVentaSimplificadoPorcentajeDiariaDesplazamientoV1RepositoryCustomImplTest {

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
    private TareaCalculoAlgoritmoPorVentaSimplificadoPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl
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
//        when(algoritmo.getId()).thenReturn(1001);
        TareaDto tarea = mock(TareaDto.class);
//        when(tarea.getId()).thenReturn(101L);
        TareaCalculoPersonaDto persona1 = mock(TareaCalculoPersonaDto.class);
//        when(persona1.getCclIdPerson()).thenReturn("AT1001");
//        when(persona1.getStdOrHrPeriod()).thenReturn("01");

        Map<String, Object> result = tareaCalculoAlgoritmoPorVentaV1RepositoryCustom.getMapValues(algoritmo, tarea, persona1);

        //TODO [COMUN] Definir los parametros de la consulta para el cálculo PorVenta
        assertEquals(0, result.size());

    }

    @Test
    public void calcularTest() {

        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
//        when(algoritmo.getId()).thenReturn(1001);
        TareaDto tarea = mock(TareaDto.class);
//        when(tarea.getId()).thenReturn(101L);
        TareaCalculoPersonaDto persona1 = mock(TareaCalculoPersonaDto.class);
//        when(persona1.getCclIdPerson()).thenReturn("AT1001");
//        when(persona1.getStdOrHrPeriod()).thenReturn("01");
        TareaCalculoPersonaDto persona2 = mock(TareaCalculoPersonaDto.class);
//        when(persona2.getCclIdPerson()).thenReturn("AT1002");
//        when(persona2.getStdOrHrPeriod()).thenReturn("02");
        List<TareaCalculoPersonaDto> personas = Arrays.asList(persona1, persona2);

        tareaCalculoAlgoritmoPorVentaV1RepositoryCustom.calcular(algoritmo, tarea, personas);

        verify(namedParameterJdbcTemplate).batchUpdate(sqlCaptor.capture(), paramsCaptor.capture());
        //TODO [COMUN] Definir los parametros de la consulta para el cálculo PorVenta
        assertEquals(SQL_CALCULAR, sqlCaptor.getValue());
        MapSqlParameterSource[] values = paramsCaptor.getValue();
        //2 elementos, porque se envían dos personas
        assertEquals(2, values.length);
        for (int i = 0; i<values.length; i++) {
            MapSqlParameterSource value = values[i];
            assertEquals(0, value.getValues().size());
        }

    }

    @Test
    public void getSqlCalcularTest() {

        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
//        when(algoritmo.getId()).thenReturn(21);

        String result = tareaCalculoAlgoritmoPorVentaV1RepositoryCustom
            .getSqlCalcular(algoritmo);
        assertEquals(SQL_CALCULAR_BASE, result);

    }
}
