package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrPresenciaService;
<<<<<<< HEAD
=======
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaSeccionPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPresenciaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionSeccionPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTipoHoraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
>>>>>>> stash

@Service
@Validated
public class RunTareaRecolectarPtrPresenciaServiceImpl implements RunTareaRecolectarPtrPresenciaService {

    @Autowired
    private RunTareaAmbitoRecolectarPtrPresenciaService runTareaAmbitoRecolectarPtrPresenciaService;

<<<<<<< HEAD
=======
    @Autowired
    private Meta4IcmWsCalcIncomeSessionAsyncService meta4IcmWsCalcIncomeSessionAsyncService;

    @Autowired
    private PtrPresenciaAsyncService ptrPresenciaAsyncService;

    @Autowired
    private TareaLocalizacionPresenciaSeccionAsyncService tareaLocalizacionPresenciaSeccionAsyncService;

    @Autowired
    private TareaLocalizacionSeccionPresenciaAsyncService tareaLocalizacionSeccionPresenciaAsyncService;
    
    @Autowired
    private TareaLocalizacionPresenciaAsyncService tareaLocalizacionPresenciaAsyncService;
    
    @Autowired
    private TareaTipoHoraAsyncService tareaTipoHoraAsyncSevice;

    @Autowired
    private TareaPersonaHistoricoService tareaPersonaHistoricoService;

    @Autowired
    private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

    @Autowired
    private TareaLocalizacionHistoricoAsyncService tareaLocalizacionHistoricoAsyncService;

    @Autowired
    private TareaLocalizacionPersonaPresenciaSeccionAsyncService tareaLocalizacionPersonaPresenciaSeccionAsyncService;
    
    @Autowired
    private TareaLocalizacionPersonaSeccionPresenciaAsyncService tareaLocalizacionPersonaSeccionPresenciaAsyncService;
    
    @Autowired
    private TareaPersonaHistoricoAsyncService tareaPersonaHistoricoAsyncService;

    @Autowired
    private TareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncService tareaAmbitoLocalizacionPersonaPresenciaAsyncService;
    
    @Autowired
    private TareaLocalizacionPersonaPresenciaAsyncService tareaLocalizacionPersonaPresenciaAsyncService;

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    @Qualifier("meta4Properties")
    private Map<String, Meta4PropertiesDto> meta4Properties;

    @Autowired
    @Qualifier("presenciasProperties")
    private Map<String, PtrPropertiesDto> presenciasProperties;

    @Autowired
    @Qualifier(value = "recolectarProperties")
    private RecolectarPropertiesDto recolectarProperties;

    @Auditoria
>>>>>>> stash
    @Override
    public void tiposHorasByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(
                item -> runTareaAmbitoRecolectarPtrPresenciaService.tiposHorasByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void presenciaTotalLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrPresenciaService
                .presenciaTotalLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void presenciaTotalLocalizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrPresenciaService
                .presenciaTotalLocalizacionByRunTareaAndTareaAmbito(runTarea, item));
    }

