package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionVenta;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TareaAgrupacionVentaRepositoryCustomImplTest {

    private final static String SQL_SAVE = "SQL SAVE";

    @Mock
    private JdbcTemplate template;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private TareaAgrupacionVentaRepositoryCustomImpl tareaAgrupacionVentaRepositoryCustom;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> params;

    @Captor
    private ArgumentCaptor<String> sql;

    @BeforeEach
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(this.tareaAgrupacionVentaRepositoryCustom, "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(this.tareaAgrupacionVentaRepositoryCustom, "sqlUpdateActivo", "", true);
        FieldUtils.writeField(this.tareaAgrupacionVentaRepositoryCustom, "batchSize", 100, true);
    }

    @Test
    public void saveTest() {

        final List<TareaAgrupacionVenta> items = new ArrayList<>();
        items.add(mock(TareaAgrupacionVenta.class));

        this.tareaAgrupacionVentaRepositoryCustom.save(items);
        verify(this.namedParameterJdbcTemplate).batchUpdate(this.sql.capture(), any(SqlParameterSource[].class));

        assertEquals(SQL_SAVE, this.sql.getValue());

    }

    @Test
    public void updateActivoTest() {

        final TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(1234L);

        this.tareaAgrupacionVentaRepositoryCustom.updateActivo(tarea);
        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.params.capture());
        // parametros de la consulta: idTarea, idTipoImporteVenta, porcentajeInclusion, nuevoActivo
        assertEquals(4, this.params.getValue().getValues().size());
        // idTarea
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // idTipoImporte
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_AGRUPACIONONLINE.getId(),
                this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA));
        // porcentaje inclusion
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO,
                this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION));
        // nuevo activo
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
                this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
    }

}
