package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionOnlineHistorico;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

public interface TareaLocalizacionOnlineHistoricoRepositoryCustom {

    List<TareaLocalizacionOnlineHistorico> save(List<TareaLocalizacionOnlineHistorico> tiendas);

    List<IdLocalizacionLocalDto> findIdLocalizacionDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(
            @NotNull @Positive Long idTarea, @NotBlank String idOrigen, @NotNull List<Long> idsTipoDato);

}
