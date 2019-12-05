package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
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

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVentaPk;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionPersonaVentaRepositoryCustomImplTest {

    private final static String SQL_SAVE = "SAVE";

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private TareaLocalizacionPersonaVentaRepositoryCustomImpl tareaLocalizacionPersonaVentaRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaLocalizacionPersonaVentaRepositoryCustom, "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(tareaLocalizacionPersonaVentaRepositoryCustom, "batchSize", 100, true);
    }

    @Test
    public void setParametersTest() throws SQLException {

        PreparedStatement pstmt = mock(PreparedStatement.class);
        TipoDato td = mock(TipoDato.class);
        when(td.getId()).thenReturn(89);
        Tarea tarea = mock(Tarea.class);
        TareaLocalizacionPersonaVentaPk pk = mock(TareaLocalizacionPersonaVentaPk.class);
         when(pk.getFechaInicioPeriodo()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));
        TareaLocalizacionPersonaVenta entity = mock(TareaLocalizacionPersonaVenta.class);
        when(entity.getTarea()).thenReturn(tarea);
//        when(entity.getPk()).thenReturn(pk);
        when(entity.getTipoDato()).thenReturn(td);
        when(entity.getCclIdCodOrigen()).thenReturn("Id localización");
        when(entity.getCclIdPerson()).thenReturn("Id persona");
        when(entity.getImporteConImpuestos()).thenReturn(BigDecimal.valueOf(6789L));
        when(entity.getImporteSinImpuestos()).thenReturn(BigDecimal.valueOf(6711L));

        tareaLocalizacionPersonaVentaRepositoryCustom.setParameters(pstmt, entity);

        // Parámetros de la consulta: fecha, cclIdCodOrigen, cclidPerson,
        // importeSinImpuestos, importeConImpuestos,
        // idTipoDato, idTarea

        verify(pstmt, times(1)).setObject(1, entity.getFecha());
        verify(pstmt, times(1)).setString(2, entity.getCclIdCodOrigen());
        verify(pstmt, times(1)).setString(3, entity.getCclIdPerson());
        verify(pstmt, times(1)).setBigDecimal(4, entity.getImporteSinImpuestos());
        verify(pstmt, times(1)).setBigDecimal(5, entity.getImporteConImpuestos());
        verify(pstmt, times(1)).setDouble(6, td.getId());
        verify(pstmt, times(1)).setLong(7, tarea.getId());
        verify(pstmt, times(1)).setObject(10, pk.getFechaInicioPeriodo());
    }

    @Test
    public void saveTest() {
        List<TareaLocalizacionPersonaVenta> items = Arrays.asList(mock(TareaLocalizacionPersonaVenta.class));
        tareaLocalizacionPersonaVentaRepositoryCustom.save(items);
        verify(jdbcTemplate).batchUpdate(sqlCaptor.capture(), any(BatchPreparedStatementSetter.class));
        assertEquals(SQL_SAVE, sqlCaptor.getValue());
    }

}
