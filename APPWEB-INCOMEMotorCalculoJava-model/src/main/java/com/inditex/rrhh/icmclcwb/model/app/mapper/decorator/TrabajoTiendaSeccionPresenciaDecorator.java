package com.inditex.rrhh.icmclcwb.model.app.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaSeccionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionPresencia;

public abstract class TrabajoTiendaSeccionPresenciaDecorator extends TrabajoTiendaSeccionPresenciaMapper {

    @Autowired
    private TrabajoTiendaSeccionPresenciaMapper delegate;

    @Override
    public List<TrabajoTiendaSeccionPresencia> presenciasTotalTiendaSeccionResponseDtosDtoToTrabajoTiendaSeccionPresencias(
            List<PtrPresenciaTotalTiendaSeccionResultItemDto> src, TrabajoDto trabajoDto) {
        List<TrabajoTiendaSeccionPresencia> dtoList = new ArrayList<>();
        for (PtrPresenciaTotalTiendaSeccionResultItemDto childDto : src) {
            TrabajoTiendaSeccionPresencia dto = delegate.presenciasTotalTiendaSeccionResponseDtoToTrabajoTiendaSeccionPresencia(childDto,
                    trabajoDto);
            dtoList.add(dto);
        }

        return dtoList;
    }

}
