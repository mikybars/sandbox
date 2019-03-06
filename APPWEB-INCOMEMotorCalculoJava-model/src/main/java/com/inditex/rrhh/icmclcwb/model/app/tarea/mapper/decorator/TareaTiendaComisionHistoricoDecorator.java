package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaComisionHistoricoMapper;

public abstract class TareaTiendaComisionHistoricoDecorator extends TareaTiendaComisionHistoricoMapper {

    @Autowired
    private TareaTiendaComisionHistoricoMapper delegate;

    @Override
    public List<TareaTiendaComisionHistoricoDto> genericTiendaResultItemDtoToTareaTiendaComisionHistoricoDto(
            List<GenericTiendaResultItemDto> src, TareaDto tarea) {
        List<TareaTiendaComisionHistoricoDto> result = new ArrayList<>();
        
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> result.add(delegate
                    .genericTiendaResultItemDtoToTareaTiendaComisionHistoricoDto(item, tarea)));
        }
        
        return result;
    }
}
