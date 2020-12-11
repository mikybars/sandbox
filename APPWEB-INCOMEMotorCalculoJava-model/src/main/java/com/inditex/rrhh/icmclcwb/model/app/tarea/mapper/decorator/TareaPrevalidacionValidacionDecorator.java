/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionValidacionDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confprevalid.ConfPreValidResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPrevalidacionValidacionMapper;


public abstract class TareaPrevalidacionValidacionDecorator extends TareaPrevalidacionValidacionMapper {

    @Autowired
    private TareaPrevalidacionValidacionMapper delegate;

    @Override
    public List<TareaPrevalidacionValidacionDto> confPreValidResultItemDtotoTareaPrevalidacionValidacionDto(
            final List<ConfPreValidResultItemDto> src, final TareaPrevalidacionDto tareaPrevalidacionDto) {
        final List<TareaPrevalidacionValidacionDto> result = new ArrayList<>();
        src.forEach(
                x -> result.add(this.delegate.confPreValidResultItemDtotoTareaPrevalidacionValidacionDto(x,
                        tareaPrevalidacionDto)));
        return result;
    }

}
