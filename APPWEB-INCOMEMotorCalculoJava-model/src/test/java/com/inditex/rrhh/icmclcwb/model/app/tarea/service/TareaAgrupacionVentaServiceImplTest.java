package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAgrupacionVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionVentaRepositoryCustomImpl;

@RunWith(MockitoJUnitRunner.class)
public class TareaAgrupacionVentaServiceImplTest {

    @Mock
    private TareaAgrupacionVentaRepositoryCustomImpl tareaAgrupacionVentaRepositoryCustomImpl;

    @InjectMocks
    private TareaAgrupacionVentaServiceImpl tareaAgrupacionVentaServiceImpl;

    @Mock
    private TareaAgrupacionVentaMapper tareaAgrupacionVentaMapper;

    @Mock
    private TareaAgrupacionVentaDecorator tareaAgrupacionVentaDecorator;

    @Test
    public void savePtrVentaTotalizadoResponseTest() {
        TareaDto tarea = mock(TareaDto.class);
        PtrVentaTotalizadoResponseDto ptrVentaTotalizadoResponseDto = new PtrVentaTotalizadoResponseDto();
        ptrVentaTotalizadoResponseDto.setVentaTotalizado(new ArrayList<>());
        PtrVentaTotalizadoResultItemDto ptrVentaTotalizadoResultItemDto = mock(PtrVentaTotalizadoResultItemDto.class);
        ptrVentaTotalizadoResponseDto.getVentaTotalizado().add(ptrVentaTotalizadoResultItemDto);
        List<VentaCongeladaResultItemDto> list = new ArrayList<VentaCongeladaResultItemDto>();
        List<TareaAgrupacionCadenasDto> agrupaciones = new ArrayList<>();
        when(tareaAgrupacionVentaRepositoryCustomImpl.save(any(List.class))).thenReturn(list);

        tareaAgrupacionVentaServiceImpl.savePtrVentaTotalizadoResponse(ptrVentaTotalizadoResponseDto, tarea,
                agrupaciones);

        verify(tareaAgrupacionVentaRepositoryCustomImpl, times(1)).save(any(List.class));
    }

    @Test
    public void savePtrVentaOnlineEntregaDomicilioResponseTest() {
        TareaDto tarea = mock(TareaDto.class);
        PtrVentaOnlineEntregaDomicilioResponseDto ptrVentaOnlineEntregaDomicilioResponseDto = new PtrVentaOnlineEntregaDomicilioResponseDto();
        ptrVentaOnlineEntregaDomicilioResponseDto.setVentaOnline(new ArrayList<>());
        PtrVentaOnlineEntregaDomicilioResultItemDto ptrVentaTotalizadoResultItemDto = mock(
                PtrVentaOnlineEntregaDomicilioResultItemDto.class);
        ptrVentaOnlineEntregaDomicilioResponseDto.getVentaOnline().add(ptrVentaTotalizadoResultItemDto);
        List<VentaCongeladaResultItemDto> list = new ArrayList<VentaCongeladaResultItemDto>();
        List<TareaAgrupacionCadenasDto> agrupaciones = new ArrayList<>();
        when(tareaAgrupacionVentaRepositoryCustomImpl.save(any(List.class))).thenReturn(list);

        tareaAgrupacionVentaServiceImpl
            .savePtrVentaOnlineEntregaDomicilioResponse(ptrVentaOnlineEntregaDomicilioResponseDto, tarea, agrupaciones);

        verify(tareaAgrupacionVentaRepositoryCustomImpl, times(1)).save(any(List.class));
    }

}
