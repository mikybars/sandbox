package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaVentaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaLocalizacionPersonaVentaDecorator extends TareaLocalizacionPersonaVentaMapper {

  @Autowired
  private Logger log;

  @Autowired
  private TareaLocalizacionPersonaVentaMapper delegate;

  @Override
  public TareaLocalizacionPersonaVenta ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
      final PtrVentaIndividualDetalleResultItemDto src, final TareaDto tarea) {
    final TareaLocalizacionPersonaVenta result = this.delegate
        .ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(src, tarea);
    if (PtrConstants.OPERACION_VENTA.equals(src.getOperacion())) {
      result.setTipoDato(new TipoDato());
      result.getTipoDato().setId(TipoDatoEnum.OPERACION_VENTA_FISICA_LOCALIZACION_SECCION.getId());
    } else if (PtrConstants.OPERACION_DEVOLUCION.equals(src.getOperacion())) {
      result.setTipoDato(new TipoDato());
      result.getTipoDato().setId(TipoDatoEnum.OPERACION_DEVOLUCION_FISICA_LOCALIZACION_SECCION.getId());
    } else {
      this.log.warn(ErrorConstants.OPERATION_NOT_VALID, src.getOperacion());
    }

    if (PtrConstants.getVENDEDORES_0().contains(Integer.valueOf(result.getCclIdPerson()))) {
      result.setCclIdPerson(PtrConstants.VENDEDOR_0.toString());
    }

    result.setActivo(Boolean.TRUE);
    return result;
  }

  private TareaLocalizacionPersonaVenta ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
      final PtrVentaIndividualDetalleResultItemDto src, final TareaDto tarea,
      final PtrSeccionVentaOnlineGenericType seccion) {
    final TareaLocalizacionPersonaVenta result = this
        .ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
            src, tarea);
    result.setCclIdSeccion(seccion.getSeccion().toString());
    result.setImporteConImpuestos(seccion.getImporteConIVA());
    result.setImporteSinImpuestos(seccion.getImporteSinIVA());
    return result;
  }

  @Override
  public List<TareaLocalizacionPersonaVenta> ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
      final List<PtrVentaIndividualDetalleResultItemDto> src, final TareaDto tarea) {
    final List<TareaLocalizacionPersonaVenta> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(x -> result
          .addAll(this.ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaList(x, tarea)));
    }
    return result;
  }

  private List<TareaLocalizacionPersonaVenta> ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaList(
      final PtrVentaIndividualDetalleResultItemDto src, final TareaDto tarea) {
    final List<TareaLocalizacionPersonaVenta> result = new ArrayList<>();
    src.getListaSeccion().forEach(seccion -> {
      if (AppConstants.SECCION_4.equals(seccion.getSeccion())) {
        for (final Integer idSeccion : AppConstants.getSECCIONES()) {
          final PtrSeccionVentaOnlineGenericType s = new PtrSeccionVentaOnlineGenericType();
          s.setImporteConIVA(seccion.getImporteConIVA());
          s.setImporteSinIVA(seccion.getImporteSinIVA());
          s.setSeccion(idSeccion);
          final TareaLocalizacionPersonaVenta item = this
              .ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
                  src, tarea, s);
          if (item.getTipoDato() != null) {
            result.add(item);
          }
        }
      } else {
        final TareaLocalizacionPersonaVenta item = this
            .ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
                src, tarea, seccion);
        if (item.getTipoDato() != null) {
          result.add(item);
        }
      }
    });
    return result;
  }

  @Override
  public TareaLocalizacionPersonaVenta ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
      final PtrVentaOnlineIpodIndividualDetalleResultItemDto src, final TareaDto tarea) {
    final TareaLocalizacionPersonaVenta result = this.delegate
        .ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(src, tarea);
    if (PtrConstants.OPERACION_VENTA.equals(src.getOperacion())) {
      result.setTipoDato(new TipoDato());
      result.getTipoDato().setId(TipoDatoEnum.OPERACION_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId());
    } else if (PtrConstants.OPERACION_DEVOLUCION.equals(src.getOperacion())) {
      result.setTipoDato(new TipoDato());
      result.getTipoDato().setId(TipoDatoEnum.OPERACION_DEVOLUCION_ONLINE_IPOD_LOCALIZACION_SECCION.getId());
    } else {
      this.log.warn(ErrorConstants.OPERATION_NOT_VALID, src.getOperacion());
    }
    result.setActivo(Boolean.TRUE);
    return result;
  }

  @Override
  public List<TareaLocalizacionPersonaVenta> ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
      final List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, final TareaDto tarea) {
    final List<TareaLocalizacionPersonaVenta> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(x -> result
          .addAll(this.ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaList(x,
              tarea)));
    }
    return result;
  }

  private TareaLocalizacionPersonaVenta ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
      final PtrVentaOnlineIpodIndividualDetalleResultItemDto src, final TareaDto tarea,
      final PtrSeccionVentaOnlineGenericType seccion) {
    final TareaLocalizacionPersonaVenta result = this
        .ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
            src, tarea);
    result.setCclIdSeccion(seccion.getSeccion().toString());
    result.setImporteConImpuestos(seccion.getImporteConIVA());
    result.setImporteSinImpuestos(seccion.getImporteSinIVA());
    return result;
  }

  private List<TareaLocalizacionPersonaVenta> ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaList(
      final PtrVentaOnlineIpodIndividualDetalleResultItemDto src, final TareaDto tarea) {
    final List<TareaLocalizacionPersonaVenta> result = new ArrayList<>();
    src.getListaSeccion().forEach(seccion -> {
      if (AppConstants.SECCION_4.equals(seccion.getSeccion())) {
        for (final Integer idSeccion : AppConstants.getSECCIONES()) {
          final PtrSeccionVentaOnlineGenericType s = new PtrSeccionVentaOnlineGenericType();
          s.setImporteConIVA(seccion.getImporteConIVA());
          s.setImporteSinIVA(seccion.getImporteSinIVA());
          s.setSeccion(idSeccion);
          final TareaLocalizacionPersonaVenta item = this
              .ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
                  src, tarea, s);
          if (item.getTipoDato() != null) {
            if (StringUtils.isNotEmpty(item.getCclIdPerson())) {
              result.add(item);
            } else {
              this.log.warn(ErrorConstants.EMPTY_CCL_ID_PERSON, item);
            }
          }
        }
      } else {
        final TareaLocalizacionPersonaVenta item = this
            .ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
                src, tarea, seccion);
        if (item.getTipoDato() != null) {
          if (StringUtils.isNotEmpty(item.getCclIdPerson())) {
            result.add(item);
          } else {
            this.log.warn(ErrorConstants.EMPTY_CCL_ID_PERSON, item);
          }
        }
      }
    });
    return result;
  }

}
