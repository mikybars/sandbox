package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;
import java.util.Optional;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaTiendaSeccionVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaSeccionVenta;

@Mapper
@DecoratedWith(TareaTiendaSeccionVentaDecorator.class)
public abstract class TareaTiendaSeccionVentaMapper {
    
    public abstract TareaTiendaSeccionVenta tareaTiendaSeccionVentaDtoToTareaTiendaSeccionVenta(
            TareaTiendaSeccionVentaDto src);

    public abstract List<TareaTiendaSeccionVenta> tareaTiendaSeccionVentaDtoToTareaTiendaSeccionVenta(
            List<TareaTiendaSeccionVentaDto> src);

    public abstract TareaTiendaSeccionVentaDto tareaTiendaSeccionVentaToTareaTiendaSeccionVentaDto(
            TareaTiendaSeccionVenta src);

    public abstract List<TareaTiendaSeccionVentaDto> tareaTiendaSeccionVentaToTareaTiendaSeccionVentaDto(
            List<TareaTiendaSeccionVenta> src);
    
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaSeccionVenta ventaTotalizadoResponseItemDtoToTareaTiendaSeccionVenta(
            PtrVentaTotalizadoResultItemDto src, TareaDto tarea, Integer idSeccion);
    
    public List<TareaTiendaSeccionVenta> ventaTotalizadoResponseItemDtoToTareaTiendaSeccionVenta(
            List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea, Integer idSeccion) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void ventaTotalizadoResponseItemDtoToTareaTiendaSeccionVenta(
            @MappingTarget TareaTiendaSeccionVenta dest,
            PtrVentaTotalizadoResultItemDto src, TareaDto tarea, Integer idSeccion) {
        setImporteSeccion(dest, src.getListaSeccion(), idSeccion, TipoDatoEnum.IMPORTE_VENTA_FISICA_LOCALIZACION_SECCION);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaSeccionVenta ventaOnlineIpodResponseItemDtoToTareaTiendaSeccionVenta(
            PtrVentaOnlineIpodResultItemDto src, TareaDto tarea, Integer idSeccion);
    
    public List<TareaTiendaSeccionVenta> ventaOnlineIpodResponseItemDtoToTareaTiendaSeccionVenta(
            List<PtrVentaOnlineIpodResultItemDto> src, TareaDto tarea, Integer idSeccion){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void ventaOnlineIpodResponseItemDtoToTareaTiendaSeccionVenta(@MappingTarget TareaTiendaSeccionVenta dest, 
            PtrVentaOnlineIpodResultItemDto src, TareaDto tarea, Integer idSeccion) {
        setImporteSeccion(dest, src.getListaSeccion(), idSeccion, TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaSeccionVenta ventaOnlineIpodIndividualDetalleResponseItemDtoToTareaTiendaSeccionVenta(
            PtrVentaOnlineIpodIndividualDetalleResultItemDto src, TareaDto tarea, Integer idSeccion);
    
    public List<TareaTiendaSeccionVenta> ventaOnlineIpodIndividualDetalleResponseItemDtoToTareaTiendaSeccionVenta(
            List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tarea, Integer idSeccion){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void ventaOnlineIpodIndividualDetalleResponseItemDtoToTareaTiendaSeccionVenta(@MappingTarget TareaTiendaSeccionVenta dest, 
            PtrVentaOnlineIpodIndividualDetalleResultItemDto src, TareaDto tarea, Integer idSeccion) {
        setImporteSeccion(dest, src.getListaSeccion(), idSeccion, TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaSeccionVenta ventaOnlinePickingResponseItemDtoToTareaTiendaSeccionVenta(
            PtrVentaOnlinePickingResultItemDto src, TareaDto tarea, Integer idSeccion);
    
    public List<TareaTiendaSeccionVenta> ventaOnlinePickingResponseItemDtoToTareaTiendaSeccionVenta(
            List<PtrVentaOnlinePickingResultItemDto> src, TareaDto tarea, Integer idSeccion){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void ventaOnlinePickingResponseItemDtoToTareaTiendaSeccionVenta(@MappingTarget TareaTiendaSeccionVenta dest, 
            PtrVentaOnlinePickingResultItemDto src, TareaDto tarea, Integer idSeccion) {
        setImporteSeccion(dest, src.getListaSeccion(), idSeccion, TipoDatoEnum.IMPORTE_VENTA_ONLINE_PICKING_LOCALIZACION_SECCION);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaSeccionVenta ventaOnlineEntregaTiendaResponseItemDtoToTareaTiendaSeccionVenta(
            PtrVentaOnlineEntregaTiendaResultItemDto src, TareaDto tarea, Integer idSeccion);
    
    public List<TareaTiendaSeccionVenta> ventaOnlineEntregaTiendaResponseItemDtoToTareaTiendaSeccionVenta(
            List<PtrVentaOnlineEntregaTiendaResultItemDto> src, TareaDto tarea, Integer idSeccion){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void ventaOnlineEntregaTiendaResponseItemDtoToTareaTiendaSeccionVenta(@MappingTarget TareaTiendaSeccionVenta dest, 
            PtrVentaOnlineEntregaTiendaResultItemDto src, TareaDto tarea, Integer idSeccion) {
        setImporteSeccion(dest, src.getListaSeccion(), idSeccion, TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION_SECCION);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaSeccionVenta ventaOnlineEntregaDomicilioResponseItemDtoToTareaTiendaSeccionVenta(
            PtrVentaOnlineEntregaDomicilioResultItemDto src, TareaDto tarea, Integer idSeccion);
    
    public List<TareaTiendaSeccionVenta> ventaOnlineEntregaDomicilioResponseItemDtoToTareaTiendaSeccionVenta(
            List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tarea, Integer idSeccion){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void ventaOnlineEntregaDomicilioResponseItemDtoToTareaTiendaSeccionVenta(@MappingTarget TareaTiendaSeccionVenta dest, 
            PtrVentaOnlineEntregaDomicilioResultItemDto src, TareaDto tarea, Integer idSeccion) {
        setImporteSeccion(dest, src.getListaSeccion(), idSeccion, TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION_SECCION);
    }
    
    private void setImporteSeccion(TareaTiendaSeccionVenta dest, 
            List<PtrSeccionVentaOnlineGenericType> listaSeccion, Integer idSeccion, 
            TipoDatoEnum tipoImporteVenta) {
        dest.setImporte(0D);
        dest.setImporteConImpuestos(0D);
        if (listaSeccion != null) {
            Optional<PtrSeccionVentaOnlineGenericType> optional = listaSeccion.stream().filter(x -> x.getSeccion() == idSeccion).findFirst();
            if (optional.isPresent()) {
                PtrSeccionVentaOnlineGenericType seccion = optional.get();
                dest.setImporte(seccion.getImporteSinIVA().doubleValue());
                dest.setImporteConImpuestos(seccion.getImporteConIVA().doubleValue());
            }
        }
        dest.setTipoDato(new TipoDato());
        dest.getTipoDato().setId(tipoImporteVenta.getId());
    }

}
