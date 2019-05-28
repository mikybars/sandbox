package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarVentaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionCadenaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionCadenaSeccionRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionAbiertaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionVentaRepositoryProcesarCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaVentaSeccionRespositoryProcesarCustom;

@Service
@Validated
public class RunTareaProcesarVentaServiceImpl implements RunTareaProcesarVentaService {

    @Autowired
    private TareaTiendaVentaSeccionRespositoryProcesarCustom tareaTiendaVentaSeccionRepository;

    @Autowired
    private TareaLocalizacionVentaRepositoryProcesarCustom tareaTiendaVentaRepository;

    @Autowired
    private TareaLocalizacionAbiertaRepositoryCustom tareaLocalizacionAbiertaRepositoryCustom;

    @Autowired
    private TareaAgrupacionCadenaRepositoryCustom tareaAgrupacionCadenaRepository;

    @Autowired
    private TareaAgrupacionCadenaSeccionRepositoryCustom tareaAgrupacionCadenaSeccionRepository;

    @Auditoria
    @Override
    public void ventaOnlineEntregaTiendaAgrupacionCadena(@Valid RunTareaDto runTarea) {
        tareaAgrupacionCadenaRepository.procesar(runTarea.getTarea(),
                TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_CADENA,
                TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_AGRUPACION_CADENA);
    }

    @Auditoria
    @Override
    public void ventaOnlineEntregaTiendaAgrupacionCadenaSeccion(@Valid RunTareaDto runTarea) {
        tareaAgrupacionCadenaSeccionRepository.procesar(runTarea.getTarea(),
                TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_CADENA_SECCION,
                TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_AGRUPACION_CADENA_SECCION);
    }

    @Auditoria
    @Override
    public void ventaFisicaAgrupacionCadena(@Valid RunTareaDto runTarea) {
        tareaAgrupacionCadenaRepository.procesar(runTarea.getTarea(), TipoDatoEnum.IMPORTE_VENTA_FISICA_CADENA,
                TipoDatoEnum.IMPORTE_VENTA_FISICA_AGRUPACION_CADENA);
    }

    @Auditoria
    @Override
    public void ventaFisicaAgrupacionCadenaSeccion(@Valid RunTareaDto runTarea) {
        tareaAgrupacionCadenaSeccionRepository.procesar(runTarea.getTarea(),
                TipoDatoEnum.IMPORTE_VENTA_FISICA_CADENA_SECCION,
                TipoDatoEnum.IMPORTE_VENTA_FISICA_AGRUPACION_CADENA_SECCION);
    }

    @Auditoria
    @Override
    public void ventaLocalizacionSeccion(@Valid RunTareaDto runTarea) {

        // TODO obtener los tipos de importe relacionados con el de venta localizacion
        // seccion en lugar de usar este listado
        List<Long> tipos = new ArrayList<>();
        tipos.add(TipoDatoEnum.IMPORTE_VENTA_FISICA_LOCALIZACION_SECCION.getId());
        tipos.add(TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId());
        tipos.add(TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION_SECCION.getId());
        tipos.add(TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION_SECCION.getId());
        tipos.add(TipoDatoEnum.IMPORTE_VENTA_ONLINE_PICKING_LOCALIZACION_SECCION.getId());

        tareaTiendaVentaSeccionRepository.procesar(runTarea.getTarea(), tipos);
    }

    @Override
    public void ventaLocalizacionTienda(@Valid RunTareaDto runTarea) {
        // TODO obtener los tipos de importe relacionados con el de venta localizacion
        // seccion en lugar de usar este listado
        List<Long> tipos = new ArrayList<>();
        tipos.add(TipoDatoEnum.IMPORTE_VENTA_FISICA_LOCALIZACION.getId());
        tipos.add(TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION.getId());
        tipos.add(TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION.getId());
        tipos.add(TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION.getId());
        tipos.add(TipoDatoEnum.IMPORTE_VENTA_ONLINE_PICKING_LOCALIZACION.getId());

        tareaTiendaVentaRepository.procesar(runTarea.getTarea(), tipos);
    }

    @Override
    public void saveAbierto(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.saveAbierto(runTarea.getTarea(), runTarea.getTrabajo());
    }

    @Override
    public void saveCerrado(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.saveCerrado(runTarea.getTarea(), runTarea.getTrabajo(),
                AppConstants.ID_TIPO_IMPORTE_VENTA_ONLINE);
    }

    @Override
    public void trasladar(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.trasladar(runTarea.getTarea(),
                AppConstants.ID_TIPO_IMPORTE_VENTA_ONLINE);
    }

    @Override
    public void compensar(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.compensar(runTarea.getTarea(),
                AppConstants.ID_TIPO_IMPORTE_VENTA_ONLINE);
    }

    @Auditoria
    @Override
    public void repartoVentaEntregaDomicilioAgrupaciones(@Valid RunTareaDto runTarea) {
        tareaTiendaVentaRepository.procesarRepartoEntregaDomicilioAgrupaciones(runTarea.getTarea());
    }

    @Auditoria
    @Override
    public void repartoVentaEntregaDomicilioCadenas(@Valid RunTareaDto runTarea) {
        tareaTiendaVentaRepository.procesarRepartoEntregaDomicilioCadenas(runTarea.getTarea());
    }

}
