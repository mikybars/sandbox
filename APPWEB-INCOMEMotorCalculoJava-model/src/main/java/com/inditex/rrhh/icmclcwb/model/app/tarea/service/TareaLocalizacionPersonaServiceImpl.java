package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionPersonaServiceImpl implements TareaLocalizacionPersonaService {
    
    @Autowired
    private TareaLocalizacionPersonaRepositoryCustom tareaLocalizacionPersonaRepositoryCustom;
    
    @Autowired
    private TareaLocalizacionPersonaMapper tareaLocalizacionPersonaMapper;
    
    @Override
    public void save(@NotNull final PtrPresenciaEmpleadosTiendaResponseDto src, @NotNull final TareaDto tareaDto) {
        tareaLocalizacionPersonaRepositoryCustom.save(
                tareaLocalizacionPersonaMapper.presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersona(src.getPresenciasEmpleadosTienda(), tareaDto));
    }
    
    @Override
    public void mergePersonaLocalizacion(@NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPersonaRepositoryCustom.mergePersonaLocalizacion(runTareaDto);
    }
}
