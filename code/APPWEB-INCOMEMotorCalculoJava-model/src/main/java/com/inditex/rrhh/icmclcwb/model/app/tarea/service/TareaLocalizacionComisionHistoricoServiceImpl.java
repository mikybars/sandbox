package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionComisionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionComisionHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionComisionHistoricoRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaLocalizacionComisionHistoricoServiceImpl implements TareaLocalizacionComisionHistoricoService {

  @Autowired
  private TareaLocalizacionComisionHistoricoMapper mapper;

  @Autowired
  private TareaLocalizacionComisionHistoricoRepositoryCustom tareaLocalizacionComisionHistoricoRepositoryCustom;

  @Override
  public List<TareaLocalizacionComisionHistoricoDto> save(
      @Valid @NotNull @NotEmpty final List<TareaLocalizacionComisionHistoricoDto> tareaLocalizacionHistorico) {
    return this.mapper
        .tareaLocalizacionComisionHistoricoToTareaLocalizacionComisionHistoricoDto(
            this.tareaLocalizacionComisionHistoricoRepositoryCustom
                .save(this.mapper.tareaLocalizacionComisionHistoricoDtoToTareaLocalizacionComisionHistorico(
                    tareaLocalizacionHistorico)));
  }

  @Override
  public List<TareaLocalizacionComisionHistoricoDto> merge(
      @Valid @NotNull @NotEmpty final List<GenericTiendaResultItemDto> genericTiendaResultItemDto,
      @Valid @NotNull final TareaDto tarea) {
    return this.mapper
        .genericLocalizacionResultItemDtoToTareaLocalizacionComisionHistoricoDto(genericTiendaResultItemDto, tarea);
  }

}
