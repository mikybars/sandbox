package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaPresenciaManual;
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
public class TareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustomImplTest {

    @Mock
    private JdbcTemplate template;

    @InjectMocks
    private TareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustomImpl tareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustom;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustom, "sqlSave", "", true);
        FieldUtils.writeField(tareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustom, "batchSize", 100, true);
    }

    @Test
    public void saveTest() {

        List<TareaAmbitoGlobalLocalizacionPersonaPresenciaManual> items = new ArrayList<>();
        items.add(mock(TareaAmbitoGlobalLocalizacionPersonaPresenciaManual.class));

        tareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustom.save(items);
        verify(template).batchUpdate(any(String.class), any(BatchPreparedStatementSetter.class));

    }

    @Test
    public void setParametersTest() throws SQLException {

        TareaAmbitoGlobalLocalizacionPersonaPresenciaManual taglppm = mock(TareaAmbitoGlobalLocalizacionPersonaPresenciaManual.class);
        when(taglppm.getCclIdOrigen()).thenReturn("90II9");
        when(taglppm.getCclIdPerson()).thenReturn("dfs98");
        when(taglppm.getStdIdLegEnt()).thenReturn("FDS90");
        when(taglppm.getStdIdWorkLocat()).thenReturn("AT930");
        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(234839L);
        when(taglppm.getTarea()).thenReturn(tarea);

        PreparedStatement pstmt = mock(PreparedStatement.class);

        tareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustom.setParameters(pstmt, taglppm);
        // parametros de la consulta: id locallzacion, id origen, id persona, id empresa, id tarea
        verify(pstmt, times(1)).setString(1, taglppm.getStdIdWorkLocat());
        verify(pstmt, times(1)).setString(2, taglppm.getCclIdOrigen());
        verify(pstmt, times(1)).setString(3, taglppm.getCclIdPerson());
        verify(pstmt, times(1)).setString(4, taglppm.getStdIdLegEnt());
        verify(pstmt, times(1)).setLong(5, tarea.getId());

    }
}
