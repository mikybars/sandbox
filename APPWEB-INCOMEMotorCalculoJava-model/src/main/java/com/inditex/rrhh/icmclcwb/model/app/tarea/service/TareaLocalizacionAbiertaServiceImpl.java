package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.Arrays;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoImporteVentaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionAbiertaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionAbiertaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionAbiertaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionAbiertaServiceImpl implements TareaLocalizacionAbiertaService {

    @Autowired
    TareaLocalizacionAbiertaRepositoryCustom tareaLocalizacionAbiertaRepositoryCustom;
    
    @Autowired
    TareaLocalizacionAbiertaMapper tareaLocalizacionAbiertaMapper;
    
    @Override
    public void saveAbierto(@NotNull final TareaDto tareaDto, @NotNull final TrabajoDto trabajoDto) {
        tareaLocalizacionAbiertaRepositoryCustom.saveAbierto(tareaDto, trabajoDto);
    }
    
    @Override
    public void saveCerrado(@NotNull final TareaDto tareaDto, @NotNull final TrabajoDto trabajoDto) {
        tareaLocalizacionAbiertaRepositoryCustom.saveCerrado(tareaDto, trabajoDto, Arrays.asList(
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
    }
}
