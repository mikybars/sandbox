package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPendienteService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionDatoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaAmbitoValidarCalculoPendienteServiceImplTest {

  @Mock
  private TareaFaseAccionServiceImpl tareaFaseAccionService;

  @Mock
  private TareaCalculoPendienteService tareaCalculoPendienteService;

  @Mock
  private TareaFaseAccionDatoServiceImpl tareaFaseAccionFallidasService;

  @Mock
  private ValidacionMapper validacionMapper;

  @InjectMocks
  private RunTareaAmbitoValidarCalculoPendienteServiceImpl runTareaAmbitoValidarCalculoPendiente;

  @Test
  void executeWithResultsTest() {
    final RunTareaDto runTareaDto = this.createRunTareaDto();
    final TareaAmbitoDto tareaAmbitoDto = this.createTareaAmbitoDto();
    final TareaFaseAccionDto tareaFaseAccionDto = this.createTareaFaseAccionDto();
    final IdPersonaLocalDto idPersonaLocalDto = new IdPersonaLocalDto();
    idPersonaLocalDto.setIdPersonaLocal("12345");
    final List<IdPersonaLocalDto> calculoPendienteList = List.of(idPersonaLocalDto);
    final ValidacionDto validacionDto = new ValidacionDto();

    when(this.tareaCalculoPendienteService.findPersonaCalculoPendiente(1L))
        .thenReturn(calculoPendienteList);
    when(this.validacionMapper.idPersonaLocalDtoTovalidacionDto(any(), any(), any(), any(), any()))
        .thenReturn(validacionDto);
    when(this.validacionMapper.booleanToValidacionDto(tareaAmbitoDto, tareaFaseAccionDto, true))
        .thenReturn(new ValidacionDto());

    this.runTareaAmbitoValidarCalculoPendiente.execute(runTareaDto, tareaAmbitoDto, tareaFaseAccionDto);

    verify(this.tareaCalculoPendienteService).findPersonaCalculoPendiente(1L);
    verify(this.tareaFaseAccionFallidasService).save(anyList());
    verify(this.validacionMapper).idPersonaLocalDtoTovalidacionDto(any(), any(), any(), any(), any());
  }

  @Test
  void executeWithEmptyResultsTest() {
    final RunTareaDto runTareaDto = this.createRunTareaDto();
    final TareaAmbitoDto tareaAmbitoDto = this.createTareaAmbitoDto();
    final TareaFaseAccionDto tareaFaseAccionDto = this.createTareaFaseAccionDto();
    final List<IdPersonaLocalDto> emptyList = Collections.emptyList();
    final ValidacionDto validacionDto = new ValidacionDto();

    when(this.tareaCalculoPendienteService.findPersonaCalculoPendiente(1L))
        .thenReturn(emptyList);
    when(this.validacionMapper.idPersonaLocalDtoTovalidacionDto(any(), any(), any(), any(), any()))
        .thenReturn(validacionDto);
    when(this.validacionMapper.booleanToValidacionDto(tareaAmbitoDto, tareaFaseAccionDto, true))
        .thenReturn(new ValidacionDto());

    this.runTareaAmbitoValidarCalculoPendiente.execute(runTareaDto, tareaAmbitoDto, tareaFaseAccionDto);

    verify(this.tareaCalculoPendienteService).findPersonaCalculoPendiente(1L);
    verify(this.validacionMapper).idPersonaLocalDtoTovalidacionDto(any(), any(), any(), any(), any());
  }

  @Test
  void executeHandlesExceptionTest() {
    final RunTareaDto runTareaDto = this.createRunTareaDto();
    final TareaAmbitoDto tareaAmbitoDto = this.createTareaAmbitoDto();
    final TareaFaseAccionDto tareaFaseAccionDto = this.createTareaFaseAccionDto();

    when(this.tareaCalculoPendienteService.findPersonaCalculoPendiente(1L))
        .thenThrow(new RuntimeException("Test exception"));
    when(this.validacionMapper.booleanToValidacionDto(tareaAmbitoDto, tareaFaseAccionDto, true))
        .thenReturn(new ValidacionDto());

    this.runTareaAmbitoValidarCalculoPendiente.execute(runTareaDto, tareaAmbitoDto, tareaFaseAccionDto);

    verify(this.tareaCalculoPendienteService).findPersonaCalculoPendiente(1L);
    verify(this.validacionMapper).booleanToValidacionDto(tareaAmbitoDto, tareaFaseAccionDto, true);
  }

  private RunTareaDto createRunTareaDto() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    final TrabajoDTO trabajoDTO = new TrabajoDTO();
    trabajoDTO.setId(1L);
    tareaDto.setId(1L);
    tareaDto.setStdIdLegEnt("8");
    runTareaDto.setTarea(tareaDto);
    runTareaDto.setTrabajo(trabajoDTO);
    return runTareaDto;
  }

  private TareaAmbitoDto createTareaAmbitoDto() {
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setIdTarea(1L);
    tareaAmbitoDto.setCclIdOrigen("11");
    return tareaAmbitoDto;
  }

  private TareaFaseAccionDto createTareaFaseAccionDto() {
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    tareaFaseAccionDto.setId(1L);
    return tareaFaseAccionDto;
  }
}
