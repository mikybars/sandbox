package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCadenaPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCadenaPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaCadenaPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCadenaPresencia;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCadenaPresenciaRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class TareaCadenaPresenciaServiceImpl implements TareaCadenaPresenciaService {

    @Autowired
    private TareaCadenaPresenciaRepositoryCustom tareaCadenaPresenciaRepositoryCustom;

    @Autowired
    private TareaCadenaPresenciaMapper tareaCadenaPresenciaMapper;

    @Override
    public List<TareaCadenaPresenciaDto> save(@Valid List<PtrPresenciaTotalizadoResultItemDto> dto, @Valid TareaDto tarea) {
        List<TareaCadenaPresencia> tareaCadenaPresencias = tareaCadenaPresenciaMapper.presenciasTotalizadoResponseDtoToTareaCadenaPresencia(dto, tarea);
        return tareaCadenaPresenciaMapper.tareaCadenaPresenciaToTareaCadenaPresenciaDto(tareaCadenaPresenciaRepositoryCustom.save(tareaCadenaPresencias));
    }

    @Override
    public void updateActivoCadenaByRunTarea(@Valid TareaDto tarea) {
        tareaCadenaPresenciaRepositoryCustom.updateActivo(tarea);
    }
}
