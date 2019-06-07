package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPersonaOperacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPersonaOperacionVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaOperacionVenta;

@Mapper
@DecoratedWith(TareaLocalizacionPersonaOperacionVentaDecorator.class)
public abstract class TareaLocalizacionPersonaOperacionVentaMapper {

    public abstract TareaLocalizacionPersonaOperacionVenta tareaLocalizacionPersonaOperacionVentaDtoToTareaLocalizacionPersonaOperacionVenta(
            TareaLocalizacionPersonaOperacionVentaDto src);

    public abstract List<TareaLocalizacionPersonaOperacionVenta> tareaLocalizacionPersonaOperacionVentaDtoToTareaLocalizacionPersonaOperacionVenta(
            List<TareaLocalizacionPersonaOperacionVentaDto> src);

    public abstract TareaLocalizacionPersonaOperacionVentaDto tareaLocalizacionPersonaOperacionVentaToTareaLocalizacionPersonaOperacionVentaDto(
            TareaLocalizacionPersonaOperacionVenta src);

    public abstract List<TareaLocalizacionPersonaOperacionVentaDto> tareaLocalizacionPersonaOperacionVentaToTareaLocalizacionPersonaOperacionVentaDto(
            List<TareaLocalizacionPersonaOperacionVenta> src);
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.operacion", target = "idOperacion")
    @Mapping(source = "src.vendedor", target = "idPersona")
    @Mapping(source = "src.seccion", target = "idSeccion")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionPersonaOperacionVenta getVentaIndividualDetalleResponseItemsDtoToTareaLocalizacionPersonaOperacionVentas(
            PtrVentaIndividualDetalleResultItemDto src, TareaDto tarea);

    public List<TareaLocalizacionPersonaOperacionVenta> getVentaIndividualDetalleResponseItemsDtoToTareaLocalizacionPersonaOperacionVentas(
            List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionPersonaOperacionVenta tareaLocalizacionPersonaOperacionVenta, PtrVentaIndividualDetalleResultItemDto src){
        tareaLocalizacionPersonaOperacionVenta.setTipoDato(new TipoDato());
        tareaLocalizacionPersonaOperacionVenta.getTipoDato().setId(TipoDatoEnum.IMPORTE_VENTA_FISICA_INDIVIDUAL_OPERACION_PERSONA_LOCALIZACION_SECCION.getId());
    }
}
