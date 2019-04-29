package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaPresenciaManualMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresenciaManual;

public abstract class TareaLocalizacionPersonaPresenciaManualDecorator
        extends TareaLocalizacionPersonaPresenciaManualMapper {

    @Autowired
    TareaLocalizacionPersonaPresenciaManualMapper delegate;
    
    @Override
    public List<TareaLocalizacionPersonaPresenciaManual> genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(
            List<GenericEmpleadoResultItemDto> src, TareaDto tareaDto) {
        List<TareaLocalizacionPersonaPresenciaManual> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            for(GenericEmpleadoResultItemDto item : src) {
                result.add(delegate.genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(item, tareaDto));                    
            }
        }
        return result;
    }

}
