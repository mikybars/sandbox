package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaVentaSeccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaVentaSeccion;

public abstract class TareaTiendaVentaSeccionDecorator extends TareaTiendaVentaSeccionMapper {

    @Autowired
    private TareaTiendaVentaSeccionMapper delegate;
    
    @Override
    public List<TareaTiendaVentaSeccion> getVentaTotalizadoResponseItemDtoToTareaTiendaVentaSeccion(
            List<PtrVentaTotalizadoResultItemDto> src, TareaDto tarea){
        List<TareaTiendaVentaSeccion> dtoList = new ArrayList<>();
        for (PtrVentaTotalizadoResultItemDto childDto : src) {
            TareaTiendaVentaSeccion dto = delegate.getVentaTotalizadoResponseItemDtoToTareaTiendaVentaSeccion(childDto, tarea);
            dtoList.add(dto);
        }
        
        return dtoList;
    }

}
