package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaSeccionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaSeccionPresenciaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionPersonaSeccionPresenciaServiceImpl
        implements TareaLocalizacionPersonaSeccionPresenciaService {
    
    @Autowired
    private TareaLocalizacionPersonaSeccionPresenciaRepositoryCustom tareaLocalizacionPersonaSeccionPresenciaRepositoryCustom;

    @Autowired
    private TareaLocalizacionPersonaSeccionPresenciaMapper tareaLocalizacionPersonaSeccionPresenciaMapper;
    
    @Override
    public void save(@NotNull final List<GenericEmpleadoResultItemDto> src, @NotNull final TareaDto tareaDto) {
        tareaLocalizacionPersonaSeccionPresenciaRepositoryCustom.save(tareaLocalizacionPersonaSeccionPresenciaMapper
                .genericEmpleadoResultItemDtoToTareaLocalizacionPersonaSeccionPresencia(src, tareaDto));
    }
    
    @Override
    public void savePtrPresenciaDetalle(@NotNull final List<PtrPresenciaDetalleResultItemDto> src, @NotNull final TareaDto tareaDto) {
        tareaLocalizacionPersonaSeccionPresenciaRepositoryCustom.save(tareaLocalizacionPersonaSeccionPresenciaMapper
                .presenciasDetalleResponseDtoToTareaLocalizacionPersonaSeccionPresencia(src, tareaDto));
    }
    
    @Override
    public void updateActivo(@NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPersonaSeccionPresenciaRepositoryCustom.updateActivo(runTareaDto);
    }
    
}
