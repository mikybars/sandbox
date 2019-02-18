package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaEmpleadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleado;

public abstract class TareaEmpleadoDecorator extends TareaEmpleadoMapper {

    @Autowired
    private TareaEmpleadoMapper delegate;

    @Override
    public List<TareaEmpleado> mergeTareaEmpleadoDtoAndTareaDtoToTareaEmpleado(List<TareaEmpleadoDto> src,
            TareaDto tarea) {
        List<TareaEmpleado> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(
                    item -> result.add(delegate.mergeTareaEmpleadoDtoAndTareaDtoToTareaEmpleado(item, tarea)));
        }
        return result;
    }

}