package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.DesplazamientoRealDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDesplazamientoRealDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraDesplazamientoRealService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraDesplazamientoRealMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraDesplazamientoRealRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaPersonaEstructuraDesplazamientoRealServiceImpl
    implements TareaPersonaEstructuraDesplazamientoRealService {

  @Autowired
  private TareaPersonaEstructuraDesplazamientoRealRepositoryCustom tareaPersonaEstructuraDesplazamientoRealRepositoryCustom;

  @Autowired
  private TareaPersonaEstructuraDesplazamientoRealMapper tareaPersonaEstructuraDesplazamientoRealMapper;

  @Override
  public List<TareaPersonaEstructuraDesplazamientoRealDto> save(
      @Valid @NonNull @NotEmpty final List<TareaPersonaEstructuraDesplazamientoRealDto> tareaPersonaEstructuraDesplazamientoReal,
      @Valid @NonNull final TareaDto tarea) {
    return this.tareaPersonaEstructuraDesplazamientoRealMapper
        .tareaPersonaEstructuraDesplazamientoRealToTareaPersonaEstructuraDesplazamientoRealDto(
            this.tareaPersonaEstructuraDesplazamientoRealRepositoryCustom
                .save(this.tareaPersonaEstructuraDesplazamientoRealMapper
                    .tareaPersonaEstructuraDesplazamientoRealDtoToTareaPersonaEstructuraDesplazamientoReal(
                        tareaPersonaEstructuraDesplazamientoReal)));
  }

  @Override
  public List<TareaPersonaEstructuraDesplazamientoRealDto> saveDesplazamientoRealResultItemDto(
      @Valid @NonNull @NotEmpty final List<DesplazamientoRealResultItemDto> desplazamientoReal,
      @Valid @NonNull final TareaDto tarea) {
    return this.tareaPersonaEstructuraDesplazamientoRealMapper
        .tareaPersonaEstructuraDesplazamientoRealToTareaPersonaEstructuraDesplazamientoRealDto(
            this.tareaPersonaEstructuraDesplazamientoRealRepositoryCustom
                .save(this.tareaPersonaEstructuraDesplazamientoRealMapper
                    .desplazamientoRealResultItemDtoToTareaPersonaEstructuraDesplazamientoReal(
                        desplazamientoReal, tarea)));
  }

  @Override
  public List<DesplazamientoRealDto> findDesplazamientoReal(@Valid @NonNull final TareaDto tarea) {
    return this.tareaPersonaEstructuraDesplazamientoRealRepositoryCustom.findDesplazamientoReal(tarea);
  }

}
