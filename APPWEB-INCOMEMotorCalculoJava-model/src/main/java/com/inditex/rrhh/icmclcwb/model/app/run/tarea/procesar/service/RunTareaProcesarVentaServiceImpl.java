package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarVentaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionAbiertaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionVentaRepositoryProcesarCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionVentaRespositoryProcesarCustom;

@Service
@Validated
public class RunTareaProcesarVentaServiceImpl implements RunTareaProcesarVentaService {

    @Autowired
    private TareaLocalizacionVentaRespositoryProcesarCustom tareaTiendaVentaSeccionRepository;

    @Autowired
    private TareaLocalizacionVentaRepositoryProcesarCustom tareaTiendaVentaRepository;

    @Autowired
    private TareaLocalizacionAbiertaRepositoryCustom tareaLocalizacionAbiertaRepositoryCustom;

    @Override
    public void saveAbierto(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.saveAbierto(runTarea.getTarea(), runTarea.getTrabajo());
    }

    @Override
    public void saveCerrado(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.saveCerrado(runTarea.getTarea(), runTarea.getTrabajo(),
                Arrays.asList(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId()));
    }

    @Override
    public void trasladar(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.trasladar(runTarea.getTarea(),
                Arrays.asList(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId()));
    }

    @Override
    public void compensar(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.compensar(runTarea.getTarea(),
                Arrays.asList(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId()));
    }

    @Override
    public void repartoVentaEntregaDomicilioAgrupaciones(@Valid RunTareaDto runTarea) {
        tareaTiendaVentaRepository.procesarRepartoEntregaDomicilioAgrupaciones(runTarea.getTarea());
    }

    @Override
    public void repartoVentaEntregaDomicilioPorPresenciaAgrupaciones(@Valid RunTareaDto runTarea) {
        tareaTiendaVentaRepository.procesarRepartoEntregaDomicilioPorPresenciaAgrupaciones(runTarea.getTarea());
    }

    @Override
    public void repartoVentaEntregaDomicilioSeccion(@Valid RunTareaDto runTarea) {
        tareaTiendaVentaSeccionRepository.procesarRepartoEntregaDomicilio(runTarea.getTarea());
    }

}
