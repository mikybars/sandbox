package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaCadenaVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCadenaVenta;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class TareaCadenaVentaDecorator extends TareaCadenaVentaMapper {

    @Autowired
    private TareaCadenaVentaMapper delegate;

    @Override
    public List<TareaCadenaVenta> ventaTotalizadoResponseItemDtoToTareaCadenaVenta(
        List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea) {
        List<TareaCadenaVenta> result =  new ArrayList<>();
        if (src != null) {
            src.forEach(item -> result.add(delegate.ventaTotalizadoResponseItemDtoToTareaCadenaVenta(item, tarea)));
        }
        return result;
    }

    @Override
    public List<TareaCadenaVenta> ventaOnlineEntregaDomicilioResultItemDtoToTareaCadenaVenta(
        List<PtrVentaOnlineEntregaDomicilioResultItemDto> src, TareaDto tarea) {
        List<TareaCadenaVenta> result = new ArrayList<>();
        if (src != null) {
            src.forEach(item -> result.add(
                delegate.ventaOnlineEntregaDomicilioResultItemDtoToTareaCadenaVenta(item, tarea)));
        }
        return result;
    }
}
