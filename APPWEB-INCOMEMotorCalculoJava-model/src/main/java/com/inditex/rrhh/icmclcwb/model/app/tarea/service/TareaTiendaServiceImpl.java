package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaRepository;

@Service
@Validated
public class TareaTiendaServiceImpl implements TareaTiendaService {

    @Autowired
    private TareaTiendaRepository tareaTiendaRepository;

    @Autowired
    private TareaTiendaMapper tareaTiendaMapper;

    @Override
    public List<TareaTiendaDto> findByTarea(@Valid @NotNull final TareaDto tarea) {
        return tareaTiendaMapper
                .tareaTiendaToTareaTiendaDto(tareaTiendaRepository.findByTareaId(tarea.getId()));
    }

    @Override
    public List<TareaTiendaDto> createTareaTienda(@Valid @NotNull TareaDto tarea,
            @NotNull List<TareaTiendaDto> tareaTienda) {
        return tareaTiendaMapper.tareaTiendaToTareaTiendaDto(tareaTiendaRepository
                .saveAll(tareaTiendaMapper.mergeTareaTiendaDtoAndTareaDtoToTareaTienda(tareaTienda, tarea)));
    }

}