package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
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
public class TareaLocalizacionVentaRespositoryProcesarCustomImpl
        implements TareaLocalizacionVentaRespositoryProcesarCustom {

    @Value("#{primaryQuery['RunTareaProcesarService.procesarVentaSeccion']}")
    private String sqlProcesarVentasSeccion;

    @Value("#{primaryQuery['TareaLocalizacionVentaSeccionRepositoryCustom.proceasrRepartoVentaEntregaDomicilio']}")
    private String sqlProcesarEntregaDomicilio;

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void procesarRepartoEntregaDomicilio(@NotNull TareaDto tareaDto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION_SECCION,
                TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION,
                TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_FISICA_LOCALIZACION_SECCION,
                TipoDatoEnum.VENTA_FISICA_LOCALIZACION_SECCION.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_FISICA_LOCALIZACION,
                TipoDatoEnum.VENTA_FISICA_LOCALIZACION.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        namedParameterJdbcTemplate.update(sqlProcesarEntregaDomicilio, params);
    }
}