<<<<<<< HEAD
=======
    private void presenciaTotalLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    tareaLocalizacionHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    presenciasProperties.get(PtrConstants.PRESENCIA_TOTALIZADO).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrPresenciaTotalizadoRequestDto paramPresenciasTotalTiendaSeccion = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciaTotalizadoRequestDto(trabajo, tarea,
                                tareaAmbito, recolectarProperties);
                paramPresenciasTotalTiendaSeccion
                        .setTienda(iter.stream().map(e -> Integer.valueOf(e.getId())).collect(Collectors.toList()));
                paramPresenciasTotalTiendaSeccion.setAgruparSeccion(PtrConstants.BOOLEAN_INTEGER_TRUE);
                paramPresenciasTotalTiendaSeccion.setAgrupacion(PtrConstants.FECHA_TIENDA_SECCION);
                paramPresenciasTotalTiendaSeccion.setExcluidoDenom(Boolean.FALSE);

                CompletableFuture<PtrPresenciaTotalizadoResponseDto> cfData = ptrPresenciaAsyncService
                        .presenciasTotalizado(paramPresenciasTotalTiendaSeccion);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrPresenciaTotalizadoResponseDto data = AsyncUtils.get(cfData);
                if (data != null && CollectionUtils.isNotEmpty(data.getPresenciasTotalizado())) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist, presenciasProperties
                            .get(PtrConstants.PRESENCIA_TOTALIZADO).getFilter().getMaxPersistenceSize());
                    AsyncUtils.exceptionally(
                            tareaLocalizacionPresenciaSeccionAsyncService.save(data.getPresenciasTotalizado(), tarea), cf,
                            cfPersist);
                    AsyncUtils.checkAsyncAvaliable(cfPersist, presenciasProperties
                            .get(PtrConstants.PRESENCIA_TOTALIZADO).getFilter().getMaxPersistenceSize());
                    
                    AsyncUtils.exceptionally(
                        tareaLocalizacionSeccionPresenciaAsyncService.save(data.getPresenciasTotalizado(), tarea), cf,
                        cfPersist);
                }

            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @Auditoria
>>>>>>> stash
    @Override
    public void presenciaDetalleComisionablePersonaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrPresenciaService
                .presenciaDetalleComisionablePersonaByRunTareaAndTareaAmbito(runTarea, item));
    }
<<<<<<< HEAD
=======
    
    private void presenciaTotalLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    tareaLocalizacionHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    presenciasProperties.get(PtrConstants.PRESENCIA_TOTALIZADO).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
>>>>>>> stash

    @Override
    public void presenciaDetalleComisionableLocalizacionPersonaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrPresenciaService
                .presenciaDetalleComisionableLocalizacionPersonaByRunTareaAndTareaAmbito(runTarea, item));
    }

<<<<<<< HEAD
=======
    private void presenciaDetalleComisionablePersonaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    tareaLocalizacionHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrPresenciaDetalleRequestDto paramPresenciasDetalle = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciasDetalleRequestDto(trabajo, tarea,
                                tareaAmbito);
                paramPresenciasDetalle.setTienda(iter.stream().map(IdLocalizacionLocalDto::getId)
                        .map(Integer::valueOf).collect(Collectors.toList()));
                paramPresenciasDetalle.setAgruparSeccion(PtrConstants.BOOLEAN_INTEGER_TRUE);
                paramPresenciasDetalle.setAgrupacion(PtrConstants.FECHA_TIENDA_TIPOHORA_SECCION);
                paramPresenciasDetalle.setExcluidoCalculo(Boolean.FALSE);

                CompletableFuture<PtrPresenciaDetalleResponseDto> cfData = ptrPresenciaAsyncService
                        .presenciasDetalle(paramPresenciasDetalle);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrPresenciaDetalleResponseDto data = AsyncUtils.get(cfData);
                if (data != null && CollectionUtils.isNotEmpty(data.getPresenciasDetalle())) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist, presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE)
                            .getFilter().getMaxPersistenceSize());
                    //TODO Las dos siguientes líneas son respectivamente el guardado pivotado y sin pivotar
                    AsyncUtils.exceptionally(
                            tareaLocalizacionPersonaPresenciaSeccionAsyncService.save(data.getPresenciasDetalle(), tarea),
                            cf, cfPersist);
                    AsyncUtils.checkAsyncAvaliable(cfPersist, presenciasProperties
                            .get(PtrConstants.PRESENCIA_DETALLE).getFilter().getMaxPersistenceSize());
                    AsyncUtils.exceptionally(
                            tareaLocalizacionPersonaSeccionPresenciaAsyncService.savePtrPresenciaDetalle(data.getPresenciasDetalle(), tarea),
                            cf, cfPersist);
                }
            }

            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }

    }

    @Auditoria
>>>>>>> stash
    @Override
<<<<<<< HEAD
    public void presenciaEmpleadoTiendaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrPresenciaService
                .presenciaEmpleadoTiendaByRunTareaAndTareaAmbito(runTarea, item));
