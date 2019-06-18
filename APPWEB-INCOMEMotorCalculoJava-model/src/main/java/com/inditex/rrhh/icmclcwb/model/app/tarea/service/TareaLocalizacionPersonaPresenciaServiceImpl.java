package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaPresenciaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaPresenciaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionPersonaPresenciaServiceImpl
        implements TareaLocalizacionPersonaPresenciaService {
    
    @Autowired
    private TareaLocalizacionPersonaPresenciaRepositoryCustom tareaLocalizacionPersonaPresenciaRepositoryCustom;

    @Autowired
    private TareaLocalizacionPersonaPresenciaMapper tareaLocalizacionPersonaPresenciaMapper;
    
    @Override
    public void save(@NotNull final List<GenericEmpleadoResultItemDto> src, @NotNull final TareaDto tareaDto) {
        tareaLocalizacionPersonaPresenciaRepositoryCustom.save(tareaLocalizacionPersonaPresenciaMapper
                .genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(src, tareaDto));
    }
    
    @Override
    public void savePtrPresenciaDetalle(@NotNull final List<PtrPresenciaDetalleResultItemDto> src, @NotNull final TareaDto tareaDto) {
        tareaLocalizacionPersonaPresenciaRepositoryCustom.save(tareaLocalizacionPersonaPresenciaMapper
                .presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(src, tareaDto));
    }
    
    @Override
    public void updateActivo(@NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivo(runTareaDto);
    }
    
    @Override
    public void updateActivoTotalizado(@NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivoTotalizado(runTareaDto);
    }
    
    @Override
    public void compensar(@NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPersonaPresenciaRepositoryCustom.compensar(runTareaDto);
    }
}
