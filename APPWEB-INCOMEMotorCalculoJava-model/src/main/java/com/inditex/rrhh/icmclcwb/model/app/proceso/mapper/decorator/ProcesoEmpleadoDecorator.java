package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoEmpleadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoEmpleado;

public abstract class ProcesoEmpleadoDecorator extends ProcesoEmpleadoMapper {

    @Autowired
    private ProcesoEmpleadoMapper delegate;

    @Override
    public List<ProcesoEmpleado> mergeProcesoEmpleadoDtoAndProcesoDtoToProcesoEmpleado(List<ProcesoEmpleadoDto> src,
            ProcesoDto proceso) {
        List<ProcesoEmpleado> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(
                    item -> result.add(delegate.mergeProcesoEmpleadoDtoAndProcesoDtoToProcesoEmpleado(item, proceso)));
        }
        return result;
    }

}