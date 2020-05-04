package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraPoliticaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraPoliticaRepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class TareaPersonaEstructuraPoliticaServiceImplTest {

    @Mock
    private TareaPersonaEstructuraPoliticaRepositoryCustom tareaPersonaEstructuraPoliticaRepositoryCustom;

    @InjectMocks
    private TareaPersonaEstructuraPoliticaServiceImpl tareaPersonaEstructuraPoliticaServiceImpl;

    @Mock
    private TareaPersonaEstructuraPoliticaMapper tareaPersonaEstructuraPoliticaMapper;

    @Mock
    private TrabajoServiceImpl trabajoServiceImpl;

    @Test
    public void saveTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        List<ComisionEmpleadoResultItemDto> comisionEmpleado = new ArrayList<>();

        tareaPersonaEstructuraPoliticaServiceImpl.save(comisionEmpleado, tarea);
        verify(tareaPersonaEstructuraPoliticaRepositoryCustom, times(1)).save(any(List.class));
    }

    @Test
    public void saveEstructurasPolResultItemDtoTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        List<EstructurasPolResultItemDto> estructurasPol = new ArrayList<>();

        tareaPersonaEstructuraPoliticaServiceImpl.saveEstructurasPolResultItemDto(estructurasPol, tarea);
        verify(tareaPersonaEstructuraPoliticaRepositoryCustom, times(1)).save(any(List.class));
    }

}
