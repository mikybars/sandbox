package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionOnlineHistoricoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.LocalizacionOnlineDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionOnlineHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionOnlineHistorico;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionOnlineHistoricoRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@Service
public class TareaLocalizacionOnlineHistoricoServiceImpl implements TareaLocalizacionOnlineHistoricoService {

    @Autowired
    private TareaLocalizacionOnlineHistoricoMapper tareaLocalizacionOnlineHistoricoMapper;

    @Autowired
    private TareaLocalizacionOnlineHistoricoRepositoryCustom tareaLocalizacionOnlineHistoricoRepositoryCustom;

    @Override
    public List<LocalizacionOnlineDto> save(List<TiendaOnlineResultItemDto> src, TareaDto tarea) {
        List<TareaLocalizacionOnlineHistorico> tiendas = tareaLocalizacionOnlineHistoricoMapper
            .getTiendaOnlineResultItemDtoToTareaTiendaOnlineHistorico(src, tarea);
        return tareaLocalizacionOnlineHistoricoMapper
            .getTareaTiendaOnlineHistoricoToLocalizacionOnlineDto(
                tareaLocalizacionOnlineHistoricoRepositoryCustom.save(tiendas));
    }

    @Override
    public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(@NotNull final Long idTarea,
        @NotBlank String idOrigen, @NotNull final List<Long> idsTipoDato) {
        return tareaLocalizacionOnlineHistoricoRepositoryCustom.findIdLocalizacionDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(idTarea, idOrigen, idsTipoDato);
    }
}
