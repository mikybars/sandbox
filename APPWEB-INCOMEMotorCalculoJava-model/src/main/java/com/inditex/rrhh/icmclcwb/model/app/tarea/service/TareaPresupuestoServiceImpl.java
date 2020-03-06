package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPresupuestoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPresupuestoRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class TareaPresupuestoServiceImpl implements TareaPresupuestoService {

    @Autowired
    private TareaPresupuestoRepositoryCustom tareaPresupuestoRepositoryCustom;

    @Autowired
    private TareaPresupuestoMapper tareaPresupuestoMapper;

    @Override
    public void save(List<PresupuestosWlocResultItemDto> src, TareaDto tarea) {
        tareaPresupuestoRepositoryCustom.save(
            tareaPresupuestoMapper.presupuestosWlocResultItemDtoToTareaPresupuesto(src, tarea));
    }
}
