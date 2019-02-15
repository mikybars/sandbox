package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.TrabajoAuditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoTiendaSeccionEmpleadoPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoTiendaSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoTipoHoraService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.exception.PtrException;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTiendaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoTiendaEmpleadoPresenciaSeccionRepository;

@Service
@Validated
public class TrabajoRecolectarPtrPresenciaServiceImpl implements TrabajoRecolectarPtrPresenciaService {

    @Autowired
    private PtrPresenciaAsyncService ptrPresenciaAsyncService;

    @Autowired
    private TrabajoTiendaSeccionPresenciaService trabajoTiendaSeccionPresenciaService;

    @Autowired
    private TrabajoTipoHoraService trabajoTipoHoraSevice;

    @Autowired
    private TrabajoTiendaSeccionEmpleadoPresenciaService trabajoTiendaSeccionEmpleadoPresenciaService;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Autowired
    private TrabajoTiendaEmpleadoPresenciaSeccionRepository trabajoTiendaEmpleadoPresenciaSeccionRepository;
    
    @Autowired
    @Qualifier("presenciasProperties")
    private Map<String, PtrPropertiesDto> presenciasProperties;

    @TrabajoAuditoria
    @Override
    public void tiposHoras(@Valid final TrabajoDto trabajo,
            @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            CompletableFuture<PtrPresenciaTiposHorasResponseDto> cfData = ptrPresenciaAsyncService.getTiposHoras(
                    PtrPresenciaTiposHorasRequestDto.builder().origen(Integer.parseInt(trabajo.getIdPaisOrigen()))
                            .excluidoCalculo(Boolean.FALSE).build());
            AsyncUtils.exceptionally(cfData, cf);
            PtrPresenciaTiposHorasResponseDto data = cfData.get();
            if (data != null && CollectionUtils.isNotEmpty(data.getTiposHoras())) {
                AsyncUtils.exceptionally(trabajoTipoHoraSevice.save(data.getTiposHoras(), trabajo), cf);
                data.getTiposHoras().stream().forEach(item -> {
                    if (Boolean.FALSE.equals(item.getExcluidoCalculo())) {
                        runTrabajoRecolectarBloque.getTipoHoraComisionable().add(item.getTipoHora());
                        if (Boolean.FALSE.equals(item.getExcluidoDenom())) {
                            runTrabajoRecolectarBloque.getTipoHoraComisionableDenominador().add(item.getTipoHora());
                        }
                    }
                });
            } else {
                throw new PtrException(new StringBuilder("No hay tipos de hora comisionables para el origen: ")
                        .append(trabajo.getIdPaisOrigen()).toString());
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @TrabajoAuditoria
    @Override
    public void presenciaTotalizadaTienda(@Valid TrabajoDto trabajo,
            @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            for (String cadena : runTrabajoRecolectarBloque.getCadenaEmpresa()) {
                for (List<String> iter : StreamUtils.partition(runTrabajoRecolectarBloque.getTiendaMtu(),
                        presenciasProperties.get(PtrConstants.PRESENCIA_TOTAL_TIENDA_SECCION).getFilter().getMaxPageSize())) {
                    List<PtrPresenciaTiendaSeccionDto> tiendas = iter.stream()
                            .map(item -> PtrPresenciaTiendaSeccionDto.builder().tienda(Integer.valueOf(item)).build())
                            .collect(Collectors.toList());

                    PtrPresenciaTotalTiendaSeccionRequestDto paramPresenciasTotalTiendaSeccion = trabajoMapper
                            .trabajoDtoToPtrPresenciasTotalTiendaSeccionRequestDto(trabajo);
                    paramPresenciasTotalTiendaSeccion.setCadena(Integer.valueOf(cadena));
                    paramPresenciasTotalTiendaSeccion.setTiendaSeccion(tiendas);
                    // TODO Obtener las presencias comisionables por tipo de hora y excluido
                    // denominador

                    CompletableFuture<PtrPresenciaTotalTiendaSeccionResponseDto> cfData = ptrPresenciaAsyncService
                            .getPresenciasTotalTiendaSeccionDto(paramPresenciasTotalTiendaSeccion);
                    AsyncUtils.exceptionally(cfData, cf, cfPersist);

                    PtrPresenciaTotalTiendaSeccionResponseDto data = cfData.get();
                    if (data != null && CollectionUtils.isNotEmpty(data.getPresenciasTotalTiendaSeccion())) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                presenciasProperties.get(PtrConstants.PRESENCIA_TOTAL_TIENDA_SECCION).getFilter().getMaxPersistenceSize());
                        AsyncUtils.exceptionally(trabajoTiendaSeccionPresenciaService
                                .save(data.getPresenciasTotalTiendaSeccion(), trabajo), cf, cfPersist);
                    }
                }

            }

            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @TrabajoAuditoria
    @Override
    public void presenciaDetalleEmpleado(@Valid TrabajoDto trabajo,
            @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            for (String cadena : runTrabajoRecolectarBloque.getCadenaEmpresa()) {
                for (List<String> iter : StreamUtils.partition(runTrabajoRecolectarBloque.getEmpleadoLocal(),
                        presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE_COMISIONABLE).getFilter().getMaxPageSize())) {
                    List<Integer> empleados = iter.stream().map(Integer::valueOf).collect(Collectors.toList());
                    PtrPresenciaDetalleComisionableRequestDto paramPresenciasDetalleComisionable = trabajoMapper
                            .trabajoDtoToPtrPresenciasDetalleComisionableRequestDto(trabajo);
                    paramPresenciasDetalleComisionable.setPersona(empleados);
                    paramPresenciasDetalleComisionable.setCadena(Integer.valueOf(cadena));

                    CompletableFuture<PtrPresenciaDetalleComisionableResponseDto> cfData = ptrPresenciaAsyncService
                            .getPresenciasDetalleComisionableDto(paramPresenciasDetalleComisionable);
                    AsyncUtils.exceptionally(cfData, cf, cfPersist);

                    PtrPresenciaDetalleComisionableResponseDto data = cfData.get();
                    if (data != null && CollectionUtils.isNotEmpty(data.getPresenciasDetalleComisionable())) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE_COMISIONABLE).getFilter().getMaxPersistenceSize());
                        AsyncUtils.exceptionally(
                                trabajoTiendaSeccionEmpleadoPresenciaService.save(data.getPresenciasDetalleComisionable(), trabajo),
                                cf, cfPersist);

                        if (CollectionUtils.isNotEmpty(trabajo.getTiendas())
                                || CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
                            runTrabajoRecolectarBloque
                                    .getTiendaPresencia().addAll(
                                            data.getPresenciasDetalleComisionable().stream()
                                                    .map(item -> new StringBuilder(AppConstants.PREFIJO_TIENDA_META4)
                                                            .append(item.getTienda()).toString())
                                                    .collect(Collectors.toSet()));
                        }
                    }
                }
            }

            AsyncUtils.waitAllOfIsOk(cf, cf);

            trabajoTiendaEmpleadoPresenciaSeccionRepository.save(trabajo);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

}