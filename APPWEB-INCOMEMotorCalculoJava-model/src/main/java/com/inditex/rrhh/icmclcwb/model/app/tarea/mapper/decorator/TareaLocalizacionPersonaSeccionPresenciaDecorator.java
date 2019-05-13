package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaSeccionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaSeccionPresencia;

public abstract class TareaLocalizacionPersonaSeccionPresenciaDecorator
        extends TareaLocalizacionPersonaSeccionPresenciaMapper {

    @Autowired
    private TareaLocalizacionPersonaSeccionPresenciaMapper delegate;

    @Override
    public List<TareaLocalizacionPersonaSeccionPresencia> genericEmpleadoResultItemDtoToTareaLocalizacionPersonaSeccionPresencia(
            List<GenericEmpleadoResultItemDto> src, TareaDto tareaDto) {
        List<TareaLocalizacionPersonaSeccionPresencia> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> 
                result.add(
                        delegate.genericEmpleadoResultItemDtoToTareaLocalizacionPersonaSeccionPresencia(item, tareaDto))
            );
        }
        return result;
    }
}
