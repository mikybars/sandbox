/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionValidacionDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confprevalid.ConfPreValidResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPrevalidacionValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPrevalidacionValidacion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPrevalidacionValidacionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPrevalidacionValidacionRepositoryCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TareaPrevalidacionValidacionServiceImplTest {

    @Mock
    private TareaPrevalidacionValidacionRepositoryCustom tareaPrevalidacionValidacionRepositoryCustom;

    @Mock
    private TareaPrevalidacionValidacionRepository tareaPrevalidacionValidacionRepository;

    @InjectMocks
    private TareaPrevalidacionValidacionServiceImpl tareaPrevalidacionValidacionServiceImpl;

    @Mock
    private TareaPrevalidacionValidacionMapper tareaPrevalidacionValidacionMapper;

    @Test
    public void saveTest() {
        final TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        final TareaPrevalidacionValidacionDto prevalidacion = new TareaPrevalidacionValidacionDto();

        this.tareaPrevalidacionValidacionServiceImpl.save(prevalidacion, tarea);
        verify(this.tareaPrevalidacionValidacionMapper, times(1))
            .tareaPrevalidacionValidacionDtotoTareaPrevalidacionValidacion(
                    ArgumentMatchers.<TareaPrevalidacionValidacionDto>any(), any(TareaDto.class));
        verify(this.tareaPrevalidacionValidacionRepository, times(1)).save(ArgumentMatchers
            .<TareaPrevalidacionValidacion>any());
    }

    @Test
    public void saveConfPreValidResultItemDtoTest() {
        final TareaDto tarea = mock(TareaDto.class);
        final TareaPrevalidacionDto tareaPrevalidacion = mock(TareaPrevalidacionDto.class);
        tarea.setIdTrabajo(1L);
        final List<ConfPreValidResultItemDto> confPreValidDto = new ArrayList<>();

        this.tareaPrevalidacionValidacionServiceImpl.saveConfPreValidResultItemDto(confPreValidDto, tareaPrevalidacion);
        verify(this.tareaPrevalidacionValidacionMapper, times(1))
            .confPreValidResultItemDtotoTareaPrevalidacionValidacionDto(
                    ArgumentMatchers.<List<ConfPreValidResultItemDto>>any(), any(TareaPrevalidacionDto.class));
        verify(this.tareaPrevalidacionValidacionRepositoryCustom, times(1)).save(ArgumentMatchers
            .<List<TareaPrevalidacionValidacion>>any());
    }

    @Test
    public void findByIdTareaAndIdTareaPrevalidacionAndTipoValidacionTest() {
        final Integer idTipoValidacion = 1;
        final Integer idTareaPrevalidacion = 1;
        final Long idTarea = 1L;

        this.tareaPrevalidacionValidacionServiceImpl.findByIdTareaAndIdTareaPrevalidacionAndTipoValidacion(idTarea,
                idTareaPrevalidacion, idTipoValidacion);
        verify(this.tareaPrevalidacionValidacionRepositoryCustom, times(1))
            .findByIdTareaAndIdTareaPrevalidacionAndTipoValidacion(any(Long.class), any(Integer.class),
                    any(Integer.class));
    }

    @Test
    public void updateTest() {
        final TareaDto tarea = mock(TareaDto.class);
        final TareaPrevalidacionValidacionDto tareaPrevalidacionValidacionDto = mock(
                TareaPrevalidacionValidacionDto.class);
        tarea.setIdTrabajo(1L);

        this.tareaPrevalidacionValidacionServiceImpl.update(tareaPrevalidacionValidacionDto, tarea, 1);
        verify(this.tareaPrevalidacionValidacionRepositoryCustom, times(1)).update(ArgumentMatchers
            .<Integer>any(),
                ArgumentMatchers
                    .<Integer>any(),
                ArgumentMatchers
                    .<Integer>any(),
                ArgumentMatchers
                    .<Long>any());
    }

}
