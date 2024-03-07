package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.ComisClaseEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.ReglaEmpleadoExternoMeta4Service;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaExternaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaExternaRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaAmbitoValidarExternosBrasilServiceImplTest {

  @Mock
  private ComisAsyncService comisAsyncService;

  @Mock
  private TareaPersonaExternaRepositoryCustom tareaPersonaExternaRepositoryCustom;

  @Mock
  private TareaPersonaExternaMapper tareaPersonaExternaMapper;

  @Mock
  private ValidacionMapper validacionMapper;

  @Mock
  private ReglaEmpleadoExternoMeta4Service reglaEmpleadoExternoMeta4Service;

  @InjectMocks
  private RunTareaAmbitoValidarExternosBrasilServiceImpl runTareaAmbitoValidarExternosBrasilService;

  @Test
  void executeTest() {

    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();

    final List<IdPersonaLocalExternaDto> lista = new ArrayList<>();
    final CompletableFuture<List<IdPersonaLocalExternaDto>> cf = new CompletableFuture<>();
    cf.complete(lista);

    when(this.comisAsyncService.findExternosByClase(any(RunTareaDto.class), any(TareaAmbitoDto.class), any(
        ComisClaseEmpleadoEnum.class))).thenReturn(cf);

    when(this.reglaEmpleadoExternoMeta4Service.getReglasEmpleadoExternoMeta4ActivasByCclIdOrigen(any(String.class), any(String.class)))
        .thenReturn(null);

    this.runTareaAmbitoValidarExternosBrasilService.execute(runTareaDto, tareaAmbitoDto, tareaFaseAccionDto);

    verify(this.comisAsyncService, timeout(1000).times(1)).findExternosByClase(runTareaDto, tareaAmbitoDto,
        ComisClaseEmpleadoEnum.EMPLEADO_EXTERNO_BRASIL);
    verify(this.tareaPersonaExternaMapper, timeout(1000).times(1))
        .idPersonaLocalExternaToTareaPersonaExterna(any(List.class), eq(tareaDto));
    verify(this.tareaPersonaExternaRepositoryCustom, timeout(1000).times(1)).save(any(List.class));
    verify(this.validacionMapper, timeout(1000).times(1)).booleanToValidacionDto(tareaAmbitoDto, tareaFaseAccionDto,
        true);
  }

}
