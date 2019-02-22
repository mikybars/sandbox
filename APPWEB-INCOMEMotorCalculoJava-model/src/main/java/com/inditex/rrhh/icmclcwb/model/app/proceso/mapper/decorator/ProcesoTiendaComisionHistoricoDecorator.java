package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTiendaComisionHistoricoMapper;

public abstract class ProcesoTiendaComisionHistoricoDecorator extends ProcesoTiendaComisionHistoricoMapper {

    @Autowired
    private ProcesoTiendaComisionHistoricoMapper delegate;

    @Override
    public List<ProcesoTiendaComisionHistoricoDto> genericTiendaResultItemDtoToProcesoTiendaComisionHistoricoDto(
            List<GenericTiendaResultItemDto> src, ProcesoDto proceso) {
        List<ProcesoTiendaComisionHistoricoDto> result = new ArrayList<>();
        
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> result.add(delegate
                    .genericTiendaResultItemDtoToProcesoTiendaComisionHistoricoDto(item, proceso)));
        }
        
        return result;
    }
}
