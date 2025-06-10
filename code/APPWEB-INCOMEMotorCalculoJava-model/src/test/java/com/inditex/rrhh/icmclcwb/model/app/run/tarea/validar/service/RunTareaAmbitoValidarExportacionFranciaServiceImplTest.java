package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.Proceso;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoAmbitoEmpresa;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoAmbitoEmpresaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoRepository;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class RunTareaAmbitoValidarExportacionFranciaServiceImplTest {

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Mock
  private Logger log;

  @Mock
  private ValidacionMapper validacionMapper;

  @Mock
  private ProcesoRepository procesoRepository;

  @Mock
  private ProcesoAmbitoEmpresaRepository procesoAmbitoEmpresaRepository;

  @InjectMocks
  private RunTareaAmbitoValidarExportacionFranciaServiceImpl runTareaAmbitoValidarExportacionFranciaService;

  @ParameterizedTest
  @InstancioSource(samples = 1)
  public void executeTest(final RunTareaDto runTarea, final TareaAmbitoDto tareaAmbito, final TareaFaseAccionDto tareaFaseAccion,
      final Proceso proceso, final ProcesoAmbitoEmpresa procesoAmbitoEmpresa, final ValidacionDto validacionDto) {
    runTarea.getTrabajo().setTipoAmbito(TipoAmbitoEnum.EMPRESA.getDto());
    runTarea.getTrabajo().setIdSimulacion(null);

    doReturn(proceso).when(this.procesoRepository).save(any(Proceso.class));
    doReturn(procesoAmbitoEmpresa).when(this.procesoAmbitoEmpresaRepository).save(any(ProcesoAmbitoEmpresa.class));
    doReturn(validacionDto).when(this.validacionMapper).booleanToValidacionDto(tareaAmbito, tareaFaseAccion, true);

    this.runTareaAmbitoValidarExportacionFranciaService.execute(runTarea, tareaAmbito, tareaFaseAccion);

    verify(this.procesoRepository, times(1)).save(any(Proceso.class));
    verify(this.procesoAmbitoEmpresaRepository, times(1)).save(any(ProcesoAmbitoEmpresa.class));
    verify(this.validacionMapper, times(1)).booleanToValidacionDto(tareaAmbito, tareaFaseAccion, true);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  public void executeMalAmbitoTest(final RunTareaDto runTarea, final TareaAmbitoDto tareaAmbito,
      final TareaFaseAccionDto tareaFaseAccion) {
    runTarea.getTrabajo().setTipoAmbito(TipoAmbitoEnum.PERSONA.getDto());
    runTarea.getTrabajo().setIdSimulacion(null);

    assertThrows(IcmclcwbException.class, () -> {
      this.runTareaAmbitoValidarExportacionFranciaService.execute(runTarea, tareaAmbito, tareaFaseAccion);
    });
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  public void executeErrorTest(final RunTareaDto runTarea, final TareaAmbitoDto tareaAmbito,
      final TareaFaseAccionDto tareaFaseAccion) {
    runTarea.getTrabajo().setTipoAmbito(TipoAmbitoEnum.PERSONA.getDto());
    runTarea.getTrabajo().setIdSimulacion(null);

    doThrow(RuntimeException.class).when(this.procesoRepository).save(any(Proceso.class));

    assertThrows(Exception.class, () -> {
      this.runTareaAmbitoValidarExportacionFranciaService.execute(runTarea, tareaAmbito, tareaFaseAccion);
    });
  }

}
