package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.FaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaFaseAccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaFaseAccionRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaFaseAccionServiceImpl implements TareaFaseAccionService {

  @Autowired
  private TareaFaseAccionRepositoryCustom tareaFaseAccionRepositoryCustom;

  @Autowired
  private TareaFaseAccionMapper tareaFaseAccionMapper;

  @Autowired
  private FaseAccionService faseAccionService;

  @Autowired
  private TareaFaseService tareaFaseService;

  @Override
  public List<TareaFaseAccionDto> save(
      @Valid @NonNull @NotEmpty final List<TareaFaseAccionDto> tareaFaseAccion) {
    return this.tareaFaseAccionMapper
        .tareaFaseAccionToTareaFaseAccionDto(
            this.tareaFaseAccionRepositoryCustom.save(this.tareaFaseAccionMapper
                .tareaFaseAccionDtoToTareaFaseAccion(tareaFaseAccion)));
  }

  @Override
  public TareaFaseAccionDto findById(@Valid @NonNull @Positive final Long idTareaFaseAccion) {
    return this.tareaFaseAccionRepositoryCustom.findById(idTareaFaseAccion);
  }

  @Override
  public void create(@Valid @NonNull final RunTareaDto runTareaDto) {
    final TareaDto tareaDto = runTareaDto.getTarea();
    final List<TareaFaseDto> tareaFaseDto = this.tareaFaseService.findTareaFaseDtoByIdTarea(tareaDto.getId());
    this.save(tareaFaseDto.stream().map(x -> {
      final List<FaseAccionDto> faseAccion = this.faseAccionService
          .findByIdFase(x.getIdFase());
      return faseAccion.stream().map(y -> {
        return TareaFaseAccionDto.builder()
            .idAccion(y.getIdAccion())
            .activo(Boolean.TRUE)
            .idEstadoTareaFaseAccion(EstadoTareaFaseAccionEnum.PENDIENTE.getId())
            .fechaHoraCreacion(LocalDateTime.now())
            .idPuntoEjecucion(y.getIdPuntoEjecucion())
            .idTareaFase(x.getId())
            .build();
      }).collect(Collectors.toList());
    }).flatMap(List::stream).collect(Collectors.toList()));
  }

  @Override
  public List<TareaFaseAccionDto> findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(
      @NonNull final Long idTarea, @NonNull final Integer idFase, @NonNull final Integer idPuntoEjecucion) {
    return this.tareaFaseAccionRepositoryCustom.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(
        idTarea,
        idFase, idPuntoEjecucion);
  }

  @Override
  public List<TareaFaseAccionDto> findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion(
      @NonNull final Long idTarea, @NonNull final Integer idFase, @NonNull final Integer idAccion,
      @NonNull final Integer idPuntoEjecucion) {
    return this.tareaFaseAccionRepositoryCustom
        .findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion(
            idTarea,
            idFase, idAccion, idPuntoEjecucion);
  }

  @Override
  public List<Long> findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion(
      @NonNull final Long idTarea, @NonNull final Integer idFase, @NonNull final Integer idPuntoEjecucion) {
    return this.tareaFaseAccionRepositoryCustom.findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion(idTarea,
        idFase, idPuntoEjecucion);
  }

  @Override
  public void updateFechaInicio(@Valid @NonNull final TareaFaseAccionDto tareaFaseAccionDto) {
    this.tareaFaseAccionRepositoryCustom.updateFechaInicio(tareaFaseAccionDto);
  }

  @Override
  public void updateFechaFinAndEstado(@Valid @NonNull final TareaFaseAccionDto tareaFaseAccionDto,
      @Valid @NonNull final EstadoTareaFaseAccionDto estadoTareaFaseAccionDto) {
    this.tareaFaseAccionRepositoryCustom.updateFechaFinAndEstado(tareaFaseAccionDto, estadoTareaFaseAccionDto);
  }

  @Override
  public void updateFechaInicioFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual(
      @Valid @NonNull final TareaFaseDto tareaFaseDto,
      @Valid @NonNull final EstadoTareaFaseAccionDto estadoTareaFaseAccionActualDto,
      @Valid @NonNull final EstadoTareaFaseAccionDto estadoTareaFaseAccionDto) {
    this.tareaFaseAccionRepositoryCustom.updateFechaInicioFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual(
        tareaFaseDto,
        estadoTareaFaseAccionActualDto, estadoTareaFaseAccionDto);
  }

  @Override
  public Integer countReintentosByIdTareaAndIdAccionAndIdEstado(
      @NonNull final TareaFaseAccionDto tareaFaseAccionDto,
      @NonNull final TareaFaseDto tareaFaseDto) {
    return this.tareaFaseAccionRepositoryCustom.countReintentosByIdTareaAndIdAccionAndIdEstado(tareaFaseAccionDto,
        tareaFaseDto);
  }

}
