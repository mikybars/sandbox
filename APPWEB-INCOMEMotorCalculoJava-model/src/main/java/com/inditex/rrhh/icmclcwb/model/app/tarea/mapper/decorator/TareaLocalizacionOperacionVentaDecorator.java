package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionOperacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionOperacionVenta;

public abstract class TareaLocalizacionOperacionVentaDecorator extends TareaLocalizacionOperacionVentaMapper {

    @Autowired
    private TareaLocalizacionOperacionVentaMapper delegate;
    
    @Override
    public List<TareaLocalizacionOperacionVenta> getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaLocalizacionOperacionVentas(List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tarea){
        List<TareaLocalizacionOperacionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineIpodIndividualDetalleResultItemDto childDto : src) {
            TareaLocalizacionOperacionVenta dto = delegate.getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaLocalizacionOperacionVentas(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<TareaLocalizacionOperacionVenta> getVentaIndividualDetalleResponseItemsDtoToTareaLocalizacionOperacionVentas(List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tarea){
        List<TareaLocalizacionOperacionVenta> dtoList = new ArrayList<>();
        for (PtrVentaIndividualDetalleResultItemDto childDto : src) {
            TareaLocalizacionOperacionVenta dto = delegate.getVentaIndividualDetalleResponseItemsDtoToTareaLocalizacionOperacionVentas(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
