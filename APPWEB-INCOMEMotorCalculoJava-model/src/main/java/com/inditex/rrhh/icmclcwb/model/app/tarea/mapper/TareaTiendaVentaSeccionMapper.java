package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoImporteVentaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaVentaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaTiendaVentaSeccionDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoImporteVenta;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaVentaSeccion;

@Mapper
@DecoratedWith(TareaTiendaVentaSeccionDecorator.class)
public abstract class TareaTiendaVentaSeccionMapper {

    private static final Integer SECCION_1 = 1;
    private static final Integer SECCION_2 = 2;
    private static final Integer SECCION_3 = 3;
    
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
        for(PtrSeccionVentaOnlineGenericType item : src.getListaSeccion()) {
            if(item.getSeccion().equals(SECCION_1)){
                tareaTiendaVentaSeccion.setImporte1(item.getImporteSinIVA().doubleValue());
            }else if(item.getSeccion().equals(SECCION_2)) {
                tareaTiendaVentaSeccion.setImporte2(item.getImporteSinIVA().doubleValue());
            }else if(item.getSeccion().equals(SECCION_3)) {
                tareaTiendaVentaSeccion.setImporte3(item.getImporteSinIVA().doubleValue());
            }
        }
        tareaTiendaVentaSeccion.setTipoImporteVenta(new TipoImporteVenta());
        tareaTiendaVentaSeccion.getTipoImporteVenta().setId(TipoImporteVentaEnum.IMPORTE_VENTA_FISICA_LOCALIZACION_SECCION.getId());
    }
}
