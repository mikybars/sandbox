package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.Programacion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;

public abstract class TareaMapperDecorator extends TareaMapper {

    @Autowired
    private TareaMapper delegate;

    public Tarea tareaToTareaDto(TareaDto src) {
        Tarea dto = delegate.tareaDtoToTarea(src);
        if (src.getIdProgramacion() != null) {
            Programacion programacion = new Programacion();
            programacion.setId(src.getIdProgramacion());
            dto.setProgramacion(programacion);
        }
        return dto;
    }
    
    public TareaDto tareaDtoToTarea(Tarea src) {
        TareaDto dto = delegate.tareaToTareaDto(src);
        if (src.getProgramacion() != null) {
            dto.setIdProgramacion(src.getProgramacion().getId());
        }
        return dto;
    }

}
