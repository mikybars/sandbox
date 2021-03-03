/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.PtrService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.ptr.repository.PtrRepositoryCustom;

@Service
@Validated
public class PtrServiceImpl implements PtrService {

    @Autowired
    private PtrRepositoryCustom ptrRepositoryCustom;

    @Override
    public PresenciaOrigenDto findPresenciasOrigenAndFecha(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        return this.ptrRepositoryCustom
            .findPresenciasOrigenAndFecha(runTareaDto.getTarea(), tareaAmbito);
    }

}
