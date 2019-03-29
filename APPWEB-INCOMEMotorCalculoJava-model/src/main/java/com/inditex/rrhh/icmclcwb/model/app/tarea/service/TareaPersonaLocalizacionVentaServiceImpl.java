package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaLocalizacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaLocalizacionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaLocalizacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaLocalizacionVentaRepositoryCustom;

@Service
@Validated
public class TareaPersonaLocalizacionVentaServiceImpl implements TareaPersonaLocalizacionVentaService {

    @Autowired
    private TareaPersonaLocalizacionVentaRepositoryCustom tareaPersonaLocalizacionVentaRepositoryCustom;
    
    @Autowired
    private TareaPersonaLocalizacionVentaMapper tareaPersonaLocalizacionVentaMapper;
    
    @Override
    public List<TareaPersonaLocalizacionVentaDto> savePtrVentaOnlineIpodIndividualDetalleResponse(final PtrVentaOnlineIpodIndividualDetalleResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaPersonaLocalizacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnlineIpodIndividual())) {
            result.addAll(tareaPersonaLocalizacionVentaMapper
                    .tareaPersonaLocalizacionVentaToTareaPersonaLocalizacionVentaDto(tareaPersonaLocalizacionVentaRepositoryCustom.save(
                            tareaPersonaLocalizacionVentaMapper.getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaPersonaLocalizacionVentas(dto.getVentaOnlineIpodIndividual(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaPersonaLocalizacionVentaDto> savePtrVentaIndividualDetalleResponseDto(final PtrVentaIndividualDetalleResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaPersonaLocalizacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaIndividualDetalle())) {
            result.addAll(tareaPersonaLocalizacionVentaMapper
                    .tareaPersonaLocalizacionVentaToTareaPersonaLocalizacionVentaDto(tareaPersonaLocalizacionVentaRepositoryCustom.save(
                            tareaPersonaLocalizacionVentaMapper.getVentaIndividualDetalleResponseItemsDtoToTareaPersonaLocalizacionVentas(dto.getVentaIndividualDetalle(),
                                    tarea))));
        }
        return result;
    }
    
    
}
