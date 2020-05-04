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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracionPrecioHora;

@RunWith(MockitoJUnitRunner.class)
public class TareaConfiguracionPrecioHoraRepositoryCustomImplTest {

    private final static String SQL_SAVE = "SQL SAVE";

    @Mock
    private JdbcTemplate template;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private TareaConfiguracionPrecioHoraRepositoryCustomImpl tareaConfiguracionPrecioHoraRepositoryCustomImpl;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaConfiguracionPrecioHoraRepositoryCustomImpl, "batchSize", 100, true);
        FieldUtils.writeField(tareaConfiguracionPrecioHoraRepositoryCustomImpl, "sqlSave", SQL_SAVE, true);
    }

    @Test
    public void save() {
        List<TareaConfiguracionPrecioHora> items = Collections.singletonList(mock(TareaConfiguracionPrecioHora.class));
        tareaConfiguracionPrecioHoraRepositoryCustomImpl.save(items);
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
        TareaConfiguracionPrecioHora presupuesto = mock(TareaConfiguracionPrecioHora.class);
        when(presupuesto.getTarea()).thenReturn(tarea);
        when(presupuesto.getIcmCkTpHoraComis()).thenReturn(Boolean.TRUE);
        when(presupuesto.getIcmCkTpHoraIncPtpo()).thenReturn(Boolean.TRUE);
        when(presupuesto.getFechaInicio()).thenReturn(new Date());
        when(presupuesto.getFechaFin()).thenReturn(new Date());
        when(presupuesto.getCclIdOrigen()).thenReturn("CCL_ID_ORIGEN");

        PreparedStatement pstmt = mock(PreparedStatement.class);

        tareaConfiguracionPrecioHoraRepositoryCustomImpl.setParameters(pstmt, presupuesto);
        verify(pstmt, times(1)).setLong(1, tarea.getId());
        verify(pstmt, times(1)).setBoolean(2, presupuesto.getIcmCkTpHoraComis());
        verify(pstmt, times(1)).setBoolean(3, presupuesto.getIcmCkTpHoraIncPtpo());
        verify(pstmt, times(1)).setObject(4, presupuesto.getFechaInicio());
        verify(pstmt, times(1)).setObject(5, presupuesto.getFechaFin());
        verify(pstmt, times(1)).setString(6, presupuesto.getCclIdOrigen());
    }

}
