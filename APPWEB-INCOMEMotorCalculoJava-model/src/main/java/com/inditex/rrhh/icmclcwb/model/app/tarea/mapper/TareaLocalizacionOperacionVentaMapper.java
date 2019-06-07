package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionOperacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionOperacionVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionOperacionVenta;

@Mapper
@DecoratedWith(TareaLocalizacionOperacionVentaDecorator.class)
public abstract class TareaLocalizacionOperacionVentaMapper {

    public abstract TareaLocalizacionOperacionVenta tareaLocalizacionOperacionVentaDtoToTareaLocalizacionOperacionVenta(
            TareaLocalizacionOperacionVentaDto src);

    public abstract List<TareaLocalizacionOperacionVenta> tareaLocalizacionOperacionVentaDtoToTareaLocalizacionOperacionVenta(
            List<TareaLocalizacionOperacionVentaDto> src);

    public abstract TareaLocalizacionOperacionVentaDto tareaLocalizacionOperacionVentaToTareaLocalizacionOperacionVentaDto(
            TareaLocalizacionOperacionVenta src);

    public abstract List<TareaLocalizacionOperacionVentaDto> tareaLocalizacionOperacionVentaToTareaLocalizacionOperacionVentaDto(
            List<TareaLocalizacionOperacionVenta> src);

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.operacion", target = "idOperacion")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionOperacionVenta getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaLocalizacionOperacionVentas(
            PtrVentaOnlineIpodIndividualDetalleResultItemDto src, TareaDto tarea);

    public List<TareaLocalizacionOperacionVenta> getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaLocalizacionOperacionVentas(
            List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionOperacionVenta tareaLocalizacionOperacionVenta,
            PtrVentaOnlineIpodIndividualDetalleResultItemDto src) {
        tareaLocalizacionOperacionVenta.setIdSeccion(AppConstants.SECCION_4.toString());
        tareaLocalizacionOperacionVenta.setTipoDato(new TipoDato());
        tareaLocalizacionOperacionVenta.getTipoDato()
                .setId(TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId());
    }

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.operacion", target = "idOperacion")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionOperacionVenta getVentaIndividualDetalleResponseItemsDtoToTareaLocalizacionOperacionVentas(
            PtrVentaIndividualDetalleResultItemDto src, TareaDto tarea);

    public List<TareaLocalizacionOperacionVenta> getVentaIndividualDetalleResponseItemsDtoToTareaLocalizacionOperacionVentas(
            List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionOperacionVenta tareaLocalizacionOperacionVenta,
            PtrVentaIndividualDetalleResultItemDto src) {
        tareaLocalizacionOperacionVenta.setIdSeccion(AppConstants.SECCION_4.toString());
        tareaLocalizacionOperacionVenta.setTipoDato(new TipoDato());
        tareaLocalizacionOperacionVenta.getTipoDato()
                .setId(TipoDatoEnum.IMPORTE_VENTA_FISICA_INDIVIDUAL_OPERACION_LOCALIZACION.getId());
    }

}
