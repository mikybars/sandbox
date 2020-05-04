package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaDesplazamiento;
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
public class TareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustomImplTest {

    @Mock
    private JdbcTemplate template;

    @InjectMocks
    private TareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustomImpl tareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustom;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustom, "sqlSave", "", true);
        FieldUtils.writeField(tareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustom, "batchSize", 100,
                true);
    }

    @Test
    public void saveTest() {

        List<TareaAmbitoGlobalLocalizacionPersonaDesplazamiento> items = new ArrayList<>();
        items.add(mock(TareaAmbitoGlobalLocalizacionPersonaDesplazamiento.class));

        tareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustom.save(items);
        verify(template).batchUpdate(any(String.class), any(BatchPreparedStatementSetter.class));

    }

    @Test
    public void setParametersTest() throws SQLException {

        TareaAmbitoGlobalLocalizacionPersonaDesplazamiento taglpd = mock(
                TareaAmbitoGlobalLocalizacionPersonaDesplazamiento.class);
        when(taglpd.getCclIdOrigen()).thenReturn("90II9");
        when(taglpd.getCclIdPerson()).thenReturn("dfs98");
        when(taglpd.getStdIdLegEnt()).thenReturn("FDS90");
        when(taglpd.getStdIdWorkLocat()).thenReturn("AT930");
        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(234839L);
        when(taglpd.getTarea()).thenReturn(tarea);

        PreparedStatement pstmt = mock(PreparedStatement.class);

        tareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustom.setParameters(pstmt, taglpd);
        // parametros de la consulta: id locallzacion, id origen, id persona, id empresa, id tarea
        verify(pstmt, times(1)).setString(1, taglpd.getStdIdWorkLocat());
        verify(pstmt, times(1)).setString(2, taglpd.getCclIdOrigen());
        verify(pstmt, times(1)).setString(3, taglpd.getCclIdPerson());
        verify(pstmt, times(1)).setString(4, taglpd.getStdIdLegEnt());
        verify(pstmt, times(1)).setLong(5, tarea.getId());

    }

}
