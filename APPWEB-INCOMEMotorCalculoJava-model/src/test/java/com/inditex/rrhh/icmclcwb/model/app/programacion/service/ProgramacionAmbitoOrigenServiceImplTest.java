package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoOrigenMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoOrigen;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoOrigenRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ProgramacionAmbitoOrigenServiceImplTest {

    @Mock
    private ProgramacionAmbitoOrigenMapper programacionAmbitooOrigenMapper;

    @Mock
    private ProgramacionAmbitoOrigenRepository programacionAmbitooOrigenRepository;

    @InjectMocks
    private ProgramacionAmbitoOrigenServiceImpl programacionAmbitoOrigenServiceImpl;

    @Test
    public void create() {
        when(this.programacionAmbitooOrigenMapper
            .mergeProgramacionAmbitoOrigenDtoAndProgramacionDtoToProgramacionAmbitoOrigen(
                    ArgumentMatchers.<List<ProgramacionAmbitoOrigenDto>>any(), any(ProgramacionAmbitoDto.class)))
                        .thenReturn(new ArrayList<ProgramacionAmbitoOrigen>());
        when(this.programacionAmbitooOrigenRepository.saveAll(ArgumentMatchers.<List<ProgramacionAmbitoOrigen>>any()))
            .thenReturn(new ArrayList<ProgramacionAmbitoOrigen>());

        this.programacionAmbitoOrigenServiceImpl.create(Arrays.asList(new ProgramacionAmbitoOrigenDto()),
                new ProgramacionAmbitoDto());
        verify(this.programacionAmbitooOrigenRepository, times(1))
            .saveAll(ArgumentMatchers.<List<ProgramacionAmbitoOrigen>>any());
    }

    @Test
    public void findByProgramacionAmbito() {
        final ProgramacionAmbitoDto ambito = new ProgramacionAmbitoDto();
        ambito.setId(1L);
        when(this.programacionAmbitooOrigenMapper.programacionAmbitoOrigenToProgramacionAmbitoOrigenDto(
                ArgumentMatchers.<List<ProgramacionAmbitoOrigen>>any()))
                    .thenReturn(new ArrayList<ProgramacionAmbitoOrigenDto>());
        when(this.programacionAmbitooOrigenRepository.findByProgramacionAmbitoId(any(Long.class)))
            .thenReturn(new ArrayList<ProgramacionAmbitoOrigen>());

        this.programacionAmbitoOrigenServiceImpl.findByProgramacionAmbito(ambito);
        verify(this.programacionAmbitooOrigenRepository, times(1)).findByProgramacionAmbitoId(any(Long.class));

    }

}
