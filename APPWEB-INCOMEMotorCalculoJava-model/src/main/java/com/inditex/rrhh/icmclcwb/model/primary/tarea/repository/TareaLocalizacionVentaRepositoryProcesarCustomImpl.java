package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
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

import java.util.stream.Collectors;

@Repository
public class TareaLocalizacionVentaRepositoryProcesarCustomImpl
        implements TareaLocalizacionVentaRepositoryProcesarCustom {

    @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.procesarRepartoVentaEntregaDomicilioAgrupaciones']}")
    private String sqlProcesarEntregaDomicilioAgrupaciones;

    @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.procesarRepartoVentaEntregaDomicilioPresenciaAgrupaciones']}")
    private String sqlProcesarEntregaDomicilioPresenciaAgrupaciones;

    @Autowired
    private TipoDatoService tipoDatoService;

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void procesarRepartoEntregaDomicilioAgrupaciones(@NotNull TareaDto tareaDto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_AGRUPACION,
                TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_AGRUPACIONONLINE.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
                TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_FISICA_LOCALIZACION,
                TipoDatoEnum.VENTA_FISICA_LOCALIZACION.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_FISICA_AGRUPACION,
                TipoDatoEnum.VENTA_FISICA_AGRUPACIONONLINE.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO,
                TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_VENTA.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, 1);
        params.addValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION, 0);
        namedParameterJdbcTemplate.update(sqlProcesarEntregaDomicilioAgrupaciones, params);
    }

    @Override
    public void procesarRepartoEntregaDomicilioPorPresenciaAgrupaciones(@NotNull TareaDto tareaDto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_AGRUPACION,
                TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_AGRUPACIONONLINE.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
                TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_FISICA_LOCALIZACION,
                TipoDatoEnum.VENTA_FISICA_LOCALIZACION.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_FISICA_AGRUPACION,
                TipoDatoEnum.VENTA_FISICA_AGRUPACIONONLINE.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS,
                TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_INCLUIDOECOMMERCE.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
            tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_LOCALIZACION.getId())
                .stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, 1);
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO,
                TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, 1);
        params.addValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION, 0);
        namedParameterJdbcTemplate.update(sqlProcesarEntregaDomicilioPresenciaAgrupaciones, params);
    }

}
