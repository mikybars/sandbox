package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaEmpleadoPresenciaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaEmpleadoPresenciaSeccionService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaEmpleadoPresenciaSeccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaEmpleadoPresenciaSeccionRepositoryCustom;

@Service
@Validated
public class TareaTiendaEmpleadoPresenciaSeccionServiceImpl implements TareaTiendaEmpleadoPresenciaSeccionService{

    @Autowired
    private TareaTiendaEmpleadoPresenciaSeccionMapper mapper;

    @Autowired
    private TareaTiendaEmpleadoPresenciaSeccionRepositoryCustom tareaTiendaSeccionEmpleadoPresenciaRepositoryCustom;
    
    @Override
    public List<TareaTiendaEmpleadoPresenciaSeccionDto> save(@Valid final List<PtrPresenciaDetalleComisionableResultItemDto> dtos, @Valid final TareaDto tareaDto) {
       return mapper.tareaTiendaEmpleadoPresenciaSeccionToTareaTiendaEmpleadoPresenciaSeccionDto(
        tareaTiendaSeccionEmpleadoPresenciaRepositoryCustom.save(mapper
                .presenciasDetalleComisionableResponseDtoToTareaTiendaEmpleadoPresenciaSeccion(dtos, tareaDto)));
    }
}
