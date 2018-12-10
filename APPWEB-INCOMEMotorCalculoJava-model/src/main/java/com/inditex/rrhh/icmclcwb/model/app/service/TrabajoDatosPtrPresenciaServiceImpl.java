package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajo;
import com.inditex.rrhh.icmclcwb.api.app.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionEmpleadoPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTipoHoraService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTiendaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.RunUtils;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaEstado;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEmpleadoPresenciaSeccionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaPresenciaSeccionRepository;

@Service
@Validated
public class TrabajoDatosPtrPresenciaServiceImpl implements TrabajoDatosPtrPresenciaService {

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
    private TrabajoTiendaEstadoRepository trabajoTiendaEstadoRepository;

    @Autowired
    private TrabajoTiendaEstadoRepositoryCustom trabajoTiendaEstadoRepositoryCustom;

    @Autowired
    private TrabajoEmpleadoEstadoRepository trabajoEmpleadoEstadoRepository;

    @Autowired
    private TrabajoTiendaPresenciaSeccionRepository trabajoTiendaPresenciaSeccionRepository;

    @Autowired
    private TrabajoTiendaEmpleadoPresenciaSeccionRepository trabajoTiendaEmpleadoPresenciaSeccionRepository;

    @Autowired
    @Qualifier("presenciasTotalTiendaSeccionDto")
    private PtrPropertiesDto presenciasTotalTiendaSeccionDto;

    @Autowired
    @Qualifier("presenciasDetalleDto")
    private PtrPropertiesDto presenciasDetalleDto;

