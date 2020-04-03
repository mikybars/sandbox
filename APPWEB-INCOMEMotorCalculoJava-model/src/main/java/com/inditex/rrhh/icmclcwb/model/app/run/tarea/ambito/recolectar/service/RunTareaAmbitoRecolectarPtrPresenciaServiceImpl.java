package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTipoHoraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPageDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPageEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrAgruparSeccionEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@Validated
public class RunTareaAmbitoRecolectarPtrPresenciaServiceImpl
    extends AbstractRunTareaAmbitoRecolectarPtrPresenciaService
    implements RunTareaAmbitoRecolectarPtrPresenciaService {

    @Autowired
    private Logger log;

    @Autowired
    private PtrPresenciaAsyncService ptrPresenciaAsyncService;

    @Autowired
    private TareaTipoHoraAsyncService tareaTipoHoraAsyncSevice;

    @Autowired
    private TareaLocalizacionHistoricoService tareaTiendaHistoricoService;

    @Autowired
    private TareaLocalizacionPersonaPresenciaAsyncService tareaLocalizacionPersonaPresenciaAsyncService;

    @Autowired
    private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    @Qualifier("presenciasProperties")
    private Map<String, PtrPropertiesDto> presenciasProperties;

    @Autowired
    @Qualifier(value = "recolectarProperties")
    private RecolectarPropertiesDto recolectarProperties;

    @Override
    protected String getFechaInicioPeriodo(TareaDto tarea) {
        return tarea.getFechaInicioPeriodo().format(DateTimeFormatter.ofPattern(PtrConstants.DATE_FORMAT));
    }

    @Override
    public void tiposHorasByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TareaDto tarea = runTarea.getTarea();
            CompletableFuture<PtrPresenciaTiposHorasResponseDto> cfData = ptrPresenciaAsyncService
                    .tiposHoras(PtrPresenciaTiposHorasRequestDto.builder()
                            .origen(Integer.parseInt(tareaAmbito.getCclIdOrigen())).build());
            AsyncUtils.exceptionally(cfData, cf);
            PtrPresenciaTiposHorasResponseDto data = AsyncUtils.get(cfData);
            if (data != null && CollectionUtils.isNotEmpty(data.getTiposHoras())) {
                AsyncUtils.exceptionally(tareaTipoHoraAsyncSevice.save(data.getTiposHoras(), tarea), cf);
            } else {
                log.warn(new StringBuilder("No hay tipos de hora comisionables para el origen: ")
                        .append(tareaAmbito.getCclIdOrigen()).toString());
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @Override
    public void presenciaDetallePersonaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TareaDto tarea = runTarea.getTarea();
            PtrPageDto page = PtrPageDto
                .builder()
                .size(1)
                .type(PtrPageEnum.MONTHS)
                .build();
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    tareaTiendaHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(
                            tarea.getId(), tareaAmbito.getCclIdOrigen()),
                    presenciasProperties.get(PtrPropertiesConstants.PRESENCIA_DETALLE).getFilter().getMaxPageSize())) {
                for (PeriodoDto periodo : tareaLocalizacionPresupuestoService.findListaPeriodosPresupestoYTrabajo(
                            tarea.getId(), page, recolectarProperties)) {
                    List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                    PtrPresenciaDetalleRequestDto paramPresenciasDetalle = tareaMapper
                        .mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrPresenciasDetalleRequestDto(tarea,
                            tareaAmbito, periodo);
                    paramPresenciasDetalle.setTienda(iter.stream().map(IdLocalizacionLocalDto::getId).map(Integer::valueOf)
                        .collect(Collectors.toList()));
                    paramPresenciasDetalle.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                    paramPresenciasDetalle.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_TIPOHORA_SECCION.getValue());
                    CompletableFuture<PtrPresenciaDetalleResponseDto> cfData = ptrPresenciaAsyncService
                        .presenciasDetalle(paramPresenciasDetalle);
                    AsyncUtils.exceptionally(cfData, cf, cfPersist);

                    PtrPresenciaDetalleResponseDto data = AsyncUtils.get(cfData);
                    if (data != null && CollectionUtils.isNotEmpty(data.getPresenciasDetalle())) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist, presenciasProperties
                            .get(PtrPropertiesConstants.PRESENCIA_DETALLE).getFilter().getMaxPersistenceSize());
                        AsyncUtils.exceptionally(tareaLocalizacionPersonaPresenciaAsyncService
                            .savePtrPresenciaDetalle(data.getPresenciasDetalle(), tarea), cf, cfPersist);
                    }
                }
            }

            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }

    }

}
