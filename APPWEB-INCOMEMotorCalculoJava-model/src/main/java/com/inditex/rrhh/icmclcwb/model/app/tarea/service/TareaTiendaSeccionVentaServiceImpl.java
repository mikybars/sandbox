package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaSeccionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaSeccionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaSeccionVentaRepositoryCustom;

@Service
@Validated
public class TareaTiendaSeccionVentaServiceImpl implements TareaTiendaSeccionVentaService {

    @Autowired
    private TareaTiendaSeccionVentaMapper mapper;

    @Autowired
    private TareaTiendaSeccionVentaRepositoryCustom tareaTiendaSeccionVentaRepositoryCustom;

    @Override
    public List<TareaTiendaSeccionVentaDto> savePtrVentaTotalizadoResponse(@Valid final PtrVentaTotalizadoResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaTiendaSeccionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaTotalizado())) {
            result.addAll(mapper
                    .tareaTiendaSeccionVentasToTareaTiendaSeccionVentasDto(tareaTiendaSeccionVentaRepositoryCustom.save(
                            mapper.getVentaTotalizadoReponseItemsDtoToTareaTiendaSeccionVentas(dto.getVentaTotalizado(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaTiendaSeccionVentaDto> savePtrVentaOnlineEntregaDomicilioResponse(@Valid final PtrVentaOnlineEntregaDomicilioResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaTiendaSeccionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(mapper
                    .tareaTiendaSeccionVentasToTareaTiendaSeccionVentasDto(tareaTiendaSeccionVentaRepositoryCustom.save(
                            mapper.getVentaOnlineEntregaDomicilioReponseItemsDtoToTareaTiendaSeccionVentas(dto.getVentaOnline(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaTiendaSeccionVentaDto> savePtrVentaOnlineEntregaTiendaResponse(@Valid final PtrVentaOnlineEntregaTiendaResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaTiendaSeccionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(mapper
                    .tareaTiendaSeccionVentasToTareaTiendaSeccionVentasDto(tareaTiendaSeccionVentaRepositoryCustom.save(
                            mapper.getVentaOnlineEntregaTiendaReponseItemsDtoToTareaTiendaSeccionVentas(dto.getVentaOnline(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaTiendaSeccionVentaDto> savePtrVentaOnlinePickingResponse(@Valid final PtrVentaOnlinePickingResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaTiendaSeccionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(mapper
                    .tareaTiendaSeccionVentasToTareaTiendaSeccionVentasDto(tareaTiendaSeccionVentaRepositoryCustom.save(
                            mapper.getVentaOnlinePickingReponseItemsDtoToTareaTiendaSeccionVentas(dto.getVentaOnline(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaTiendaSeccionVentaDto> savePtrVentaOnlineIpodResponse(@Valid final PtrVentaOnlineIpodResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaTiendaSeccionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(mapper
                    .tareaTiendaSeccionVentasToTareaTiendaSeccionVentasDto(tareaTiendaSeccionVentaRepositoryCustom.save(
                            mapper.getVentaOnlineIpodReponseItemsDtoToTareaTiendaSeccionVentas(dto.getVentaOnline(),
                                    tarea))));
        }
        return result;
    }

}
