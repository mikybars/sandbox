package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTienda;

public abstract class TrabajoTiendaDecorator extends TrabajoTiendaMapper {

    @Autowired
    private TrabajoTiendaMapper delegate;

    @Override
    public List<TrabajoTienda> mergeTrabajoTiendaDtoAndTrabajoDtoToTrabajoTienda(List<TrabajoTiendaDto> src,
            TrabajoDto trabajo) {
        List<TrabajoTienda> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> result.add(delegate.mergeTrabajoTiendaDtoAndTrabajoDtoToTrabajoTienda(item, trabajo)));
        }
        return result;
    }
}
