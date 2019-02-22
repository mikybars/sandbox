package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoTiendaSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTiendaSeccionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoTiendaSeccionPresenciaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoTiendaSeccionPresenciaRepositoryCustom;

@Service
@Validated
public class ProcesoTiendaSeccionPresenciaServiceImpl implements ProcesoTiendaSeccionPresenciaService {

    @Autowired
    private ProcesoTiendaSeccionPresenciaMapper mapper;

    @Autowired
    private ProcesoTiendaSeccionPresenciaRepository procesoTiendaSeccionPresenciaRepository;

    @Autowired
    private ProcesoTiendaSeccionPresenciaRepositoryCustom procesoTiendaSeccionPresenciaRepositoryCustom;
    
    @Override
    public CompletableFuture<Void> save(@Valid final ProcesoTiendaSeccionPresenciaDto dto) {
        mapper.procesoTiendaSeccionPresenciaToProcesoTiendaSeccionPresenciaDto(procesoTiendaSeccionPresenciaRepository
                .save(mapper.procesoTiendaSeccionPresenciaDtoToProcesoTiendaSeccionPresencia(dto)));
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> save(List<PtrPresenciaTotalTiendaSeccionResultItemDto> dto, ProcesoDto proceso) {
        mapper.procesoTiendaSeccionPresenciasToProcesoTiendaSeccionPresenciasDto(procesoTiendaSeccionPresenciaRepositoryCustom
                .save(mapper.presenciasTotalTiendaSeccionResponseDtosDtoToProcesoTiendaSeccionPresencias(dto, proceso)));
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