=======
    public void presenciaDetalleComisionableLocalizacionPersonaByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            presenciaDetalleComisionableLocalizacionPersonaByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }
    
    private void presenciaDetalleComisionableLocalizacionPersonaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    tareaLocalizacionHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrPresenciaDetalleRequestDto paramPresenciasDetalle = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciasDetalleRequestDto(trabajo, tarea,
                                tareaAmbito);
                paramPresenciasDetalle.setTienda(iter.stream().map(IdLocalizacionLocalDto::getId)
                        .map(Integer::valueOf).collect(Collectors.toList()));
                paramPresenciasDetalle.setAgruparSeccion(PtrConstants.BOOLEAN_INTEGER_FALSE);
                paramPresenciasDetalle.setAgrupacion(PtrConstants.FECHA_TIENDA_TIPOHORA);
                paramPresenciasDetalle.setExcluidoCalculo(Boolean.FALSE);

                CompletableFuture<PtrPresenciaDetalleResponseDto> cfData = ptrPresenciaAsyncService
                        .presenciasDetalle(paramPresenciasDetalle);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrPresenciaDetalleResponseDto data = AsyncUtils.get(cfData);
                if (data != null && CollectionUtils.isNotEmpty(data.getPresenciasDetalle())) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist, presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE)
                            .getFilter().getMaxPersistenceSize());
                    //TODO Las dos siguientes líneas son respectivamente el guardado pivotado y sin pivotar
                    AsyncUtils.exceptionally(
                            tareaLocalizacionPersonaPresenciaAsyncService.save(data.getPresenciasDetalle(), tarea),
                            cf, cfPersist);
                }
            }

            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }

    }
    
    @Auditoria
    @Override
    public void presenciaEmpleadoTiendaByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            presenciaEmpleadoTiendaByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }

    private void presenciaEmpleadoTiendaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    tareaLocalizacionHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    presenciasProperties.get(PtrConstants.PRESENCIA_EMPLEADOS_TIENDA).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrPresenciaEmpleadosTiendaRequestDto request = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciaEmpleadosTiendaRequestDto(trabajo,
                                tarea, tareaAmbito, iter);

                request.setEmpresa(Arrays.asList(Integer.valueOf(tarea.getIdEmpresa())));
                request.setAgrupacion(PtrConstants.PERSONA_TIENDA);

                CompletableFuture<PtrPresenciaEmpleadosTiendaResponseDto> cfData = ptrPresenciaAsyncService
                        .presenciasEmpleadosTienda(request);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrPresenciaEmpleadosTiendaResponseDto data = AsyncUtils.get(cfData);

                if (data != null && CollectionUtils.isNotEmpty(data.getPresenciasEmpleadosTienda())) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist, presenciasProperties
                            .get(PtrConstants.PRESENCIA_EMPLEADOS_TIENDA).getFilter().getMaxPersistenceSize());
                    AsyncUtils.exceptionally(tareaAmbitoLocalizacionPersonaPresenciaAsyncService
                            .savePtrPresenciaEmpleadosTiendaResponse(data, tarea), cf, cfPersist);
                }
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @Auditoria
    @Override
    public void presenciaTiendaEmpleadoByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            presenciaTiendaEmpleadoByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }

    private void presenciaTiendaEmpleadoByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            List<Integer> idTiendasGuardadas = null;
            for (List<IdPersonaLocalDto> iter : StreamUtils.partition(
                    tareaPersonaHistoricoService.findIdPersonaLocalByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    presenciasProperties.get(PtrConstants.PRESENCIA_TIENDAS_EMPLEADO).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrPresenciaTiendasEmpleadoRequestDto paramPresenciaTiendaEmpleado = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciaTiendasEmpleadoRequestDto(trabajo,
                                tarea, tareaAmbito);
                paramPresenciaTiendaEmpleado
                        .setPersona(iter.stream().map(e -> Integer.valueOf(StringUtils.trim(e.getIdPersonaLocal())))
                                .collect(Collectors.toList()));
                paramPresenciaTiendaEmpleado.setAgrupacion(PtrGroupTypeEnum.TIENDA.getValue());
                CompletableFuture<PtrPresenciaTiendasEmpleadoResponseDto> cfData = ptrPresenciaAsyncService
                        .presenciasTiendasEmpleado(paramPresenciaTiendaEmpleado);

                PtrPresenciaTiendasEmpleadoResponseDto data = AsyncUtils.get(cfData);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                if (data != null && CollectionUtils.isNotEmpty(data.getPresenciasTiendasEmpleado())) {
                    if (idTiendasGuardadas == null) {
                        idTiendasGuardadas = tareaLocalizacionHistoricoService
                                .findIdLocalizacionLocalDtoByIdTareaAndIdOrigen(tarea.getId(),
                                        tareaAmbito.getIdOrigen())
                                .stream().map(x -> Integer.parseInt(x.getId())).collect(Collectors.toList());
                    }
                    List<Integer> idTiendasSinGuardar = new ArrayList<>();
                    for (PtrPresenciaTiendasEmpleadoResultItemDto presencia : data.getPresenciasTiendasEmpleado()) {
                        if (!idTiendasGuardadas.contains(presencia.getTienda())
                                && !idTiendasSinGuardar.contains(presencia.getTienda())) {
                            idTiendasSinGuardar.add(presencia.getTienda());
                        }
                    }

                    if (CollectionUtils.isNotEmpty(idTiendasSinGuardar)) {
                        // Para las tiendas no guardadas se obtienen en Meta4 y se guardan
                        TiendasRequestDto tiendasRequest = new TiendasRequestDto();
                        tiendasRequest.setPage(meta4Properties.get(Meta4Constants.TIENDAS).getPage());
                        tiendasRequest.setData(
                                tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo,
                                        tarea, tareaAmbito));
                        tiendasRequest.getData().setItem(idTiendasSinGuardar.stream().map(x -> {
                            // No tenemos servicio para obtener tiendas a partir de id local, por lo que
                            // hacemos
                            // esta transformación bruta. En futuro tendremos un servicio a medida.
                            StringBuilder sb = new StringBuilder("T").append(x);
                            return GenericFilterParametersDto.builder().idLugarTrabajo(sb.toString()).build();
                        }).collect(Collectors.toList()));
                        // TODO Usamos el servicio de tiendas a partir de id universal, pero se
                        // sustituira en el futuro.
                        // Este servicio no está devolviendo el origen, país o cadena.
                        CompletableFuture<List<GenericTiendaResultItemDto>> cfTiendas = meta4IcmWsCalcIncomeSessionAsyncService
                                .getTiendas(tiendasRequest);
                        AsyncUtils.exceptionally(cfTiendas, cf, cfPersist);
                        List<GenericTiendaResultItemDto> tiendas = AsyncUtils.get(cfTiendas);
                        if (CollectionUtils.isNotEmpty(tiendas)) {
                            AsyncUtils.checkAsyncAvaliable(cfPersist, presenciasProperties
                                    .get(PtrConstants.PRESENCIA_TIENDAS_EMPLEADO).getFilter().getMaxPersistenceSize());
                            CompletableFuture<Void> cfSave = tareaLocalizacionHistoricoAsyncService
                                    .saveGenericTiendaResultItemDto(tiendas, tarea);
                            AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                            // Se pone en la lista de ids de tiendas guardadas,
                            // para que no se guarden en la siguiente vuelta del bucle
                            idTiendasGuardadas.addAll(idTiendasSinGuardar);
                        }
                    }

                }

            }

            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }

    }

    @Auditoria
    @Override
    public void personaPresenciaDetalleComisionableByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            personaPresenciaDetalleComisionableByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }

    private void personaPresenciaDetalleComisionableByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            List<Integer> personasGuardadas = null;
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    tareaLocalizacionHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    presenciasProperties.get(PtrConstants.PRESENCIA_TOTAL_TIENDA_SECCION).getFilter()
                            .getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                // Obtencion de presencias de empleados a partir de localizaciones
                PtrPresenciaEmpleadosTiendaRequestDto request = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciaEmpleadosTiendaRequestDto(trabajo,
                                tarea, tareaAmbito, iter);
                request.setAgrupacion(PtrGroupTypeEnum.PERSONA_TIENDA.getValue());
                request.setExcluidoCalculo(Boolean.FALSE);
                CompletableFuture<PtrPresenciaEmpleadosTiendaResponseDto> cfData = ptrPresenciaAsyncService
                        .presenciasEmpleadosTienda(request);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                PtrPresenciaEmpleadosTiendaResponseDto data = AsyncUtils.get(cfData);
                if (data != null && CollectionUtils.isNotEmpty(data.getPresenciasEmpleadosTienda())) {
                    // Comprobacion de empleados guardados previamente para evitar duplicados
                    //TODO: Revisar si se puede eliminar de la poc
                    if (personasGuardadas == null) {
                        List<IdPersonaLocalDto> ids = tareaPersonaHistoricoService
                                .findIdPersonaLocalByIdTareaAndIdOrigen(tarea.getId(), tareaAmbito.getIdOrigen());
                        personasGuardadas = ids.stream().map(IdPersonaLocalDto::getIdPersonaLocal).map(Integer::valueOf)
                                .collect(Collectors.toList());
                    }

                    List<Integer> personasSinGuardar = new ArrayList<>();
                    for (PtrPresenciaEmpleadosTiendaResultItemDto presencia : data.getPresenciasEmpleadosTienda()) {
                        LinkedList<Integer> personas = new LinkedList<>(presencia.getPersonas());
                        personas.removeAll(personasGuardadas);
                        personas.removeAll(personasSinGuardar);
                        if (CollectionUtils.isNotEmpty(personas)) {
                            personasSinGuardar.addAll(personas);
                        }
                    }

                    // Para los empleados no guardados, obtener su informacion desde Meta4 para
                    // poder guardarlos en BD
                    if (CollectionUtils.isNotEmpty(personasSinGuardar)) {
                        EmpleadosRequestDto empleadoRequest = new EmpleadosRequestDto();
                        empleadoRequest.setPage(meta4Properties.get(Meta4Constants.SEARCH_EMPLEADOS).getPage());
                        empleadoRequest.setData(
                                tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo,
                                        tarea, tareaAmbito));
                        List<GenericFilterParametersDto> empleadosRequestItem = personasSinGuardar.stream()
                                .map(x -> GenericFilterParametersDto.builder()
                                        // TODO estamos usando id local, pero el servicio solo acepta Id global, cambiar
                                        // esto cuando nos proporcionen el servicio
                                        .idEmpleado(x.toString()).build())
                                .collect(Collectors.toList());
                        empleadoRequest.getData().setItem(empleadosRequestItem);
                        CompletableFuture<List<GenericEmpleadoResultItemDto>> cfEmpleados = meta4IcmWsCalcIncomeSessionAsyncService
                                .getEmpleados(empleadoRequest);
                        AsyncUtils.exceptionally(cfEmpleados, cf);
                        List<GenericEmpleadoResultItemDto> empleados = AsyncUtils.get(cfEmpleados);
                        // Guardado de empleados
                        boolean hasNext = false;
                        do {
                            if (CollectionUtils.isNotEmpty(empleados)) {
                                AsyncUtils.checkAsyncAvaliable(cfPersist, meta4Properties
                                        .get(Meta4Constants.SEARCH_EMPLEADOS).getFilter().getMaxPersistenceSize());
                                CompletableFuture<Void> cfSave = tareaPersonaHistoricoAsyncService
                                        .saveGenericEmpleadoResultItemDto(empleados, tarea);
                                AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                                personasGuardadas
                                        .addAll(empleados.stream().map(GenericEmpleadoResultItemDto::getIdEmpleadoLocal)
                                                .map(Integer::valueOf).collect(Collectors.toList()));
                            }
                            hasNext = empleadoRequest.nextPage();
                        } while (hasNext);
                    }
                }

            }
            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
>>>>>>> stash
    }

}
