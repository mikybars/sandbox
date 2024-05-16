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
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class RunTareaAmbitoValidarPersonasEsServiceImplTest {

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

  @InjectMocks
  private RunTareaAmbitoValidarPersonasEsServiceImpl runTareaAmbitoValidarPersonasService;

  @ParameterizedTest
  @InstancioSource
  void executeTest(final RunTareaDto runTarea, final TareaAmbitoDto tareaAmbito,
      final TareaFaseAccionDto tareaFaseAccion,
      final IdPersonaLocalLocalizacionDto persona) {

    final List<IdPersonaLocalLocalizacionDto> lista = Collections.singletonList(persona);
    final CompletableFuture<List<IdPersonaLocalLocalizacionDto>> cf = new CompletableFuture<>();
    cf.complete(lista);

    when(this.comisAsyncService.findPersonas(any(RunTareaDto.class), any(TareaAmbitoDto.class), any(Long.class))).thenReturn(cf);

    this.runTareaAmbitoValidarPersonasService.execute(runTarea, tareaAmbito, tareaFaseAccion);

    verify(this.comisAsyncService, timeout(1000).times(1)).findPersonas(runTarea, tareaAmbito, AppConstants.MIN_ID_PERSONA_EXTERNO_ES);
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1)).createTempComisPersonasLocalizaciones();
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1)).indexTempComisPersonasLocalizaciones();
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1)).insertTempComisPersonasLocalizaciones(lista);
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1)).validateTempComisPersonas(runTarea.getTarea());
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1)).deleteTempComisPersonasLocalizaciones();
    verify(this.validacionMapper, timeout(1000).times(1)).idPersonaLocalDtoTovalidacionDto(eq(tareaAmbito), eq(tareaFaseAccion),
        ArgumentMatchers.any(), eq(
            this.personasPropertiesDto),
        eq(runTarea.getTarea()));

  }

  @ParameterizedTest
  @InstancioSource
  void executeExceptionTest(final RunTareaDto runTarea, final TareaAmbitoDto tareaAmbito,
      final TareaFaseAccionDto tareaFaseAccion) {

    when(this.comisAsyncService.findPersonas(any(RunTareaDto.class), any(TareaAmbitoDto.class), any(Long.class)))
        .thenThrow(RuntimeException.class);

    assertThrows(RuntimeException.class, () -> {
      this.runTareaAmbitoValidarPersonasService.execute(runTarea, tareaAmbito, tareaFaseAccion);
    });
    verify(this.tareaFaseAccionService, timeout(1000).times(1)).updateFechaFinAndEstado(tareaFaseAccion,
        EstadoTareaFaseAccionEnum.ERROR.getDto());

  }

}
