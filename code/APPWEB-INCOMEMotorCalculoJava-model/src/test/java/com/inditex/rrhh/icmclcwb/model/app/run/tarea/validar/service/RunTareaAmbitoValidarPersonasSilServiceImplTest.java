package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ClasePersonaSilAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.ClasePersonaSilAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;

import org.instancio.Instancio;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class RunTareaAmbitoValidarPersonasSilServiceImplTest {

  @Mock
  private Logger log;

  @Mock
  TareaFaseAccionService tareaFaseAccionService;

  @Mock
  private ComisAsyncService comisAsyncService;

  @Mock
  private AccionService accionService;

  @Mock
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @Mock
  private ValidacionMapper validacionMapper;

  @Mock
  private PrevalidarPropertiesDto personasPropertiesDto;

  @Mock
  private ClasePersonaSilAmbitoService clasePersonaSilAmbitoService;

  @InjectMocks
  private RunTareaAmbitoValidarPersonasSilServiceImpl runTareaAmbitoValidarPersonasGlobalService;

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void executeTest(final RunTareaDto runTarea, final TareaAmbitoDto tareaAmbito,
      final TareaFaseAccionDto tareaFaseAccion,
      final IdPersonaLocalLocalizacionDto persona1) {

    final List<ClasePersonaSilAmbitoDto> clasesEstados = Instancio.ofList(ClasePersonaSilAmbitoDto.class).size(1).create();

    final CompletableFuture<List<IdPersonaLocalLocalizacionDto>> cf1 = new CompletableFuture<>();
    cf1.complete(Collections.singletonList(persona1));

    when(this.clasePersonaSilAmbitoService.getClaseAndEstadoByCclIdOrigenAndStdIdLegEnt(tareaAmbito.getCclIdOrigen(),
        runTarea.getTarea().getStdIdLegEnt()))
            .thenReturn(clasesEstados);

    when(this.comisAsyncService.findPersonasSil(any(RunTareaDto.class), any(TareaAmbitoDto.class), any(Long.class),
        any(ClaseResultItemDto.class)))
            .thenReturn(cf1);

    this.runTareaAmbitoValidarPersonasGlobalService.execute(runTarea, tareaAmbito, tareaFaseAccion);

    verify(this.comisAsyncService, timeout(1000).times(1)).findPersonasSil(eq(runTarea), eq(tareaAmbito),
        eq(AppConstants.MIN_ID_PERSONA_EXTERNO_NO_ES),
        any(ClaseResultItemDto.class));
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1)).createTempComisPersonasLocalizaciones();
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1)).indexTempComisPersonasLocalizaciones();
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1))
        .insertTempComisPersonasLocalizaciones(Collections.singletonList(persona1));
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1)).validateTempComisPersonas(runTarea.getTarea());
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1)).deleteTempComisPersonasLocalizaciones();
    verify(this.validacionMapper, timeout(1000).times(1)).idPersonaLocalDtoTovalidacionDto(eq(tareaAmbito), eq(tareaFaseAccion),
        ArgumentMatchers.any(), eq(this.personasPropertiesDto), eq(runTarea.getTarea()));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void executeExceptionTest( final RunTareaDto runTarea,  final TareaAmbitoDto tareaAmbito,
       final TareaFaseAccionDto tareaFaseAccion) {

    when(this.clasePersonaSilAmbitoService.getClaseAndEstadoByCclIdOrigenAndStdIdLegEnt(tareaAmbito.getCclIdOrigen(),
        runTarea.getTarea().getStdIdLegEnt()))
            .thenThrow(RuntimeException.class);

    assertThrows(RuntimeException.class, () -> {
      this.runTareaAmbitoValidarPersonasGlobalService.execute(runTarea, tareaAmbito, tareaFaseAccion);
    });
    verify(this.tareaFaseAccionService, timeout(1000).times(1)).updateFechaFinAndEstado(tareaFaseAccion,
        EstadoTareaFaseAccionEnum.ERROR.getDto());

  }

}
