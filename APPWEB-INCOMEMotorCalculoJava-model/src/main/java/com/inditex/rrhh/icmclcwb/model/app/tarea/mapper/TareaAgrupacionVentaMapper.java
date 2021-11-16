package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

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

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = {TipoDato.class, TipoDatoEnum.class, AppConstants.class})
@DecoratedWith(TareaAgrupacionVentaDecorator.class)
public abstract class TareaAgrupacionVentaMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(source = "tarea.id", target = "tarea.id")
  @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(source = "src.pais", target = "cclIdOrigen")
  @Mapping(target = "importeSinImpuestos", ignore = true)
  @Mapping(target = "importeConImpuestos", ignore = true)
  @Mapping(target = "icmIdAgrupacionOnline", ignore = true)
  @Mapping(target = "cclIdSeccion", expression = "java(AppConstants.SECCION_4.toString())")
  @Mapping(target = "activo", expression = "java(Boolean.TRUE)")
  @Mapping(target = "tipoDato",
      expression = "java(TipoDato.builder().id(TipoDatoEnum.VENTA_FISICA_AGRUPACIONONLINE.getId()).build())")
  public abstract TareaAgrupacionVenta ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(
      PtrVentaTotalizadoResultItemDto src, TareaDto tarea);

  public List<TareaAgrupacionVenta> ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(
      List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea, List<TareaAgrupacionCadenasDto> agrupaciones) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  @Mapping(target = "id", ignore = true)
  @Mapping(source = "tarea.id", target = "tarea.id")
  @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(source = "src.pais", target = "cclIdOrigen")
  @Mapping(target = "importeSinImpuestos", ignore = true)
  @Mapping(target = "importeConImpuestos", ignore = true)
  @Mapping(target = "icmIdAgrupacionOnline", ignore = true)
  @Mapping(target = "cclIdSeccion", expression = "java(AppConstants.SECCION_4.toString())")
  @Mapping(target = "activo", expression = "java(Boolean.TRUE)")
  @Mapping(target = "tipoDato",
      expression = "java(TipoDato.builder().id(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_AGRUPACIONONLINE.getId()).build())")
  public abstract TareaAgrupacionVenta ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(
      PtrVentaOnlineEntregaDomicilioResultItemDto src, TareaDto tarea);

  public List<TareaAgrupacionVenta> ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(
      List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tarea,
      List<TareaAgrupacionCadenasDto> agrupaciones) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
