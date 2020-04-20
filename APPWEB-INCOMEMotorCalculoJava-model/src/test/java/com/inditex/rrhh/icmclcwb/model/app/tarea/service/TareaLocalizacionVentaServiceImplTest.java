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

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
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
import com.inditex.rrhh.icmclcwb.model.app.calcular.service.TipoDatoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionVentaRepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionVentaServiceImplTest {

    @Mock
    private TareaLocalizacionVentaRepositoryCustom tareaLocalizacionVentaRepositoryCustom;
    
    @InjectMocks
    private TareaLocalizacionVentaServiceImpl tareaLocalizacionVentaServiceImpl;
    
    @Mock
    private TareaLocalizacionVentaMapper tareaLocalizacionVentaMapper;
    
    @Mock
    private TrabajoServiceImpl trabajoServiceImpl;
    
    @Mock
    private TipoDatoServiceImpl tipoDatoServiceImpl;
    
    @Test
    public void savePtrVentaTotalizadoResponseTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        PtrVentaTotalizadoResponseDto ventaTotalizado = new PtrVentaTotalizadoResponseDto();
        ventaTotalizado.setVentaTotalizado(new ArrayList<PtrVentaTotalizadoResultItemDto>());
        ventaTotalizado.getVentaTotalizado().add(new PtrVentaTotalizadoResultItemDto());
        tareaLocalizacionVentaServiceImpl.savePtrVentaTotalizadoResponse(ventaTotalizado, tarea);
        
        verify(tareaLocalizacionVentaRepositoryCustom, times(1)).save(any(List.class));
    }
    
    @Test
    public void savePtrVentaOnlineIpodResponseTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        PtrVentaOnlineIpodResponseDto ventaOnline = new PtrVentaOnlineIpodResponseDto();
        ventaOnline.setVentaOnline(new ArrayList<PtrVentaOnlineIpodResultItemDto>());        
        ventaOnline.getVentaOnline().add(new PtrVentaOnlineIpodResultItemDto());

        tareaLocalizacionVentaServiceImpl.savePtrVentaOnlineIpodResponse(ventaOnline, tarea);
        
        verify(tareaLocalizacionVentaRepositoryCustom, times(1)).save(any(List.class));
    }
    
    @Test
    public void savePtrVentaOnlinePickingResponseTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        PtrVentaOnlinePickingResponseDto ventaOnline = new PtrVentaOnlinePickingResponseDto();
        ventaOnline.setVentaOnline(new ArrayList<PtrVentaOnlinePickingResultItemDto>());        
        ventaOnline.getVentaOnline().add(new PtrVentaOnlinePickingResultItemDto());

        tareaLocalizacionVentaServiceImpl.savePtrVentaOnlinePickingResponse(ventaOnline, tarea);
        
        verify(tareaLocalizacionVentaRepositoryCustom, times(1)).save(any(List.class));
    }
    
    @Test
    public void savePtrVentaOnlineEntregaTiendaResponseTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        PtrVentaOnlineEntregaTiendaResponseDto ventaOnline = new PtrVentaOnlineEntregaTiendaResponseDto();
        ventaOnline.setVentaOnline(new ArrayList<PtrVentaOnlineEntregaTiendaResultItemDto>());        
        ventaOnline.getVentaOnline().add(new PtrVentaOnlineEntregaTiendaResultItemDto());

        tareaLocalizacionVentaServiceImpl.savePtrVentaOnlineEntregaTiendaResponse(ventaOnline, tarea);
        
        verify(tareaLocalizacionVentaRepositoryCustom, times(1)).save(any(List.class));
    }
    
    @Test
    public void savePtrVentaOnlineEntregaDomicilioResponseTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        PtrVentaOnlineEntregaDomicilioResponseDto ventaOnline = new PtrVentaOnlineEntregaDomicilioResponseDto();
        ventaOnline.setVentaOnline(new ArrayList<PtrVentaOnlineEntregaDomicilioResultItemDto>());        
        ventaOnline.getVentaOnline().add(new PtrVentaOnlineEntregaDomicilioResultItemDto());

        tareaLocalizacionVentaServiceImpl.savePtrVentaOnlineEntregaDomicilioResponse(ventaOnline, tarea);
        
        verify(tareaLocalizacionVentaRepositoryCustom, times(1)).save(any(List.class));
    }
    
    @Test
    public void updateActivoVentaOnlineIpodTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        PtrVentaOnlineEntregaDomicilioResponseDto ventaOnline = new PtrVentaOnlineEntregaDomicilioResponseDto();
        ventaOnline.setVentaOnline(new ArrayList<PtrVentaOnlineEntregaDomicilioResultItemDto>());        
        ventaOnline.getVentaOnline().add(new PtrVentaOnlineEntregaDomicilioResultItemDto());
        when(tipoDatoServiceImpl.findTipoDatoByTipoGrupoDato(any(Integer.class))).thenReturn(new ArrayList<IdTipoDatoDto>());

        tareaLocalizacionVentaServiceImpl.updateActivoVentaOnlineIpod(tarea);
        
        verify(tareaLocalizacionVentaRepositoryCustom, times(1)).updateActivo(any(TareaDto.class), any(TipoVentaConceptoEnum.class), any(List.class));
    }
}
