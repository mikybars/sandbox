package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoPersona;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoPersonaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        when(this.programacionAmbitoPersonaMapper
            .mergeProgramacionAmbitoPersonaDtoAndProgramacionDtoToProgramacionAmbitoPersona(
                    ArgumentMatchers.<List<ProgramacionAmbitoPersonaDto>>any(), any(ProgramacionAmbitoDto.class)))
                        .thenReturn(new ArrayList<ProgramacionAmbitoPersona>());
        when(this.programacionAmbitoPersonaRepository.saveAll(ArgumentMatchers.<List<ProgramacionAmbitoPersona>>any()))
            .thenReturn(new ArrayList<ProgramacionAmbitoPersona>());

        this.programacionAmbitoPersonaServiceImpl.create(Arrays.asList(new ProgramacionAmbitoPersonaDto()),
                new ProgramacionAmbitoDto());
        verify(this.programacionAmbitoPersonaRepository, times(1))
            .saveAll(ArgumentMatchers.<List<ProgramacionAmbitoPersona>>any());
    }

    @Test
    public void findByProgramacionAmbito() {
        final ProgramacionAmbitoDto ambito = new ProgramacionAmbitoDto();
        ambito.setId(1L);
        when(this.programacionAmbitoPersonaMapper.programacionAmbitoPersonaToProgramacionAmbitoPersonaDto(
                ArgumentMatchers.<List<ProgramacionAmbitoPersona>>any()))
                    .thenReturn(new ArrayList<ProgramacionAmbitoPersonaDto>());
        when(this.programacionAmbitoPersonaRepository.findByProgramacionAmbitoId(any(Long.class)))
            .thenReturn(new ArrayList<ProgramacionAmbitoPersona>());

        this.programacionAmbitoPersonaServiceImpl.findByProgramacionAmbito(ambito);
        verify(this.programacionAmbitoPersonaRepository, times(1)).findByProgramacionAmbitoId(any(Long.class));

    }

}
