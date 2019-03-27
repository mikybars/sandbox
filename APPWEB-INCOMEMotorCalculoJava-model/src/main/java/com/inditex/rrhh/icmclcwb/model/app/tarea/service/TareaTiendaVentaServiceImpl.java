package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaVentaRepositoryCustom;

@Service
@Validated
public class TareaTiendaVentaServiceImpl implements TareaTiendaVentaService {

    @Autowired
    private TareaTiendaVentaRepositoryCustom tareaTiendaVentaRepository;
    
    @Autowired
    private TareaTiendaVentaMapper tareaTiendaVentaMapper;
    
    
    @Override
    public List<TareaTiendaVentaDto> savePtrVentaTotalizadoResponse(final PtrVentaTotalizadoResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaTiendaVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaTotalizado())) {
            result.addAll(tareaTiendaVentaMapper
                    .tareaTiendaVentasToTareaTiendaVentasDto(tareaTiendaVentaRepository.save(
                            tareaTiendaVentaMapper.getVentaTotalizadoReponseItemsDtoToTareaTiendaVentas(dto.getVentaTotalizado(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaTiendaVentaDto> savePtrVentaOnlineIpodResponse(final PtrVentaOnlineIpodResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaTiendaVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaTiendaVentaMapper
                    .tareaTiendaVentasToTareaTiendaVentasDto(tareaTiendaVentaRepository.save(
                            tareaTiendaVentaMapper.getVentaOnlineIpodReponseItemsDtoToTareaTiendaVentas(dto.getVentaOnline(),
                                    tarea))));
        }
        return result;
    }

    @Override
    public List<TareaTiendaVentaDto> savePtrVentaOnlinePickingResponse(final PtrVentaOnlinePickingResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaTiendaVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaTiendaVentaMapper
                    .tareaTiendaVentasToTareaTiendaVentasDto(tareaTiendaVentaRepository.save(
                            tareaTiendaVentaMapper.getVentaOnlinePickingReponseItemsDtoToTareaTiendaVentas(dto.getVentaOnline(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaTiendaVentaDto> savePtrVentaOnlineEntregaTiendaResponse(final PtrVentaOnlineEntregaTiendaResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaTiendaVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaTiendaVentaMapper
                    .tareaTiendaVentasToTareaTiendaVentasDto(tareaTiendaVentaRepository.save(
                            tareaTiendaVentaMapper.getVentaOnlineEntregaTiendaReponseItemsDtoToTareaTiendaVentas(dto.getVentaOnline(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaTiendaVentaDto> savePtrVentaOnlineEntregaDomicilioResponse(final PtrVentaOnlineEntregaDomicilioResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaTiendaVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaTiendaVentaMapper
                    .tareaTiendaVentasToTareaTiendaVentasDto(tareaTiendaVentaRepository.save(
                            tareaTiendaVentaMapper.getVentaOnlineEntregaDomicilioReponseItemsDtoToTareaTiendaVentas(dto.getVentaOnline(),
                                    tarea))));
        }
        return result;
    }
    
}
