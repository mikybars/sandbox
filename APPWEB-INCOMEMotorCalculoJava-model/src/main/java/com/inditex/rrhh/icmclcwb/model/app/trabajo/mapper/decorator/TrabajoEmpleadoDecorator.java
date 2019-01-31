package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoEmpleadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleado;

public abstract class TrabajoEmpleadoDecorator extends TrabajoEmpleadoMapper {

    @Autowired
    private TrabajoEmpleadoMapper delegate;

    @Override
    public List<TrabajoEmpleado> mergeTrabajoEmpleadoDtoAndTrabajoDtoToTrabajoEmpleado(List<TrabajoEmpleadoDto> src,
            TrabajoDto trabajo) {
        List<TrabajoEmpleado> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(
                    item -> result.add(delegate.mergeTrabajoEmpleadoDtoAndTrabajoDtoToTrabajoEmpleado(item, trabajo)));
        }
        return result;
    }

}