package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaEmpleadoHistoricoService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaEmpleadoHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaEmpleadoHistoricoRepositoryCustom;

@Service
@Validated
public class TareaEmpleadoHistoricoServiceImpl implements TareaEmpleadoHistoricoService {

    @Autowired
    private TareaEmpleadoHistoricoRepositoryCustom tareaEmpleadoHistoricoRepositoryCustom;

    @Autowired
    private TareaEmpleadoHistoricoMapper tareaEmpleadoHistoricoMapper;

    @Override
    public List<TareaEmpleadoHistoricoDto> save(final List<TareaEmpleadoHistoricoDto> tareaEmpleadoHistorico , @Valid TareaDto tarea) {
        return tareaEmpleadoHistoricoMapper.tareaEmpleadoHistoricoToTareaEmpleadoHistoricoDto(
                tareaEmpleadoHistoricoRepositoryCustom.save(tareaEmpleadoHistoricoMapper
                        .mergeTareaEmpleadoHistoricoDtoAndTareaDtoToTareaEmpleadoHistorico(tareaEmpleadoHistorico,
                                tarea)));
    }
    
    
}