    @AuditoriaTrabajo
    @Override
    public void tiposHoras(@Valid final TrabajoDto trabajo) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            CompletableFuture<PtrPresenciaTiposHorasResponseDto> cfData = ptrPresenciaAsyncService
                    .getTiposHoras(PtrPresenciaTiposHorasRequestDto.builder()
                            .origen(Integer.parseInt(trabajo.getIdPaisOrigen())).build());
            AsyncUtils.exceptionally(cfData, cf);
            PtrPresenciaTiposHorasResponseDto data = cfData.get();
            if (CollectionUtils.isNotEmpty(data.getList())) {
                AsyncUtils.exceptionally(trabajoTipoHoraSevice.save(data.getList(), trabajo), cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @AuditoriaTrabajo
    @Override
    public void presenciaTotalizadaTienda(@Valid TrabajoDto trabajo,
            @NotNull final List<TipoTrabajoTiendaDto> tipoTrabajoTienda,
            @Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            List<Long> tipoTrabajoTiendaId = tipoTrabajoTienda.stream().map(TipoTrabajoTiendaDto::getId)
                    .collect(Collectors.toList());
            Page<TrabajoTiendaEstado> page;
            Pageable pageable = new PageRequest(0, presenciasTotalTiendaSeccionDto.getFilter().getMaxPageSize());
            do {
                page = trabajoTiendaEstadoRepository.findByTrabajoIdAndTipoIdIn(trabajo.getId(), tipoTrabajoTiendaId,
                        pageable);

                if (CollectionUtils.isNotEmpty(page.getContent())) {
                    List<PtrPresenciaTiendaSeccionDto> tiendas = page.getContent().stream()
                            .map(t -> new PtrPresenciaTiendaSeccionDto(Integer.valueOf(t.getIdTienda()), null))
                            .collect(Collectors.toList());

                    List<Integer> cadenas = trabajoRunDatos.getCadenasEmpresa().stream().map(Integer::valueOf)
                            .collect(Collectors.toList());

                    PtrPresenciaTotalTiendaSeccionRequestDto paramPresenciasTotalTiendaSeccion = trabajoMapper
                            .trabajoDtoToPtrPresenciasTotalTiendaSeccionRequestDto(trabajo);
                    paramPresenciasTotalTiendaSeccion.setCadena(cadenas);
                    paramPresenciasTotalTiendaSeccion.setTiendaSeccion(tiendas);
                    // TODO (PENDIENTE ANALIZAR) Enviar la lista de horas comisionables y cambiar el
                    // objeto a una lista
                    // paramPresenciasTotalTiendaSeccion.setTipo(tipo);

                    CompletableFuture<PtrPresenciaTotalTiendaSeccionResponseDto> cfData = ptrPresenciaAsyncService
                            .getPresenciasTotalTiendaSeccionDto(paramPresenciasTotalTiendaSeccion);
                    AsyncUtils.exceptionally(cfData, cf, cfPersist);

                    PtrPresenciaTotalTiendaSeccionResponseDto data = cfData.get();
                    if (data != null && CollectionUtils.isNotEmpty(data.getList())) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                presenciasTotalTiendaSeccionDto.getFilter().getMaxPersistenceSize());
                        AsyncUtils.exceptionally(trabajoTiendaSeccionPresenciaService.save(data.getList()), cf,
                                cfPersist);
                    }
                    pageable = page.nextPageable();
                }
            } while (page.hasNext());

            AsyncUtils.waitAllOfIsOk(cf, cf);

            if (RunUtils.isPivot(trabajo, tipoTrabajoTienda)) {
                trabajoTiendaPresenciaSeccionRepository.save(trabajo);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @AuditoriaTrabajo
    @Override
    public void presenciaDetalleEmpleado(@Valid TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos)
            throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            Page<TrabajoEmpleadoEstado> page;
            Pageable pageable = new PageRequest(0, presenciasDetalleDto.getFilter().getMaxPageSize());
            Set<Integer> idsTiendas = new HashSet<>();
            do {
                page = trabajoEmpleadoEstadoRepository.findByTrabajoId(trabajo.getId(), pageable);

                if (CollectionUtils.isNotEmpty(page.getContent())) {
                    List<Integer> empleados = page.getContent().stream().map(s -> Integer.valueOf(s.getIdEmpleado()))
                            .collect(Collectors.toList());

                    List<Integer> cadenas = trabajoRunDatos.getCadenasEmpresa().stream().map(Integer::valueOf)
                            .collect(Collectors.toList());

                    PtrPresenciaDetalleRequestDto paramPresenciasDetalle = trabajoMapper
                            .trabajoDtoToPtrPresenciasDetalleRequestDto(trabajo);
                    paramPresenciasDetalle.setPersonas(empleados);
                    paramPresenciasDetalle.setCadena(cadenas);

                    CompletableFuture<PtrPresenciaDetalleResponseDto> cfData = ptrPresenciaAsyncService
                            .getPresenciasDetalleDto(paramPresenciasDetalle);
                    AsyncUtils.exceptionally(cfData, cf, cfPersist);

                    PtrPresenciaDetalleResponseDto data = cfData.get();
                    if (data != null && CollectionUtils.isNotEmpty(data.getList())) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                presenciasDetalleDto.getFilter().getMaxPersistenceSize());
                        AsyncUtils.exceptionally(
                                trabajoTiendaSeccionEmpleadoPresenciaService.save(data.getList(), trabajo), cf,
                                cfPersist);

                        if (CollectionUtils.isNotEmpty(trabajo.getTiendas())
                                || CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
                            // TODO Recuperar los ids de tienda sin repetidos de las presencias, para
                            // procesarlas posteriormente
                            trabajoRunDatos.getTiendasPresencia().addAll(data.getList().stream()
                                    .map(PtrPresenciaDetalleResultItemDto::getTienda).collect(Collectors.toSet()));
                        }

                    }
                }
                pageable = page.nextPageable();
            } while (page.hasNext());

            AsyncUtils.waitAllOfIsOk(cf, cf);

            // TODO Revisar si las tiendas recuperadas de las presencias estan en las
            // tiendas de BBDD
            // Si no estan consultar a Meta4 e insertar los datos

            if (CollectionUtils.isNotEmpty(idsTiendas)) {
                List<Integer> idsTiendasMeta4 = trabajoTiendaEstadoRepositoryCustom
                        .customFindByIdTiendaNotExists(idsTiendas);
                // TODO Obtener tiendas de Meta4 y persistir en BBDD el detalle
            }

            // TODO Pivotado de la informacion

            trabajoTiendaEmpleadoPresenciaSeccionRepository.save(trabajo);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}