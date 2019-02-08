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
import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoTiendaSeccionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoRecolectarPtrVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrGroupSellerTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaEmpleadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaGeneralAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

@Service
@Validated
public class TrabajoRecolectarPtrVentaServiceImpl implements TrabajoRecolectarPtrVentaService {

    @Autowired
    private PtrVentaGeneralAsyncService ptrVentaGeneralAsyncService;
    
    @Autowired
    private PtrVentaEmpleadoAsyncService ptrVentaEmpleadoAsyncService;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Autowired
    private TrabajoTiendaSeccionVentaAsyncService trabajoTiendaSeccionVentaAsyncService;

    @Autowired
    @Qualifier("ptrProps")
    protected Map<String, PtrPropertiesDto> ptrProps;
    
    @TrabajoAuditoria
    @Override
    public void ventaTotalizadaTienda(@Valid final TrabajoDto trabajo,
            @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            for (String cadena : runTrabajoRecolectarBloque.getCadenaEmpresa()) {
                for (List<String> iter : StreamUtils.partition(runTrabajoRecolectarBloque.getTiendaMtu(),
                        ptrProps.get(PtrConstants.VENTA_TOTALIZADO).getFilter().getMaxPageSize())) {
                    PtrVentaTotalizadoRequestDto paramGetVentaTotalizado = trabajoMapper
                            .trabajoDtoToPtrVentaTotalizadoRequestDto(trabajo);
                    paramGetVentaTotalizado.setTienda(iter);
                    // EL parametro cadena deja de ser una lista en la nueva fachada.
                    paramGetVentaTotalizado.setCadena(Integer.valueOf(cadena));
                    paramGetVentaTotalizado.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);

                    CompletableFuture<PtrVentaTotalizadoResponseDto> cfData = ptrVentaGeneralAsyncService
                            .getVentaTotalizado(paramGetVentaTotalizado);
                    AsyncUtils.exceptionally(cfData, cf, cfPersist);

                    PtrVentaTotalizadoResponseDto data = cfData.get();

                    if (data != null && CollectionUtils.isNotEmpty(data.getVentaTotalizado())) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                ptrProps.get(PtrConstants.VENTA_TOTALIZADO).getFilter().getMaxPersistenceSize());
                        AsyncUtils.exceptionally(
                                trabajoTiendaSeccionVentaAsyncService.save(data.getVentaTotalizado(), trabajo), cf,
                                cfPersist);
                    }
                }
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @TrabajoAuditoria
    @Override
    public void ventaDetalleEmpleado(@Valid final TrabajoDto trabajo,
            @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            for (String cadena : runTrabajoRecolectarBloque.getCadenaEmpresa()) {
                for (List<String> iter : StreamUtils.partition(runTrabajoRecolectarBloque.getEmpleadoLocal(),
                        ptrProps.get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getFilter().getMaxPageSize())) {
                    List<Integer> empleados = iter.stream().map(Integer::valueOf).collect(Collectors.toList());
                    PtrVentaIndividualDetalleRequestDto paramGetVentaIndividualDetalle = trabajoMapper
                            .trabajoDtoToPtrVentaIndividualDetalleRequestDto(trabajo);
                    paramGetVentaIndividualDetalle.setVendedores(empleados);
                    paramGetVentaIndividualDetalle.setCadena(Integer.valueOf(cadena));
                    paramGetVentaIndividualDetalle.setAgrupacion(PtrGroupSellerTypeEnum.FECHA_VENDEDOR_TIENDA);

                    CompletableFuture<PtrVentaIndividualDetalleResponseDto> cfData = ptrVentaEmpleadoAsyncService
                            .getVentaIndividualDetalle(paramGetVentaIndividualDetalle);
                    AsyncUtils.exceptionally(cfData, cf, cfPersist);

                    PtrVentaIndividualDetalleResponseDto data = cfData.get();

                    if (data != null && CollectionUtils.isNotEmpty(data.getVentaIndividualDetalle())) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                ptrProps.get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getFilter().getMaxPersistenceSize());
                        // TODO PERSISTIR
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