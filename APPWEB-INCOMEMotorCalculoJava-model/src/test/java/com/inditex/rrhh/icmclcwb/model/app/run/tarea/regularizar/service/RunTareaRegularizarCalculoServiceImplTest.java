package com.inditex.rrhh.icmclcwb.model.app.run.tarea.regularizar.service;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunTareaRegularizarCalculoServiceImplTest {

  @Mock
  private TareaCalculoRepositoryCustom tareaCalculoRepositoryCustom;

  @Mock
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;;

  @InjectMocks
  private RunTareaRegularizarCalculoServiceImpl runTareaRegularizarCalculoServiceImpl;

  @Test
  public void regularizarCalculoMejorOpcion() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);

    this.runTareaRegularizarCalculoServiceImpl.regularizarCalculoMejorOpcion(runTareaDto);

    verify(this.tareaCalculoRepositoryCustom, timeout(1000).times(1))
        .regularizarMejorOpcion(
            ArgumentMatchers.any(TareaDto.class));
  }

  @Test
  public void regularizarMejorOpcionSinFechas() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);

    this.runTareaRegularizarCalculoServiceImpl.regularizarMejorOpcionSinFechas(runTareaDto);

    verify(this.tareaCalculoRepositoryCustom, timeout(1000).times(1))
        .regularizarMejorOpcionSinFechas(
            ArgumentMatchers.any(TareaDto.class));
  }

  @Test
  public void regularizarMejorOpcionSinFechasTodoPeriodo() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);

    this.runTareaRegularizarCalculoServiceImpl.regularizarMejorOpcionSinFechasTodoPeriodo(runTareaDto);

    verify(this.tareaCalculoRepositoryCustom, timeout(1000).times(1))
        .regularizarMejorOpcionSinFechasTodoPeriodo(
            ArgumentMatchers.any(TareaDto.class));
  }

}
