package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionVenta;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaAgrupacionVentaRepositoryCustomImplTest {

  private final static String SQL_SAVE = "SQL SAVE";

  private final static String SQL_UPDATE_ACTIVO = "SQL UPDATE ACTIVO";

  @Mock
  private JdbcTemplate template;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private TareaAgrupacionVentaRepositoryCustomImpl tareaAgrupacionVentaRepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaAgrupacionVentaRepositoryCustom, "sqlSave", SQL_SAVE, true);
    FieldUtils.writeField(this.tareaAgrupacionVentaRepositoryCustom, "sqlUpdateActivo", SQL_UPDATE_ACTIVO, true);
    FieldUtils.writeField(this.tareaAgrupacionVentaRepositoryCustom, "batchSize", 100, true);
  }

  @Test
  void saveTest() {

    final List<TareaAgrupacionVenta> items = new ArrayList<>();
    items.add(mock(TareaAgrupacionVenta.class));

    this.tareaAgrupacionVentaRepositoryCustom.save(items);
    verify(this.namedParameterJdbcTemplate).batchUpdate(eq(SQL_SAVE), any(SqlParameterSource[].class));

  }

  @Test
  void updateActivoTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(1234L);

    this.tareaAgrupacionVentaRepositoryCustom.updateActivo(tarea);

    final ArgumentCaptor<MapSqlParameterSource> paramsCaptor = ArgumentCaptor.forClass(MapSqlParameterSource.class);

    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_UPDATE_ACTIVO), paramsCaptor.capture());

    // parametros de la consulta: idTarea, idTipoImporteVenta, porcentajeInclusion, idTipoVentaConcepto, nuevoActivo
    final Map<String, Object> expected = new HashMap<>();
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA, TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_AGRUPACIONONLINE.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION, SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO);
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CONCEPTO_VENTA,
        Arrays.asList(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_VENTA.getId(),
            TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId()));
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);

    assertEquals(expected, paramsCaptor.getValue().getValues());
  }

}
