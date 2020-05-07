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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaCoeficienteMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaCoeficienteRepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class TareaPersonaCoeficienteServiceImplTest {

    @Mock
    private TareaPersonaCoeficienteRepositoryCustom tareaPersonaCoeficienteRepositoryCustom;

    @InjectMocks
    private TareaPersonaCoeficienteServiceImpl tareaPersonaCoeficienteServiceImpl;

    @Mock
    private TareaPersonaCoeficienteMapper tareaPersonaCoeficienteMapper;

    @Mock
    private TrabajoServiceImpl trabajoServiceImpl;

    @Test
    public void saveTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        List<GenericEmpleadoResultItemDto> empleados = new ArrayList<>();

        tareaPersonaCoeficienteServiceImpl.save(empleados, tarea);
        verify(tareaPersonaCoeficienteRepositoryCustom, times(1)).save(any(List.class));
    }

}
