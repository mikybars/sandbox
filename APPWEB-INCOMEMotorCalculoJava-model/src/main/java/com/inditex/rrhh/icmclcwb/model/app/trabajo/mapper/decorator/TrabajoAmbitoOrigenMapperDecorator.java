package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoOrigenMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoAmbitoOrigen;

public abstract class TrabajoAmbitoOrigenMapperDecorator extends TrabajoAmbitoOrigenMapper {

    @Autowired
    private TrabajoAmbitoOrigenMapper delegate;

    @Override
    public List<TrabajoAmbitoOrigen> mergeTrabajoAmbitoOrigenDtoAndTrabajoDtoToTrabajoAmbitoOrigen(
            List<TrabajoAmbitoOrigenDto> srcTrabajoAmbitoOrigen, TrabajoDto srcTrabajo) {
        List<TrabajoAmbitoOrigen> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(srcTrabajoAmbitoOrigen)) {
            srcTrabajoAmbitoOrigen.forEach(item -> result
                    .add(delegate.mergeTrabajoAmbitoOrigenDtoAndTrabajoDtoToTrabajoAmbitoOrigen(item, srcTrabajo)));
        }
        return result;
    }

}
