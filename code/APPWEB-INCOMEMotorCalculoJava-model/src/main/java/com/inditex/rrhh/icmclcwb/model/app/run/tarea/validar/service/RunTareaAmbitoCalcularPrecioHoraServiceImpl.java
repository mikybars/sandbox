package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoCalcularPrecioHoraService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaCalculoPersonaPrecioHoraServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaAmbitoCalcularPrecioHoraServiceImpl implements RunTareaAmbitoCalcularPrecioHoraService {

    private static final Logger LOG = LoggerFactory.getLogger(RunTareaAmbitoCalcularPrecioHoraServiceImpl.class);

    private final TareaCalculoPersonaPrecioHoraServiceImpl tareaCalculoPersonaPrecioHoraService;

    private final TareaFaseAccionServiceImpl tareaFaseAccionService;

    private final ValidacionMapper validacionMapper;

    @Override
    public ValidacionDto execute(@Valid final RunTareaDto runTarea,
        @Valid final TareaAmbitoDto tareaAmbito,
        @Valid final TareaFaseAccionDto tareaFaseAccion) {

        final List<CompletableFuture<?>> cf = new ArrayList<>();

        final List<IdPersonaLocalDto> ids =
            this.tareaCalculoPersonaPrecioHoraService.getIdsPersonasCalculoPrecioHoraByTareaAndAmbito(runTarea, tareaAmbito);

        for (final List<IdPersonaLocalDto> personas : StreamUtils.partition(ids, 1000)) {
            AsyncUtils.checkAsyncAvaliable(cf, 10);
            LOG.info("Trabajo[{}]Tarea[{}] :: Inicio :: Cálculo precio hora :: Personas: {}",
                runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
            try {
                final CompletableFuture<Void> cfCalc = this.tareaCalculoPersonaPrecioHoraService
                    .calcularPrecioHora(runTarea, tareaAmbito, personas);
                AsyncUtils.exceptionally(cfCalc, cf);
            } catch (final Exception e) {
                this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion, EstadoTareaFaseAccionEnum.ERROR.getDto());
                AsyncUtils.cancel(cf);
                LOG.error(
                    "Trabajo[{}]Tarea[{}] :: Cálculo precio hora :: KO :: Personas: {}",
                    runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size(), e);
                throw e;
            }
            LOG.info(
                "Trabajo[{}]Tarea[{}] :: Fin :: Cálculo precio hora :: Personas: {}",
                runTarea.getTrabajo().getId(), runTarea.getTarea().getId(), personas.size());
        }

        AsyncUtils.waitAllOfIsOk(cf, cf);

        return this.validacionMapper.booleanToValidacionDto(tareaAmbito, tareaFaseAccion, Boolean.TRUE);
    }

}
