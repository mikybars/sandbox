package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaPresencia;
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
public class TareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustomImplTest {

    @Mock
    private JdbcTemplate template;

    @InjectMocks
    private TareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustomImpl tareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustom;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustom, "sqlSave", "", true);
        FieldUtils.writeField(tareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustom, "batchSize", 100, true);
    }

    @Test
    public void saveTest() {

        List<TareaAmbitoGlobalLocalizacionPersonaPresencia> items = new ArrayList<>();
        items.add(mock(TareaAmbitoGlobalLocalizacionPersonaPresencia.class));

        tareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustom.save(items);
        verify(template).batchUpdate(any(String.class), any(BatchPreparedStatementSetter.class));

    }

    @Test
    public void setParametersTest() throws SQLException {

        TareaAmbitoGlobalLocalizacionPersonaPresencia taglpp = mock(TareaAmbitoGlobalLocalizacionPersonaPresencia.class);
        when(taglpp.getCclIdOrigen()).thenReturn("90II9");
        when(taglpp.getCclIdPerson()).thenReturn("dfs98");
        when(taglpp.getStdIdLegEnt()).thenReturn("FDS90");
        when(taglpp.getCclIdCodOrigen()).thenReturn("AT930");
        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(234839L);
        when(taglpp.getTarea()).thenReturn(tarea);

        PreparedStatement pstmt = mock(PreparedStatement.class);

        tareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustom.setParameters(pstmt, taglpp);
        // parametros de la consulta: id locallzacion, id origen, id persona, id empresa, id tarea
        verify(pstmt, times(1)).setString(1, taglpp.getCclIdCodOrigen());
        verify(pstmt, times(1)).setString(2, taglpp.getCclIdOrigen());
        verify(pstmt, times(1)).setString(3, taglpp.getCclIdPerson());
        verify(pstmt, times(1)).setString(4, taglpp.getStdIdLegEnt());
        verify(pstmt, times(1)).setLong(5, tarea.getId());

    }

}
