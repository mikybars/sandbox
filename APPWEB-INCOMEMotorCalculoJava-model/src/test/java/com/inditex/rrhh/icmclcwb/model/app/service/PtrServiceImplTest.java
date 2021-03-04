/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.ptr.repository.PtrRepositoryCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PtrServiceImplTest {

    @Mock
    private PtrRepositoryCustom ptrRepositoryCustom;

    @InjectMocks
    private PtrServiceImpl ptrServiceImpl;

    private static final String ORIGEN = "1";

    private static final long ID_TAREA = 1L;

    @Test
    public void findPresenciasOrigenAndFecha() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        runTareaDto.setTarea(tarea);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen(ORIGEN);
        this.ptrServiceImpl.findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoDto);
        verify(this.ptrRepositoryCustom, times(1))
            .findPresenciasOrigenAndFecha(any(TareaDto.class), any(TareaAmbitoDto.class));
    }

}
