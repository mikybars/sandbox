package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracion;
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

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaConfiguracionRepositoryCustomImplTest {

    private final static String SQL_SAVE = "SAVE";

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private TareaConfiguracionRepositoryCustomImpl tareaConfiguracionRepositoryCustom;

    @Captor
    ArgumentCaptor<String> sqlCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaConfiguracionRepositoryCustom, "batchSize", 1234, true);
        FieldUtils.writeField(tareaConfiguracionRepositoryCustom, "sqlSave", SQL_SAVE, true);
    }

    @Test
    public void setParametersTest() throws SQLException {

        PreparedStatement pstmt = mock(PreparedStatement.class);

        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(12345L);
        TareaConfiguracion entity = mock(TareaConfiguracion.class);
        when(entity.getTarea()).thenReturn(tarea);
        when(entity.getCclIdOrigen()).thenReturn("ID ORIGEN");
        when(entity.getFechaInicio()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));
        when(entity.getFechaFin()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 31)));
        when(entity.getCodTipoHora()).thenReturn(1);
        when(entity.getIcmCkVentaImpuestos()).thenReturn(Boolean.TRUE);

        tareaConfiguracionRepositoryCustom.setParameters(pstmt, entity);

        // Parámetros de la consulta: ID_TAREA, CCL_ID_ORIGEN, ICM_ID_CONFIG, FECHA_INICIO, FECHA_FIN,
        // ICM_ID_TP_HORA, ICM_CK_VENTA_IMPUESTOS
        verify(pstmt, times(1)).setLong(1, tarea.getId());
        verify(pstmt, times(1)).setString(2, entity.getCclIdOrigen());
        verify(pstmt, times(1)).setObject(3, entity.getFechaInicio());
        verify(pstmt, times(1)).setObject(4, entity.getFechaFin());
        verify(pstmt, times(1)).setInt(5, entity.getCodTipoHora());
        verify(pstmt, times(1)).setBoolean(6, entity.getIcmCkVentaImpuestos());

    }

    @Test
    public void saveTest() {

        List<TareaConfiguracion> items = Arrays.asList(mock(TareaConfiguracion.class));
        tareaConfiguracionRepositoryCustom.save(items);
        verify(jdbcTemplate).batchUpdate(sqlCaptor.capture(), any(BatchPreparedStatementSetter.class));
        assertEquals(SQL_SAVE, sqlCaptor.getValue());

    }

}
