package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoAmbitoLocalizacion;

public abstract class TrabajoAmbitoLocalizacionMapperDecorator extends TrabajoAmbitoLocalizacionMapper {

    @Autowired
    private TrabajoAmbitoLocalizacionMapper delegate;

    @Override
    public List<TrabajoAmbitoLocalizacion> mergeTrabajoAmbitoLocalizacionDtoAndTrabajoDtoToTrabajoAmbitoLocalizacion(
            List<TrabajoAmbitoLocalizacionDto> srcTrabajoAmbitoLocalizacion, TrabajoDto srcTrabajo) {
        List<TrabajoAmbitoLocalizacion> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(srcTrabajoAmbitoLocalizacion)) {
            srcTrabajoAmbitoLocalizacion.forEach(item -> result.add(delegate
                .mergeTrabajoAmbitoLocalizacionDtoAndTrabajoDtoToTrabajoAmbitoLocalizacion(item, srcTrabajo)));
        }
        return result;
    }

}
