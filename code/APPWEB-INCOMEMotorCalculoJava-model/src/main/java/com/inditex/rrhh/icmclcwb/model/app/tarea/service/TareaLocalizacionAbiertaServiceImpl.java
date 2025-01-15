package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionAbiertaService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionAbiertaRepositoryCustom;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaLocalizacionAbiertaServiceImpl implements TareaLocalizacionAbiertaService {

  @Autowired
  private TareaLocalizacionAbiertaRepositoryCustom tareaLocalizacionAbiertaRepositoryCustom;

  @Autowired
  private TipoDatoService tipoDatoService;

  @Override
  public void saveAbierto(@Valid @NotNull final TareaDto tareaDto, @Valid @NotNull final TrabajoDTO trabajoDto) {
    this.tareaLocalizacionAbiertaRepositoryCustom.saveAbierto(tareaDto, trabajoDto);
  }

  @Override
  public void saveCerrado(@Valid @NotNull final TareaDto tareaDto, @Valid @NotNull final TrabajoDTO trabajoDto) {
    final List<IdTipoDatoDto> ids = this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_LOCALIZACION.getId());
    this.tareaLocalizacionAbiertaRepositoryCustom.saveCerrado(tareaDto, trabajoDto,
        ids.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
  }

}
