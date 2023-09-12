
package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaFaseAccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaFaseAccionRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaFaseAccionServiceImplTest {

  @Mock
  private TareaFaseAccionRepositoryCustom tareaFaseAccionRepositoryCustom;

  @Mock
  private TareaFaseAccionMapper tareaFaseAccionMapper;

  @Mock
  private FaseAccionServiceImpl faseAccionService;

  @Mock
  private TareaFaseServiceImpl tareaFaseService;

  @InjectMocks
  private TareaFaseAccionServiceImpl tareaFaseAccionServiceImpl;

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<TareaFaseAccionDto> tareaFaseAccionDto = new ArrayList<>();
    this.tareaFaseAccionServiceImpl.save(tareaFaseAccionDto);
    verify(this.tareaFaseAccionRepositoryCustom, times(1)).save(ArgumentMatchers
        .<List<TareaFaseAccion>>any());
  }

  @Test
  public void findById() {
    final Long idTareaFaseAccion = 1L;

    this.tareaFaseAccionServiceImpl.findById(idTareaFaseAccion);
    verify(this.tareaFaseAccionRepositoryCustom, times(1))
        .findById(any(Long.class));
  }

  @Test
  public void create() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTareaDto.setTarea(tarea);
    when(this.tareaFaseService.findTareaFaseDtoByIdTarea(any(Long.class)))
        .thenReturn(new ArrayList<TareaFaseDto>());

    this.tareaFaseAccionServiceImpl.create(runTareaDto);
    verify(this.tareaFaseAccionRepositoryCustom, times(1))
        .save(ArgumentMatchers
            .<List<TareaFaseAccion>>any());
  }

  @Test
  public void findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion() {
    final Long idTarea = 1L;
    final Integer idFase = 1;
    final Integer idPuntoEjecucion = 1;

    this.tareaFaseAccionServiceImpl.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(idTarea, idFase,
        idPuntoEjecucion);
    verify(this.tareaFaseAccionRepositoryCustom, times(1))
        .findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(any(Long.class), any(Integer.class),
            any(Integer.class));
  }

  @Test
  public void findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion() {
    final Long idTarea = 1L;
    final Integer idFase = 1;
    final Integer idAccion = 1;
    final Integer idPuntoEjecucion = 1;

    this.tareaFaseAccionServiceImpl.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion(idTarea,
        idFase, idAccion,
        idPuntoEjecucion);
    verify(this.tareaFaseAccionRepositoryCustom, times(1))
        .findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion(any(Long.class), any(Integer.class),
            any(Integer.class),
            any(Integer.class));
  }

  @Test
  public void findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion() {
    final Long idTarea = 1L;
    final Integer idFase = 1;
    final Integer idPuntoEjecucion = 1;

    this.tareaFaseAccionServiceImpl.findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion(idTarea,
        idFase,
        idPuntoEjecucion);
    verify(this.tareaFaseAccionRepositoryCustom, times(1))
        .findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion(any(Long.class), any(Integer.class),
            any(Integer.class));
  }

  @Test
  public void updateFechaInicio() {
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();

    this.tareaFaseAccionServiceImpl.updateFechaInicio(tareaFaseAccionDto);
    verify(this.tareaFaseAccionRepositoryCustom, times(1))
        .updateFechaInicio(any(TareaFaseAccionDto.class));
  }

  @Test
  public void updateFechaFinAndEstado() {
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    final EstadoTareaFaseAccionDto estadoTareaFaseAccionDto = EstadoTareaFaseAccionEnum.OK.getDto();

    this.tareaFaseAccionServiceImpl.updateFechaFinAndEstado(tareaFaseAccionDto, estadoTareaFaseAccionDto);
    verify(this.tareaFaseAccionRepositoryCustom, times(1))
        .updateFechaFinAndEstado(any(TareaFaseAccionDto.class), any(EstadoTareaFaseAccionDto.class));
  }

  @Test
  public void updateFechaInicioFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual() {
    final TareaFaseDto tareaFaseDto = new TareaFaseDto();
    final EstadoTareaFaseAccionDto estadoTareaFaseAccionDto = EstadoTareaFaseAccionEnum.OK.getDto();
    final EstadoTareaFaseAccionDto estadoTareaFaseAccionKoDto = EstadoTareaFaseAccionEnum.KO.getDto();

    this.tareaFaseAccionServiceImpl.updateFechaInicioFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual(
        tareaFaseDto, estadoTareaFaseAccionKoDto, estadoTareaFaseAccionDto);
    verify(this.tareaFaseAccionRepositoryCustom, times(1))
        .updateFechaInicioFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual(any(TareaFaseDto.class),
            any(EstadoTareaFaseAccionDto.class), any(EstadoTareaFaseAccionDto.class));
  }

  @Test
  public void countReintentosByIdTareaAndIdAccionAndIdEstado() {
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    final TareaFaseDto tareaFaseDto = new TareaFaseDto();

    this.tareaFaseAccionServiceImpl.countReintentosByIdTareaAndIdAccionAndIdEstado(
        tareaFaseAccionDto, tareaFaseDto);
    verify(this.tareaFaseAccionRepositoryCustom, times(1))
        .countReintentosByIdTareaAndIdAccionAndIdEstado(any(TareaFaseAccionDto.class),
            any(TareaFaseDto.class));
  }

}
