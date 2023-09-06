package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.ms.app.tarea.SenderTarea;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TareaServiceImplTest {

  @Mock
  private TareaRepositoryCustom tareaRepositoryCustom;

  @Mock
  private TareaRepository tareaRepository;

  @InjectMocks
  private TareaServiceImpl tareaServiceImpl;

  @Mock
  private TareaMapper tareaMapper;

  @Mock
  private TrabajoServiceImpl trabajoServiceImpl;

  @Mock
  private TareaAmbitoPersonaService tareaAmbitoPersonaService;

  @Mock
  private TareaAmbitoLocalizacionService tareaAmbitoLocalizacionService;

  @Mock
  private TareaAmbitoService tareaAmbitoService;

  @Mock
  private SenderTarea senderTarea;

  @Mock
  private TareaFaseService tareaFaseService;

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Test
  void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    when(this.tareaMapper.tareaDtoToTarea(any(TareaDto.class))).thenReturn(new Tarea());

    this.tareaServiceImpl.save(tarea);

    verify(this.tareaRepository, times(1)).save(any(Tarea.class));
  }

  @Test
  void findTest() {
    final Tarea tarea = mock(Tarea.class);
    final TareaDto tareaDto = mock(TareaDto.class);
    final Long idTarea = 1L;
    when(this.tareaRepository.findById(any(Long.class))).thenReturn(Optional.of(tarea));
    when(this.tareaAmbitoService.findByTarea(any(TareaDto.class))).thenReturn(new ArrayList<TareaAmbitoDto>());
    when(this.tareaAmbitoLocalizacionService.findByTarea(any(TareaDto.class)))
        .thenReturn(new ArrayList<TareaAmbitoLocalizacionDto>());
    when(this.tareaAmbitoPersonaService.findByTarea(any(TareaDto.class)))
        .thenReturn(new ArrayList<TareaAmbitoPersonaDto>());
    when(this.tareaMapper.tareaToTareaDto(any(Tarea.class))).thenReturn(tareaDto);

    this.tareaServiceImpl.find(idTarea);

    verify(this.tareaRepository, times(1)).findById(any(Long.class));
    verify(this.tareaAmbitoService, times(1)).findByTarea(any(TareaDto.class));
    verify(this.tareaAmbitoLocalizacionService, times(1)).findByTarea(any(TareaDto.class));
    verify(this.tareaAmbitoPersonaService, times(1)).findByTarea(any(TareaDto.class));
  }

  @Test
  void findByIdWithStatesTest() {
    final Tarea tarea = mock(Tarea.class);
    final TareaDto tareaDto = mock(TareaDto.class);
    final Long idTarea = 1L;

    when(this.tareaRepository.findByIdAndEstadoIdIn(idTarea, AppConstants.ESTADOS_RUN_TAREA_OK)).thenReturn(tarea);
    when(this.tareaAmbitoService.findByTarea(tareaDto)).thenReturn(new ArrayList<>());
    when(this.tareaAmbitoLocalizacionService.findByTarea(tareaDto))
        .thenReturn(new ArrayList<>());
    when(this.tareaAmbitoPersonaService.findByTarea(tareaDto))
        .thenReturn(new ArrayList<>());
    when(this.tareaMapper.tareaToTareaDto(tarea)).thenReturn(tareaDto);

    assertDoesNotThrow(() -> this.tareaServiceImpl.findByIdWithStates(idTarea));

    verify(this.tareaMapper, times(1)).tareaToTareaDto(tarea);
    verify(this.tareaRepository, times(1)).findByIdAndEstadoIdIn(idTarea, AppConstants.ESTADOS_RUN_TAREA_OK);
    verify(this.tareaAmbitoService, times(1)).findByTarea(tareaDto);
    verify(this.tareaAmbitoLocalizacionService, times(1)).findByTarea(tareaDto);
    verify(this.tareaAmbitoPersonaService, times(1)).findByTarea(tareaDto);
  }

  @Test
  void findByIdWithStatesTest2() {
    final Long idTarea = 1L;
    when(this.tareaRepository.findByIdAndEstadoIdIn(idTarea, AppConstants.ESTADOS_RUN_TAREA_OK)).thenReturn(null);

    assertNull(this.tareaServiceImpl.findByIdWithStates(idTarea));
  }

  @Test
  void createTareaAndTrabajoTest() {
    final TrabajoDTO trabajoDto = mock(TrabajoDTO.class);
    trabajoDto.setEmpresa(new ArrayList<>());
    final TareaDto tareaDto = mock(TareaDto.class);
    tareaDto.setAmbito(new ArrayList<>());
    tareaDto.getAmbito().add(new TareaAmbitoDto());
    tareaDto.setLocalizacion(new ArrayList<>());
    tareaDto.getLocalizacion().add(new TareaAmbitoLocalizacionDto());
    tareaDto.setPersona(new ArrayList<>());
    tareaDto.getPersona().add(new TareaAmbitoPersonaDto());

    when(this.tareaMapper.tareaDtoToTarea(any(TareaDto.class))).thenReturn(new Tarea());

    this.tareaServiceImpl.create(trabajoDto, tareaDto);

    verify(this.tareaRepository, times(1)).save(any(Tarea.class));
  }

  @Test
  void createTrabajoTest() {
    final TrabajoDTO trabajoDto = mock(TrabajoDTO.class);
    trabajoDto.setEmpresa(new ArrayList<>());
    this.tareaServiceImpl.create(trabajoDto);
    verify(this.tareaMapper, times(1)).mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(trabajoDto.getEmpresa(),
        trabajoDto);
  }

  @Test
  void findByTrabajoIdTest() {
    final Long idTrabajo = 1L;
    this.tareaServiceImpl.findByTrabajoId(idTrabajo);
    verify(this.tareaRepository, times(1)).findByTrabajoId(any(Long.class));
  }

  @Test
  void updateFechaFinTest() {
    final TareaDto tarea = mock(TareaDto.class);
    this.tareaServiceImpl.updateFechaFin(tarea);
    verify(this.tareaRepositoryCustom, times(1)).updateFechaFin(any(TareaDto.class));
  }

  @Test
  void updateFechaInicioAndEstadoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final EstadoTareaDto estado = mock(EstadoTareaDto.class);
    this.tareaServiceImpl.updateFechaInicioAndEstado(tarea, estado);
    verify(this.tareaRepositoryCustom, times(1)).updateFechaInicioAndEstado(any(TareaDto.class),
        any(EstadoTareaDto.class));
  }

  @Test
  void updateEstadoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final EstadoTareaDto estado = mock(EstadoTareaDto.class);
    this.tareaServiceImpl.updateEstado(tarea, estado);
    verify(this.tareaRepositoryCustom, times(1)).updateEstado(any(TareaDto.class), any(EstadoTareaDto.class));
  }

  @Test
  void updateEstadoFinalTest() {
    final TareaDto tarea = mock(TareaDto.class);
    this.tareaServiceImpl.updateEstadoFinal(tarea);
    verify(this.tareaRepositoryCustom, times(1)).updateEstadoFinal(any(TareaDto.class));
  }

  @Test
  void findLimpiezaTest() {
    this.tareaServiceImpl.findLimpieza();
    verify(this.tareaRepositoryCustom, times(1)).findLimpieza();
  }

  @Test
  void findLimpiezaByIdTareaTest() {
    final Long idTarea = 1L;
    this.tareaServiceImpl.findLimpiezaByIdTarea(idTarea);
    verify(this.tareaRepositoryCustom, times(1)).findLimpiezaByIdTarea(any(Long.class));
  }

}
