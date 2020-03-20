package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoVentaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresupuestoVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresupuestoVentaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionPresupuestoVentaServiceImpl implements TareaLocalizacionPresupuestoVentaService {

    @Autowired
    private TareaLocalizacionPresupuestoVentaRepositoryCustom tareaLocalizacionPresupuestoVentaRepositoryCustom;
    
    @Autowired
    private TareaLocalizacionPresupuestoVentaMapper tareaLocalizacionPresupuestoVentaMapper;
    
    @Override
    public List<TareaLocalizacionPresupuestoVentaDto> save(
            @Valid final List<TareaLocalizacionPresupuestoVentaDto> tareaLocalizacionPresupuestoVenta) {
        return tareaLocalizacionPresupuestoVentaMapper.tareaLocalizacionPresupuestoVentaToTareaLocalizacionPresupuestoVentaDto(
                tareaLocalizacionPresupuestoVentaRepositoryCustom.save(tareaLocalizacionPresupuestoVentaMapper.tareaLocalizacionPresupuestoVentaDtoToTareaLocalizacionPresupuestoVenta(tareaLocalizacionPresupuestoVenta)));
    }
    
    @Override
    public List<TareaLocalizacionPresupuestoVentaDto> save(
            @Valid final List<VentaCongeladaResultItemDto> ventaCongelada, TareaDto tarea) {
        return tareaLocalizacionPresupuestoVentaMapper.tareaLocalizacionPresupuestoVentaToTareaLocalizacionPresupuestoVentaDto(
                tareaLocalizacionPresupuestoVentaRepositoryCustom.save(tareaLocalizacionPresupuestoVentaMapper.ventaCongeladaResultItemDtoToTareaLocalizacionPresupuestoVenta(ventaCongelada, tarea)));
    }
    
    @Override
    public List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaTotalizadoResponse(@Valid PtrVentaTotalizadoResponseDto dto,
            @Valid TareaDto tarea){
        List<TareaLocalizacionPresupuestoVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaTotalizado())) {
            result.addAll(tareaLocalizacionPresupuestoVentaMapper.tareaLocalizacionPresupuestoVentaToTareaLocalizacionPresupuestoVentaDto(
                    tareaLocalizacionPresupuestoVentaRepositoryCustom.save(tareaLocalizacionPresupuestoVentaMapper
                            .ventaTotalizadoResponseItemDtoToTareaLocalizacionPresupuestoVenta(dto.getVentaTotalizado(), tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlineIpodResponse(@Valid PtrVentaOnlineIpodResponseDto dto,
            @Valid TareaDto tarea){
        List<TareaLocalizacionPresupuestoVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaLocalizacionPresupuestoVentaMapper.tareaLocalizacionPresupuestoVentaToTareaLocalizacionPresupuestoVentaDto(
                    tareaLocalizacionPresupuestoVentaRepositoryCustom.save(tareaLocalizacionPresupuestoVentaMapper
                            .ventaOnlineIpodResponseItemDtoToTareaLocalizacionPresupuestoVenta(dto.getVentaOnline(), tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlinePickingResponse(@Valid PtrVentaOnlinePickingResponseDto dto,
            @Valid TareaDto tarea){
        List<TareaLocalizacionPresupuestoVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaLocalizacionPresupuestoVentaMapper.tareaLocalizacionPresupuestoVentaToTareaLocalizacionPresupuestoVentaDto(
                    tareaLocalizacionPresupuestoVentaRepositoryCustom.save(tareaLocalizacionPresupuestoVentaMapper
                            .ventaOnlinePickingResponseItemDtoToTareaLocalizacionPresupuestoVenta(dto.getVentaOnline(), tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlineEntregaTiendaResponse(@Valid PtrVentaOnlineEntregaTiendaResponseDto dto,
            @Valid TareaDto tarea){
        List<TareaLocalizacionPresupuestoVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaLocalizacionPresupuestoVentaMapper.tareaLocalizacionPresupuestoVentaToTareaLocalizacionPresupuestoVentaDto(
                    tareaLocalizacionPresupuestoVentaRepositoryCustom.save(tareaLocalizacionPresupuestoVentaMapper
                            .ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionPresupuestoVenta(dto.getVentaOnline(), tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlineEntregaDomicilioResponse(@Valid PtrVentaOnlineEntregaDomicilioResponseDto dto,
            @Valid TareaDto tarea){
        List<TareaLocalizacionPresupuestoVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaLocalizacionPresupuestoVentaMapper.tareaLocalizacionPresupuestoVentaToTareaLocalizacionPresupuestoVentaDto(
                    tareaLocalizacionPresupuestoVentaRepositoryCustom.save(tareaLocalizacionPresupuestoVentaMapper
                            .ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionPresupuestoVenta(dto.getVentaOnline(), tarea))));
        }
        return result;
    }
}
