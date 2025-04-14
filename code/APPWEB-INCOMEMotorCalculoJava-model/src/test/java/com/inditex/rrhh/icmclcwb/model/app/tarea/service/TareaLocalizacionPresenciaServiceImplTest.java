package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresenciaRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaLocalizacionPresenciaServiceImplTest {

  @Mock
  private TareaLocalizacionPresenciaRepositoryCustom tareaLocalizacionPresenciaRepositoryCustom;

  @InjectMocks
  private TareaLocalizacionPresenciaServiceImpl tareaLocalizacionPresenciaServiceImpl;

  @Mock
  private TrabajoServiceImpl trabajoServiceImpl;

  @Test
  public void updateActivoVacioTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPresenciaServiceImpl.updateActivoVacio(runTarea);
    verify(this.tareaLocalizacionPresenciaRepositoryCustom, times(1)).updateActivoVacio(any(RunTareaDto.class));
  }

  @Test
  public void compensarTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPresenciaServiceImpl.compensar(runTarea);
    verify(this.tareaLocalizacionPresenciaRepositoryCustom, times(1)).compensar(any(RunTareaDto.class));
  }

  @Test
  public void totalizarTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPresenciaServiceImpl.totalizar(runTarea);
    verify(this.tareaLocalizacionPresenciaRepositoryCustom, times(1)).totalizar(any(RunTareaDto.class));
  }

  @Test
  public void totalizarEcommerceTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPresenciaServiceImpl.totalizarEcommerce(runTarea);
    verify(this.tareaLocalizacionPresenciaRepositoryCustom, times(1)).totalizarEcommerce(any(RunTareaDto.class));
  }

  @Test
  public void compensarLocalizacionManual() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPresenciaServiceImpl.compensarLocalizacionManual(runTarea);
    verify(this.tareaLocalizacionPresenciaRepositoryCustom, times(1))
        .compensarLocalizacionManual(any(RunTareaDto.class));
  }

  @Test
  public void totalizarEmpleadosPorVentaTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPresenciaServiceImpl.totalizarEmpleadosPorVenta(runTarea);
    verify(this.tareaLocalizacionPresenciaRepositoryCustom, times(1))
        .totalizarEmpleadosPorVenta(any(RunTareaDto.class));
  }

  @Test
  public void repartirPresenciasSindicalesLocalizacionTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPresenciaServiceImpl.repartirPresenciasSindicalesLocalizacion(runTarea);
    verify(this.tareaLocalizacionPresenciaRepositoryCustom, times(1))
        .repartirPresenciasSindicalesLocalizacion(runTarea);
  }

  @Test
  public void repartirPresenciasSindicalesLocalizacionSeccionTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPresenciaServiceImpl.repartirPresenciasSindicalesLocalizacionSeccion(runTarea);
    verify(this.tareaLocalizacionPresenciaRepositoryCustom, times(1))
        .repartirPresenciasSindicalesLocalizacionSeccion(runTarea);
  }

  @Test
  public void totalizarIncluidoChallengePorcentajeTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPresenciaServiceImpl.totalizarIncluidoChallengePorcentaje(runTarea);
    verify(this.tareaLocalizacionPresenciaRepositoryCustom, times(1)).totalizarIncluidoChallengePorcentaje(any(RunTareaDto.class));
  }

  @Test
  public void compensarLocalizacionManualIncluidoChallengePorcentaje() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPresenciaServiceImpl.compensarLocalizacionManualIncluidoChallengePorcentaje(runTarea);
    verify(this.tareaLocalizacionPresenciaRepositoryCustom, times(1))
        .compensarLocalizacionManualIncluidoChallengePorcentaje(any(RunTareaDto.class));
  }

  @Test
  public void updateSindicalCerrada() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);

    this.tareaLocalizacionPresenciaServiceImpl.updateSindicalCerrada(runTarea);
    verify(this.tareaLocalizacionPresenciaRepositoryCustom, times(1))
        .updateSindicalCerrada(any(RunTareaDto.class));
  }

}
