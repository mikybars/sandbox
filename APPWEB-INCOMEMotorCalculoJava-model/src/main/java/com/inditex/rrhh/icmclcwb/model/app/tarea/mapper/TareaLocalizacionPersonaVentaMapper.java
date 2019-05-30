package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPersonaVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPersonaVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;

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

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.vendedor", target = "idPersona")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionPersonaVenta getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaLocalizacionPersonaVentas(
            PtrVentaOnlineIpodIndividualDetalleResultItemDto src, TareaDto tarea);

    public List<TareaLocalizacionPersonaVenta> getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaLocalizacionPersonaVentas(
            List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionPersonaVenta tareaPersonaLocalizacionVenta,
            PtrVentaOnlineIpodIndividualDetalleResultItemDto src) {
        tareaPersonaLocalizacionVenta.setTipoDato(new TipoDato());
        tareaPersonaLocalizacionVenta.getTipoDato()
                .setId(TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION_PERSONA.getId());
    }

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.vendedor", target = "idPersona")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionPersonaVenta getVentaIndividualDetalleResponseResponseItemsDtoToTareaLocalizacionPersonaVentas(
            PtrVentaIndividualDetalleResultItemDto src, TareaDto tarea);

    public List<TareaLocalizacionPersonaVenta> getVentaIndividualDetalleResponseItemsDtoToTareaLocalizacionPersonaVentas(
            List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionPersonaVenta tareaPersonaLocalizacionVenta,
            PtrVentaIndividualDetalleResultItemDto src) {
        tareaPersonaLocalizacionVenta.setTipoDato(new TipoDato());
        tareaPersonaLocalizacionVenta.getTipoDato()
                .setId(TipoDatoEnum.IMPORTE_VENTA_FISICA_INDIVIDUAL_PERSONA_LOCALIZACION.getId());
    }

}
