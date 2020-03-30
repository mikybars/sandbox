package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustomTest {

    private final static String SQL_RELACIONAR_ESTRUCTURA_SIN_DESPLAZAMIENTO = "SQL RELACIONAR ESTRUCTURA SIN DESPLAZAMIENTO";
    private final static String SQL_RELACIONAR_ESTRUCTURA_DESPLAZAMIENTO = "SQL RELACIONAR ESTRUCTURA DESPLAZAMIENTO";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private TareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustomImpl tareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom, "sqlRelacionarEstructuraSinDesplazamiento", SQL_RELACIONAR_ESTRUCTURA_SIN_DESPLAZAMIENTO, true);
        FieldUtils.writeField(tareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom, "sqlRelacionarEstructuraDesplazamiento", SQL_RELACIONAR_ESTRUCTURA_DESPLAZAMIENTO, true);
    }

    @Test
    public void relacionarSinDesplazamientoTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(89348L);

        tareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom.relacionarEstructuraSinDesplazamiento(tarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_RELACIONAR_ESTRUCTURA_SIN_DESPLAZAMIENTO, sqlCaptor.getValue());

        //Parámetros de la consulta: idTarea, incluidoChallenge, tiposCalculo, tiposCalculoChallengeLocalizacion,
        // tiposCalculoChallengePrecioHora, activo
        MapSqlParameterSource params = paramsCaptor.getValue();
        assertEquals(6, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // incluidoChallenge
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INCLUIDO_CHALLENGE));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_INCLUIDO_CHALLENGE));
        // tiposCalculo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
        assertEquals(Arrays.asList(TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_PRECIO_HORA_SECCION.getId(),
            TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_IMPORTE_SECCION.getId()), params.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
        // tiposCalculoChallengeLocalizacion
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO_CHALLENGE_LOCALIZACION));
        assertEquals(Arrays.asList(TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId()),
            params.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO_CHALLENGE_LOCALIZACION));
        // tiposCalculoChallengePrecioHora
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO_CHALLENGE_PRECIO_HORA));
        assertEquals(Arrays.asList(TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_PRECIO_HORA_SECCION.getId()),
            params.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO_CHALLENGE_PRECIO_HORA));
        // activo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    }

    @Test
    public void relacionarDesplazamientoTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(89348L);

        tareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom.relacionarEstructuraDesplazamiento(tarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_RELACIONAR_ESTRUCTURA_DESPLAZAMIENTO, sqlCaptor.getValue());

        //Parámetros de la consulta: idTarea, incluidoChallenge, tiposCalculo, activo
        MapSqlParameterSource params = paramsCaptor.getValue();
        assertEquals(5, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // incluidoChallenge
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INCLUIDO_CHALLENGE));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_INCLUIDO_CHALLENGE));
        // tiposCalculo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
        assertEquals(Arrays.asList(TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_PRECIO_HORA_SECCION.getId(),
            TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_IMPORTE_SECCION.getId()), params.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
        // tiposCalculoChallengeLocalizacion
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO_CHALLENGE_LOCALIZACION));
        assertEquals(Arrays.asList(TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId()),
            params.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO_CHALLENGE_LOCALIZACION));
        // activo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    }

}
