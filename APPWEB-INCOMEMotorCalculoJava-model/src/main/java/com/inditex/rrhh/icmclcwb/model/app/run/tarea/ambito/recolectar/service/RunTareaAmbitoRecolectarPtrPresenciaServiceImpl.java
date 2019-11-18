package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTipoHoraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@Validated
public class RunTareaAmbitoRecolectarPtrPresenciaServiceImpl implements RunTareaAmbitoRecolectarPtrPresenciaService {

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
    private TareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncService tareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncService;

    @Autowired
    private TipoDatoService tipoDatoService;

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    @Qualifier("presenciasProperties")
    private Map<String, PtrPropertiesDto> presenciasProperties;

    @Autowired
    @Qualifier(value = "recolectarProperties")
    private RecolectarPropertiesDto recolectarProperties;

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
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            List<IdTipoDatoDto> tiposDatoPresencia = tipoDatoService
                    .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA.getId());
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    tareaTiendaHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(
                            tarea.getId(), tareaAmbito.getCclIdOrigen(),
                            tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList())),
                    presenciasProperties.get(PtrPropertiesConstants.PRESENCIA_DETALLE).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrPresenciaDetalleRequestDto paramPresenciasDetalle = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciasDetalleRequestDto(trabajo, tarea,
                                tareaAmbito, recolectarProperties);
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

            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }

    }

    @Override
    public void presenciaEmpleadoTiendaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        final TrabajoDto trabajo = runTarea.getTrabajo();
        final TareaDto tarea = runTarea.getTarea();
        for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                tareaTiendaHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigen(tarea.getId(),
                        tareaAmbito.getCclIdOrigen()),
                presenciasProperties.get(PtrPropertiesConstants.PRESENCIA_EMPLEADOS_TIENDA).getFilter()
                        .getMaxPageSize())) {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();

            PtrPresenciaEmpleadosTiendaRequestDto request = tareaMapper
                    .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciaEmpleadosTiendaRequestDto(trabajo, tarea,
                            tareaAmbito, iter);

            request.setEmpresa(Arrays.asList(Integer.valueOf(tarea.getStdIdLegEnt())));
            request.setAgrupacion(PtrGroupTypeEnum.PERSONA_TIENDA.getValue());
            CompletableFuture<PtrPresenciaEmpleadosTiendaResponseDto> cfData = ptrPresenciaAsyncService
                    .presenciasEmpleadosTienda(request);
            AsyncUtils.exceptionally(cfData, cf, cfPersist);
            PtrPresenciaEmpleadosTiendaResponseDto data = AsyncUtils.get(cfData);
            if (data != null && CollectionUtils.isNotEmpty(data.getPresenciasTiendasEmpleado())) {
                AsyncUtils.checkAsyncAvaliable(cfPersist, presenciasProperties
                        .get(PtrPropertiesConstants.PRESENCIA_EMPLEADOS_TIENDA).getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(tareaAmbitoGlobalLocalizacionPersonaPresenciaAsyncService
                        .savePtrPresenciaEmpleadosTiendaResponse(data, tarea), cf, cfPersist);
            }
        }
        AsyncUtils.waitAllOfIsOk(cf, cf);
    }

}
