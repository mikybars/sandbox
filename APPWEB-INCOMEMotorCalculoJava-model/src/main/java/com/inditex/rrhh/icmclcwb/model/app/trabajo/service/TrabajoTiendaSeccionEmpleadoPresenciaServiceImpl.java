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
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoTiendaSeccionEmpleadoPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionEmpleadoPresencia;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaSeccionEmpleadoPresenciaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaSeccionEmpleadoPresenciaRepositoryCustom;

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
    public CompletableFuture<Void> save(List<PtrPresenciaDetalleResultItemDto> dtos, TrabajoDto trabajoDto) throws Exception {
        List<TrabajoTiendaSeccionEmpleadoPresencia> result = mapper
                .presenciasDetalleResponsesDtoToTrabajoTiendaSeccionVentas(dtos, trabajoDto);
        trabajoTiendaSeccionEmpleadoPresenciaRepositoryCustom.save(result);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
