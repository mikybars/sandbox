package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionEmpleadoPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaSeccionEmpleadoPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaSeccionEmpleadoPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaSeccionEmpleadoPresenciaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaSeccionEmpleadoPresenciaRepositoryCustom;

@Service
@Validated
@Deprecated
public class TareaTiendaSeccionEmpleadoPresenciaServiceImpl implements TareaTiendaSeccionEmpleadoPresenciaService {

    @Autowired
    private TareaTiendaSeccionEmpleadoPresenciaMapper mapper;

    @Autowired
    private TareaTiendaSeccionEmpleadoPresenciaRepository tareaTiendaSeccionEmpleadoPresenciaRepository;

    @Autowired
    private TareaTiendaSeccionEmpleadoPresenciaRepositoryCustom tareaTiendaSeccionEmpleadoPresenciaRepositoryCustom;
    
    @Override
    public TareaTiendaSeccionEmpleadoPresenciaDto save(@Valid final TareaTiendaSeccionEmpleadoPresenciaDto dto) {
        return mapper.tareaTiendaSeccionEmpleadoPresenciaToTareaTiendaSeccionEmpleadoPresenciaDto(
                tareaTiendaSeccionEmpleadoPresenciaRepository.save(
                        mapper.tareaTiendaSeccionEmpleadoPresenciaDtoToTareaTiendaSeccionEmpleadoPresencia(dto)));
    }

    @Override
    public List<TareaTiendaSeccionEmpleadoPresenciaDto> save(List<PtrPresenciaDetalleComisionableResultItemDto> dtos, TareaDto tareaDto) {
        return mapper.tareaTiendaSeccionEmpleadoPresenciasToTareaTiendaSeccionEmpleadoPresenciasDto(tareaTiendaSeccionEmpleadoPresenciaRepositoryCustom.save(mapper
                .presenciasDetalleComisionableResponsesDtoToTareaTiendaSeccionEmpleadoPresencia(dtos, tareaDto)));
    }

}
