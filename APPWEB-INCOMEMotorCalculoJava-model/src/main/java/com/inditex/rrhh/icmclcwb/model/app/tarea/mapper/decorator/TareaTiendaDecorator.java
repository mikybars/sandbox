package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTienda;

public abstract class TareaTiendaDecorator extends TareaTiendaMapper {

    @Autowired
    private TareaTiendaMapper delegate;

    @Override
    public List<TareaTienda> mergeTareaTiendaDtoAndTareaDtoToTareaTienda(List<TareaTiendaDto> src,
            TareaDto tarea) {
        List<TareaTienda> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> result.add(delegate.mergeTareaTiendaDtoAndTareaDtoToTareaTienda(item, tarea)));
        }
        return result;
    }
}
