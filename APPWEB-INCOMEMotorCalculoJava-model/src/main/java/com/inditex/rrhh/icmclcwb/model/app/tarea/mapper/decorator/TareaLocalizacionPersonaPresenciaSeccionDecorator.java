package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaPresenciaSeccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresenciaSeccion;

public abstract class TareaLocalizacionPersonaPresenciaSeccionDecorator
        extends TareaLocalizacionPersonaPresenciaSeccionMapper {

    @Autowired
    private TareaLocalizacionPersonaPresenciaSeccionMapper delegate;
    

    @Override
    public List<TareaLocalizacionPersonaPresenciaSeccion> presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresenciaSeccion(
            List<PtrPresenciaDetalleResultItemDto> src, TareaDto tareaDto) {
        List<TareaLocalizacionPersonaPresenciaSeccion> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> 
                result.add(
                        delegate.presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresenciaSeccion(item, tareaDto))
            );
        }
        return result;
    }

}
