package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoEmpresa;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoEmpresaRepository;
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
public class ProgramacionAmbitoEmpresaServiceImplTest {

    @Mock
    private ProgramacionAmbitoEmpresaMapper programacionAmbitoEmpresaMapper;

    @Mock
    private ProgramacionAmbitoEmpresaRepository programacionAmbitoEmpresaRepository;

    @InjectMocks
    private ProgramacionAmbitoEmpresaServiceImpl programacionAmbitoEmpresaServiceImpl;

    @Test
    public void create() {
        when(this.programacionAmbitoEmpresaMapper
            .mergeProgramacionAmbitoEmpresaDtoAndProgramacionDtoToProgramacionAmbitoEmpresa(
                    ArgumentMatchers.<List<ProgramacionAmbitoEmpresaDto>>any(), any(ProgramacionAmbitoDto.class)))
                        .thenReturn(new ArrayList<ProgramacionAmbitoEmpresa>());
        when(this.programacionAmbitoEmpresaRepository.saveAll(ArgumentMatchers.<List<ProgramacionAmbitoEmpresa>>any()))
            .thenReturn(new ArrayList<ProgramacionAmbitoEmpresa>());

        this.programacionAmbitoEmpresaServiceImpl.create(Arrays.asList(new ProgramacionAmbitoEmpresaDto()),
                new ProgramacionAmbitoDto());
        verify(this.programacionAmbitoEmpresaRepository, times(1))
            .saveAll(ArgumentMatchers.<List<ProgramacionAmbitoEmpresa>>any());
    }


    @Test
    public void findByProgramacionAmbito() {
        final ProgramacionAmbitoDto ambito = new ProgramacionAmbitoDto();
        ambito.setId(1L);
        when(this.programacionAmbitoEmpresaMapper.programacionAmbitoEmpresaToProgramacionAmbitoEmpresaDto(
                ArgumentMatchers.<List<ProgramacionAmbitoEmpresa>>any()))
                    .thenReturn(new ArrayList<ProgramacionAmbitoEmpresaDto>());
        when(this.programacionAmbitoEmpresaRepository.findByProgramacionAmbitoId(any(Long.class)))
            .thenReturn(new ArrayList<ProgramacionAmbitoEmpresa>());

        this.programacionAmbitoEmpresaServiceImpl.findByProgramacionAmbito(ambito);
        verify(this.programacionAmbitoEmpresaRepository, times(1)).findByProgramacionAmbitoId(any(Long.class));

    }

}
