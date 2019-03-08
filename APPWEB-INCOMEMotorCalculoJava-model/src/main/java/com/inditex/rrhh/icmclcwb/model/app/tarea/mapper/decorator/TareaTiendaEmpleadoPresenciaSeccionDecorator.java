package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaEmpleadoPresenciaSeccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaEmpleadoPresenciaSeccion;

public abstract class TareaTiendaEmpleadoPresenciaSeccionDecorator extends TareaTiendaEmpleadoPresenciaSeccionMapper {

    @Autowired
    private TareaTiendaEmpleadoPresenciaSeccionMapper delegate; 
    
    @Override
    public List<TareaTiendaEmpleadoPresenciaSeccion> presenciasDetalleComisionableResponseDtoToTareaTiendaEmpleadoPresenciaSeccion(
            List<PtrPresenciaDetalleComisionableResultItemDto> src, TareaDto tareaDto) {

        List<TareaTiendaEmpleadoPresenciaSeccion> dtoList = new ArrayList<>();
        for (PtrPresenciaDetalleComisionableResultItemDto childDto : src) {
            TareaTiendaEmpleadoPresenciaSeccion dto = delegate.presenciasDetalleComisionableResponseDtoToTareaTiendaEmpleadoPresenciaSeccion(childDto, tareaDto);
            dtoList.add(dto);
        }
        return dtoList;
        
    }

}
