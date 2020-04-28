package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarVentaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionAbiertaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaVentaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresupuestoVentaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionVentaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionVentaRepositoryProcesarCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionVentaRespositoryProcesarCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraPoliticaRepositoryCustom;

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
    private TareaLocalizacionVentaRepositoryCustom tareaLocalizacionVentaRepositoryCustom;
    
    @Autowired
    private TareaPersonaEstructuraPoliticaRepositoryCustom tareaPersonaEstructuraPoliticaRepositoryCustom;

    @Autowired
    private TareaLocalizacionPersonaVentaRepositoryCustom tareaLocalizacionPersonaVentaRepositoryCustom;
    
    @Autowired
    private TareaLocalizacionPresupuestoVentaRepositoryCustom tareaLocalizacionPresupuestoVentaRepositoryCustom;


    @Autowired
    private TipoDatoService tipoDatoService;

    @Override
    public void saveAbierto(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.saveAbierto(runTarea.getTarea(), runTarea.getTrabajo());
    }

    @Override
    public void saveAbiertoSeccion(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.saveAbiertoSeccion(runTarea.getTarea(), runTarea.getTrabajo());
    }
    
    @Override
    public void compensarOnlineSeccionCerrada(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.compensarOnlineSeccionCerrada(runTarea.getTarea(), runTarea.getTrabajo());
    }
    
    @Override
    public void saveCerrado(@Valid RunTareaDto runTarea) {
        List<IdTipoDatoDto> ids = tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_LOCALIZACION.getId());
        tareaLocalizacionAbiertaRepositoryCustom.saveCerrado(runTarea.getTarea(), runTarea.getTrabajo(),
                ids.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    }
    
    @Override
    public void saveCerradoSeccion(@Valid RunTareaDto runTarea) {
        List<IdTipoDatoDto> ids = tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_LOCALIZACION.getId());
        tareaLocalizacionAbiertaRepositoryCustom.saveCerradoSeccion(runTarea.getTarea(), runTarea.getTrabajo(),
                ids.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    }


    @Override
    public void trasladar(@Valid RunTareaDto runTarea) {
        List<IdTipoDatoDto> ids = tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_LOCALIZACION.getId());
        tareaLocalizacionAbiertaRepositoryCustom.trasladar(runTarea.getTarea(),
            ids.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    }

    @Override
    public void compensar(@Valid RunTareaDto runTarea) {
        List<IdTipoDatoDto> ids = tipoDatoService.findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_LOCALIZACION.getId());
        tareaLocalizacionAbiertaRepositoryCustom.compensar(runTarea.getTarea(),
            ids.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
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
    
    @Override
    public void updateActivoTrasladadas(@Valid RunTareaDto runTarea) {
        tareaLocalizacionVentaRepositoryCustom.updateActivoTrasladadas(runTarea.getTarea());
    }

    @Override
    public void updateActivoExcepcionada(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPresupuestoVentaRepositoryCustom.updateActivoExcepcionada(runTarea);
    }
    
    @Override
    public void updateActivoCongelada(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPresupuestoVentaRepositoryCustom.updateActivoCongelada(runTarea);
    }
    
    @Override
    public void totalizarPresupuesto(@Valid RunTareaDto runTarea) {
        tareaLocalizacionPresupuestoVentaRepositoryCustom.totalizar(runTarea);
    }
    
    @Override
    public void updateActivoTrasladadasSeccion(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.updateActivoTrasladadasSeccion(runTarea.getTarea(), runTarea.getTrabajo());
    }
    
    @Override
    public void agruparOnlineSeccionDia(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.agruparOnlineSeccionDia(runTarea.getTarea(), runTarea.getTrabajo());
    }
    
    @Override
    public void updateActivoTrasladadasTotalizado(@Valid RunTareaDto runTarea) {
        tareaLocalizacionAbiertaRepositoryCustom.updateActivoTrasladadasTotalizado(runTarea.getTarea(), runTarea.getTrabajo());
    }
    
    @Override
    public void updateImporteEstructuraPoliticas(@Valid RunTareaDto runTarea) {
        tareaPersonaEstructuraPoliticaRepositoryCustom.updateImporteEstructuraPoliticas(runTarea.getTarea(), runTarea.getTrabajo());
    }

    @Override
    public void totalizarDevolucionLocalizacionSeccion(@Valid RunTareaDto runTarea) {
        tareaLocalizacionVentaRepositoryCustom.totalizarDevolucionLocalizacionSeccion(runTarea.getTarea());
    }

    @Override
    public void totalizarVentasSinDevolucionLocalizacionSeccion(@Valid RunTareaDto runTarea) {
        tareaLocalizacionVentaRepositoryCustom.totalizarVentasSinDevolucionLocalizacionSeccion(runTarea.getTarea());
    }

    @Override
    public void totalizarVentaSinDevolucionPersonasPorVenta(@Valid RunTareaDto tarea) {
        tareaLocalizacionVentaRepositoryCustom.totalizarVentaSinDevolucionPersonasPorVenta(tarea.getTarea());
    }

    @Override
    public void totalizarVentaPersonasPorVentaSimplificada(@Valid RunTareaDto tarea) {
        tareaLocalizacionVentaRepositoryCustom.totalizarVentaPersonasPorVentaSimplificada(tarea.getTarea());
    }

    @Override
    public void totalizarVentaPersonaSeccion(@Valid RunTareaDto tarea) {
        tareaLocalizacionPersonaVentaRepositoryCustom.totalizarVentaPersonaSeccion(tarea.getTarea());
    }

    @Override
    public void totalizarVentaSinDevolucionPersonaSeccion(@Valid RunTareaDto tarea) {
        tareaLocalizacionPersonaVentaRepositoryCustom.totalizarVentaSinDevolucionPersonaSeccion(tarea.getTarea());
    }

    @Override
    public void totalizarDevolucionPersonaSeccion(@Valid RunTareaDto tarea) {
        tareaLocalizacionPersonaVentaRepositoryCustom.totalizarDevolucionPersonaSeccion(tarea.getTarea());
    }

    @Override
    public void totalizarVentaFisicaSinDevolucionPersonaSeccion(@Valid RunTareaDto tarea) {
        tareaLocalizacionPersonaVentaRepositoryCustom.totalizarVentaFisicaSinDevolucionPersonaSeccion(tarea.getTarea());
    }

    @Override
    public void totalizarVentaOnlineIpodSinDevolucionPersonaSeccion(@Valid RunTareaDto tarea) {
        tareaLocalizacionPersonaVentaRepositoryCustom.totalizarVentaOnlineIpodSinDevolucionPersonaSeccion(tarea.getTarea());
    }

    @Override
    public void totalizarDevolucionFisicaPersonaSeccion(@Valid RunTareaDto tarea) {
        tareaLocalizacionPersonaVentaRepositoryCustom.totalizarDevolucionFisicaPersonaSeccion(tarea.getTarea());
    }

    @Override
    public void totalizarDevolucionOnlineIpodPersonaSeccion(@Valid RunTareaDto tarea) {
        tareaLocalizacionPersonaVentaRepositoryCustom.totalizarDevolucionFisicaPersonaSeccion(tarea.getTarea());
    }

    @Override
    public void calcularImporteComisionVendedores(@Valid RunTareaDto tarea) {
        tareaLocalizacionVentaRepositoryCustom.calcularImporteComisionVendedores(tarea.getTarea());
    }

    @Override
    public void calcularImporteComisionVentaODevolucion(@Valid RunTareaDto tarea) {
        tareaLocalizacionVentaRepositoryCustom.calcularImporteComisionVentaODevolucion(tarea.getTarea());
    }
    
    @Override
    public void updateActivoNegativoTotalizado(@Valid RunTareaDto tarea) {
        tareaLocalizacionVentaRepositoryCustom.updateActivoNegativoTotalizado(tarea.getTarea());
    }

    @Override
    public void totalizarVentasVendedor0(@Valid RunTareaDto tarea) {
        tareaLocalizacionVentaRepositoryCustom.totalizarVentasVendedor0(tarea.getTarea());
    }

    @Override
    public void repartoDevolucionVendedor0(@Valid RunTareaDto tarea) {
        tareaLocalizacionVentaRepositoryCustom.repartoDevolucionVendedor0(tarea.getTarea());
    }
}
