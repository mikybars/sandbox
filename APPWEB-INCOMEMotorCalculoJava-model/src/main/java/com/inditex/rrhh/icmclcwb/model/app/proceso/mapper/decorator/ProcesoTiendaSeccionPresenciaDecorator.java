package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTiendaSeccionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaPresenciaSeccion;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaSeccionPresencia;

public abstract class ProcesoTiendaSeccionPresenciaDecorator extends ProcesoTiendaSeccionPresenciaMapper {

    @Autowired
    private ProcesoTiendaSeccionPresenciaMapper delegate;

    @Override
    public List<ProcesoTiendaSeccionPresencia> presenciasTotalTiendaSeccionResponseDtoToProcesoTiendaSeccionPresencias(
            List<PtrPresenciaTotalTiendaSeccionResultItemDto> src, ProcesoDto procesoDto) {
        List<ProcesoTiendaSeccionPresencia> dtoList = new ArrayList<>();
        for (PtrPresenciaTotalTiendaSeccionResultItemDto childDto : src) {
            ProcesoTiendaSeccionPresencia dto = delegate.presenciasTotalTiendaSeccionResponseDtoToProcesoTiendaSeccionPresencia(childDto,
                    procesoDto);
            dtoList.add(dto);
        }

        return dtoList;
    }
    
    @Override
    public List<ProcesoTiendaPresenciaSeccion> presenciasTotalTiendaSeccionResponseDtoToProcesoTiendaPresenciaSeccion(
            List<PtrPresenciaTotalTiendaSeccionResultItemDto> src, ProcesoDto procesoDto) {
        List<ProcesoTiendaPresenciaSeccion> dtoList = new ArrayList<>();
        for (PtrPresenciaTotalTiendaSeccionResultItemDto childDto : src) {
            ProcesoTiendaPresenciaSeccion dto = delegate.presenciasTotalTiendaSeccionResponseDtoToProcesoTiendaPresenciaSeccion(childDto,
                    procesoDto);
            dtoList.add(dto);
        }

        return dtoList;
    }
    
}
