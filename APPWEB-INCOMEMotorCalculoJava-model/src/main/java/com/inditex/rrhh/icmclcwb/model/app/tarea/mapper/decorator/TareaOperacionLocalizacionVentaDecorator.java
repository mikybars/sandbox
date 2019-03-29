package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaOperacionLocalizacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaOperacionLocalizacionVenta;

public abstract class TareaOperacionLocalizacionVentaDecorator extends TareaOperacionLocalizacionVentaMapper {

    @Autowired
    private TareaOperacionLocalizacionVentaMapper delegate;
    
    @Override
    public List<TareaOperacionLocalizacionVenta> getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaOperacionLocalizacionVentas(List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tarea){
        List<TareaOperacionLocalizacionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineIpodIndividualDetalleResultItemDto childDto : src) {
            TareaOperacionLocalizacionVenta dto = delegate.getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaOperacionLocalizacionVentas(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<TareaOperacionLocalizacionVenta> getVentaIndividualDetalleResponseItemsDtoToTareaOperacionLocalizacionVentas(List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tarea){
        List<TareaOperacionLocalizacionVenta> dtoList = new ArrayList<>();
        for (PtrVentaIndividualDetalleResultItemDto childDto : src) {
            TareaOperacionLocalizacionVenta dto = delegate.getVentaIndividualDetalleResponseItemsDtoToTareaOperacionLocalizacionVentas(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
