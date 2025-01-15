package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.CALCULAR_FESTIVOS;
import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.ID_PERSONA_LOCAL_CHALLENGE_BY_TAREA;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraDesplazamientoMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamiento;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraDesplazamientoRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaPersonaEstructuraServiceImpl implements TareaPersonaEstructuraService {

  @Autowired
  private TareaPersonaEstructuraRepositoryCustom tareaPersonaEstructuraRepositoryCustom;

  @Autowired
  private TareaPersonaEstructuraDesplazamientoRepositoryCustom tareaPersonaEstructuraDesplazamientoRepositoryCustom;

  @Autowired
  private TareaPersonaEstructuraMapper tareaPersonaEstructuraMapper;

  @Autowired
  private TareaPersonaEstructuraDesplazamientoMapper tareaPersonaEstructuraDesplazamientoMapper;

  @Override
  public List<TareaPersonaEstructuraDto> save(
      @Valid @NotNull @NotEmpty final List<TareaPersonaEstructuraDto> tareaPersonaEstructura,
      @Valid @NotNull final TareaDto tarea) {
    // Guardado de estructuras
    final List<TareaPersonaEstructuraDto> result = this.tareaPersonaEstructuraMapper
        .tareaPersonaEstructuraToTareaPersonaEstructuraDto(
            this.tareaPersonaEstructuraRepositoryCustom.save(this.tareaPersonaEstructuraMapper
                .tareaPersonaEstructuraDtoToTareaPersonaEstructura(tareaPersonaEstructura)));
    // Guardado de desplazamientos
    final List<TareaPersonaEstructuraDesplazamiento> desplazamientos = new ArrayList<>();
    tareaPersonaEstructura.stream().forEach(item -> {
      if (item.getEstructuraDesplazamiento() != null) {
        desplazamientos.add(this.tareaPersonaEstructuraDesplazamientoMapper
            .tareaPersonaEstructuraDesplazamientoDtoToTareaPersonaEstructuraDesplazamiento(
                item.getEstructuraDesplazamiento()));
      }
    });
    if (CollectionUtils.isNotEmpty(desplazamientos)) {
      this.tareaPersonaEstructuraDesplazamientoRepositoryCustom.save(desplazamientos);
    }
    return result;
  }

  @Override
  public List<TareaPersonaEstructuraDto> mergeEstructurasComResultItemDto(
      @Valid @NotNull @NotEmpty final List<EstructurasComResultItemDto> estructurasComResultItemDto,
      @Valid @NotNull final TareaDto tarea) {
    return this.tareaPersonaEstructuraMapper
        .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(estructurasComResultItemDto, tarea);
  }

  @Override
  @Cacheable(value = ID_PERSONA_LOCAL_CHALLENGE_BY_TAREA, key = "{#tarea}")
  public List<IdPersonaLocalDto> findPersonasChallenge(@Valid @NotNull final TareaDto tarea) {
    return this.tareaPersonaEstructuraRepositoryCustom.findPersonasChallenge(tarea);
  }

  @Override
  @Cacheable(value = CALCULAR_FESTIVOS, key = "{#tarea}")
  public Boolean calcularFestivos(
      @Valid @NotNull final TareaDto tarea) {
    return this.tareaPersonaEstructuraRepositoryCustom.calcularFestivos(tarea);
  }

}
