package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionOperacionPersona;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionOperacionPersonaPk;
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
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionOperacionPersonaRepositoryCustomImplTest {

    private static final String SQL_SAVE = "SQL SAVE";

    @Mock
    private JdbcTemplate template;

    @InjectMocks
    private TareaLocalizacionOperacionPersonaRepositoryCustomImpl tareaLocalizacionOperacionPersonaRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sql;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaLocalizacionOperacionPersonaRepositoryCustom, "batchSize", 100, true);
        FieldUtils.writeField(tareaLocalizacionOperacionPersonaRepositoryCustom, "sqlSave", SQL_SAVE, true);
    }

    @Test
    public void setParametersTest() throws SQLException {

        PreparedStatement pstmt = mock(PreparedStatement.class);
        TipoDato tipoDato = mock(TipoDato.class);
        when(tipoDato.getId()).thenReturn(TipoDatoEnum.OPERACION_VENTA_FISICA_LOCALIZACION_SECCION.getId());
        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(8989L);
        TareaLocalizacionOperacionPersonaPk pk = mock(TareaLocalizacionOperacionPersonaPk.class);
        when(pk.getFechaInicioPeriodo()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));
        TareaLocalizacionOperacionPersona entity = mock(TareaLocalizacionOperacionPersona.class);
        when(entity.getPk()).thenReturn(pk);
        when(entity.getTarea()).thenReturn(tarea);
        when(entity.getActivo()).thenReturn(Boolean.TRUE);
        when(entity.getCclIdCadena()).thenReturn("001");
        when(entity.getCclIdCodOrigen()).thenReturn("3114");
        when(entity.getCclIdPerson()).thenReturn("958");
        when(entity.getCclIdSeccion()).thenReturn("1");
        when(entity.getFecha()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 10)));
        when(entity.getImporteConImpuestos()).thenReturn(122.2);
        when(entity.getImporteSinImpuestos()).thenReturn(100.1);
        when(entity.getTipoDato()).thenReturn(tipoDato);

        tareaLocalizacionOperacionPersonaRepositoryCustom.setParameters(pstmt, entity);

        verify(pstmt, times(1)).setObject(1, pk.getFechaInicioPeriodo());
        verify(pstmt, times(1)).setLong(2, tarea.getId());
        verify(pstmt, times(1)).setString(3, entity.getCclIdPerson());
        verify(pstmt, times(1)).setString(4, entity.getCclIdCodOrigen());
        verify(pstmt, times(1)).setString(5, entity.getCclIdCadena());
        verify(pstmt, times(1)).setString(6, entity.getCclIdSeccion());
        verify(pstmt, times(1)).setDouble(7, entity.getImporteSinImpuestos());
        verify(pstmt, times(1)).setDouble(8, entity.getImporteConImpuestos());
        verify(pstmt, times(1)).setBoolean(9, entity.getActivo());
        verify(pstmt, times(1)).setInt(10, tipoDato.getId());
        verify(pstmt, times(1)).setObject(11, entity.getFecha());

    }

    @Test
    public void saveTest() {

        List<TareaLocalizacionOperacionPersona> entities = Collections.singletonList(mock(TareaLocalizacionOperacionPersona.class));
        tareaLocalizacionOperacionPersonaRepositoryCustom.save(entities);
        verify(template, times(1)).batchUpdate(sql.capture(), any(BatchPreparedStatementSetter.class));
        assertEquals(SQL_SAVE, sql.getValue());

    }

}
