package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionVenta;
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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaAgrupacionVentaRepositoryCustomImplTest {

    @Mock
    private JdbcTemplate template;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private TareaAgrupacionVentaRepositoryCustomImpl tareaAgrupacionVentaRepositoryCustom;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> params;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaAgrupacionVentaRepositoryCustom, "sqlSave", "", true);
        FieldUtils.writeField(tareaAgrupacionVentaRepositoryCustom, "sqlUpdateActivo", "", true);
        FieldUtils.writeField(tareaAgrupacionVentaRepositoryCustom, "batchSize", 100, true);
    }

    @Test
    public void saveTest() {

        List<TareaAgrupacionVenta> items = new ArrayList<>();
        items.add(mock(TareaAgrupacionVenta.class));

        tareaAgrupacionVentaRepositoryCustom.save(items);
        verify(template).batchUpdate(any(String.class), any(BatchPreparedStatementSetter.class));

    }

    @Test
    public void setParametersTest() throws SQLException {

        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(809L);
        TareaAgrupacionVenta tav = mock(TareaAgrupacionVenta.class);
        when(tav.getTarea()).thenReturn(tarea);
        when(tav.getIcmIdAgrupacionOnline()).thenReturn(30489L);
        when(tav.getFecha()).thenReturn(TimeUtils.nowDate());
        when(tav.getCclIdSeccion()).thenReturn("4934893");
        when(tav.getCclIdOrigen()).thenReturn("8989");
        when(tav.getImporteConImpuestos()).thenReturn(BigDecimal.valueOf(9090L));
        when(tav.getImporteSinImpuestos()).thenReturn(BigDecimal.valueOf(1981112L));
        TipoDato tipo = mock(TipoDato.class);
        when(tipo.getId()).thenReturn(101);
        when(tav.getTipoDato()).thenReturn(tipo);
        PreparedStatement pstmt = mock(PreparedStatement.class);

        tareaAgrupacionVentaRepositoryCustom.setParameters(pstmt, tav);
        verify(pstmt, times(1)).setObject(1, tav.getFecha());
        verify(pstmt, times(1)).setLong(2, tav.getIcmIdAgrupacionOnline());
        verify(pstmt, times(1)).setLong(3, tarea.getId());
        verify(pstmt, times(1)).setLong(4, tipo.getId());
        verify(pstmt, times(1)).setString(5, tav.getCclIdSeccion());
        verify(pstmt, times(1)).setString(6, tav.getCclIdOrigen());
        verify(pstmt, times(1)).setBigDecimal(7, tav.getImporteSinImpuestos());
        verify(pstmt, times(1)).setBigDecimal(8, tav.getImporteConImpuestos());
        verify(pstmt, times(1)).setBoolean(9, tav.getActivo());

    }

    @Test
    public void updateActivoTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(1234L);

        tareaAgrupacionVentaRepositoryCustom.updateActivo(tarea);
        verify(namedParameterJdbcTemplate, times(1)).update(any(String.class), params.capture());
        // parametros de la consulta: idTarea, idTipoImporteVenta, porcentajeInclusion, nuevoActivo
        assertEquals(4, params.getValue().getValues().size());
        // idTarea
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // idTipoImporte
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_AGRUPACIONONLINE.getId(),
            params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA));
        // porcentaje inclusion
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO,
            params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION));
        // nuevo activo
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
            params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));

    }

}
