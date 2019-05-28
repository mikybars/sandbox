package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionVentaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionVentaServiceImpl implements TareaLocalizacionVentaService {

    @Autowired
    private TareaLocalizacionVentaRepositoryCustom tareaLocalizacionVentaRepository;
    
    @Autowired
    private TareaLocalizacionVentaMapper tareaLocalizacionVentaMapper;
    
    @Override
    public List<TareaLocalizacionVentaDto> savePtrVentaTotalizadoResponse(@Valid final PtrVentaTotalizadoResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaLocalizacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaTotalizado())) {
            result.addAll(tareaLocalizacionVentaMapper
                    .tareaLocalizacionVentasToTareaLocalizacionVentasDto(tareaLocalizacionVentaRepository.save(
                            tareaLocalizacionVentaMapper.getVentaTotalizadoReponseItemsDtoToTareaLocalizacionVentas(dto.getVentaTotalizado(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaLocalizacionVentaDto> savePtrVentaOnlineIpodResponse(@Valid final PtrVentaOnlineIpodResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaLocalizacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaLocalizacionVentaMapper
                    .tareaLocalizacionVentasToTareaLocalizacionVentasDto(tareaLocalizacionVentaRepository.save(
                            tareaLocalizacionVentaMapper.getVentaOnlineIpodReponseItemsDtoToTareaLocalizacionVentas(dto.getVentaOnline(),
                                    tarea))));
        }
        return result;
    }

    @Override
    public List<TareaLocalizacionVentaDto> savePtrVentaOnlinePickingResponse(@Valid final PtrVentaOnlinePickingResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaLocalizacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaLocalizacionVentaMapper
                    .tareaLocalizacionVentasToTareaLocalizacionVentasDto(tareaLocalizacionVentaRepository.save(
                            tareaLocalizacionVentaMapper.getVentaOnlinePickingReponseItemsDtoToTareaLocalizacionVentas(dto.getVentaOnline(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaLocalizacionVentaDto> savePtrVentaOnlineEntregaTiendaResponse(@Valid final PtrVentaOnlineEntregaTiendaResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaLocalizacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaLocalizacionVentaMapper
                    .tareaLocalizacionVentasToTareaLocalizacionVentasDto(tareaLocalizacionVentaRepository.save(
                            tareaLocalizacionVentaMapper.getVentaOnlineEntregaTiendaReponseItemsDtoToTareaLocalizacionVentas(dto.getVentaOnline(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaLocalizacionVentaDto> savePtrVentaOnlineEntregaDomicilioResponse(@Valid final PtrVentaOnlineEntregaDomicilioResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaLocalizacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaLocalizacionVentaMapper
                    .tareaLocalizacionVentasToTareaLocalizacionVentasDto(tareaLocalizacionVentaRepository.save(
                            tareaLocalizacionVentaMapper.getVentaOnlineEntregaDomicilioReponseItemsDtoToTareaLocalizacionVentas(dto.getVentaOnline(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaLocalizacionVentaDto> savePtrVentaIndividualDetalleResponse(@Valid final PtrVentaIndividualDetalleResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaLocalizacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaIndividualDetalle())) {
            result.addAll(tareaLocalizacionVentaMapper
                    .tareaLocalizacionVentasToTareaLocalizacionVentasDto(tareaLocalizacionVentaRepository.save(
                            tareaLocalizacionVentaMapper.getVentaIndividualDetalleReponseItemsDtoToTareaLocalizacionVentas(dto.getVentaIndividualDetalle(),
                                    tarea))));
        }
        return result;
    }
    
}
