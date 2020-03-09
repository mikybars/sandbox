package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresupuestoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresupuestoRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class TareaLocalizacionPresupuestoServiceImpl implements TareaLocalizacionPresupuestoService {

    @Autowired
    private TareaLocalizacionPresupuestoRepositoryCustom tareaLocalizacionPresupuestoRepositoryCustom;

    @Autowired
    private TareaLocalizacionPresupuestoMapper tareaLocalizacionPresupuestoMapper;

    @Override
    public void save(List<PresupuestosWlocResultItemDto> src, TareaDto tarea) {
        tareaLocalizacionPresupuestoRepositoryCustom.save(
            tareaLocalizacionPresupuestoMapper.presupuestosWlocResultItemDtoToTareaLocalizacionPresupuesto(src, tarea));
    }
}
