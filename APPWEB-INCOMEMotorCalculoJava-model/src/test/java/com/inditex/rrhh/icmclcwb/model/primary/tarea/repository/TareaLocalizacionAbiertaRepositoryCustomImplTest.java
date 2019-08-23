package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionAbiertaRepositoryCustomImplTest {

    private static final String SQL_SAVE_ABIERTO = "SQL SAVE ABIERTO TEST";
    private static final String SQL_SAVE_CERRADO = "SQL SAVE CERRADO TEST";
    private static final String SQL_TRASLADAR_ACTUAL = "SQL TRASLADAR ACTUAL TEST";
    private static final String SQL_TRASLADAR_DESTINO = "SQL TRASLADAR DESTINO TEST";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private TareaLocalizacionAbiertaRepositoryCustomImpl tareaLocalizacionAbiertaRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sql;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> params;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaLocalizacionAbiertaRepositoryCustom, "sqlSaveAbierto", SQL_SAVE_ABIERTO, true);
        FieldUtils.writeField(tareaLocalizacionAbiertaRepositoryCustom, "sqlSaveCerrado", SQL_SAVE_CERRADO, true);
        FieldUtils.writeField(tareaLocalizacionAbiertaRepositoryCustom, "sqlTrasladarActual", SQL_TRASLADAR_ACTUAL, true);
        FieldUtils.writeField(tareaLocalizacionAbiertaRepositoryCustom, "sqlTrasladarDestino", SQL_TRASLADAR_DESTINO, true);
    }

    public void saveAbiertoTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(900L);
        TrabajoDto trabajo = mock(TrabajoDto.class);
        when(trabajo.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2015, 1, 1));
        when(trabajo.getFechaFinPeriodo()).thenReturn(LocalDate.of(2015, 12, 1));

        tareaLocalizacionAbiertaRepositoryCustom.saveAbierto(tarea, trabajo);
        verify(namedParameterJdbcTemplate, times(1)).update(sql.capture(), params.capture());
        assertEquals(SQL_SAVE_ABIERTO, sql.getValue());
        // parametros de la consulta: idTipoImporteVenta, idTipoPresencia, fechaInicio, fechaFin, idTarea, importe
        assertEquals(6, params.getValue().getValues().size());
        // idTipoImporteVenta
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TIPO_IMPORTE_VENTA));
        assertEquals(TipoDatoEnum.VENTA_FISICA_LOCALIZACION_SECCION.getId(),
            params.getValue().getValue(SQL_PARAM_ID_TIPO_IMPORTE_VENTA));
        // idTipoPresencia
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TIPO_MINUTOS));
        assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId(),
            params.getValue().getValue(SQL_PARAM_ID_TIPO_MINUTOS));
        // fechaInicio
        assertTrue(params.getValue().hasValue(SQL_PARAM_FECHA_INICIO));
        assertEquals(trabajo.getFechaInicioPeriodo(), params.getValue().getValue(SQL_PARAM_FECHA_INICIO));
        // fechaFin
        assertTrue(params.getValue().hasValue(SQL_PARAM_FECHA_FIN));
        assertEquals(trabajo.getFechaFinPeriodo(), params.getValue().getValue(SQL_PARAM_FECHA_FIN));
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue().getValue(SQL_PARAM_ID_TAREA));
        // importe
        assertTrue(params.getValue().hasValue(SQL_PARAM_IMPORTE));
        assertEquals(SQL_VALUE_IMPORTE_CERO, params.getValue().getValue(SQL_PARAM_IMPORTE));
    }

    @Test
    public void trasladarTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(900L);
        List<Integer> idTipoImporteVentas = Arrays.asList(2001, 2002);

        tareaLocalizacionAbiertaRepositoryCustom.trasladar(tarea, idTipoImporteVentas);
        verify(namedParameterJdbcTemplate, times(1)).update(sql.capture(), params.capture());
        assertEquals(SQL_TRASLADAR_DESTINO, sql.getValue());
        // parametros de la consulta: tiposDato, idTarea, cerrado, nuevoIdTipoDato, abierto
        // multiplicador, nuevoActivo
        assertEquals(7, params.getValue().getValues().size());
        // tiposDato
        assertTrue(params.getValue().hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(idTipoImporteVentas, params.getValue().getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue().getValue(SQL_PARAM_ID_TAREA));
        // cerrado
        assertTrue(params.getValue().hasValue(SQL_PARAM_CERRADO));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue().getValue(SQL_PARAM_CERRADO));
        // nuevoIdTipoDato
        assertTrue(params.getValue().hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_TRASLADADA.getId(), params.getValue().getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // abierto
        assertTrue(params.getValue().hasValue(SQL_PARAM_ABIERTO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue().getValue(SQL_PARAM_ABIERTO));
        // multiplicador
        assertTrue(params.getValue().hasValue(SQL_PARAM_MULTIPLICADOR));
        assertEquals(SQL_VALUE_MULTIPLICADOR_POSITIVO, params.getValue().getValue(SQL_PARAM_MULTIPLICADOR));
        // nuevoActivo
        assertTrue(params.getValue().hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue().getValue(SQL_PARAM_NUEVO_ACTIVO));
    }

    @Test
    public void compensarTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(900L);
        List<Integer> idTipoImporteVentas = Arrays.asList(2001, 2002);

        tareaLocalizacionAbiertaRepositoryCustom.compensar(tarea, idTipoImporteVentas);
        verify(namedParameterJdbcTemplate, times(1)).update(sql.capture(), params.capture());
        assertEquals(SQL_TRASLADAR_ACTUAL, sql.getValue());
        // parametros de la consulta: tiposDato, idTarea, cerrado, nuevoIdTipoDato, abierto
        // multiplicador, nuevoActivo
        assertEquals(7, params.getValue().getValues().size());
        // tiposDato
        assertTrue(params.getValue().hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(idTipoImporteVentas, params.getValue().getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue().getValue(SQL_PARAM_ID_TAREA));
        // cerrado
        assertTrue(params.getValue().hasValue(SQL_PARAM_CERRADO));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue().getValue(SQL_PARAM_CERRADO));
        // nuevoIdTipoDato
        assertTrue(params.getValue().hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_COMPENSADA.getId(), params.getValue().getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // abierto
        assertTrue(params.getValue().hasValue(SQL_PARAM_ABIERTO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue().getValue(SQL_PARAM_ABIERTO));
        // multiplicador
        assertTrue(params.getValue().hasValue(SQL_PARAM_MULTIPLICADOR));
        assertEquals(SQL_VALUE_MULTIPLICADOR_NEGATIVO, params.getValue().getValue(SQL_PARAM_MULTIPLICADOR));
        // nuevoActivo
        assertTrue(params.getValue().hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue().getValue(SQL_PARAM_NUEVO_ACTIVO));
    }

    @Test
    public void saveCerrado() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(6789L);
        TrabajoDto trabajo = mock(TrabajoDto.class);
        when(trabajo.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2015, 1, 1));
        when(trabajo.getFechaFinPeriodo()).thenReturn(LocalDate.of(2015, 12, 1));
        List<Integer> idTipoImporteVenta = Arrays.asList(9001, 9002);

        tareaLocalizacionAbiertaRepositoryCustom.saveCerrado(tarea, trabajo, idTipoImporteVenta);
        verify(namedParameterJdbcTemplate, times(1)).update(sql.capture(), params.capture());
        assertEquals(SQL_SAVE_CERRADO, sql.getValue());
        // parametros de la consulta: tiposDato, fechaInicio, fechaFin, idTarea, nuevoAbierto
        assertEquals(5, params.getValue().getValues().size());
        // tiposDato
        assertTrue(params.getValue().hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(idTipoImporteVenta, params.getValue().getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // fechaInicio
        assertTrue(params.getValue().hasValue(SQL_PARAM_FECHA_INICIO));
        assertEquals(TimeUtils.toDate(trabajo.getFechaInicioPeriodo()),
            params.getValue().getValue(SQL_PARAM_FECHA_INICIO));
        // fechaFin
        assertTrue(params.getValue().hasValue(SQL_PARAM_FECHA_FIN));
        assertEquals(TimeUtils.toDate(trabajo.getFechaFinPeriodo()),
            params.getValue().getValue(SQL_PARAM_FECHA_FIN));
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue().getValue(SQL_PARAM_ID_TAREA));
        // nuevoAbierto
        assertTrue(params.getValue().hasValue(SQL_PARAM_NUEVO_ABIERTO));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue().getValue(SQL_PARAM_NUEVO_ABIERTO));
    }

}
