package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTipoHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTipoHoraService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTipoHoraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTipoHoraRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTipoHoraRepositoryCustom;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaTipoHoraServiceImpl implements TareaTipoHoraService {

  @Autowired
  private TareaTipoHoraMapper mapper;

  @Autowired
  private TareaTipoHoraRepositoryCustom tareaTipoHoraRepositoryCustom;

  @Autowired
  private TareaTipoHoraRepository tareaTipoHoraRepository;

  @Override
  public List<TareaTipoHoraDto> save(
      @Valid @NonNull final TiposHoraResponseDto dto,
      @Valid @NonNull final TareaDto tarea) {
    return this.mapper.tareaTipoHoraListTotareaTipoHoraDtoList(this.tareaTipoHoraRepositoryCustom.save(
        this.mapper.tiposHorasResponseDtoToTareaTipoHora(dto, tarea)));
  }

  @Override
  public List<TareaTipoHoraDto> findByIdTareaAndExcluidoDenominadorYRepartidoProvincia(
      @Valid @NonNull final TareaDto tarea) {
    return this.mapper.tareaTipoHoraListTotareaTipoHoraDtoList(
        this.tareaTipoHoraRepository.findByIdTareaAndExcluidoDenominadorYRepartidoProvincia(tarea.getId(),
            true));
  }

}
