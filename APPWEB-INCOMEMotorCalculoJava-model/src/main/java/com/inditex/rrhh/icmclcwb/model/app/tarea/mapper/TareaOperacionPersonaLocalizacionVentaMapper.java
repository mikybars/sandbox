package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoImporteVentaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaOperacionPersonaLocalizacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaOperacionPersonaLocalizacionVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoImporteVenta;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaOperacionPersonaLocalizacionVenta;

@Mapper
@DecoratedWith(TareaOperacionPersonaLocalizacionVentaDecorator.class)
public abstract class TareaOperacionPersonaLocalizacionVentaMapper {

    public abstract TareaOperacionPersonaLocalizacionVenta tareaOperacionPersonaLocalizacionVentaDtoToTareaOperacionPersonaLocalizacionVenta(
            TareaOperacionPersonaLocalizacionVentaDto src);

    public abstract List<TareaOperacionPersonaLocalizacionVenta> tareaOperacionPersonaLocalizacionVentaDtoToTareaOperacionPersonaLocalizacionVenta(
            List<TareaOperacionPersonaLocalizacionVentaDto> src);

    public abstract TareaOperacionPersonaLocalizacionVentaDto tareaOperacionPersonaLocalizacionVentaToTareaOperacionPersonaLocalizacionVentaDto(
            TareaOperacionPersonaLocalizacionVenta src);

    public abstract List<TareaOperacionPersonaLocalizacionVentaDto> tareaOperacionPersonaLocalizacionVentaToTareaOperacionPersonaLocalizacionVentaDto(
            List<TareaOperacionPersonaLocalizacionVenta> src);
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.operacion", target = "idOperacion")
    @Mapping(source = "src.vendedor", target = "idPersona")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaOperacionPersonaLocalizacionVenta getVentaIndividualDetalleResponseItemsDtoToTareaOperacionLocalizacionVentas(
            PtrVentaIndividualDetalleResultItemDto src, TareaDto tarea);

    public List<TareaOperacionPersonaLocalizacionVenta> getVentaIndividualDetalleResponseItemsDtoToTareaOperacionLocalizacionVentas(
            List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaOperacionPersonaLocalizacionVenta tareaOperacionPersonaLocalizacionVenta, PtrVentaIndividualDetalleResultItemDto src){
        tareaOperacionPersonaLocalizacionVenta.setTipoImporteVenta(new TipoImporteVenta());
        tareaOperacionPersonaLocalizacionVenta.getTipoImporteVenta().setId(TipoImporteVentaEnum.IMPORTE_VENTA_FISICA_INDIVIDUAL_OPERACION_PERSONA_LOCALIZACION.getId());
    }
}
