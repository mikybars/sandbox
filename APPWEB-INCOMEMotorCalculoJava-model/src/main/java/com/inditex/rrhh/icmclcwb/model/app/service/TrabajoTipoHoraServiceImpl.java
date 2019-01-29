package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTipoHoraService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTipoHoraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTipoHoraRepositoryCustom;

@Service
@Validated
public class TrabajoTipoHoraServiceImpl implements TrabajoTipoHoraService {

    @Autowired
    private TrabajoTipoHoraMapper mapper;
    
    @Autowired
    private TrabajoTipoHoraRepositoryCustom trabajoTipoHoraRepositoryCustom;

    @Override
    public CompletableFuture<Void> save(List<PtrPresenciaTiposHorasResultItemDto> dto, TrabajoDto trabajoDto) throws Exception {
        mapper.trabajoTrabajoTipoHoraListTotrabajoTipoHoraDtoList(trabajoTipoHoraRepositoryCustom
                .save(mapper.ptrPresenciaTipoHoraResponsesDtoToTrabajoTipoHoraDto(dto, trabajoDto)));
        return CompletableFuture.completedFuture(null);
    }

}
