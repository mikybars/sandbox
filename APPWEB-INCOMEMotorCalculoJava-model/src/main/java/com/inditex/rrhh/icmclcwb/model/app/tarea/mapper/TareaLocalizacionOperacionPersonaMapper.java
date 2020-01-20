package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionOperacionPersonaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionOperacionPersona;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
@DecoratedWith(TareaLocalizacionOperacionPersonaDecorator.class)
public abstract class TareaLocalizacionOperacionPersonaMapper {

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
    @Mapping(source = "fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    public abstract TareaLocalizacionOperacionPersona ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionOperacionPersona(
        PtrVentaIndividualDetalleResultItemDto src, TareaDto tarea);

    public List<TareaLocalizacionOperacionPersona> ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionOperacionPersona(
        List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}
