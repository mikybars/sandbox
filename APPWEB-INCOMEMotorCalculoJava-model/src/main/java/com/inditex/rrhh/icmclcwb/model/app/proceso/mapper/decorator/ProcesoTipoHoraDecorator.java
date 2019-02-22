package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTipoHoraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTipoHora;

public abstract class ProcesoTipoHoraDecorator extends ProcesoTipoHoraMapper {

    @Autowired
    private ProcesoTipoHoraMapper delegate;

    @Override
    public List<ProcesoTipoHora> ptrPresenciaTipoHoraResponsesDtoToProcesoTipoHoraDto(
            List<PtrPresenciaTiposHorasResultItemDto> src, ProcesoDto procesoDto) {
        List<ProcesoTipoHora> dtoList = new ArrayList<>();
        for (PtrPresenciaTiposHorasResultItemDto childDto : src) {
            ProcesoTipoHora dto = delegate.ptrPresenciasMockTiposHorasResponseDtoToProcesoTipoHoraDto(childDto,
                    procesoDto);
            dtoList.add(dto);
        }

        return dtoList;
    }
}
