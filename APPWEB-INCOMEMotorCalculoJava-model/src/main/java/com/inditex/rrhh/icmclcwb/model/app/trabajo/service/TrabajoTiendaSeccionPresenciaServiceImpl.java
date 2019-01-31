package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoTiendaSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoTiendaSeccionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaSeccionPresenciaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaSeccionPresenciaRepositoryCustom;

@Service
@Validated
public class TrabajoTiendaSeccionPresenciaServiceImpl implements TrabajoTiendaSeccionPresenciaService {

    @Autowired
    private TrabajoTiendaSeccionPresenciaMapper mapper;

    @Autowired
    private TrabajoTiendaSeccionPresenciaRepository trabajoTiendaSeccionPresenciaRepository;

    @Autowired
    private TrabajoTiendaSeccionPresenciaRepositoryCustom trabajoTiendaSeccionPresenciaRepositoryCustom;
    
    @Override
    public CompletableFuture<Void> save(@Valid final TrabajoTiendaSeccionPresenciaDto dto) {
        mapper.trabajoTiendaSeccionPresenciaToTrabajoTiendaSeccionPresenciaDto(trabajoTiendaSeccionPresenciaRepository
                .save(mapper.trabajoTiendaSeccionPresenciaDtoToTrabajoTiendaSeccionPresencia(dto)));
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> save(List<PtrPresenciaTotalTiendaSeccionResultItemDto> dto, TrabajoDto trabajo) throws Exception {
        mapper.trabajoTiendaSeccionPresenciasToTrabajoTiendaSeccionPresenciasDto(trabajoTiendaSeccionPresenciaRepositoryCustom
                .save(mapper.presenciasTotalTiendaSeccionResponseDtosDtoToTrabajoTiendaSeccionPresencias(dto, trabajo)));
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
