/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.MotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.Meta4Service;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.meta4.repository.Meta4RepositoryCustom;

@Service
@Validated
public class Meta4ServiceImpl implements Meta4Service {

    @Autowired
    private Meta4RepositoryCustom meta4RepositoryCustom;

    @Override
    public List<MotivoDesplazamientoDto> findMotivosDesplazamientoAux(final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        return this.meta4RepositoryCustom
            .findMotivosDesplazamientoAux(runTareaDto.getTarea());
    }

    @Override
    public List<MotivoDesplazamientoDto> findMotivosDesplazamientoGlobal(final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        return this.meta4RepositoryCustom
            .findMotivosDesplazamientoGlobal(runTareaDto.getTarea());
    }

}
