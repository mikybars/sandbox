package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPolitica;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoUnidadTiempo;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPolitica;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPoliticaPk;
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
public class TareaPersonaEstructuraPoliticaRepositoryCustomImplTest {

    private static final String SQL_SAVE = "SQL_SAVE";

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private TareaPersonaEstructuraPoliticaRepositoryCustomImpl tareaPersonaEstructuraPoliticaRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaPersonaEstructuraPoliticaRepositoryCustom,
            "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(tareaPersonaEstructuraPoliticaRepositoryCustom,
            "batchSize", 100, true);
    }

    @Test
    public void setParametersTest() throws SQLException {

        PreparedStatement pstmt = mock(PreparedStatement.class);
        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(900L);
        TareaPersonaEstructuraPolitica entity = mock(TareaPersonaEstructuraPolitica.class);
        TipoPolitica tipoPolitica = mock(TipoPolitica.class);
        TipoUnidadTiempo tipoUnidadTiempo = mock(TipoUnidadTiempo.class);
        TareaPersonaEstructuraPoliticaPk pk = mock(TareaPersonaEstructuraPoliticaPk.class);
        when(pk.getFechaInicioPeriodo()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));
        when(tipoPolitica.getId()).thenReturn(1);
        when(tipoUnidadTiempo.getId()).thenReturn(1);
        when(entity.getPk()).thenReturn(pk);
        when(entity.getFechaInicio()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));
        when(entity.getFechaFin()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 12, 1)));
        when(entity.getStdIdHr()).thenReturn("STD_ID_HR");
        when(entity.getCclIdPerson()).thenReturn("CCL_ID_PERSON");
        when(entity.getIdEstructuraPolitica()).thenReturn("ICM_ID_ESTR_POLITICAS");
        when(entity.getTipoPolitica()).thenReturn(tipoPolitica);
        when(entity.getTipoUnidadTiempo()).thenReturn(tipoUnidadTiempo);
        when(entity.getStdOrHrPeriod()).thenReturn("STD_OR_HR_PERIOD");
        when(entity.getTarea()).thenReturn(tarea);
        when(entity.getCclIdOrigen()).thenReturn("CCL_ID_ORIGEN");
        when(entity.getExcluidoDenominador()).thenReturn(Boolean.TRUE);

        tareaPersonaEstructuraPoliticaRepositoryCustom.setParameters(pstmt, entity);

        // Parámetros de la consulta: fechaFin, fechaInicio, stdIdHr, cclIdPerson, icmIdEstrPoliticas,
        // idTipoPolitica, stdOrHrPeriod, idTarea, cclIdOrigen, excluidoDenominador
        verify(pstmt, times(1)).setObject(1, entity.getFechaFin());
        verify(pstmt, times(1)).setObject(2, entity.getFechaInicio());
        verify(pstmt, times(1)).setString(3, entity.getStdIdHr());
        verify(pstmt, times(1)).setString(4, entity.getCclIdPerson());
        verify(pstmt, times(1)).setString(5, entity.getIdEstructuraPolitica());
        verify(pstmt, times(1)).setLong(6, tipoPolitica.getId());
        verify(pstmt, times(1)).setString(7, entity.getStdOrHrPeriod());
        verify(pstmt, times(1)).setLong(8, tarea.getId());
        verify(pstmt, times(1)).setString(9, entity.getCclIdOrigen());
        verify(pstmt, times(1)).setBoolean(10, entity.getExcluidoDenominador());

    }

    @Test
    public void saveTest() {
        List<TareaPersonaEstructuraPolitica> items = Arrays.asList(mock(TareaPersonaEstructuraPolitica.class));
        tareaPersonaEstructuraPoliticaRepositoryCustom.save(items);
        verify(jdbcTemplate).batchUpdate(sqlCaptor.capture(), any(BatchPreparedStatementSetter.class));
        assertEquals(SQL_SAVE, sqlCaptor.getValue());
    }

}
