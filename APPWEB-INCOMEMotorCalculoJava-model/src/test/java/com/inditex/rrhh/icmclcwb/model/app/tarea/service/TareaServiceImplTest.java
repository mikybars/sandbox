package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.ms.app.tarea.SenderTarea;

@RunWith(MockitoJUnitRunner.class)
public class TareaServiceImplTest {

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

    @Test
    public void saveTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        when(tareaMapper.tareaDtoToTarea(any(TareaDto.class))).thenReturn(new Tarea());

        tareaServiceImpl.save(tarea);

        verify(tareaRepository, times(1)).save(any(Tarea.class));
    }

    @Test
    public void findTest() {
        Tarea tarea = mock(Tarea.class);
        TareaDto tareaDto = mock(TareaDto.class);
        Long idTarea = 1L;
        when(tareaRepository.findById(any(Long.class))).thenReturn(Optional.of(tarea));
        when(tareaAmbitoService.findByTarea(any(TareaDto.class))).thenReturn(new ArrayList<TareaAmbitoDto>());
        when(tareaAmbitoLocalizacionService.findByTarea(any(TareaDto.class)))
            .thenReturn(new ArrayList<TareaAmbitoLocalizacionDto>());
        when(tareaAmbitoPersonaService.findByTarea(any(TareaDto.class)))
            .thenReturn(new ArrayList<TareaAmbitoPersonaDto>());
        when(tareaMapper.tareaToTareaDto(any(Tarea.class))).thenReturn(tareaDto);

        tareaServiceImpl.find(idTarea);

        verify(tareaRepository, times(1)).findById(any(Long.class));
        verify(tareaAmbitoService, times(1)).findByTarea(any(TareaDto.class));
        verify(tareaAmbitoLocalizacionService, times(1)).findByTarea(any(TareaDto.class));
        verify(tareaAmbitoPersonaService, times(1)).findByTarea(any(TareaDto.class));
    }

    @Test
    public void createTest() {
        TareaDto tareaDto = mock(TareaDto.class);
        tareaDto.setAmbito(new ArrayList<>());
        tareaDto.getAmbito().add(new TareaAmbitoDto());
        tareaDto.setLocalizacion(new ArrayList<>());
        tareaDto.getLocalizacion().add(new TareaAmbitoLocalizacionDto());
        tareaDto.setPersona(new ArrayList<>());
        tareaDto.getPersona().add(new TareaAmbitoPersonaDto());

        when(tareaMapper.tareaDtoToTarea(any(TareaDto.class))).thenReturn(new Tarea());

        tareaServiceImpl.create(tareaDto);

        verify(tareaRepository, times(1)).save(any(Tarea.class));
    }

    @Test
    public void createTrabajoTest() {
        TrabajoDto trabajoDto = mock(TrabajoDto.class);
        trabajoDto.setEmpresa(new ArrayList<>());
        tareaServiceImpl.create(trabajoDto);
        verify(tareaMapper, times(1)).mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(trabajoDto.getEmpresa(),
                trabajoDto);
    }

    @Test
    public void findByTrabajoIdTest() {
        Long idTrabajo = 1L;
        tareaServiceImpl.findByTrabajoId(idTrabajo);
        verify(tareaRepository, times(1)).findByTrabajoId(any(Long.class));
    }

    @Test
    public void updateFechaFinTest() {
        TareaDto tarea = mock(TareaDto.class);
        tareaServiceImpl.updateFechaFin(tarea);
        verify(tareaRepositoryCustom, times(1)).updateFechaFin(any(TareaDto.class));
    }

    @Test
    public void updateFechaInicioAndEstadoTest() {
        TareaDto tarea = mock(TareaDto.class);
        EstadoTareaDto estado = mock(EstadoTareaDto.class);
        tareaServiceImpl.updateFechaInicioAndEstado(tarea, estado);
        verify(tareaRepositoryCustom, times(1)).updateFechaInicioAndEstado(any(TareaDto.class),
                any(EstadoTareaDto.class));
    }

    @Test
    public void updateEstadoTest() {
        TareaDto tarea = mock(TareaDto.class);
        EstadoTareaDto estado = mock(EstadoTareaDto.class);
        tareaServiceImpl.updateEstado(tarea, estado);
        verify(tareaRepositoryCustom, times(1)).updateEstado(any(TareaDto.class), any(EstadoTareaDto.class));
    }

    @Test
    public void updateEstadoFinalTest() {
        TareaDto tarea = mock(TareaDto.class);
        tareaServiceImpl.updateEstadoFinal(tarea);
        verify(tareaRepositoryCustom, times(1)).updateEstadoFinal(any(TareaDto.class));
    }

    @Test
    public void findLimpiezaTest() {
        tareaServiceImpl.findLimpieza();
        verify(tareaRepositoryCustom, times(1)).findLimpieza();
    }

    @Test
    public void findLimpiezaByIdTareaTest() {
        Long idTarea = 1L;
        tareaServiceImpl.findLimpiezaByIdTarea(idTarea);
        verify(tareaRepositoryCustom, times(1)).findLimpiezaByIdTarea(any(Long.class));
    }

}
