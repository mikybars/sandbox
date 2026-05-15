package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalSimpleDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaCalculoPersonaPrecioHoraServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaAmbitoCalcularPrecioHoraServiceImplTest {

  @Mock
  private TareaCalculoPersonaPrecioHoraServiceImpl tareaCalculoPersonaPrecioHoraService;

  @Mock
  private TareaFaseAccionServiceImpl tareaFaseAccionService;

  @Mock
  private ValidacionMapper validacionMapper;

  @InjectMocks
  private RunTareaAmbitoCalcularPrecioHoraServiceImpl runTareaAmbitoCalcularPrecioHoraServiceImpl;

  @Test
  void execute() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    final TrabajoDTO trabajoDto = new TrabajoDTO();
    trabajoDto.setIcmIdPeriodo(1L);
    runTareaDto.setTarea(tareaDto);
    runTareaDto.setTrabajo(trabajoDto);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    final FaseDto faseDto = new FaseDto();
    faseDto.setId(1);
    final AccionDto accionDto = new AccionDto();
    accionDto.setId(1);

    final IdPersonaLocalSimpleDto idPersonaLocalDto = new IdPersonaLocalSimpleDto();
    idPersonaLocalDto.setIdPersonaLocal("1");

    final List<IdPersonaLocalSimpleDto> idsPersonaLocal = List.of(idPersonaLocalDto);

    when(this.tareaCalculoPersonaPrecioHoraService.getIdsPersonasCalculoPrecioHoraByTareaAndAmbito(
        ArgumentMatchers.any(RunTareaDto.class), ArgumentMatchers.any(TareaAmbitoDto.class)))
            .thenReturn(idsPersonaLocal);

    when(this.tareaCalculoPersonaPrecioHoraService.calcularPrecioHora(
        ArgumentMatchers.any(RunTareaDto.class), ArgumentMatchers.any(TareaAmbitoDto.class),
        ArgumentMatchers.anyList()))
            .thenReturn(CompletableFuture.completedFuture(AsyncConstants.NIL));

    this.runTareaAmbitoCalcularPrecioHoraServiceImpl.execute(runTareaDto, tareaAmbitoDto, tareaFaseAccionDto);

    verify(this.tareaCalculoPersonaPrecioHoraService, timeout(1000)).getIdsPersonasCalculoPrecioHoraByTareaAndAmbito(
        ArgumentMatchers.any(RunTareaDto.class), ArgumentMatchers.any(TareaAmbitoDto.class));

    verify(this.tareaCalculoPersonaPrecioHoraService, timeout(1000)).calcularPrecioHora(
        ArgumentMatchers.any(RunTareaDto.class), ArgumentMatchers.any(TareaAmbitoDto.class),
        ArgumentMatchers.anyList());

    verify(this.validacionMapper, timeout(1000).times(1))
        .booleanToValidacionDto(ArgumentMatchers.any(TareaAmbitoDto.class),
            ArgumentMatchers.any(TareaFaseAccionDto.class), ArgumentMatchers.anyBoolean());

  }

  @Test
  void executeWithException() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    final TrabajoDTO trabajoDto = new TrabajoDTO();
    trabajoDto.setIcmIdPeriodo(1L);
    runTareaDto.setTarea(tareaDto);
    runTareaDto.setTrabajo(trabajoDto);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    final FaseDto faseDto = new FaseDto();
    faseDto.setId(1);
    final AccionDto accionDto = new AccionDto();
    accionDto.setId(1);

    final IdPersonaLocalSimpleDto idPersonaLocalDto = new IdPersonaLocalSimpleDto();
    idPersonaLocalDto.setIdPersonaLocal("1");

    final List<IdPersonaLocalSimpleDto> idsPersonaLocal = List.of(idPersonaLocalDto);

    when(this.tareaCalculoPersonaPrecioHoraService.getIdsPersonasCalculoPrecioHoraByTareaAndAmbito(
        ArgumentMatchers.any(RunTareaDto.class), ArgumentMatchers.any(TareaAmbitoDto.class)))
            .thenReturn(idsPersonaLocal);

    when(this.tareaCalculoPersonaPrecioHoraService.calcularPrecioHora(
        ArgumentMatchers.any(RunTareaDto.class), ArgumentMatchers.any(TareaAmbitoDto.class),
        ArgumentMatchers.anyList()))
            .thenThrow(new RuntimeException("Error al calcular el precio hora"));

    assertThrows(RuntimeException.class,
        () -> this.runTareaAmbitoCalcularPrecioHoraServiceImpl.execute(runTareaDto, tareaAmbitoDto, tareaFaseAccionDto));

    verify(this.tareaCalculoPersonaPrecioHoraService, timeout(1000)).getIdsPersonasCalculoPrecioHoraByTareaAndAmbito(
        ArgumentMatchers.any(RunTareaDto.class), ArgumentMatchers.any(TareaAmbitoDto.class));

    verify(this.tareaCalculoPersonaPrecioHoraService, timeout(1000)).calcularPrecioHora(
        ArgumentMatchers.any(RunTareaDto.class), ArgumentMatchers.any(TareaAmbitoDto.class),
        ArgumentMatchers.anyList());

    verify(this.tareaFaseAccionService, timeout(1000).times(1))
        .updateFechaFinAndEstado(
            tareaFaseAccionDto, EstadoTareaFaseAccionEnum.ERROR.getDto());
  }

}
