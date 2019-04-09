package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

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

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.saveAbierto']}")
    private String sqlSaveAbierto;
    
    @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.saveCerrado']}")
    private String sqlSaveCerrado;
    
    @Override
    public void saveAbierto(@NotNull TareaDto tareaDto, TrabajoDto trabajoDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("fechaInicio", trabajoDto.getFechaInicioPeriodo().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        parameters.addValue("fechaFin", trabajoDto.getFechaFinPeriodo().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        parameters.addValue("idTarea", tareaDto.getId());
        
        namedParameterJdbcTemplate.update(sqlSaveAbierto, parameters);
    }
    
    @Override
    public void saveCerrado(@NotNull TareaDto tareaDto, TrabajoDto trabajoDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("fechaInicio", trabajoDto.getFechaInicioPeriodo().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        parameters.addValue("fechaFin", trabajoDto.getFechaFinPeriodo().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        parameters.addValue("idTarea", tareaDto.getId());
        parameters.addValue("idTipoImporteVenta", Arrays.asList(
                TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION.getId(),
                TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION_SECCION.getId(),
                TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION.getId(),
                TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION_SECCION.getId(),
                TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION.getId(),
                TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION_PERSONA.getId(),
                TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_OPERACION_LOCALIZACION.getId(),
                TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION.getId(),
                TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(),
                TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_PICKING_LOCALIZACION.getId(),
                TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_PICKING_LOCALIZACION_SECCION.getId()
                ));
        
        namedParameterJdbcTemplate.update(sqlSaveCerrado, parameters);
    }
}
