package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCadenaVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaCadenaVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCadenaVentaRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class TareaCadenaVentaServiceImpl implements TareaCadenaVentaService {

    @Autowired
    private TareaCadenaVentaRepositoryCustom tareaCadenaVentaRespositoryCustom;

    @Autowired
    private TareaCadenaVentaMapper tareaCadenaVentaMapper;

    @Override
    public void savePtrVentaTotalizadoResponse(@Valid PtrVentaTotalizadoResponseDto dto, @Valid TareaDto tarea) {
        tareaCadenaVentaRespositoryCustom.save(
            tareaCadenaVentaMapper.ventaTotalizadoResponseItemDtoToTareaCadenaVenta(dto.getVentaTotalizado(), tarea));
    }

    @Override
    public void savePtrVentaOnlineEntregaDomicilioResponse(@Valid PtrVentaOnlineEntregaDomicilioResponseDto dto,
        @Valid TareaDto tarea) {
        tareaCadenaVentaRespositoryCustom.save(
            tareaCadenaVentaMapper.ventaOnlineEntregaDomicilioResultItemDtoToTareaCadenaVenta(dto.getVentaOnline(), tarea));
    }

    @Override
    public void updateActivoVentaOnlineEntregaDomicilio(@Valid TareaDto tarea) {
        tareaCadenaVentaRespositoryCustom.updateActivoVentaOnlineEntregaDomicilio(tarea);
    }
}
