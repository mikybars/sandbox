package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Programacion;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Trabajo;

public abstract class TrabajoMapperDecorator extends TrabajoMapper {

    @Autowired
    private TrabajoMapper delegate;

    public Trabajo trabajoToTrabajoDto(TrabajoDto src) {
        Trabajo dto = delegate.trabajoDtoToTrabajo(src);
        if (src.getIdProgramacion() != null) {
            Programacion programacion = new Programacion();
            programacion.setId(src.getIdProgramacion());
            dto.setProgramacion(programacion);
        }
        return dto;
    }
    
    public TrabajoDto trabajoDtoToTrabajo(Trabajo src) {
        TrabajoDto dto = delegate.trabajoToTrabajoDto(src);
        if (src.getProgramacion() != null) {
            dto.setIdProgramacion(src.getProgramacion().getId());
        }
        return dto;
    }

}
