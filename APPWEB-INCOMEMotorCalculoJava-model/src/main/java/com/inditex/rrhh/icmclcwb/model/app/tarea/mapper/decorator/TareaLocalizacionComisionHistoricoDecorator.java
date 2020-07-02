package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionComisionHistoricoMapper;

public abstract class TareaLocalizacionComisionHistoricoDecorator extends TareaLocalizacionComisionHistoricoMapper {

    @Autowired
    private TareaLocalizacionComisionHistoricoMapper delegate;

    @Override
    public List<TareaLocalizacionComisionHistoricoDto> genericLocalizacionResultItemDtoToTareaLocalizacionComisionHistoricoDto(
            List<GenericTiendaResultItemDto> src, TareaDto srcTarea) {
        List<TareaLocalizacionComisionHistoricoDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> result.add(
                    delegate.genericLocalizacionResultItemDtoToTareaLocalizacionComisionHistoricoDto(item, srcTarea)));
        }
        return result;
    }

}
