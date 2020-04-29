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
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaVentaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaVentaRepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionPersonaVentaServiceImplTest {

    @Mock
    private TareaLocalizacionPersonaVentaRepositoryCustom tareaLocalizacionPersonaVentaRepositoryCustom;
    
    @InjectMocks
    private TareaLocalizacionPersonaVentaServiceImpl tareaLocalizacionPersonaVentaServiceImpl;
    
    @Mock
    private TrabajoServiceImpl trabajoServiceImpl;
    
    @Mock
    private TareaLocalizacionPersonaVentaMapper tareaLocalizacionPersonaVentaMapper;
    
    @Test
    public void savePtrVentaIndividualDetalleResultItemTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        List<PtrVentaIndividualDetalleResultItemDto> ventaIndividual = new ArrayList<>();

        tareaLocalizacionPersonaVentaServiceImpl.savePtrVentaIndividualDetalleResultItem(ventaIndividual, tarea);
        
        verify(tareaLocalizacionPersonaVentaMapper, times(1)).ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(any(List.class), any(TareaDto.class));
        verify(tareaLocalizacionPersonaVentaRepositoryCustom, times(1)).save(any(List.class));
    }
    
    @Test
    public void savePtrVentaOnlineIpodIndividualDetalleResultItemTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> ventaOnlineIpod = new ArrayList<>();

        tareaLocalizacionPersonaVentaServiceImpl.savePtrVentaOnlineIpodIndividualDetalleResultItem(ventaOnlineIpod, tarea);
        
        verify(tareaLocalizacionPersonaVentaMapper, times(1)).ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(any(List.class), any(TareaDto.class));
        verify(tareaLocalizacionPersonaVentaRepositoryCustom, times(1)).save(any(List.class));
    }
}
