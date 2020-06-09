package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionHistoricoMapper;
import org.apache.commons.collections.CollectionUtils;

public abstract class LocalizacionFicticiaHistoricoDecorator extends TareaLocalizacionHistoricoMapper {

    @Autowired
    private LocalizacionFicticiaHistoricoMapper delegate;

    @Override
    public List<TareaLocalizacionHistoricoDto> genericLocalizacionResultItemDtoToTareaLocalizacionHistoricoDto(
            final List<GenericTiendaResultItemDto> src, final TareaDto srcTarea) {
        final List<TareaLocalizacionHistoricoDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> result.add(
                    this.delegate.genericLocalizacionResultItemDtoToTareaLocalizacionHistoricoDto(item, srcTarea)));
        }
        return result;
    }

}
