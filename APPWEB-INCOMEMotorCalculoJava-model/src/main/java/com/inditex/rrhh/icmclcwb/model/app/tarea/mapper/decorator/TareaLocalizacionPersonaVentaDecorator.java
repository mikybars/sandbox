package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;

public abstract class TareaLocalizacionPersonaVentaDecorator extends TareaLocalizacionPersonaVentaMapper {

    @Autowired
    private TareaLocalizacionPersonaVentaMapper delegate;
    
    @Override
    public List<TareaLocalizacionPersonaVenta> getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaLocalizacionPersonaVentas(List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> src, TareaDto tarea){
        List<TareaLocalizacionPersonaVenta> dtoList = new ArrayList<>();
        for (PtrVentaOnlineIpodIndividualDetalleResultItemDto childDto : src) {
            TareaLocalizacionPersonaVenta dto = delegate.getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaLocalizacionPersonaVentas(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }
    
    @Override
    public List<TareaLocalizacionPersonaVenta> getVentaIndividualDetalleResponseItemsDtoToTareaLocalizacionPersonaVentas(List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tarea){
        List<TareaLocalizacionPersonaVenta> dtoList = new ArrayList<>();
        for (PtrVentaIndividualDetalleResultItemDto childDto : src) {
            TareaLocalizacionPersonaVenta dto = delegate.getVentaIndividualDetalleResponseResponseItemsDtoToTareaLocalizacionPersonaVentas(childDto, tarea);
            dtoList.add(dto);
        }
        return dtoList;
    }
    
}
