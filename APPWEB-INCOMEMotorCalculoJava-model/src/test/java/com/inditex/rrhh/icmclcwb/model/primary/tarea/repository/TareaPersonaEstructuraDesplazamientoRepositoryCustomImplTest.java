package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoOpcionCalculo;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamiento;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Ignore;
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
public class TareaPersonaEstructuraDesplazamientoRepositoryCustomImplTest {

    private static final String SQL_SAVE = "SQL SAVE";

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private TareaPersonaEstructuraDesplazamientoRepositoryCustomImpl tareaPersonaEstructuraDesplazamientoRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaPersonaEstructuraDesplazamientoRepositoryCustom,
            "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(tareaPersonaEstructuraDesplazamientoRepositoryCustom,
            "batchSize", 100, true);
    }

    @Test
    @Ignore
    public void setParametersTest() throws SQLException {

        PreparedStatement pstmt = mock(PreparedStatement.class);
        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(900L);
        TipoOpcionCalculo opcionEstructura = mock(TipoOpcionCalculo.class);
        when(opcionEstructura.getId()).thenReturn(101);
        TipoOpcionCalculo opcionEfectiva = mock(TipoOpcionCalculo.class);
        when(opcionEfectiva.getId()).thenReturn(120);
        TareaPersonaEstructuraDesplazamiento entity = mock(TareaPersonaEstructuraDesplazamiento.class);
        when(entity.getTarea()).thenReturn(tarea);
        when(entity.getIcmIdEstrComision()).thenReturn("ICM_ID_ESTR_COMISION");
        when(entity.getOrdinalEstructura()).thenReturn(1919);
        when(entity.getFechaInicio()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));
        when(entity.getFechaFin()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 12, 1)));
        when(entity.getTipoOpcionCalculoEfectiva()).thenReturn(opcionEfectiva);
        when(entity.getTipoOpcionCalculoEstructura()).thenReturn(opcionEstructura);
        when(entity.getCclIdPuestoDestino()).thenReturn("CCL_ID_PUESTO_DESTINO");
        when(entity.getCclIdSeccionDestino()).thenReturn("CCL_ID_SECCION_DESTINO");
        when(entity.getCclIdCodOrigenDestino()).thenReturn("CCL_ID_COD_ORIGEN_DESTINO");
        when(entity.getStdIdWorkLocatDestino()).thenReturn("STD_ID_WORK_LOCAT_DESTINO");
        when(entity.getHorasDestino()).thenReturn(Boolean.FALSE);
        when(entity.getHorasOrigen()).thenReturn(Boolean.TRUE);

        tareaPersonaEstructuraDesplazamientoRepositoryCustom.setParameters(pstmt, entity);

        // Parámetros de la consulta: idTarea, icmIdEstrComision, ordinalEstructura, fechaInicio,
        // fechaFin, idtipoOpcionCalculoEstructura, idTipoOpcionCalculoEfectiva, icmIdTpCalculo,
        // icmIdPuestoDestino, cclIdSeccionDestino, cclIdCodOrigenDestino, valor, cclIdSeccionEfectiva,
        // cclIdSeccionEstructura, icmIdWlocDestino, esHorasOrigen, esHorasDestino, icmIdTpReqComision
        verify(pstmt, times(1)).setLong(1, tarea.getId());
        verify(pstmt, times(1)).setString(2, entity.getIcmIdEstrComision());
        verify(pstmt, times(1)).setInt(3, entity.getOrdinalEstructura());
        verify(pstmt, times(1)).setObject(4, entity.getFechaInicio());
        verify(pstmt, times(1)).setObject(5, entity.getFechaFin());
        verify(pstmt, times(1)).setInt(6, opcionEstructura.getId());
        verify(pstmt, times(1)).setInt(7, opcionEfectiva.getId());
        verify(pstmt, times(1)).setString(8, entity.getCclIdPuestoDestino());
        verify(pstmt, times(1)).setString(9, entity.getCclIdSeccionDestino());
        verify(pstmt, times(1)).setString(10, entity.getCclIdCodOrigenDestino());
        verify(pstmt, times(1)).setString(11, entity.getStdIdWorkLocatDestino());
        verify(pstmt, times(1)).setBoolean(12, entity.getHorasOrigen());
        verify(pstmt, times(1)).setBoolean(13, entity.getHorasDestino());
        verify(pstmt, times(1)).setString(14, entity.getIcmIdTpReqCom());

    }
    
    @Ignore
    @Test
    public void saveTest() {
        List<TareaPersonaEstructuraDesplazamiento> items = Arrays.asList(mock(TareaPersonaEstructuraDesplazamiento.class));
        tareaPersonaEstructuraDesplazamientoRepositoryCustom.save(items);
        verify(jdbcTemplate).batchUpdate(sqlCaptor.capture(), any(BatchPreparedStatementSetter.class));
        assertEquals(SQL_SAVE, sqlCaptor.getValue());
    }
}
