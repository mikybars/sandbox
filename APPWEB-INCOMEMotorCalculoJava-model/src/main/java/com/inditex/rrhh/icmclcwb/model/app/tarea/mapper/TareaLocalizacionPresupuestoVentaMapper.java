package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPresupuestoVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuestoVenta;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(TareaLocalizacionPresupuestoVentaDecorator.class)
public abstract class TareaLocalizacionPresupuestoVentaMapper {

  @Mapping(target = "tarea", ignore = true)
  @Mapping(target = "fechaInicio", ignore = true)
  @Mapping(target = "fechaFin", ignore = true)
  @Mapping(target = "tipoPresupuesto", ignore = true)
  @Mapping(target = "tipoVentaConceptoChallenge", ignore = true)
  @Mapping(target = "tipoDato", ignore = true)
  public abstract TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVentaDtoToTareaLocalizacionPresupuestoVenta(
      TareaLocalizacionPresupuestoVentaDto src);

  public abstract List<TareaLocalizacionPresupuestoVenta> tareaLocalizacionPresupuestoVentaDtoToTareaLocalizacionPresupuestoVenta(
      List<TareaLocalizacionPresupuestoVentaDto> src);

  @Mapping(target = "idTarea", ignore = true)
  @Mapping(target = "idTipoPresupuesto", ignore = true)
  @Mapping(target = "icmIdConceptoVenta", ignore = true)
  @Mapping(target = "idTipoDato", ignore = true)
  public abstract TareaLocalizacionPresupuestoVentaDto tareaLocalizacionPresupuestoVentaToTareaLocalizacionPresupuestoVentaDto(
      TareaLocalizacionPresupuestoVenta src);

