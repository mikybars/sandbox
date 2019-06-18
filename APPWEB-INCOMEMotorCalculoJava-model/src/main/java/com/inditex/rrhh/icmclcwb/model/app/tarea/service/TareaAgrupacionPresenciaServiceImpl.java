package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionPresencia;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionPresenciaRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class TareaAgrupacionPresenciaServiceImpl implements TareaAgrupacionPresenciaService {

    @Autowired
    private TareaAgrupacionPresenciaRepositoryCustom tareaAgrupacionPresenciaRepositoryCustom;

    @Autowired
    private TareaAgrupacionPresenciaMapper tareaAgrupacionPresenciaMapper;

    @Override
    public void save(@Valid List<PtrPresenciaTotalizadoResultItemDto> dto, @Valid TareaDto tarea,
                                              List<TareaAgrupacionCadenasDto> agrupaciones) {
        List<TareaAgrupacionPresencia> tareaCadenaPresencias =
            tareaAgrupacionPresenciaMapper.presenciasTotalizadoResponseDtoToTareaAgrupacionPresencia(dto, tarea, agrupaciones);
        tareaAgrupacionPresenciaRepositoryCustom.save(tareaCadenaPresencias);
    }

    @Override
    public void updateActivo(@Valid TareaDto tarea) {
        tareaAgrupacionPresenciaRepositoryCustom.updateActivo(tarea);
    }
}
