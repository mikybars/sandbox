package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoLocalizacion;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoLocalizacionRepository;
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
public class ProgramacionAmbitoLocalizacionServiceImplTest {

    @Mock
    private ProgramacionAmbitoLocalizacionMapper programacionAmbitoLocalizacionMapper;

    @Mock
    private ProgramacionAmbitoLocalizacionRepository programacionAmbitoLocalizacionRepository;

    @InjectMocks
    private ProgramacionAmbitoLocalizacionServiceImpl programacionAmbitoLocalizacionServiceImpl;

    @Test
    public void create() {
        when(this.programacionAmbitoLocalizacionMapper
            .mergeProgramacionAmbitoLocalizacionDtoAndProgramacionDtoToProgramacionAmbitoLocalizacion(
                    ArgumentMatchers.<List<ProgramacionAmbitoLocalizacionDto>>any(), any(ProgramacionAmbitoDto.class)))
                        .thenReturn(new ArrayList<ProgramacionAmbitoLocalizacion>());
        when(this.programacionAmbitoLocalizacionRepository
            .saveAll(ArgumentMatchers.<List<ProgramacionAmbitoLocalizacion>>any()))
                .thenReturn(new ArrayList<ProgramacionAmbitoLocalizacion>());

        this.programacionAmbitoLocalizacionServiceImpl.create(Arrays.asList(new ProgramacionAmbitoLocalizacionDto()),
                new ProgramacionAmbitoDto());
        verify(this.programacionAmbitoLocalizacionRepository, times(1))
            .saveAll(ArgumentMatchers.<List<ProgramacionAmbitoLocalizacion>>any());
    }

    @Test
    public void findByProgramacionAmbito() {
        final ProgramacionAmbitoDto ambito = new ProgramacionAmbitoDto();
        ambito.setId(1L);
        when(this.programacionAmbitoLocalizacionMapper
            .programacionAmbitoLocalizacionToProgramacionAmbitoLocalizacionDto(
                    ArgumentMatchers.<List<ProgramacionAmbitoLocalizacion>>any()))
                        .thenReturn(new ArrayList<ProgramacionAmbitoLocalizacionDto>());
        when(this.programacionAmbitoLocalizacionRepository.findByProgramacionAmbitoId(any(Long.class)))
            .thenReturn(new ArrayList<ProgramacionAmbitoLocalizacion>());

        this.programacionAmbitoLocalizacionServiceImpl.findByProgramacionAmbito(ambito);
        verify(this.programacionAmbitoLocalizacionRepository, times(1)).findByProgramacionAmbitoId(any(Long.class));

    }

}
