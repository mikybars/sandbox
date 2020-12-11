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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.prevalidar.service.RunTareaPreValidarConfService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoValidacionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPrevalidacionValidacionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.prevalidon.dto.PreValidOnRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.prevalidon.dto.PreValidOnResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaPreValidarConfServiceImpl implements RunTareaPreValidarConfService {

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
                final PreValidOnRequestDto request = new PreValidOnRequestDto();
                final CompletableFuture<List<PreValidOnResultItemDto>> cfValidPresencias = this.meta4IcmWsCalcIncomeSessionAsyncService
                    .getPrevalidOn(request);
                final List<PreValidOnResultItemDto> result = AsyncUtils.get(cfValidPresencias);
                AsyncUtils.exceptionally(cfValidPresencias, cf);
                // TODO: Esto hay que cambiarlo con el maestro
                this.tareaPrevalidacionValidacionService.update(validacion, runTareaPrevalidarDto.getTarea(),
                        Integer.valueOf(result.get(0).getIdEstado()));
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
