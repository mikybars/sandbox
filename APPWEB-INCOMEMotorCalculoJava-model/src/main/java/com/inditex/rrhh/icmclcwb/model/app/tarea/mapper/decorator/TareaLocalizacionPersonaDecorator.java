package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersona;

public abstract class TareaLocalizacionPersonaDecorator extends TareaLocalizacionPersonaMapper {

    @Autowired
    TareaLocalizacionPersonaMapper delegate;
    
    @Override
    public List<TareaLocalizacionPersona> presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersona(
            List<PtrPresenciaEmpleadosTiendaResultItemDto> src, TareaDto tareaDto)  {
        List<TareaLocalizacionPersona> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            for(PtrPresenciaEmpleadosTiendaResultItemDto item : src) {
                for(Integer persona : item.getPersonas()) {
                    result.add(delegate.presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersona(persona, item, tareaDto));                    
                }
            }
        }
        return result;
    }
}
