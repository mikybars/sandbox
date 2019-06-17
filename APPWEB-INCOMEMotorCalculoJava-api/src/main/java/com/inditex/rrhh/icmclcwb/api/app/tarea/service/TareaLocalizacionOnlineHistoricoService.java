package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.LocalizacionOnlineDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface TareaLocalizacionOnlineHistoricoService {

    List<LocalizacionOnlineDto> save(final List<TiendaOnlineResultItemDto> src, final TareaDto tarea);

    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(@NotNull final Long idTarea,
        @NotBlank String idOrigen, @NotNull final List<Long> idsTipoDato);
}
