package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoVentaService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresupuestoVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresupuestoVentaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionPresupuestoVentaServiceImpl implements TareaLocalizacionPresupuestoVentaService {

    @Autowired
    private TareaLocalizacionPresupuestoVentaRepositoryCustom tareaLocalizacionPresupuestoVentaRepositoryCustom;
    
    @Autowired
    private TareaLocalizacionPresupuestoVentaMapper tareaLocalizacionPresupuestoVentaMapper;
    
    @Override
    public List<TareaLocalizacionPresupuestoVentaDto> save(
            @Valid final List<TareaLocalizacionPresupuestoVentaDto> tareaLocalizacionPresupuestoVenta) {
        return tareaLocalizacionPresupuestoVentaMapper.tareaLocalizacionPresupuestoVentaToTareaLocalizacionPresupuestoVentaDto(
                tareaLocalizacionPresupuestoVentaRepositoryCustom.save(tareaLocalizacionPresupuestoVentaMapper.tareaLocalizacionPresupuestoVentaDtoToTareaLocalizacionPresupuestoVenta(tareaLocalizacionPresupuestoVenta)));
    }
    
}
