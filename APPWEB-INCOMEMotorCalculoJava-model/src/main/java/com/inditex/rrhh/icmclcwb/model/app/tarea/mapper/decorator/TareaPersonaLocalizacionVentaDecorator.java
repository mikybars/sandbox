package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaLocalizacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaLocalizacionVenta;

public abstract class TareaPersonaLocalizacionVentaDecorator extends TareaPersonaLocalizacionVentaMapper {

    @Autowired
    private TareaPersonaLocalizacionVentaMapper delegate;
    
    @Override
    public List<TareaPersonaLocalizacionVenta> getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaPersonaLocalizacionVentas(List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tarea){
        List<TareaPersonaLocalizacionVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineIpodIndividualDetalleResultItemDto childDto : src) {
            TareaPersonaLocalizacionVenta dto = delegate.getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaPersonaLocalizacionVentas(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }
    
    @Override
    public List<TareaPersonaLocalizacionVenta> getVentaIndividualDetalleResponseItemsDtoToTareaPersonaLocalizacionVentas(List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tarea){
        List<TareaPersonaLocalizacionVenta> dtoList = new ArrayList<>();
        for (PtrVentaIndividualDetalleResultItemDto childDto : src) {
            TareaPersonaLocalizacionVenta dto = delegate.getVentaIndividualDetalleResponseResponseItemsDtoToTareaPersonaLocalizacionVentas(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }
    
}
