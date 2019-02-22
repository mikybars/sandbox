package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoTipoHoraService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTipoHoraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoTipoHoraRepositoryCustom;

@Service
@Validated
public class ProcesoTipoHoraServiceImpl implements ProcesoTipoHoraService {

    @Autowired
    private ProcesoTipoHoraMapper mapper;
    
    @Autowired
    private ProcesoTipoHoraRepositoryCustom procesoTipoHoraRepositoryCustom;

    @Override
    public CompletableFuture<Void> save(List<PtrPresenciaTiposHorasResultItemDto> dto, ProcesoDto procesoDto) {
        mapper.procesoProcesoTipoHoraListToprocesoTipoHoraDtoList(procesoTipoHoraRepositoryCustom
                .save(mapper.ptrPresenciaTipoHoraResponsesDtoToProcesoTipoHoraDto(dto, procesoDto)));
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
