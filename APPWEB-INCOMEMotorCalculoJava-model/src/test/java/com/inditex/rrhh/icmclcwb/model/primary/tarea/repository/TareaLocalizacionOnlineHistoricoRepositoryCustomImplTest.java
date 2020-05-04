package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionOnlineHistorico;
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
public class TareaLocalizacionOnlineHistoricoRepositoryCustomImplTest {

    private static final String SQL_SAVE = "UPDATE TAREA_LOCALIZACION_ONLINE_HISTORICO BLA BLA";

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private TareaLocalizacionOnlineHistoricoRepositoryCustomImpl tareaLocalizacionOnlineHistoricoRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sql;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaLocalizacionOnlineHistoricoRepositoryCustom,
                "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(tareaLocalizacionOnlineHistoricoRepositoryCustom,
                "batchSize", 100, true);
    }

    @Test
    public void setParametersTest() throws SQLException {
        PreparedStatement pstmt = mock(PreparedStatement.class);
        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(1920L);
        TareaLocalizacionOnlineHistorico entity = mock(TareaLocalizacionOnlineHistorico.class);
        when(entity.getTarea()).thenReturn(tarea);
        when(entity.getCclIdCadena()).thenReturn("Cadena");
        when(entity.getCclIdCodOrigen()).thenReturn("Id localización mtu");
        when(entity.getCclIdOrigen()).thenReturn("Id origen");
        when(entity.getStdIdLegEnt()).thenReturn("Id empresa");
        when(entity.getStdIdWorkLocat()).thenReturn("Id localización M4");
        when(entity.getFechaInicio()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));
        when(entity.getFechaFin()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 12, 1)));

        tareaLocalizacionOnlineHistoricoRepositoryCustom.setParameters(pstmt, entity);

        // Parametros de la consulta: id tarea, CclIdCodOrigen, StdIdWorkLocat, CclIdOrigen, StdIdLegEnt,
        // CclIdCadena, FechaInicio, FechaFin

        verify(pstmt, times(1)).setLong(1, tarea.getId());
        verify(pstmt, times(1)).setString(2, entity.getCclIdCodOrigen());
        verify(pstmt, times(1)).setString(3, entity.getStdIdWorkLocat());
        verify(pstmt, times(1)).setString(4, entity.getCclIdOrigen());
        verify(pstmt, times(1)).setString(5, entity.getStdIdLegEnt());
        verify(pstmt, times(1)).setString(6, entity.getCclIdCadena());
        verify(pstmt, times(1)).setObject(7, entity.getFechaInicio());
        verify(pstmt, times(1)).setObject(8, entity.getFechaFin());
    }

    @Test
    public void saveTest() {
        List<TareaLocalizacionOnlineHistorico> items = Arrays.asList(mock(TareaLocalizacionOnlineHistorico.class));
        tareaLocalizacionOnlineHistoricoRepositoryCustom.save(items);
        verify(jdbcTemplate, times(1)).batchUpdate(sql.capture(), any(BatchPreparedStatementSetter.class));
        assertEquals(SQL_SAVE, sql.getValue());
    }

}
