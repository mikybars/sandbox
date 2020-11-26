package com.inditex.rrhh.icmclcwb.model.app.run.tarea.prevalidar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaPrevalidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.prevalidar.service.RunTareaPreValidarPresenciasService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoValidacionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPrevalidacionValidacionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaPreValidarPresenciasServiceImpl implements RunTareaPreValidarPresenciasService {

    @Autowired
    private Meta4IcmWsCalcIncomeSessionAsyncService meta4IcmWsCalcIncomeSessionAsyncService;

    @Autowired
    private TareaPrevalidacionValidacionService tareaPrevalidacionValidacionService;

    @Override
    public void run(@NotNull @Valid final RunTareaPrevalidarDto runTareaPrevalidarDto) {
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TareaPrevalidacionValidacionDto validacion = this.tareaPrevalidacionValidacionService
                .findByIdTareaAndIdTareaPrevalidacionAndTipoValidacion(runTareaPrevalidarDto.getTarea().getId(),
                        runTareaPrevalidarDto.getTareaPrevalidacionDto().getId(),
                        TipoValidacionEnum.PRESENCIAS.getId());
            if (validacion != null) {
                final CompletableFuture<Integer> cfValidPresencias = this.meta4IcmWsCalcIncomeSessionAsyncService
                    .validacionPresencias();
                AsyncUtils.exceptionally(cfValidPresencias, cf);
                this.tareaPrevalidacionValidacionService.update(validacion, runTareaPrevalidarDto.getTarea(),
                        AsyncUtils.get(cfValidPresencias));
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
