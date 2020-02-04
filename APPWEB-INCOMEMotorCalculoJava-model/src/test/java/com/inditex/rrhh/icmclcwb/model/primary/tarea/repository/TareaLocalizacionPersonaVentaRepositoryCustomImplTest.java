package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVentaPk;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionPersonaVentaRepositoryCustomImplTest {

    private final static String SQL_SAVE = "SAVE";

    private final static String SQL_TOTALIZAR_VENTA_PERSONA_SECCION = "SQL_TOTALIZAR_VENTA_PERSONA_SECCION";

    private final static String SQL_TOTALIZAR_VENTA_PERSONA_LOCALIZACION = "SQL_TOTALIZAR_VENTA_PERSONA_LOCALIZACION";

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private TareaLocalizacionPersonaVentaRepositoryCustomImpl tareaLocalizacionPersonaVentaRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaLocalizacionPersonaVentaRepositoryCustom, "sqlTotalizarVentaPersonaSeccion", SQL_TOTALIZAR_VENTA_PERSONA_SECCION, true);
        FieldUtils.writeField(tareaLocalizacionPersonaVentaRepositoryCustom, "sqlTotalizarVentaPersonaLocalizacion", SQL_TOTALIZAR_VENTA_PERSONA_LOCALIZACION, true);
        FieldUtils.writeField(tareaLocalizacionPersonaVentaRepositoryCustom, "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(tareaLocalizacionPersonaVentaRepositoryCustom, "batchSize", 100, true);
    }

    @Test
    public void setParametersTest() throws SQLException {

        PreparedStatement pstmt = mock(PreparedStatement.class);
        TipoDato td = mock(TipoDato.class);
        when(td.getId()).thenReturn(89);
        Tarea tarea = mock(Tarea.class);
        TareaLocalizacionPersonaVentaPk pk = mock(TareaLocalizacionPersonaVentaPk.class);
         when(pk.getFechaInicioPeriodo()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));
        TareaLocalizacionPersonaVenta entity = mock(TareaLocalizacionPersonaVenta.class);
        when(entity.getTarea()).thenReturn(tarea);
        when(entity.getPk()).thenReturn(pk);
        when(entity.getTipoDato()).thenReturn(td);
        when(entity.getCclIdCodOrigen()).thenReturn("Id localización");
        when(entity.getCclIdPerson()).thenReturn("Id persona");
        when(entity.getImporteConImpuestos()).thenReturn(BigDecimal.valueOf(6789L));
        when(entity.getImporteSinImpuestos()).thenReturn(BigDecimal.valueOf(6711L));
        when(entity.getActivo()).thenReturn(Boolean.FALSE);
        when(entity.getCclIdCadena()).thenReturn("ZAR");
        when(entity.getCclIdSeccion()).thenReturn("CAB");

        tareaLocalizacionPersonaVentaRepositoryCustom.setParameters(pstmt, entity);

        // Parámetros de la consulta: fecha, cclIdCodOrigen, cclidPerson,
        // importeSinImpuestos, importeConImpuestos,
        // idTipoDato, idTarea

        verify(pstmt, times(1)).setObject(1, entity.getFecha());
        verify(pstmt, times(1)).setString(2, entity.getCclIdCodOrigen());
        verify(pstmt, times(1)).setString(3, entity.getCclIdPerson());
        verify(pstmt, times(1)).setBigDecimal(4, entity.getImporteSinImpuestos());
        verify(pstmt, times(1)).setBigDecimal(5, entity.getImporteConImpuestos());
        verify(pstmt, times(1)).setDouble(6, td.getId());
        verify(pstmt, times(1)).setLong(7, tarea.getId());
        verify(pstmt, times(1)).setObject(8, pk.getFechaInicioPeriodo());
        verify(pstmt, times(1)).setString(9, entity.getCclIdSeccion());
        verify(pstmt, times(1)).setString(10, entity.getCclIdCadena());
        verify(pstmt, times(1)).setBoolean(11, entity.getActivo());
    }

    @Test
    public void saveTest() {
        List<TareaLocalizacionPersonaVenta> items = Arrays.asList(mock(TareaLocalizacionPersonaVenta.class));
        tareaLocalizacionPersonaVentaRepositoryCustom.save(items);
        verify(jdbcTemplate).batchUpdate(sqlCaptor.capture(), any(BatchPreparedStatementSetter.class));
        assertEquals(SQL_SAVE, sqlCaptor.getValue());
    }

    @Test
    public void totalizarVentaPersonaSeccionTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9392L);

        tareaLocalizacionPersonaVentaRepositoryCustom.totalizarVentaPersonaSeccion(tarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_TOTALIZAR_VENTA_PERSONA_SECCION, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, idTarea, idTipoGrupoDato, activo
        assertEquals(5, params.getValues().size());
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.VENTA_INDIVIDUAL_LOCALIZACION_SECCION.getId(), params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // idTipoGrupoDato
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
        assertEquals(TipoGrupoDatoEnum.VENTA_INDIVIDUAL_LOCALIZACION.getId(), params.getValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    }

}
