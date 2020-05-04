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
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoEmpresa;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoEmpresaRepository;

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
        when(programacionAmbitoEmpresaMapper
            .mergeProgramacionAmbitoEmpresaDtoAndProgramacionDtoToProgramacionAmbitoEmpresa(
                    any(List.class), any(ProgramacionAmbitoDto.class)))
                        .thenReturn(new ArrayList<ProgramacionAmbitoEmpresa>());
        when(programacionAmbitoEmpresaRepository.saveAll(any(List.class)))
            .thenReturn(new ArrayList<ProgramacionAmbitoEmpresa>());

        programacionAmbitoEmpresaServiceImpl.create(Arrays.asList(new ProgramacionAmbitoEmpresaDto()),
                new ProgramacionAmbitoDto());
        verify(programacionAmbitoEmpresaRepository, times(1)).saveAll(any(List.class));
    }


    @Test
    public void findByProgramacionAmbito() {
        ProgramacionAmbitoDto ambito = new ProgramacionAmbitoDto();
        ambito.setId(1L);
        when(programacionAmbitoEmpresaMapper.programacionAmbitoEmpresaToProgramacionAmbitoEmpresaDto(
                any(List.class))).thenReturn(new ArrayList<ProgramacionAmbitoEmpresa>());
        when(programacionAmbitoEmpresaRepository.findByProgramacionAmbitoId(any(Long.class)))
            .thenReturn(new ArrayList<ProgramacionAmbitoEmpresa>());

        programacionAmbitoEmpresaServiceImpl.findByProgramacionAmbito(ambito);
        verify(programacionAmbitoEmpresaRepository, times(1)).findByProgramacionAmbitoId(any(Long.class));

    }

}
