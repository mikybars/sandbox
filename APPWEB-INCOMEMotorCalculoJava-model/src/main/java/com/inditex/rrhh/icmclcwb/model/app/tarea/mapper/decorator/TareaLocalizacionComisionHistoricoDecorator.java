package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionComisionHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionComisionHistorico;

public abstract class TareaLocalizacionComisionHistoricoDecorator extends TareaLocalizacionComisionHistoricoMapper {

    @Autowired
    private TareaLocalizacionComisionHistoricoMapper delegate;

    @Override
    public List<TareaLocalizacionComisionHistorico> mergeTareaLocalizacionComisionHistoricoDtoAndTareaDtoToTareaLocalizacionComisionHistorico(
            List<TareaLocalizacionComisionHistoricoDto> srcTareaLocalizacionComisionHistorico, TareaDto srcTarea) {
        List<TareaLocalizacionComisionHistorico> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(srcTareaLocalizacionComisionHistorico)) {
            srcTareaLocalizacionComisionHistorico.forEach(item -> 
                result.add(
                        delegate.mergeTareaLocalizacionComisionHistoricoDtoAndTareaDtoToTareaLocalizacionComisionHistorico(item, srcTarea))
            );
        }
        return result;
    }

}
