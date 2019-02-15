package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaSeccionEmpleadoPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoTiendaSeccionEmpleadoPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoTiendaSeccionEmpleadoPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoTiendaSeccionEmpleadoPresencia;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoTiendaSeccionEmpleadoPresenciaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoTiendaSeccionEmpleadoPresenciaRepositoryCustom;

@Service
@Validated
public class TrabajoTiendaSeccionEmpleadoPresenciaServiceImpl implements TrabajoTiendaSeccionEmpleadoPresenciaService {

    @Autowired
    private TrabajoTiendaSeccionEmpleadoPresenciaMapper mapper;

    @Autowired
    private TrabajoTiendaSeccionEmpleadoPresenciaRepository trabajoTiendaSeccionEmpleadoPresenciaRepository;

    @Autowired
    private TrabajoTiendaSeccionEmpleadoPresenciaRepositoryCustom trabajoTiendaSeccionEmpleadoPresenciaRepositoryCustom;
    
    @Override
    public CompletableFuture<Void> save(@Valid final TrabajoTiendaSeccionEmpleadoPresenciaDto dto) {
        mapper.trabajoTiendaSeccionEmpleadoPresenciaToTrabajoTiendaSeccionEmpleadoPresenciaDto(
                trabajoTiendaSeccionEmpleadoPresenciaRepository.save(
                        mapper.trabajoTiendaSeccionEmpleadoPresenciaDtoToTrabajoTiendaSeccionEmpleadoPresencia(dto)));
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> save(List<PtrPresenciaDetalleComisionableResultItemDto> dtos, TrabajoDto trabajoDto) {
        List<TrabajoTiendaSeccionEmpleadoPresencia> result = mapper
                .presenciasDetalleComisionableResponsesDtoToTrabajoTiendaSeccionVentas(dtos, trabajoDto);
        trabajoTiendaSeccionEmpleadoPresenciaRepositoryCustom.save(result);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    

}
