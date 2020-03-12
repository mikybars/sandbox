package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrPresenciaPresupuestosService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class RunTareaAmbitoRecolectarPtrPresenciaPresupuestosServiceImpl
    extends AbstractRunTareaAmbitoRecolectarPtrPresenciaService
    implements RunTareaAmbitoRecolectarPtrPresenciaPresupuestosService {

    @Autowired
    private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

    @Override
    protected String getFechaInicioPeriodo(TareaDto tarea) {
        LocalDate minDate = tarea.getFechaInicioPeriodo();
        List<TareaLocalizacionPresupuestoDto> presupuestos = tareaLocalizacionPresupuestoService.findPresupuestos(tarea);
        if (CollectionUtils.isNotEmpty(presupuestos)) {
            Optional<TareaLocalizacionPresupuestoDto> optional = presupuestos.stream().min(Comparator.comparing(presupuesto -> presupuesto.getFechaInicio()));
            if (optional.isPresent()) {
                minDate = minDate.isBefore(optional.get().getFechaInicio()) ? minDate : optional.get().getFechaInicio();
            }
        }
        return minDate.format(DateTimeFormatter.ofPattern(PtrConstants.DATE_FORMAT));
    }
}
