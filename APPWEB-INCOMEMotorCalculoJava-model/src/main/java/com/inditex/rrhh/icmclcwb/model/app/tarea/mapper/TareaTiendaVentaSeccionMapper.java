package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaVentaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaTiendaVentaSeccionDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaVentaSeccion;

@Mapper
@DecoratedWith(TareaTiendaVentaSeccionDecorator.class)
public abstract class TareaTiendaVentaSeccionMapper {

    public abstract TareaTiendaVentaSeccion tareaTiendaVentaSeccionDtoToTareaTiendaVentaSeccion(
            TareaTiendaVentaSeccionDto src);

    public abstract List<TareaTiendaVentaSeccion> tareaTiendaVentaSeccionDtoToTareaTiendaVentaSeccion(
            List<TareaTiendaVentaSeccionDto> src);

    public abstract TareaTiendaVentaSeccionDto tareaTiendaVentaSeccionToTareaTiendaVentaSeccionDto(
            TareaTiendaVentaSeccion src);

    public abstract List<TareaTiendaVentaSeccionDto> tareaTiendaVentaSeccionToTareaTiendaVentaSeccionDto(
            List<TareaTiendaVentaSeccion> src);
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaVentaSeccion getVentaTotalizadoResponseItemDtoToTareaTiendaVentaSeccion(
            PtrVentaTotalizadoResultItemDto src, TareaDto tarea);
    
    public List<TareaTiendaVentaSeccion> getVentaTotalizadoResponseItemDtoToTareaTiendaVentaSeccion(
            List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaVentaSeccion tareaTiendaVentaSeccion, PtrVentaTotalizadoResultItemDto src){
        setListaSeccion(tareaTiendaVentaSeccion, src.getListaSeccion(), TipoDatoEnum.IMPORTE_VENTA_FISICA_LOCALIZACION_SECCION);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaVentaSeccion getVentaOnlineIpodResponseItemDtoToTareaTiendaVentaSeccion(
            PtrVentaOnlineIpodResultItemDto src, TareaDto tarea);
    
    public List<TareaTiendaVentaSeccion> getVentaOnlineIpodResponseItemDtoToTareaTiendaVentaSeccion(
            List<PtrVentaOnlineIpodResultItemDto> src, TareaDto tarea){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaVentaSeccion tareaTiendaVentaSeccion, PtrVentaOnlineIpodResultItemDto src){
        setListaSeccion(tareaTiendaVentaSeccion, src.getListaSeccion(), TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaVentaSeccion getVentaOnlineIpodIndividualDetalleResponseItemDtoToTareaTiendaVentaSeccion(
            PtrVentaOnlineIpodIndividualDetalleResultItemDto src, TareaDto tarea);
    
    public List<TareaTiendaVentaSeccion> getVentaOnlineIpodIndividualDetalleResponseItemDtoToTareaTiendaVentaSeccion(
            List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tarea){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaVentaSeccion tareaTiendaVentaSeccion, PtrVentaOnlineIpodIndividualDetalleResultItemDto src){
        setListaSeccion(tareaTiendaVentaSeccion, src.getListaSeccion(), TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaVentaSeccion getVentaOnlinePickingResponseItemDtoToTareaTiendaVentaSeccion(
            PtrVentaOnlinePickingResultItemDto src, TareaDto tarea);
    
    public List<TareaTiendaVentaSeccion> getVentaOnlinePickingResponseItemDtoToTareaTiendaVentaSeccion(
            List<PtrVentaOnlinePickingResultItemDto> src, TareaDto tarea){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaVentaSeccion tareaTiendaVentaSeccion, PtrVentaOnlinePickingResultItemDto src){
        setListaSeccion(tareaTiendaVentaSeccion, src.getListaSeccion(), TipoDatoEnum.IMPORTE_VENTA_ONLINE_PICKING_LOCALIZACION_SECCION);
    }

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaVentaSeccion getVentaOnlineEntregaTiendaResponseItemDtoToTareaTiendaVentaSeccion(
            PtrVentaOnlineEntregaTiendaResultItemDto src, TareaDto tarea);
    
    public List<TareaTiendaVentaSeccion> getVentaOnlineEntregaTiendaResponseItemDtoToTareaTiendaVentaSeccion(
            List<PtrVentaOnlineEntregaTiendaResultItemDto> src, TareaDto tarea){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaVentaSeccion tareaTiendaVentaSeccion, PtrVentaOnlineEntregaTiendaResultItemDto src){
        setListaSeccion(tareaTiendaVentaSeccion, src.getListaSeccion(), TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION_SECCION);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaVentaSeccion getVentaOnlineEntregaDomicilioResponseItemDtoToTareaTiendaVentaSeccion(
            PtrVentaOnlineEntregaDomicilioResultItemDto src, TareaDto tarea);
    
    public List<TareaTiendaVentaSeccion> getVentaOnlineEntregaDomicilioResponseItemDtoToTareaTiendaVentaSeccion(
            List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tarea){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaVentaSeccion tareaTiendaVentaSeccion, PtrVentaOnlineEntregaDomicilioResultItemDto src){
        setListaSeccion(tareaTiendaVentaSeccion, src.getListaSeccion(), TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION_SECCION);
    }
    
    private void setListaSeccion(TareaTiendaVentaSeccion tareaTiendaVentaSeccion,
            List<PtrSeccionVentaOnlineGenericType> listaSeccion, TipoDatoEnum tipoImporteVenta) {
        if (listaSeccion != null ) {
            for (PtrSeccionVentaOnlineGenericType item : listaSeccion) {
                if (PtrConstants.SECCION_1.equals(item.getSeccion())) {
                    tareaTiendaVentaSeccion.setImporte1(item.getImporteSinIVA().doubleValue());
                    tareaTiendaVentaSeccion.setImporteConImpuestos1(item.getImporteConIVA().doubleValue());
                } else if (PtrConstants.SECCION_2.equals(item.getSeccion())) {
                    tareaTiendaVentaSeccion.setImporte2(item.getImporteSinIVA().doubleValue());
                    tareaTiendaVentaSeccion.setImporteConImpuestos2(item.getImporteConIVA().doubleValue());
                } else if (PtrConstants.SECCION_3.equals(item.getSeccion())) {
                    tareaTiendaVentaSeccion.setImporte3(item.getImporteSinIVA().doubleValue());
                    tareaTiendaVentaSeccion.setImporteConImpuestos3(item.getImporteConIVA().doubleValue());
                }
            } 
        }
        tareaTiendaVentaSeccion.setTipoDato(new TipoDato());
        tareaTiendaVentaSeccion.getTipoDato().setId(tipoImporteVenta.getId());
    }
}
