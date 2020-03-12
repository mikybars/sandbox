package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.CounterFunctionalMetric;
import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.limpieza.async.service.LimpiezaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrPresenciaPresupuestosAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarAmbitoPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Validated
public class RunTareaRecolectarAmbitoPresupuestoServiceImpl implements RunTareaRecolectarAmbitoPresupuestoService {

    @Autowired
    private RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;

    @Autowired
    private RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService;

    @Autowired
    private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

    @Autowired
    private TareaAmbitoGlobalPersonaAsyncService tareaAmbitoGlobalPersonaAsyncService;

    @Autowired
    private TareaAmbitoGlobalLocalizacionAsyncService tareaAmbitoGlobalLocalizacionAsyncService;

    @Autowired
    private TareaAmbitoGlobalLocalizacionPersonaAsyncService tareaAmbitoGlobalLocalizacionPersonaAsyncService;

    @Autowired
    private RunTareaRecolectarPtrPresenciaPresupuestosAsyncService runTareaRecolectarPtrPresenciaPresupuestosAsyncService;

    @Autowired
    private RunTareaRecolectarByAmbitoService runTareaRecolectarByAmbitoService;

    @Autowired
    private RunTareaRecolectarByAmbitoLocalizacionService runTareaRecolectarByAmbitoLocalizacionService;

    @Autowired
    private RunTareaRecolectarByAmbitoPersonaService runTareaRecolectarByAmbitoPersonaService;

    @Autowired
    private LimpiezaAsyncService limpiezaAsyncService;

    @Auditoria
    @TimerFunctionalMetric(metricName = "RunTareaRecolectarAmbitoPresupuestoService.run.timer", metricGroupName = "RunTareaRecolectarAmbitoPresupuestoServiceGroup", metricDescription = "RunTareaRecolectarAmbitoPresupuestoService.run.timer")
    @CounterFunctionalMetric(metricName = "RunTareaRecolectarAmbitoPresupuestoService.run.counter", metricGroupName = "RunTareaRecolectarAmbitoPresupuestoServiceGroup", metricDescription = "RunTareaRecolectarAmbitoPresupuestoService.run.counter")
    @Override
    public void run(@NotNull @Valid RunTareaDto runTarea) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            /*-----------------------------------------------------------------*/
            /*
             * Carga inicial de estructuras
             */
            /*-----------------------------------------------------------------*/

