package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(TareaLocalizacionVentaDecorator.class)
public abstract class TareaLocalizacionVentaMapper {

    @Mapping(target = "pk", ignore = true)
    @Mapping(target = "tarea", ignore = true)
    public abstract TareaLocalizacionVenta tareaLocalizacionVentaDtoToTareaLocalizacionVenta(
            TareaLocalizacionVentaDto src);

    public abstract List<TareaLocalizacionVenta> tareaLocalizacionVentaDtoToTareaLocalizacionVenta(
            List<TareaLocalizacionVentaDto> src);

    public abstract TareaLocalizacionVentaDto tareaLocalizacionVentaToTareaLocalizacionVentaDto(
            TareaLocalizacionVenta src);

    public abstract List<TareaLocalizacionVentaDto> tareaLocalizacionVentaToTareaLocalizacionVentaDto(
            List<TareaLocalizacionVenta> src);

    @Mapping(target = "pk.id", ignore = true)
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(source = "tienda", target = "cclIdCodOrigen")
    @Mapping(source = "cadena", target = "cclIdCadena")
    @Mapping(source = "fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "idSeccion", target = "cclIdSeccion")
    @Mapping(source = "importeSinIVA", target = "importeSinImpuestos")
    @Mapping(source = "importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "idTipoDato", target = "tipoDato.id")
    @Mapping(constant = "true", target = "activo")
    @Mapping(source = "tarea.fechaInicioPeriodo", target = "pk.fechaInicioPeriodo")
    public abstract TareaLocalizacionVenta responseItemDtoToTareaLocalizacionVenta(Integer tienda, Integer cadena,
            String fecha, TareaDto tarea, Double importeSinIVA, Double importeConIVA, Integer idSeccion,
            Integer idTipoDato);

    public List<TareaLocalizacionVenta> ventaTotalizadoResponseItemDtoToTareaLocalizacionVenta(
            final List<PtrVentaTotalizadoResultItemDto> src, final TareaDto tarea,
            final Integer tipoDatoLocalizacionSeccion,
            final Integer tipoDatoLocalizacion) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    public List<TareaLocalizacionVenta> ventaOnlineIpodResponseItemDtoToTareaLocalizacionVenta(
            final List<PtrVentaOnlineIpodResultItemDto> src, final TareaDto tarea,
            final Integer tipoDatoLocalizacionSeccion,
            final Integer tipoDatoLocalizacion) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    public List<TareaLocalizacionVenta> ventaOnlineIpodIndividualDetalleResponseItemDtoToTareaLocalizacionVenta(
            final List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, final TareaDto tarea,
            final Integer tipoDatoLocalizacionSeccion, final Integer tipoDatoLocalizacion) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    public List<TareaLocalizacionVenta> ventaOnlinePickingResponseItemDtoToTareaLocalizacionVenta(
            final List<PtrVentaOnlinePickingResultItemDto> src, final TareaDto tarea,
            final Integer tipoDatoLocalizacionSeccion,
            final Integer tipoDatoLocalizacion) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    public List<TareaLocalizacionVenta> ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionVenta(
            final List<PtrVentaOnlineEntregaTiendaResultItemDto> src, final TareaDto tarea,
            final Integer tipoDatoLocalizacionSeccion,
            final Integer tipoDatoLocalizacion) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    public List<TareaLocalizacionVenta> ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionVenta(
            final List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, final TareaDto tarea,
            final Integer tipoDatoLocalizacionSeccion,
            final Integer tipoDatoLocalizacion) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    public List<TareaLocalizacionVenta> ventaIndividualDetalleReponseItemsDtoToTareaLocalizacionVenta(
            final List<PtrVentaIndividualDetalleResultItemDto> src, final TareaDto tarea,
            final Integer tipoDatoLocalizacionSeccion,
            final Integer tipoDatoLocalizacion) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}
