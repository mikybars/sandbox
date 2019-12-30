package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaAusenciaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;

public interface TareaPersonaAusenciaHistoricoService {

    List<TareaPersonaAusenciaHistoricoDto> saveAusenciaResultItemDto(@Valid final List<AusenciasResultItemDto> src,
            @Valid final TareaDto tarea);

    List<TareaPersonaAusenciaHistoricoDto> save(
            @Valid final List<TareaPersonaAusenciaHistoricoDto> tareaPersonaAusenciaHistorico);

}
