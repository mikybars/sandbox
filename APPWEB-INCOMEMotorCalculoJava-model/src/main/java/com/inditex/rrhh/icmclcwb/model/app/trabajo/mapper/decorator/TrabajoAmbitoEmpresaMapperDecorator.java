package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoAmbitoEmpresa;

public abstract class TrabajoAmbitoEmpresaMapperDecorator extends TrabajoAmbitoEmpresaMapper {

    @Autowired
    private TrabajoAmbitoEmpresaMapper delegate;

    @Override
    public List<TrabajoAmbitoEmpresa> mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTrabajoAmbitoEmpresa(
            List<TrabajoAmbitoEmpresaDto> srcTrabajoAmbitoEmpresa, TrabajoDto srcTrabajo) {
        List<TrabajoAmbitoEmpresa> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(srcTrabajoAmbitoEmpresa)) {
            srcTrabajoAmbitoEmpresa.forEach(item -> result
                .add(delegate.mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTrabajoAmbitoEmpresa(item, srcTrabajo)));
        }
        return result;
    }

}
