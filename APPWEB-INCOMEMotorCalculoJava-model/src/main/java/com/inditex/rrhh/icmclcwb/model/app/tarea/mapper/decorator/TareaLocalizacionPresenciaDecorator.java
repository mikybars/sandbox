package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresencia;

public abstract class TareaLocalizacionPresenciaDecorator extends TareaLocalizacionPresenciaMapper {

    @Autowired
    private TareaLocalizacionPresenciaMapper delegate;

    @Override
    public List<TareaLocalizacionPresencia> presenciasTotalizadoResponseDtoToTareaLocalizacionSeccion(
            List<PtrPresenciaTotalizadoResultItemDto> src, TareaDto tareaDto) {
        List<TareaLocalizacionPresencia> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> result
                    .add(delegate.presenciasTotalizadoResponseDtoToTareaLocalizacionSeccion(item, tareaDto)));
        }
        return result;
    }
}
