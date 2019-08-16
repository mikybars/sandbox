package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TareaAgrupacionCadena;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaAgrupacionCadenaRepositoryCustomImplTest {

    @Mock
    private JdbcTemplate template;

    @InjectMocks
    private TareaAgrupacionCadenaRepositoryCustomImpl tareaAgrupacionCadenaRepositoryCustom;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaAgrupacionCadenaRepositoryCustom, "batchSize", 100, true);
        FieldUtils.writeField(tareaAgrupacionCadenaRepositoryCustom, "sqlSave", "", true);
    }

    @Test
    public void saveTest() {

        List<TareaAgrupacionCadena> items = new ArrayList<>();
        items.add(mock(TareaAgrupacionCadena.class));

        tareaAgrupacionCadenaRepositoryCustom.save(items);
        verify(template).batchUpdate(any(String.class), any(BatchPreparedStatementSetter.class));

    }


    @Test
    public void setParametersTest() throws SQLException {

        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(12345L);
        TareaAgrupacionCadena tac = mock(TareaAgrupacionCadena.class);
        when(tac.getTarea()).thenReturn(tarea);
        when(tac.getIcmIdAgrupacionOnline()).thenReturn(900L);
        when(tac.getCclIdCadena()).thenReturn("1");
        when(tac.getMultiple()).thenReturn(true);
        when(tac.getCclIdOrigen()).thenReturn("38");
        PreparedStatement pstmt = mock(PreparedStatement.class);

        tareaAgrupacionCadenaRepositoryCustom.setParameters(pstmt, tac);

        verify(pstmt, times(1)).setLong(1, tarea.getId());
        verify(pstmt, times(1)).setLong(2, tac.getIcmIdAgrupacionOnline());
        verify(pstmt, times(1)).setString(3, tac.getCclIdCadena());
        verify(pstmt, times(1)).setBoolean(4, tac.getMultiple());
        verify(pstmt, times(1)).setString(5, tac.getCclIdOrigen());
    }

}
