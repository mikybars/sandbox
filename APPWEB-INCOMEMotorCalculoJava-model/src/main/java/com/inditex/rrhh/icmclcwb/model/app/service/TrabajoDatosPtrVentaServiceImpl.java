package com.inditex.rrhh.icmclcwb.model.app.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
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
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosPtrVentaService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.RunUtils;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaEstado;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaVentaSeccionRepository;

@Service
@Validated
public class TrabajoDatosPtrVentaServiceImpl implements TrabajoDatosPtrVentaService {

    @Autowired
    private PtrVentaAsyncService ptrVentaAsyncService;

    @Autowired
    private TrabajoTiendaSeccionVentaAsyncService trabajoTiendaSeccionVentaAsyncService;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Autowired
    private TrabajoTiendaEstadoRepository trabajoTiendaEstadoRepository;

    @Autowired
    private TrabajoEmpleadoEstadoRepository trabajoEmpleadoEstadoRepository;

    @Autowired
    private TrabajoTiendaVentaSeccionRepository trabajoTiendaVentaSeccionRepository;

    @Autowired
    @Qualifier("getEmpleadosTiendaDto")
    private Meta4PropertiesDto getEmpleadosTiendaDto;

    @Autowired
    @Qualifier("ventaTotalizadoDto")
    private PtrPropertiesDto ventaTotalizadoDto;

    @Autowired
    @Qualifier("ventaIndividualDetalleDto")
    private PtrPropertiesDto ventaIndividualDetalleDto;

