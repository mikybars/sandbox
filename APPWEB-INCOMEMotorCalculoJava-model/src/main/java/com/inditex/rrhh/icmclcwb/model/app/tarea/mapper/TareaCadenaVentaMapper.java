package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaCadenaVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCadenaVenta;
import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
@DecoratedWith(TareaCadenaVentaDecorator.class)
public abstract class TareaCadenaVentaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "src.cadena", target = "idCadena")
    @Mapping(target = "idSeccion", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "tipoDato", ignore = true)
    public abstract TareaCadenaVenta ventaTotalizadoResponseItemDtoToTareaCadenaVenta(
        PtrVentaTotalizadoResultItemDto src, TareaDto tarea);

    @AfterMapping
    public void ventaTotalizadoResponseItemDtoToTareaCadenaVenta(
        @MappingTarget TareaCadenaVenta dest, PtrVentaTotalizadoResultItemDto src, TareaDto tarea) {
        dest.setActivo(Boolean.TRUE);
        dest.setTipoDato(new TipoDato());
        dest.getTipoDato().setId(TipoDatoEnum.IMPORTE_VENTA_FISICA_CADENA.getId());
        dest.setIdSeccion(AppConstants.SECCION_4.toString());
    }

    public List<TareaCadenaVenta> ventaTotalizadoResponseItemDtoToTareaCadenaVenta(
        List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "src.cadena", target = "idCadena")
    @Mapping(target = "idSeccion", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "tipoDato", ignore = true)
    public abstract TareaCadenaVenta ventaOnlineEntregaDomicilioResultItemDtoToTareaCadenaVenta(
        PtrVentaOnlineEntregaDomicilioResultItemDto src, TareaDto tarea);

    @AfterMapping
    public void ventaOnlineEntregaDomicilioResultItemDtoToTareaCadenaVenta(
        @MappingTarget TareaCadenaVenta dest, PtrVentaOnlineEntregaDomicilioResultItemDto src, TareaDto tarea) {
        dest.setActivo(Boolean.TRUE);
        dest.setTipoDato(new TipoDato());
        dest.getTipoDato().setId(TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_CADENA.getId());
        dest.setIdSeccion(AppConstants.SECCION_4.toString());
    }

    public List<TareaCadenaVenta> ventaOnlineEntregaDomicilioResultItemDtoToTareaCadenaVenta(
        List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}
