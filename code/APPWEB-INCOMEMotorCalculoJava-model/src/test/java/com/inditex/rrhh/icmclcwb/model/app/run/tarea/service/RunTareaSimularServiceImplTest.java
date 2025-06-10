package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.simulacion.service.SimulacionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class RunTareaSimularServiceImplTest {

  public static final long ID_SIMULACION = 1L;

  @Mock
  private SimulacionService simulacionService;

  @InjectMocks
  private RunTareaSimularServiceImpl runTareaSimularServiceImpl;

  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  void runTest(boolean isSimulacion) {

    final RunTareaDto runTarea = new RunTareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    runTarea.setTrabajo(trabajo);
    runTarea.setTarea(new TareaDto());

    if (isSimulacion) {
      trabajo.setIdSimulacion(ID_SIMULACION);

      this.runTareaSimularServiceImpl.run(runTarea);

      verify(this.simulacionService, times(1))
          .mergeEstructurasEmpleadoSimulacion(any(TareaDto.class));
      verify(this.simulacionService, times(1))
          .mergePresenciasEmpleadoSimulacion(any(TareaDto.class));
    } else {
      this.runTareaSimularServiceImpl.run(runTarea);

      verify(this.simulacionService, times(0))
          .mergeEstructurasEmpleadoSimulacion(any(TareaDto.class));
      verify(this.simulacionService, times(0))
          .mergePresenciasEmpleadoSimulacion(any(TareaDto.class));
    }
  }

}
