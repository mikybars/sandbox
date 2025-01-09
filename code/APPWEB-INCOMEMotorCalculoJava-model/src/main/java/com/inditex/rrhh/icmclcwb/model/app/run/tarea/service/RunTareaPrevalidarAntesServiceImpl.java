package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPrevalidarAntesService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.PuntoEjecucionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaPrevalidarAntesServiceImpl extends AbstractRunTareaPrevalidar implements RunTareaPrevalidarAntesService {

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Override
  public void run(@NonNull @Valid final RunTareaDto runTareaDto,
      @NonNull @Valid final FaseDto faseDto) {
    final TareaDto tareaDto = runTareaDto.getTarea();

    final Map<Integer, List<TareaFaseAccionDto>> fases = this.tareaFaseAccionService
        .findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(tareaDto.getId(), faseDto.getId(),
            PuntoEjecucionEnum.ANTES.getId())
        .stream()
        .sorted(Comparator.comparingInt(TareaFaseAccionDto::getPeso)
            .reversed())
        .collect(Collectors.groupingBy(TareaFaseAccionDto::getPeso));

    final List<ValidacionDto> validaciones = this.ejecucion(runTareaDto, fases);

    final List<ValidacionDto> fallidas = validaciones.stream()
        .filter(e -> Boolean.FALSE.equals(e.getResult()))
        .sorted(Comparator.comparingInt(ValidacionDto::getReaccionPeso)
            .reversed())
        .map(e -> {
          this.actualizaFechasAntes(runTareaDto, faseDto, e);
          return e;
        })
        .collect(Collectors.toList());

    this.procesarFallidas(runTareaDto, tareaDto, faseDto, fallidas);

  }

}
