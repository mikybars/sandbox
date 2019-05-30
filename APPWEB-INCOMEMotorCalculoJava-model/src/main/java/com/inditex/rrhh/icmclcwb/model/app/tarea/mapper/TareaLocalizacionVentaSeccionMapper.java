package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionVentaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionVentaSeccionDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVentaSeccion;

@Mapper
@DecoratedWith(TareaLocalizacionVentaSeccionDecorator.class)
public abstract class TareaLocalizacionVentaSeccionMapper {

    public abstract TareaLocalizacionVentaSeccion tareaLocalizacionVentaSeccionDtoToTareaLocalizacionVentaSeccion(
            TareaLocalizacionVentaSeccionDto src);

    public abstract List<TareaLocalizacionVentaSeccion> tareaLocalizacionVentaSeccionDtoToTareaLocalizacionVentaSeccion(
            List<TareaLocalizacionVentaSeccionDto> src);

    public abstract TareaLocalizacionVentaSeccionDto tareaLocalizacionVentaSeccionToTareaLocalizacionVentaSeccionDto(
            TareaLocalizacionVentaSeccion src);

    public abstract List<TareaLocalizacionVentaSeccionDto> tareaLocalizacionVentaSeccionToTareaLocalizacionVentaSeccionDto(
            List<TareaLocalizacionVentaSeccion> src);
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionVentaSeccion getVentaTotalizadoResponseItemDtoToTareaLocalizacionVentaSeccion(
            PtrVentaTotalizadoResultItemDto src, TareaDto tarea);
    
    public List<TareaLocalizacionVentaSeccion> getVentaTotalizadoResponseItemDtoToTareaLocalizacionVentaSeccion(
            List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionVentaSeccion tareaLocalizacionVentaSeccion, PtrVentaTotalizadoResultItemDto src){
        setListaSeccion(tareaLocalizacionVentaSeccion, src.getListaSeccion(), TipoDatoEnum.IMPORTE_VENTA_FISICA_LOCALIZACION_SECCION);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionVentaSeccion getVentaOnlineIpodResponseItemDtoToTareaLocalizacionVentaSeccion(
            PtrVentaOnlineIpodResultItemDto src, TareaDto tarea);
    
    public List<TareaLocalizacionVentaSeccion> getVentaOnlineIpodResponseItemDtoToTareaLocalizacionVentaSeccion(
            List<PtrVentaOnlineIpodResultItemDto> src, TareaDto tarea){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionVentaSeccion tareaLocalizacionVentaSeccion, PtrVentaOnlineIpodResultItemDto src){
        setListaSeccion(tareaLocalizacionVentaSeccion, src.getListaSeccion(), TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionVentaSeccion getVentaOnlineIpodIndividualDetalleResponseItemDtoToTareaLocalizacionVentaSeccion(
            PtrVentaOnlineIpodIndividualDetalleResultItemDto src, TareaDto tarea);
    
    public List<TareaLocalizacionVentaSeccion> getVentaOnlineIpodIndividualDetalleResponseItemDtoToTareaLocalizacionVentaSeccion(
            List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tarea){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionVentaSeccion tareaLocalizacionVentaSeccion, PtrVentaOnlineIpodIndividualDetalleResultItemDto src){
        setListaSeccion(tareaLocalizacionVentaSeccion, src.getListaSeccion(), TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionVentaSeccion getVentaOnlinePickingResponseItemDtoToTareaLocalizacionVentaSeccion(
            PtrVentaOnlinePickingResultItemDto src, TareaDto tarea);
    
    public List<TareaLocalizacionVentaSeccion> getVentaOnlinePickingResponseItemDtoToTareaLocalizacionVentaSeccion(
            List<PtrVentaOnlinePickingResultItemDto> src, TareaDto tarea){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionVentaSeccion tareaLocalizacionVentaSeccion, PtrVentaOnlinePickingResultItemDto src){
        setListaSeccion(tareaLocalizacionVentaSeccion, src.getListaSeccion(), TipoDatoEnum.IMPORTE_VENTA_ONLINE_PICKING_LOCALIZACION_SECCION);
    }

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionVentaSeccion getVentaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionVentaSeccion(
            PtrVentaOnlineEntregaTiendaResultItemDto src, TareaDto tarea);
    
    public List<TareaLocalizacionVentaSeccion> getVentaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionVentaSeccion(
            List<PtrVentaOnlineEntregaTiendaResultItemDto> src, TareaDto tarea){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionVentaSeccion tareaLocalizacionVentaSeccion, PtrVentaOnlineEntregaTiendaResultItemDto src){
        setListaSeccion(tareaLocalizacionVentaSeccion, src.getListaSeccion(), TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION_SECCION);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionVentaSeccion getVentaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionVentaSeccion(
            PtrVentaOnlineEntregaDomicilioResultItemDto src, TareaDto tarea);
    
    public List<TareaLocalizacionVentaSeccion> getVentaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionVentaSeccion(
            List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tarea){ 
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionVentaSeccion tareaLocalizacionVentaSeccion, PtrVentaOnlineEntregaDomicilioResultItemDto src){
        setListaSeccion(tareaLocalizacionVentaSeccion, src.getListaSeccion(), TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION_SECCION);
    }
    
    private void setListaSeccion(TareaLocalizacionVentaSeccion tareaLocalizacionVentaSeccion,
            List<PtrSeccionVentaOnlineGenericType> listaSeccion, TipoDatoEnum tipoImporteVenta) {
        if (listaSeccion != null ) {
            for (PtrSeccionVentaOnlineGenericType item : listaSeccion) {
                if (PtrConstants.SECCION_1.equals(item.getSeccion())) {
                    tareaLocalizacionVentaSeccion.setImporte1(item.getImporteSinIVA().doubleValue());
                    tareaLocalizacionVentaSeccion.setImporteConImpuestos1(item.getImporteConIVA().doubleValue());
                } else if (PtrConstants.SECCION_2.equals(item.getSeccion())) {
                    tareaLocalizacionVentaSeccion.setImporte2(item.getImporteSinIVA().doubleValue());
                    tareaLocalizacionVentaSeccion.setImporteConImpuestos2(item.getImporteConIVA().doubleValue());
                } else if (PtrConstants.SECCION_3.equals(item.getSeccion())) {
                    tareaLocalizacionVentaSeccion.setImporte3(item.getImporteSinIVA().doubleValue());
                    tareaLocalizacionVentaSeccion.setImporteConImpuestos3(item.getImporteConIVA().doubleValue());
                }
            } 
        }
        tareaLocalizacionVentaSeccion.setTipoDato(new TipoDato());
        tareaLocalizacionVentaSeccion.getTipoDato().setId(tipoImporteVenta.getId());
    }
}
