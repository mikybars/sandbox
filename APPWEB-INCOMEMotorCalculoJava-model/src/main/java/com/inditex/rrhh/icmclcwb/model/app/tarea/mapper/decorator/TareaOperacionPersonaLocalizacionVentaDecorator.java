package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaOperacionPersonaLocalizacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaOperacionPersonaLocalizacionVenta;

public abstract class TareaOperacionPersonaLocalizacionVentaDecorator
        extends TareaOperacionPersonaLocalizacionVentaMapper {
    
    @Autowired
    private TareaOperacionPersonaLocalizacionVentaMapper delegate;
    
    @Override
    public List<TareaOperacionPersonaLocalizacionVenta> getVentaIndividualDetalleResponseItemsDtoToTareaOperacionLocalizacionVentas(
            List<PtrVentaIndividualDetalleResultItemDto> src, TareaDto tareaDto) {
        List<TareaOperacionPersonaLocalizacionVenta> dtoList = new ArrayList<>();
        for (PtrVentaIndividualDetalleResultItemDto childDto : src) {
            TareaOperacionPersonaLocalizacionVenta dto = delegate.getVentaIndividualDetalleResponseItemsDtoToTareaOperacionLocalizacionVentas(childDto, tareaDto);
            dtoList.add(dto);
        }
        return dtoList;
    }

}
