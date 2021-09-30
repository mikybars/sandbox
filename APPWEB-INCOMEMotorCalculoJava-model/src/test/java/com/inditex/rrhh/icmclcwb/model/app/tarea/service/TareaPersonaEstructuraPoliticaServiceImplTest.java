package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraPoliticaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPolitica;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraPoliticaRepositoryCustom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
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
        final TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        final List<ComisionEmpleadoResultItemDto> comisionEmpleado = new ArrayList<>();

        this.tareaPersonaEstructuraPoliticaServiceImpl.save(comisionEmpleado, tarea);
        verify(this.tareaPersonaEstructuraPoliticaRepositoryCustom, times(1)).save(ArgumentMatchers
            .<List<TareaPersonaEstructuraPolitica>>any());
    }

    @Test
    public void saveEstructurasPolResultItemDtoTest() {
        final TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        final List<EstructurasPolResultItemDto> estructurasPol = new ArrayList<>();

        this.tareaPersonaEstructuraPoliticaServiceImpl.saveEstructurasPolResultItemDto(estructurasPol, tarea);
        verify(this.tareaPersonaEstructuraPoliticaRepositoryCustom, times(1)).save(ArgumentMatchers
            .<List<TareaPersonaEstructuraPolitica>>any());
    }

}
