package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaSeccionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaSeccionPresenciaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaSeccionPresenciaRepositoryCustom;

@Service
@Validated
public class TareaTiendaSeccionPresenciaServiceImpl implements TareaTiendaSeccionPresenciaService {

    @Autowired
    private TareaTiendaSeccionPresenciaMapper mapper;

    @Autowired
    private TareaTiendaSeccionPresenciaRepository tareaTiendaSeccionPresenciaRepository;

    @Autowired
    private TareaTiendaSeccionPresenciaRepositoryCustom tareaTiendaSeccionPresenciaRepositoryCustom;
    
    @Override
    public CompletableFuture<Void> save(@Valid final TareaTiendaSeccionPresenciaDto dto) {
        mapper.tareaTiendaSeccionPresenciaToTareaTiendaSeccionPresenciaDto(tareaTiendaSeccionPresenciaRepository
                .save(mapper.tareaTiendaSeccionPresenciaDtoToTareaTiendaSeccionPresencia(dto)));
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> save(List<PtrPresenciaTotalTiendaSeccionResultItemDto> dto, TareaDto tarea) {
        mapper.tareaTiendaSeccionPresenciasToTareaTiendaSeccionPresenciasDto(tareaTiendaSeccionPresenciaRepositoryCustom
                .save(mapper.presenciasTotalTiendaSeccionResponseDtoToTareaTiendaSeccionPresencias(dto, tarea)));
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
