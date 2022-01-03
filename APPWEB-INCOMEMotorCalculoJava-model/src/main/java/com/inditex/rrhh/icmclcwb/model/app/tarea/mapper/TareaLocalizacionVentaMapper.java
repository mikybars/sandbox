package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = {TipoDato.class, TipoDatoEnum.class, AppConstants.class})
@DecoratedWith(TareaLocalizacionVentaDecorator.class)
public abstract class TareaLocalizacionVentaMapper {

  @Mapping(target = "pk", ignore = true)
  @Mapping(target = "tarea", ignore = true)
  @Mapping(target = "tipoDato", ignore = true)
  @Mapping(target = "cclIdCadena", ignore = true)
  public abstract TareaLocalizacionVenta tareaLocalizacionVentaDtoToTareaLocalizacionVenta(
      TareaLocalizacionVentaDto src);

  public abstract List<TareaLocalizacionVenta> tareaLocalizacionVentaDtoToTareaLocalizacionVenta(
      List<TareaLocalizacionVentaDto> src);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "idTarea", ignore = true)
  @Mapping(target = "idTipoImporteVenta", ignore = true)
  public abstract TareaLocalizacionVentaDto tareaLocalizacionVentaToTareaLocalizacionVentaDto(
      TareaLocalizacionVenta src);

  public abstract List<TareaLocalizacionVentaDto> tareaLocalizacionVentaToTareaLocalizacionVentaDto(
      List<TareaLocalizacionVenta> src);

  @Mapping(target = "pk.id", ignore = true)
  @Mapping(source = "tarea.id", target = "tarea.id")
  @Mapping(source = "tienda", target = "cclIdCodOrigen")
  @Mapping(source = "cadena", target = "cclIdCadena")
  @Mapping(source = "fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(source = "seccionVenta.seccion", target = "cclIdSeccion")
  @Mapping(source = "seccionVenta.importeSinIVA", target = "importeSinImpuestos")
  @Mapping(source = "seccionVenta.importeConIVA", target = "importeConImpuestos")
  @Mapping(source = "idTipoDato", target = "tipoDato.id")
  @Mapping(constant = "true", target = "activo")
  @Mapping(source = "tarea.fechaInicioPeriodo", target = "pk.fechaInicioPeriodo")
  public abstract TareaLocalizacionVenta responseItemDtoToTareaLocalizacionVenta(Integer tienda, Integer cadena,
      String fecha, TareaDto tarea, PtrSeccionVentaOnlineGenericType seccionVenta, Integer idTipoDato);

  @Mapping(target = "pk.id", ignore = true)
  @Mapping(source = "tarea.id", target = "tarea.id")
  @Mapping(source = "src.tienda", target = "cclIdCodOrigen")
  @Mapping(source = "src.cadena", target = "cclIdCadena")
  @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(target = "cclIdSeccion",
      expression = "java((src.getSeccion() != null ? src.getSeccion() : AppConstants.SECCION_4).toString())")
  @Mapping(source = "src.importeSinIVA", target = "importeSinImpuestos")
  @Mapping(source = "src.importeConIVA", target = "importeConImpuestos")
  @Mapping(source = "idTipoDato", target = "tipoDato.id")
  @Mapping(constant = "true", target = "activo")
  @Mapping(source = "tarea.fechaInicioPeriodo", target = "pk.fechaInicioPeriodo")
  public abstract TareaLocalizacionVenta responseItemDtoToTareaLocalizacionVenta(PtrVentaTotalizadoResultItemDto src,
      TareaDto tarea, Integer idTipoDato);

  public List<TareaLocalizacionVenta> ventaTotalizadoResponseItemDtoToTareaLocalizacionVenta(
      final List<PtrVentaTotalizadoResultItemDto> src, final TareaDto tarea,
      final Integer tipoDatoLocalizacionSeccion,
      final Integer tipoDatoLocalizacion) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  public List<TareaLocalizacionVenta> ventaTotalizadoResponseItemDtoToTareaLocalizacionVenta(
      final List<PtrVentaTotalizadoResultItemDto> src, final TareaDto tarea,
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

  @Mapping(source = "src.idLugarTrabajoMtu", target = "cclIdCodOrigen")
  @Mapping(source = "src.idSeccion", target = "cclIdSeccion")
  @Mapping(source = "src.idCadena", target = "cclIdCadena")
  @Mapping(source = "src.fecha", target = "fecha", dateFormat = Meta4Constants.META4_DATE)
  @Mapping(source = "src.importe", target = "importeSinImpuestos")
  @Mapping(source = "src.importe", target = "importeConImpuestos")
  @Mapping(source = "tareaDto.id", target = "tarea.id")
  @Mapping(target = "tipoDato",
      expression = "java(TipoDato.builder().id(TipoDatoEnum.VENTA_MANUAL_LOCALIZACION_SECCION.getId()).build())")
  @Mapping(target = "activo", expression = "java(Boolean.TRUE)")
  @Mapping(target = "pk.id", ignore = true)
  @Mapping(source = "tareaDto.fechaInicioPeriodo", target = "pk.fechaInicioPeriodo")
  public abstract TareaLocalizacionVenta genericTiendaResultItemDtoToTareaLocalizacionVenta(
      VentaManualWlocResultItemDto src, TareaDto tareaDto);

  public List<TareaLocalizacionVenta> genericTiendaResultItemDtoToTareaLocalizacionVenta(
      final List<VentaManualWlocResultItemDto> src, final TareaDto tareaDto) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
