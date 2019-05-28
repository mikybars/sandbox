package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;

@Mapper
@DecoratedWith(TareaLocalizacionVentaDecorator.class)
public abstract class TareaLocalizacionVentaMapper {

    public abstract TareaLocalizacionVenta tareaLocalizacionVentaDtoToTareaLocalizacionVenta(
            TareaLocalizacionVentaDto src);

    public abstract List<TareaLocalizacionVenta> tareaLocalizacionVentasDtoToTareaLocalizacionVentas(
            List<TareaLocalizacionVentaDto> src);

    public abstract TareaLocalizacionVentaDto tareaLocalizacionVentaToTareaLocalizacionVentaDto(
            TareaLocalizacionVenta src);

    public abstract List<TareaLocalizacionVentaDto> tareaLocalizacionVentasToTareaLocalizacionVentasDto(
            List<TareaLocalizacionVenta> src);

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.cadena", target = "idCadena")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionVenta getVentaTotalizadoResponseItemDtoToTareaLocalizacionVenta(
            PtrVentaTotalizadoResultItemDto src, TareaDto tarea);

    public List<TareaLocalizacionVenta> getVentaTotalizadoReponseItemsDtoToTareaLocalizacionVentas(
            List<PtrVentaTotalizadoResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionVenta tareaLocalizacionVenta, PtrVentaTotalizadoResultItemDto src){
        tareaLocalizacionVenta.setTipoDato(new TipoDato());
        tareaLocalizacionVenta.getTipoDato().setId(TipoDatoEnum.IMPORTE_VENTA_FISICA_LOCALIZACION.getId());
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "src.cadena", target = "idCadena")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionVenta getVentaOnlineEntregaDomicilioReponseItemsDtoToTareaLocalizacionVentas(
            PtrVentaOnlineEntregaDomicilioResultItemDto src, TareaDto tarea);

    public List<TareaLocalizacionVenta> getVentaOnlineEntregaDomicilioReponseItemsDtoToTareaLocalizacionVentas(
            List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionVenta tareaLocalizacionVenta, PtrVentaOnlineEntregaDomicilioResultItemDto src){
        tareaLocalizacionVenta.setTipoDato(new TipoDato());
        tareaLocalizacionVenta.getTipoDato().setId(TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION.getId());
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.cadena", target = "idCadena")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionVenta getVentaOnlineEntregaTiendaReponseItemsDtoToTareaLocalizacionVentas(
            PtrVentaOnlineEntregaTiendaResultItemDto src, TareaDto tarea);

    public List<TareaLocalizacionVenta> getVentaOnlineEntregaTiendaReponseItemsDtoToTareaLocalizacionVentas(
            List<PtrVentaOnlineEntregaTiendaResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionVenta tareaLocalizacionVenta, PtrVentaOnlineEntregaTiendaResultItemDto src){
        tareaLocalizacionVenta.setTipoDato(new TipoDato());
        tareaLocalizacionVenta.getTipoDato().setId(TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION.getId());
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.cadena", target = "idCadena")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionVenta getVentaOnlinePickingReponseItemsDtoToTareaLocalizacionVentas(
            PtrVentaOnlinePickingResultItemDto src, TareaDto tarea);

    public List<TareaLocalizacionVenta> getVentaOnlinePickingReponseItemsDtoToTareaLocalizacionVentas(
            List<PtrVentaOnlinePickingResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionVenta tareaLocalizacionVenta, PtrVentaOnlinePickingResultItemDto src){
        tareaLocalizacionVenta.setTipoDato(new TipoDato());
        tareaLocalizacionVenta.getTipoDato().setId(TipoDatoEnum.IMPORTE_VENTA_ONLINE_PICKING_LOCALIZACION.getId());
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.cadena", target = "idCadena")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionVenta getVentaOnlineIpodReponseItemsDtoToTareaLocalizacionVentas(
            PtrVentaOnlineIpodResultItemDto src, TareaDto tarea);

    public List<TareaLocalizacionVenta> getVentaOnlineIpodReponseItemsDtoToTareaLocalizacionVentas(
            List<PtrVentaOnlineIpodResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionVenta tareaLocalizacionVenta, PtrVentaOnlineIpodResultItemDto src){
        tareaLocalizacionVenta.setTipoDato(new TipoDato());
        tareaLocalizacionVenta.getTipoDato().setId(TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION.getId());
    }
    
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.cadena", target = "idCadena")
    @Mapping(source = "tarea.id", target = "tarea.id")
    public abstract TareaLocalizacionVenta getVentaIndividualDetalleReponseItemsDtoToTareaLocalizacionVentas(
            PtrVentaIndividualDetalleResultItemDto src, TareaDto tarea);

    public List<TareaLocalizacionVenta> getVentaIndividualDetalleReponseItemsDtoToTareaLocalizacionVentas(
            List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionVenta tareaLocalizacionVenta, PtrVentaIndividualDetalleResultItemDto src){
        tareaLocalizacionVenta.setTipoDato(new TipoDato());
        tareaLocalizacionVenta.getTipoDato().setId(TipoDatoEnum.IMPORTE_VENTA_FISICA_INDIVIDUAL_LOCALIZACION.getId());
    }
}
