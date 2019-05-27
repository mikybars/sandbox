package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoLocalizacionPersonaPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoLocalizacionPersonaPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoLocalizacionPersonaPresenciaRepositoryCustom;

@Service
@Validated
public class TareaAmbitoLocalizacionPersonaPresenciaServiceImpl implements TareaAmbitoLocalizacionPersonaPresenciaService {

    @Autowired
    private TareaAmbitoLocalizacionPersonaPresenciaRepositoryCustom tareaLocalizacionPersonaPresenciaRepositoryCustom;

    @Autowired
    private TareaAmbitoLocalizacionPersonaPresenciaMapper tareaLocalizacionPersonaPresenciaMapper;

    @Override
    public void save(@NotNull final PtrPresenciaEmpleadosTiendaResponseDto src, @NotNull final TareaDto tareaDto) {
        tareaLocalizacionPersonaPresenciaRepositoryCustom.save(tareaLocalizacionPersonaPresenciaMapper
                .presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersonaPresencia(
                        src.getPresenciasEmpleadosTienda(), tareaDto));
    }

}
