package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TareaCalculoAjusteMaximoGarantizadoRepositoryCustomImplTest {

    private final static String SQL_AJUSTAR_BASE = "SQL CALCULAR BASE";

    private final static String SQL_AJUSTAR = "SQL CALCULAR";

    @Mock
    private TareaCalculoPersonaService tareaCalculoPerosnaService;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource[]> params;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @InjectMocks
    private TareaCalculoAjusteMaximoGarantizadoRepositoryCustomImpl tareaCalculoAjusteMaximoGarantizadoRepositoryCustomImpl;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaCalculoAjusteMaximoGarantizadoRepositoryCustomImpl, "sqlAjustar", SQL_AJUSTAR, true);
        FieldUtils.writeField(tareaCalculoAjusteMaximoGarantizadoRepositoryCustomImpl, "sqlAjustarBase",
                SQL_AJUSTAR_BASE, true);
    }

    @Test
    public void idsTest() {
        TareaCalculoPersonaDto persona1 = mock(TareaCalculoPersonaDto.class);
        TareaCalculoPersonaDto persona2 = mock(TareaCalculoPersonaDto.class);
        List<TareaCalculoPersonaDto> personas = Arrays.asList(persona1, persona2);
        when(tareaCalculoPerosnaService.findByTareaAndIdEstadoAndIdTipoPolitica(any(TareaDto.class), any(String.class)))
            .thenReturn(personas);

        TareaDto tarea = mock(TareaDto.class);
        List<TareaCalculoPersonaDto> ids = tareaCalculoAjusteMaximoGarantizadoRepositoryCustomImpl.ids(tarea);

        assertEquals(personas, ids);
    }

    @Test
    public void getMapValuesTest() {
        AlgoritmoAjusteDto algoritmoAjuste = mock(AlgoritmoAjusteDto.class);
        when(algoritmoAjuste.getId()).thenReturn(11003);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(101L);
        TareaCalculoPersonaDto persona1 = mock(TareaCalculoPersonaDto.class);
        when(persona1.getCclIdPerson()).thenReturn("AT1001");
        when(persona1.getStdOrHrPeriod()).thenReturn("01");

        Map<String, Object> result = tareaCalculoAjusteMaximoGarantizadoRepositoryCustomImpl
            .getMapValues(algoritmoAjuste, tarea, persona1);
        assertEquals(7, result.size());

        // idTarea
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), result.get(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // cclIdPerson
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
        assertEquals(persona1.getCclIdPerson(), result.get(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
        // stdOrHrPeriod
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
        assertEquals(persona1.getStdOrHrPeriod(), result.get(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
        // idAlgoritmo
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO_AJUSTE));
        assertEquals(algoritmoAjuste.getId(), result.get(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO_AJUSTE));
        // idTipoPolitica
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.MAXIMO_GARANTIZADO.getId(),
                result.get(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
        // idTipoPoliticaAjuste
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE));
        assertEquals(
                Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD.getIdMeta4(), TipoPoliticaEnum.VACACIONES.getIdMeta4(),
                        TipoPoliticaEnum.BAJA_IT.getIdMeta4()),
                result.get(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE));
        // inactivo
        assertTrue(result.containsKey(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE, result.get(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
    }

}
