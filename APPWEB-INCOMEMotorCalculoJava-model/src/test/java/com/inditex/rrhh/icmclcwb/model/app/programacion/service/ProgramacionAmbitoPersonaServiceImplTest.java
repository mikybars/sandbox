package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoPersona;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoPersonaRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProgramacionAmbitoPersonaServiceImplTest {
    
    @Mock
    private ProgramacionAmbitoPersonaMapper programacionAmbitoPersonaMapper;
    
    @Mock
    private ProgramacionAmbitoPersonaRepository programacionAmbitoPersonaRepository;
    
    @InjectMocks
    private ProgramacionAmbitoPersonaServiceImpl programacionAmbitoPersonaServiceImpl;
    
    @Test
    public void create() {
        when(programacionAmbitoPersonaMapper.mergeProgramacionAmbitoPersonaDtoAndProgramacionDtoToProgramacionAmbitoPersona(
                any(List.class), any(ProgramacionAmbitoDto.class))).thenReturn(new ArrayList<ProgramacionAmbitoPersona>());
        when(programacionAmbitoPersonaRepository.saveAll(any(List.class))).thenReturn(new ArrayList<ProgramacionAmbitoPersona>());

        programacionAmbitoPersonaServiceImpl.create(Arrays.asList(new ProgramacionAmbitoPersonaDto()), new ProgramacionAmbitoDto());
        verify(programacionAmbitoPersonaRepository, times(1)).saveAll(any(List.class));
    }
    
    @Test
    public void findByProgramacionAmbito() {
        ProgramacionAmbitoDto ambito = new ProgramacionAmbitoDto();
        ambito.setId(1L);
        when(programacionAmbitoPersonaMapper.programacionAmbitoPersonaToProgramacionAmbitoPersonaDto(
                any(List.class))).thenReturn(new ArrayList<ProgramacionAmbitoPersona>());
        when(programacionAmbitoPersonaRepository.findByProgramacionAmbitoId(any(Long.class))).thenReturn(new ArrayList<ProgramacionAmbitoPersona>());
        
        programacionAmbitoPersonaServiceImpl.findByProgramacionAmbito(ambito);
        verify(programacionAmbitoPersonaRepository, times(1)).findByProgramacionAmbitoId(any(Long.class));

    }
}
