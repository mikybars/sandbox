package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresencia;

public abstract class TareaLocalizacionPresenciaDecorator
        extends TareaLocalizacionPresenciaMapper {

    @Autowired
    private TareaLocalizacionPresenciaMapper delegate;

    @Override
    public List<TareaLocalizacionPresencia> genericEmpleadoResultItemDtoToTareaLocalizacionPresencia(
            final List<GenericEmpleadoResultItemDto> src, final TareaDto tareaDto) {
        final List<TareaLocalizacionPresencia> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> {
                if (AppConstants.SECCIONES_STRING.contains(item.getIdSeccion())) {
                    result.add(
                            this.delegate.genericEmpleadoResultItemDtoToTareaLocalizacionPresencia(item,
                                    tareaDto));
                }
            });
        }
        return result;
    }

}
