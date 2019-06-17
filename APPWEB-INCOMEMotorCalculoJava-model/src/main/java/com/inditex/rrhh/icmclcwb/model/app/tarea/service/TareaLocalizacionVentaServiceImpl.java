package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.TipoConceptoVenta;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionVentaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionVentaServiceImpl implements TareaLocalizacionVentaService {

    @Autowired
    private TareaLocalizacionVentaRepositoryCustom tareaLocalizacionVentaRepositoryCustom;
    
    @Autowired
    private TareaLocalizacionVentaMapper tareaLocalizacionVentaMapper;
    
    @Override
    public List<TareaLocalizacionVentaDto> savePtrVentaTotalizadoResponse(@Valid PtrVentaTotalizadoResponseDto dto,
            @Valid TareaDto tarea) {
        List<TareaLocalizacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaTotalizado())) {
            result.addAll(tareaLocalizacionVentaMapper.tareaLocalizacionVentaToTareaLocalizacionVentaDto(
                    tareaLocalizacionVentaRepositoryCustom.save(tareaLocalizacionVentaMapper.ventaTotalizadoResponseItemDtoToTareaLocalizacionVenta(dto.getVentaTotalizado(), tarea, TipoDatoEnum.IMPORTE_VENTA_FISICA_LOCALIZACION_SECCION.getId(), TipoDatoEnum.IMPORTE_VENTA_FISICA_LOCALIZACION.getId()))));
        }
        return result;
    }

    @Override
    public List<TareaLocalizacionVentaDto> savePtrVentaOnlineIpodResponse(@Valid PtrVentaOnlineIpodResponseDto dto,
            @Valid TareaDto tarea) {
        List<TareaLocalizacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaLocalizacionVentaMapper.tareaLocalizacionVentaToTareaLocalizacionVentaDto(
                    tareaLocalizacionVentaRepositoryCustom.save( tareaLocalizacionVentaMapper.ventaOnlineIpodResponseItemDtoToTareaLocalizacionVenta(dto.getVentaOnline(), tarea, TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(), TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION.getId()))));
        }
        return result;
    }

    @Override
    public List<TareaLocalizacionVentaDto> savePtrVentaOnlineIpodIndividualDetalleResponse(
            @Valid PtrVentaOnlineIpodIndividualDetalleResponseDto dto, @Valid TareaDto tarea) {
        List<TareaLocalizacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnlineIpodIndividual())) {
            result.addAll(tareaLocalizacionVentaMapper.tareaLocalizacionVentaToTareaLocalizacionVentaDto(
                    tareaLocalizacionVentaRepositoryCustom.save(tareaLocalizacionVentaMapper.ventaOnlineIpodIndividualDetalleResponseItemDtoToTareaLocalizacionVenta(
                            dto.getVentaOnlineIpodIndividual(), tarea, TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION_SECCION.getId(), TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION.getId()))));
        }
        return result;
    }

    @Override
    public List<TareaLocalizacionVentaDto> savePtrVentaOnlinePickingResponse(
            @Valid PtrVentaOnlinePickingResponseDto dto, @Valid TareaDto tarea) {
        List<TareaLocalizacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaLocalizacionVentaMapper.tareaLocalizacionVentaToTareaLocalizacionVentaDto(
                    tareaLocalizacionVentaRepositoryCustom.save(tareaLocalizacionVentaMapper.ventaOnlinePickingResponseItemDtoToTareaLocalizacionVenta(
                            dto.getVentaOnline(), tarea, TipoDatoEnum.IMPORTE_VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId(), TipoDatoEnum.IMPORTE_VENTA_ONLINE_SINT_LOCALIZACION.getId()))));
        }
        return result;
    }

    @Override
    public List<TareaLocalizacionVentaDto> savePtrVentaOnlineEntregaTiendaResponse(
            @Valid PtrVentaOnlineEntregaTiendaResponseDto dto, @Valid TareaDto tarea) {
        List<TareaLocalizacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaLocalizacionVentaMapper.tareaLocalizacionVentaToTareaLocalizacionVentaDto(
                    tareaLocalizacionVentaRepositoryCustom.save(tareaLocalizacionVentaMapper.ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionVenta(
                            dto.getVentaOnline(), tarea, TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION_SECCION.getId(), TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION.getId()))));
        }
        return result;
    }

    @Override
    public List<TareaLocalizacionVentaDto> savePtrVentaOnlineEntregaDomicilioResponse(
            @Valid PtrVentaOnlineEntregaDomicilioResponseDto dto, @Valid TareaDto tarea) {
        List<TareaLocalizacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(tareaLocalizacionVentaMapper.tareaLocalizacionVentaToTareaLocalizacionVentaDto(
                    tareaLocalizacionVentaRepositoryCustom.save(tareaLocalizacionVentaMapper.ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionVenta(
                            dto.getVentaOnline(), tarea, TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION_SECCION.getId(), TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION.getId()))));
        }
        return result;
    }
    
    @Override
    public List<TareaLocalizacionVentaDto> savePtrVentaIndividualDetalleResponse(
            @Valid PtrVentaIndividualDetalleResponseDto dto, @Valid TareaDto tarea) {
        List<TareaLocalizacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaIndividualDetalle())) {
            result.addAll(tareaLocalizacionVentaMapper.tareaLocalizacionVentaToTareaLocalizacionVentaDto(
                    tareaLocalizacionVentaRepositoryCustom.save(tareaLocalizacionVentaMapper.ventaIndividualDetalleReponseItemsDtoToTareaLocalizacionVenta(
                            dto.getVentaIndividualDetalle(), tarea, TipoDatoEnum.IMPORTE_VENTA_FISICA_INDIVIDUAL_LOCALIZACION_SECCION.getId(), TipoDatoEnum.IMPORTE_VENTA_FISICA_INDIVIDUAL_LOCALIZACION.getId()))));
        }
        return result;
    }

    @Override
    public void updateActivoVentaOnlineIpod(@Valid TareaDto tarea) {
        tareaLocalizacionVentaRepositoryCustom.updateActivo(tarea,
            TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION,
            TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION,
            TipoConceptoVenta.IPOD);
    }

    @Override
    public void updateActivoVentaOnlinePicking(@Valid TareaDto tarea) {
        tareaLocalizacionVentaRepositoryCustom.updateActivo(tarea,
            TipoDatoEnum.IMPORTE_VENTA_ONLINE_SINT_LOCALIZACION,
            TipoDatoEnum.IMPORTE_VENTA_ONLINE_SINT_LOCALIZACION_SECCION,
            TipoConceptoVenta.SINT);
    }

    @Override
    public void updateActivoVentaOnlineEntregaTienda(@Valid TareaDto tarea) {
        tareaLocalizacionVentaRepositoryCustom.updateActivo(tarea,
            TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION,
            TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_LOCALIZACION_SECCION,
            TipoConceptoVenta.ENTREGA_TIENDA);
    }

}
