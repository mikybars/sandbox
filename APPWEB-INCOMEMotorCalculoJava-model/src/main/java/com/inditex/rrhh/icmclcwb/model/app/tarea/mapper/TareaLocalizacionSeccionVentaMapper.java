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
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionSeccionVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionSeccionVenta;

@Mapper
@DecoratedWith(TareaLocalizacionSeccionVentaDecorator.class)
public abstract class TareaLocalizacionSeccionVentaMapper {
    
    public abstract TareaLocalizacionSeccionVenta tareaLocalizacionSeccionVentaDtoToTareaLocalizacionSeccionVenta(
            TareaLocalizacionSeccionVentaDto src);

    public abstract List<TareaLocalizacionSeccionVenta> tareaLocalizacionSeccionVentaDtoToTareaLocalizacionSeccionVenta(
            List<TareaLocalizacionSeccionVentaDto> src);

    public abstract TareaLocalizacionSeccionVentaDto tareaLocalizacionSeccionVentaToTareaLocalizacionSeccionVentaDto(
            TareaLocalizacionSeccionVenta src);

    public abstract List<TareaLocalizacionSeccionVentaDto> tareaLocalizacionSeccionVentaToTareaLocalizacionSeccionVentaDto(
            List<TareaLocalizacionSeccionVenta> src);
    
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionSeccionVenta ventaTotalizadoResponseItemDtoToTareaLocalizacionSeccionVenta(
            PtrVentaTotalizadoResultItemDto src, TareaDto tarea, Integer idSeccion);
    
    public List<TareaLocalizacionSeccionVenta> ventaTotalizadoResponseItemDtoToTareaLocalizacionSeccionVenta(
            List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea, Integer idSeccion) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void ventaTotalizadoResponseItemDtoToTareaLocalizacionSeccionVenta(
            @MappingTarget TareaLocalizacionSeccionVenta dest,
            PtrVentaTotalizadoResultItemDto src, TareaDto tarea, Integer idSeccion) {
        setImporteSeccion(dest, src.getListaSeccion(), idSeccion, TipoDatoEnum.IMPORTE_VENTA_FISICA_LOCALIZACION_SECCION);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionSeccionVenta ventaOnlineIpodResponseItemDtoToTareaLocalizacionSeccionVenta(
            PtrVentaOnlineIpodResultItemDto src, TareaDto tarea, Integer idSeccion);
    
    public List<TareaLocalizacionSeccionVenta> ventaOnlineIpodResponseItemDtoToTareaLocalizacionSeccionVenta(
            List<PtrVentaOnlineIpodResultItemDto> src, TareaDto tarea, Integer idSeccion){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void ventaOnlineIpodResponseItemDtoToTareaLocalizacionSeccionVenta(@MappingTarget TareaLocalizacionSeccionVenta dest, 
            PtrVentaOnlineIpodResultItemDto src, TareaDto tarea, Integer idSeccion) {
        setImporteSeccion(dest, src.getListaSeccion(), idSeccion, TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionSeccionVenta ventaOnlineIpodIndividualDetalleResponseItemDtoToTareaLocalizacionSeccionVenta(
            PtrVentaOnlineIpodIndividualDetalleResultItemDto src, TareaDto tarea, Integer idSeccion);
    
    public List<TareaLocalizacionSeccionVenta> ventaOnlineIpodIndividualDetalleResponseItemDtoToTareaLocalizacionSeccionVenta(
            List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tarea, Integer idSeccion){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void ventaOnlineIpodIndividualDetalleResponseItemDtoToTareaLocalizacionSeccionVenta(@MappingTarget TareaLocalizacionSeccionVenta dest, 
            PtrVentaOnlineIpodIndividualDetalleResultItemDto src, TareaDto tarea, Integer idSeccion) {
        setImporteSeccion(dest, src.getListaSeccion(), idSeccion, TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionSeccionVenta ventaOnlinePickingResponseItemDtoToTareaLocalizacionSeccionVenta(
            PtrVentaOnlinePickingResultItemDto src, TareaDto tarea, Integer idSeccion);
    
    public List<TareaLocalizacionSeccionVenta> ventaOnlinePickingResponseItemDtoToTareaLocalizacionSeccionVenta(
            List<PtrVentaOnlinePickingResultItemDto> src, TareaDto tarea, Integer idSeccion){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void ventaOnlinePickingResponseItemDtoToTareaLocalizacionSeccionVenta(@MappingTarget TareaLocalizacionSeccionVenta dest, 
            PtrVentaOnlinePickingResultItemDto src, TareaDto tarea, Integer idSeccion) {
        setImporteSeccion(dest, src.getListaSeccion(), idSeccion, TipoDatoEnum.IMPORTE_VENTA_ONLINE_PICKING_LOCALIZACION_SECCION);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionSeccionVenta ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionSeccionVenta(
            PtrVentaOnlineEntregaTiendaResultItemDto src, TareaDto tarea, Integer idSeccion);
    
    public List<TareaLocalizacionSeccionVenta> ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionSeccionVenta(
            List<PtrVentaOnlineEntregaTiendaResultItemDto> src, TareaDto tarea, Integer idSeccion){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionSeccionVenta(@MappingTarget TareaLocalizacionSeccionVenta dest, 
            PtrVentaOnlineEntregaTiendaResultItemDto src, TareaDto tarea, Integer idSeccion) {
        setImporteSeccion(dest, src.getListaSeccion(), idSeccion, TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION_SECCION);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionSeccionVenta ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionSeccionVenta(
            PtrVentaOnlineEntregaDomicilioResultItemDto src, TareaDto tarea, Integer idSeccion);
    
    public List<TareaLocalizacionSeccionVenta> ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionSeccionVenta(
            List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tarea, Integer idSeccion){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionSeccionVenta(@MappingTarget TareaLocalizacionSeccionVenta dest, 
            PtrVentaOnlineEntregaDomicilioResultItemDto src, TareaDto tarea, Integer idSeccion) {
        setImporteSeccion(dest, src.getListaSeccion(), idSeccion, TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION_SECCION);
    }
    
    private void setImporteSeccion(TareaLocalizacionSeccionVenta dest, 
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
