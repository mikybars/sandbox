package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCadenaPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaCadenaPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCadenaPresencia;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class TareaCadenaPresenciaDecorator extends TareaCadenaPresenciaMapper {

    @Autowired
    private TareaCadenaPresenciaMapper delegate;

    @Override
    public List<TareaCadenaPresencia> presenciasTotalizadoResponseDtoToTareaCadenaPresencia(List<PtrPresenciaTotalizadoResultItemDto> src, TareaDto tareaDto) {
        List<TareaCadenaPresencia> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> result
                .add(delegate.presenciasTotalizadoResponseDtoToTareaCadenaPresencia(item, tareaDto)));;
        }
        return result;
    }

    @Override
    public List<TareaCadenaPresenciaDto> tareaCadenaPresenciaToTareaCadenaPresenciaDto(List<TareaCadenaPresencia> src) {
        List<TareaCadenaPresenciaDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> result
                .add(delegate.tareaCadenaPresenciaToTareaCadenaPresenciaDto(item)));
        }
        return result;
    }
}
