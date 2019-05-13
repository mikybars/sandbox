package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPeriodoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPeriodoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPeriodoRepositoryCustom;

@Service
@Validated
public class TareaPeriodoServiceImpl implements TareaPeriodoService {

    @Autowired
    private TareaPeriodoRepositoryCustom tareaPeriodoRepositoryCustom;
    
    @Autowired
    private TareaPeriodoMapper tareaPeriodoMapper;
    
    
    @Override
    public void save(@NotNull final List<PeriodosResultItemDto> src, @NotNull final TareaDto tareaDto) {
        tareaPeriodoRepositoryCustom.save(tareaPeriodoMapper
                .periodosResultItemDtoToTareaPeriodo(src, tareaDto));
    }
}
