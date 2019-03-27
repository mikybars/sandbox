package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoImporteVentaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaTiendaSeccionVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoImporteVenta;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaSeccionVenta;

@Mapper
@DecoratedWith(TareaTiendaSeccionVentaDecorator.class)
public abstract class TareaTiendaSeccionVentaMapper {

    public abstract TareaTiendaSeccionVenta tareaTiendaSeccionVentaDtoToTareaTiendaSeccionVenta(
            TareaTiendaSeccionVentaDto src);

    public abstract List<TareaTiendaSeccionVenta> tareaTiendaSeccionVentasDtoToTareaTiendaSeccionVentas(
            List<TareaTiendaSeccionVentaDto> src);

    public abstract TareaTiendaSeccionVentaDto tareaTiendaSeccionVentaToTareaTiendaSeccionVentaDto(
            TareaTiendaSeccionVenta src);

    public abstract List<TareaTiendaSeccionVentaDto> tareaTiendaSeccionVentasToTareaTiendaSeccionVentasDto(
            List<TareaTiendaSeccionVenta> src);

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.seccion", target = "idSeccion")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaSeccionVenta getVentaTotalizadoResponseItemDtoToTareaTiendaSeccionVenta(
            PtrVentaTotalizadoResultItemDto src, TareaDto tarea);

    public List<TareaTiendaSeccionVenta> getVentaTotalizadoReponseItemsDtoToTareaTiendaSeccionVentas(
            List<PtrVentaTotalizadoResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaSeccionVenta tareaTiendaSeccionVenta, PtrVentaTotalizadoResultItemDto src){
        tareaTiendaSeccionVenta.setTipoImporteVenta(new TipoImporteVenta());
        tareaTiendaSeccionVenta.getTipoImporteVenta().setId(TipoImporteVentaEnum.IMPORTE_VENTA_FISICA_LOCALIZACION_SECCION.getId());
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.seccion", target = "idSeccion")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaSeccionVenta getVentaOnlineEntregaDomicilioReponseItemsDtoToTareaTiendaSeccionVentas(
            PtrVentaOnlineEntregaDomicilioResultItemDto src, TareaDto tarea);

    public List<TareaTiendaSeccionVenta> getVentaOnlineEntregaDomicilioReponseItemsDtoToTareaTiendaSeccionVentas(
            List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaSeccionVenta tareaTiendaSeccionVenta, PtrVentaOnlineEntregaDomicilioResultItemDto src){
        tareaTiendaSeccionVenta.setTipoImporteVenta(new TipoImporteVenta());
        tareaTiendaSeccionVenta.getTipoImporteVenta().setId(TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION_SECCION.getId());
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.seccion", target = "idSeccion")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaSeccionVenta getVentaOnlineEntregaTiendaReponseItemsDtoToTareaTiendaSeccionVentas(
            PtrVentaOnlineEntregaTiendaResultItemDto src, TareaDto tarea);

    public List<TareaTiendaSeccionVenta> getVentaOnlineEntregaTiendaReponseItemsDtoToTareaTiendaSeccionVentas(
            List<PtrVentaOnlineEntregaTiendaResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaSeccionVenta tareaTiendaSeccionVenta, PtrVentaOnlineEntregaTiendaResultItemDto src){
        tareaTiendaSeccionVenta.setTipoImporteVenta(new TipoImporteVenta());
        tareaTiendaSeccionVenta.getTipoImporteVenta().setId(TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION_SECCION.getId());
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.seccion", target = "idSeccion")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaSeccionVenta getVentaOnlinePickingReponseItemsDtoToTareaTiendaSeccionVentas(
            PtrVentaOnlinePickingResultItemDto src, TareaDto tarea);

    public List<TareaTiendaSeccionVenta> getVentaOnlinePickingReponseItemsDtoToTareaTiendaSeccionVentas(
            List<PtrVentaOnlinePickingResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaSeccionVenta tareaTiendaSeccionVenta, PtrVentaOnlinePickingResultItemDto src){
        tareaTiendaSeccionVenta.setTipoImporteVenta(new TipoImporteVenta());
        tareaTiendaSeccionVenta.getTipoImporteVenta().setId(TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_PICKING_LOCALIZACION_SECCION.getId());
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.seccion", target = "idSeccion")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaSeccionVenta getVentaOnlineIpodReponseItemsDtoToTareaTiendaSeccionVentas(
            PtrVentaOnlineIpodResultItemDto src, TareaDto tarea);

    public List<TareaTiendaSeccionVenta> getVentaOnlineIpodReponseItemsDtoToTareaTiendaSeccionVentas(
            List<PtrVentaOnlineIpodResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaSeccionVenta tareaTiendaSeccionVenta, PtrVentaOnlineIpodResultItemDto src){
        tareaTiendaSeccionVenta.setTipoImporteVenta(new TipoImporteVenta());
        tareaTiendaSeccionVenta.getTipoImporteVenta().setId(TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId());
    }
}
