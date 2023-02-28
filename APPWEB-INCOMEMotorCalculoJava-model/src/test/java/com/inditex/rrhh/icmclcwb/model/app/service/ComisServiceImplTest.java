
package com.inditex.rrhh.icmclcwb.model.app.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.ComisClaseEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalFechaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResultItemDto;
import com.inditex.rrhh.icmclcwb.model.comis.repository.ComisRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class ComisServiceImplTest {

  @Mock
  private ComisRepositoryCustom comisRepositoryCustom;

  @InjectMocks
  private ComisServiceImpl comisServiceImpl;

  @Mock
  private TareaAmbitoGlobalFechaService tareaAmbitoGlobalFechaService;

  private static final String ORIGEN = "1";

  private static final long ID_TAREA = 1L;

  @Test
  void findPresenciasOrigenAndFecha() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    this.comisServiceImpl.findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findPresenciasOrigenAndFecha(any(TareaDto.class));
  }

  @Test
  void findMotivoDesplazamiento() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    this.comisServiceImpl.findMotivoDesplazamiento(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findMotivoDesplazamiento(any(TareaDto.class));
  }

  @Test
  void findFechasIncidencias() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    this.comisServiceImpl.findFechasIncidencias(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findFechasIncidencias(any(TareaDto.class));
  }

  @Test
  void findFechasDesplazamientos() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    this.comisServiceImpl.findFechasDesplazamientos(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findFechasDesplazamientos(any(TareaDto.class));
  }

  @Test
  void findCondicionesHistorico() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
        ArgumentMatchers.any(Long.class), ArgumentMatchers.any(Integer.class)))
        .thenReturn(new PeriodoDto());

    this.comisServiceImpl.findCondicionesHistorico(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findCondicionesHistorico(any(TareaDto.class), any(PeriodoDto.class));
  }

  @Test
  void findCondicionesHistoricoEs() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    this.comisServiceImpl.findCondicionesHistoricoEs(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findCondicionesHistoricoEs(any(TareaDto.class));
  }

  @Test
  void findCondicionesDesplazamiento() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
        ArgumentMatchers.any(Long.class), ArgumentMatchers.any(Integer.class)))
        .thenReturn(new PeriodoDto());

    this.comisServiceImpl.findCondicionesDesplazamiento(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findCondicionesDesplazamiento(any(TareaDto.class), any(PeriodoDto.class));
  }

  @Test
  void findCondicionesDesplazamientoEs() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
        ArgumentMatchers.any(Long.class), ArgumentMatchers.any(Integer.class)))
        .thenReturn(new PeriodoDto());

    this.comisServiceImpl.findCondicionesDesplazamientoEs(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findCondicionesDesplazamientoEs(any(TareaDto.class), any(PeriodoDto.class));
  }

  @Test
  void findCondicionesResalta() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    this.comisServiceImpl.findCondicionesResalta(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findCondicionesResalta(any(TareaDto.class));
  }

  @Test
  void findCondicionesResaltaSinPrimas() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    this.comisServiceImpl.findCondicionesResaltaSinPrimas(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findCondicionesResaltaSinPrimas(any(TareaDto.class));
  }

  @Test
  void findCondicionesResaltaEs() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    this.comisServiceImpl.findCondicionesResaltaEs(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findCondicionesResaltaEs(any(TareaDto.class));
  }

  @Test
  void findCondicionesPrimas() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    this.comisServiceImpl.findCondicionesPrimas(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findCondicionesPrimas(any(TareaDto.class));
  }

  @Test
  void findBajasIt() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
        ArgumentMatchers.any(Long.class), ArgumentMatchers.any(Integer.class)))
        .thenReturn(new PeriodoDto());

    this.comisServiceImpl.findBajasIt(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findBajasIt(any(TareaDto.class), any(PeriodoDto.class));
  }

  @Test
  void findCarencia() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    this.comisServiceImpl.findCarencia(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findCarencia(any(TareaDto.class));
  }

  @Test
  void findEmpleadosExterosByClaseTest() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    this.comisServiceImpl.findExternosByClase(runTareaDto, tareaAmbitoDto,
        ComisClaseEmpleadoEnum.EMPLEADO_EXTERNO_BRASIL);
    verify(this.comisRepositoryCustom, times(1)).findExternosByClase(tarea,
        ComisClaseEmpleadoEnum.EMPLEADO_EXTERNO_BRASIL);
  }

  @Test
  void findEmpleadosExternosByMinIdPersonaTest() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    final Long idEmpleado = 898989L;
    this.comisServiceImpl.findExternosByMinIdPersona(runTareaDto, tareaAmbitoDto,
        idEmpleado);
    verify(this.comisRepositoryCustom, times(1)).findExternosByMinIdPersona(tarea,
        idEmpleado);
  }

  @Test
  void findBajasItEs() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    this.comisServiceImpl.findBajasItEs(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findBajasItEs(any(TareaDto.class));
  }

  @Test
  void findCondicionesHistoricoSinChallenge() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
        ArgumentMatchers.any(Long.class), ArgumentMatchers.any(Integer.class)))
        .thenReturn(new PeriodoDto());

    this.comisServiceImpl.findCondicionesHistoricoSinChallenge(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findCondicionesHistoricoSinChallenge(any(TareaDto.class), any(PeriodoDto.class));
  }

  @Test
  void findCondicionesDesplazamientoSinChallenge() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
        ArgumentMatchers.any(Long.class), ArgumentMatchers.any(Integer.class)))
        .thenReturn(new PeriodoDto());

    this.comisServiceImpl.findCondicionesDesplazamientoSinChallenge(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findCondicionesDesplazamientoSinChallenge(any(TareaDto.class), any(PeriodoDto.class));
  }

  @Test
  void findCondicionesResaltaSinChallenge() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    this.comisServiceImpl.findCondicionesResaltaSinChallenge(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findCondicionesResaltaSinChallenge(any(TareaDto.class));
  }

  @Test
  void findComisionManualTest(@Random final RunTareaDto runTarea, @Random final TareaAmbitoDto tareaAmbito) {
    this.comisServiceImpl.findComisionManual(runTarea, tareaAmbito);
    verify(this.comisRepositoryCustom, times(1)).findComisionManual(runTarea.getTarea());
  }

  @Test
  void findPersonasTest(@Random final RunTareaDto runTarea, @Random final TareaAmbitoDto tareaAmbitoDto, @Random final Long maxIdPersona) {
    this.comisServiceImpl.findPersonas(runTarea, tareaAmbitoDto, maxIdPersona);
    verify(this.comisRepositoryCustom, times(1)).findPersonas(runTarea.getTarea(), maxIdPersona);
  }

  @Test
  void findPersonasSilEstadoNullTest(@Random final RunTareaDto runTarea, @Random final TareaAmbitoDto tareaAmbitoDto,
      @Random final Long maxIdPersona, @Random final ClaseResultItemDto clase) {
    clase.setIdsEstadoSil(null);
    this.comisServiceImpl.findPersonasSil(runTarea, tareaAmbitoDto, maxIdPersona, clase);
    verify(this.comisRepositoryCustom, times(1)).findPersonasSilSinEstado(runTarea.getTarea(), maxIdPersona, clase);
  }

  @Test
  void findPersonasSilEstadoVacioTest(@Random final RunTareaDto runTarea, @Random final TareaAmbitoDto tareaAmbitoDto,
      @Random final Long maxIdPersona, @Random final ClaseResultItemDto clase) {
    clase.setIdsEstadoSil(new ArrayList<>());
    this.comisServiceImpl.findPersonasSil(runTarea, tareaAmbitoDto, maxIdPersona, clase);
    verify(this.comisRepositoryCustom, times(1)).findPersonasSilSinEstado(runTarea.getTarea(), maxIdPersona, clase);
  }

  @Test
  void findPersonasSilConEstadoTest(@Random final RunTareaDto runTarea, @Random final TareaAmbitoDto tareaAmbitoDto,
      @Random final Long maxIdPersona, @Random final ClaseResultItemDto clase) {
    clase.setIdsEstadoSil(Collections.singletonList("ea"));
    this.comisServiceImpl.findPersonasSil(runTarea, tareaAmbitoDto, maxIdPersona, clase);
    verify(this.comisRepositoryCustom, times(1)).findPersonasSilConEstado(runTarea.getTarea(), maxIdPersona, clase);
  }

  @Test
  void findCondicionesHistoricoChallengeIncluidoPorcentaje() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
        ArgumentMatchers.any(Long.class), ArgumentMatchers.any(Integer.class)))
        .thenReturn(new PeriodoDto());

    this.comisServiceImpl.findCondicionesHistoricoChallengeIncluidoPorcentaje(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findCondicionesHistoricoChallengeIncluidoPorcentaje(any(TareaDto.class), any(PeriodoDto.class));
  }

  @Test
  void findCondicionesDesplazamientoChallengeIncluidoPorcentaje() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    when(this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
        ArgumentMatchers.any(Long.class), ArgumentMatchers.any(Integer.class)))
        .thenReturn(new PeriodoDto());

    this.comisServiceImpl.findCondicionesDesplazamientoChallengeIncluidoPorcentaje(runTareaDto, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1))
        .findCondicionesDesplazamientoChallengeIncluidoPorcentaje(any(TareaDto.class), any(PeriodoDto.class));
  }

  @Test
  void validateTempComisRecuperarFranciaTest(@Random final RunTareaDto runTarea, @Random final TareaAmbitoDto tareaAmbitoDto) {
    this.comisServiceImpl.validateTempComisRecuperarFrancia(runTarea, tareaAmbitoDto);
    verify(this.comisRepositoryCustom, times(1)).validateTempComisRecuperarFrancia(runTarea.getTarea());
  }
}
