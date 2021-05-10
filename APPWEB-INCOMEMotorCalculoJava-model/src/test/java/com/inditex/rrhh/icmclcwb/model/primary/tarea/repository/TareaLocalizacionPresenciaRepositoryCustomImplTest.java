package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
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

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionPresenciaRepositoryCustomImplTest {

    private final static String SQL_SAVE = "SAVE";

    private final static String SQL_COMPENSAR_LOCALIZACION_MANUAL = "COMPENSAR_LOCALIZACION_MANUAL";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Mock
    private TipoDatoService tipoDatoService;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private TareaLocalizacionPresenciaRepositoryCustomImpl tareaLocalizacionPresenciaRepositoryCustom;

    @Captor
    ArgumentCaptor<String> sqlCaptor;

    @Captor
    ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(this.tareaLocalizacionPresenciaRepositoryCustom, "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(this.tareaLocalizacionPresenciaRepositoryCustom, "sqlCompensarLocalizacionManual",
                SQL_COMPENSAR_LOCALIZACION_MANUAL,
                true);
    }

    @Test
    public void compensarLocalizacionManualTest() {

        final RunTareaDto runTarea = mock(RunTareaDto.class);
        final TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(199L);
        when(runTarea.getTarea()).thenReturn(tarea);

        this.tareaLocalizacionPresenciaRepositoryCustom.compensarLocalizacionManual(runTarea);
        verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
        assertEquals(SQL_COMPENSAR_LOCALIZACION_MANUAL, this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: idTarea, nuevoIdSeccion, nuevoIdTipoDato,
        // excluidoDenominador, idTipoPolitica, tiposDato, activo
        assertEquals(5, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // nuevoIdSeccion
        assertTrue(params.hasValue(SQL_PARAM_ID_SECCION));
        assertEquals(AppConstants.SECCION_4, params.getValue(SQL_PARAM_ID_SECCION));
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId(),
                params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // tiposDato
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(Arrays.asList(5018, 5002), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));

    }

}
