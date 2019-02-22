package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTienda;

public abstract class ProcesoTiendaDecorator extends ProcesoTiendaMapper {

    @Autowired
    private ProcesoTiendaMapper delegate;

    @Override
    public List<ProcesoTienda> mergeProcesoTiendaDtoAndProcesoDtoToProcesoTienda(List<ProcesoTiendaDto> src,
            ProcesoDto proceso) {
        List<ProcesoTienda> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> result.add(delegate.mergeProcesoTiendaDtoAndProcesoDtoToProcesoTienda(item, proceso)));
        }
        return result;
    }
}
