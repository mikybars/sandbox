package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConcepto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionConfiguracion;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaAgrupacionConfiguracionRepositoryCustomImplTest {

    @Mock
    private JdbcTemplate template;

    @InjectMocks
    private TareaAgrupacionConfiguracionRepositoryCustomImpl tareaAgrupacionConfiguracionRepositoryCustom;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaAgrupacionConfiguracionRepositoryCustom, "sqlSave", "", true);
        FieldUtils.writeField(tareaAgrupacionConfiguracionRepositoryCustom, "batchSize", 100, true);
    }

    @Test
    public void mergePersonaLocalizacionTest() {

        List<TareaAgrupacionConfiguracion> items = new ArrayList<>();
        items.add(mock(TareaAgrupacionConfiguracion.class));

        tareaAgrupacionConfiguracionRepositoryCustom.save(items);
        verify(template).batchUpdate(any(String.class), any(BatchPreparedStatementSetter.class));

    }

    @Test
    public void setParametersTest() throws SQLException {

        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(12345L);
        TareaAgrupacionConfiguracion tac = mock(TareaAgrupacionConfiguracion.class);
        when(tac.getTarea()).thenReturn(tarea);
        when(tac.getIcmIdAgrupacionOnline()).thenReturn(900L);
        when(tac.getFechaInicio()).thenReturn(TimeUtils.nowDate());
        when(tac.getFechaFin()).thenReturn(TimeUtils.nowDate());
        when(tac.getCclIdOrigen()).thenReturn("38");
        when(tac.getPorcentajeInclusion()).thenReturn(BigDecimal.valueOf(87633L));
        TipoVentaConcepto tvc = mock(TipoVentaConcepto.class);
        when(tac.getTipoVentaConcepto()).thenReturn(tvc);
        when(tvc.getId()).thenReturn(899L);
        PreparedStatement pstmt = mock(PreparedStatement.class);

        tareaAgrupacionConfiguracionRepositoryCustom.setParameters(pstmt, tac);
        verify(pstmt, times(1)).setLong(1, tarea.getId());
        verify(pstmt, times(1)).setString(2, tac.getCclIdOrigen());
        verify(pstmt, times(1)).setLong(3, tac.getIcmIdAgrupacionOnline());
        verify(pstmt, times(1)).setObject(4, tac.getFechaInicio());
        verify(pstmt, times(1)).setObject(5, tac.getFechaFin());
        verify(pstmt, times(1)).setBigDecimal(6, tac.getPorcentajeInclusion());
        verify(pstmt, times(1)).setLong(7, tvc.getId());

    }

}
