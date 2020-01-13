package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaAusenciaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaAusenciaHistorico;

public abstract class TareaPersonaAusenciaHistoricoDecorator extends TareaPersonaAusenciaHistoricoMapper {

    @Autowired
    private TareaPersonaAusenciaHistoricoMapper delegate;
    
    @Override
    public List<TareaPersonaAusenciaHistorico> ausenciasResultItemDtoToTareaPersonaAusenciaHistorico(
            List<AusenciasResultItemDto> src, TareaDto tareaDto) {
        List<TareaPersonaAusenciaHistorico> result = new ArrayList<>();
        if (src != null) {
            src.forEach(x ->
                result.add(delegate.ausenciasResultItemDtoToTareaPersonaAusenciaHistorico(x, tareaDto)));
        }
        return result;
    }

}
