package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPersonaOperacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaOperacionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaOperacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaOperacionVentaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionPersonaOperacionVentaServiceImpl
        implements TareaLocalizacionPersonaOperacionVentaService {

    @Autowired
    private TareaLocalizacionPersonaOperacionVentaRepositoryCustom tareaLocalizacionPersonaOperacionVentaRepositoryCustom;
    
    @Autowired
    private TareaLocalizacionPersonaOperacionVentaMapper tareaLocalizacionPersonaOperacionVentaMapper;
    
    @Override
    public List<TareaLocalizacionPersonaOperacionVentaDto> savePtrVentaIndividualDetalleResponse(@Valid final PtrVentaIndividualDetalleResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaLocalizacionPersonaOperacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaIndividualDetalle())) {
            result.addAll(tareaLocalizacionPersonaOperacionVentaMapper
                    .tareaLocalizacionPersonaOperacionVentaToTareaLocalizacionPersonaOperacionVentaDto(tareaLocalizacionPersonaOperacionVentaRepositoryCustom.save(
                            tareaLocalizacionPersonaOperacionVentaMapper.getVentaIndividualDetalleResponseItemsDtoToTareaLocalizacionPersonaOperacionVentas(dto.getVentaIndividualDetalle(),
                                    tarea))));
        }
        return result;
    }
}
