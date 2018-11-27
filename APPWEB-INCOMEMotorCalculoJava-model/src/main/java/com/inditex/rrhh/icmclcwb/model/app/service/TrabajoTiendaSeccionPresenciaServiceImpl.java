package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaSeccionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaSeccionPresenciaRepository;

@Service
@Validated
public class TrabajoTiendaSeccionPresenciaServiceImpl implements TrabajoTiendaSeccionPresenciaService {

    @Autowired
    private TrabajoTiendaSeccionPresenciaMapper mapper;

    @Autowired
    private TrabajoTiendaSeccionPresenciaRepository trabajoTiendaSeccionPresenciaRepository;

    @Override
    public CompletableFuture<Void> save(@Valid final TrabajoTiendaSeccionPresenciaDto dto) {
        mapper.trabajoTiendaSeccionPresenciaToTrabajoTiendaSeccionPresenciaDto(trabajoTiendaSeccionPresenciaRepository
                .save(mapper.trabajoTiendaSeccionPresenciaDtoToTrabajoTiendaSeccionPresencia(dto)));
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public CompletableFuture<Void> save(List<PtrPresenciaTotalTiendaSeccionResultItemDto> dto) {
        mapper.trabajoTiendaSeccionPresenciasToTrabajoTiendaSeccionPresenciasDto(trabajoTiendaSeccionPresenciaRepository
                .save(mapper.presenciasTotalTiendaSeccionResponseDtosDtoToTrabajoTiendaSeccionPresencias(dto)));
        return CompletableFuture.completedFuture(null);
    }
}
