package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionChallengeDiasMinimosDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResultItemDto;

public interface TareaConfiguracionChallengeDiasMinimosService {

    void save(List<TareaConfiguracionChallengeDiasMinimosDto> src, TareaDto tarea);

    void saveConfChDiasMinimosResultItemDto(List<ConfChDiasMinimosResultItemDto> src, TareaDto tarea);

}
