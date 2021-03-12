package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionVentaRepositoryCustom;
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
        final TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        final PtrVentaTotalizadoResponseDto ventaTotalizado = new PtrVentaTotalizadoResponseDto();
        ventaTotalizado.setVentaTotalizado(new ArrayList<PtrVentaTotalizadoResultItemDto>());
        ventaTotalizado.getVentaTotalizado().add(new PtrVentaTotalizadoResultItemDto());
        this.tareaLocalizacionVentaServiceImpl.savePtrVentaTotalizadoResponse(ventaTotalizado, tarea);

        verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).save(ArgumentMatchers
            .<List<TareaLocalizacionVenta>>any());
    }

    @Test
    public void savePtrVentaOnlineIpodResponseTest() {
        final TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        final PtrVentaOnlineIpodResponseDto ventaOnline = new PtrVentaOnlineIpodResponseDto();
        ventaOnline.setVentaOnline(new ArrayList<PtrVentaOnlineIpodResultItemDto>());
        ventaOnline.getVentaOnline().add(new PtrVentaOnlineIpodResultItemDto());

        this.tareaLocalizacionVentaServiceImpl.savePtrVentaOnlineIpodResponse(ventaOnline, tarea);

        verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).save(ArgumentMatchers
            .<List<TareaLocalizacionVenta>>any());
    }

    @Test
    public void savePtrVentaOnlinePickingResponseTest() {
        final TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        final PtrVentaOnlinePickingResponseDto ventaOnline = new PtrVentaOnlinePickingResponseDto();
        ventaOnline.setVentaOnline(new ArrayList<PtrVentaOnlinePickingResultItemDto>());
        ventaOnline.getVentaOnline().add(new PtrVentaOnlinePickingResultItemDto());

        this.tareaLocalizacionVentaServiceImpl.savePtrVentaOnlinePickingResponse(ventaOnline, tarea);

        verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).save(ArgumentMatchers
            .<List<TareaLocalizacionVenta>>any());
    }

    @Test
    public void savePtrVentaOnlineEntregaTiendaResponseTest() {
        final TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        final PtrVentaOnlineEntregaTiendaResponseDto ventaOnline = new PtrVentaOnlineEntregaTiendaResponseDto();
        ventaOnline.setVentaOnline(new ArrayList<PtrVentaOnlineEntregaTiendaResultItemDto>());
        ventaOnline.getVentaOnline().add(new PtrVentaOnlineEntregaTiendaResultItemDto());

        this.tareaLocalizacionVentaServiceImpl.savePtrVentaOnlineEntregaTiendaResponse(ventaOnline, tarea);

        verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).save(ArgumentMatchers
            .<List<TareaLocalizacionVenta>>any());
    }

    @Test
    public void savePtrVentaOnlineEntregaDomicilioResponseTest() {
        final TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        final PtrVentaOnlineEntregaDomicilioResponseDto ventaOnline = new PtrVentaOnlineEntregaDomicilioResponseDto();
        ventaOnline.setVentaOnline(new ArrayList<PtrVentaOnlineEntregaDomicilioResultItemDto>());
        ventaOnline.getVentaOnline().add(new PtrVentaOnlineEntregaDomicilioResultItemDto());

        this.tareaLocalizacionVentaServiceImpl.savePtrVentaOnlineEntregaDomicilioResponse(ventaOnline, tarea);

        verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).save(ArgumentMatchers
            .<List<TareaLocalizacionVenta>>any());
    }

    @Test
    public void updateActivoVentaOnlineIpodTest() {
        final TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        final PtrVentaOnlineEntregaDomicilioResponseDto ventaOnline = new PtrVentaOnlineEntregaDomicilioResponseDto();
        ventaOnline.setVentaOnline(new ArrayList<PtrVentaOnlineEntregaDomicilioResultItemDto>());
        ventaOnline.getVentaOnline().add(new PtrVentaOnlineEntregaDomicilioResultItemDto());
        when(this.tipoDatoServiceImpl.findTipoDatoByTipoGrupoDato(any(Integer.class)))
            .thenReturn(new ArrayList<IdTipoDatoDto>());

        this.tareaLocalizacionVentaServiceImpl.updateActivoVentaOnlineIpod(tarea);

        verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).updateActivo(any(TareaDto.class),
                any(TipoVentaConceptoEnum.class), ArgumentMatchers.<List<Integer>>any());
    }

    @Test
    public void saveTest() {
        final TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        final VentaManualWlocResultItemDto ventaTotalizado = new VentaManualWlocResultItemDto();
        this.tareaLocalizacionVentaServiceImpl.save(Arrays.asList(ventaTotalizado), tarea);

        verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).save(ArgumentMatchers
            .<List<TareaLocalizacionVenta>>any());
    }

}
