package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionFestivo;
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
public class TareaLocalizacionFestivoRepositoryCustomImplTest {

    private static final String SQL_SAVE = "SAVE TEST";

    @Mock
    private JdbcTemplate template;

    @InjectMocks
    private TareaLocalizacionFestivoRepositoryCustomImpl tareaLocalizacionFestivoRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sql;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaLocalizacionFestivoRepositoryCustom, "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(tareaLocalizacionFestivoRepositoryCustom, "batchSize", 100, true);
    }

    @Test
    public void setParametersTest() throws SQLException {

        PreparedStatement pstmt = mock(PreparedStatement.class);
        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(900L);
        TareaLocalizacionFestivo entity = mock(TareaLocalizacionFestivo.class);
        when(entity.getTarea()).thenReturn(tarea);
        when(entity.getStdIdWorkLocat()).thenReturn("T90101");
        when(entity.getFecha()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));

        tareaLocalizacionFestivoRepositoryCustom.setParameters(pstmt, entity);
        verify(pstmt, times(1)).setLong(1, tarea.getId());
        verify(pstmt, times(1)).setString(2, entity.getStdIdWorkLocat());
        verify(pstmt, times(1)).setObject(3, entity.getFecha());
    }

    @Test
    public void saveTest() {

        List<TareaLocalizacionFestivo> entities = Arrays.asList(mock(TareaLocalizacionFestivo.class));
        tareaLocalizacionFestivoRepositoryCustom.save(entities);
        verify(template, times(1)).batchUpdate(sql.capture(), any(BatchPreparedStatementSetter.class));
        assertEquals(SQL_SAVE, sql.getValue());

    }
    
}
