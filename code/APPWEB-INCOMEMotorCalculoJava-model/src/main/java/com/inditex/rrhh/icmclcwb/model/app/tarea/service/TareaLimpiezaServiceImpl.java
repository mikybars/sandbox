package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import com.inditex.amigafwk.service.aaa.userdetails.heimdal.HeimdalUser;
import com.inditex.amigafwk.service.aaa.userdetails.heimdal.HeimdalUtils;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoLimpiezaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoLimpiezaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLimpiezaService;
import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLimpiezaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.OptionalUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLimpieza;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLimpiezaRepository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaLimpiezaServiceImpl implements TareaLimpiezaService {

  @Autowired
  private TareaLimpiezaRepository tareaLimpiezaRepository;

  @Autowired
  private TareaLimpiezaMapper tareaLimpiezaMapper;

  @Override
  // TODO: Revisar si es login o username
  public TareaLimpiezaDto save(final TareaLimpiezaDto tareaLimpieza) {
    if (StringUtils.isBlank(tareaLimpieza.getNombreUsuario())) {
      final HeimdalUser heimdalUser = HeimdalUtils.getHeimdalUser();
      if (StringUtils.isNotBlank(heimdalUser.getLogin())) {
        tareaLimpieza.setNombreUsuario(heimdalUser.getLogin());
      }
    }
    tareaLimpieza.setEstado(EstadoLimpiezaEnum.PENDIENTE.getDto());
    tareaLimpieza.setFechaHoraCreacion(TimeUtils.nowLocalDateTime());
    // TODO [javierev] cuando se implemente la limpieza parcial esta línea se debe retirar
    tareaLimpieza.setTipo(TipoLimpiezaEnum.COMPLETA.getDto());
    final TareaLimpieza result = this.tareaLimpiezaRepository
        .save(this.tareaLimpiezaMapper.tareaLimpiezaDtoToTareaLimpieza(tareaLimpieza));
    return this.tareaLimpiezaMapper.tareaLimpiezaToTareaLimpiezaDto(result);

  }

  @Override
  public List<TareaLimpiezaDto> save(
      final List<IdTareaDTO> idTareas) {
    final List<TareaLimpiezaDto> result = new ArrayList<>();
    this.tareaLimpiezaMapper.idTareaDtoToTareaLimpiezaDto(idTareas).forEach(item -> result.add(this.save(item)));
    return result;
  }

  @Override
  public TareaLimpiezaDto find(final Long id) {
    return this.tareaLimpiezaMapper
        .tareaLimpiezaToTareaLimpiezaDto(OptionalUtils.get(this.tareaLimpiezaRepository.findById(id)));
  }

}
