package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaVentaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaVentaSeccionService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaVentaSeccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaVentaSeccionRepositoryCustom;

@Service
@Validated
public class TareaTiendaVentaSeccionServiceImpl implements TareaTiendaVentaSeccionService {
    
    @Autowired
    private TareaTiendaVentaSeccionRepositoryCustom tareaTiendaVentaSeccionRepository;
    
    @Autowired
    private TareaTiendaVentaSeccionMapper tareaTiendaVentaSeccionMapper;

    @Override
    public void pivot(@Valid final TareaDto tareaDto) {
        tareaTiendaVentaSeccionRepository.save(tareaDto);
    }
    
    @Override
    public List<TareaTiendaVentaSeccionDto> savePtrVentaTotalizadoResponse(final PtrVentaTotalizadoResponseDto dto,
            final TareaDto tarea) {
        List<TareaTiendaVentaSeccionDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaTotalizado())) {
            result.addAll(tareaTiendaVentaSeccionMapper
                    .tareaTiendaVentaSeccionToTareaTiendaVentaSeccionDto(tareaTiendaVentaSeccionRepository.save(
                            tareaTiendaVentaSeccionMapper.getVentaTotalizadoResponseItemDtoToTareaTiendaVentaSeccion(dto.getVentaTotalizado(),
                                    tarea))));
        }
        return result;
    }
}
