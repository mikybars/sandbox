package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaEmpleadoPresenciaSeccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaEmpleadoPresenciaSeccion;

public abstract class TareaTiendaEmpleadoPresenciaSeccionDecorator extends TareaTiendaEmpleadoPresenciaSeccionMapper {

    @Autowired
    private TareaTiendaEmpleadoPresenciaSeccionMapper delegate; 
    
    @Override
    public List<TareaTiendaEmpleadoPresenciaSeccion> presenciasDetalleResponseDtoToTareaTiendaEmpleadoPresenciaSeccion(
            List<PtrPresenciaDetalleResultItemDto> src, TareaDto tareaDto) {

        List<TareaTiendaEmpleadoPresenciaSeccion> dtoList = new ArrayList<>();
        for (PtrPresenciaDetalleResultItemDto childDto : src) {
            TareaTiendaEmpleadoPresenciaSeccion dto = delegate.presenciasDetalleResponseDtoToTareaTiendaEmpleadoPresenciaSeccion(childDto, tareaDto);
            dtoList.add(dto);
        }
        return dtoList;
        
    }

}
