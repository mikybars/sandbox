package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarVentaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoGrupoEnum;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionCadenaRepositoryCustom;
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

    @Autowired
    private TareaAgrupacionCadenaRepositoryCustom tareaAgrupacionCadenaRepository;

    @Auditoria
    @Override
    public void ventaLocalizacionSeccion(@Valid RunTareaDto runTarea) {
        tareaTiendaVentaSeccionRepository.procesarVentasSeccion(runTarea.getTarea(),
                TipoDatoGrupoEnum.VENTA_LOCALIZACION_SECCION.getValue());
    }

    @Override
    public void ventaLocalizacionTienda(@Valid RunTareaDto runTarea) {
        tareaTiendaVentaRepository.procesar(runTarea.getTarea(), TipoDatoGrupoEnum.VENTA_LOCALIZACION.getValue());
    }

    @Override
    public void saveAbierto(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.saveAbierto(runTarea.getTarea(), runTarea.getTrabajo());
    }

    @Override
    public void saveCerrado(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.saveCerrado(runTarea.getTarea(), runTarea.getTrabajo(),
                TipoDatoGrupoEnum.VENTA_ONLINE.getValue());
    }

    @Override
    public void trasladar(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.trasladar(runTarea.getTarea(),
                TipoDatoGrupoEnum.VENTA_ONLINE.getValue());
    }

    @Override
    public void compensar(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.compensar(runTarea.getTarea(),
                TipoDatoGrupoEnum.VENTA_ONLINE.getValue());
    }

    @Auditoria
    @Override
    public void repartoVentaEntregaDomicilioAgrupaciones(@Valid RunTareaDto runTarea) {
        tareaTiendaVentaRepository.procesarRepartoEntregaDomicilioAgrupaciones(runTarea.getTarea());
    }

    @Auditoria
    @Override
    public void repartoVentaEntregaDomicilioPorPresenciaAgrupaciones(@Valid RunTareaDto runTarea) {
        tareaTiendaVentaRepository.procesarRepartoEntregaDomicilioPorPresenciaAgrupaciones(runTarea.getTarea());
    }

    @Auditoria
    @Override
    public void repartoVentaEntregaDomicilioSeccion(@Valid RunTareaDto runTarea) {
        tareaTiendaVentaSeccionRepository.procesarRepartoEntregaDomicilio(runTarea.getTarea());
    }
}
