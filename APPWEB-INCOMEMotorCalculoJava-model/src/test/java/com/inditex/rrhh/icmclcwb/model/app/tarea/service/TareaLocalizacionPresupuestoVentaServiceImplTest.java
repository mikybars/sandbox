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

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoVentaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresupuestoVentaMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPresupuestoVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresupuestoVentaRepositoryCustomImpl;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionPresupuestoVentaServiceImplTest {

    @Mock
    private TareaLocalizacionPresupuestoVentaRepositoryCustomImpl tareaLocalizacionPresupuestoVentaRepositoryCustomImpl;

    @InjectMocks
    private TareaLocalizacionPresupuestoVentaServiceImpl tareaLocalizacionPresupuestoVentaService;
    
    @Mock
    private TareaLocalizacionPresupuestoVentaMapper tareaLocalizacionPresupuestoVentaMapper;
    
    @Mock
    private TareaLocalizacionPresupuestoVentaDecorator tareaLocalizacionPresupuestoVentaDecorator;
    
    @Test
    public void saveTest() {
        TareaLocalizacionPresupuestoVentaDto tareaLocalizacionPresupuestoVentaDto = mock(TareaLocalizacionPresupuestoVentaDto.class);
        List<TareaLocalizacionPresupuestoVentaDto> list = new ArrayList<TareaLocalizacionPresupuestoVentaDto>();
        list.add(tareaLocalizacionPresupuestoVentaDto);
        when(tareaLocalizacionPresupuestoVentaRepositoryCustomImpl.save(any(List.class))).thenReturn(list);

        tareaLocalizacionPresupuestoVentaService.save(list);

        verify(tareaLocalizacionPresupuestoVentaRepositoryCustomImpl, times(1)).save(any(List.class));
    }
    
    @Test
    public void saveVentaCongeladaResultItemDtoTest() {
        TareaDto tarea = mock(TareaDto.class);
        VentaCongeladaResultItemDto ventaCongeladaResultItemDto = mock(VentaCongeladaResultItemDto.class);
        List<VentaCongeladaResultItemDto> list = new ArrayList<VentaCongeladaResultItemDto>();
        list.add(ventaCongeladaResultItemDto);
        when(tareaLocalizacionPresupuestoVentaRepositoryCustomImpl.save(any(List.class))).thenReturn(list);

        tareaLocalizacionPresupuestoVentaService.save(list, tarea);

        verify(tareaLocalizacionPresupuestoVentaRepositoryCustomImpl, times(1)).save(any(List.class));
    }
    
    @Test
    public void savePtrVentaTotalizadoResponseTest() {
        TareaDto tarea = mock(TareaDto.class);
        IdLocalizacionLocalPresupuestoDto localizacion = mock(IdLocalizacionLocalPresupuestoDto.class);
        PtrVentaTotalizadoResponseDto ptrVentaTotalizadoResponseDto = new PtrVentaTotalizadoResponseDto();
        ptrVentaTotalizadoResponseDto.setVentaTotalizado(new ArrayList<>());
        PtrVentaTotalizadoResultItemDto ptrVentaTotalizadoResultItemDto = mock(PtrVentaTotalizadoResultItemDto.class);
        ptrVentaTotalizadoResponseDto.getVentaTotalizado().add(ptrVentaTotalizadoResultItemDto);
        List<VentaCongeladaResultItemDto> list = new ArrayList<VentaCongeladaResultItemDto>();

        when(tareaLocalizacionPresupuestoVentaRepositoryCustomImpl.save(any(List.class))).thenReturn(list);

        tareaLocalizacionPresupuestoVentaService.savePtrVentaTotalizadoResponse(ptrVentaTotalizadoResponseDto, localizacion, tarea);

        verify(tareaLocalizacionPresupuestoVentaRepositoryCustomImpl, times(1)).save(any(List.class));
    }
    
    @Test
    public void savePtrVentaOnlineIpodResponseTest() {
        TareaDto tarea = mock(TareaDto.class);
        IdLocalizacionLocalPresupuestoDto localizacion = mock(IdLocalizacionLocalPresupuestoDto.class);
        PtrVentaOnlineIpodResponseDto ptrVentaOnlineIpodResponseDto = new PtrVentaOnlineIpodResponseDto();
        ptrVentaOnlineIpodResponseDto.setVentaOnline(new ArrayList<>());
        PtrVentaOnlineIpodResultItemDto ptrVentaOnlineIpodResultItemDto = mock(PtrVentaOnlineIpodResultItemDto.class);
        ptrVentaOnlineIpodResponseDto.getVentaOnline().add(ptrVentaOnlineIpodResultItemDto);
        List<TareaLocalizacionPresupuestoVentaDto> list = mock(List.class);
        when(tareaLocalizacionPresupuestoVentaRepositoryCustomImpl.save(any(List.class))).thenReturn(list);

        tareaLocalizacionPresupuestoVentaService.savePtrVentaOnlineIpodResponse(ptrVentaOnlineIpodResponseDto, localizacion, tarea);

        verify(tareaLocalizacionPresupuestoVentaRepositoryCustomImpl, times(1)).save(any(List.class));
    }
    
    @Test
    public void savePtrVentaOnlinePickingResponseTest() {
        TareaDto tarea = mock(TareaDto.class);
        IdLocalizacionLocalPresupuestoDto localizacion = mock(IdLocalizacionLocalPresupuestoDto.class);
        PtrVentaOnlinePickingResponseDto ptrVentaOnlinePickingResponseDto = new PtrVentaOnlinePickingResponseDto();
        ptrVentaOnlinePickingResponseDto.setVentaOnline(new ArrayList<>());
        PtrVentaOnlinePickingResultItemDto ptrVentaOnlinePickingResultItemDto = mock(PtrVentaOnlinePickingResultItemDto.class);
        ptrVentaOnlinePickingResponseDto.getVentaOnline().add(ptrVentaOnlinePickingResultItemDto);
        List<TareaLocalizacionPresupuestoVentaDto> list = mock(List.class);
        when(tareaLocalizacionPresupuestoVentaRepositoryCustomImpl.save(any(List.class))).thenReturn(list);

        tareaLocalizacionPresupuestoVentaService.savePtrVentaOnlinePickingResponse(ptrVentaOnlinePickingResponseDto, localizacion, tarea);

        verify(tareaLocalizacionPresupuestoVentaRepositoryCustomImpl, times(1)).save(any(List.class));
    }
    
    @Test
    public void savePtrVentaOnlineEntregaTiendaResponseTest() {
        TareaDto tarea = mock(TareaDto.class);
        IdLocalizacionLocalPresupuestoDto localizacion = mock(IdLocalizacionLocalPresupuestoDto.class);
        PtrVentaOnlineEntregaTiendaResponseDto ptVentaOnlineEntregaTiendaResponseDto = new PtrVentaOnlineEntregaTiendaResponseDto();
        ptVentaOnlineEntregaTiendaResponseDto.setVentaOnline(new ArrayList<>());
        PtrVentaOnlineEntregaTiendaResultItemDto ptrVentaOnlineEntregaTiendaResultItemDto = mock(PtrVentaOnlineEntregaTiendaResultItemDto.class);
        ptVentaOnlineEntregaTiendaResponseDto.getVentaOnline().add(ptrVentaOnlineEntregaTiendaResultItemDto);
        List<TareaLocalizacionPresupuestoVentaDto> list = mock(List.class);
        when(tareaLocalizacionPresupuestoVentaRepositoryCustomImpl.save(any(List.class))).thenReturn(list);

        tareaLocalizacionPresupuestoVentaService.savePtrVentaOnlineEntregaTiendaResponse(ptVentaOnlineEntregaTiendaResponseDto, localizacion, tarea);

        verify(tareaLocalizacionPresupuestoVentaRepositoryCustomImpl, times(1)).save(any(List.class));
    }
    
    @Test
    public void savePtrVentaOnlineEntregaDomicilioResponseTest() {
        TareaDto tarea = mock(TareaDto.class);
        IdLocalizacionLocalPresupuestoDto localizacion = mock(IdLocalizacionLocalPresupuestoDto.class);
        PtrVentaOnlineEntregaDomicilioResponseDto ptVentaOnlineEntregaDomicilioResponseDto = new PtrVentaOnlineEntregaDomicilioResponseDto();
        ptVentaOnlineEntregaDomicilioResponseDto.setVentaOnline(new ArrayList<>());
        PtrVentaOnlineEntregaDomicilioResultItemDto ptrVentaOnlineEntregaDomicilioResultItemDto = mock(PtrVentaOnlineEntregaDomicilioResultItemDto.class);
        ptVentaOnlineEntregaDomicilioResponseDto.getVentaOnline().add(ptrVentaOnlineEntregaDomicilioResultItemDto);
        List<TareaLocalizacionPresupuestoVentaDto> list = mock(List.class);
        when(tareaLocalizacionPresupuestoVentaRepositoryCustomImpl.save(any(List.class))).thenReturn(list);

        tareaLocalizacionPresupuestoVentaService.savePtrVentaOnlineEntregaDomicilioResponse(ptVentaOnlineEntregaDomicilioResponseDto, localizacion, tarea);

        verify(tareaLocalizacionPresupuestoVentaRepositoryCustomImpl, times(1)).save(any(List.class));
    }
    
}
