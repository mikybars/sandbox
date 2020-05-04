package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaCoeficiente;
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
public class TareaPersonaCoeficienteRepositoryCustomImplTest {

    private static final String SQL_SAVE = "SQL SAVE";

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private TareaPersonaCoeficienteRepositoryCustomImpl tareaPersonaCoeficienteRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaPersonaCoeficienteRepositoryCustom,
                "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(tareaPersonaCoeficienteRepositoryCustom,
                "batchSize", 100, true);
    }

    @Test
    public void setParametersTest() throws SQLException {

        PreparedStatement pstmt = mock(PreparedStatement.class);
        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(900L);
        TareaPersonaCoeficiente entity = mock(TareaPersonaCoeficiente.class);
        when(entity.getTarea()).thenReturn(tarea);
        when(entity.getCoeficiente()).thenReturn(8900);
        when(entity.getStdIdHr()).thenReturn("STD_ID_HR");
        when(entity.getCclIdPerson()).thenReturn("CCL_ID_PERSON");
        when(entity.getStdOrHrPeriod()).thenReturn("STD_OR_HR_PERIOD");
        when(entity.getFechaInicioPar()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));
        when(entity.getFechaFinPar()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 12, 1)));
        when(entity.getFechaInicioCom()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));
        when(entity.getFechaFinCom()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 12, 1)));

        tareaPersonaCoeficienteRepositoryCustom.setParameters(pstmt, entity);

        // Parámetros de la consulta: coeficiente, stdIdHr, cclIdPerson, stdOrHrPeriod, fechaInicioPar,
        // fechaFinPar, fechaInicioCom, fechaFinCom, idTarea
        verify(pstmt, times(1)).setObject(1, entity.getCoeficiente());
        verify(pstmt, times(1)).setString(2, entity.getStdIdHr());
        verify(pstmt, times(1)).setString(3, entity.getCclIdPerson());
        verify(pstmt, times(1)).setString(4, entity.getStdOrHrPeriod());
        verify(pstmt, times(1)).setObject(5, entity.getFechaInicioPar());
        verify(pstmt, times(1)).setObject(6, entity.getFechaFinPar());
        verify(pstmt, times(1)).setObject(7, entity.getFechaInicioCom());
        verify(pstmt, times(1)).setObject(8, entity.getFechaFinCom());
        verify(pstmt, times(1)).setLong(9, tarea.getId());

    }

    @Test
    public void saveTest() {
        List<TareaPersonaCoeficiente> items = Arrays.asList(mock(TareaPersonaCoeficiente.class));
        tareaPersonaCoeficienteRepositoryCustom.save(items);
        verify(jdbcTemplate).batchUpdate(sqlCaptor.capture(), any(BatchPreparedStatementSetter.class));
        assertEquals(SQL_SAVE, sqlCaptor.getValue());
    }

}
