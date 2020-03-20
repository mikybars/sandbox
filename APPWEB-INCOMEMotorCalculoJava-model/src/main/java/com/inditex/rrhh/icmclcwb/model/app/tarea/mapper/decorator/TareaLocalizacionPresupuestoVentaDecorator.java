package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.util.concurrent.AtomicDouble;
import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoChallengeEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPresupuestoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresupuestoVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPresupuesto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConceptoChallenge;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuestoVenta;

public abstract class TareaLocalizacionPresupuestoVentaDecorator extends TareaLocalizacionPresupuestoVentaMapper {

    @Autowired
    private TareaLocalizacionPresupuestoVentaMapper delegate;

    @Override
    public List<TareaLocalizacionPresupuestoVenta> ventaCongeladaResultItemDtoToTareaLocalizacionPresupuestoVenta(
            List<VentaCongeladaResultItemDto> src, TareaDto tarea) {
        List<TareaLocalizacionPresupuestoVenta> result = new ArrayList<>();
        if (src != null) {
            src.forEach(x -> {
                TareaLocalizacionPresupuestoVenta config = delegate.ventaCongeladaResultItemDtoToTareaLocalizacionPresupuestoVenta(x, tarea);
                config.setTipoPresupuesto(TipoPresupuesto.builder().id(TipoPresupuestoEnum.fromIdMeta4(x.getIdTpPresupuesto()).getId()).build());
                config.setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder().id(TipoVentaConceptoChallengeEnum.fromIdMeta4(x.getIdConceptoVenta()).getId()).build());
                if(x.getIdSeccion().equals(AppConstants.SECCION_4)) {
                    if(x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.VENTA_CAJA.getIdMeta4())) {
                        config.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_CONGELADA_FISICA_CAJA_LOCALIZACION.getId()).build());
                    }
                    if(x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.DEVOLUCIONES_OTRAS_TIENDAS.getIdMeta4())) {
                        config.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_CONGELADA_FISICA_DEVOLUCION_LOCALIZACION.getId()).build());
                    }
                    if(x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.IPOD.getIdMeta4())) {
                        config.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_CONGELADA_ONLINE_IPOD_LOCALIZACION.getId()).build());
                    }
                    if(x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.SINT.getIdMeta4())) {
                        config.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_CONGELADA_ONLINE_SINT_LOCALIZACION.getId()).build());
                    }
                    if(x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.ENTREGA_TIENDA.getIdMeta4())) {
                        config.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_CONGELADA_ONLINE_ENTREGATIENDA_LOCALIZACION.getId()).build());
                    }
                    if(x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.ENTREGA_DOMICILIO.getIdMeta4())) {
                        config.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_CONGELADA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId()).build());
                    }
                } 
                
                if(x.getIdSeccion().equals(AppConstants.SECCION_1) || x.getIdSeccion().equals(AppConstants.SECCION_2) || x.getIdSeccion().equals(AppConstants.SECCION_3)) {
                    if(x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.VENTA_CAJA.getIdMeta4())) {
                        config.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_CONGELADA_FISICA_CAJA_LOCALIZACION_SECCION.getId()).build());
                    }
                    if(x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.DEVOLUCIONES_OTRAS_TIENDAS.getIdMeta4())) {
                        config.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_CONGELADA_FISICA_DEVOLUCION_LOCALIZACION_SECCION.getId()).build());
                    }
                    if(x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.IPOD.getIdMeta4())) {
                        config.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_CONGELADA_ONLINE_IPOD_LOCALIZACION_SECCION.getId()).build());
                    }
                    if(x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.SINT.getIdMeta4())) {
                        config.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_CONGELADA_ONLINE_SINT_LOCALIZACION_SECCION.getId()).build());
                    }
                    if(x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.ENTREGA_TIENDA.getIdMeta4())) {
                        config.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_CONGELADA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId()).build());
                    }
                    if(x.getIdConceptoVenta().equals(TipoVentaConceptoChallengeEnum.ENTREGA_DOMICILIO.getIdMeta4())) {
                        config.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_CONGELADA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId()).build());
                    }
                }

                result.add(config);
            });
        }
        return result;
    }
    
    @Override
    public List<TareaLocalizacionPresupuestoVenta> ventaTotalizadoResponseItemDtoToTareaLocalizacionPresupuestoVenta(
            List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea) {
        List<TareaLocalizacionPresupuestoVenta> dtoList = new ArrayList<>();
        AtomicDouble importeSinIva = new AtomicDouble(0);
        AtomicDouble importeConIva = new AtomicDouble(0);
        if (CollectionUtils.isNotEmpty(src)) {
            src.stream().forEach(item -> {
                item.getListaSeccion().stream().forEach(venta -> {
                    TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = delegate.responseItemDtoToTareaLocalizacionPresupuestoVenta(item, tarea);
                    tareaLocalizacionPresupuestoVenta.setCclIdSeccion(String.valueOf(venta.getSeccion()));
                    tareaLocalizacionPresupuestoVenta.setImporteSinImpuestos(venta.getImporteSinIVA().doubleValue());
                    tareaLocalizacionPresupuestoVenta.setImporteConImpuestos(venta.getImporteConIVA().doubleValue());
                    if(item.getOperacion().equals(AppConstants.OPERACION_VENTA)) {
                        tareaLocalizacionPresupuestoVenta.setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder().id(TipoVentaConceptoChallengeEnum.VENTA_CAJA.getId()).build());
                        tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_FISICA_CAJA_LOCALIZACION_SECCION.getId()).build());
                    }
                    if(item.getOperacion().equals(AppConstants.OPERACION_DEVOLUCION)) {
                        tareaLocalizacionPresupuestoVenta.setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder().id(TipoVentaConceptoChallengeEnum.DEVOLUCIONES_OTRAS_TIENDAS.getId()).build());    
                        tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_FISICA_DEVOLUCION_LOCALIZACION_SECCION.getId()).build());
                    }
                    dtoList.add(tareaLocalizacionPresupuestoVenta);
                    importeSinIva.getAndAdd(tareaLocalizacionPresupuestoVenta.getImporteSinImpuestos());
                    importeConIva.getAndAdd(tareaLocalizacionPresupuestoVenta.getImporteConImpuestos());
                });
                TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = delegate.responseItemDtoToTareaLocalizacionPresupuestoVenta(item, tarea);
                tareaLocalizacionPresupuestoVenta.setImporteConImpuestos(importeConIva.doubleValue());
                tareaLocalizacionPresupuestoVenta.setImporteSinImpuestos(importeSinIva.doubleValue());
                if(item.getOperacion().equals(AppConstants.OPERACION_VENTA)) {
                    tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_FISICA_CAJA_LOCALIZACION.getId()).build());
                    tareaLocalizacionPresupuestoVenta.setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder().id(TipoVentaConceptoChallengeEnum.VENTA_CAJA.getId()).build());    
                }
                if(item.getOperacion().equals(AppConstants.OPERACION_DEVOLUCION)) {
                    tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_FISICA_DEVOLUCION_LOCALIZACION.getId()).build());
                    tareaLocalizacionPresupuestoVenta.setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder().id(TipoVentaConceptoChallengeEnum.DEVOLUCIONES_OTRAS_TIENDAS.getId()).build());    
                }
                dtoList.add(tareaLocalizacionPresupuestoVenta);
            });
        }
        return dtoList;
    }

    @Override
    public List<TareaLocalizacionPresupuestoVenta> ventaOnlineIpodResponseItemDtoToTareaLocalizacionPresupuestoVenta(
            List<PtrVentaOnlineIpodResultItemDto> src, TareaDto tarea) {
        List<TareaLocalizacionPresupuestoVenta> dtoList = new ArrayList<>();
        AtomicDouble importeSinIva = new AtomicDouble(0);
        AtomicDouble importeConIva = new AtomicDouble(0);
        if (CollectionUtils.isNotEmpty(src)) {
            src.stream().forEach(item -> {
                item.getListaSeccion().stream().forEach(venta -> {
                    TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = delegate.responseItemDtoToTareaLocalizacionPresupuestoVenta(item, tarea);
                    tareaLocalizacionPresupuestoVenta.setCclIdSeccion(String.valueOf(venta.getSeccion()));
                    tareaLocalizacionPresupuestoVenta.setImporteSinImpuestos(venta.getImporteSinIVA().doubleValue());
                    tareaLocalizacionPresupuestoVenta.setImporteConImpuestos(venta.getImporteConIVA().doubleValue());
                    tareaLocalizacionPresupuestoVenta.setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder().id(TipoVentaConceptoChallengeEnum.IPOD.getId()).build());    
                    tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_ONLINE_IPOD_LOCALIZACION_SECCION.getId()).build());

                    dtoList.add(tareaLocalizacionPresupuestoVenta);
                    importeSinIva.getAndAdd(tareaLocalizacionPresupuestoVenta.getImporteSinImpuestos());
                    importeConIva.getAndAdd(tareaLocalizacionPresupuestoVenta.getImporteConImpuestos());
                });
                TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = delegate.responseItemDtoToTareaLocalizacionPresupuestoVenta(item, tarea);
                tareaLocalizacionPresupuestoVenta.setImporteConImpuestos(importeConIva.doubleValue());
                tareaLocalizacionPresupuestoVenta.setImporteSinImpuestos(importeSinIva.doubleValue());
                tareaLocalizacionPresupuestoVenta.setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder().id(TipoVentaConceptoChallengeEnum.IPOD.getId()).build());    
                tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_ONLINE_IPOD_LOCALIZACION.getId()).build());

                dtoList.add(tareaLocalizacionPresupuestoVenta);
            });
        }
        return dtoList;
    }

    @Override
    public List<TareaLocalizacionPresupuestoVenta> ventaOnlinePickingResponseItemDtoToTareaLocalizacionPresupuestoVenta(
            List<PtrVentaOnlinePickingResultItemDto> src, TareaDto tarea) {
        List<TareaLocalizacionPresupuestoVenta> dtoList = new ArrayList<>();
        AtomicDouble importeSinIva = new AtomicDouble(0);
        AtomicDouble importeConIva = new AtomicDouble(0);
        if (CollectionUtils.isNotEmpty(src)) {
            src.stream().forEach(item -> {
                item.getListaSeccion().stream().forEach(venta -> {
                    TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = delegate.responseItemDtoToTareaLocalizacionPresupuestoVenta(item, tarea);
                    tareaLocalizacionPresupuestoVenta.setCclIdSeccion(String.valueOf(venta.getSeccion()));
                    tareaLocalizacionPresupuestoVenta.setImporteSinImpuestos(venta.getImporteSinIVA().doubleValue());
                    tareaLocalizacionPresupuestoVenta.setImporteConImpuestos(venta.getImporteConIVA().doubleValue());
                    tareaLocalizacionPresupuestoVenta.setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder().id(TipoVentaConceptoChallengeEnum.SINT.getId()).build());    
                    tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_ONLINE_SINT_LOCALIZACION_SECCION.getId()).build());

                    dtoList.add(tareaLocalizacionPresupuestoVenta);
                    importeSinIva.getAndAdd(tareaLocalizacionPresupuestoVenta.getImporteSinImpuestos());
                    importeConIva.getAndAdd(tareaLocalizacionPresupuestoVenta.getImporteConImpuestos());
                });
                TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = delegate.responseItemDtoToTareaLocalizacionPresupuestoVenta(item, tarea);
                tareaLocalizacionPresupuestoVenta.setImporteConImpuestos(importeConIva.doubleValue());
                tareaLocalizacionPresupuestoVenta.setImporteSinImpuestos(importeSinIva.doubleValue());
                tareaLocalizacionPresupuestoVenta.setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder().id(TipoVentaConceptoChallengeEnum.SINT.getId()).build());    
                tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_ONLINE_SINT_LOCALIZACION.getId()).build());

                dtoList.add(tareaLocalizacionPresupuestoVenta);
            });
        }
        return dtoList;
    }
    
    @Override
    public List<TareaLocalizacionPresupuestoVenta> ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionPresupuestoVenta(
            List<PtrVentaOnlineEntregaTiendaResultItemDto> src, TareaDto tarea) {
        List<TareaLocalizacionPresupuestoVenta> dtoList = new ArrayList<>();
        AtomicDouble importeSinIva = new AtomicDouble(0);
        AtomicDouble importeConIva = new AtomicDouble(0);
        if (CollectionUtils.isNotEmpty(src)) {
            src.stream().forEach(item -> {
                item.getListaSeccion().stream().forEach(venta -> {
                    TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = delegate.responseItemDtoToTareaLocalizacionPresupuestoVenta(item, tarea);
                    tareaLocalizacionPresupuestoVenta.setCclIdSeccion(String.valueOf(venta.getSeccion()));
                    tareaLocalizacionPresupuestoVenta.setImporteSinImpuestos(venta.getImporteSinIVA().doubleValue());
                    tareaLocalizacionPresupuestoVenta.setImporteConImpuestos(venta.getImporteConIVA().doubleValue());
                    tareaLocalizacionPresupuestoVenta.setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder().id(TipoVentaConceptoChallengeEnum.ENTREGA_TIENDA.getId()).build());    
                    tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId()).build());

                    dtoList.add(tareaLocalizacionPresupuestoVenta);
                    importeSinIva.getAndAdd(tareaLocalizacionPresupuestoVenta.getImporteSinImpuestos());
                    importeConIva.getAndAdd(tareaLocalizacionPresupuestoVenta.getImporteConImpuestos());
                });
                TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = delegate.responseItemDtoToTareaLocalizacionPresupuestoVenta(item, tarea);
                tareaLocalizacionPresupuestoVenta.setImporteConImpuestos(importeConIva.doubleValue());
                tareaLocalizacionPresupuestoVenta.setImporteSinImpuestos(importeSinIva.doubleValue());
                tareaLocalizacionPresupuestoVenta.setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder().id(TipoVentaConceptoChallengeEnum.ENTREGA_TIENDA.getId()).build());    
                tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_ONLINE_ENTREGATIENDA_LOCALIZACION.getId()).build());

                dtoList.add(tareaLocalizacionPresupuestoVenta);
            });
        }
        return dtoList;
    }

    @Override
    public List<TareaLocalizacionPresupuestoVenta> ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionPresupuestoVenta(
            List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tarea) {
        List<TareaLocalizacionPresupuestoVenta> dtoList = new ArrayList<>();
        AtomicDouble importeSinIva = new AtomicDouble(0);
        AtomicDouble importeConIva = new AtomicDouble(0);
        if (CollectionUtils.isNotEmpty(src)) {
            src.stream().forEach(item -> {
                item.getListaSeccion().stream().forEach(venta -> {
                    TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = delegate.responseItemDtoToTareaLocalizacionPresupuestoVenta(item, tarea);
                    tareaLocalizacionPresupuestoVenta.setCclIdSeccion(String.valueOf(venta.getSeccion()));
                    tareaLocalizacionPresupuestoVenta.setImporteSinImpuestos(venta.getImporteSinIVA().doubleValue());
                    tareaLocalizacionPresupuestoVenta.setImporteConImpuestos(venta.getImporteConIVA().doubleValue());
                    tareaLocalizacionPresupuestoVenta.setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder().id(TipoVentaConceptoChallengeEnum.ENTREGA_DOMICILIO.getId()).build());    
                    tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId()).build());

                    dtoList.add(tareaLocalizacionPresupuestoVenta);
                    importeSinIva.getAndAdd(tareaLocalizacionPresupuestoVenta.getImporteSinImpuestos());
                    importeConIva.getAndAdd(tareaLocalizacionPresupuestoVenta.getImporteConImpuestos());
                });
                TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVenta = delegate.responseItemDtoToTareaLocalizacionPresupuestoVenta(item, tarea);
                tareaLocalizacionPresupuestoVenta.setImporteConImpuestos(importeConIva.doubleValue());
                tareaLocalizacionPresupuestoVenta.setImporteSinImpuestos(importeSinIva.doubleValue());
                tareaLocalizacionPresupuestoVenta.setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder().id(TipoVentaConceptoChallengeEnum.ENTREGA_DOMICILIO.getId()).build());    
                tareaLocalizacionPresupuestoVenta.setTipoDato(TipoDato.builder().id(TipoDatoEnum.VENTA_RANGO_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId()).build());

                dtoList.add(tareaLocalizacionPresupuestoVenta);
            });
        }
        return dtoList;
    }

}
