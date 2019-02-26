package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

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

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoTiendaSeccionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoRecolectarPtrVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupSellerTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaEmpleadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaGeneralAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

@Service
@Validated
public class ProcesoRecolectarPtrVentaServiceImpl implements ProcesoRecolectarPtrVentaService {

    @Autowired
    private PtrVentaGeneralAsyncService ptrVentaGeneralAsyncService;
    
    @Autowired
    private PtrVentaEmpleadoAsyncService ptrVentaEmpleadoAsyncService;

    @Autowired
    private ProcesoMapper procesoMapper;

    @Autowired
    private ProcesoTiendaSeccionVentaAsyncService procesoTiendaSeccionVentaAsyncService;

    @Autowired
    @Qualifier("ventaGeneralProperties")
    protected Map<String, PtrPropertiesDto> ventaGeneralProperties;
    
    @Autowired
    @Qualifier("ventaEmpleadoProperties")
    protected Map<String, PtrPropertiesDto> ventaEmpleadoProperties;
    
    @Autowired
    @Qualifier("ventaEcommerceProperties")
    protected Map<String, PtrPropertiesDto> ventaEcommerceProperties;
    
    
    @Auditoria
    @Override
    public void ventaTotalizadaTienda(@Valid final ProcesoDto proceso,
            @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            for (String cadena : runProcesoRecolectarBloque.getCadenaEmpresa()) {
                for (List<String> iter : StreamUtils.partition(runProcesoRecolectarBloque.getTiendaMtu(),
                        ventaGeneralProperties.get(PtrConstants.VENTA_TOTALIZADO).getFilter().getMaxPageSize())) {
                    PtrVentaTotalizadoRequestDto paramGetVentaTotalizado = procesoMapper
                            .procesoDtoToPtrVentaTotalizadoRequestDto(proceso);
                    paramGetVentaTotalizado.setTienda(iter);
                    // EL parametro cadena deja de ser una lista en la nueva fachada.
                    paramGetVentaTotalizado.setCadena(Integer.valueOf(cadena));
                    paramGetVentaTotalizado.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);

                    CompletableFuture<PtrVentaTotalizadoResponseDto> cfData = ptrVentaGeneralAsyncService
                            .ventaTotalizado(paramGetVentaTotalizado);
                    AsyncUtils.exceptionally(cfData, cf, cfPersist);

                    PtrVentaTotalizadoResponseDto data = cfData.get();

                    if (data != null && CollectionUtils.isNotEmpty(data.getVentaTotalizado())) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                ventaGeneralProperties.get(PtrConstants.VENTA_TOTALIZADO).getFilter().getMaxPersistenceSize());
                        AsyncUtils.exceptionally(
                                procesoTiendaSeccionVentaAsyncService.save(data.getVentaTotalizado(), proceso), cf,
                                cfPersist);
                    }
                }
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Auditoria
    @Override
    public void ventaDetalleEmpleado(@Valid final ProcesoDto proceso,
            @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            for (String cadena : runProcesoRecolectarBloque.getCadenaEmpresa()) {
                for (List<String> iter : StreamUtils.partition(runProcesoRecolectarBloque.getEmpleadoLocal(),
                        ventaEmpleadoProperties.get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getFilter().getMaxPageSize())) {
                    List<Integer> empleados = iter.stream().map(Integer::valueOf).collect(Collectors.toList());
                    PtrVentaIndividualDetalleRequestDto paramGetVentaIndividualDetalle = procesoMapper
                            .procesoDtoToPtrVentaIndividualDetalleRequestDto(proceso);
                    paramGetVentaIndividualDetalle.setVendedores(empleados);
                    paramGetVentaIndividualDetalle.setCadena(Integer.valueOf(cadena));
                    paramGetVentaIndividualDetalle.setAgrupacion(PtrGroupSellerTypeEnum.FECHA_VENDEDOR_TIENDA);

                    CompletableFuture<PtrVentaIndividualDetalleResponseDto> cfData = ptrVentaEmpleadoAsyncService
                            .ventaIndividualDetalle(paramGetVentaIndividualDetalle);
                    AsyncUtils.exceptionally(cfData, cf, cfPersist);

                    PtrVentaIndividualDetalleResponseDto data = cfData.get();

                    if (data != null && CollectionUtils.isNotEmpty(data.getVentaIndividualDetalle())) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                ventaEmpleadoProperties.get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getFilter().getMaxPersistenceSize());
                        // TODO PERSISTIR
                    }
                }
            }

            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

}