package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;

public abstract class TareaLocalizacionPersonaVentaDecorator extends TareaLocalizacionPersonaVentaMapper {

    @Autowired
    private Logger log;

    @Autowired
    private TareaLocalizacionPersonaVentaMapper delegate;


    @Override
    public TareaLocalizacionPersonaVenta ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
        PtrVentaIndividualDetalleResultItemDto src, TareaDto tarea) {
        TareaLocalizacionPersonaVenta result = delegate.ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(src, tarea);
        if (PtrConstants.OPERACION_VENTA.equals(src.getOperacion())) {
            result.setTipoDato(new TipoDato());
            result.getTipoDato().setId(TipoDatoEnum.OPERACION_VENTA_FISICA_LOCALIZACION_SECCION.getId());
        } else if (PtrConstants.OPERACION_DEVOLUCION.equals(src.getOperacion())) {
            result.setTipoDato(new TipoDato());
            result.getTipoDato().setId(TipoDatoEnum.OPERACION_DEVOLUCION_FISICA_LOCALIZACION_SECCION.getId());
        } else {
            log.warn(ErrorConstants.OPERATION_NOT_VALID, src.getOperacion());
        }

        if (PtrConstants.VENDEDORES_0.contains(Integer.valueOf(result.getCclIdPerson()))) {
            result.setCclIdPerson(PtrConstants.VENDEDOR_0.toString());
        }

        result.setActivo(Boolean.TRUE);
        return result;
    }

    private TareaLocalizacionPersonaVenta ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
        PtrVentaIndividualDetalleResultItemDto src, TareaDto tarea, PtrSeccionVentaOnlineGenericType seccion) {
        TareaLocalizacionPersonaVenta result = ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(src, tarea);
        result.setCclIdSeccion(seccion.getSeccion().toString());
        result.setImporteConImpuestos(seccion.getImporteConIVA());
        result.setImporteSinImpuestos(seccion.getImporteSinIVA());
        return result;
    }

    private List<TareaLocalizacionPersonaVenta> ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaList(
        PtrVentaIndividualDetalleResultItemDto src, TareaDto tarea) {
        List<TareaLocalizacionPersonaVenta> result = new ArrayList<>();
        src.getListaSeccion().forEach(seccion -> {
            if (AppConstants.SECCION_4.equals(seccion.getSeccion())) {
                for (Integer idSeccion : AppConstants.SECCIONES) {
                    PtrSeccionVentaOnlineGenericType s = new PtrSeccionVentaOnlineGenericType();
                    s.setImporteConIVA(seccion.getImporteConIVA());
                    s.setImporteSinIVA(seccion.getImporteSinIVA());
                    s.setSeccion(idSeccion);
                    TareaLocalizacionPersonaVenta item = ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(src, tarea, s);
                    if (item.getTipoDato() != null) {
                        result.add(item);
                    }
                }
            } else {
                TareaLocalizacionPersonaVenta item = ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(src, tarea, seccion);
                if (item.getTipoDato() != null) {
                    result.add(item);
                }
            }
        });
        return result;
    }

    @Override
    public List<TareaLocalizacionPersonaVenta> ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
        List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tarea) {
        List<TareaLocalizacionPersonaVenta> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(x -> result.addAll(ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaList(x, tarea)));
        }
        return result;
    }

    @Override
    public TareaLocalizacionPersonaVenta ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(PtrVentaOnlineIpodIndividualDetalleResultItemDto src, TareaDto tarea) {
        TareaLocalizacionPersonaVenta result = delegate.ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(src, tarea);
        if (PtrConstants.OPERACION_VENTA.equals(src.getOperacion())) {
            result.setTipoDato(new TipoDato());
            result.getTipoDato().setId(TipoDatoEnum.OPERACION_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId());
        } else if (PtrConstants.OPERACION_DEVOLUCION.equals(src.getOperacion())) {
            result.setTipoDato(new TipoDato());
            result.getTipoDato().setId(TipoDatoEnum.OPERACION_DEVOLUCION_ONLINE_IPOD_LOCALIZACION_SECCION.getId());
        } else {
            log.warn(ErrorConstants.OPERATION_NOT_VALID, src.getOperacion());
        }
        result.setActivo(Boolean.TRUE);
        return result;
    }

    @Override
    public List<TareaLocalizacionPersonaVenta> ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tarea) {
        List<TareaLocalizacionPersonaVenta> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(x -> result.addAll(ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaList(x, tarea)));
        }
        return result;
    }

    private TareaLocalizacionPersonaVenta ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
        PtrVentaOnlineIpodIndividualDetalleResultItemDto src, TareaDto tarea, PtrSeccionVentaOnlineGenericType seccion) {
        TareaLocalizacionPersonaVenta result = ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(src, tarea);
        result.setCclIdSeccion(seccion.getSeccion().toString());
        result.setImporteConImpuestos(seccion.getImporteConIVA());
        result.setImporteSinImpuestos(seccion.getImporteSinIVA());
        return result;
    }

    private List<TareaLocalizacionPersonaVenta> ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVentaList(
        PtrVentaOnlineIpodIndividualDetalleResultItemDto src, TareaDto tarea) {
        List<TareaLocalizacionPersonaVenta> result = new ArrayList<>();
        src.getListaSeccion().forEach(seccion -> {
            if (AppConstants.SECCION_4.equals(seccion.getSeccion())) {
                for (Integer idSeccion : AppConstants.SECCIONES) {
                    PtrSeccionVentaOnlineGenericType s = new PtrSeccionVentaOnlineGenericType();
                    s.setImporteConIVA(seccion.getImporteConIVA());
                    s.setImporteSinIVA(seccion.getImporteSinIVA());
                    s.setSeccion(idSeccion);
                    TareaLocalizacionPersonaVenta item = ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(src, tarea, s);
                    if (item.getTipoDato() != null) {
                        if(StringUtils.isNotEmpty(item.getCclIdPerson())) {
                            result.add(item);    
                        }else {
                            log.warn(ErrorConstants.EMPTY_CCL_ID_PERSON, item);
                        }
                    }
                }
            } else {
                TareaLocalizacionPersonaVenta item = ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(src, tarea, seccion);
                if (item.getTipoDato() != null) {
                    if(StringUtils.isNotEmpty(item.getCclIdPerson())) {
                        result.add(item);    
                    }else {
                        log.warn(ErrorConstants.EMPTY_CCL_ID_PERSON, item);
                    }
                }
            }
        });
        return result;
    }
}
