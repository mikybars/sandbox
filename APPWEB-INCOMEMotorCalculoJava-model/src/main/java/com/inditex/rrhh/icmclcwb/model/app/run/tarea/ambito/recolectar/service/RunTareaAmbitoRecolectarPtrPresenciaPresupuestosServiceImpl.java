package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrPresenciaPresupuestosService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoListDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.format.DateTimeFormatter;

@Service
@Validated
public class RunTareaAmbitoRecolectarPtrPresenciaPresupuestosServiceImpl
    extends AbstractRunTareaAmbitoRecolectarPtrPresenciaService
    implements RunTareaAmbitoRecolectarPtrPresenciaPresupuestosService {

    @Autowired
    private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

    @Override
    protected String getFechaInicioPeriodo(TareaDto tarea) {
        TareaLocalizacionPresupuestoListDto presupuestos = tareaLocalizacionPresupuestoService.findPresupuestos(tarea);
        return presupuestos.getMinFechaInicioPeriodo().format(DateTimeFormatter.ofPattern(PtrConstants.DATE_FORMAT));
    }
}
