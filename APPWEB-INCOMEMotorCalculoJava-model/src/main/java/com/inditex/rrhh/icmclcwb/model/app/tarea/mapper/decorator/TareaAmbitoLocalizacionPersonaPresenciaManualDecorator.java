package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoLocalizacionPersonaPresenciaManualMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoLocalizacionPersonaPresenciaManual;

public abstract class TareaAmbitoLocalizacionPersonaPresenciaManualDecorator
        extends TareaAmbitoLocalizacionPersonaPresenciaManualMapper {

    @Autowired
    TareaAmbitoLocalizacionPersonaPresenciaManualMapper delegate;
    
    @Override
    public List<TareaAmbitoLocalizacionPersonaPresenciaManual> genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(
            List<GenericEmpleadoResultItemDto> src, TareaDto tareaDto) {
        List<TareaAmbitoLocalizacionPersonaPresenciaManual> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            for(GenericEmpleadoResultItemDto item : src) {
                result.add(delegate.genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(item, tareaDto));                    
            }
        }
        return result;
    }

}
