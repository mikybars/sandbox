package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionCadenaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionCadenaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TareaAgrupacionCadena;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionCadenaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionCadenaRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaAgrupacionCadenaServiceImpl implements TareaAgrupacionCadenaService {

  @Autowired
  private TareaAgrupacionCadenaMapper tareaAgrupacionCadenaMapper;

  @Autowired
  private TareaAgrupacionCadenaRepositoryCustom tareaAgrupacionCadenaRepositoryCustom;

  @Autowired
  private TareaAgrupacionCadenaRepository tareaAgrupacionCadenaRepository;

  @Override
  public List<TareaAgrupacionCadenaDto> save(@Valid @NotNull @NotEmpty final List<AgrupOnlineResultItemDto> src,
      @Valid @NotNull final TareaDto tarea) {
    final List<TareaAgrupacionCadena> agrupaciones = this.tareaAgrupacionCadenaMapper
        .getAgrupOnlineResultItemDtoToTareaAgrupacionCadena(src, tarea);
    return this.tareaAgrupacionCadenaMapper.getTareaAgrupacionCadenaToTareaAgrupacionCadenaDto(
        this.tareaAgrupacionCadenaRepositoryCustom.save(agrupaciones));
  }

  @Override
  public List<TareaAgrupacionCadenasDto> findAgrupacionesByTarea(@Valid @NotNull final TareaDto tarea) {
    final List<TareaAgrupacionCadena> agrupaciones = this.tareaAgrupacionCadenaRepository.findByTareaId(tarea.getId());
    return this.tareaAgrupacionCadenaMapper.getTareaAgrupacionCadenaToTareaAgrupacionCadenasDto(agrupaciones);
  }

}
