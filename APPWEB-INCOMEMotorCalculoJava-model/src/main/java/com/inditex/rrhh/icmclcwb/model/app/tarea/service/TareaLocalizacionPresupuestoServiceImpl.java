package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoListDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresupuestoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresupuestoRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
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

    @Override
    @Cacheable(value = "itx.icmlcwb.presupuestos_by_tarea", key = "{#tarea}")
    public TareaLocalizacionPresupuestoListDto findPresupuestos(@Valid TareaDto tarea) {
        return TareaLocalizacionPresupuestoListDto
            .builder()
            .presupuestos(tareaLocalizacionPresupuestoRepositoryCustom.findPresupuestos(tarea))
            .build();
    }

    @Override
    public void updateActivoBandaExcepcion(@Valid TareaDto tarea) {
        tareaLocalizacionPresupuestoRepositoryCustom.updateActivoBandaExcepcion(tarea);
    }

    @Override
    public void updateActivoBandasSinExcepcion(@Valid TareaDto tarea) {
        tareaLocalizacionPresupuestoRepositoryCustom.updateActivoBandasSinExcepcion(tarea);
    }
}
