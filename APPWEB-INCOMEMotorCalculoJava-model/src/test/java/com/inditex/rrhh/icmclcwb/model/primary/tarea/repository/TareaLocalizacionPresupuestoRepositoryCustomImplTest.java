package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuesto;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionPresupuestoRepositoryCustomImplTest {

    private final static String SQL_SAVE = "SQL SAVE";

    @Mock
    private JdbcTemplate template;

    @InjectMocks
    private TareaLocalizacionLocalizacionPresupuestoRepositoryCustomImpl tareaPresupuestoRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sql;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaPresupuestoRepositoryCustom, "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(tareaPresupuestoRepositoryCustom, "batchSize", 100, true);
    }

    //TODO [JAVIEREV] Reactivar test
    @Ignore
    @Test
    public void saveTest() {

        List<TareaLocalizacionPresupuesto> items = Collections.singletonList(mock(TareaLocalizacionPresupuesto.class));

        tareaPresupuestoRepositoryCustom.save(items);
        verify(template).batchUpdate(sql.capture(), any(BatchPreparedStatementSetter.class));

        assertEquals(SQL_SAVE, sql.getValue());

    }

    //TODO [JAVIEREV] Reactivar test
    @Ignore
    @Test
    public void setParametersTest() throws SQLException {

        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(809L);
        TareaLocalizacionPresupuesto presupuesto = mock(TareaLocalizacionPresupuesto.class);
        when(presupuesto.getTarea()).thenReturn(tarea);
        when(presupuesto.getCclIdOrigen()).thenReturn("ORIGEN");
        when(presupuesto.getStdIdLegEnt()).thenReturn("STD_LEG_ENT");
        when(presupuesto.getStdIdWorkLocat()).thenReturn("STD_ID_WORK_LOCAT");
        when(presupuesto.getCclIdCodOrigen()).thenReturn("CCL_ID_COD_ORIGEN");
        when(presupuesto.getCclIdSeccion()).thenReturn("SECCION");
        when(presupuesto.getFechaInicio()).thenReturn(TimeUtils.nowDate());
        when(presupuesto.getFechaFin()).thenReturn(TimeUtils.nowDate());
        when(presupuesto.getImporteConImpuestos()).thenReturn(1234.1);
        when(presupuesto.getImporteSinImpuestos()).thenReturn(1222.1);
        when(presupuesto.getBanda()).thenReturn(11);
        when(presupuesto.getOrdinal()).thenReturn(43);
        when(presupuesto.getExcepcion()).thenReturn(Boolean.FALSE);
        when(presupuesto.getIdTpPresupuesto()).thenReturn("TP PRESUPUESTO");
        when(presupuesto.getActivo()).thenReturn(Boolean.FALSE);
        PreparedStatement pstmt = mock(PreparedStatement.class);

        tareaPresupuestoRepositoryCustom.setParameters(pstmt, presupuesto);
        verify(pstmt, times(1)).setLong(1, tarea.getId());
        verify(pstmt, times(1)).setString(2, presupuesto.getCclIdOrigen());
        verify(pstmt, times(1)).setString(3, presupuesto.getStdIdLegEnt());
        verify(pstmt, times(1)).setString(4, presupuesto.getCclIdCodOrigen());
        verify(pstmt, times(1)).setString(5, presupuesto.getStdIdWorkLocat());
        verify(pstmt, times(1)).setString(6, presupuesto.getCclIdSeccion());
        verify(pstmt, times(1)).setObject(7, presupuesto.getFechaInicio());
        verify(pstmt, times(1)).setObject(8, presupuesto.getFechaFin());
        verify(pstmt, times(1)).setDouble(9, presupuesto.getImporteSinImpuestos());
        verify(pstmt, times(1)).setDouble(10, presupuesto.getImporteConImpuestos());
        verify(pstmt, times(1)).setInt(11, presupuesto.getBanda());
        verify(pstmt, times(1)).setInt(12, presupuesto.getOrdinal());
        verify(pstmt, times(1)).setBoolean(13, presupuesto.getExcepcion());
        verify(pstmt, times(1)).setString(14, presupuesto.getIdTpPresupuesto());
        verify(pstmt, times(1)).setBoolean(15, presupuesto.getExcepcion());

    }
}
