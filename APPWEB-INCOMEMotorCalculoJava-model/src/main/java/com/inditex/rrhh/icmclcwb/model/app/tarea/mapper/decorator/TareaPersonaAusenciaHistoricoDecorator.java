package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaAusenciaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaAusenciaHistoricoMapper;

public abstract class TareaPersonaAusenciaHistoricoDecorator extends TareaPersonaAusenciaHistoricoMapper {

    @Autowired
    private TareaPersonaAusenciaHistoricoMapper delegate;
    
    @Override
    public List<TareaPersonaAusenciaHistoricoDto> ausenciasResultItemDtoToTareaPersonaAusenciaHistoricoDto(
            List<AusenciasResultItemDto> src, TareaDto tareaDto) {
        List<TareaPersonaAusenciaHistoricoDto> result = new ArrayList<>();
        if (src != null) {
            src.stream().forEach(x -> {
                TareaPersonaAusenciaHistoricoDto entity = delegate.ausenciasResultItemDtoToTareaPersonaAusenciaHistoricoDto(x, tareaDto);
                result.add(entity);
            });
        }
        return result;
    }

}
