package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionVentaRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class TareaAgrupacionVentaServiceImpl implements TareaAgrupacionVentaService {

    @Autowired
    private TareaAgrupacionVentaRepositoryCustom tareaAgrupacionVentaRepositoryCustom;

    @Autowired
    private TareaAgrupacionVentaMapper tareaAgrupacionVentaMapper;

    @Override
    public void savePtrVentaTotalizadoResponse(@Valid PtrVentaTotalizadoResponseDto dto, @Valid TareaDto tarea,
        @Valid List<TareaAgrupacionCadenasDto> agrupaciones) {
        tareaAgrupacionVentaRepositoryCustom.save(
            tareaAgrupacionVentaMapper.ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(dto.getVentaTotalizado(), tarea, agrupaciones));
    }

    @Override
    public void savePtrVentaOnlineEntregaDomicilioResponse(@Valid PtrVentaOnlineEntregaDomicilioResponseDto dto,
        @Valid TareaDto tarea, @Valid List<TareaAgrupacionCadenasDto> agrupaciones) {
        tareaAgrupacionVentaRepositoryCustom.save(
            tareaAgrupacionVentaMapper.ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(dto.getVentaOnline(), tarea, agrupaciones));
    }

    @Override
    public void updateActivoVentaOnlineEntregaDomicilio(@Valid TareaDto tarea) {
        tareaAgrupacionVentaRepositoryCustom.updateActivo(tarea);
    }
}
