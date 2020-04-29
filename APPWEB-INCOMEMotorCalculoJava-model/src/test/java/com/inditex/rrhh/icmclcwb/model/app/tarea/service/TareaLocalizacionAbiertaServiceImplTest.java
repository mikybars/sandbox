package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.calcular.service.TipoDatoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionAbiertaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionAbiertaRepositoryCustom;


@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionAbiertaServiceImplTest {

    @Mock
    private TareaLocalizacionAbiertaRepositoryCustom tareaLocalizacionAbiertaRepositoryCustom;
    
    @InjectMocks
    private TareaLocalizacionAbiertaServiceImpl tareaLocalizacionAbiertaServiceImpl;
    
    @Mock
    private TrabajoServiceImpl trabajoServiceImpl;
    
    @Mock
    private TipoDatoServiceImpl tipoDatoService;
    
    @Mock
    private TareaLocalizacionAbiertaMapper tareaLocalizacionAbiertaMapper;
    
    @Test
    public void saveCerradoTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        TrabajoDto trabajo = mock(TrabajoDto.class);
        List<IdTipoDatoDto> tipoDato = new ArrayList<>();
        when(tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class))).thenReturn(tipoDato);

        tareaLocalizacionAbiertaServiceImpl.saveCerrado(tarea, trabajo);
        verify(tareaLocalizacionAbiertaRepositoryCustom, times(1)).saveCerrado(any(TareaDto.class), any(TrabajoDto.class), (java.util.@NotNull List<Integer>) any(List.class));
    }
}
