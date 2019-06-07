package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionOperacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionOperacionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionOperacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionOperacionVentaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionOperacionVentaServiceImpl implements TareaLocalizacionOperacionVentaService {

    @Autowired
    private TareaLocalizacionOperacionVentaRepositoryCustom tareaLocalizacionOperacionVentaRepositoryCustom;
    
    @Autowired
    private TareaLocalizacionOperacionVentaMapper tareaLocalizacionOperacionVentaMapper;
    
    @Override
    public List<TareaLocalizacionOperacionVentaDto> savePtrVentaOnlineIpodIndividualDetalleResponse(@Valid final PtrVentaOnlineIpodIndividualDetalleResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaLocalizacionOperacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaOnlineIpodIndividual())) {
            result.addAll(tareaLocalizacionOperacionVentaMapper
                    .tareaLocalizacionOperacionVentaToTareaLocalizacionOperacionVentaDto(tareaLocalizacionOperacionVentaRepositoryCustom.save(
                            tareaLocalizacionOperacionVentaMapper.getVentaOnlineIpodIndividualDetalleResponseItemsDtoToTareaLocalizacionOperacionVentas(dto.getVentaOnlineIpodIndividual(),
                                    tarea))));
        }
        return result;
    }
    
    @Override
    public List<TareaLocalizacionOperacionVentaDto> savePtrVentaIndividualDetalleResponse(@Valid final PtrVentaIndividualDetalleResponseDto dto,
            @Valid final TareaDto tarea) {
        List<TareaLocalizacionOperacionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaIndividualDetalle())) {
            result.addAll(tareaLocalizacionOperacionVentaMapper
                    .tareaLocalizacionOperacionVentaToTareaLocalizacionOperacionVentaDto(tareaLocalizacionOperacionVentaRepositoryCustom.save(
                            tareaLocalizacionOperacionVentaMapper.getVentaIndividualDetalleResponseItemsDtoToTareaLocalizacionOperacionVentas(dto.getVentaIndividualDetalle(),
                                    tarea))));
        }
        return result;
    }
    
}
