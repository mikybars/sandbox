package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionFestivoService;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionFestivoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionFestivoRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaLocalizacionFestivoServiceImpl implements TareaLocalizacionFestivoService {

  @Autowired
  private TareaLocalizacionFestivoRepositoryCustom tareaLocalizacionFestivoRepositoryCustom;

  @Autowired
  private TareaLocalizacionFestivoMapper tareaLocalizacionFestivoMapper;

  @Override
  public void save(
      @Valid @NotNull @NotEmpty final List<HorarioComercialFestivoDocDto> src,
      @Valid @NotNull final TareaDto tareaDto) {
    this.tareaLocalizacionFestivoRepositoryCustom.save(
        this.tareaLocalizacionFestivoMapper.horarioComercialFestivoDocDtoToTareaLocalizacionFestivo(src,
            tareaDto));
  }

}
