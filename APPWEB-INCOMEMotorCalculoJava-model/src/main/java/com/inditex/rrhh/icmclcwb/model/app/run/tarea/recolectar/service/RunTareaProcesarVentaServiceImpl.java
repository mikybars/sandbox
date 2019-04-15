package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaProcesarVentaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoImporteVentaEnum;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionAbiertaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaVentaRepositoryProcesarCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaVentaSeccionRespositoryProcesarCustom;

@Service
@Validated
public class RunTareaProcesarVentaServiceImpl implements RunTareaProcesarVentaService {

    @Autowired
    private TareaTiendaVentaSeccionRespositoryProcesarCustom tareaTiendaVentaSeccionRepository;
    
    @Autowired
    private TareaTiendaVentaRepositoryProcesarCustom tareaTiendaVentaRepository;
    
    @Autowired
    private TareaLocalizacionAbiertaRepositoryCustom tareaLocalizacionAbiertaRepositoryCustom;
    
    @Auditoria
    @Override
    public void ventaLocalizacionSeccion(@Valid RunTareaDto runTarea) {
        
        //TODO obtener los tipos de importe relacionados con el de venta localizacion seccion en lugar de usar este listado
        List<Long> tipos = new ArrayList<>();
        tipos.add(TipoImporteVentaEnum.IMPORTE_VENTA_FISICA_LOCALIZACION_SECCION.getId());
        tipos.add(TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId());
        tipos.add(TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION_SECCION.getId());
        tipos.add(TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION_SECCION.getId());
        tipos.add(TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_PICKING_LOCALIZACION_SECCION.getId());
        
        tareaTiendaVentaSeccionRepository.procesar(runTarea.getTarea(), tipos);
    }

    @Override
    public void ventaLocalizacionTienda(@Valid RunTareaDto runTarea) {
        // TODO obtener los tipos de importe relacionados con el de venta localizacion seccion en lugar de usar este listado
        List<Long> tipos = new ArrayList<>();
        tipos.add(TipoImporteVentaEnum.IMPORTE_VENTA_FISICA_LOCALIZACION.getId());
        tipos.add(TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION.getId());
        tipos.add(TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION.getId());
        tipos.add(TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION.getId());
        tipos.add(TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_PICKING_LOCALIZACION.getId());
        
        
        tareaTiendaVentaRepository.procesar(runTarea.getTarea(), tipos);
    }
    
    @Override
    public void saveAbierto(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.saveAbierto(runTarea.getTarea(), runTarea.getTrabajo());
    }
    
    @Override
    public void saveCerrado(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.saveCerrado(runTarea.getTarea(), runTarea.getTrabajo());
    }
    
    @Override
    public void trasladar(@Valid RunTareaDto runTarea) {
//        tareaLocalizacionAbiertaRepositoryCustom.trasladar(runTarea.getTarea());
    }

}
