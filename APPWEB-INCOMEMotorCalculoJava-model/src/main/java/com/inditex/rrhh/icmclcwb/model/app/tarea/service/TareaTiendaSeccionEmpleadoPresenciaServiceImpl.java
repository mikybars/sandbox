package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionEmpleadoPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaSeccionEmpleadoPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaSeccionEmpleadoPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaSeccionEmpleadoPresencia;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaSeccionEmpleadoPresenciaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaSeccionEmpleadoPresenciaRepositoryCustom;

@Service
@Validated
public class TareaTiendaSeccionEmpleadoPresenciaServiceImpl implements TareaTiendaSeccionEmpleadoPresenciaService {

    @Autowired
    private TareaTiendaSeccionEmpleadoPresenciaMapper mapper;

    @Autowired
    private TareaTiendaSeccionEmpleadoPresenciaRepository tareaTiendaSeccionEmpleadoPresenciaRepository;

    @Autowired
    private TareaTiendaSeccionEmpleadoPresenciaRepositoryCustom tareaTiendaSeccionEmpleadoPresenciaRepositoryCustom;
    
    @Override
    public CompletableFuture<Void> save(@Valid final TareaTiendaSeccionEmpleadoPresenciaDto dto) {
        mapper.tareaTiendaSeccionEmpleadoPresenciaToTareaTiendaSeccionEmpleadoPresenciaDto(
                tareaTiendaSeccionEmpleadoPresenciaRepository.save(
                        mapper.tareaTiendaSeccionEmpleadoPresenciaDtoToTareaTiendaSeccionEmpleadoPresencia(dto)));
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> save(List<PtrPresenciaDetalleComisionableResultItemDto> dtos, TareaDto tareaDto) {
        List<TareaTiendaSeccionEmpleadoPresencia> result = mapper
                .presenciasDetalleComisionableResponsesDtoToTareaTiendaSeccionVentas(dtos, tareaDto);
        tareaTiendaSeccionEmpleadoPresenciaRepositoryCustom.save(result);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    

}
