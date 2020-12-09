/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.AccionValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPrevalidacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPrevalidacion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPrevalidacionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPrevalidacionRepositoryCustom;
import com.inditex.rrhh.icmclcwb.ms.app.tarea.SenderTarea;
import com.inditex.rrhh.icmclcwb.ms.app.tareaprevalidar.SenderTareaPreValidar;
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
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TareaPrevalidacionServiceImplTest {

    @Mock
    private TareaPrevalidacionRepositoryCustom tareaPrevalidacionRepositoryCustom;

    @Mock
    private TareaPrevalidacionRepository tareaPrevalidacionRepository;

    @Mock
    private SenderTareaPreValidar senderTareaPreValidar;

    @Mock
    private SenderTarea senderTarea;

    @Mock
    private TareaService tareaService;

    @InjectMocks
    private TareaPrevalidacionServiceImpl tareaPrevalidacionServiceImpl;

    @Mock
    private TareaPrevalidacionMapper tareaPrevalidacionMapper;

    @Test
    public void saveTest() {
        final TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        final TareaPrevalidacionDto prevalidacion = new TareaPrevalidacionDto();

        this.tareaPrevalidacionServiceImpl.save(prevalidacion, tarea);
        verify(this.tareaPrevalidacionMapper, times(1))
            .tareaPrevalidacionDtotoTareaPrevalidacion(
                    ArgumentMatchers.<TareaPrevalidacionDto>any(), any(TareaDto.class));
        verify(this.tareaPrevalidacionRepository, times(1)).save(ArgumentMatchers
            .<TareaPrevalidacion>any());
    }

    @Test
    public void createTest() {
        final TareaDto tarea = mock(TareaDto.class);

        when(this.tareaPrevalidacionRepositoryCustom.findMaxReintento(any(Long.class)))
            .thenReturn(new TareaPrevalidacionDto());

        this.tareaPrevalidacionServiceImpl.create(tarea);

        verify(this.tareaPrevalidacionRepositoryCustom, times(1))
            .findMaxReintento(
                    ArgumentMatchers.<Long>any());
        verify(this.tareaPrevalidacionMapper, times(1))
            .tareaPrevalidacionDtotoTareaPrevalidacion(
                    ArgumentMatchers.<TareaPrevalidacionDto>any(), any(TareaDto.class));
        verify(this.tareaPrevalidacionRepository, times(1)).save(ArgumentMatchers
            .<TareaPrevalidacion>any());
    }

    @Test
    public void updateFechaFinTest() {
        final TareaDto tarea = mock(TareaDto.class);
        final TareaPrevalidacionDto tareaPrevalidacionDto = mock(
                TareaPrevalidacionDto.class);
        tarea.setIdTrabajo(1L);

        this.tareaPrevalidacionServiceImpl.updateFechaFin(tareaPrevalidacionDto);
        verify(this.tareaPrevalidacionRepositoryCustom, times(1)).updateFechaFin(ArgumentMatchers
            .<TareaPrevalidacionDto>any());
    }

    @Test
    public void updateEstadoTest() {
        final TareaDto tarea = mock(TareaDto.class);
        final TareaPrevalidacionDto tareaPrevalidacionDto = mock(
                TareaPrevalidacionDto.class);
        final EstadoTareaPrevalidacionDto estadoTareaPrevalidacionDto = mock(
                EstadoTareaPrevalidacionDto.class);
        tarea.setIdTrabajo(1L);

        this.tareaPrevalidacionServiceImpl.updateEstado(tareaPrevalidacionDto, estadoTareaPrevalidacionDto);
        verify(this.tareaPrevalidacionRepositoryCustom, times(1)).updateEstado(ArgumentMatchers
            .<TareaPrevalidacionDto>any(),
                ArgumentMatchers
                    .<EstadoTareaPrevalidacionDto>any());
    }

    @Test
    public void checkMaxReintentosTest() {
        final TareaDto tarea = mock(TareaDto.class);
        final TareaPrevalidacionDto tareaPrevalidacionDto = mock(
                TareaPrevalidacionDto.class);
        tarea.setIdTrabajo(1L);

        this.tareaPrevalidacionServiceImpl.checkMaxReintentos(tareaPrevalidacionDto);
        verify(this.tareaPrevalidacionRepositoryCustom, times(1)).checkMaxReintentos(ArgumentMatchers
            .<TareaPrevalidacionDto>any());
    }

    @Test
    public void sendAccion3Test() {
        final TareaPrevalidacionDto tareaPrevalidacionDto = mock(
                TareaPrevalidacionDto.class);
        when(this.tareaPrevalidacionServiceImpl.checkMaxReintentos(any(TareaPrevalidacionDto.class)))
            .thenReturn(Boolean.FALSE);
        when(this.tareaPrevalidacionRepositoryCustom.findAccionValidacion(any(Long.class), any(Integer.class)))
            .thenReturn(AccionValidacionDto.builder().id(3).delayTime(10000L).build());
        when(this.tareaService.find(any(Long.class)))
            .thenReturn(new TareaDto());

        this.tareaPrevalidacionServiceImpl.send(tareaPrevalidacionDto);

        verify(this.tareaPrevalidacionRepositoryCustom, times(1))
            .findAccionValidacion(
                    ArgumentMatchers.<Long>any(),
                    ArgumentMatchers.<Integer>any());
        verify(this.tareaService, times(1))
            .find(
                    ArgumentMatchers.<Long>any());
    }

    @Test
    public void sendAccion4Test() {
        final TareaPrevalidacionDto tareaPrevalidacionDto = mock(
                TareaPrevalidacionDto.class);
        when(this.tareaPrevalidacionServiceImpl.checkMaxReintentos(any(TareaPrevalidacionDto.class)))
            .thenReturn(Boolean.FALSE);
        when(this.tareaPrevalidacionRepositoryCustom.findAccionValidacion(any(Long.class), any(Integer.class)))
            .thenReturn(AccionValidacionDto.builder().id(4).delayTime(10000L).build());
        when(this.tareaService.find(any(Long.class)))
            .thenReturn(new TareaDto());

        this.tareaPrevalidacionServiceImpl.send(tareaPrevalidacionDto);

        verify(this.tareaPrevalidacionRepositoryCustom, times(1))
            .findAccionValidacion(
                    ArgumentMatchers.<Long>any(),
                    ArgumentMatchers.<Integer>any());
        verify(this.tareaService, times(1))
            .find(
                    ArgumentMatchers.<Long>any());
    }

    @Test
    public void sendAccionNullTest() {
        final TareaPrevalidacionDto tareaPrevalidacionDto = mock(
                TareaPrevalidacionDto.class);
        when(this.tareaPrevalidacionServiceImpl.checkMaxReintentos(any(TareaPrevalidacionDto.class)))
            .thenReturn(Boolean.FALSE);
        when(this.tareaPrevalidacionRepositoryCustom.findAccionValidacion(any(Long.class), any(Integer.class)))
            .thenReturn(null);
        when(this.tareaService.find(any(Long.class)))
            .thenReturn(new TareaDto());

        this.tareaPrevalidacionServiceImpl.send(tareaPrevalidacionDto);

        verify(this.tareaPrevalidacionRepositoryCustom, times(1))
            .findAccionValidacion(
                    ArgumentMatchers.<Long>any(),
                    ArgumentMatchers.<Integer>any());
        verify(this.tareaService, times(1))
            .find(
                    ArgumentMatchers.<Long>any());
    }

    @Test
    public void sendMaxReintentosTest() {
        final TareaPrevalidacionDto tareaPrevalidacionDto = mock(
                TareaPrevalidacionDto.class);
        when(this.tareaPrevalidacionServiceImpl.checkMaxReintentos(any(TareaPrevalidacionDto.class)))
            .thenReturn(Boolean.TRUE);

        this.tareaPrevalidacionServiceImpl.send(tareaPrevalidacionDto);
    }

}
