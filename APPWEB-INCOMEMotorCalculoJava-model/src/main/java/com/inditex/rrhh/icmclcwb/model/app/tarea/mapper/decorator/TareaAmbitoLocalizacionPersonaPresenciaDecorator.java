package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoLocalizacionPersonaPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoLocalizacionPersonaPresencia;

public abstract class TareaAmbitoLocalizacionPersonaPresenciaDecorator extends TareaAmbitoLocalizacionPersonaPresenciaMapper {

    @Autowired
    private TareaAmbitoLocalizacionPersonaPresenciaMapper delegate;
    
    @Override
    public List<TareaAmbitoLocalizacionPersonaPresencia> presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersonaPresencia(
            List<PtrPresenciaEmpleadosTiendaResultItemDto> src, TareaDto tareaDto)  {
        List<TareaAmbitoLocalizacionPersonaPresencia> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            for(PtrPresenciaEmpleadosTiendaResultItemDto item : src) {
                for(Integer persona : item.getPersonas()) {
                    result.add(delegate.presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersonaPresencia(persona, item, tareaDto));                    
                }
            }
        }
        return result;
    }
}
