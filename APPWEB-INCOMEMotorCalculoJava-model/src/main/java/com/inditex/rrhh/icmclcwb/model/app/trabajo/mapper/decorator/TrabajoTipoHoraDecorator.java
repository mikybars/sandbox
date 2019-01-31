package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoTipoHoraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTipoHora;

public abstract class TrabajoTipoHoraDecorator extends TrabajoTipoHoraMapper {

    @Autowired
    private TrabajoTipoHoraMapper delegate;

    @Override
    public List<TrabajoTipoHora> ptrPresenciaTipoHoraResponsesDtoToTrabajoTipoHoraDto(
            List<PtrPresenciaTiposHorasResultItemDto> src, TrabajoDto trabajoDto) {
        List<TrabajoTipoHora> dtoList = new ArrayList<>();
        for (PtrPresenciaTiposHorasResultItemDto childDto : src) {
            TrabajoTipoHora dto = delegate.ptrPresenciasMockTiposHorasResponseDtoToTrabajoTipoHoraDto(childDto,
                    trabajoDto);
            dtoList.add(dto);
        }

        return dtoList;
    }
}
