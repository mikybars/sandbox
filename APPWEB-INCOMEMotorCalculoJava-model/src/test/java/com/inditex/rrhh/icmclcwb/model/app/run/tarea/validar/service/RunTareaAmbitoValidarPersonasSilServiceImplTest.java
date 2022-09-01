package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
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
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @InjectMocks
  private RunTareaAmbitoValidarPersonasSilServiceImpl runTareaAmbitoValidarPersonasGlobalService;

  @Test
  void executeTest(@Random final RunTareaDto runTarea, @Random final TareaAmbitoDto tareaAmbito,
      @Random final TareaFaseAccionDto tareaFaseAccion,
      @Random final IdPersonaLocalLocalizacionDto persona1,
      @Random final IdPersonaLocalLocalizacionDto persona2,
      @Random final IdPersonaLocalLocalizacionDto persona3,
      @Random final IdPersonaLocalLocalizacionDto persona4) {

    final CompletableFuture<List<IdPersonaLocalLocalizacionDto>> cf1 = new CompletableFuture<>();
    cf1.complete(Collections.singletonList(persona1));
    final CompletableFuture<List<IdPersonaLocalLocalizacionDto>> cf2 = new CompletableFuture<>();
    cf2.complete(Collections.singletonList(persona2));
    final CompletableFuture<List<IdPersonaLocalLocalizacionDto>> cf3 = new CompletableFuture<>();
    cf3.complete(Collections.singletonList(persona3));
    final CompletableFuture<List<IdPersonaLocalLocalizacionDto>> cf9 = new CompletableFuture<>();
    cf9.complete(Collections.singletonList(persona4));

    tareaAmbito.setCclIdOrigen("6");

    final ClaseResultItemDto clase1 = ClaseResultItemDto.builder().idOrigen(tareaAmbito.getCclIdOrigen()).idClase("1").build();
    final ClaseResultItemDto clase3 = ClaseResultItemDto.builder().idOrigen(tareaAmbito.getCclIdOrigen()).idClase("3").build();
    final ClaseResultItemDto clase9 = ClaseResultItemDto.builder().idOrigen(tareaAmbito.getCclIdOrigen()).idClase("9").build();
    final ClaseResultItemDto clase2 =
        ClaseResultItemDto.builder().idOrigen(tareaAmbito.getCclIdOrigen()).idClase("2").idsEstadoSil(Arrays.asList("10")).build();

    final ClaseResponseDto clase = ClaseResponseDto
        .builder()
        .items(Arrays.asList(clase1, clase2, clase3, clase9))
        .build();

    when(this.meta4IcmWsCalcIncomeService.getClases(any(ClaseRequestDto.class))).thenReturn(clase);
    when(this.comisAsyncService.findPersonasSil(any(RunTareaDto.class), any(TareaAmbitoDto.class), any(Long.class), eq(clase1)))
        .thenReturn(cf1);
    when(this.comisAsyncService.findPersonasSil(any(RunTareaDto.class), any(TareaAmbitoDto.class), any(Long.class), eq(clase2)))
        .thenReturn(cf2);
    when(this.comisAsyncService.findPersonasSil(any(RunTareaDto.class), any(TareaAmbitoDto.class), any(Long.class), eq(clase3)))
        .thenReturn(cf3);
    when(this.comisAsyncService.findPersonasSil(any(RunTareaDto.class), any(TareaAmbitoDto.class), any(Long.class), eq(clase9)))
        .thenReturn(cf9);

    this.runTareaAmbitoValidarPersonasGlobalService.execute(runTarea, tareaAmbito, tareaFaseAccion);

    verify(this.comisAsyncService, timeout(1000).times(1)).findPersonasSil(runTarea, tareaAmbito, AppConstants.MIN_ID_PERSONA_EXTERNO_NO_ES,
        clase1);
    verify(this.comisAsyncService, timeout(1000).times(1)).findPersonasSil(runTarea, tareaAmbito, AppConstants.MIN_ID_PERSONA_EXTERNO_NO_ES,
        clase2);
    verify(this.comisAsyncService, timeout(1000).times(1)).findPersonasSil(runTarea, tareaAmbito, AppConstants.MIN_ID_PERSONA_EXTERNO_NO_ES,
        clase3);
    verify(this.comisAsyncService, timeout(1000).times(1)).findPersonasSil(runTarea, tareaAmbito, AppConstants.MIN_ID_PERSONA_EXTERNO_NO_ES,
        clase9);
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1)).createTempComisPersonasLocalizaciones();
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1)).indexTempComisPersonasLocalizaciones();
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1))
        .insertTempComisPersonasLocalizaciones(Arrays.asList(persona1, persona3, persona4, persona2));
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1)).validateTempComisPersonas(runTarea.getTarea());
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1)).deleteTempComisPersonasLocalizaciones();
    verify(this.validacionMapper, timeout(1000).times(1)).idPersonaLocalDtoTovalidacionDto(eq(tareaAmbito), eq(tareaFaseAccion),
        ArgumentMatchers.<List<IdPersonaLocalDto>>any(), eq(
            this.personasPropertiesDto),
        eq(runTarea.getTarea()));

  }

  @Test
  void executeExceptionTest(@Random final RunTareaDto runTarea, @Random final TareaAmbitoDto tareaAmbito,
      @Random final TareaFaseAccionDto tareaFaseAccion) {

    when(this.comisAsyncService.findPersonas(any(RunTareaDto.class), any(TareaAmbitoDto.class), any(Long.class)))
        .thenThrow(RuntimeException.class);

    assertThrows(RuntimeException.class, () -> {
      this.runTareaAmbitoValidarPersonasGlobalService.execute(runTarea, tareaAmbito, tareaFaseAccion);
    });
    verify(this.tareaFaseAccionService, timeout(1000).times(1)).updateFechaFinAndEstado(tareaFaseAccion,
        EstadoTareaFaseAccionEnum.ERROR.getDto());

  }

}
