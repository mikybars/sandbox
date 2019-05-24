package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaEmpleadoSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaEmpleadoSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaEmpleadoSeccionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaEmpleadoSeccionPresencia;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaEmpleadoSeccionPresenciaRepositoryCustom;

@Service
@Validated
public class TareaTiendaEmpleadoSeccionPresenciaServiceImpl implements TareaTiendaEmpleadoSeccionPresenciaService{

    private static final Integer[] SECCIONES = { PtrConstants.SECCION_1, PtrConstants.SECCION_2, PtrConstants.SECCION_3 };
    
    @Autowired
    private TareaTiendaEmpleadoSeccionPresenciaMapper mapper;
    
    @Autowired
    private TareaTiendaEmpleadoSeccionPresenciaRepositoryCustom tareaTiendaEmpleadoSeccionPresenciaRepositoryCustom;
    
    @Override
    public List<TareaTiendaEmpleadoSeccionPresenciaDto> save(@Valid List<PtrPresenciaDetalleResultItemDto> dtos,
            @Valid TareaDto tareaDto) {
        List<TareaTiendaEmpleadoSeccionPresenciaDto> result = new ArrayList<>();
        if (dtos != null && CollectionUtils.isNotEmpty(dtos)) {
            List<TareaTiendaEmpleadoSeccionPresencia> toSave = new ArrayList<>();
            for (Integer seccion : SECCIONES) {
                List<TareaTiendaEmpleadoSeccionPresencia> presencias = mapper
                        .presenciasDetalleResponseDtoToTareaTiendaEmpleadoSeccionPresencia(dtos, tareaDto, seccion);
                toSave.addAll(presencias.stream().filter(x -> x.getMinutos() != 0).collect(Collectors.toList()));
            }
            result.addAll(mapper.tareaTiendaEmpleadoSeccionPresenciaToTareaTiendaEmpleadoSeccionPresenciaDto(
                    tareaTiendaEmpleadoSeccionPresenciaRepositoryCustom.save(toSave)));
        }
        return result;
    }

}
