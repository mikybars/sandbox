
package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaFaseMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFase;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaFaseRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaFaseServiceImplTest {

  @Mock
  private TareaFaseRepositoryCustom tareaFaseRepositoryCustom;

  @Mock
  private TareaFaseMapper tareaFaseMapper;

  @Mock
  private FaseServiceImpl faseService;

  @InjectMocks
  private TareaFaseServiceImpl tareaFaseServiceImpl;

  @Test
  public void create() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTareaDto.setTarea(tarea);

    this.tareaFaseServiceImpl.create(runTareaDto);
    verify(this.tareaFaseRepositoryCustom, times(1))
        .save(ArgumentMatchers
            .<List<TareaFase>>any());
  }

  @Test
  public void save() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<TareaFaseDto> tareaFaseDto = new ArrayList<>();
    this.tareaFaseServiceImpl.save(tareaFaseDto);
    verify(this.tareaFaseRepositoryCustom, times(1)).save(ArgumentMatchers
        .<List<TareaFase>>any());
  }

  @Test
  public void findTareaFaseDtoByIdTareaAndIdFase() {
    final Long idTarea = 1L;
    final Integer idFase = 1;

    this.tareaFaseServiceImpl.findTareaFaseDtoByIdTareaAndIdFase(idTarea, idFase);
    verify(this.tareaFaseRepositoryCustom, times(1))
        .findTareaFaseDtoByIdTareaAndIdFase(any(Long.class), any(Integer.class));
  }

  @Test
  public void findTareaFaseDtoByIdTarea() {
    final Long idTarea = 1L;

    this.tareaFaseServiceImpl.findTareaFaseDtoByIdTarea(idTarea);
    verify(this.tareaFaseRepositoryCustom, times(1))
        .findTareaFaseDtoByIdTarea(any(Long.class));
  }

  @Test
  public void updateFechaInicio() {
    final TareaFaseDto tareaFaseDto = new TareaFaseDto();

    this.tareaFaseServiceImpl.updateFechaInicio(tareaFaseDto);
    verify(this.tareaFaseRepositoryCustom, times(1))
        .updateFechaInicio(any(TareaFaseDto.class));
  }

  @Test
  public void updateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual() {
    final TareaDto tareaDto = new TareaDto();
    final EstadoTareaFaseDto estado = EstadoTareaFaseEnum.OK.getDto();

    this.tareaFaseServiceImpl.updateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual(tareaDto, estado,
        estado);
    verify(this.tareaFaseRepositoryCustom, times(1))
        .updateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual(any(TareaDto.class),
            any(EstadoTareaFaseDto.class), any(EstadoTareaFaseDto.class));
  }

  @Test
  public void updateActivo() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTareaDto.setTarea(tarea);

    this.tareaFaseServiceImpl.updateActivo(runTareaDto);
    verify(this.tareaFaseRepositoryCustom, times(1))
        .updateActivoByIdTarea(any(TareaDto.class));
  }

  @Test
  public void updateActivoByIdTareaFase() {
    final TareaFaseDto tareaFaseDto = new TareaFaseDto();

    this.tareaFaseServiceImpl.updateActivoByIdTareaFase(tareaFaseDto);
    verify(this.tareaFaseRepositoryCustom, times(1))
        .updateActivoByIdTareaFase(any(TareaFaseDto.class));
  }

  @Test
  public void updateFechaFinAndEstado() {
    final TareaFaseDto tareaFaseDto = new TareaFaseDto();
    final EstadoTareaFaseDto estadoTareaFaseDto = EstadoTareaFaseEnum.OK.getDto();
    this.tareaFaseServiceImpl.updateFechaFinAndEstado(tareaFaseDto, estadoTareaFaseDto);
    verify(this.tareaFaseRepositoryCustom, times(1))
        .updateFechaFinAndEstado(any(TareaFaseDto.class), any(EstadoTareaFaseDto.class));
  }

  @Test
  public void updateFechaInicioAndFechaFinAndEstado() {
    final TareaFaseDto tareaFaseDto = new TareaFaseDto();
    final EstadoTareaFaseDto estadoTareaFaseDto = EstadoTareaFaseEnum.OK.getDto();
    this.tareaFaseServiceImpl.updateFechaInicioAndFechaFinAndEstado(tareaFaseDto, estadoTareaFaseDto);
    verify(this.tareaFaseRepositoryCustom, times(1))
        .updateFechaInicioAndFechaFinAndEstado(any(TareaFaseDto.class), any(EstadoTareaFaseDto.class));
  }

}
