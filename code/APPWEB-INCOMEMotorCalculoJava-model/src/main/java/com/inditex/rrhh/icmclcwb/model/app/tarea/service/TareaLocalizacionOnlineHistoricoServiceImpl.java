package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionOnlineHistoricoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.LocalizacionOnlineDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionOnlineHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionOnlineHistorico;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionOnlineHistoricoRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class TareaLocalizacionOnlineHistoricoServiceImpl implements TareaLocalizacionOnlineHistoricoService {

  @Autowired
  private TareaLocalizacionOnlineHistoricoMapper tareaLocalizacionOnlineHistoricoMapper;

  @Autowired
  private TareaLocalizacionOnlineHistoricoRepositoryCustom tareaLocalizacionOnlineHistoricoRepositoryCustom;

  @Override
  public List<LocalizacionOnlineDto> save(@Valid @NotNull @NotEmpty final List<TiendaOnlineResultItemDto> src,
      @Valid @NotNull final TareaDto tarea) {
    List<TareaLocalizacionOnlineHistorico> tiendas = tareaLocalizacionOnlineHistoricoMapper
        .getTiendaOnlineResultItemDtoToTareaTiendaOnlineHistorico(src, tarea);
    return tareaLocalizacionOnlineHistoricoMapper.getTareaTiendaOnlineHistoricoToLocalizacionOnlineDto(
        tareaLocalizacionOnlineHistoricoRepositoryCustom.save(tiendas));
  }

}
