package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

@Repository
public class TareaLocalizacionVentaRepositoryProcesarCustomImpl
        implements TareaLocalizacionVentaRepositoryProcesarCustom {

    @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.procesarRepartoVentaEntregaDomicilioAgrupaciones']}")
    private String sqlProcesarEntregaDomicilioAgrupaciones;

    @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.procesarRepartoVentaEntregaDomicilioPresenciaAgrupaciones']}")
    private String sqlProcesarEntregaDomicilioPresenciaAgrupaciones;

    @Value("#{primaryQuery['RunTareaProcesarService.procesarVentaTienda']}")
    private String sql;

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void procesar(@NotNull TareaDto tareaDto, @NotNull List<Long> tipoImportes) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_SUMA,
                TipoDatoEnum.IMPORTE_VENTA_LOCALIZACION.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA, tipoImportes);
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public void procesarRepartoEntregaDomicilioAgrupaciones(@NotNull TareaDto tareaDto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_AGRUPACION,
                TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_AGRUPACION_CADENA.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION,
                TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_FISICA_LOCALIZACION,
                TipoDatoEnum.IMPORTE_VENTA_FISICA_LOCALIZACION.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_FISICA_AGRUPACION,
                TipoDatoEnum.IMPORTE_VENTA_FISICA_AGRUPACION_CADENA.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        namedParameterJdbcTemplate.update(sqlProcesarEntregaDomicilioAgrupaciones, params);
    }

    @Override
    public void procesarRepartoEntregaDomicilioPorPresenciaAgrupaciones(@NotNull TareaDto tareaDto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_AGRUPACION,
                TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_AGRUPACION_CADENA.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION,
                TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_FISICA_LOCALIZACION,
                TipoDatoEnum.IMPORTE_VENTA_FISICA_LOCALIZACION.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_FISICA_AGRUPACION,
                TipoDatoEnum.IMPORTE_VENTA_FISICA_AGRUPACION_CADENA.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS, TipoDatoEnum.MINUTOS_TOTALES.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        namedParameterJdbcTemplate.update(sqlProcesarEntregaDomicilioPresenciaAgrupaciones, params);
    }

}