  public abstract List<TareaLocalizacionPresupuestoVentaDto> tareaLocalizacionPresupuestoVentaToTareaLocalizacionPresupuestoVentaDto(
      List<TareaLocalizacionPresupuestoVenta> src);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "tipoPresupuesto", ignore = true)
  @Mapping(target = "tipoVentaConceptoChallenge", ignore = true)
  @Mapping(target = "tipoDato", ignore = true)
  @Mapping(target = "activo", ignore = true)
  @Mapping(target = "tarea.id", source = "tarea.id")
  @Mapping(target = "fechaInicio", source = "src.fechaInicio")
  @Mapping(target = "fechaFin", source = "src.fechaFin")
  @Mapping(target = "cclIdSeccion", source = "src.idSeccion")
  @Mapping(target = "cclIdOrigen", source = "src.idOrigen")
  @Mapping(target = "cclIdCadena", source = "src.idCadena")
  @Mapping(target = "cclIdCodOrigen", source = "src.idLugarTrabajoMtu")
  @Mapping(target = "ordinal", source = "src.ordinal")
  @Mapping(target = "importeConImpuestos", source = "src.importeConImpuestos")
  @Mapping(target = "importeSinImpuestos", source = "src.importeSinImpuestos")
  public abstract TareaLocalizacionPresupuestoVenta ventaCongeladaResultItemDtoToTareaLocalizacionPresupuestoVenta(
      VentaCongeladaResultItemDto src, TareaDto tarea);

  public List<TareaLocalizacionPresupuestoVenta> ventaCongeladaResultItemDtoToTareaLocalizacionPresupuestoVenta(
      final List<VentaCongeladaResultItemDto> src, final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "cclIdSeccion", ignore = true)
  @Mapping(target = "ordinal", ignore = true)
  @Mapping(target = "importeSinImpuestos", ignore = true)
  @Mapping(target = "importeConImpuestos", ignore = true)
  @Mapping(target = "tipoPresupuesto", ignore = true)
  @Mapping(target = "tipoVentaConceptoChallenge", ignore = true)
  @Mapping(target = "tipoDato", ignore = true)
  @Mapping(target = "activo", ignore = true)
  @Mapping(target = "tarea.id", source = "tarea.id")
  @Mapping(target = "fechaInicio", source = "iter.fechaInicio")
  @Mapping(target = "fechaFin", source = "iter.fechaFin")
  @Mapping(target = "cclIdOrigen", source = "src.pais")
  @Mapping(target = "cclIdCadena", source = "src.cadena")
  @Mapping(target = "cclIdCodOrigen", source = "src.tienda")
  public abstract TareaLocalizacionPresupuestoVenta responseItemDtoToTareaLocalizacionPresupuestoVenta(
      PtrVentaTotalizadoResultItemDto src, IdLocalizacionLocalPresupuestoDto iter, TareaDto tarea);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "cclIdSeccion", ignore = true)
  @Mapping(target = "ordinal", ignore = true)
  @Mapping(target = "importeSinImpuestos", ignore = true)
  @Mapping(target = "importeConImpuestos", ignore = true)
  @Mapping(target = "tipoPresupuesto", ignore = true)
  @Mapping(target = "tipoVentaConceptoChallenge", ignore = true)
  @Mapping(target = "tipoDato", ignore = true)
  @Mapping(target = "activo", ignore = true)
  @Mapping(target = "tarea.id", source = "tarea.id")
  @Mapping(target = "fechaInicio", source = "iter.fechaInicio")
  @Mapping(target = "fechaFin", source = "iter.fechaFin")
  @Mapping(target = "cclIdOrigen", source = "src.pais")
  @Mapping(target = "cclIdCadena", source = "src.cadena")
  @Mapping(target = "cclIdCodOrigen", source = "src.tienda")
  public abstract TareaLocalizacionPresupuestoVenta responseItemDtoToTareaLocalizacionPresupuestoVenta(
      PtrVentaOnlineIpodResultItemDto src, IdLocalizacionLocalPresupuestoDto iter, TareaDto tarea);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "cclIdSeccion", ignore = true)
  @Mapping(target = "ordinal", ignore = true)
  @Mapping(target = "importeSinImpuestos", ignore = true)
  @Mapping(target = "importeConImpuestos", ignore = true)
  @Mapping(target = "tipoPresupuesto", ignore = true)
  @Mapping(target = "tipoVentaConceptoChallenge", ignore = true)
  @Mapping(target = "tipoDato", ignore = true)
  @Mapping(target = "activo", ignore = true)
  @Mapping(target = "tarea.id", source = "tarea.id")
  @Mapping(target = "fechaInicio", source = "iter.fechaInicio")
  @Mapping(target = "fechaFin", source = "iter.fechaFin")
  @Mapping(target = "cclIdOrigen", source = "src.pais")
  @Mapping(target = "cclIdCadena", source = "src.cadena")
  @Mapping(target = "cclIdCodOrigen", source = "src.tienda")
  public abstract TareaLocalizacionPresupuestoVenta responseItemDtoToTareaLocalizacionPresupuestoVenta(
      PtrVentaOnlinePickingResultItemDto src, IdLocalizacionLocalPresupuestoDto iter, TareaDto tarea);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "cclIdSeccion", ignore = true)
  @Mapping(target = "ordinal", ignore = true)
  @Mapping(target = "importeSinImpuestos", ignore = true)
  @Mapping(target = "importeConImpuestos", ignore = true)
  @Mapping(target = "tipoPresupuesto", ignore = true)
  @Mapping(target = "tipoVentaConceptoChallenge", ignore = true)
  @Mapping(target = "tipoDato", ignore = true)
  @Mapping(target = "activo", ignore = true)
  @Mapping(target = "tarea.id", source = "tarea.id")
  @Mapping(target = "fechaInicio", source = "iter.fechaInicio")
  @Mapping(target = "fechaFin", source = "iter.fechaFin")
  @Mapping(target = "cclIdOrigen", source = "src.pais")
  @Mapping(target = "cclIdCadena", source = "src.cadena")
  @Mapping(target = "cclIdCodOrigen", source = "src.tienda")
  public abstract TareaLocalizacionPresupuestoVenta responseItemDtoToTareaLocalizacionPresupuestoVenta(
      PtrVentaOnlineEntregaTiendaResultItemDto src, IdLocalizacionLocalPresupuestoDto iter, TareaDto tarea);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "cclIdSeccion", ignore = true)
  @Mapping(target = "ordinal", ignore = true)
  @Mapping(target = "importeSinImpuestos", ignore = true)
  @Mapping(target = "importeConImpuestos", ignore = true)
  @Mapping(target = "tipoPresupuesto", ignore = true)
  @Mapping(target = "tipoVentaConceptoChallenge", ignore = true)
  @Mapping(target = "tipoDato", ignore = true)
  @Mapping(target = "activo", ignore = true)
  @Mapping(target = "tarea.id", source = "tarea.id")
  @Mapping(target = "fechaInicio", source = "iter.fechaInicio")
  @Mapping(target = "fechaFin", source = "iter.fechaFin")
  @Mapping(target = "cclIdOrigen", source = "src.pais")
  @Mapping(target = "cclIdCadena", source = "src.cadena")
  @Mapping(target = "cclIdCodOrigen", source = "src.tienda")
  public abstract TareaLocalizacionPresupuestoVenta responseItemDtoToTareaLocalizacionPresupuestoVenta(
      PtrVentaOnlineEntregaDomicilioResultItemDto src, IdLocalizacionLocalPresupuestoDto iter, TareaDto tarea);

  public List<TareaLocalizacionPresupuestoVenta> ventaTotalizadoResponseItemDtoToTareaLocalizacionPresupuestoVenta(
      final List<PtrVentaTotalizadoResultItemDto> src, final IdLocalizacionLocalPresupuestoDto iter,
      final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  public List<TareaLocalizacionPresupuestoVenta> ventaOnlineIpodResponseItemDtoToTareaLocalizacionPresupuestoVenta(
      final List<PtrVentaOnlineIpodResultItemDto> src, final IdLocalizacionLocalPresupuestoDto iter,
      final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  public List<TareaLocalizacionPresupuestoVenta> ventaOnlinePickingResponseItemDtoToTareaLocalizacionPresupuestoVenta(
      final List<PtrVentaOnlinePickingResultItemDto> src, final IdLocalizacionLocalPresupuestoDto iter,
      final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  public List<TareaLocalizacionPresupuestoVenta> ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionPresupuestoVenta(
      final List<PtrVentaOnlineEntregaTiendaResultItemDto> src, final IdLocalizacionLocalPresupuestoDto iter,
      final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  public List<TareaLocalizacionPresupuestoVenta> ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionPresupuestoVenta(
      final List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, final IdLocalizacionLocalPresupuestoDto iter,
      final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
