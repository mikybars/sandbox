package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrFilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class AbstractRunTareaAmbitoRecolectarPtrPresenciaService {

    @Autowired
    private PtrPresenciaAsyncService ptrPresenciaAsyncService;

    @Autowired
    private TareaLocalizacionHistoricoService tareaTiendaHistoricoService;

    @Autowired
    private TareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncService tareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncService;

    @Autowired
    private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    @Qualifier("presenciasProperties")
    private Map<String, PtrPropertiesDto> presenciasProperties;

    protected abstract String getFechaInicioPeriodo(TareaDto tarea);

    public void presenciaEmpleadoTiendaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        final TareaDto tarea = runTarea.getTarea();
        PtrFilterPropertiesDto filter = presenciasProperties.get(PtrPropertiesConstants.PRESENCIA_EMPLEADOS_TIENDA)
            .getFilter();
        for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                tareaTiendaHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigen(tarea.getId(),
                        tareaAmbito.getCclIdOrigen()),
                filter.getMaxPageSize())) {

            List<PeriodoDto> periodos = tareaLocalizacionPresupuestoService
                .findListaPeriodosPresupestoYTrabajo(tarea.getId(), filter);
            for (PeriodoDto periodo : periodos) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                PtrPresenciaEmpleadosTiendaRequestDto request = tareaMapper
                    .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrPresenciaEmpleadosTiendaRequestDto(tarea,
                            tareaAmbito, periodo, iter);

                request.setEmpresa(Arrays.asList(Integer.valueOf(tarea.getStdIdLegEnt())));
                request.setAgrupacion(PtrGroupTypeEnum.PERSONA_TIENDA.getValue());
                request.setFechaDesde(getFechaInicioPeriodo(tarea));
                CompletableFuture<PtrPresenciaEmpleadosTiendaResponseDto> cfData = ptrPresenciaAsyncService
                    .presenciasEmpleadosTienda(request);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                PtrPresenciaEmpleadosTiendaResponseDto data = AsyncUtils.get(cfData);
                if (data != null && CollectionUtils.isNotEmpty(data.getPresenciasTiendasEmpleado())) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist, filter.getMaxPersistenceSize());
                    AsyncUtils.exceptionally(tareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncService
                        .savePtrPresenciaEmpleadosTiendaResponse(data, tarea), cf, cfPersist);
                }
            }
        }
        AsyncUtils.waitAllOfIsOk(cf, cf);
    }

}
