package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoImporteVentaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaLocalizacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPersonaLocalizacionVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoImporteVenta;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaLocalizacionVenta;

@Mapper
@DecoratedWith(TareaPersonaLocalizacionVentaDecorator.class)
public abstract class TareaPersonaLocalizacionVentaMapper {

    public abstract TareaPersonaLocalizacionVenta tareaPersonaLocalizacionVentaDtoToTareaPersonaLocalizacionVenta(
            TareaPersonaLocalizacionVentaDto src);

    public abstract List<TareaPersonaLocalizacionVenta> tareaPersonaLocalizacionVentaDtoToTareaPersonaLocalizacionVenta(
            List<TareaPersonaLocalizacionVentaDto> src);

    public abstract TareaPersonaLocalizacionVentaDto tareaPersonaLocalizacionVentaToTareaPersonaLocalizacionVentaDto(
            TareaPersonaLocalizacionVenta src);

    public abstract List<TareaPersonaLocalizacionVentaDto> tareaPersonaLocalizacionVentaToTareaPersonaLocalizacionVentaDto(
            List<TareaPersonaLocalizacionVenta> src);
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.vendedor", target = "idPersona")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaPersonaLocalizacionVenta getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaPersonaLocalizacionVentas(
            PtrVentaOnlineIpodIndividualDetalleResultItemDto src, TareaDto tarea);

    public List<TareaPersonaLocalizacionVenta> getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaPersonaLocalizacionVentas(
            List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaPersonaLocalizacionVenta tareaPersonaLocalizacionVenta, PtrVentaOnlineIpodIndividualDetalleResultItemDto src){
        tareaPersonaLocalizacionVenta.setTipoImporteVenta(new TipoImporteVenta());
        tareaPersonaLocalizacionVenta.getTipoImporteVenta().setId(TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION_PERSONA.getId());
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.vendedor", target = "idPersona")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaPersonaLocalizacionVenta getVentaIndividualDetalleResponseResponseItemsDtoToTareaPersonaLocalizacionVentas(
            PtrVentaIndividualDetalleResultItemDto src, TareaDto tarea);

    public List<TareaPersonaLocalizacionVenta> getVentaIndividualDetalleResponseItemsDtoToTareaPersonaLocalizacionVentas(
            List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaPersonaLocalizacionVenta tareaPersonaLocalizacionVenta, PtrVentaIndividualDetalleResultItemDto src){
        tareaPersonaLocalizacionVenta.setTipoImporteVenta(new TipoImporteVenta());
        tareaPersonaLocalizacionVenta.getTipoImporteVenta().setId(TipoImporteVentaEnum.IMPORTE_VENTA_FISICA_INDIVIDUAL_PERSONA_LOCALIZACION.getId());
    }
}
