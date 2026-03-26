package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.ms.app.tarea.SenderTarea;
import com.inditex.rrhh.icmclcwb.ms.app.tarea.TareaPriorityEnum;

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

  @Mock
  private TareaLimpiezaService tareaLimpiezaService;

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

  @Test
  void findByIdLimpiezaTest_WithValidTareaLimpieza() {
    final Long idLimpieza = 1L;
    final Long idTarea = 2L;
    final Tarea tarea = mock(Tarea.class);
    final TareaDto tareaDto = mock(TareaDto.class);
    final TareaLimpiezaDto tareaLimpiezaDto = mock(TareaLimpiezaDto.class);

    when(this.tareaLimpiezaService.find(idLimpieza)).thenReturn(tareaLimpiezaDto);
    when(tareaLimpiezaDto.getIdTarea()).thenReturn(idTarea);
    when(this.tareaRepository.findById(idTarea)).thenReturn(Optional.of(tarea));
    when(this.tareaMapper.tareaToTareaDto(tarea)).thenReturn(tareaDto);
    when(this.tareaAmbitoService.findByTarea(tareaDto)).thenReturn(new ArrayList<>());
    when(this.tareaAmbitoLocalizacionService.findByTarea(tareaDto)).thenReturn(new ArrayList<>());
    when(this.tareaAmbitoPersonaService.findByTarea(tareaDto)).thenReturn(new ArrayList<>());

    final TareaDto result = this.tareaServiceImpl.findByIdLimpieza(idLimpieza);

    assertNotNull(result);
    verify(this.tareaLimpiezaService, times(1)).find(idLimpieza);
    verify(this.tareaRepository, times(1)).findById(idTarea);
  }

  @Test
  void findByIdLimpiezaTest_WithNullTareaLimpieza() {
    final Long idLimpieza = 1L;

    when(this.tareaLimpiezaService.find(idLimpieza)).thenReturn(null);

    final TareaDto result = this.tareaServiceImpl.findByIdLimpieza(idLimpieza);

    assertNull(result);
    verify(this.tareaLimpiezaService, times(1)).find(idLimpieza);
  }

  @Test
  void createTareaWithAmbitoTest() {
    final TrabajoDTO trabajoDto = mock(TrabajoDTO.class);
    when(trabajoDto.getIdProgramacion()).thenReturn(null);
    final TareaDto tareaDto = mock(TareaDto.class);
    final TareaDto resultDto = mock(TareaDto.class);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    ambito.add(new TareaAmbitoDto());

    when(tareaDto.getAmbito()).thenReturn(ambito);
    when(tareaDto.getLocalizacion()).thenReturn(new ArrayList<>());
    when(tareaDto.getPersona()).thenReturn(new ArrayList<>());

    final Tarea tarea = mock(Tarea.class);
    when(this.tareaMapper.tareaDtoToTarea(tareaDto)).thenReturn(tarea);
    when(this.tareaRepository.save(tarea)).thenReturn(tarea);
    when(this.tareaMapper.tareaToTareaDto(tarea)).thenReturn(resultDto);
    when(this.tareaAmbitoService.create(ambito, resultDto)).thenReturn(ambito);

    this.tareaServiceImpl.create(trabajoDto, tareaDto);

    verify(this.tareaRepository, times(1)).save(tarea);
    verify(this.tareaAmbitoService, times(1)).create(ambito, resultDto);
    verify(this.senderTarea, times(1)).sendWithPriority(resultDto, TareaPriorityEnum.MANUAL);
  }

  @Test
  void createTareaWithLocalizacionTest() {
    final TrabajoDTO trabajoDto = mock(TrabajoDTO.class);
    when(trabajoDto.getIdProgramacion()).thenReturn(null);
    final TareaDto tareaDto = mock(TareaDto.class);
    final TareaDto resultDto = mock(TareaDto.class);
    final List<TareaAmbitoLocalizacionDto> localizacion = new ArrayList<>();
    localizacion.add(new TareaAmbitoLocalizacionDto());

    when(tareaDto.getAmbito()).thenReturn(new ArrayList<>());
    when(tareaDto.getLocalizacion()).thenReturn(localizacion);
    when(tareaDto.getPersona()).thenReturn(new ArrayList<>());

    final Tarea tarea = mock(Tarea.class);
    when(this.tareaMapper.tareaDtoToTarea(tareaDto)).thenReturn(tarea);
    when(this.tareaRepository.save(tarea)).thenReturn(tarea);
    when(this.tareaMapper.tareaToTareaDto(tarea)).thenReturn(resultDto);
    when(this.tareaAmbitoLocalizacionService.create(localizacion, resultDto)).thenReturn(localizacion);

    this.tareaServiceImpl.create(trabajoDto, tareaDto);

    verify(this.tareaRepository, times(1)).save(tarea);
    verify(this.tareaAmbitoLocalizacionService, times(1)).create(localizacion, resultDto);
    verify(this.senderTarea, times(1)).sendWithPriority(resultDto, TareaPriorityEnum.MANUAL);
  }

  @Test
  void createTareaWithPersonaTest() {
    final TrabajoDTO trabajoDto = mock(TrabajoDTO.class);
    when(trabajoDto.getIdProgramacion()).thenReturn(null);
    final TareaDto tareaDto = mock(TareaDto.class);
    final TareaDto resultDto = mock(TareaDto.class);
    final List<TareaAmbitoPersonaDto> persona = new ArrayList<>();
    persona.add(new TareaAmbitoPersonaDto());

    when(tareaDto.getAmbito()).thenReturn(new ArrayList<>());
    when(tareaDto.getLocalizacion()).thenReturn(new ArrayList<>());
    when(tareaDto.getPersona()).thenReturn(persona);

    final Tarea tarea = mock(Tarea.class);
    when(this.tareaMapper.tareaDtoToTarea(tareaDto)).thenReturn(tarea);
    when(this.tareaRepository.save(tarea)).thenReturn(tarea);
    when(this.tareaMapper.tareaToTareaDto(tarea)).thenReturn(resultDto);
    when(this.tareaAmbitoPersonaService.create(persona, resultDto)).thenReturn(persona);

    this.tareaServiceImpl.create(trabajoDto, tareaDto);

    verify(this.tareaRepository, times(1)).save(tarea);
    verify(this.tareaAmbitoPersonaService, times(1)).create(persona, resultDto);
    verify(this.senderTarea, times(1)).sendWithPriority(resultDto, TareaPriorityEnum.MANUAL);
  }

  @Test
  void createTareaWithProgramacionTest() {
    final TrabajoDTO trabajoDto = mock(TrabajoDTO.class);
    when(trabajoDto.getIdProgramacion()).thenReturn(1L);
    final TareaDto tareaDto = mock(TareaDto.class);
    final TareaDto resultDto = mock(TareaDto.class);

    when(tareaDto.getAmbito()).thenReturn(new ArrayList<>());
    when(tareaDto.getLocalizacion()).thenReturn(new ArrayList<>());
    when(tareaDto.getPersona()).thenReturn(new ArrayList<>());

    final Tarea tarea = mock(Tarea.class);
    when(this.tareaMapper.tareaDtoToTarea(tareaDto)).thenReturn(tarea);
    when(this.tareaRepository.save(tarea)).thenReturn(tarea);
    when(this.tareaMapper.tareaToTareaDto(tarea)).thenReturn(resultDto);

    this.tareaServiceImpl.create(trabajoDto, tareaDto);

    verify(this.tareaRepository, times(1)).save(tarea);
    verify(this.senderTarea, times(1)).sendWithPriority(resultDto, TareaPriorityEnum.PROGRAMADA);
  }

  @Test
  void createTareaManualTest() {
    final TrabajoDTO trabajoDto = mock(TrabajoDTO.class);
    when(trabajoDto.getIdProgramacion()).thenReturn(null);
    final TareaDto tareaDto = mock(TareaDto.class);
    final TareaDto resultDto = mock(TareaDto.class);

    when(tareaDto.getAmbito()).thenReturn(new ArrayList<>());
    when(tareaDto.getLocalizacion()).thenReturn(new ArrayList<>());
    when(tareaDto.getPersona()).thenReturn(new ArrayList<>());

    final Tarea tarea = mock(Tarea.class);
    when(this.tareaMapper.tareaDtoToTarea(tareaDto)).thenReturn(tarea);
    when(this.tareaRepository.save(tarea)).thenReturn(tarea);
    when(this.tareaMapper.tareaToTareaDto(tarea)).thenReturn(resultDto);

    this.tareaServiceImpl.create(trabajoDto, tareaDto);

    verify(this.tareaRepository, times(1)).save(tarea);
    verify(this.senderTarea, times(1)).sendWithPriority(resultDto, TareaPriorityEnum.MANUAL);
  }

  @Test
  void createTareaWithAllAmbitosTest() {
    final TrabajoDTO trabajoDto = mock(TrabajoDTO.class);
    when(trabajoDto.getIdProgramacion()).thenReturn(1L);
    final TareaDto tareaDto = mock(TareaDto.class);
    final TareaDto resultDto = mock(TareaDto.class);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    ambito.add(new TareaAmbitoDto());
    final List<TareaAmbitoLocalizacionDto> localizacion = new ArrayList<>();
    localizacion.add(new TareaAmbitoLocalizacionDto());
    final List<TareaAmbitoPersonaDto> persona = new ArrayList<>();
    persona.add(new TareaAmbitoPersonaDto());

    when(tareaDto.getAmbito()).thenReturn(ambito);
    when(tareaDto.getLocalizacion()).thenReturn(localizacion);
    when(tareaDto.getPersona()).thenReturn(persona);

    final Tarea tarea = mock(Tarea.class);
    when(this.tareaMapper.tareaDtoToTarea(tareaDto)).thenReturn(tarea);
    when(this.tareaRepository.save(tarea)).thenReturn(tarea);
    when(this.tareaMapper.tareaToTareaDto(tarea)).thenReturn(resultDto);
    when(this.tareaAmbitoService.create(ambito, resultDto)).thenReturn(ambito);
    when(this.tareaAmbitoLocalizacionService.create(localizacion, resultDto)).thenReturn(localizacion);
    when(this.tareaAmbitoPersonaService.create(persona, resultDto)).thenReturn(persona);

    this.tareaServiceImpl.create(trabajoDto, tareaDto);

    verify(this.tareaRepository, times(1)).save(tarea);
    verify(this.tareaAmbitoService, times(1)).create(ambito, resultDto);
    verify(this.tareaAmbitoLocalizacionService, times(1)).create(localizacion, resultDto);
    verify(this.tareaAmbitoPersonaService, times(1)).create(persona, resultDto);
    verify(this.senderTarea, times(1)).sendWithPriority(resultDto, TareaPriorityEnum.PROGRAMADA);
  }

  @Test
  void findLimpiezaTest_WithValidResults() {
    final IdTareaDTO idTarea = new IdTareaDTO();
    idTarea.setId(1L);
    final List<IdTareaDTO> tareas = List.of(idTarea);

    when(this.tareaRepositoryCustom.findLimpieza()).thenReturn(tareas);
    when(this.tareaRepositoryCustom.totalLimpieza()).thenReturn(5);

    final var result = this.tareaServiceImpl.findLimpieza();

    assertNotNull(result);
    assertEquals(1, result.getIdTarea().size());
    assertEquals(1, result.getTareasProcesadas());
    assertEquals(5, result.getTareasPendientes());
    verify(this.tareaRepositoryCustom, times(1)).findLimpieza();
    verify(this.tareaRepositoryCustom, times(1)).totalLimpieza();
  }

  @Test
  void findLimpiezaByIdTareaTest_WithValidResults() {
    final Long idTarea = 1L;
    final IdTareaDTO idTareaDTO = new IdTareaDTO();
    idTareaDTO.setId(idTarea);
    final List<IdTareaDTO> tareas = List.of(idTareaDTO);

    when(this.tareaRepositoryCustom.findLimpiezaByIdTarea(idTarea)).thenReturn(tareas);
    when(this.tareaRepositoryCustom.totalLimpieza()).thenReturn(3);

    final var result = this.tareaServiceImpl.findLimpiezaByIdTarea(idTarea);

    assertNotNull(result);
    assertEquals(1, result.getIdTarea().size());
    assertEquals(1, result.getTareasProcesadas());
    assertEquals(3, result.getTareasPendientes());
    verify(this.tareaRepositoryCustom, times(1)).findLimpiezaByIdTarea(idTarea);
    verify(this.tareaRepositoryCustom, times(1)).totalLimpieza();
  }

  @Test
  void findLimpiezaTest_WithEmptyResults() {
    when(this.tareaRepositoryCustom.findLimpieza()).thenReturn(new ArrayList<>());

    final var result = this.tareaServiceImpl.findLimpieza();

    assertNotNull(result);
    assertEquals(0, result.getIdTarea().size());
    assertEquals(0, result.getTareasProcesadas());
    assertEquals(0, result.getTareasPendientes());
    verify(this.tareaRepositoryCustom, times(1)).findLimpieza();
    verify(this.tareaRepositoryCustom, never()).totalLimpieza();
  }

  @Test
  void findLimpiezaByIdTareaTest_WithEmptyResults() {
    final Long idTarea = 1L;
    when(this.tareaRepositoryCustom.findLimpiezaByIdTarea(idTarea)).thenReturn(new ArrayList<>());

    final var result = this.tareaServiceImpl.findLimpiezaByIdTarea(idTarea);

    assertNotNull(result);
    assertEquals(0, result.getIdTarea().size());
    assertEquals(0, result.getTareasProcesadas());
    assertEquals(0, result.getTareasPendientes());
    verify(this.tareaRepositoryCustom, times(1)).findLimpiezaByIdTarea(idTarea);
    verify(this.tareaRepositoryCustom, never()).totalLimpieza();
  }

  @Test
  void findLimpieza_whenEmpty_thenTotalIsZeroAndTotalLimpiezaNotCalled() {
    when(this.tareaRepositoryCustom.findLimpieza()).thenReturn(new ArrayList<>());

    final var result = this.tareaServiceImpl.findLimpieza();

    assertNotNull(result);
    assertEquals(0, result.getTareasProcesadas());
    assertEquals(0, result.getTareasPendientes());
    assertNotNull(result.getIdTarea());
    assertEquals(0, result.getIdTarea().size());
    verify(this.tareaRepositoryCustom, times(1)).findLimpieza();
    verify(this.tareaRepositoryCustom, never()).totalLimpieza();
  }

  @Test
  void findLimpieza_whenNotEmpty_thenCallsTotalLimpieza() {
    final IdTareaDTO id = new IdTareaDTO();
    id.setId(1L);
    when(this.tareaRepositoryCustom.findLimpieza()).thenReturn(List.of(id));
    when(this.tareaRepositoryCustom.totalLimpieza()).thenReturn(7);

    final var result = this.tareaServiceImpl.findLimpieza();

    assertNotNull(result);
    assertEquals(1, result.getTareasProcesadas());
    assertEquals(7, result.getTareasPendientes());
    assertEquals(1, result.getIdTarea().size());
    verify(this.tareaRepositoryCustom, times(1)).findLimpieza();
    verify(this.tareaRepositoryCustom, times(1)).totalLimpieza();
  }

  @Test
  void findLimpiezaByIdTarea_whenEmpty_thenTotalIsZeroAndTotalLimpiezaNotCalled() {
    final Long idTarea = 123L;
    when(this.tareaRepositoryCustom.findLimpiezaByIdTarea(idTarea)).thenReturn(new ArrayList<>());

    final var result = this.tareaServiceImpl.findLimpiezaByIdTarea(idTarea);

    assertNotNull(result);
    assertEquals(0, result.getTareasProcesadas());
    assertEquals(0, result.getTareasPendientes());
    assertNotNull(result.getIdTarea());
    assertEquals(0, result.getIdTarea().size());
    verify(this.tareaRepositoryCustom, times(1)).findLimpiezaByIdTarea(idTarea);
    verify(this.tareaRepositoryCustom, never()).totalLimpieza();
  }

  @Test
  void findLimpiezaByIdTarea_whenNotEmpty_thenCallsTotalLimpieza() {
    final Long idTarea = 123L;
    final IdTareaDTO id = new IdTareaDTO();
    id.setId(2L);

    when(this.tareaRepositoryCustom.findLimpiezaByIdTarea(idTarea)).thenReturn(List.of(id));
    when(this.tareaRepositoryCustom.totalLimpieza()).thenReturn(9);

    final var result = this.tareaServiceImpl.findLimpiezaByIdTarea(idTarea);

    assertNotNull(result);
    assertEquals(1, result.getTareasProcesadas());
    assertEquals(9, result.getTareasPendientes());
    assertEquals(1, result.getIdTarea().size());
    verify(this.tareaRepositoryCustom, times(1)).findLimpiezaByIdTarea(idTarea);
    verify(this.tareaRepositoryCustom, times(1)).totalLimpieza();
  }
}