            // Estructuras (Tramado estructuras (ApV) Detalle comision (Meta4))
            CompletableFuture<Void> cfEstructurasCom = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                .estructurasComByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfEstructurasCom, cf);

            CompletableFuture<Void> cfEstructurasPol = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                .estructurasPolByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfEstructurasPol, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            CompletableFuture<Void> cfPresupuestos = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.presupuestosWlocByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPresupuestos, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            List<TareaLocalizacionPresupuestoDto> presupuestos = tareaLocalizacionPresupuestoService.findPresupuestos(runTarea.getTarea());
            if (CollectionUtils.isNotEmpty(presupuestos)) {

                final TrabajoDto trabajo = runTarea.getTrabajo();
                /*-----------------------------------------------------------------*/
                /*
                 * Limpieza del ámbito anterior
                 */
                /*-----------------------------------------------------------------*/

                CompletableFuture<Void> cfLimpiezaTareaPersonaHistorico = limpiezaAsyncService.limpiezaTareaPersonaHistorico(runTarea.getTarea());
                AsyncUtils.exceptionally(cfLimpiezaTareaPersonaHistorico, cf);

                CompletableFuture<Void> cfLimpiezaTareaLocalizacionHistorico = limpiezaAsyncService.limpiezaTareaLocalizacionHistorico(runTarea.getTarea());
                AsyncUtils.exceptionally(cfLimpiezaTareaLocalizacionHistorico, cf);

                CompletableFuture<Void> cfLimpiezaTareaAmbitoGlobalLocalizacionPersona = limpiezaAsyncService.limpiezaTareaGlobalLocalizacionPersona(runTarea.getTarea());
                AsyncUtils.exceptionally(cfLimpiezaTareaAmbitoGlobalLocalizacionPersona, cf);

                CompletableFuture<Void> cfLimpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento = limpiezaAsyncService.limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(runTarea.getTarea());
                AsyncUtils.exceptionally(cfLimpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento, cf);

                CompletableFuture<Void> cfLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia = limpiezaAsyncService.limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(runTarea.getTarea());
                AsyncUtils.exceptionally(cfLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia, cf);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cf);
                /*-------------------------------------------------------------*/

                /*-----------------------------------------------------------------*/
                /*
                 * Obtención del ámbito de nuevo
                 */
                /*-----------------------------------------------------------------*/

                // Personas asociadas al origen y empresa
                CompletableFuture<Void> cfPersonaByRunTarea = runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService
                    .personaByRunTarea(runTarea);
                AsyncUtils.exceptionally(cfPersonaByRunTarea, cf);

                // Localizaciones asociadas al origen y empresa
                CompletableFuture<Void> cfLocalizacionByRunTarea = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .localizacionByRunTarea(runTarea);
                AsyncUtils.exceptionally(cfLocalizacionByRunTarea, cf);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cf);
                /*-------------------------------------------------------------*/

                // Relacion de personas con localizaciones en presencias ptr
                // asociadas al origen y empresa
                CompletableFuture<Void> cfPresenciaEmpleadoTienda = runTareaRecolectarPtrPresenciaPresupuestosAsyncService
                    .presenciaEmpleadoTiendaByRunTarea(runTarea);
                AsyncUtils.exceptionally(cfPresenciaEmpleadoTienda, cf);

                // Relacion de personas con localizaciones en presencias manuales
                // asociadas al origen y empresa
                CompletableFuture<Void> cfEmpleadosPresencia = runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService
                    .empleadosPresenciaByRunTarea(runTarea);
                AsyncUtils.exceptionally(cfEmpleadosPresencia, cf);

                // Relacion de personas con localizaciones en desplazamientos
                // asociadas al origen y empresa
                CompletableFuture<Void> cfEmpleadosDesplazamiento = runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService
                    .empleadosDesplazamientoByRunTarea(runTarea);
                AsyncUtils.exceptionally(cfEmpleadosDesplazamiento, cf);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cf);
                /*-------------------------------------------------------------*/

                CompletableFuture<Void> cfMergePersonaLocalizacion = tareaAmbitoGlobalLocalizacionPersonaAsyncService
                    .mergePersonaLocalizacion(runTarea);
                AsyncUtils.exceptionally(cfMergePersonaLocalizacion, cf);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cf);
                /*-------------------------------------------------------------*/

                CompletableFuture<Void> cfMergePersona = tareaAmbitoGlobalPersonaAsyncService.mergePersona(runTarea);
                AsyncUtils.exceptionally(cfMergePersona, cf);

                CompletableFuture<Void> cfMergeLocalizacion = tareaAmbitoGlobalLocalizacionAsyncService
                    .mergeLocalizacion(runTarea);
                AsyncUtils.exceptionally(cfMergeLocalizacion, cf);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cf);
                /*-------------------------------------------------------------*/
                if (TipoAmbitoEnum.SOCIEDAD.getId().equals(trabajo.getTipoAmbito().getId())
                    || TipoAmbitoEnum.ORIGEN.getId().equals(trabajo.getTipoAmbito().getId())
                    || TipoAmbitoEnum.EMPRESA.getId().equals(trabajo.getTipoAmbito().getId())) {
                    runTareaRecolectarByAmbitoService.run(runTarea);
                } else if (TipoAmbitoEnum.LOCALIZACION.getId().equals(trabajo.getTipoAmbito().getId())) {
                    runTareaRecolectarByAmbitoLocalizacionService.run(runTarea);
                } else if (TipoAmbitoEnum.PERSONA.getId().equals(trabajo.getTipoAmbito().getId())) {
                    runTareaRecolectarByAmbitoPersonaService.run(runTarea);
                } else {
                    throw new IcmclcwbException("El tipo ambito no esta soportado");
                }
            }

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }
}
