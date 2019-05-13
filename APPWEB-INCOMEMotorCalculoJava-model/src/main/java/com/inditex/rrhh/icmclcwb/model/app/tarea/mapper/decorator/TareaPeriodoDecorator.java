package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPeriodoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPeriodo;

public abstract class TareaPeriodoDecorator extends TareaPeriodoMapper {

    @Autowired
    private TareaPeriodoMapper delegate;

    @Override
    public List<TareaPeriodo> periodosResultItemDtoToTareaPeriodo(
            List<PeriodosResultItemDto> src, TareaDto tareaDto) {
        List<TareaPeriodo> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> 
                result.add(
                        delegate.periodosResultItemDtoToTareaPeriodo(item, tareaDto))
            );
        }
        return result;
    }
}
