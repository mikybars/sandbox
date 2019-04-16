package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoImporteVentaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

@Repository
public class TareaLocalizacionAbiertaRepositoryCustomImpl implements TareaLocalizacionAbiertaRepositoryCustom {


    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");
 
    private static final String ID_TIPO_IMPORTE_VENTA_NUEVO = "idTipoImporteVentaNuevo";
    private static final String ID_TIPO_IMPORTE_VENTA = "idTipoImporteVenta";
    private static final String FECHA_INICIO = "fechaInicio";
    private static final String FECHA_FIN = "fechaFin";
    private static final String ID_TAREA = "idTarea";
    private static final String MULTIPLICADOR = "multiplicador";

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
        parameters.addValue(FECHA_INICIO, trabajoDto.getFechaInicioPeriodo().format(DATE_PATTERN));
        parameters.addValue(FECHA_FIN, trabajoDto.getFechaFinPeriodo().format(DATE_PATTERN));
        parameters.addValue(ID_TAREA, tareaDto.getId());
        
        namedParameterJdbcTemplate.update(sqlSaveAbierto, parameters);
    }
    
    @Override
    public void trasladar(@NotNull TareaDto tareaDto, @NotNull List<Long> idTipoImporteVenta) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(ID_TAREA, tareaDto.getId());
        parameters.addValue(ID_TIPO_IMPORTE_VENTA, idTipoImporteVenta);
        parameters.addValue(ID_TIPO_IMPORTE_VENTA_NUEVO, TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_TRASLADADA.getId());
        parameters.addValue(MULTIPLICADOR, 1);

        namedParameterJdbcTemplate.update(sqlTrasladarDestino, parameters);
    }
    
    @Override
    public void compensar(@NotNull TareaDto tareaDto, @NotNull List<Long> idTipoImporteVenta) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(ID_TAREA, tareaDto.getId());
        parameters.addValue(ID_TIPO_IMPORTE_VENTA, idTipoImporteVenta);
        parameters.addValue(ID_TIPO_IMPORTE_VENTA_NUEVO, TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_COMPENSADA.getId());
        parameters.addValue(MULTIPLICADOR, -1);

        namedParameterJdbcTemplate.update(sqlTrasladarActual, parameters);
    }
    
    @Override
    public void saveCerrado(@NotNull TareaDto tareaDto, TrabajoDto trabajoDto, @NotNull List<Long> idTipoImporteVenta) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(FECHA_INICIO, trabajoDto.getFechaInicioPeriodo().format(DATE_PATTERN));
        parameters.addValue(FECHA_FIN, trabajoDto.getFechaFinPeriodo().format(DATE_PATTERN));
        parameters.addValue(ID_TAREA, tareaDto.getId());
        parameters.addValue(ID_TIPO_IMPORTE_VENTA, idTipoImporteVenta);
        
        namedParameterJdbcTemplate.update(sqlSaveCerrado, parameters);
    }
}
