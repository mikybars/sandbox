package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaOperacionPersonaLocalizacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaOperacionPersonaLocalizacionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaOperacionPersonaLocalizacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaOperacionPersonaLocalizacionVentaRepositoryCustom;

@Service
@Validated
public class TareaOperacionPersonaLocalizacionVentaServiceImpl
        implements TareaOperacionPersonaLocalizacionVentaService {

    @Autowired
    private TareaOperacionPersonaLocalizacionVentaRepositoryCustom tareaOperacionPersonaLocalizacionVentaRepositoryCustom;
    
    @Autowired
    private TareaOperacionPersonaLocalizacionVentaMapper tareaOperacionPersonaLocalizacionVentaMapper;
    
    @Override
    public List<TareaOperacionPersonaLocalizacionVentaDto> savePtrVentaIndividualDetalleResponse(@Valid final PtrVentaIndividualDetalleResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaOperacionPersonaLocalizacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaIndividualDetalle())) {
            result.addAll(tareaOperacionPersonaLocalizacionVentaMapper
                    .tareaOperacionPersonaLocalizacionVentaToTareaOperacionPersonaLocalizacionVentaDto(tareaOperacionPersonaLocalizacionVentaRepositoryCustom.save(
                            tareaOperacionPersonaLocalizacionVentaMapper.getVentaIndividualDetalleResponseItemsDtoToTareaOperacionLocalizacionVentas(dto.getVentaIndividualDetalle(),
                                    tarea))));
        }
        return result;
    }
}
