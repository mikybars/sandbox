package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

@Repository
public class TareaLocalizacionAbiertaRepositoryCustomImpl implements TareaLocalizacionAbiertaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.saveAbierto']}")
    private String sqlSaveAbierto;

    @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.saveCerrado']}")
    private String sqlSaveCerrado;

    @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.trasladar']}")
    private String sqlTrasladar;

    @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.trasladar']} #{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.trasladar.actual']}")
    private String sqlTrasladarActual;

    @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.trasladar']} #{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.trasladar.destino']}")
    private String sqlTrasladarDestino;

    @Override
    public void saveAbierto(@NotNull TareaDto tareaDto, TrabajoDto trabajoDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO,
                TimeUtils.toDate(trabajoDto.getFechaInicioPeriodo()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN, TimeUtils.toDate(trabajoDto.getFechaFinPeriodo()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ABIERTO, 1);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IMPORTE, 0);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA,
            TipoDatoEnum.VENTA_FISICA_LOCALIZACION_SECCION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS,
            TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId());
        namedParameterJdbcTemplate.update(sqlSaveAbierto, parameters);
    }

    @Override
    public void trasladar(@NotNull TareaDto tareaDto, @NotNull List<Long> idTipoImporteVenta) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, idTipoImporteVenta);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
                TipoDatoEnum.VENTA_ONLINE_TRASLADADA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_MULTIPLICADOR, 1);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ABIERTO, 1);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CERRADO, 0);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, 1);
        namedParameterJdbcTemplate.update(sqlTrasladarDestino, parameters);
    }

    @Override
    public void compensar(@NotNull TareaDto tareaDto, @NotNull List<Long> idTipoImporteVenta) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, idTipoImporteVenta);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
                TipoDatoEnum.VENTA_ONLINE_COMPENSADA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_MULTIPLICADOR, -1);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ABIERTO, 1);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CERRADO, 0);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, 1);
        namedParameterJdbcTemplate.update(sqlTrasladarActual, parameters);
    }

    @Override
    public void saveCerrado(@NotNull TareaDto tareaDto, TrabajoDto trabajoDto, @NotNull List<Long> idTipoImporteVenta) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO,
                TimeUtils.toDate(trabajoDto.getFechaInicioPeriodo()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN, TimeUtils.toDate(trabajoDto.getFechaFinPeriodo()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, idTipoImporteVenta);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ABIERTO, 0);
        namedParameterJdbcTemplate.update(sqlSaveCerrado, parameters);
    }

}
