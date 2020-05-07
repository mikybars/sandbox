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
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoLocalizacion;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoLocalizacionRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProgramacionAmbitoLocalizacionServiceImplTest {

    @Mock
    private ProgramacionAmbitoLocalizacionMapper programacionAmbitoLocalizacionMapper;

    @Mock
    private ProgramacionAmbitoLocalizacionRepository programacionAmbitoLocalizacionRepository;

    @InjectMocks
    private ProgramacionAmbitoLocalizacionServiceImpl programacionAmbitoLocalizacionServiceImpl;

    @Test
    public void create() {
        when(programacionAmbitoLocalizacionMapper
            .mergeProgramacionAmbitoLocalizacionDtoAndProgramacionDtoToProgramacionAmbitoLocalizacion(
                    any(List.class), any(ProgramacionAmbitoDto.class)))
                        .thenReturn(new ArrayList<ProgramacionAmbitoLocalizacion>());
        when(programacionAmbitoLocalizacionRepository.saveAll(any(List.class)))
            .thenReturn(new ArrayList<ProgramacionAmbitoLocalizacion>());

        programacionAmbitoLocalizacionServiceImpl.create(Arrays.asList(new ProgramacionAmbitoLocalizacionDto()),
                new ProgramacionAmbitoDto());
        verify(programacionAmbitoLocalizacionRepository, times(1)).saveAll(any(List.class));
    }

    @Test
    public void findByProgramacionAmbito() {
        ProgramacionAmbitoDto ambito = new ProgramacionAmbitoDto();
        ambito.setId(1L);
        when(programacionAmbitoLocalizacionMapper.programacionAmbitoLocalizacionToProgramacionAmbitoLocalizacionDto(
                any(List.class))).thenReturn(new ArrayList<ProgramacionAmbitoLocalizacion>());
        when(programacionAmbitoLocalizacionRepository.findByProgramacionAmbitoId(any(Long.class)))
            .thenReturn(new ArrayList<ProgramacionAmbitoLocalizacion>());

        programacionAmbitoLocalizacionServiceImpl.findByProgramacionAmbito(ambito);
        verify(programacionAmbitoLocalizacionRepository, times(1)).findByProgramacionAmbitoId(any(Long.class));

    }

}
