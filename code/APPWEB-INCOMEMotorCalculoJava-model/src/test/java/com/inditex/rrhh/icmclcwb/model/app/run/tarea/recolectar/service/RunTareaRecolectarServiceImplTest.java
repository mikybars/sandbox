package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarCondicionesBaseService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarCondicionesService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarPreAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.simulacion.dto.SimulacionDto;
import com.inditex.rrhh.icmclcwb.api.app.simulacion.service.SimulacionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.service.RunTareaRecolectarServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarServiceImplTest {
  @Mock
  private RunTareaRecolectarPreAmbitoService runTareaRecolectarPreAmbitoService;

  @Mock
  private RunTareaRecolectarAmbitoService runTareaRecolectarAmbitoService;

  @Mock
  private RunTareaRecolectarCondicionesService runTareaRecolectarCondicionesService;

  @Mock
  private RunTareaRecolectarCondicionesBaseService runTareaRecolectarCondicionesBaseService;

  @Mock
  private TareaFaseService tareaFaseService;

  @Mock
  private SimulacionService simulacionService;

  @Spy
  @InjectMocks
  private RunTareaRecolectarServiceImpl RunTareaRecolectarServiceImpl;

  @Test
  void runTest() {
    final long idSimulacion = 1L;

    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    final TrabajoDTO trabajoDTO = new TrabajoDTO();
    final TareaFaseDto tareaFaseDto = new TareaFaseDto();

    trabajoDTO.setIdSimulacion(idSimulacion);
    runTarea.setTrabajo(trabajoDTO);
    runTarea.setTarea(tareaDto);

    when(this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
        FaseEnum.RECOLECTAR.getId())).thenReturn(tareaFaseDto);

    doNothing().when(this.tareaFaseService).updateFechaInicio(any(TareaFaseDto.class));
    doNothing().when(this.runTareaRecolectarPreAmbitoService).run(any(RunTareaDto.class));
    doNothing().when(this.runTareaRecolectarAmbitoService).run(any(RunTareaDto.class));
    doNothing().when(this.runTareaRecolectarCondicionesBaseService).run(any(RunTareaDto.class));
    doNothing().when(this.runTareaRecolectarCondicionesService).run(any(RunTareaDto.class));

    when(this.simulacionService.findbyId(idSimulacion)).thenReturn(new SimulacionDto());
    doNothing().when(this.simulacionService).updateBandaExcepcionada(any(TareaDto.class), any(SimulacionDto.class));
    doNothing().when(this.tareaFaseService).updateFechaFinAndEstado(any(TareaFaseDto.class), any(EstadoTareaFaseDto.class));

    this.RunTareaRecolectarServiceImpl.run(runTarea);

    verify(this.runTareaRecolectarPreAmbitoService).run(runTarea);
    verify(this.runTareaRecolectarAmbitoService).run(runTarea);
    verify(this.runTareaRecolectarCondicionesBaseService).run(runTarea);
    verify(this.runTareaRecolectarCondicionesService).run(runTarea);
    verify(this.RunTareaRecolectarServiceImpl).run(runTarea);

  }
}
