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
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaSeccionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaSeccionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaSeccionVenta;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaSeccionVentaRepositoryCustom;

@Service
@Validated
public class TareaTiendaSeccionVentaServiceImpl implements TareaTiendaSeccionVentaService {

    private static final Integer[] SECCIONES = new Integer[] {PtrConstants.SECCION_1, PtrConstants.SECCION_2, PtrConstants.SECCION_3};
    
    @Autowired
    private TareaTiendaSeccionVentaRepositoryCustom tareaTiendaSeccionVentaRepositoryCustom;
    
    @Autowired
    private TareaTiendaSeccionVentaMapper tareaTiendaSeccionVentaMapper;
    
    @Override
    public List<TareaTiendaSeccionVentaDto> savePtrVentaTotalizadoResponse(@Valid PtrVentaTotalizadoResponseDto dto,
            @Valid TareaDto tarea) {
        List<TareaTiendaSeccionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaTotalizado())) {
            List<TareaTiendaSeccionVenta> toSave = new ArrayList<>();
            for (Integer seccion : SECCIONES) {
                List<TareaTiendaSeccionVenta> ventas = tareaTiendaSeccionVentaMapper.ventaTotalizadoResponseItemDtoToTareaTiendaSeccionVenta(
                        dto.getVentaTotalizado(), tarea, seccion);
                toSave.addAll(ventas.stream().filter(x -> !x.skip()).collect(Collectors.toList()));
            }
            result.addAll(tareaTiendaSeccionVentaMapper.tareaTiendaSeccionVentaToTareaTiendaSeccionVentaDto(
                    tareaTiendaSeccionVentaRepositoryCustom.save(toSave)));
        }
        return result;
    }

    @Override
    public List<TareaTiendaSeccionVentaDto> savePtrVentaOnlineIpodResponse(@Valid PtrVentaOnlineIpodResponseDto dto,
            @Valid TareaDto tarea) {
        List<TareaTiendaSeccionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            List<TareaTiendaSeccionVenta> toSave = new ArrayList<>();
            for (Integer seccion : SECCIONES) {
                List<TareaTiendaSeccionVenta> ventas = tareaTiendaSeccionVentaMapper.ventaOnlineIpodResponseItemDtoToTareaTiendaSeccionVenta(
                        dto.getVentaOnline(), tarea, seccion);
                toSave.addAll(ventas.stream().filter(x -> !x.skip()).collect(Collectors.toList()));
            }
            result.addAll(tareaTiendaSeccionVentaMapper.tareaTiendaSeccionVentaToTareaTiendaSeccionVentaDto(
                    tareaTiendaSeccionVentaRepositoryCustom.save(toSave)));
        }
        return result;
    }

    @Override
    public List<TareaTiendaSeccionVentaDto> savePtrVentaOnlineIpodIndividualDetalleResponse(
            @Valid PtrVentaOnlineIpodIndividualDetalleResponseDto dto, @Valid TareaDto tarea) {
        List<TareaTiendaSeccionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnlineIpodIndividual())) {
            List<TareaTiendaSeccionVenta> toSave = new ArrayList<>();
            for (Integer seccion : SECCIONES) {
                List<TareaTiendaSeccionVenta> ventas = tareaTiendaSeccionVentaMapper.ventaOnlineIpodIndividualDetalleResponseItemDtoToTareaTiendaSeccionVenta(
                        dto.getVentaOnlineIpodIndividual(), tarea, seccion);
                toSave.addAll(ventas.stream().filter(x -> !x.skip()).collect(Collectors.toList()));
            }
            result.addAll(tareaTiendaSeccionVentaMapper.tareaTiendaSeccionVentaToTareaTiendaSeccionVentaDto(
                    tareaTiendaSeccionVentaRepositoryCustom.save(toSave)));
        }
        return result;
    }

    @Override
    public List<TareaTiendaSeccionVentaDto> savePtrVentaOnlinePickingResponse(
            @Valid PtrVentaOnlinePickingResponseDto dto, @Valid TareaDto tarea) {
        List<TareaTiendaSeccionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            List<TareaTiendaSeccionVenta> toSave = new ArrayList<>();
            for (Integer seccion : SECCIONES) {
                List<TareaTiendaSeccionVenta> ventas = tareaTiendaSeccionVentaMapper.ventaOnlinePickingResponseItemDtoToTareaTiendaSeccionVenta(
                        dto.getVentaOnline(), tarea, seccion);
                toSave.addAll(ventas.stream().filter(x -> !x.skip()).collect(Collectors.toList()));
            }
            result.addAll(tareaTiendaSeccionVentaMapper.tareaTiendaSeccionVentaToTareaTiendaSeccionVentaDto(
                    tareaTiendaSeccionVentaRepositoryCustom.save(toSave)));
        }
        return result;
    }

    @Override
    public List<TareaTiendaSeccionVentaDto> savePtrVentaOnlineEntregaTiendaResponse(
            @Valid PtrVentaOnlineEntregaTiendaResponseDto dto, @Valid TareaDto tarea) {
        List<TareaTiendaSeccionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            List<TareaTiendaSeccionVenta> toSave = new ArrayList<>();
            for (Integer seccion : SECCIONES) {
                List<TareaTiendaSeccionVenta> ventas = tareaTiendaSeccionVentaMapper.ventaOnlineEntregaTiendaResponseItemDtoToTareaTiendaSeccionVenta(
                        dto.getVentaOnline(), tarea, seccion);
                toSave.addAll(ventas.stream().filter(x -> !x.skip()).collect(Collectors.toList()));
            }
            result.addAll(tareaTiendaSeccionVentaMapper.tareaTiendaSeccionVentaToTareaTiendaSeccionVentaDto(
                    tareaTiendaSeccionVentaRepositoryCustom.save(toSave)));
        }
        return result;
    }

    @Override
    public List<TareaTiendaSeccionVentaDto> savePtrVentaOnlineEntregaDomicilioResponse(
            @Valid PtrVentaOnlineEntregaDomicilioResponseDto dto, @Valid TareaDto tarea) {
        List<TareaTiendaSeccionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            List<TareaTiendaSeccionVenta> toSave = new ArrayList<>();
            for (Integer seccion : SECCIONES) {
                List<TareaTiendaSeccionVenta> ventas = tareaTiendaSeccionVentaMapper.ventaOnlineEntregaDomicilioResponseItemDtoToTareaTiendaSeccionVenta(
                        dto.getVentaOnline(), tarea, seccion);
                toSave.addAll(ventas.stream().filter(x -> !x.skip()).collect(Collectors.toList()));
            }
            result.addAll(tareaTiendaSeccionVentaMapper.tareaTiendaSeccionVentaToTareaTiendaSeccionVentaDto(
                    tareaTiendaSeccionVentaRepositoryCustom.save(toSave)));
        }
        return result;
    }

}
