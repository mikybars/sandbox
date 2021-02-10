package com.inditex.rrhh.icmclcwb.model.app.run.mantenimiento.limpieza.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.limpieza.dto.RunMantenimientoLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.limpieza.service.RunMantenimientoLimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.ms.app.limpieza.SenderLimpieza;
import reactor.core.publisher.Flux;

import com.inditex.aqsw.framework.common.reactor.autoconfiguration.ItxSchedulers;

@Service
@Validated
public class RunMantenimientoLimpiezaServiceImpl implements RunMantenimientoLimpiezaService {

    @Autowired
    private TareaService tareaService;

    @Autowired
    private TareaLimpiezaService tareaLimpiezaService;

    @Autowired
    private SenderLimpieza senderLimpieza;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public RunMantenimientoLimpiezaDto run() {
        final RunMantenimientoLimpiezaDto result = this.tareaService.findLimpieza();
        final List<TareaLimpiezaDto> limpiezas = this.tareaLimpiezaService.save(result.getIdTarea());
        Flux.fromIterable(limpiezas)
            .parallel()
            .runOn(ItxSchedulers.single())
            .subscribe(this.senderLimpieza::send);
        return result;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public RunMantenimientoLimpiezaDto runIdTarea(@NotNull final Long id) {
        final RunMantenimientoLimpiezaDto result = this.tareaService.findLimpiezaByIdTarea(id);
        final List<TareaLimpiezaDto> limpiezas = this.tareaLimpiezaService.save(result.getIdTarea());
        Flux.fromIterable(limpiezas)
            .parallel()
            .runOn(ItxSchedulers.single())
            .subscribe(this.senderLimpieza::send);
        return result;
    }

}
