package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionComisionHistorico;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionComisionHistoricoRepositoryCustomImplTest {

    private static final String SQL_SAVE = "SAVE TEST";

    @Mock
    private JdbcTemplate template;

    @InjectMocks
    private TareaLocalizacionComisionHistoricoRepositoryCustomImpl tareaLocalizacionComisionHistoricoRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sql;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaLocalizacionComisionHistoricoRepositoryCustom, "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(tareaLocalizacionComisionHistoricoRepositoryCustom, "batchSize", 100, true);
    }

    @Test
    public void setParametersTest() throws SQLException {

        PreparedStatement pstmt = mock(PreparedStatement.class);
        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(900L);
        TareaLocalizacionComisionHistorico entity = mock(TareaLocalizacionComisionHistorico.class);
        when(entity.getTarea()).thenReturn(tarea);
        when(entity.getStdIdWorkLocat()).thenReturn("T90101");
        when(entity.getCclIdCodOrigen()).thenReturn("90101");
        when(entity.getComisionable()).thenReturn(Boolean.TRUE);
        when(entity.getFechaInicio()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));
        when(entity.getFechaFin()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 12, 1)));

        tareaLocalizacionComisionHistoricoRepositoryCustom.setParameters(pstmt, entity);
        verify(pstmt, times(1)).setObject(1, entity.getFechaFin());
        verify(pstmt, times(1)).setObject(2, entity.getFechaInicio());
        verify(pstmt, times(1)).setBoolean(3, entity.getComisionable());
        verify(pstmt, times(1)).setString(4, entity.getCclIdCodOrigen());
        verify(pstmt, times(1)).setString(5, entity.getStdIdWorkLocat());
        verify(pstmt, times(1)).setLong(6, tarea.getId());
    }

    @Test
    public void saveTest() {

        List<TareaLocalizacionComisionHistorico> entities = Arrays.asList(mock(TareaLocalizacionComisionHistorico.class));
        tareaLocalizacionComisionHistoricoRepositoryCustom.save(entities);
        verify(template, times(1)).batchUpdate(sql.capture(), any(BatchPreparedStatementSetter.class));
        assertEquals(SQL_SAVE, sql.getValue());

    }
}
