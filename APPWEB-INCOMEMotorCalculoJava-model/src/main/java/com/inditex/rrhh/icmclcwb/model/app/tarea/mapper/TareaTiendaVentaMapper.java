package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaTiendaVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaVenta;

@Mapper
@DecoratedWith(TareaTiendaVentaDecorator.class)
public abstract class TareaTiendaVentaMapper {

    public abstract TareaTiendaVenta tareaTiendaVentaDtoToTareaTiendaVenta(
            TareaTiendaVentaDto src);

    public abstract List<TareaTiendaVenta> tareaTiendaVentasDtoToTareaTiendaVentas(
            List<TareaTiendaVentaDto> src);

    public abstract TareaTiendaVentaDto tareaTiendaVentaToTareaTiendaVentaDto(
            TareaTiendaVenta src);

    public abstract List<TareaTiendaVentaDto> tareaTiendaVentasToTareaTiendaVentasDto(
            List<TareaTiendaVenta> src);

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.cadena", target = "idCadena")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaVenta getVentaTotalizadoResponseItemDtoToTareaTiendaVenta(
            PtrVentaTotalizadoResultItemDto src, TareaDto tarea);

    public List<TareaTiendaVenta> getVentaTotalizadoReponseItemsDtoToTareaTiendaVentas(
            List<PtrVentaTotalizadoResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaVenta tareaTiendaVenta, PtrVentaTotalizadoResultItemDto src){
        tareaTiendaVenta.setTipoDato(new TipoDato());
        tareaTiendaVenta.getTipoDato().setId(TipoDatoEnum.IMPORTE_VENTA_FISICA_LOCALIZACION.getId());
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "src.cadena", target = "idCadena")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaVenta getVentaOnlineEntregaDomicilioReponseItemsDtoToTareaTiendaVentas(
            PtrVentaOnlineEntregaDomicilioResultItemDto src, TareaDto tarea);

    public List<TareaTiendaVenta> getVentaOnlineEntregaDomicilioReponseItemsDtoToTareaTiendaVentas(
            List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaVenta tareaTiendaVenta, PtrVentaOnlineEntregaDomicilioResultItemDto src){
        tareaTiendaVenta.setTipoDato(new TipoDato());
        tareaTiendaVenta.getTipoDato().setId(TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION.getId());
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.cadena", target = "idCadena")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaVenta getVentaOnlineEntregaTiendaReponseItemsDtoToTareaTiendaVentas(
            PtrVentaOnlineEntregaTiendaResultItemDto src, TareaDto tarea);

    public List<TareaTiendaVenta> getVentaOnlineEntregaTiendaReponseItemsDtoToTareaTiendaVentas(
            List<PtrVentaOnlineEntregaTiendaResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaVenta tareaTiendaVenta, PtrVentaOnlineEntregaTiendaResultItemDto src){
        tareaTiendaVenta.setTipoDato(new TipoDato());
        tareaTiendaVenta.getTipoDato().setId(TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION.getId());
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.cadena", target = "idCadena")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaVenta getVentaOnlinePickingReponseItemsDtoToTareaTiendaVentas(
            PtrVentaOnlinePickingResultItemDto src, TareaDto tarea);

    public List<TareaTiendaVenta> getVentaOnlinePickingReponseItemsDtoToTareaTiendaVentas(
            List<PtrVentaOnlinePickingResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaVenta tareaTiendaVenta, PtrVentaOnlinePickingResultItemDto src){
        tareaTiendaVenta.setTipoDato(new TipoDato());
        tareaTiendaVenta.getTipoDato().setId(TipoDatoEnum.IMPORTE_VENTA_ONLINE_PICKING_LOCALIZACION.getId());
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.cadena", target = "idCadena")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaVenta getVentaOnlineIpodReponseItemsDtoToTareaTiendaVentas(
            PtrVentaOnlineIpodResultItemDto src, TareaDto tarea);

    public List<TareaTiendaVenta> getVentaOnlineIpodReponseItemsDtoToTareaTiendaVentas(
            List<PtrVentaOnlineIpodResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaVenta tareaTiendaVenta, PtrVentaOnlineIpodResultItemDto src){
        tareaTiendaVenta.setTipoDato(new TipoDato());
        tareaTiendaVenta.getTipoDato().setId(TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION.getId());
    }
    
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.cadena", target = "idCadena")
    @Mapping(source = "tarea.id", target = "tarea.id")
    public abstract TareaTiendaVenta getVentaIndividualDetalleReponseItemsDtoToTareaTiendaVentas(
            PtrVentaIndividualDetalleResultItemDto src, TareaDto tarea);

    public List<TareaTiendaVenta> getVentaIndividualDetalleReponseItemsDtoToTareaTiendaVentas(
            List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaVenta tareaTiendaVenta, PtrVentaIndividualDetalleResultItemDto src){
        tareaTiendaVenta.setTipoDato(new TipoDato());
        tareaTiendaVenta.getTipoDato().setId(TipoDatoEnum.IMPORTE_VENTA_FISICA_INDIVIDUAL_LOCALIZACION.getId());
    }
}
