package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionSeccionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionSeccionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionSeccionVenta;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionSeccionVentaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionSeccionVentaServiceImpl implements TareaLocalizacionSeccionVentaService {

    private static final Integer[] SECCIONES = new Integer[] {PtrConstants.SECCION_1, PtrConstants.SECCION_2, PtrConstants.SECCION_3};
    
    @Autowired
    private TareaLocalizacionSeccionVentaRepositoryCustom tareaLocalizacionSeccionVentaRepositoryCustom;
    
    @Autowired
    private TareaLocalizacionSeccionVentaMapper tareaLocalizacionSeccionVentaMapper;
    
    @Override
    public List<TareaLocalizacionSeccionVentaDto> savePtrVentaTotalizadoResponse(@Valid PtrVentaTotalizadoResponseDto dto,
            @Valid TareaDto tarea) {
        List<TareaLocalizacionSeccionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaTotalizado())) {
            List<TareaLocalizacionSeccionVenta> toSave = new ArrayList<>();
            for (Integer seccion : SECCIONES) {
                List<TareaLocalizacionSeccionVenta> ventas = tareaLocalizacionSeccionVentaMapper.ventaTotalizadoResponseItemDtoToTareaLocalizacionSeccionVenta(
                        dto.getVentaTotalizado(), tarea, seccion);
                toSave.addAll(ventas.stream().filter(x -> !x.skip()).collect(Collectors.toList()));
            }
            result.addAll(tareaLocalizacionSeccionVentaMapper.tareaLocalizacionSeccionVentaToTareaLocalizacionSeccionVentaDto(
                    tareaLocalizacionSeccionVentaRepositoryCustom.save(toSave)));
        }
        return result;
    }

    @Override
    public List<TareaLocalizacionSeccionVentaDto> savePtrVentaOnlineIpodResponse(@Valid PtrVentaOnlineIpodResponseDto dto,
            @Valid TareaDto tarea) {
        List<TareaLocalizacionSeccionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            List<TareaLocalizacionSeccionVenta> toSave = new ArrayList<>();
            for (Integer seccion : SECCIONES) {
                List<TareaLocalizacionSeccionVenta> ventas = tareaLocalizacionSeccionVentaMapper.ventaOnlineIpodResponseItemDtoToTareaLocalizacionSeccionVenta(
                        dto.getVentaOnline(), tarea, seccion);
                toSave.addAll(ventas.stream().filter(x -> !x.skip()).collect(Collectors.toList()));
            }
            result.addAll(tareaLocalizacionSeccionVentaMapper.tareaLocalizacionSeccionVentaToTareaLocalizacionSeccionVentaDto(
                    tareaLocalizacionSeccionVentaRepositoryCustom.save(toSave)));
        }
        return result;
    }

    @Override
    public List<TareaLocalizacionSeccionVentaDto> savePtrVentaOnlineIpodIndividualDetalleResponse(
            @Valid PtrVentaOnlineIpodIndividualDetalleResponseDto dto, @Valid TareaDto tarea) {
        List<TareaLocalizacionSeccionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnlineIpodIndividual())) {
            List<TareaLocalizacionSeccionVenta> toSave = new ArrayList<>();
            for (Integer seccion : SECCIONES) {
                List<TareaLocalizacionSeccionVenta> ventas = tareaLocalizacionSeccionVentaMapper.ventaOnlineIpodIndividualDetalleResponseItemDtoToTareaLocalizacionSeccionVenta(
                        dto.getVentaOnlineIpodIndividual(), tarea, seccion);
                toSave.addAll(ventas.stream().filter(x -> !x.skip()).collect(Collectors.toList()));
            }
            result.addAll(tareaLocalizacionSeccionVentaMapper.tareaLocalizacionSeccionVentaToTareaLocalizacionSeccionVentaDto(
                    tareaLocalizacionSeccionVentaRepositoryCustom.save(toSave)));
        }
        return result;
    }

    @Override
    public List<TareaLocalizacionSeccionVentaDto> savePtrVentaOnlinePickingResponse(
            @Valid PtrVentaOnlinePickingResponseDto dto, @Valid TareaDto tarea) {
        List<TareaLocalizacionSeccionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            List<TareaLocalizacionSeccionVenta> toSave = new ArrayList<>();
            for (Integer seccion : SECCIONES) {
                List<TareaLocalizacionSeccionVenta> ventas = tareaLocalizacionSeccionVentaMapper.ventaOnlinePickingResponseItemDtoToTareaLocalizacionSeccionVenta(
                        dto.getVentaOnline(), tarea, seccion);
                toSave.addAll(ventas.stream().filter(x -> !x.skip()).collect(Collectors.toList()));
            }
            result.addAll(tareaLocalizacionSeccionVentaMapper.tareaLocalizacionSeccionVentaToTareaLocalizacionSeccionVentaDto(
                    tareaLocalizacionSeccionVentaRepositoryCustom.save(toSave)));
        }
        return result;
    }

    @Override
    public List<TareaLocalizacionSeccionVentaDto> savePtrVentaOnlineEntregaTiendaResponse(
            @Valid PtrVentaOnlineEntregaTiendaResponseDto dto, @Valid TareaDto tarea) {
        List<TareaLocalizacionSeccionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            List<TareaLocalizacionSeccionVenta> toSave = new ArrayList<>();
            for (Integer seccion : SECCIONES) {
                List<TareaLocalizacionSeccionVenta> ventas = tareaLocalizacionSeccionVentaMapper.ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionSeccionVenta(
                        dto.getVentaOnline(), tarea, seccion);
                toSave.addAll(ventas.stream().filter(x -> !x.skip()).collect(Collectors.toList()));
            }
            result.addAll(tareaLocalizacionSeccionVentaMapper.tareaLocalizacionSeccionVentaToTareaLocalizacionSeccionVentaDto(
                    tareaLocalizacionSeccionVentaRepositoryCustom.save(toSave)));
        }
        return result;
    }

    @Override
    public List<TareaLocalizacionSeccionVentaDto> savePtrVentaOnlineEntregaDomicilioResponse(
            @Valid PtrVentaOnlineEntregaDomicilioResponseDto dto, @Valid TareaDto tarea) {
        List<TareaLocalizacionSeccionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            List<TareaLocalizacionSeccionVenta> toSave = new ArrayList<>();
            for (Integer seccion : SECCIONES) {
                List<TareaLocalizacionSeccionVenta> ventas = tareaLocalizacionSeccionVentaMapper.ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionSeccionVenta(
                        dto.getVentaOnline(), tarea, seccion);
                toSave.addAll(ventas.stream().filter(x -> !x.skip()).collect(Collectors.toList()));
            }
            result.addAll(tareaLocalizacionSeccionVentaMapper.tareaLocalizacionSeccionVentaToTareaLocalizacionSeccionVentaDto(
                    tareaLocalizacionSeccionVentaRepositoryCustom.save(toSave)));
        }
        return result;
    }

}
