package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

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

@Mapper
@DecoratedWith(TareaLocalizacionPersonaVentaDecorator.class)
public abstract class TareaLocalizacionPersonaVentaMapper {

  @Mapping(source = "id", target = "pk.id")
  @Mapping(source = "idTarea", target = "tarea.id")
  @Mapping(source = "cclIdCodOrigen", target = "cclIdCodOrigen")
  @Mapping(source = "cclIdPerson", target = "cclIdPerson")
  @Mapping(source = "importeSinImpuestos", target = "importeSinImpuestos")
  @Mapping(source = "importeConImpuestos", target = "importeConImpuestos")
  @Mapping(target = "cclIdSeccion", ignore = true)
  @Mapping(target = "cclIdCadena", ignore = true)
  @Mapping(target = "tipoDato", ignore = true)
  @Mapping(target = "activo", ignore = true)
  @Mapping(source = "fecha", target = "fecha")
  public abstract TareaLocalizacionPersonaVenta tareaLocalizacionPersonaVentaDtoToTareaLocalizacionPersonaVenta(
      TareaLocalizacionPersonaVentaDto src);

  public abstract List<TareaLocalizacionPersonaVenta> tareaLocalizacionPersonaVentaDtoToTareaLocalizacionPersonaVenta(
      List<TareaLocalizacionPersonaVentaDto> src);

  @Mapping(source = "pk.id", target = "id")
  @Mapping(source = "tarea.id", target = "idTarea")
  @Mapping(target = "idTipoImporteVenta", ignore = true)
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
  @Mapping(target = "activo", ignore = true)
  @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
  public abstract TareaLocalizacionPersonaVenta ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
      PtrVentaIndividualDetalleResultItemDto src, TareaDto tarea);

  public List<TareaLocalizacionPersonaVenta> ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
      final List<PtrVentaIndividualDetalleResultItemDto> src, final TareaDto tarea) {
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
  @Mapping(target = "activo", ignore = true)
  @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
  public abstract TareaLocalizacionPersonaVenta ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
      PtrVentaOnlineIpodIndividualDetalleResultItemDto src, TareaDto tarea);

  public List<TareaLocalizacionPersonaVenta> ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
      final List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
