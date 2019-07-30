package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAgrupacionVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionVenta;
import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
@DecoratedWith(TareaAgrupacionVentaDecorator.class)
public abstract class TareaAgrupacionVentaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.pais", target = "idOrigen")
    @Mapping(target = "importeSinImpuestos", ignore = true)
    @Mapping(target = "importeConImpuestos", ignore = true)
    @Mapping(target = "idAgrupacion", ignore = true)
    @Mapping(target = "idSeccion", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "tipoDato", ignore = true)
    public abstract TareaAgrupacionVenta ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(
        PtrVentaTotalizadoResultItemDto src, TareaDto tarea);

    @AfterMapping
    public void ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(
        @MappingTarget TareaAgrupacionVenta dest, PtrVentaTotalizadoResultItemDto src, TareaDto tarea) {
        dest.setActivo(Boolean.TRUE);
        dest.setTipoDato(new TipoDato());
        dest.getTipoDato().setId(TipoDatoEnum.VENTA_FISICA_AGRUPACIONONLINE.getId());
        dest.setIdSeccion(AppConstants.SECCION_4.toString());
    }

    public List<TareaAgrupacionVenta> ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(
        List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea, List<TareaAgrupacionCadenasDto> agrupaciones) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.pais", target = "idOrigen")
    @Mapping(target = "importeSinImpuestos", ignore = true)
    @Mapping(target = "importeConImpuestos", ignore = true)
    @Mapping(target = "idAgrupacion", ignore = true)
    @Mapping(target = "idSeccion", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "tipoDato", ignore = true)
    public abstract TareaAgrupacionVenta ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(
        PtrVentaOnlineEntregaDomicilioResultItemDto src, TareaDto tarea);

    @AfterMapping
    public void ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(
        @MappingTarget TareaAgrupacionVenta dest, PtrVentaOnlineEntregaDomicilioResultItemDto src, TareaDto tarea) {
        dest.setActivo(Boolean.TRUE);
        dest.setTipoDato(new TipoDato());
        dest.getTipoDato().setId(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_AGRUPACIONONLINE.getId());
        dest.setIdSeccion(AppConstants.SECCION_4.toString());
    }

    public List<TareaAgrupacionVenta> ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(
        List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tarea, List<TareaAgrupacionCadenasDto> agrupaciones) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}
