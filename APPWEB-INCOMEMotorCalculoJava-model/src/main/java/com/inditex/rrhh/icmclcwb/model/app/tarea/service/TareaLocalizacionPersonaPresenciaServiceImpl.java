package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaPresenciaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionPersonaPresenciaServiceImpl implements TareaLocalizacionPersonaPresenciaService {
    
    @Autowired
    TareaLocalizacionPersonaPresenciaRepositoryCustom tareaLocalizacionPersonaPresenciaRepositoryCustom;
    
    @Autowired
    TareaLocalizacionPersonaPresenciaMapper tareaLocalizacionPersonaPresenciaMapper;
    
    @Override
    public void save(@NotNull final PtrPresenciaEmpleadosTiendaResponseDto src, @NotNull final TareaDto tareaDto) {
        tareaLocalizacionPersonaPresenciaRepositoryCustom.save(
                tareaLocalizacionPersonaPresenciaMapper.presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersonaPresencia(src.getPresenciasEmpleadosTienda(), tareaDto));
    }
}
