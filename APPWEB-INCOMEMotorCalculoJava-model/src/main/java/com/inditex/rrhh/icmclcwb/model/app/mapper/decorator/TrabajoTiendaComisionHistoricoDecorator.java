package com.inditex.rrhh.icmclcwb.model.app.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaComisionHistoricoMapper;

public abstract class TrabajoTiendaComisionHistoricoDecorator extends TrabajoTiendaComisionHistoricoMapper {

    @Autowired
    TrabajoTiendaComisionHistoricoMapper delegate;

    public List<TrabajoTiendaComisionHistoricoDto> genericTiendaResultItemDtoToTrabajoTiendaComisionHistoricoDto(
            List<GenericTiendaResultItemDto> src, TrabajoDto trabajo) {
        List<TrabajoTiendaComisionHistoricoDto> result = new ArrayList<>();
        
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> result.add(delegate
                    .genericTiendaResultItemDtoToTrabajoTiendaComisionHistoricoDto(item, trabajo)));
        }
        
        return result;
    }
}
