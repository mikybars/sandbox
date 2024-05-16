package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.FaseService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaFaseMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaFaseRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaFaseServiceImpl implements TareaFaseService {

  @Autowired
  private TareaFaseRepositoryCustom tareaFaseRepositoryCustom;

  @Autowired
  private TareaFaseMapper tareaFaseMapper;

  @Autowired
  private FaseService faseService;

  @Override
  public List<TareaFaseDto> create(@Valid @NotNull final RunTareaDto runTareaDto) {
    final TareaDto tareaDto = runTareaDto.getTarea();
    return this.save(this.faseService.findAll()
        .stream()
        .map(x -> TareaFaseDto.builder()
            .idFase(x.getId())
            .activo(Boolean.TRUE)
            .idTarea(tareaDto.getId())
            .estadoTareaFase(EstadoTareaFaseEnum.PENDIENTE.getDto())
            .fechaHoraCreacion(LocalDateTime.now())
            .build())
        .collect(Collectors.toList()));
  }

  @Override
  public List<TareaFaseDto> save(
      @Valid @NotNull @NotEmpty final List<TareaFaseDto> tareaFase) {
    return this.tareaFaseMapper
        .tareaFaseToTareaFaseDto(
            this.tareaFaseRepositoryCustom.save(this.tareaFaseMapper
                .tareaFaseDtoToTareaFase(tareaFase)));
  }

  @Override
  public TareaFaseDto findTareaFaseDtoByIdTareaAndIdFase(@NotNull final Long idTarea,
      @NotNull final Integer idFase) {
    return this.tareaFaseRepositoryCustom.findTareaFaseDtoByIdTareaAndIdFase(idTarea, idFase);
  }

  @Override
  public List<TareaFaseDto> findTareaFaseDtoByIdTarea(@NotNull final Long idTarea) {
    return this.tareaFaseRepositoryCustom.findTareaFaseDtoByIdTarea(idTarea);
  }

  @Override
  public void updateFechaInicio(@Valid @NotNull final TareaFaseDto tareaFaseDto) {
    this.tareaFaseRepositoryCustom.updateFechaInicio(tareaFaseDto);
  }

  @Override
  public void updateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual(@Valid @NotNull final TareaDto tareaDto,
      @Valid @NotNull final EstadoTareaFaseDto estadoTareaFaseActualDto,
      @Valid @NotNull final EstadoTareaFaseDto estadoTareaFaseDto) {
    this.tareaFaseRepositoryCustom.updateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual(tareaDto,
        estadoTareaFaseActualDto,
        estadoTareaFaseDto);
  }

  @Override
  public void updateActivo(@Valid @NotNull final RunTareaDto runTareaDto) {
    this.tareaFaseRepositoryCustom.updateActivoByIdTarea(runTareaDto.getTarea());
  }

  @Override
  public void updateActivoByIdTareaFase(@Valid @NotNull final TareaFaseDto tareaFaseDto) {
    this.tareaFaseRepositoryCustom.updateActivoByIdTareaFase(tareaFaseDto);
  }

  @Override
  public void updateFechaFinAndEstado(
      @Valid @NotNull final TareaFaseDto tareaFaseDto,
      @Valid @NotNull final EstadoTareaFaseDto estadoTareaFaseDto) {
    this.tareaFaseRepositoryCustom.updateFechaFinAndEstado(tareaFaseDto, estadoTareaFaseDto);
  }

  @Override
  public void updateFechaInicioAndFechaFinAndEstado(
      @Valid @NotNull final TareaFaseDto tareaFaseDto,
      @Valid @NotNull final EstadoTareaFaseDto estadoTareaFaseDto) {
    this.tareaFaseRepositoryCustom.updateFechaInicioAndFechaFinAndEstado(tareaFaseDto, estadoTareaFaseDto);
  }

}
