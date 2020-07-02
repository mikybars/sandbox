package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoAmbitoPersona;

public abstract class TrabajoAmbitoPersonaMapperDecorator extends TrabajoAmbitoPersonaMapper {

    @Autowired
    private TrabajoAmbitoPersonaMapper delegate;

    @Override
    public List<TrabajoAmbitoPersona> mergeTrabajoAmbitoPersonaDtoAndTrabajoDtoToTrabajoAmbitoPersona(
            List<TrabajoAmbitoPersonaDto> srcTrabajoAmbitoPersona, TrabajoDto srcTrabajo) {
        List<TrabajoAmbitoPersona> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(srcTrabajoAmbitoPersona)) {
            srcTrabajoAmbitoPersona.forEach(item -> result
                .add(delegate.mergeTrabajoAmbitoPersonaDtoAndTrabajoDtoToTrabajoAmbitoPersona(item, srcTrabajo)));
        }
        return result;
    }

}
