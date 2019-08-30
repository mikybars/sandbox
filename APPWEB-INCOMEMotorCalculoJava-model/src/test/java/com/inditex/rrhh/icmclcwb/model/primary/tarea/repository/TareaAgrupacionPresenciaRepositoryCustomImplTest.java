package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaAgrupacionPresenciaRepositoryCustomImplTest {

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private TareaAgrupacionPresenciaRepositoryCustomImpl tareaAgrupacionPresenciaRepositoryCustom;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> params;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaAgrupacionPresenciaRepositoryCustom, "sqlUpdateActivo", "", true);
        FieldUtils.writeField(tareaAgrupacionPresenciaRepositoryCustom, "sqlTotalizar", "", true);
    }

    @Test
    public void updateActivoTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(345089L);

        tareaAgrupacionPresenciaRepositoryCustom.updateActivo(tarea);
        // parametros de la consulta: idTarea, idTipoPresencia, idConcepto, porcentajeInclusion, nuevoActivo
        verify(namedParameterJdbcTemplate, times(1)).update(any(String.class), params.capture());
        assertEquals(5, params.getValue().getValues().size());
        // idTarea
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // idTipoPresencia
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS));
        assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId(), params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS));
        // idConcepto
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO));
        assertEquals(Arrays.asList(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId()), params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO));
        // porcentajeInclusion
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO, params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION));
        // nuevoActivo
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE, params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
    }


}
