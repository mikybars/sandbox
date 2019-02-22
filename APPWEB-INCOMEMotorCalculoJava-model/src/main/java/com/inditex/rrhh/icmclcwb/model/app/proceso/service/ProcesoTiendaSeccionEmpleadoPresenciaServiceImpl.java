package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaSeccionEmpleadoPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoTiendaSeccionEmpleadoPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTiendaSeccionEmpleadoPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaSeccionEmpleadoPresencia;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoTiendaSeccionEmpleadoPresenciaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoTiendaSeccionEmpleadoPresenciaRepositoryCustom;

@Service
@Validated
public class ProcesoTiendaSeccionEmpleadoPresenciaServiceImpl implements ProcesoTiendaSeccionEmpleadoPresenciaService {

    @Autowired
    private ProcesoTiendaSeccionEmpleadoPresenciaMapper mapper;

    @Autowired
    private ProcesoTiendaSeccionEmpleadoPresenciaRepository procesoTiendaSeccionEmpleadoPresenciaRepository;

    @Autowired
    private ProcesoTiendaSeccionEmpleadoPresenciaRepositoryCustom procesoTiendaSeccionEmpleadoPresenciaRepositoryCustom;
    
    @Override
    public CompletableFuture<Void> save(@Valid final ProcesoTiendaSeccionEmpleadoPresenciaDto dto) {
        mapper.procesoTiendaSeccionEmpleadoPresenciaToProcesoTiendaSeccionEmpleadoPresenciaDto(
                procesoTiendaSeccionEmpleadoPresenciaRepository.save(
                        mapper.procesoTiendaSeccionEmpleadoPresenciaDtoToProcesoTiendaSeccionEmpleadoPresencia(dto)));
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> save(List<PtrPresenciaDetalleComisionableResultItemDto> dtos, ProcesoDto procesoDto) {
        List<ProcesoTiendaSeccionEmpleadoPresencia> result = mapper
                .presenciasDetalleComisionableResponsesDtoToProcesoTiendaSeccionVentas(dtos, procesoDto);
        procesoTiendaSeccionEmpleadoPresenciaRepositoryCustom.save(result);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    

}
