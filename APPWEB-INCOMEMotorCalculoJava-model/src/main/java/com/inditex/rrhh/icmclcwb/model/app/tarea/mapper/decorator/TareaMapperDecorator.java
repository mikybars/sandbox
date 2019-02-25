package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;

public abstract class TareaMapperDecorator extends TareaMapper {

    @Autowired
    private TareaMapper delegate;

    @Override
    public List<TareaDto> mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(
            List<TrabajoAmbitoEmpresaDto> srcTrabajoAmbitoEmpresa, TrabajoDto srcTrabajo) {
        List<TareaDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(srcTrabajoAmbitoEmpresa)) {
            srcTrabajoAmbitoEmpresa.forEach(
                    item -> result.add(delegate.mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(item, srcTrabajo)));
        }
        return result;
    }

}
