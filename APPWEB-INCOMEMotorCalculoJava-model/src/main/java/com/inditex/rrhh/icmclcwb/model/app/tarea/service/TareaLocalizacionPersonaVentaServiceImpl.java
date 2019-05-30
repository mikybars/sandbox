package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPersonaVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaVentaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionPersonaVentaServiceImpl implements TareaLocalizacionPersonaVentaService {

    @Autowired
    private TareaLocalizacionPersonaVentaRepositoryCustom tareaLocalizacionPersonaVentaRepositoryCustom;
    
    @Autowired
    private TareaLocalizacionPersonaVentaMapper tareaLocalizacionPersonaVentaMapper;
    
    @Override
    public List<TareaLocalizacionPersonaVentaDto> savePtrVentaOnlineIpodIndividualDetalleResponse(@Valid final PtrVentaOnlineIpodIndividualDetalleResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaLocalizacionPersonaVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnlineIpodIndividual())) {
            result.addAll(tareaLocalizacionPersonaVentaMapper
                    .tareaLocalizacionPersonaVentaToTareaLocalizacionPersonaVentaDto(tareaLocalizacionPersonaVentaRepositoryCustom.save(
                            tareaLocalizacionPersonaVentaMapper.getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaLocalizacionPersonaVentas(dto.getVentaOnlineIpodIndividual(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaLocalizacionPersonaVentaDto> savePtrVentaIndividualDetalleResponseDto(@Valid final PtrVentaIndividualDetalleResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaLocalizacionPersonaVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaIndividualDetalle())) {
            result.addAll(tareaLocalizacionPersonaVentaMapper
                    .tareaLocalizacionPersonaVentaToTareaLocalizacionPersonaVentaDto(tareaLocalizacionPersonaVentaRepositoryCustom.save(
                            tareaLocalizacionPersonaVentaMapper.getVentaIndividualDetalleResponseItemsDtoToTareaLocalizacionPersonaVentas(dto.getVentaIndividualDetalle(),
                                    tarea))));
        }
        return result;
    }
    
    
}
