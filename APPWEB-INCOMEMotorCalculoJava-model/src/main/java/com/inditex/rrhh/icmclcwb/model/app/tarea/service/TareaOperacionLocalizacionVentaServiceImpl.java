package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaOperacionLocalizacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaOperacionLocalizacionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaOperacionLocalizacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaOperacionLocalizacionVentaRepositoryCustom;

@Service
@Validated
public class TareaOperacionLocalizacionVentaServiceImpl implements TareaOperacionLocalizacionVentaService {

    @Autowired
    private TareaOperacionLocalizacionVentaRepositoryCustom tareaOperacionLocalizacionVentaRepositoryCustom;
    
    @Autowired
    private TareaOperacionLocalizacionVentaMapper tareaOperacionLocalizacionVentaMapper;
    
    @Override
    public List<TareaOperacionLocalizacionVentaDto> savePtrVentaOnlineIpodIndividualDetalleResponse(final PtrVentaOnlineIpodIndividualDetalleResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaOperacionLocalizacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnlineIpodIndividual())) {
            result.addAll(tareaOperacionLocalizacionVentaMapper
                    .tareaOperacionLocalizacionVentaToTareaOperacionLocalizacionVentaDto(tareaOperacionLocalizacionVentaRepositoryCustom.save(
                            tareaOperacionLocalizacionVentaMapper.getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaOperacionLocalizacionVentas(dto.getVentaOnlineIpodIndividual(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaOperacionLocalizacionVentaDto> savePtrVentaIndividualDetalleResponse(final PtrVentaIndividualDetalleResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaOperacionLocalizacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaIndividualDetalle())) {
            result.addAll(tareaOperacionLocalizacionVentaMapper
                    .tareaOperacionLocalizacionVentaToTareaOperacionLocalizacionVentaDto(tareaOperacionLocalizacionVentaRepositoryCustom.save(
                            tareaOperacionLocalizacionVentaMapper.getVentaIndividualDetalleResponseItemsDtoToTareaOperacionLocalizacionVentas(dto.getVentaIndividualDetalle(),
                                    tarea))));
        }
        return result;
    }
    
}