    @AuditoriaTrabajo
    @Override
    public void ventaTotalizadaTienda(@Valid final TrabajoDto trabajo,
            @NotNull final List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            List<Long> tipoTrabajoTiendaId = tipoTrabajoTienda.stream().map(TipoTrabajoTiendaDto::getId)
                    .collect(Collectors.toList());
            Page<TrabajoTiendaEstado> page;
            Pageable pageable = new PageRequest(0, ventaTotalizadoDto.getFilter().getMaxPageSize());
            do {
                page = trabajoTiendaEstadoRepository.findByTrabajoIdAndEstadoIdAndTipoIdIn(trabajo.getId(),
                        AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), tipoTrabajoTiendaId, pageable);
                if (CollectionUtils.isNotEmpty(page.getContent())) {
                    List<String> tiendas = page.getContent().stream().map(TrabajoTiendaEstado::getIdTienda)
                            .collect(Collectors.toList());

                    GetVentaTotalizadoRequestDto paramGetVentaTotalizado = trabajoMapper
                            .trabajoDtoToGetVentaTotalizadoRequestDto(trabajo);
                    paramGetVentaTotalizado.setTienda(tiendas);
                    paramGetVentaTotalizado.setCadena(trabajo.getCadenasEmpresa());
                    paramGetVentaTotalizado.setAgrupacion(PtrConstants.AGRUPACION_TOTALIZADA);

                    CompletableFuture<GetVentaTotalizadoResponseDto> cfData = ptrVentaAsyncService
                            .getVentaTotalizado(paramGetVentaTotalizado);
                    AsyncUtils.exceptionally(cfData, cf, cfPersist);

                    GetVentaTotalizadoResponseDto data = cfData.get();

                    if (data != null && CollectionUtils.isNotEmpty(data.getVentaTotalizado())) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                ventaTotalizadoDto.getFilter().getMaxPersistenceSize());
                        AsyncUtils.exceptionally(
                                trabajoTiendaSeccionVentaAsyncService.save(data.getVentaTotalizado(), trabajo), cf,
                                cfPersist);
                    }
                }

                pageable = page.nextPageable();

            } while (page.hasNext());

            AsyncUtils.waitAllOfIsOk(cf, cf);

            if (RunUtils.isPivot(trabajo, tipoTrabajoTienda)) {
                trabajoTiendaVentaSeccionRepository.save(trabajo);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @AuditoriaTrabajo
    @Override
    public void ventaDetalleEmpleado(@Valid final TrabajoDto trabajo) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            Page<TrabajoEmpleadoEstado> page;
            Pageable pageable = new PageRequest(0, ventaIndividualDetalleDto.getFilter().getMaxPageSize());
            do {

                page = trabajoEmpleadoEstadoRepository.findByTrabajoIdAndEstadoId(trabajo.getId(),
                        AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), pageable);

                if (CollectionUtils.isNotEmpty(page.getContent())) {

                    List<Integer> empleados = page.getContent().stream().map(e -> Integer.valueOf(e.getIdEmpleado()))
                            .collect(Collectors.toList());

                    GetVentaIndividualDetalleRequestDto paramGetVentaIndividualDetalle = trabajoMapper
                            .trabajoDtoToGetVentaIndividualDetalleRequestDto(trabajo);
                    paramGetVentaIndividualDetalle.setVendedores(empleados);
                    paramGetVentaIndividualDetalle.setCadena(trabajo.getCadenasEmpresa());
                    paramGetVentaIndividualDetalle.setTienda(new ArrayList<>());
                    paramGetVentaIndividualDetalle.setAgrupacion(PtrConstants.AGRUPACION_INDIVIDUAL);

                    CompletableFuture<GetVentaIndividualDetalleResponseDto> cfData = ptrVentaAsyncService
                            .getVentaIndividualDetalle(paramGetVentaIndividualDetalle);
                    AsyncUtils.exceptionally(cfData, cf, cfPersist);

                    GetVentaIndividualDetalleResponseDto data = cfData.get();

                    if (data != null && CollectionUtils.isNotEmpty(data.getVentaIndividualDetalle())) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                ventaIndividualDetalleDto.getFilter().getMaxPersistenceSize());
                        // TODO PERSISTIR
                    }
                }
                pageable = page.nextPageable();
            } while (page.hasNext());

            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @AuditoriaTrabajo
    @Override
    public void ventaTotalizadaTiendaTest(@Valid final TrabajoDto trabajo, List<TipoTrabajoTiendaDto> tipoTrabajoTienda)
            throws Exception {
        Integer maxPersistenceSize = ventaTotalizadoDto.getFilter().getMaxPersistenceSize();
        Integer maxPageSize = ventaTotalizadoDto.getFilter().getMaxPageSize();
        List<Long> tipoTrabajoTiendaId = tipoTrabajoTienda.stream().map(TipoTrabajoTiendaDto::getId)
                .collect(Collectors.toList());

        GetVentaTotalizadoRequestDto paramGetVentaTotalizado = trabajoMapper
                .trabajoDtoToGetVentaTotalizadoRequestDto(trabajo);
        paramGetVentaTotalizado.setCadena(trabajo.getCadenasEmpresa());
        paramGetVentaTotalizado.setAgrupacion(PtrConstants.AGRUPACION_TOTALIZADA);

        Object[] helperParams = new Object[3];
        helperParams[0] = trabajo.getId();
        helperParams[1] = AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId();
        helperParams[2] = tipoTrabajoTiendaId;

        ServiceDefinitionHelper elementsHelper = ServiceDefinitionHelper.builder()
                .methodName("findByTrabajoIdAndEstadoIdAndTipoIdIn").objectParams(helperParams)
                .service(trabajoTiendaEstadoRepository).build();

        ServiceDefinitionHelper ptr = ServiceDefinitionHelper.builder().methodName("getVentaTotalizado")
                .service(ptrVentaAsyncService).build();

        Class[] saveType = new Class[2];
        saveType[0] = List.class;
        saveType[1] = TrabajoDto.class;

        ServiceDefinitionHelper save = ServiceDefinitionHelper.builder().methodName("save").objectType(saveType)
                .service(trabajoTiendaSeccionVentaAsyncService).build();

        genericPtrCall(trabajo, paramGetVentaTotalizado, maxPageSize, maxPersistenceSize, ptr, elementsHelper, save,
                "tienda", "ventaTotalizado");
    }

    private <T, U extends Object, Z extends Object> void genericPtrCall(TrabajoDto trabajo, U request,
            Integer maxPageSize, Integer maxPersistenceSize, ServiceDefinitionHelper ptr,
            ServiceDefinitionHelper elementsHelper, ServiceDefinitionHelper save, String field, String fieldResult)
            throws Exception {
        Pageable pageable = new PageRequest(0, maxPageSize);
        Page page = null;

        List<CompletableFuture<?>> cf = new ArrayList<>();
        do {
            Object[] params = new Object[elementsHelper.getObjectParams().length + 1];
            Class[] paramsType = new Class[elementsHelper.getObjectParams().length + 1];

            for (int i = 0; i < elementsHelper.getObjectParams().length; i++) {
                params[i] = elementsHelper.getObjectParams()[i];
                if (elementsHelper.getObjectParams()[i] instanceof ArrayList) {
                    paramsType[i] = List.class;
                } else {
                    paramsType[i] = elementsHelper.getObjectParams()[i].getClass();
                }
            }

            params[params.length - 1] = pageable;
            paramsType[paramsType.length - 1] = Pageable.class;

            Method method = elementsHelper.getService().getClass().getMethod(elementsHelper.getMethodName(),
                    paramsType);
            page = (Page) method.invoke(elementsHelper.getService(), params);
            if (CollectionUtils.isNotEmpty(page.getContent())) {
                List<?> elements = (List<Integer>) page.getContent().stream().map(e -> {
                    if (e instanceof TrabajoEmpleadoEstado) {
                        return ((TrabajoEmpleadoEstado) e).getIdEmpleado();
                    } else if (e instanceof TrabajoTiendaEstado) {
                        return ((TrabajoTiendaEstado) e).getIdTienda();
                    }
                    return null;
                }).collect(Collectors.toList());

                Field setField = request.getClass().getDeclaredField(field);
                if (setField != null) {
                    setField.setAccessible(true);
                    setField.set(request, elements);
                }

                Method methodPtr = ptr.getService().getClass().getMethod(ptr.getMethodName(), request.getClass());
                CompletableFuture<U> result = (CompletableFuture<U>) methodPtr.invoke(ptr.getService(), request);

                U resultGet = result.get();
                List<U> resultArray = new ArrayList<>();
                Field setFieldSave = resultGet.getClass().getDeclaredField(fieldResult);
                if (setFieldSave != null) {
                    setFieldSave.setAccessible(true);
                    resultArray = (List<U>) setFieldSave.get(resultGet);
                }

                Method methodSave = save.getService().getClass().getMethod(save.getMethodName(), save.getObjectType());
                CompletableFuture<?> cfSave;
                if (save.getObjectType().length == 2) {
                    cfSave = (CompletableFuture<?>) methodSave.invoke(save.getService(), resultArray, trabajo);
                } else {
                    cfSave = (CompletableFuture<?>) methodSave.invoke(save.getService(), resultArray);
                }
                cf.add(cfSave);

                AsyncUtils.checkAsyncAvaliable(cf, maxPersistenceSize);
            }

            pageable = page.nextPageable();

        } while (page.hasNext());

        AsyncUtils.waitAllOfIsOk(cf, cf);
    }

}