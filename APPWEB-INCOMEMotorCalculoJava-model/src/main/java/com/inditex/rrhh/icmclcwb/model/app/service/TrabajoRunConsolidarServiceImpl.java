package com.inditex.rrhh.icmclcwb.model.app.service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.LongStream;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajo;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunConsolidarService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants.EstadoTrabajoEnum;

@Service
@Validated
public class TrabajoRunConsolidarServiceImpl implements TrabajoRunConsolidarService {

    @Autowired
    private TrabajoService trabajoService;

    @AuditoriaTrabajo
    @Override
    public TrabajoDto run(@Valid final TrabajoDto trabajo) throws Exception {
        if (EstadoTrabajoEnum.PENDIENTE_CONSOLIDACION.getId().equals(trabajo.getEstado().getId())) {
            trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.EN_CURSO_CONSOLIDACION.getDto(), trabajo);
            Random random = new Random();
            LongStream ls = random.longs(1000, 5000);
            long time = ls.findFirst().getAsLong();
            ls.close();
            Thread.sleep(time);
            trabajo.setFechaFinTrabajo(LocalDateTime.now());
            trabajo.setEstado(EstadoTrabajoEnum.FINALIZADO_SIN_ERRORES.getDto());
            trabajoService.modifyTrabajo(trabajo);
        }
        return trabajo;
    }

}