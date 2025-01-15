package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaAusenciaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaAusenciaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaAusenciaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaAusenciaHistoricoRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaPersonaAusenciaHistoricoServiceImpl implements TareaPersonaAusenciaHistoricoService {

  @Autowired
  private TareaPersonaAusenciaHistoricoRepositoryCustom tareaPersonaAusenciaHistoricoRepositoryCustom;

  @Autowired
  private TareaPersonaAusenciaHistoricoMapper tareaPersonaAusenciaHistoricoMapper;

  @Override
  public List<TareaPersonaAusenciaHistoricoDto> save(
      @Valid @NotNull @NotEmpty final List<TareaPersonaAusenciaHistoricoDto> tareaPersonaAusenciaHistorico) {
    return tareaPersonaAusenciaHistoricoMapper.tareaPersonaAusenciaHistoricoToTareaPersonaAusenciaHistoricoDto(
        tareaPersonaAusenciaHistoricoRepositoryCustom.save(tareaPersonaAusenciaHistoricoMapper
            .tareaPersonaAusenciaHistoricoDtoToTareaPersonaAusenciaHistorico(tareaPersonaAusenciaHistorico)));
  }

  @Override
  public List<TareaPersonaAusenciaHistoricoDto> saveAusenciaResultItemDto(
      @Valid @NotNull @NotEmpty final List<AusenciasResultItemDto> src, @Valid @NotNull final TareaDto tarea) {
    return tareaPersonaAusenciaHistoricoMapper.tareaPersonaAusenciaHistoricoToTareaPersonaAusenciaHistoricoDto(
        tareaPersonaAusenciaHistoricoRepositoryCustom.save(tareaPersonaAusenciaHistoricoMapper
            .tareaPersonaAusenciaHistoricoDtoToTareaPersonaAusenciaHistorico(
                tareaPersonaAusenciaHistoricoMapper
                    .ausenciasResultItemDtoToTareaPersonaAusenciaHistoricoDto(src, tarea))));
  }

}
