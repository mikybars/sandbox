package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaVentaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaVentaSeccionService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaVentaSeccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaVentaSeccionRepositoryCustom;

@Service
@Validated
public class TareaTiendaVentaSeccionServiceImpl implements TareaTiendaVentaSeccionService {
    
    @Autowired
    private TareaTiendaVentaSeccionRepositoryCustom tareaTiendaVentaSeccionRepositoryCustom;
    
    @Autowired
    private TareaTiendaVentaSeccionMapper tareaTiendaVentaSeccionMapper;

    @Deprecated
    @Override
    public void pivot(@Valid final TareaDto tareaDto) {
        tareaTiendaVentaSeccionRepositoryCustom.save(tareaDto);
    }
    
    @Override
    public List<TareaTiendaVentaSeccionDto> savePtrVentaTotalizadoResponse(@Valid final PtrVentaTotalizadoResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaTiendaVentaSeccionDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaTotalizado())) {
            result.addAll(tareaTiendaVentaSeccionMapper
                    .tareaTiendaVentaSeccionToTareaTiendaVentaSeccionDto(tareaTiendaVentaSeccionRepositoryCustom.save(
                            tareaTiendaVentaSeccionMapper.getVentaTotalizadoResponseItemDtoToTareaTiendaVentaSeccion(dto.getVentaTotalizado(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaTiendaVentaSeccionDto> savePtrVentaOnlineIpodResponse(@Valid final PtrVentaOnlineIpodResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaTiendaVentaSeccionDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaTiendaVentaSeccionMapper
                    .tareaTiendaVentaSeccionToTareaTiendaVentaSeccionDto(tareaTiendaVentaSeccionRepositoryCustom.save(
                            tareaTiendaVentaSeccionMapper.getVentaOnlineIpodResponseItemDtoToTareaTiendaVentaSeccion(dto.getVentaOnline(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaTiendaVentaSeccionDto> savePtrVentaOnlineIpodIndividualDetalleResponse(@Valid final PtrVentaOnlineIpodIndividualDetalleResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaTiendaVentaSeccionDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnlineIpodIndividual())) {
            result.addAll(tareaTiendaVentaSeccionMapper
                    .tareaTiendaVentaSeccionToTareaTiendaVentaSeccionDto(tareaTiendaVentaSeccionRepositoryCustom.save(
                            tareaTiendaVentaSeccionMapper.getVentaOnlineIpodIndividualDetalleResponseItemDtoToTareaTiendaVentaSeccion(dto.getVentaOnlineIpodIndividual(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaTiendaVentaSeccionDto> savePtrVentaOnlinePickingResponse(@Valid final PtrVentaOnlinePickingResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaTiendaVentaSeccionDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaTiendaVentaSeccionMapper
                    .tareaTiendaVentaSeccionToTareaTiendaVentaSeccionDto(tareaTiendaVentaSeccionRepositoryCustom.save(
                            tareaTiendaVentaSeccionMapper.getVentaOnlinePickingResponseItemDtoToTareaTiendaVentaSeccion(dto.getVentaOnline(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaTiendaVentaSeccionDto> savePtrVentaOnlineEntregaTiendaResponse(@Valid final PtrVentaOnlineEntregaTiendaResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaTiendaVentaSeccionDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaTiendaVentaSeccionMapper
                    .tareaTiendaVentaSeccionToTareaTiendaVentaSeccionDto(tareaTiendaVentaSeccionRepositoryCustom.save(
                            tareaTiendaVentaSeccionMapper.getVentaOnlineEntregaTiendaResponseItemDtoToTareaTiendaVentaSeccion(dto.getVentaOnline(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaTiendaVentaSeccionDto> savePtrVentaOnlineEntregaDomicilioResponse(@Valid final PtrVentaOnlineEntregaDomicilioResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaTiendaVentaSeccionDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaTiendaVentaSeccionMapper
                    .tareaTiendaVentaSeccionToTareaTiendaVentaSeccionDto(tareaTiendaVentaSeccionRepositoryCustom.save(
                            tareaTiendaVentaSeccionMapper.getVentaOnlineEntregaDomicilioResponseItemDtoToTareaTiendaVentaSeccion(dto.getVentaOnline(),
                                    tarea))));
        }
        return result;
    }
    
}
