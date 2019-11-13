package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.RunUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

@Repository
public class TareaLocalizacionAbiertaRepositoryCustomImpl implements TareaLocalizacionAbiertaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.saveAbierto']}")
    private String sqlSaveAbierto;
    
    @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.saveAbiertoSeccion']}")
    private String sqlSaveAbiertoSeccion;

    @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.saveCerrado']}")
    private String sqlSaveCerrado;
    
    @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.saveCerradoSeccion']}")
    private String sqlSaveCerradoSeccion;

    @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.trasladar']}")
    private String sqlTrasladar;

    @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.compensar']}")
    private String sqlCompensar;
    
    @Autowired
    @Qualifier(value = "recolectarProperties")
    private RecolectarPropertiesDto recolectarProperties;

    @Override
    public void saveAbierto(@NotNull TareaDto tareaDto, TrabajoDto trabajoDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO,
                TimeUtils.toDate(trabajoDto.getFechaInicioPeriodo()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN, RunUtils.addDays(trabajoDto.getFechaFinPeriodo(), recolectarProperties.getDaysNumber(), "yyyy-MM-dd"));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IMPORTE, SqlPrimaryConstants.SQL_VALUE_IMPORTE_CERO);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA,
                TipoDatoEnum.VENTA_FISICA_LOCALIZACION_SECCION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS,
                TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
        namedParameterJdbcTemplate.update(sqlSaveAbierto, parameters);
    }
    
    @Override
    public void saveAbiertoSeccion(@NotNull TareaDto tareaDto, TrabajoDto trabajoDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO,
                TimeUtils.toDate(trabajoDto.getFechaInicioPeriodo()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN, RunUtils.addDays(trabajoDto.getFechaFinPeriodo(), recolectarProperties.getDaysNumber(), "yyyy-MM-dd"));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IMPORTE, SqlPrimaryConstants.SQL_VALUE_IMPORTE_CERO);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA,
                TipoDatoEnum.VENTA_FISICA_LOCALIZACION_SECCION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS,
                TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId());
        namedParameterJdbcTemplate.update(sqlSaveAbiertoSeccion, parameters);
    }

    @Override
    public void trasladar(@NotNull TareaDto tareaDto, @NotNull List<Integer> idTipoImporteVenta) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, idTipoImporteVenta);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CERRADO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_IPOD_LOCALIZACION, TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_IPOD_LOCALIZACION_SECCION, TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_SINT_LOCALIZACION, TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_SINT_LOCALIZACION_SECCION, TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_TIENDA_LOCALIZACION, TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_TIENDA_LOCALIZACION_SECCION, TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION, TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION_SECCION, TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

        // valores a establecer
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_IPOD_LOCALIZACION_TRASLADADA, TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_TRASLADADA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_IPOD_LOCALIZACION_SECCION_TRASLADADA, TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION_TRASLADADA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_SINT_LOCALIZACION_TRASLADADA, TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_TRASLADADA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_SINT_LOCALIZACION_SECCION_TRASLADADA, TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION_TRASLADADA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_TIENDA_LOCALIZACION_TRASLADADA, TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_TRASLADADA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_TIENDA_LOCALIZACION_SECCION_TRASLADADA, TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION_TRASLADADA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION_TRASLADADA, TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_TRASLADADA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION_SECCION_TRASLADADA, TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION_TRASLADADA.getId());
        namedParameterJdbcTemplate.update(sqlTrasladar, parameters);
    }

    @Override
    public void compensar(@NotNull TareaDto tareaDto, @NotNull List<Integer> idTipoImporteVenta) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, idTipoImporteVenta);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CERRADO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        namedParameterJdbcTemplate.update(sqlCompensar, parameters);
    }

    @Override
    public void saveCerrado(@NotNull TareaDto tareaDto, TrabajoDto trabajoDto, @NotNull List<Integer> idTipoImporteVenta) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO,
                TimeUtils.toDate(trabajoDto.getFechaInicioPeriodo()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN, RunUtils.addDays(trabajoDto.getFechaFinPeriodo(), recolectarProperties.getDaysNumber(), "yyyy-MM-dd"));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, idTipoImporteVenta);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
        namedParameterJdbcTemplate.update(sqlSaveCerrado, parameters);
    }
    
    @Override
    public void saveCerradoSeccion(@NotNull TareaDto tareaDto, TrabajoDto trabajoDto, @NotNull List<Integer> idTipoImporteVenta) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO,
                TimeUtils.toDate(trabajoDto.getFechaInicioPeriodo()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN, RunUtils.addDays(trabajoDto.getFechaFinPeriodo(), recolectarProperties.getDaysNumber(), "yyyy-MM-dd"));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, idTipoImporteVenta);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        namedParameterJdbcTemplate.update(sqlSaveCerradoSeccion, parameters);
    }

}
