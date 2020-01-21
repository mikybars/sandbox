package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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
        return result;
    }

    @Override
    public List<TareaLocalizacionPersonaVenta> ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
        List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tarea) {
        List<TareaLocalizacionPersonaVenta> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(x -> {
                TareaLocalizacionPersonaVenta item = ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(x, tarea);
                // No metemos en la lista aquellos elementos que no tengan una operación válida (VENTA / DEVOLUCIÓN)
                if (item.getTipoDato() != null) {
                    result.add(item);
                }
            });
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
        return result;
    }

    @Override
    public List<TareaLocalizacionPersonaVenta> ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tarea) {
        List<TareaLocalizacionPersonaVenta> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(x -> {
                TareaLocalizacionPersonaVenta item = ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(x, tarea);
                // No metemos en la lista aquellos elementos que no tengan una operación válida (VENTA / DEVOLUCIÓN)
                if (item.getTipoDato() != null) {
                    result.add(item);
                }
            });
        }
        return result;
    }
}
