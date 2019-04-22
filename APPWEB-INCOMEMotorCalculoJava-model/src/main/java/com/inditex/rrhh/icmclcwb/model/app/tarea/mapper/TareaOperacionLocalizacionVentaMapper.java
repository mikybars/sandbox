package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoImporteVentaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaOperacionLocalizacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaOperacionLocalizacionVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoImporteVenta;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaOperacionLocalizacionVenta;

@Mapper
@DecoratedWith(TareaOperacionLocalizacionVentaDecorator.class)
public abstract class TareaOperacionLocalizacionVentaMapper {

    public abstract TareaOperacionLocalizacionVenta tareaOperacionLocalizacionVentaDtoToTareaOperacionLocalizacionVenta(
            TareaOperacionLocalizacionVentaDto src);

    public abstract List<TareaOperacionLocalizacionVenta> tareaOperacionLocalizacionVentaDtoToTareaOperacionLocalizacionVenta(
            List<TareaOperacionLocalizacionVentaDto> src);

    public abstract TareaOperacionLocalizacionVentaDto tareaOperacionLocalizacionVentaToTareaOperacionLocalizacionVentaDto(
            TareaOperacionLocalizacionVenta src);

    public abstract List<TareaOperacionLocalizacionVentaDto> tareaOperacionLocalizacionVentaToTareaOperacionLocalizacionVentaDto(
            List<TareaOperacionLocalizacionVenta> src);

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.operacion", target = "idOperacion")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaOperacionLocalizacionVenta getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaOperacionLocalizacionVentas(
            PtrVentaOnlineIpodIndividualDetalleResultItemDto src, TareaDto tarea);

    public List<TareaOperacionLocalizacionVenta> getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaOperacionLocalizacionVentas(
            List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @AfterMapping
    void afterMapping(@MappingTarget TareaOperacionLocalizacionVenta tareaOperacionLocalizacionVenta,
            PtrVentaOnlineIpodIndividualDetalleResultItemDto src) {
        tareaOperacionLocalizacionVenta.setTipoImporteVenta(new TipoImporteVenta());
        tareaOperacionLocalizacionVenta.getTipoImporteVenta()
                .setId(TipoImporteVentaEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId());
    }

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.operacion", target = "idOperacion")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaOperacionLocalizacionVenta getVentaIndividualDetalleResponseItemsDtoToTareaOperacionLocalizacionVentas(
            PtrVentaIndividualDetalleResultItemDto src, TareaDto tarea);

    public List<TareaOperacionLocalizacionVenta> getVentaIndividualDetalleResponseItemsDtoToTareaOperacionLocalizacionVentas(
            List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @AfterMapping
    void afterMapping(@MappingTarget TareaOperacionLocalizacionVenta tareaOperacionLocalizacionVenta,
            PtrVentaIndividualDetalleResultItemDto src) {
        tareaOperacionLocalizacionVenta.setTipoImporteVenta(new TipoImporteVenta());
        tareaOperacionLocalizacionVenta.getTipoImporteVenta()
                .setId(TipoImporteVentaEnum.IMPORTE_VENTA_FISICA_INDIVIDUAL_OPERACION_LOCALIZACION.getId());
    }

}
