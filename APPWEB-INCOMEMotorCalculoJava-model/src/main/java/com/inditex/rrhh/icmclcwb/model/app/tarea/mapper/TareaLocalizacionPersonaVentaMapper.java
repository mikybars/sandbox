package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPersonaVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPersonaVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
@DecoratedWith(TareaLocalizacionPersonaVentaDecorator.class)
public abstract class TareaLocalizacionPersonaVentaMapper {

    public abstract TareaLocalizacionPersonaVenta tareaLocalizacionPersonaVentaDtoToTareaLocalizacionPersonaVenta(
            TareaLocalizacionPersonaVentaDto src);

    public abstract List<TareaLocalizacionPersonaVenta> tareaLocalizacionPersonaVentaDtoToTareaLocalizacionPersonaVenta(
            List<TareaLocalizacionPersonaVentaDto> src);

    public abstract TareaLocalizacionPersonaVentaDto tareaLocalizacionPersonaVentaToTareaLocalizacionPersonaVentaDto(
            TareaLocalizacionPersonaVenta src);

    public abstract List<TareaLocalizacionPersonaVentaDto> tareaLocalizacionPersonaVentaToTareaLocalizacionPersonaVentaDto(
            List<TareaLocalizacionPersonaVenta> src);

    @Mapping(target = "pk.id", ignore = true)
    @Mapping(source = "tarea.fechaInicioPeriodo", target = "pk.fechaInicioPeriodo")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(source = "src.vendedor", target = "cclIdPerson")
    @Mapping(source = "src.tienda", target = "cclIdCodOrigen")
    @Mapping(source = "src.cadena", target = "cclIdCadena")
    @Mapping(source = "src.seccion", target = "cclIdSeccion")
    @Mapping(source = "src.importeSinIVA", target = "importeSinImpuestos")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(target = "tipoDato", ignore = true)
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    public abstract TareaLocalizacionPersonaVenta ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
        PtrVentaIndividualDetalleResultItemDto src, TareaDto tarea);

    public List<TareaLocalizacionPersonaVenta> ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
        List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(target = "pk.id", ignore = true)
    @Mapping(source = "tarea.fechaInicioPeriodo", target = "pk.fechaInicioPeriodo")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(source = "src.vendedor", target = "cclIdPerson")
    @Mapping(source = "src.tienda", target = "cclIdCodOrigen")
    @Mapping(source = "src.cadena", target = "cclIdCadena")
    @Mapping(source = "src.seccion", target = "cclIdSeccion")
    @Mapping(source = "src.importeSinIVA", target = "importeSinImpuestos")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(target = "tipoDato", ignore = true)
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    public abstract TareaLocalizacionPersonaVenta ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
        PtrVentaOnlineIpodIndividualDetalleResultItemDto src, TareaDto tarea);

    public List<TareaLocalizacionPersonaVenta> ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
        List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
}
