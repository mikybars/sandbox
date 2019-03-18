package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaGeneralService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaSeccionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaGeneralAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

@Service
@Validated
public class RunTareaRecolectarPtrVentaGeneralServiceImpl implements RunTareaRecolectarPtrVentaGeneralService {

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    @Qualifier("ventaGeneralProperties")
    protected Map<String, PtrPropertiesDto> ventaGeneralProperties;

    @Autowired
    private PtrVentaGeneralAsyncService ptrVentaGeneralAsyncService;

    @Autowired
    private TareaTiendaSeccionVentaAsyncService tareaTiendaSeccionVentaAsyncService;

    @Autowired
    private TareaTiendaHistoricoService tareaTiendaHistoricoService;

    @Auditoria
    @Override
    public void ventaTotalizadaTienda(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                // TODO Filtrar por origen
                for (List<String> iter : StreamUtils.partition(runTareaRecolectarBloque.getTiendaMtu(),
                        ventaGeneralProperties.get(PtrConstants.VENTA_TOTALIZADO).getFilter().getMaxPageSize())) {
                    PtrVentaTotalizadoRequestDto paramGetVentaTotalizado = tareaMapper
                            .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaTotalizadoRequestDto(trabajo, tarea,
                                    tareaAmbito);
                    paramGetVentaTotalizado.setTienda(iter);
                    paramGetVentaTotalizado.setEmpresa(Integer.valueOf(tarea.getIdEmpresa()));
                    paramGetVentaTotalizado.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                    CompletableFuture<PtrVentaTotalizadoResponseDto> cfData = ptrVentaGeneralAsyncService
                            .ventaTotalizado(paramGetVentaTotalizado);
                    AsyncUtils.exceptionally(cfData, cf, cfPersist);
                    PtrVentaTotalizadoResponseDto data = AsyncUtils.get(cfData);
                    AsyncUtils.checkAsyncAvaliable(cfPersist, ventaGeneralProperties.get(PtrConstants.VENTA_TOTALIZADO)
                            .getFilter().getMaxPersistenceSize());
                    AsyncUtils.exceptionally(
                            tareaTiendaSeccionVentaAsyncService.savePtrVentaTotalizadoResponse(data, tarea), cf,
                            cfPersist);
                }
                AsyncUtils.waitAllOfIsOk(cf, cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
    @Auditoria
    @Override
    public void ventaFisicaLocalizacionSeccionByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }
    
    @Auditoria
    @Override
    public void ventaFisicaLocalizacionByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            ventaFisicaLocalizacionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }

    private void ventaFisicaLocalizacionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    tareaTiendaHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    ventaGeneralProperties.get(PtrConstants.VENTA_TOTALIZADO).getFilter().getMaxPageSize())) {
                PtrVentaTotalizadoRequestDto request = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaTotalizadoRequestDto(trabajo, tarea,
                                tareaAmbito);
                request.setTienda(iter.stream().map(item -> item.getId()).collect(Collectors.toList()));
                request.setEmpresa(Integer.valueOf(tarea.getIdEmpresa()));
                request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
                request.setAgruparSeccion(PtrConstants.BOOLEAN_INTEGER_FALSE);
                // TODO Falta el pivotado por seccion
                CompletableFuture<PtrVentaTotalizadoResponseDto> cfData = ptrVentaGeneralAsyncService
                        .ventaTotalizado(request);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                PtrVentaTotalizadoResponseDto data = AsyncUtils.get(cfData);
               //TODO: Persistir
                
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
    @Auditoria
    @Override
    public void ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    tareaTiendaHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    ventaGeneralProperties.get(PtrConstants.VENTA_TOTALIZADO).getFilter().getMaxPageSize())) {
                PtrVentaTotalizadoRequestDto request = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaTotalizadoRequestDto(trabajo, tarea,
                                tareaAmbito);
                request.setTienda(iter.stream().map(item -> item.getId()).collect(Collectors.toList()));
                request.setEmpresa(Integer.valueOf(tarea.getIdEmpresa()));
                request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                // TODO Falta el pivotado por seccion
                CompletableFuture<PtrVentaTotalizadoResponseDto> cfData = ptrVentaGeneralAsyncService
                        .ventaTotalizado(request);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                PtrVentaTotalizadoResponseDto data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist,
                        ventaGeneralProperties.get(PtrConstants.VENTA_TOTALIZADO).getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(
                        tareaTiendaSeccionVentaAsyncService.savePtrVentaTotalizadoResponse(data, tarea), cf, cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

}