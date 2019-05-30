package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionVentaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionVentaSeccionService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionVentaSeccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionVentaSeccionRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionVentaSeccionServiceImpl implements TareaLocalizacionVentaSeccionService {

    @Autowired
    private TareaLocalizacionVentaSeccionRepositoryCustom tareaLocalizacionVentaSeccionRepositoryCustom;

    @Autowired
    private TareaLocalizacionVentaSeccionMapper tareaLocalizacionVentaSeccionMapper;

    @Override
    public List<TareaLocalizacionVentaSeccionDto> savePtrVentaTotalizadoResponse(
            @Valid final PtrVentaTotalizadoResponseDto dto, @Valid final TareaDto tarea) {
        List<TareaLocalizacionVentaSeccionDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaTotalizado())) {
            result.addAll(tareaLocalizacionVentaSeccionMapper
                    .tareaLocalizacionVentaSeccionToTareaLocalizacionVentaSeccionDto(tareaLocalizacionVentaSeccionRepositoryCustom.save(
                            tareaLocalizacionVentaSeccionMapper.getVentaTotalizadoResponseItemDtoToTareaLocalizacionVentaSeccion(
                                    dto.getVentaTotalizado(), tarea))));
        }
        return result;
    }

    @Override
    public List<TareaLocalizacionVentaSeccionDto> savePtrVentaOnlineIpodResponse(
            @Valid final PtrVentaOnlineIpodResponseDto dto, @Valid final TareaDto tarea) {
        List<TareaLocalizacionVentaSeccionDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaLocalizacionVentaSeccionMapper.tareaLocalizacionVentaSeccionToTareaLocalizacionVentaSeccionDto(
                    tareaLocalizacionVentaSeccionRepositoryCustom.save(tareaLocalizacionVentaSeccionMapper
                            .getVentaOnlineIpodResponseItemDtoToTareaLocalizacionVentaSeccion(dto.getVentaOnline(), tarea))));
        }
        return result;
    }

    @Override
    public List<TareaLocalizacionVentaSeccionDto> savePtrVentaOnlineIpodIndividualDetalleResponse(
            @Valid final PtrVentaOnlineIpodIndividualDetalleResponseDto dto, @Valid final TareaDto tarea) {
        List<TareaLocalizacionVentaSeccionDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnlineIpodIndividual())) {
            result.addAll(tareaLocalizacionVentaSeccionMapper.tareaLocalizacionVentaSeccionToTareaLocalizacionVentaSeccionDto(
                    tareaLocalizacionVentaSeccionRepositoryCustom.save(tareaLocalizacionVentaSeccionMapper
                            .getVentaOnlineIpodIndividualDetalleResponseItemDtoToTareaLocalizacionVentaSeccion(
                                    dto.getVentaOnlineIpodIndividual(), tarea))));
        }
        return result;
    }

    @Override
    public List<TareaLocalizacionVentaSeccionDto> savePtrVentaOnlinePickingResponse(
            @Valid final PtrVentaOnlinePickingResponseDto dto, @Valid final TareaDto tarea) {
        List<TareaLocalizacionVentaSeccionDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaLocalizacionVentaSeccionMapper
                    .tareaLocalizacionVentaSeccionToTareaLocalizacionVentaSeccionDto(tareaLocalizacionVentaSeccionRepositoryCustom.save(
                            tareaLocalizacionVentaSeccionMapper.getVentaOnlinePickingResponseItemDtoToTareaLocalizacionVentaSeccion(
                                    dto.getVentaOnline(), tarea))));
        }
        return result;
    }

    @Override
    public List<TareaLocalizacionVentaSeccionDto> savePtrVentaOnlineEntregaTiendaResponse(
            @Valid final PtrVentaOnlineEntregaTiendaResponseDto dto, @Valid final TareaDto tarea) {
        List<TareaLocalizacionVentaSeccionDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaLocalizacionVentaSeccionMapper.tareaLocalizacionVentaSeccionToTareaLocalizacionVentaSeccionDto(
                    tareaLocalizacionVentaSeccionRepositoryCustom.save(tareaLocalizacionVentaSeccionMapper
                            .getVentaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionVentaSeccion(dto.getVentaOnline(),
                                    tarea))));
        }
        return result;
    }

    @Override
    public List<TareaLocalizacionVentaSeccionDto> savePtrVentaOnlineEntregaDomicilioResponse(
            @Valid final PtrVentaOnlineEntregaDomicilioResponseDto dto, @Valid final TareaDto tarea) {
        List<TareaLocalizacionVentaSeccionDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaLocalizacionVentaSeccionMapper.tareaLocalizacionVentaSeccionToTareaLocalizacionVentaSeccionDto(
                    tareaLocalizacionVentaSeccionRepositoryCustom.save(tareaLocalizacionVentaSeccionMapper
                            .getVentaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionVentaSeccion(
                                    dto.getVentaOnline(), tarea))));
        }
        return result;
    }

}
