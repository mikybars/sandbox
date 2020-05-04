package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPresupuesto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConceptoChallenge;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracionChallengeDiasMinimos;

@RunWith(MockitoJUnitRunner.class)
public class TareaConfiguracionChallengeDiasMinimosRepositoryCustomImplTest {

    private final static String SQL_SAVE = "SQL SAVE";

    @Mock
    private JdbcTemplate template;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private TareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl tareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl, "batchSize", 100, true);
        FieldUtils.writeField(tareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl, "sqlSave", SQL_SAVE, true);
    }

    @Test
    public void save() {
        List<TareaConfiguracionChallengeDiasMinimos> items = Collections
            .singletonList(mock(TareaConfiguracionChallengeDiasMinimos.class));
        tareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl.save(items);
        verify(template).batchUpdate(sqlCaptor.capture(), any(BatchPreparedStatementSetter.class));
        assertEquals(SQL_SAVE, sqlCaptor.getValue());
    }


    @Test
    public void setParametersTest() throws SQLException {

        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(809L);
        TipoPresupuesto tipoPresupuesto = mock(TipoPresupuesto.class);
        tipoPresupuesto.setId(1);
        TipoDato tipoDato = mock(TipoDato.class);
        tipoDato.setId(1);
        TipoVentaConceptoChallenge tipoVentaConceptoChallenge = mock(TipoVentaConceptoChallenge.class);
        tipoVentaConceptoChallenge.setId(1L);
        TareaConfiguracionChallengeDiasMinimos presupuesto = mock(TareaConfiguracionChallengeDiasMinimos.class);
        when(presupuesto.getTarea()).thenReturn(tarea);
        when(presupuesto.getIcmIdTpCalculo()).thenReturn("1");
        when(presupuesto.getIcmMinNumDays()).thenReturn(1);
        when(presupuesto.getFechaInicio()).thenReturn(new Date());
        when(presupuesto.getFechaFin()).thenReturn(new Date());
        when(presupuesto.getCclIdOrigen()).thenReturn("CCL_ID_ORIGEN");

        PreparedStatement pstmt = mock(PreparedStatement.class);

        tareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl.setParameters(pstmt, presupuesto);
        verify(pstmt, times(1)).setLong(1, tarea.getId());
        verify(pstmt, times(1)).setString(2, presupuesto.getIcmIdTpCalculo());
        verify(pstmt, times(1)).setInt(3, presupuesto.getIcmMinNumDays());
        verify(pstmt, times(1)).setObject(4, presupuesto.getFechaInicio());
        verify(pstmt, times(1)).setObject(5, presupuesto.getFechaFin());
        verify(pstmt, times(1)).setString(6, presupuesto.getCclIdOrigen());

    }

}
