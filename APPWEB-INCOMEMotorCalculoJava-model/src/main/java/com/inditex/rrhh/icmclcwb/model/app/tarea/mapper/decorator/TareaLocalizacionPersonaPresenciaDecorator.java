package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresencia;

public abstract class TareaLocalizacionPersonaPresenciaDecorator
        extends TareaLocalizacionPersonaPresenciaMapper {

    @Autowired
    private TareaLocalizacionPersonaPresenciaMapper delegate;

    @Override
    public List<TareaLocalizacionPersonaPresencia> presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(
            List<PtrPresenciaDetalleResultItemDto> src, TareaDto tareaDto) {
        List<TareaLocalizacionPersonaPresencia> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> 
                result.add(
                        delegate.presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(item, tareaDto))
            );
        }
        return result;
    }

}
