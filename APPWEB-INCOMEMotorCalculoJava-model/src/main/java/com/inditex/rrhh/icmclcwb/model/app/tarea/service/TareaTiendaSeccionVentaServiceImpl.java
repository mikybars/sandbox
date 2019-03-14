package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaSeccionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaSeccionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaSeccionVentaRepositoryCustom;

@Service
@Validated
public class TareaTiendaSeccionVentaServiceImpl implements TareaTiendaSeccionVentaService {

    @Autowired
    private TareaTiendaSeccionVentaMapper mapper;

    @Autowired
    private TareaTiendaSeccionVentaRepositoryCustom tareaTiendaSeccionVentaRepositoryCustom;

    @Override
    public List<TareaTiendaSeccionVentaDto> savePtrVentaTotalizadoResponse(final PtrVentaTotalizadoResponseDto dto,
            final TareaDto tarea) {
        List<TareaTiendaSeccionVentaDto> result = new ArrayList<>();
        if (dto != null && CollectionUtils.isNotEmpty(dto.getVentaTotalizado())) {
            result.addAll(mapper
                    .tareaTiendaSeccionVentasToTareaTiendaSeccionVentasDto(tareaTiendaSeccionVentaRepositoryCustom.save(
                            mapper.getVentaTotalizadoReponseItemsDtoToTareaTiendaSeccionVentas(dto.getVentaTotalizado(),
                                    tarea))));
        }
        return result;
    }

}
