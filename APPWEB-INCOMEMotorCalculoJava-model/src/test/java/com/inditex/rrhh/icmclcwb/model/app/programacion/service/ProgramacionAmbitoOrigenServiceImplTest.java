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
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoOrigenMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoOrigen;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoOrigenRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProgramacionAmbitoOrigenServiceImplTest {
    
    @Mock
    private ProgramacionAmbitoOrigenMapper programacionAmbitooOrigenMapper;
    
    @Mock
    private ProgramacionAmbitoOrigenRepository programacionAmbitooOrigenRepository;
    
    @InjectMocks
    private ProgramacionAmbitoOrigenServiceImpl programacionAmbitoOrigenServiceImpl;

    @Test
    public void create() {
        when(programacionAmbitooOrigenMapper.mergeProgramacionAmbitoOrigenDtoAndProgramacionDtoToProgramacionAmbitoOrigen(
                any(List.class), any(ProgramacionAmbitoDto.class))).thenReturn(new ArrayList<ProgramacionAmbitoOrigen>());
        when(programacionAmbitooOrigenRepository.saveAll(any(List.class))).thenReturn(new ArrayList<ProgramacionAmbitoOrigen>());

        programacionAmbitoOrigenServiceImpl.create(Arrays.asList(new ProgramacionAmbitoOrigenDto()), new ProgramacionAmbitoDto());
        verify(programacionAmbitooOrigenRepository, times(1)).saveAll(any(List.class));
    }
    
    @Test
    public void findByProgramacionAmbito() {
        ProgramacionAmbitoDto ambito = new ProgramacionAmbitoDto();
        ambito.setId(1L);
        when(programacionAmbitooOrigenMapper.programacionAmbitoOrigenToProgramacionAmbitoOrigenDto(
                any(List.class))).thenReturn(new ArrayList<ProgramacionAmbitoOrigen>());
        when(programacionAmbitooOrigenRepository.findByProgramacionAmbitoId(any(Long.class))).thenReturn(new ArrayList<ProgramacionAmbitoOrigen>());
        
        programacionAmbitoOrigenServiceImpl.findByProgramacionAmbito(ambito);
        verify(programacionAmbitooOrigenRepository, times(1)).findByProgramacionAmbitoId(any(Long.class));

    }
}
