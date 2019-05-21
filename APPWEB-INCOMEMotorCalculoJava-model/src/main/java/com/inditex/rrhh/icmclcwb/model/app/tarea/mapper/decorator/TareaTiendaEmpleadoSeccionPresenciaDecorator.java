package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaEmpleadoSeccionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaEmpleadoSeccionPresencia;

public abstract class TareaTiendaEmpleadoSeccionPresenciaDecorator extends TareaTiendaEmpleadoSeccionPresenciaMapper {
    
    @Autowired
    private TareaTiendaEmpleadoSeccionPresenciaMapper delegate;

    @Override
    public List<TareaTiendaEmpleadoSeccionPresencia> presenciasDetalleResponseDtoToTareaTiendaEmpleadoSeccionPresencia(
            List<PtrPresenciaDetalleResultItemDto> src, TareaDto tareaDto, Integer idSeccion) {
        List<TareaTiendaEmpleadoSeccionPresencia> dtoList = new ArrayList<>();
        for (PtrPresenciaDetalleResultItemDto childDto : src) {
            TareaTiendaEmpleadoSeccionPresencia dto = delegate.presenciasDetalleResponseDtoToTareaTiendaEmpleadoSeccionPresencia(childDto, tareaDto, idSeccion);
            dtoList.add(dto);
        }
        return dtoList;
    }

}
